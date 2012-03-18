<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=windows-1252"%>

<jsp:useBean id="categorias" scope="application" class="model.BeanCategorias" />
<bean:define id="lista_categorias" name="categorias" property="categorias" />    
<div id="section">Categor&iacute;as</div>
<c:forEach items="${lista_categorias}" var="nombre">
  <font face="verdana, arial, helvetica" size="-1">
    <a href="buscarPorCategoria.do?categoria=<c:out value="${nombre}"/>">
      <c:out value="${nombre}"/>
    </a>
  </font><br/>
</c:forEach>