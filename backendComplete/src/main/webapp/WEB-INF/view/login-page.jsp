<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>

<HTML>

<HEAD>
<link rel="stylesheet" type="text/css" 
 href="cssfiles/log-style.css">
 
		<TITLE> Custom LOG-IN</TITLE>
</HEAD>

<BODY>

<H3>MY CUSTOM LOGIN</H3>

	<a href="home">Return to the home page</a>
	<br><br><br>

	
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" 
		method="POST">
		
		<!-- check for login error -->
		<c:if test="${param.error != null }">
			<i class="loginerror">Incorrect Username/password</i>
			
		</c:if> 
		
		<!-- check for logout -->
		<c:if test="${param.logout != null }">
			<i class="logout">You have been logged out</i>
			
		</c:if> 
		
				<!--username-->
		<p>
		User name: <input type="text" name="username" />
		</p>
				<!--password-->
		<p>
		Password: <input type="password" name="password" />
		</p>
		
	
				<!--submit button-->
		<input type="submit" value="Login"/>
	</form:form>	
	
	
	

<div id="footer"> &copy;2020 greyfox LOG IN </div>

</BODY>

</HTML>