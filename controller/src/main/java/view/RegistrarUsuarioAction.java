package view;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.business.UsuarioBO;
import model.entity.Usuario;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class RegistrarUsuarioAction extends Action 
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
  public ActionForward execute(ActionMapping mapping, ActionForm form, 
                               HttpServletRequest request, 
                               HttpServletResponse response) 
                               throws IOException, ServletException
  {
    ActionErrors errors = new ActionErrors();
    
    String redireccion = "noregistrado";
    
    try
    {
      Usuario u = new Usuario();
      u.setUsername((String) request.getParameter("username"));
      u.setPassword((String) request.getParameter("password"));
      u.setNombre((String) request.getParameter("nombre"));
      u.setApellidos((String) request.getParameter("apellidos"));
      u.setDireccion((String) request.getParameter("direccion"));
      u.setPoblacion((String) request.getParameter("poblacion"));
      u.setProvincia((String) request.getParameter("provincia"));
      u.setCp((String) request.getParameter("cp"));
      u.setPais((String) request.getParameter("pais"));
      u.setEmail((String) request.getParameter("email"));
      u.setTelefono((String) request.getParameter("telefono"));
      
      UsuarioBO usuarioBO = new UsuarioBO();
      //usuarioBO.registrarUsuario((Usuario) form);
      usuarioBO.registrarUsuario(u);
      
      //return mapping.findForward("registrado");
      redireccion = "registrado";
    }
    catch (Throwable e)
    {
      e.printStackTrace();
      ActionMessage error = new ActionMessage(e.getMessage());
      errors.add(ActionMessages.GLOBAL_MESSAGE, error);
    }
    finally{
      if(!errors.isEmpty()){
        saveErrors(request, errors);
      }
    }
    
    return mapping.findForward(redireccion);
  }
  
}