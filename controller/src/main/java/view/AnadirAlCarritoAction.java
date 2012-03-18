package view;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.db.LibroDAO;
import model.db.util.PoolConexiones;
import model.entity.CarritoCompra;
import model.entity.Libro;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AnadirAlCarritoAction extends Action 
{

  private PoolConexiones pool;
  
  public AnadirAlCarritoAction()
  {
    pool = PoolConexiones.getInstance();
  }
  
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   * @return 
   * @throws java.io.IOException
   * @throws javax.servlet.ServletException
   */
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    int idLibro = Integer.parseInt(request.getParameter("idLibro"));
    Connection con = null;
    
    try
    {
      con = pool.getConnection();
      LibroDAO libroDAO = new LibroDAO(con);
      Collection col = libroDAO.buscaPorClavePrimaria(idLibro);
      Libro libro = null;
      Iterator it = col.iterator();
      if(it.hasNext())
      {
        libro = (Libro) it.next();
        HttpSession session = request.getSession();
        CarritoCompra carrito = (CarritoCompra) session.getAttribute("carrito");
        carrito.addProducto(libro);
      }
      
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("No se puede conseguir una conexion.");
    }
    finally
    {
      try
      {
        if(con != null)
        {
          con.close();          
        }
      }
      catch(SQLException e)
      {
        throw new RuntimeException(e.getMessage());
      }
    }
    
    return mapping.findForward("success");
  }
}