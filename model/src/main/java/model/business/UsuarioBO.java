package model.business;
import java.sql.Connection;
import java.sql.SQLException;
import model.exceptions.UsuarioException;
import model.db.UsuarioDAO;
import model.entity.Usuario;
import model.db.util.PoolConexiones;

/**
 * <b>Descripci&oacute;n</b>: clase que contiene las normas de negocio asociadas al 
 * mantenimiento de las entidades del sistema que modelan los usuarios 
 * registrados.
 * @author Jorge Agudo Praena
 * @version 1.1
 */
public class UsuarioBO 
{

  private PoolConexiones pool;
  
  public UsuarioBO()
  {
    pool = model.db.util.PoolConexiones.getInstance();
  }
  
  public void registrarUsuario(Usuario u) throws UsuarioException
  {
    validarUsuario(u);
    
    Connection con = null;
    
    try
    {
      con = pool.getConnection();
      
      UsuarioDAO usuarioDAO = new UsuarioDAO(con);
      usuarioDAO.creaUsuario(u);
      
      con.commit();
    }
    catch(Exception e)
    {
      System.out.println("Error al crear usuario");
      e.printStackTrace();
    
      try
      {
        if(con!=null)
        {
          con.rollback();
          throw new UsuarioException(e.getMessage());
        }
      }
      catch(SQLException sqle)
      {
        e.printStackTrace();
        sqle.printStackTrace();
        throw new UsuarioException("error.unexpected");
      }
    }
    finally
    {
      try
      {
        if(con!=null)
        {
          con.close();
        }
      }
      catch (SQLException sqle)
      {
        sqle.printStackTrace();
        throw new RuntimeException("error.unexpected");
      }
    }
  }
  
  public void actualizaUsuario(Usuario u) throws UsuarioException
  {
    
    validarUsuario(u);
    
    Connection con = null;
    
    try
    {
      con = pool.getConnection();
      
      UsuarioDAO usuarioDAO = new UsuarioDAO(con);
      usuarioDAO.actualizaUsuario(u);
      
      con.commit();
    }
    catch(Exception e)
    {
      try
      {
        if(con!=null)
        {
          con.rollback();
          throw new UsuarioException(e.getMessage());
        }
      }
      catch(SQLException sqle)
      {
        e.printStackTrace();
        throw new RuntimeException("error.unexpected");
      }
    }
    finally
    {
      try
      {
        if(con!=null)
        {
          con.close();
        }
      }
      catch(SQLException sqle)
      {
        sqle.printStackTrace();
        throw new RuntimeException("error.unexpected");
      }
    }
  }
  
  private void validarUsuario(Usuario u) throws UsuarioException
  {
    if(u.getUsername().trim().equals(""))
    {
      throw new UsuarioException("error.missing.username");
    }
    
    if(u.getPassword().trim().equals(""))
    {
      throw new UsuarioException("error.missing.password");
    }
    
    if(u.getEmail().trim().equals(""))
    {
      throw new UsuarioException("error.missing.email");
    }
  }
}