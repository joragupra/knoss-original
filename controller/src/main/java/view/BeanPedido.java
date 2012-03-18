package view;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BeanPedido extends ActionForm 
{

  private String formaPago;
  
  private int numTarjeta;
  
  private String direccion;
  
  private String poblacion;
  
  private String provincia;
  
  private String cp;
  
  private String pais;
  
  private String masInfo;
  
  public BeanPedido()
  {
  }
  
  public void setFormaPago(String formaPago)
  {
    this.formaPago = formaPago;
  }

  public String getFormaPago()
  {
    return formaPago;
  }

  public void setNumTarjeta(int numTarjeta)
  {
    this.numTarjeta = numTarjeta;
  }

  public int getNumTarjeta()
  {
    return numTarjeta;
  }

  public void setDireccion(String direccion)
  {
    this.direccion = direccion;
  }

  public String getDireccion()
  {
    return direccion;
  }

  public void setPoblacion(String poblacion)
  {
    this.poblacion = poblacion;
  }

  public String getPoblacion()
  {
    return poblacion;
  }

  public void setProvincia(String provincia)
  {
    this.provincia = provincia;
  }

  public String getProvincia()
  {
    return provincia;
  }

  public void setCp(String cp)
  {
    this.cp = cp;
  }

  public String getCp()
  {
    return cp;
  }

  public void setPais(String pais)
  {
    this.pais = pais;
  }

  public String getPais()
  {
    return pais;
  }

  public void setMasInfo(String masInfo)
  {
    this.masInfo = masInfo;
  }

  public String getMasInfo()
  {
    return masInfo;
  }
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }
  
  public ActionErrors validate(ActionMapping mapping, 
                               HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    
    if(getFormaPago()==null || getFormaPago().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.order.error.username"));
    }
    if(getFormaPago()!=null && getFormaPago().trim().compareTo("")!=0
       && (""+getNumTarjeta()).trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.order.error.creditcard"));
    }
    if(getDireccion()==null || getDireccion().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.order.error.address"));
    }
    if(getPoblacion()==null || getPoblacion().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.order.error.city"));
    }
    if(getProvincia()==null || getProvincia().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.order.error.state"));
    }
    if(getCp()==null || getCp().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.order.error.zipcode"));
    }
    if(getPais()==null || getPais().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.order.error.country"));
    }
    
    return errors;
  }

}