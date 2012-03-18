<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

  <html:form action="registrarUsuario.do" 
             focus="username">
    <P>
      <bean:message key="register.user.username" />
      <html:text property="username" 
                 size="15"/>
      <bean:message key="register.user.password" />
      <html:password property="password" 
                     size="15"/>
    </P>
    <P>
      <bean:message key="register.user.name" />
      <html:text property="nombre" 
                 size="30"/>
      <bean:message key="register.user.surname" />
      <html:text property="apellidos" 
                 size="30"/>
    </P>
    <P>
      <h4><bean:message key="register.user.contact" />:</h4>
      <br />
      <bean:message key="register.user.address" />
      <html:text property="direccion" 
                 size="50"/>
      <br />
      <bean:message key="register.user.city" />
      <html:text property="poblacion" 
                 size="20"/>
      <bean:message key="register.user.state" />
      <html:text property="provincia" 
                 size="20"/>
      <br />
      <bean:message key="register.user.zipcode" />
      <html:text property="cp" 
                 size="20"/>
      <bean:message key="register.user.country" />
      <html:text property="pais" 
                 size="20"/>
      <br />
      <bean:message key="register.user.phone" />
      <html:text property="telefono" 
                 size="20"/>
      <bean:message key="register.user.email" />
      <html:text property="email" 
                 size="20"/>
    </P>
    <P>
    <html:submit alt="Registrar usuario" 
                 value="Registrar"/>
    </P>
    
  </html:form>
  <!-- Register process errors -->
  <html:errors property="registro" />