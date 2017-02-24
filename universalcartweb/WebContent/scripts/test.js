$(document).ready( function() {

	// var it = [{type: 9, data: "xyz"}, {type: 7, data: "car1"}, {type: 8,
		// data: "Hotel Jayshri"}];
		$.ajax( {
			url : "../getallitems.action",
			type : "POST",
			success : function(response) {
				alert(response);

				$.each(response.flights, function() {
					var divbody = '<p>' + this.id + ' : FLIGHT </p>';
					$('#cartbody').append(divbody);
				});

				$.each(response.hotels, function() {
					var divbody = '<p>' + this.id + ' : HOTEL</p>';

					$('#cartbody').append(divbody);
				});

				$.each(response.cars, function() {
					var divbody = '<p>' + this.id + ' :CAR </p>';

					$('#cartbody').append(divbody);
				});
			}
		});

		/** On load * */
		/*
		 * var reqObj = { "email" : "test@gmail.com" };
		 * 
		 * $.ajax( { type : 'POST', data : reqObj, url :
		 * "http://10.245.231.50:8080/viewcart", success : function(response) {
		 * 
		 * $.each(response, function() { var divbody = ''; if (this.type ==
		 * 'flight') { divbody = '<p>' + this.id + ' : FLIGHT </p>'; } else
		 * if (this.type == 'hotel') { divbody = '<p>' + this.id + ' : HOTEL
		 * </p>'; } else if (this.type == 'car') { divbody = '<p>' + this.id + ' :
		 * CAR </p>'; } $('#cartbody').append(divbody); }); } });
		 */

		/*
		 * $(document).on("click", "#submitBtn", function() { var reqObj = {
		 * "passengerData" : JSON.stringify( { "emailId" : "test@gmail.com" }) };
		 * $.ajax( { type : 'POST', data : reqObj, url : "getallitems", success :
		 * function(data) { // Check if page needs to be redirected
		 * 
		 * if (!!data) { alert("hurrayyyy!!!!!!!!!!!!!!!"); } } }); });
		 */

	});