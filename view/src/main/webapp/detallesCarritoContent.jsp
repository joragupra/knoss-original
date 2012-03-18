<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%><%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

  <h3><bean:message key="shoppingcart.details.title" /></h3>
  <p>
    <logic:present name="carrito">
      <logic:empty name="carrito" 
                   property="productos">
        <bean:message key="shoppingcart.details.empty" />
      </logic:empty>
      <logic:notEmpty name="carrito" 
                      property="productos">
        <bean:message key="shoppingcart.details.notempty" />:
        <ul>
        <logic:iterate name="carrito"
                       property="productos"
                       id="item">
          <bean:define id="libro" 
                       name="item" 
                       property="producto"/>
          <li>
            <bean:message key="shoppingcart.details.book" />:&nbsp;
            <bean:write name="libro" 
                        property="titulo" />&nbsp;
            <bean:message key="shoppingcart.details.price" />:&nbsp;
            <bean:write name="libro" 
                        property="precio" />
            <bean:message key="shoppingcart.details.number" />:&nbsp;
            <bean:write name="item" 
                        property="cantidad" />
          </li>
        </logic:iterate>
        </ul>
        <h6>
          <bean:message key="shoppingcart.details.amount" />:
          <bean:write name="carrito" property="totalAPagar" />
        </h6>
        <a href="registroPedido.jsp">
          <bean:message key="shoppingcart.details.order" />
        </a>
      </logic:notEmpty>
    </logic:present>
  </p>