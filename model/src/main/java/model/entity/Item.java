package model.entity;

/**
 * <b>Descripci&oacute;n</b>: modela un art&iacute;culo a&ntilde;adido por un 
 * usuario registrado a su carrito de la compra.
 * @author Jorge Agudo Praena
 * @version 1.0
 */
public class Item 
{

  private Libro producto;
  
  private int cantidad;
  
  public Item()
  {
  }
  
  public Item(Libro l, int cantidad)
  {
    this.producto = l;
    this.cantidad = cantidad;
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
  
  public void incrementaCantidad()
  {
    cantidad++;
  }
  
  public void decrementaCantidad()
  {
    if(cantidad>0)
    {
      cantidad--;
    }
  }
  
}