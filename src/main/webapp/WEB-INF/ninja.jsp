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
    <title>Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div>
		<h1>Create an Ninja</h1>
		<form:form class="form" action="/ninjas/create" method="post" modelAttribute="ninja">
			<div>
				<form:label class="fw-bold mt-2 form-label" path='dojo'>Dojo Name:</form:label>
				<form:select path="dojo">
					<c:forEach var="dojos" items = "${dojos}">
						<option value="${dojos.id}"><c:out value="${dojos.name}"/></option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:label class="fw-bold mt-2 form-label" path='first_name'>First Name:</form:label>
				<form:errors class="text-danger" path="first_name"/>
	   			<form:input class="form-control" path='first_name'/>
			</div>
			<div>
				<form:label class="fw-bold mt-2 form-label" path='last_name'>Last Name:</form:label>
				<form:errors class="text-danger" path="last_name"/>
	   			<form:input class="form-control" path='last_name'/>
			</div>
			<div>
				<form:label class="fw-bold mt-2 form-label" path='age'>Age:</form:label>
				<form:errors class="text-danger" path="age"/>
	   			<form:input class="form-control" path='age'/>
			</div>
	   		<input class="mt-3 border border-dark rounded" type="submit" value="Create"/>
   		</form:form>
		
	</div>
</body>
</html>