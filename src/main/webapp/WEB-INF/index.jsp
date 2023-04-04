<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojo</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div>
		<h1>Create an Dojo</h1>
		<form:form class="form" action="/dojos/create" method="post" modelAttribute="dojo">
			<div>
				<form:label class="fw-bold mt-2 form-label" path='name'>Dojo Name:</form:label>
				<form:errors class="text-danger" path="name"/>
	   			<form:input class="form-control" path='name'/>
			</div>
	   		<input class="mt-3 border border-dark rounded" type="submit" value="Submit"/>
   		</form:form>
		
	</div>
</body>
</html>