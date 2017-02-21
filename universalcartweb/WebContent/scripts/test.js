$(document).ready( function() {


	var reqObj = { "email" : "test@gmail.com" };
	 
	$.ajax( {
		type : 'GET',
		data : reqObj,
		dataType: 'application/json; charset=utf-8',
		url : "http://localhost:8080/viewcart",
		success : function(data) {
			if (!!data) {
				alert("hurrayyyy!!!!!!!!!!!!!!!");
			}
		}
	});

	$(document).on("click", "#submitBtn", function() {
		var reqObj = {
			"passengerData" : JSON.stringify( {
				"emailId" : "test@gmail.com"
			})
		};
		$.ajax( {
			type : 'POST',
			data : reqObj,
			url : "getallitems",
			success : function(data) {
				// Check if page needs to be redirected
			if (!!data) {
				alert("hurrayyyy!!!!!!!!!!!!!!!");
			}
		}
		});
	});

});