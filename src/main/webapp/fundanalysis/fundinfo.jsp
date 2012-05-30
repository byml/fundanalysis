<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fund Found</title>
</head>
<body>
<h3>Below are the details of the fund found.</h3>

<s:if test="fund != null" >

        <s:url action="inputFundUpdate" id="editUrl">
           <s:param name="id" value="id"/>
        </s:url>
        
        <s:url action="fundDelete" id="deleteUrl">
        	<s:param name="id" value="id"/>
        </s:url>
             
	<p><s:property value="fund" /> <a href="<s:property value="#editUrl"/>">Edit</a> &nbsp;&nbsp; 
	   <a href="<s:property value="#deleteUrl"/>">Delete</a> </p>



</s:if>

<s:else>

<p>No fund was found.</p>
</s:else>

<p><a href="index.jsp">Find another fund</a></p>
<p><a href="<s:url action='allFundsFinder'/>">Find all funds</a>.</p>


</body>
</html>