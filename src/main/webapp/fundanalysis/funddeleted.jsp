<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fund Deleted</title>
</head>
<body>
<h3>Fund was deleted successfully.</h3>

<p>This fund was deleted: <s:property value="fund" /></p>

<p><a href="index.jsp">Find another fund</a></p>
<p><a href="<s:url action='allFundsFinder'/>">Find all funds</a>.</p>


</body>
</html>