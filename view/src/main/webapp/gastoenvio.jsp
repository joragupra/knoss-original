<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ page contentType="text/html;charset=windows-1252"%>

<template:insert template="template.jsp">
  <template:put name="body" content="gastoenvioContent.jsp" />
</template:insert>