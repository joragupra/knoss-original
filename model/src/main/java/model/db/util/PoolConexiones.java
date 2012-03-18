package model.db.util;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

public class PoolConexiones 
{

  private static PoolConexiones instance;
  
  private DataSource ds;
  
  private PoolConexiones()
  {
    Context ctx = null;
    
    try
    {
      ctx = new InitialContext();
      //para conectar desde casa
      instanciaFD(ctx, "jdbc/OracleMachadoPooledDS");
      //para conectar desde la calle Ardilla
      //instanciaFD(ctx, "jdbc/BDOracleEnMurilloPooledDS");
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
  
  public static PoolConexiones getInstance()
  {
    if(instance==null)
    {
      instance = new PoolConexiones();
    }
    
    return instance;
  }
  
  private void instanciaFD(Context ctx, String nombre) throws SQLException, NamingException{
    System.out.println("Buscando nombre l�gico: " + nombre);
    ds = (DataSource) ctx.lookup(nombre);
    System.out.println("Nombre logico: " + nombre + " encontrado");
  }
  
  public Connection getConnection() throws SQLException
  {
    return ds.getConnection();
  }
}