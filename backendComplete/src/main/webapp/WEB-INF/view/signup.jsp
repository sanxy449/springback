<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>

<HTML>

<HEAD>
 <link rel="stylesheet" type="text/css" 
 href="cssfiles/form-style.css">
 
		<TITLE> game account reg form</TITLE>
</HEAD>

<BODY>



	

	<div class="signform">
	<form:form action="processData" method="post"  modelAttribute="gamer">
		<b class="reg">Sign up</b><br>
		
				<!--username-->
		<label for="username">Username <b style="color:red">*</b></label><br>
		<form:input  placeholder="Displayed Name" path="credentials.username" />
		<form:errors path="credentials.username" cssClass="error" />
		<br>
		
				<!--password-->
		<label for="password">Password <b style="color:red">*</b></label><br>
		<form:input type="password" placeholder="Enter a Password" path="credentials.password" />
		<form:errors path="credentials.password" cssClass="error" />
		<br>
		
		<!--password2-->
		<label for="password2">Reenter your Password <b style="color:red">*</b></label><br>
		<form:input type="password" placeholder="Enter a Password" path="gamerProfile.password2" />
		
		<br>
		
				

				<!--First Name-->
		<label for="firstname">First Name <b style="color:red">*</b></label><br>
		<form:input  placeholder="Your First Name" path="gamerProfile.firstName" />
		<form:errors path="gamerProfile.firstName" cssClass="error" />
		<br>
		

				<!--Last Name-->
		<label for="lastname">Last Name <b style="color:red">*</b></label><br>
		<form:input  placeholder="Your Last Name" path="gamerProfile.lastName" />
		<form:errors path="gamerProfile.lastName" cssClass="error" />
		<br>
				<!--Date of birth-->
		<label for="birthday">Date of Birth-dd/mm/yy <b style="color:red">*</b></label><br>
		<form:input placeholder="dd/mm/yy path" path="gamerProfile.birthday" /> 
		
		<br>
		
				<!--input birthday  pattern="\d{1,2}/\d{1,2}/\d{4}"-->

				<!--E-mail-->
		<label for="email">E-mail <b style="color:red">*</b></label><br>
		<form:input type="email" placeholder="Your e-mail" path="gamerProfile.email" />
		<form:errors path="gamerProfile.email" cssClass="error" />
		<br>
		
				<!--Phone Number-->
		<label for="phone">Phone Number </label><br>
		<form:input path="gamerProfile.phone" placeholder="Enter your phone number here"/>
		<form:errors path="gamerProfile.phone" cssClass="error" />
		<br>

				<!--submit button-->
		<button type="submit">Submit</button>
	</form:form>	
	</div>
	

<div id="footer"> &copy;2020 greyfox signup </div>

</BODY>

</HTML>