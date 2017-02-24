$(document).ready( function() {

	$.ajax( {
		url : "../getallitems.action",
		type : "POST",
		success : function(response) {
			alert(response);

			$.each(response.cart.flights, function() {
				var divbody = '<p>' + this.id + ' : FLIGHT </p>';
				$('#cartbody').append(divbody);
			});

			$.each(response.cart.hotels, function() {
				var divbody = '<p>' + this.id + ' : HOTEL</p>';

				$('#cartbody').append(divbody);
			});

			$.each(response.cart.cars, function() {
				var divbody = '<p>' + this.id + ' :CAR </p>';

				$('#cartbody').append(divbody);
			});
		}
	});

});