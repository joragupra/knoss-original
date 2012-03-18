package view;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BeanUsuario extends ActionForm 
{

  private String username;
  
  private String password;
  
  private String nombre;
  
  private String apellidos;
  
  private String direccion;
  
  private String poblacion;
  
  private String provincia;
  
  private String cp;
  
  private String pais;
  
  private String telefono;
  
  private String email;
  
  public BeanUsuario()
  {
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getUsername()
  {
    return username;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getPassword()
  {
    return password;
  }

  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }

  public String getNombre()
  {
    return nombre;
  }

  public void setApellidos(String apellidos)
  {
    this.apellidos = apellidos;
  }

  public String getApellidos()
  {
    return apellidos;
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

  public void setTelefono(String telefono)
  {
    this.telefono = telefono;
  }

  public String getTelefono()
  {
    return telefono;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getEmail()
  {
    return email;
  }
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }
  
  public ActionErrors validate(ActionMapping mapping, 
                               HttpServletRequest request)
  {
    ActionErrors errors = new ActionErrors();
    
    if(getUsername()==null || getUsername().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.username"));
    }
    if(getPassword()==null || getPassword().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.password"));
    }
    if(getNombre()==null || getNombre().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.name"));
    }
    if(getApellidos()==null || getApellidos().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.surname"));
    }
    if(getDireccion()==null || getDireccion().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.address"));
    }
    if(getPoblacion()==null || getPoblacion().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.city"));
    }
    if(getProvincia()==null || getProvincia().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.state"));
    }
    if(getCp()==null || getCp().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.zipcode"));
    }
    if(getPais()==null || getPais().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.country"));
    }
    if(getTelefono()==null || getTelefono().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.phone"));
    }
    if(getEmail()==null || getEmail().trim().compareTo("")==0)
    {
      errors.add("registro", new ActionMessage("register.user.error.email"));
    }
    
    GregorianCalendar gc = new GregorianCalendar();
    Date date = gc.getTime();
    String fecha = date.toString();
    long fechalong = gc.getTimeInMillis();
    System.out.println("---- Fecha como cadena " + fecha);
    System.out.println("---- Fecha como long " + date.getTime());
    System.out.println("Reconstruyendo fecha a partir del long...");
    date = new Date(fechalong);
    System.out.println(">>>> " + date.toString());
    
    return errors;
  }
  
}