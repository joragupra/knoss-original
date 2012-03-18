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

import model.db.UsuarioDAO;
import model.db.util.PoolConexiones;
import model.entity.CarritoCompra;
import model.entity.Usuario;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class ComprobarUsuarioAction extends Action 
{

  private PoolConexiones pool;
  
  public ComprobarUsuarioAction()
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
    String username = (String) request.getParameter("username");
    String password = (String) request.getParameter("password");
    
    
    ActionErrors errors = new ActionErrors();
    
    Connection con = null;
    String redireccion = "notlogged";
    
    try
    {
      con = pool.getConnection();
      UsuarioDAO usuarioDAO = new UsuarioDAO(con);
      Collection col = usuarioDAO.buscaPorClavePrimaria(username);
      
      Iterator it = col.iterator();
      
      if(it.hasNext())
      {
        Usuario u = (Usuario) it.next();
        
        if(password.equals(u.getPassword()))
        {
          redireccion = "logged";
          
          HttpSession session = request.getSession();
          session.setAttribute("usuario", u);
          CarritoCompra c = new CarritoCompra();
          session.setAttribute("carrito", c);
        }
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
      throw new RuntimeException("No se puede conseguir una conexion.");
    }
    catch (Throwable e)
    {
      e.printStackTrace();
      ActionMessage error = new ActionMessage(e.getMessage());
      errors.add(ActionMessages.GLOBAL_MESSAGE, error);
    }
    finally
    {
      if(!errors.isEmpty())
      {
        saveErrors(request, errors);
      }
      
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