package view;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BeanPassword extends ActionForm
{

  private String pass1;
  
  private String pass2;
  
  public BeanPassword()
  {
  }

  public void setPass1(String pass1)
  {
    this.pass1 = pass1;
  }

  public String getPass1()
  {
    return pass1;
  }

  public void setPass2(String pass2)
  {
    this.pass2 = pass2;
  }

  public String getPass2()
  {
    return pass2;
  }
  
    public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }
  
  public ActionErrors validate(ActionMapping mapping, 
                               HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    
    if(getPass1()==null || getPass1().equals(""))
    {
      errors.add("password", new ActionMessage("change.password.error.pass1"));
    }
    if(getPass2()==null || getPass2().equals(""))
    {
      errors.add("password", new ActionMessage("change.password.error.pass2"));
    }
    if(!getPass1().equals(getPass2()))
    {
      errors.add("password", new ActionMessage("change.password.error.different"));
    }
    
    return errors;
  }
}