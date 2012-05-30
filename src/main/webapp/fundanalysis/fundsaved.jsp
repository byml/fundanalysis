<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fund Saved</title>
</head>
<body>
<h3>Below are the details of the fund created.</h3>

<s:if test="fund != null" >

        
             
	<p><s:property value="fund" />  </p>



</s:if>

<s:else>

<p>No fund was saved.</p>
</s:else>

<p><a href="index.jsp">Find fund</a></p>
<p><a href="<s:url action='allFundsFinder'/>">Find all funds</a>.</p>


</body>
</html>