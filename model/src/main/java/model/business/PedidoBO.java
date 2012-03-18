package model.business;
import java.sql.Connection;
import java.sql.SQLException;

import model.db.PedidoDAO;
import model.db.util.PoolConexiones;
import model.entity.Pedido;
import model.exceptions.PedidoException;

/**
 * <b>Descripci&oacute;n</b>: clase que contiene las normas de negocio asociadas al 
 * mantenimiento de las entidades del sistema que modelan los pedidos 
 * realizados por los usuarios registrados.
 * @author Jorge Agudo Praena
 * @version 1.1
 */
public class PedidoBO 
{

  private PoolConexiones pool;
  
  public PedidoBO()
  {
    pool = model.db.util.PoolConexiones.getInstance();
  }
  
  public void registrarPedido(Pedido p) throws PedidoException
  {
    
    //primero habria que validar el pedido
    
    Connection con = null;
    
    try
    {
      con = pool.getConnection();
      
      PedidoDAO pedidoDAO = new PedidoDAO(con);
      pedidoDAO.creaPedido(p);
      
      con.commit();
    }
    catch(Exception e)
    {
      try
      {
        if(con!=null)
        {
          con.rollback();
          throw new PedidoException(e.getMessage());
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
  
}