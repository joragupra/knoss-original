<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=windows-1252"%>
<jsp:useBean id="libros" scope="application" class="model.BeanLibros" />
<jsp:setProperty name="libros" property="categoria" value="${param.categoria}" />
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
    <title>Consulta de libros</title>
  </head>
  <body>
  </body>
</html>
