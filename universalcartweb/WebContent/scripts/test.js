$(document).ready( function() {

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