package model;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BeanLibros 
{

  private String categoria;
  
  private String autor;
  
  private String isbn;
  
  private Connection con;
  
  private List libros;
  
  private ResultSet res;
  
  public BeanLibros()
  {
    libros = new ArrayList();
    Context ctx = null;

    try
    {
      ctx = new InitialContext();
      instanciaFD(ctx, "jdbc/OracleMachadoPooledDS");
    }
    catch (SQLException e)
    {
      System.out.println("Error en el constructor al crear conexion con la base de datos.\n" +
                         e.getMessage());
    }
    catch (NamingException e)
    {
      System.out.println("Error al resolver el nombre JNDI de la base de datos.\n" +
                         e.getMessage());
    }
  }
  
  private void instanciaFD(Context ctx, String nombre) throws SQLException, NamingException{
    System.out.println("Buscando nombre logico: " + nombre);
    DataSource ds = (DataSource) ctx.lookup(nombre);
    System.out.println("Nombre logico: " + nombre + " encontrado");
    con = ds.getConnection();
  }
  
  public void setCategoria(String categoria) throws SQLException
  {
    this.categoria = categoria;
    buscaLibros();
  }
  
  public List getLibros()
  {
    return libros;
  }
  
  public boolean buscaLibros() throws SQLException
  {
    Statement sen = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                        ResultSet.CONCUR_UPDATABLE);
    
    boolean result = sen.execute("select * from JORAGUPRA_LIBROS l, JORAGUPRA_CATEGORIAS c WHERE l.id_categoria = c.id_categoria AND c.nombre = '" + categoria + "'");
    
    if(result)
    {
      res = sen.getResultSet();
      System.out.println("Hemos encontrado algo");
      
      int numRows = numRows(res);
      System.out.println("El numero de filas es " + numRows);
      
      
      for(int i=1;i<=numRows;i++)
      {
        res.absolute(i);
        String aux = res.getString("titulo");
        System.out.println("Titulo obtenido: " + aux);
        libros.add(aux);
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
  
  public List buscaPorAutor(String autor)
  {
    PreparedStatement ps = null;
    List result = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_LIBROS WHERE autor = ?";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setString(1, autor);
      res = ps.executeQuery();
      
      if(res.next())
      {
        BeanLibros bl = new BeanLibros();
        
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    
    return result;
  }
  
}