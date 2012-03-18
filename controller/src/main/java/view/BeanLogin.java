package view;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class BeanLogin extends ActionForm
{

  private String username;
  
  private String password;
  
  public BeanLogin()
  {
  }

  public void setUsername(String criterio)
  {
    this.username = criterio;
  }

  public String getUsername()
  {
    return username;
  }

  public void setPassword(String termino)
  {
    this.password = termino;
  }

  public String getPassword()
  {
    return password;
  }
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }
  
  public ActionErrors validate(ActionMapping mapping, 
                               HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    /*
    if(getUsername()==null || getUsername().equals(""))
    {
      errors.add("login", new ActionError("login.username.error"));
    }
    if(getPassword()==null || getPassword().equals(""))
    {
      errors.add("login", new ActionError("login.password.error"));
    }
    */
    
    return errors;
  }
}