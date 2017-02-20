
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sample Page</title>

</head>
<body>
	<center>
		<h2>Test Page</h2>

		<br>
		<hr>

		<div>
			<s:form action="managecart">
				<s:textfield name="passenger.emailId" label="Message" />
				<s:submit value="Submit" />
			</s:form>
			<br>
			<!--<s:form action="authenticationaction">
				<s:textfield name="authentication.userName" label="Username" />
				<s:password name="authentication.password" label="Password" />
				<s:radio label="admin" name="authencation.isAdmin" list="true" />
				<s:submit value="Submit" />
			</s:form>
		--></div>
	</center>
</body>
</html>