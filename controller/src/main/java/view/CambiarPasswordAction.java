package view;
import javax.servlet.http.HttpSession;
import model.business.UsuarioBO;
import model.entity.Usuario;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;

public class CambiarPasswordAction extends Action 
{
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
    ActionErrors errors = new ActionErrors();
    
    String redireccion = "success";
    
    try
    {
      HttpSession s = request.getSession();
      String newPassword = (String) request.getParameter("pass1");

      Usuario u = (Usuario) s.getAttribute("usuario");
      u.setPassword(newPassword);
      
      UsuarioBO usuarioBO = new UsuarioBO();
      usuarioBO.actualizaUsuario(u);
      
      System.out.println("Contrasena cambiada");
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
    }
    
    return mapping.findForward(redireccion);
  }
  
}