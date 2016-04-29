<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:useBean id="daten" class="beans.RestUtil" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body background="./image.jpg">
<f:view>
		
		<table border="0" width="100%">
		  <tr><td>Bezeichnung</td><td><input size="50" maxlength="50" name="Name" value=${daten.getData()}/></td></tr>
		  <tr><td>Beschreibung</td><td><input size="50" maxlength="50" name="Beschreibung" value=${daten.getData()}/></td></tr>
		  <tr><td>Zusätzliche Information</td><td><input size="50" maxlength="50" name="Zusätzliche Information" value=${daten.getData()}/></td></tr>
		</table>
	</f:view>
<?xml version="1.0" encoding="ISO-8859-1" ?></body>
</html>