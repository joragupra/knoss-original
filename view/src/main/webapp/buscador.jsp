<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page contentType="text/html;charset=windows-1252"%>

<div id="search_title">Buscador</div>
<html:form action="buscar.do" method="post">
  <P>
    <bean:message key="search.term" />
    <html:text property="termino" 
               alt="T&eacute;rmino%20a%20buscar" 
               size="15" 
               maxlength="256"/>
    <html:image src="images/search.gif" 
                alt="Realizar b&uacute;squeda"/>
  </P>
  <P>
    <bean:message key="search.author" />
    <html:radio property="criterio" 
                value="autor" 
                alt="Buscar por autor"/>
    <bean:message key="search.title" />
    <html:radio property="criterio" 
                value="titulo" 
                alt="Buscar por titulo"/>
    <bean:message key="search.isbn" />
    <html:radio property="criterio" 
                value="isbn" 
                alt="Buscar por ISBN"/>
  </P>  
</html:form>