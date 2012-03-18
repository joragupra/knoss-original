package model.entity;

/**
 * <b>Descripci&oacute;n</b>: modela cada una de las l&iacute;neas de un 
 * pedido realizado por un usuario registrado en el sistema.
 * @author Jorge Agudo Praena
 * @version 1.0
 */
public class LineaPedido 
{

  private Libro producto;
  
  private int cantidad;
  
  public LineaPedido()
  {
  }

  public void setProducto(Libro producto)
  {
    this.producto = producto;
  }

  public Libro getProducto()
  {
    return producto;
  }

  public void setCantidad(int cantidad)
  {
    this.cantidad = cantidad;
  }

  public int getCantidad()
  {
    return cantidad;
  }
  
}