<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ page contentType="text/html;charset=windows-1252"%>

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
      <c:import url="header.html" />
    </div>
    <!-- Website content search -->
    <div id="search">
      <c:import url="buscador.jsp" />
    </div>
    <!-- Website content menu -->
    <div id="menu">
      <c:import url="menu.jsp" />
    </div>
    <!-- Website registered users login -->
    <div id="login">
      <c:import url="login.jsp" />
    </div>
    <!-- Content begins here -->
    <div id="content">
      <template:get name="body" />
    </div>
    <!-- Website footer -->
    <div id="footer">
      <c:import url="footer.html" />
    </div>
  </div>
    
  </body>
</html>