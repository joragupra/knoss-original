<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html lang="es">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title><bean:message key="application.title" /></title>
    <link rel=StyleSheet href="css/style.css" title="EstiloPagina">
  </head>
  <body>

<div id="main">
  <!-- Website header -->
  <div id="header">
    <div id="validator">
      <a href="http://jigsaw.w3.org/css-validator/">
        <img src="images/vcss.png" 
             width="88" 
             height="31" 
             alt="CSS validado">
      </a>
      <a href="http://validator.w3.org/check?uri=referer">
        <img src="http://www.w3.org/Icons/valid-html401"
             alt="Valid HTML 4.01!" 
             height="31" 
             width="88"/>
      </a>
      <a href="http://www.w3.org/WAI/WCAG1A-Conformance"
         title="Explanation of Level A Conformance">
        <img height="32" width="88" 
             src="http://www.w3.org/WAI/wcag1A"
             alt="Level A conformance icon, W3C-WAI Web Content Accessibility Guidelines 1.0">
      </a>
    </div>
    <img src="images/logo2.jpg"
         alt="Logotipo corporativo"
         longdesc="Logotipo de BooksOnline.com"
         width="423"
         height="90" />
  </div>
  <!-- Content begins here -->
  <div id="content">
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
    <p>
      <bean:message key="register.order.request" />
      <a href="consultarCarrito.do">
        <bean:message key="register.order.cancel" />
      </a>
    </p>
  </html:form>
  <!-- Register process errors -->
  <html:errors property="registro" />
  </div>
  <!-- Order's image -->
  <div id="image">
    <img src="images/pedidos.png"
         alt="Logotipo pedidos"
         longdesc="Logotipo de registro de pedidos" />
  </div>
  <!-- Website footer -->
  <div id="footer">
    <a href="quienessomos.jsp" accesskey="q">
      &iquest;Qui&eacute;nes somos?
    </a> | 
    <a href="gastoenvio.jsp" accesskey="g">
      Gastos de envío
    </a> | 
    <a href="politicadevolucion.jsp" accesskey="p">
      Políticas de devolución y anulación
    </a>
  </div>
</div>
    
  </body>
</html>