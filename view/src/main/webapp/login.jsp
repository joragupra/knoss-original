<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

  <div id="login_title">Usuarios</div>
  <logic:notPresent name="usuario">
    <html:form action="comprobarUsuario.do" focus="username">
      <html:img src="images/usuario.gif" 
                altKey="login.username" />
      <html:text property="username" 
                 altKey="login.username"
                 size="15" />
      <br/>
      <html:img src="images/password.gif" 
                altKey="login.password" />
      <html:password property="password" 
                     altKey="login.password"
                     size="15" />
      <br/>
      <html:submit value="Login" />
    </html:form>
    <bean:message key="login.question" />
    <br/>
    <a href="registroUsuario.jsp" >
      <html:img src="images/register.gif" 
                alt="Reg&iacute;strate" />
    </a>
  </logic:notPresent>
  <logic:present name="usuario">
    <h4><bean:write name="usuario" property="username" /></h4>
    <a href="confirmarAutenticacion.jsp">
      <html:img src="images/home.gif" 
                altKey="login.home" />
    </a>
    <br/>
    <a href="detallesCarrito.do"><bean:message key="login.shoppingcart" /></a>
    <br/>
    <a href="abandonarSistema.do"><bean:message key="login.logout" /></a>
  </logic:present>