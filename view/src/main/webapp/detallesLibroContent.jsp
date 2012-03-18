<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page contentType="text/html;charset=windows-1252"%>

  <p>
    <logic:empty name="librosList">
      <bean:message key="book.details.error" />
    </logic:empty>
    
    <logic:iterate id="libro" 
                   scope="request" 
                   name="librosList" 
                   type="model.entity.Libro">
      <h2><bean:message key="details.book.title" />:
      <bean:write name="libro" 
                  property="titulo" />
      </h2>
      <h5>
      <bean:write name="libro" 
                  property="autor" />
      </h5>
      <h6>
      <bean:write name="libro" 
                  property="editorial" />
      </h6>
      <h6><bean:message key="details.book.language" />:
      <bean:write name="libro" 
                  property="idioma" />
      </h6>
      <h6><bean:message key="details.book.edition" />:
      <bean:write name="libro" 
                  property="encuadernacion" />
      </h6>
      <h6><bean:message key="details.book.pages" />:
      <bean:write name="libro" 
                  property="paginas" />
      </h6>
      <h6><bean:message key="details.book.price" />:
      <bean:write name="libro" 
                  property="precio" />
      </h6>
      <logic:notEmpty name="libro"
                      property="resumen">
        <div id="section">
          <bean:message key="details.book.abstract" />:
        </div>
        <div id="abstract">
        <p>
          <bean:write name="libro" 
                      property="resumen" />
        </p>
        </div>
      </logic:notEmpty>
      
      <logic:present name="usuario">
        <a href="anadirAlCarrito.do?idLibro=<bean:write name="libro" property="idLibro" />">
          <bean:message key="details.book.addtocart" />
        </a>
      </logic:present>

    </logic:iterate>
  </p>