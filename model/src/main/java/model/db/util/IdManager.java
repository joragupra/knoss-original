package model.db.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.exceptions.NoSuchEntityException;

public class IdManager 
{

  private Connection con;
  
  public IdManager(Connection con)
  {
    this.con = con;
  }

  public int getSiguienteId(String tabla) throws SQLException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    int result = 0;
    
    String sql = "SELECT NEXT_ID FROM JORAGUPRA_TABLAS WHERE TABLA = ?";
    
    if(con.isClosed())
    {
      throw new IllegalStateException("error.unexpected");
    }
    
    ps = con.prepareStatement(sql);
    ps.setString(1, tabla);
    rs = ps.executeQuery();
    
    if(rs.next())
    {
      result = rs.getInt(1);
    }
    
    return result;
  }
  
  public void actualizaId(String tabla, int nextId) throws SQLException
  {
    PreparedStatement ps = null;
    
    String sql = "UPDATE JORAGUPRA_TABLAS SET next_id = ? WHERE tabla = ?";
    
    if(con.isClosed())
    {
      throw new IllegalStateException("error.unexpected");
    }
    
    ps = con.prepareStatement(sql);
    ps.setInt(1, nextId);
    ps.setString(2, tabla);
    
    if(ps.executeUpdate()!=1)
    {
      throw new NoSuchEntityException("error.removed.user");
    }
  }
  
}