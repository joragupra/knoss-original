<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page contentType="text/html;charset=windows-1252"%>

  <h3><bean:message key="orders.title" /></h3>
  <P>
    <logic:empty name="pedidosList">
      <bean:message key="orders.empty" />
    </logic:empty>

    <logic:notEmpty  name="pedidosList">
      <bean:message key="orders.details" />:
    </logic:notEmpty>
    <ul>
    <logic:iterate id="pedido" 
                   scope="request" 
                   name="pedidosList" 
                   type="model.entity.Pedido">
      <li>
        <bean:message key="orders.date" />:
        <bean:write name="pedido" property="stringFecha" />&nbsp;
        <bean:message key="orders.status" />:
        <bean:write name="pedido" property="estado" />&nbsp;
        <bean:define id="libros" 
                     name="pedido" 
                     property="libros"/>
        <ul>
        <logic:iterate id="libro" 
                       name="libros"
                       type="model.entity.Libro">
          <li><bean:write name="libro" property="titulo" /></li>
        </logic:iterate>
        </ul>
      </li>
    </logic:iterate>
    </ul>
  </P>