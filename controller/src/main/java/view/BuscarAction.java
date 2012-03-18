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

public class BuscarAction extends Action 
{

  private PoolConexiones pool;
  
  public BuscarAction()
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
  public ActionForward execute(ActionMapping mapping, ActionForm form, 
                               HttpServletRequest request, 
                               HttpServletResponse response) 
                               throws IOException, ServletException
  {
    String criterio = (String) request.getParameter("criterio");
    String termino = (String) request.getParameter("termino");
    String redireccion = null;
    Connection con = null;
    
    //no se ha indicado el criterio de la busqueda o el
    //termino que se ha de busar
    if(criterio==null || termino == null || termino.equals(""))
    {
      redireccion = "noencontrado";
    }
    else
    {
      try
      {
        con = pool.getConnection();
        LibroDAO libroDAO = new LibroDAO(con);
        Collection col = null;
        
        if(criterio.equals("autor"))
        {
          col = libroDAO.buscaPorAutor(termino);
        }
        else if(criterio.equals("titulo"))
        {
          col = libroDAO.buscaPorTitulo(termino);
        }
        else if(criterio.equals("isbn"))
        {
          col = libroDAO.buscaPorIsbn(termino);
        }
        request.setAttribute(BeanNames.LIBROS_LIST, col);
        redireccion = "encontrado";
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
    }
    
    return mapping.findForward(redireccion);
  }
  
}