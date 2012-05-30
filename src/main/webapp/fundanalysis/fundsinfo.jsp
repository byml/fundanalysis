<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./style/css/ie.css" type="text/css" />
<link rel="stylesheet" href="./style/css/screen.css" type="text/css" />
<title>Fund Found</title>
</head>
<body>
	<h3>Below are the details for all the funds.</h3>

	<table>
		 
			<td>code</td>
			<td>full name</td>
			<td>short name</td>
			<td><s:text name="fund.x"/></td>
			<td></td>
		 

		<s:iterator value="funds">
			<tr>


				<s:url action="inputFundUpdate" id="editUrl">
					<s:param name="id" value="id" />
				</s:url>

				<s:url action="fundDelete" id="deleteUrl">
					<s:param name="id" value="id" />
				</s:url>


				<%--if value attribute is not specified
	the property tag will call the toString method
	of each Fund object in the funds collection. --%>
				<td><s:property value="code" /></td>
				<td><s:property value="fullName" /></td>
				<td><s:property value="shortName" /></td>
				<td><s:property value="fundType.name" /></td>
				<td><s:property value="closed" /></td>
				<td><s:property value="yieldAgreed" /></td>
				<td><s:property value="floorTrade" /></td>
				<td><a href="<s:property value="#editUrl"/>">Edit</a>
					&nbsp;&nbsp; <a href="<s:property value="#deleteUrl"/>">Delete</a>
				</td>

			</tr>
		</s:iterator>

	</table>

	<p>
		<a href="<s:url action='inputFundSave'/>">Create new fund</a>.
	</p>

	<p>
		<a href="index.jsp">Return home</a>
	</p>


</body>
</html>