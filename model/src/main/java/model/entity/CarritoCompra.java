package model.entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <b>Descripci&oacute;n</b>: modela el carrito de la compra que mantiene los 
 * art&iacute;culos seleccionados por un usuario registrado durante su 
 * visita al portal.
 * @author Jorge Agudo Praena
 * @version 1.0
 */
public class CarritoCompra 
{

  private List productos;
  
  public CarritoCompra()
  {
    productos = new ArrayList();
  }

  public void setProductos(List productos)
  {
    this.productos = productos;
  }

  public List getProductos()
  {
    return productos;
  }
  
  public void addProducto(Libro l)
  {
    Iterator it = productos.iterator();
    boolean found = false;
    Item aux = null;
    
    while(!found && it.hasNext())
    {
      aux = (Item) it.next();
      if(l.getIdLibro()==aux.getProducto().getIdLibro())
      {
        found = true;
      }
    }
    
    if(found)
    {
      aux.incrementaCantidad();
    }
    else
    {
      aux = new Item(l, 1);
      productos.add(aux);
    }
  }
  
  public float getTotalAPagar()
  {
    Iterator it = productos.iterator();
    float total = 0;
    
    while(it.hasNext())
    {
      Item aux = (Item) it.next();
      total += aux.getProducto().getPrecio()*aux.getCantidad();
    }
    
    return total;
  }
  
}