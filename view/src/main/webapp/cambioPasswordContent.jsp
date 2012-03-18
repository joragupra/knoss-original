<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%><%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

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
  </html:form>
  <html:errors />