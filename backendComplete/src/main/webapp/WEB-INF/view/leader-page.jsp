<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>Leader Page</title>
</head>

<body>
<h2>Leader Home Page</h2><br>

<p>Welcome my lord!! </p>
<br><br>

<p> We are not regular employees</p>

<hr>

<a href="home">Back to the regular Home page(ew!)</a>

<br><br><br><br>
<!-- add a logout button  -->

<form:form action="${pageContext.request.contextPath}/logout" 
method="POST">

	<input type="submit" value="Logout" />

</form:form>
</body>

</html>

