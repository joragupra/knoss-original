package view;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.business.PedidoBO;
import model.db.util.IdManager;
import model.db.util.PoolConexiones;
import model.entity.CarritoCompra;
import model.entity.Item;
import model.entity.Libro;
import model.entity.LineaPedido;
import model.entity.Pedido;
import model.entity.Usuario;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class RealizarPedidoAction extends Action 
{

  private PoolConexiones pool;
  
  public RealizarPedidoAction()
  {
    pool = PoolConexiones.getInstance();
  }
  
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   * @return 
   * @throws java.io.IOException
   * @throws javax.servlet.ServletException
   */
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    ActionErrors errors = new ActionErrors();
    
    try
    {
      HttpSession s = request.getSession();
      Connection con = pool.getConnection();
      IdManager idm = new IdManager(con);
      
      Pedido p = new Pedido();
      int idPedido = idm.getSiguienteId("pedidos");
      p.setIdPedido(idPedido);
      idm.actualizaId("pedidos", ++idPedido);
      Usuario u = (Usuario) s.getAttribute("usuario");
      p.setUsuario(u);
      CarritoCompra c = (CarritoCompra) s.getAttribute("carrito");
      List lineasPedido = contruyeLineasPedido(c);
      p.setLineasPedido(lineasPedido);
      
      
      //TODO - comprobar esto
      p.setFormaPago((String) request.getParameter("formaPago"));
      p.setNumTarjeta(Integer.parseInt(request.getParameter("numTarjeta")));
      GregorianCalendar gc = new GregorianCalendar();
      p.setFecha(gc.getTimeInMillis());
      
      
      p.setEstado("pendiente");
      p.setDireccion((String) request.getParameter("direccion"));
      p.setPoblacion((String) request.getParameter("poblacion"));
      p.setProvincia((String) request.getParameter("provincia"));
      p.setCp((String) request.getParameter("cp"));
      p.setPais((String) request.getParameter("pais"));
      p.setMasInfo((String) request.getParameter("masInfo"));
      
      PedidoBO pedidoBO = new PedidoBO();
      pedidoBO.registrarPedido(p);
      
      c = new CarritoCompra();
      s.setAttribute("carrito", c);
      
      return mapping.findForward("success");
    }
    catch (Throwable e)
    {
      e.printStackTrace();
      ActionMessage error = new ActionMessage(e.getMessage());
      errors.add(ActionMessages.GLOBAL_MESSAGE, error);
    }
    saveErrors(request, errors);
    
    return new ActionForward(mapping.getInput());
  }
  
  private List contruyeLineasPedido(CarritoCompra c)
  {
    List result = new ArrayList();
    
    Iterator it = c.getProductos().iterator();
    while(it.hasNext())
    {
      Item aux = (Item) it.next();
      Libro l = aux.getProducto();
      int cantidad = aux.getCantidad();
      LineaPedido lp = new LineaPedido();
      lp.setProducto(l);
      lp.setCantidad(cantidad);
      result.add(0, lp);
    }
    
    return result;
  }
}