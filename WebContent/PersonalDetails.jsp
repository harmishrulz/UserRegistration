<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Personal Detail</title>
</head>
<body>

<form method="get" action="SavePersonalDetails">
<input type="hidden" name = "signupid" value="${signup }" />
<input type="hidden" name = "password" value="${password }"/>

<table>
	<tr>
		<td>
			First Name		
		</td>
		<td>
			<input type="text" size="30" name="txtFirstName" value="${firstname }" />
		</td>
		<td>
			*
		</td>
	</tr>
	
	<tr>
		<td>
			Last Name		
		</td>
		<td>
			<input type="text" size="30" name="txtLastName" value="${lastname }"/>
		</td>
		<td>
			*
		</td>
	</tr>
	
	<tr>
		<td>
			Email		
		</td>
		<td>
			<input type="text" size="30" name="txtEmail" value="${email }"/>
		</td>
		<td>
			*
		</td>
	</tr>
	
	<tr>
		<td>
			Username		
		</td>
		<td>
			<input type="text" size="30" name="txtUserName"/>
		</td>
		<td>
			*
		</td>
	</tr>
	
	
	<tr>
		<td>
			Date Of Birth		
		</td>
		<td>
			<input type="text" size="30" name="txtDob" />
		</td>
		<td>
			*
		</td>
	</tr>




	<tr>
		<td>
			City		
		</td>
		<td>
			<input type="text" size="30" name="City" />
		</td>
		<td>
			*
		</td>
	</tr>

	
	<tr>
		<td>
			State		
		</td>
		<td>
			<input type="text" size="30" name="State" />
		</td>
		<td>
			*
		</td>
	</tr>
	
	<tr>
		<td>
			Country
		</td>
		<td>
			<input type="select" size="30" name="Country" />
		</td>
		<td>
			*
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			Enter the characters from the captcha
			<div>
				<%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LdpJNgSAAAAAOT4AYaltm4mj47giAx6YYnMZPF0", "6LdpJNgSAAAAACVXRbfQR1kb-LMx0tiuZbu337jG", false);
          out.print(c.createRecaptchaHtml(null, null));
        %>
				
			</div>
		</td>
	</tr>
	
	<tr>
		<td></td>
		<td>
			<input type="submit" value = "Proceed to Interests">
			<input type="submit" value = "Reset">
		</td>
	</tr>

</table>

</form>

</body>
</html>