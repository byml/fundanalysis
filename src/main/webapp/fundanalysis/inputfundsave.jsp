<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Fund</title>
</head>
<body>
<h3>Use the form below to create a new fund.</h3>


     <s:form action="executeFundSave" method="post">
     
     	<s:textfield name="fund.code" label="Codee" />
     	<s:textfield name="fund.fullName" label="Full Namee" />
     	
     	
     	
     	<s:submit />
     
     </s:form>



<p><a href="index.jsp">Find another fund</a></p>
<p><a href="<s:url action='allFundsFinder'/>">Find all funds</a>.</p>


</body>
</html>