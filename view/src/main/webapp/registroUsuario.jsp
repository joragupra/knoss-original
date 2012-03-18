<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

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
  <html:form action="registrarUsuario.do" 
             focus="username">
    <P>
      <bean:message key="register.user.username" />
      <html:text property="username" 
                 altKey="register.user.username" 
                 size="15"/>
      <bean:message key="register.user.password" />
      <html:password property="password" 
                     altKey="register.user.password"
                     size="15"/>
    </P>
    <P>
      <bean:message key="register.user.name" />
      <html:text property="nombre" 
                 altKey="register.user.name"
                 size="30"/>
      <bean:message key="register.user.surname" />
      <html:text property="apellidos" 
                 altKey="register.user.surname" 
                 size="30"/>
    </P>
    <P>
      <h4><bean:message key="register.user.contact" />:</h4>
      <br />
      <bean:message key="register.user.address" />
      <html:text property="direccion" 
                 altKey="register.user.address"
                 size="50"/>
      <br />
      <bean:message key="register.user.city" />
      <html:text property="poblacion" 
                 altKey="register.user.city"
                 size="20"/>
      <bean:message key="register.user.state" />
      <html:text property="provincia" 
                 altKey="register.user.state"
                 size="20"/>
      <br />
      <bean:message key="register.user.zipcode" />
      <html:text property="cp" 
                 altKey="register.user.zipcode"
                 size="20"/>
      <bean:message key="register.user.country" />
      <html:text property="pais"
                 altKey="register.user.country"
                 size="20"/>
      <br />
      <bean:message key="register.user.phone" />
      <html:text property="telefono" 
                 altKey="register.user.phone"
                 size="20"/>
      <bean:message key="register.user.email" />
      <html:text property="email" 
                 altKey="register.user.email"
                 size="20"/>
    </P>
    <P>
    <html:submit alt="Registrar usuario" 
                 value="Registrar"/>
    </P>
    <p>
      <bean:message key="register.user.request" />
      <a href="home.do">
        <bean:message key="register.user.cancel" />
      </a>
    </p>
  </html:form>
  <!-- Register process errors -->
  <html:errors property="registro" />
  </div>
  <!-- User's image -->
  <div id="image">
    <img src="images/usuarios.png"
         alt="Logotipo usuarios"
         longdesc="Logotipo de registro de usuarios" />
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