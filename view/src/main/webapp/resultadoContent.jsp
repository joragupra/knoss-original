<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page contentType="text/html;charset=windows-1252"%>

  <h3><bean:message key="result.title" /></h3>
  <P>
    <logic:empty name="librosList">
      <bean:message key="search.empty" />
    </logic:empty>

    <ul>
    <logic:iterate id="libro" 
                   scope="request" 
                   name="librosList" 
                   type="model.entity.Libro">
      <li>
        <a href="verLibro.do?idLibro=<bean:write name="libro"
                                                 property="idLibro"/>">
          <bean:write name="libro" 
                  property="titulo" />
        </a>
      </li>
    </logic:iterate>
    </ul>
  </P>