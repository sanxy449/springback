<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Home Page</title>

<link rel="stylesheet" type="text/css" 
 href="cssfiles/home-style.css">
 
</head>
<body>
<h2>Home Page</h2>


<a href="showForm">account register form </a>
<BR><BR><BR><BR><BR>
<a href="showLoginPage">Login </a>

<BR><BR><BR><BR><BR>
<security:authorize access="hasRole('ROLE_EMPLOYEE')">

	<p>
	WELCOME	MR EMPLOYEE
	</p>	
	


	<security:authorize access="hasRole('ROLE_MANAGER')">
	
	<!--  add a link to point to /leaders etc -->
	
	
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for managers)
		</p>	
		<hr>
	</security:authorize>


	<security:authorize access="hasRole('ROLE_ADMIN')">

	<!--  add a link to point to admins (/systems) etc -->

		<p>
			<a href="${pageContext.request.contextPath}/systems">Administrator place</a>
			(Only for admins)
		</p>	
		<hr>
	</security:authorize>

	<!-- add a logout button  -->

	<form:form action="${pageContext.request.contextPath}/logout" 
	method="POST">

		<input type="submit" value="Logout" />

	</form:form>
	
<!--end employee -->	
</security:authorize>



</body>
</html>