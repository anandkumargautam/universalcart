
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

<div><s:form action="addtocart">
	<s:textfield name="passenger.skymileNumber" size="20" label="Skymile Number" required="true" id="skymilenumber"/>


	<br>
	<s:select label="Product Type" name="product.type" headerKey="-1"
		headerValue="Select Product Type"
		list="#{'flight':'FLIGHT', 'hotel':'HOTEL', 'car':'CAR'}" value="type"
		required="true" 
		id="producttype"/>




	<s:textarea rows="10" cols="70" name="product.data" id="productxml" />

	<s:submit value="Add To Cart"></s:submit>
</s:form> <br>
</div>


<br>
<s:property value="message.message" /> <br>

<button id="viewcart" value="View Cart">View Cart</button>
<script language="JavaScript" src="scripts/jquery-3.1.1.js"></script>
<script language="JavaScript" src="scripts/index.js"></script>
</body>
</html>