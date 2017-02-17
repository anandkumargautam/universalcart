<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body>

	<script type="text/javascript">
		function fetchSubCategories() {
			
			/*$.getJSON('getsubcategorybycataction', {
				"categoryId" : $("#selectedCategory").val()
		      }, function(jsonResponse) {
		       alert(jsonResponse)
		         var select = $('#states');
		        select.find('option').remove();
		        $.each(jsonResponse.stateMap, function(key, value) {
		          $('<option>').val(key).text(value).appendTo(select);
		        }); 
		      });*/
		
			
			 $.ajax({
				type : "POST",
				url : "<s:url action='getsubcategorybycataction.action'/>",
				dataType : 'json',
				data : {
					'categoryId' : $("#selectedCategory").val()
				},
				success : function(result) {
					if (result != null && result.length > 0) {
						alert(result);
						//$("statesdivid").html(result);
					}
				},
				error : function(xhr, errmsg) {
					alert("No values found..!!");
				}
			}); 
		}
	</script>

	<center>

		<s:form action="uploadbook">

			<!-- Category Selection -->
			<s:select label="Category" list="categories" headerKey="-1"
				headerValue="Select Book Category" name="selectedCategory"
				listKey="id" listValue="name"
				id="selectedCategory" onchange="fetchSubCategories();"></s:select>

			<!-- SubCategory Selection -->
			<%-- <s:select label="SubCategory" list="subcategories" headerKey="-1"
				headerValue="Select Book SubCategory" name="selectSubCategory"></s:select> --%>

			<div id="statesdivid">
				<s:if test="%{#request.selectedsubcategories != null}">
					<s:select list="#request.selectedsubcategories"
						name="selectedSubCategories">
					</s:select>
				</s:if>
			</div>

			<s:file name="file" value="Select eBook"></s:file>

			<s:submit value="Upload"></s:submit>

		</s:form>

	</center>


</body>
</html>