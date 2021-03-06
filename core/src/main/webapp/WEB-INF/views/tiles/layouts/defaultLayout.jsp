<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="core" tagdir="/WEB-INF/tags" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title" /></title>
	<core:resources type="css" path="css"/>
    <core:resources type="js" path="js"/>  </head>
</head>
  
<body>
        <header class="col-md-12" id="header">
            <tiles:insertAttribute name="header" />
        </header>
     
        <section class="col-md-2" id="sidemenu">
            <tiles:insertAttribute name="menu" />
        </section>
             
        <section  id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer class="col-md-12" id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>