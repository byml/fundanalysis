<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./style/css/screen.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Fund</title>
</head>
<body>
	<h3>Use the form below to edit this fund.</h3>

	<s:if test="fund != null">

		<s:form action="executeFundUpdate" method="post">

			<s:textfield name="fund.code" label="Code" />
			<s:textfield name="fund.fullName" label="Full name" />
			<s:textfield name="fund.shortName" label="Short name" />
			<s:select name="fund.fundType.id" list="fundTypes" listKey="id"
				listValue="name" headerKey="0" headerValue="NULL"
				label="Select a Fund Type" />

			<s:checkbox name="fund.closed" label="是否封闭基金" />
			<s:checkbox name="fund.yieldAgreed" label="是否约定收益" /> 			
			<s:checkbox name="fund.floorTrade"  label="是否上市交易" />
			
			<s:hidden name="fund.id" />
			<s:submit />

		</s:form>


	</s:if>

	<s:else>

		<p>No fund was found.</p>
	</s:else>

	<p>
		<a href="index.jsp">Find another fund</a>
	</p>
	<p>
		<a href="<s:url action='allFundsFinder'/>">Find all funds</a>.
	</p>


</body>
</html>