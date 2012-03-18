package model.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * <b>Descripci&oacute;n</b>: modela un pedido de libros realizado por un 
 * usuario registrado en el sistema.
 * @author Jorge Agudo Praena
 * @version 1.0
 */
public class Pedido 
{

  private int idPedido;

  private Usuario usuario;
  
  private List lineasPedido;
  
  private String formaPago;
  
  private long numTarjeta;
  
  private long fecha;
  
  private String estado;
  
  private String direccion;
  
  private String poblacion;
  
  private String provincia;
  
  private String cp;
  
  private String pais;
  
  private String masInfo;
  
  public Pedido()
  {
  }

  public void setUsuario(Usuario usuario)
  {
    this.usuario = usuario;
  }

  public Usuario getUsuario()
  {
    return usuario;
  }

  public void setLineasPedido(List lineasPedido)
  {
    this.lineasPedido = lineasPedido;
  }

  public List getLineasPedido()
  {
    return lineasPedido;
  }

  public void setFormaPago(String formaPago)
  {
    this.formaPago = formaPago;
  }

  public String getFormaPago()
  {
    return formaPago;
  }

  public void setNumTarjeta(long numTarjeta)
  {
    this.numTarjeta = numTarjeta;
  }

  public long getNumTarjeta()
  {
    return numTarjeta;
  }

  public void setEstado(String estado)
  {
    this.estado = estado;
  }

  public String getEstado()
  {
    return estado;
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

  public void setFecha(long fecha)
  {
    this.fecha = fecha;
  }

  public long getFecha()
  {
    return fecha;
  }

  public void setIdPedido(int idPedido)
  {
    this.idPedido = idPedido;
  }

  public int getIdPedido()
  {
    return idPedido;
  }
  
  public String getStringFecha()
  {
    Date d = new Date(getFecha());
    
    return d.toString();
  }
  
  public List getLibros()
  {
    List result = new ArrayList();
    Iterator it = lineasPedido.iterator();
    while(it.hasNext())
    {
      LineaPedido lp = (LineaPedido) it.next();
      Libro l = lp.getProducto();
      result.add(l);
    }
    
    return result;
  }
  
}