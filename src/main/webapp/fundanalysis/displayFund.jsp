<%-- 
    Document   : success
    Created on : Feb 28, 2009, 8:24:14 AM
    Author     : eswar@vaannila.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
<sj:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
	<h1>Fund</h1>
	<s:property value="fund.code" />
	<s:property value="fund.fullName" />

	<div id="div1">Div 1</div>
	<s:url id="ajaxTest" value="/allFundsFinder.action" />
	<sj:a id="link1" href="%{ajaxTest}" targets="div1">       Update Content     </sj:a>
</body>
</html>
