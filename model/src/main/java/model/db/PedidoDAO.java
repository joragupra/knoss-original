package model.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.entity.Libro;
import model.entity.LineaPedido;
import model.entity.Pedido;
import model.entity.Usuario;
import model.exceptions.CreateException;
import model.exceptions.DuplicateKeyException;

/**
 * <b>Descripci&oacute;n</b>: clase que controla los accesos a la base de datos 
 * que tengan relaci&oacute;n con los pedidos realizados por los usuarios 
 * registrados en el sistema.
 * @author Jorge Agudo Praena
 * @version 1.2
 */
public class PedidoDAO 
{

  private Connection con;
  
  public PedidoDAO(Connection con)
  {
    this.con = con;
  }
  
  public void creaPedido(Pedido p) throws CreateException
  {
    PreparedStatement ps = null;
    
    String sql = "INSERT INTO JORAGUPRA_PEDIDOS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      
      ps.setInt(1, p.getIdPedido());
      ps.setString(2, p.getUsuario().getUsername());
      ps.setString(3, p.getFormaPago());
      ps.setLong(4, p.getNumTarjeta());
      ps.setLong(5, p.getFecha());
      ps.setString(6, p.getEstado());
      ps.setString(7, p.getDireccion());
      ps.setString(8, p.getPoblacion());
      ps.setString(9, p.getProvincia());
      ps.setString(10, p.getCp());
      ps.setString(11, p.getPais());
      ps.setString(12, p.getMasInfo());
      
      if(ps.executeUpdate()!=1)
      {
        throw new CreateException("error.create.user");
      }
      
      //una vez creado el pedido, se pueden crear las lineas
      //de pedido asociadas en la BD
      Iterator it = p.getLineasPedido().iterator();
      int i = 1;
      while(it.hasNext())
      {
        LineaPedido lp = (LineaPedido) it.next();
        creaLineaPedido(lp, i, p.getIdPedido());
        i++;
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      System.out.println("Error " + e.getMessage());
    /*
      try
      {
        buscaPorClavePrimaria(u.getUsername());
      }
      catch(FinderException fe)
      {
        fe.printStackTrace();
        throw new RuntimeException("error.unexpected");
      }*/
      
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
  
  private void creaLineaPedido(LineaPedido lp, int numLinea, int idPedido)
                throws SQLException, CreateException
  {
    PreparedStatement ps = null;
    
    String sql = "INSERT INTO JORAGUPRA_LINEAS_PEDIDOS VALUES (?, ?, ?, ?)";
    
    if(con.isClosed())
    {
      throw new IllegalStateException("error.unexpected");
    }
    
    ps = con.prepareStatement(sql);
    
    ps.setInt(1, numLinea);
    ps.setInt(2, idPedido);
    ps.setInt(3, lp.getProducto().getIdLibro());
    ps.setInt(4, lp.getCantidad());
    
    if(ps.executeUpdate()!=1)
    {
      throw new CreateException("error.create.orderdetail");
    }
  }
  
  public Collection buscaPorUsuario(Usuario usuario)
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List result = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_PEDIDOS p, JORAGUPRA_USUARIOS u " + 
                      "WHERE p.username = u.username AND " +
                      "u.username = ?";

    try
    {
      if(con.isClosed())
      {
        throw new IllegalStateException("error.unexpected");
      }
      
      ps = con.prepareStatement(sql);
      ps.setString(1, usuario.getUsername());
      rs = ps.executeQuery();
      
      while(rs.next())
      {
        Pedido p = new Pedido();
        p.setIdPedido(rs.getInt(1));
        p.setUsuario(usuario);
        p.setFormaPago(rs.getString(3));
        p.setNumTarjeta(rs.getInt(4));
        p.setFecha(rs.getLong(5));
        p.setEstado(rs.getString(6));
        List lineasPedido = buscaLineasPedidos(p.getIdPedido());
        p.setLineasPedido(lineasPedido);
        p.setMasInfo(rs.getString(12));
        
        result.add(p);
      }
    }
    catch(SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("error.unexpected");
    }
    
    return result;
  }
  
  private List buscaLineasPedidos(int idPedido)
                throws SQLException
  {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List lineasPedido = new ArrayList();
    
    String sql = "SELECT * FROM JORAGUPRA_LINEAS_PEDIDOS lp, JORAGUPRA_PEDIDOS p " + 
                      "WHERE lp.id_pedido = p.id_pedido AND " +
                      "p.id_pedido = ?";
    
    if(con.isClosed())
    {
      throw new IllegalStateException("error.unexpected");
    }
    
    ps = con.prepareStatement(sql);
    ps.setInt(1, idPedido);
    
    rs = ps.executeQuery();
      
    while(rs.next())
    {
      LineaPedido lp = new LineaPedido();
      LibroDAO libroDAO = new LibroDAO(con);
      Libro l = null;
      Collection c = libroDAO.buscaPorClavePrimaria(rs.getInt(3));
      Iterator it = c.iterator();
      if(it.hasNext()){
        l = (Libro) it.next();
      }
      lp.setProducto(l);
      lp.setCantidad(rs.getInt(4));
      lineasPedido.add(lp);
    }
    
    return lineasPedido;
  }
  
}