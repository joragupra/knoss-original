package model.entity;

/**
 * <b>Descripci&oacute;n</b>: modela un usuario registrado en el sistema que 
 * puede realizar pedidos.
 * @author Jorge Agudo Praena
 * @version 1.0
 */
public class Usuario
{

  private String username;
  
  private String password;
  
  private String nombre;
  
  private String apellidos;
  
  private String direccion;
  
  private String poblacion;
  
  private String provincia;
  
  private String pais;
  
  private String cp;
  
  private String email;
  
  private String telefono;
  
  public Usuario()
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

  public void setPais(String pais)
  {
    this.pais = pais;
  }

  public String getPais()
  {
    return pais;
  }

  public void setCp(String cp)
  {
    this.cp = cp;
  }

  public String getCp()
  {
    return cp;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getEmail()
  {
    return email;
  }
  
  public void setTelefono(String telefono)
  {
    this.telefono = telefono;
  }

  public String getTelefono()
  {
    return telefono;
  }
  
}