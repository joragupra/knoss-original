package model.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.entity.Usuario;
import model.exceptions.CreateException;
import model.exceptions.DuplicateKeyException;
import model.exceptions.FinderException;
import model.exceptions.NoSuchEntityException;
import model.exceptions.ObjectNotFoundException;

/**
 * <b>Descripci&oacute;n</b>: clase que controla los accesos a la base de datos 
 * que tengan relaci&oacute;n con los usuarios registrados en el sistema.
 * @author Jorge Agudo Praena
 * @version 1.1
 */
public class UsuarioDAO 
{

  private Connection con;

  public UsuarioDAO(Connection con)
  {
    this.con = con;
  }
  
  public Collection buscaPorClavePrimaria(String username) 
                                          throws FinderException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List result = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_USUARIOS u " + 
                      "WHERE u.username = ?";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setString(1, username);
      rs = ps.executeQuery();
      
      if(rs.next())
      {
        Usuario u = new Usuario();
        u.setUsername(rs.getString(1));
        u.setPassword(rs.getString(2));
        u.setNombre(rs.getString(3));
        u.setApellidos(rs.getString(4));
        u.setDireccion(rs.getString(5));
        u.setPoblacion(rs.getString(6));
        u.setProvincia(rs.getString(7));
        u.setCp(rs.getString(8));
        u.setPais(rs.getString(9));
        u.setEmail(rs.getString(10));
        u.setTelefono(rs.getString(11));
        
        result.add(u);
      }
      else
      {
        throw new ObjectNotFoundException("error.removed.user");
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    finally
    {
      try
      {
        if(ps!=null)
        {
          ps.close();
        }
        if(rs!=null)
        {
          rs.close();
        }
      }
      catch(SQLException e)
      {
        e.printStackTrace();
        throw new RuntimeException("error.unexpected");
      }
    }
    
    return result;
  }
  
  public void creaUsuario(Usuario u) throws CreateException
  {
    PreparedStatement ps = null;
    
    String sql = "INSERT INTO JORAGUPRA_USUARIOS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      
      ps.setString(1, u.getUsername());
      ps.setString(2, u.getPassword());
      ps.setString(3, u.getNombre());
      ps.setString(4, u.getApellidos());
      ps.setString(5, u.getDireccion());
      ps.setString(6, u.getPoblacion());
      ps.setString(7, u.getProvincia());
      ps.setString(8, u.getCp());
      ps.setString(9, u.getPais());
      ps.setString(10, u.getEmail());
      ps.setString(11, u.getTelefono());
      
      if(ps.executeUpdate()!=1)
      {
        throw new CreateException("error.create.user");
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      System.out.println("Error " + e.getMessage());
    
      try
      {
        buscaPorClavePrimaria(u.getUsername());
      }
      catch(FinderException fe)
      {
        fe.printStackTrace();
        throw new RuntimeException("error.unexpected");
      }
      
      throw new DuplicateKeyException("error.duplicate.user");
    }
    finally
    {
      try
      {
        if(ps!=null)
        {
          ps.close();
        }
      }
      catch(SQLException e)
      {
        e.printStackTrace();
        throw new RuntimeException("error.unexpected");
      }
    }
  }
  
  //TODO - terminar este metodo
  public void actualizaUsuario(Usuario u)
  {
    PreparedStatement ps = null;
    
    String sql = "UPDATE JORAGUPRA_USUARIOS " +
                 "SET password = ?, " +
                 "nombre = ?, apellidos = ?, " +
                 "direccion = ?, poblacion = ?," +
                 "provincia = ?, cp = ?," +
                 "pais = ?, email = ?, telefono = ? " +
                 "WHERE username = ?";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setString(1, u.getPassword());
      ps.setString(2, u.getNombre());
      ps.setString(3, u.getApellidos());
      ps.setString(4, u.getDireccion());
      ps.setString(5, u.getPoblacion());
      ps.setString(6, u.getProvincia());
      ps.setString(7, u.getCp());
      ps.setString(8, u.getPais());
      ps.setString(9, u.getEmail());
      ps.setString(10, u.getTelefono());
      ps.setString(11, u.getUsername());
      
      if(ps.executeUpdate()!=1)
      {
        throw new NoSuchEntityException("error.removed.user");
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    finally
    {
      try
      {
        if(ps!=null)
        {
          ps.close();
        }
      }
      catch (SQLException e)
      {
        e.printStackTrace();
        throw new RuntimeException("error.unexpected");
      }
    }
  }
  
}