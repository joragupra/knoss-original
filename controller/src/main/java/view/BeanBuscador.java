package view;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class BeanBuscador extends ActionForm
{

  private String criterio;
  
  private String termino;
  
  public BeanBuscador()
  {
  }

  public void setCriterio(String criterio)
  {
    this.criterio = criterio;
  }

  public String getCriterio()
  {
    return criterio;
  }

  public void setTermino(String termino)
  {
    this.termino = termino;
  }

  public String getTermino()
  {
    return termino;
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
    if(getCriterio()==null || getCriterio().trim().compareTo("")==0)
    {
      errors.add("busqueda", new ActionError("search.error.empty.criteria"));
    }
    if(getTermino()==null || getTermino().trim().compareTo("")==0)
    {
      errors.add("busqueda", new ActionError("search.error.empty.term"));
    }*/
    
    return errors;
  }
}