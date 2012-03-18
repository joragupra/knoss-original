<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%><%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

  <html:form action="realizarPedido.do">
    <p>
      <bean:message key="register.order.payment" />
      <html:select property="formaPago">
        <html:option value="contrarreembolso" 
                     key="register.order.payhome" />
        <html:option value="tarjeta" 
                     key="register.order.creditcard" />
      </html:select>
      <bean:message key="register.order.creditcard.number" />
      <html:text property="numTarjeta" 
                 size="16" />
    </p>
    <p>
      <bean:message key="register.order.address" />
      <html:text property="direccion" 
                 size="50" />
      <br/>
      <bean:message key="register.order.city" />
      <html:text property="poblacion" 
                 size="20" />
      <bean:message key="register.order.state" />
      <html:text property="provincia" 
                 size="20" />
      <br/>
      <bean:message key="register.order.zipcode" />
      <html:text property="cp" 
                 size="20" />
      <bean:message key="register.order.country" />
      <html:text property="pais" 
                 size="20" />
    </p>
    <p>
      <h4><bean:message key="register.order.more" /></h4>
      <html:textarea property="masInfo" cols="30" rows="5" />
    </p>
    <p>
      <html:submit value="Realizar pedido" />
    </p>
  </html:form>