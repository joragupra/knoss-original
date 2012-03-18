package view;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.db.LibroDAO;
import model.db.util.PoolConexiones;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class BuscarPorCategoriaAction extends Action 
{

  private PoolConexiones pool;
  
  public BuscarPorCategoriaAction()
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
    String categoria = (String) request.getParameter("categoria");
    String redireccion = "categoriaEncontrada";
    Connection con = null;
    
    try
    {
      con = pool.getConnection();
      LibroDAO libroDAO = new LibroDAO(con);
      Collection col = libroDAO.buscaPorCategoria(categoria);
      request.setAttribute(BeanNames.LIBROS_LIST, col);
      redireccion = "categoriaEncontrada";
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
    
    return mapping.findForward(redireccion);
  }
}