package model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * <b>Descripci&oacute;n</b>: permite obtener las categor&iacute;as de libros que hay 
 * almacenadas en la base de datos del sistema.
 * @author Jorge Agudo Praena
 * @version 1.1
 */
public class BeanCategorias 
{

  //categorias de libros
  private List categorias;
  //conexcion con la base de datos del sistema
  private Connection con;
  //resultado de la busqueda de categorias en la base de datos del sistema
  private ResultSet res;

  /**
   * <b>Descripci&oacute;n</b>: constructor que accede a la base de datos del sistema 
   * y obtiene las categor&iacute;as de libros registradas en ella.
   */
  public BeanCategorias()
  {
    categorias = new ArrayList();
    Context ctx = null;

    try
    {
      ctx = new InitialContext();
      //para conectar desde casa
      instanciaFD(ctx, "jdbc/OracleMachadoPooledDS");
      //para conectar desde la calle Ardilla
      //instanciaFD(ctx, "jdbc/BDOracleEnMurilloPooledDS");
      buscaCategorias();
    }
    catch (SQLException e)
    {
      System.out.println("Error en el constructor al crear conexi&oacute;n con la base de datos.\n" +
                         e.getMessage());
    }
    catch (NamingException e)
    {
      System.out.println("Error al resolver el nombre JNDI de la base de datos.\n" +
                         e.getMessage());
    }
  }

  /**
   * <b>Descripci&oacute;n</b>: instancia la fuente de datos para la conexi&oacute;n con la 
   * base de datos.
   * @param ctx Contexto de la base de datos del sistema.
   * @param nombre Nombre JNDI que identifica a la base de datos del sistema.
   * @throws SQLException Se produjo un error al obtener la conexi&oacute;n con la 
   * base de datos.
   * @throws NamingException No se pudo resolver el nombre JNDI de la base de 
   * datos.
   */
  private void instanciaFD(Context ctx, String nombre) throws SQLException, NamingException{
    System.out.println("Buscando nombre logico: " + nombre);
    DataSource ds = (DataSource) ctx.lookup(nombre);
    System.out.println("Nombre logico: " + nombre + " encontrado");
    con = ds.getConnection();
  }

  /**
   * <b>Descripci&oacute;n</b>: busca en la base de datos del sistema las categor&iacute;as 
   * de libros.
   * @return Devuelve cierto si la b�squeda se llev� a cabo con &eacute;xito y false 
   * en caso contrario.
   * @throws SQLException Se produjo un error al ejecutar la sentencia SQL de 
   * b&uacute;squeda en la base de datos.
   */
  private boolean buscaCategorias() throws SQLException
  {
    Statement sen = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                        ResultSet.CONCUR_UPDATABLE);
    
    boolean result = sen.execute("select * from JORAGUPRA_CATEGORIAS order by NOMBRE");
    
    if(result)
    {
      res = sen.getResultSet();
      System.out.println("Hemos encontrado algo");
      
      int numRows = numRows(res);
      
      
      for(int i=1;i<=numRows;i++)
      {
        res.absolute(i);
        String aux = res.getString("nombre");
        System.out.println("Categoria obtenida: " + aux);
        categorias.add(aux);
      }
      con.close();
    }
    else
    {
      System.out.println("No hemos encontrado nada");
    }
    
    return result;
  }

  /**
   * <b>Descripci&oacute;n</b>: cuenta el n&uacute;mero de filas en un objeto 
   * <i>ResultSet</i>.
   * @param res <i>ResultSet</i> del que se quiere conocer el n&uacute;mero de filas 
   * que tiene.
   * @return N&uacute;mero de filas en el <i>ResultSet</i> indicado.
   */
  private int numRows(ResultSet res)
  {
    int num = 0;
    
    try
    {
      res.last();
      num = res.getRow();
      res.first();
      res.previous();
    }
    catch (SQLException e)
    {
      System.out.println("Error al consultar las filas obtenidas.\n" + e);
    }
    return num;
  }

  /**
   * <b>Descripci&oacute;n</b>: obtiene una lista con los nombres de las categor&iacute;as de 
   * libros que hay en la base de datos del sistema.
   * @return Lista de nombres de categor�as de libros de la base de datos.
   */
  public List getCategorias()
  {
    return categorias;
  }

  /**
   * <b>Descripci&oacute;n</b>: establece la lista de nombres de las categor&iacute;as de 
   * libros que hay en la base de datos del sistema.
   * @param categorias Lista de nombres de categor&iacute;as de libros de la base de 
   * datos.
   */
  public void setCategorias(List categorias)
  {
    this.categorias = categorias;
  }
}