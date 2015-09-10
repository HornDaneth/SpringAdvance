<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>
<body>
    ${test}
</body>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		jQuery.ajax( {
			type			: "GET",
			url				: "<c:url value='/validator/person'/>" ,
		    contentType		: "application/x-www-form-urlencoded; charset=UTF-8", //"application/json",
		    data			: {"id": "4"}, // if contentType = application/json (not GET method) then have to use JSON.stringify()
			dataType		: "json",
			async			: false,
			cache			: false,
			success: function( data ){
				var errors = data.description;
				$.each(errors, function(index, value){
					alert(value.defaultMessage);
				});
			},
			error: function ( error ){
				
			}    
		} );
	});
</script>
</html>
