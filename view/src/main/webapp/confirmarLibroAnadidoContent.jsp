<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
  
  <h4>
    <bean:message key="shoppingcart.confirm" />
  </h4>
  <p>
    <bean:message key="shoppingcart.suggest" />
    <a href="consultarCarrito.do" >
      <bean:message key="shoppingcart.reviewbooks" />
    </a>
    <bean:message key="shoppingcart.option" />
    <a href="registroPedido.jsp">
      <bean:message key="shoppingcart.order" />
    </a>
  </p>