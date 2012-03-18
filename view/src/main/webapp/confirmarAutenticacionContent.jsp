<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="model.entity.Usuario" %>


  <H3>
    <bean:message key="user.home.welcome" />,&nbsp;
    <bean:write name="usuario" property="nombre" />&nbsp;
    <bean:write name="usuario" property="apellidos" />
  </H3>
  <p>
    <bean:message key="user.home.whattodo" />
  </p>
  <ul>
    <li><a href="cambioPassword.jsp"><bean:message key="user.home.changepassword" /></a></li>
    <li><a href="consultarPedidos.do"><bean:message key="user.home.revieworders" /></a></li>
  </ul>