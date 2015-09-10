<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1"/>
		<title>jQuery treeview</title>
		
		<link rel="stylesheet" href="<c:url value='/resources/css/jquery.treeview.css'/>" />
		
		<script src="<c:url value='/resources/js/lib/jquery.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/resources/js/lib/jquery.cookie.js'/>" type="text/javascript"></script>
		<script src="<c:url value='/resources/js/lib//jquery.treeview.js'/>" type="text/javascript"></script>
		
		<script type="text/javascript" src="<c:url value='/resources/js/tree.js'/>"></script>
	
	</head>
	<body>
		<div id="main">
			<h4>LDAP TREE VIEW</h4>
			<ul id="browser" class="filetree">
			</ul>
		</div>
	</body>
</html>