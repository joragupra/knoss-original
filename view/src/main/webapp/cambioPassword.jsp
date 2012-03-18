<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ page contentType="text/html;charset=windows-1252"%>

<html>
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
             border="0" 
             alt="CSS validado">
      </a>
    </div>
    <img src="images/logo2.jpg"
         alt="Logotipo corporativo"
         longdesc="Logotipo de BooksOnline.com"
         width="423"
         height="90" />
  </div>
  <div id="content">
    <h2><bean:message key="change.password.title" /></h2>
  <html:form action="cambiarPassword.do" 
             focus="pass1">
    <p>
      <bean:message key="change.password.pass1" />
      <html:password property="pass1" 
                     size="15"/>
    </p>
    <p>
      <bean:message key="change.password.pass2" />
      <html:password property="pass2" 
                     size="15"/>
    </p>
    <html:submit alt="Cambiar contraseña"
                 value="Cambiar contraseña" />
    <p>
      <bean:message key="change.password.request" />
      <a href="confirmarAutenticacion.do">
        <bean:message key="change.password.cancel" />
      </a>
    </p>
  </html:form>
  <html:errors />
  </div>
  <!-- Password's image -->
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