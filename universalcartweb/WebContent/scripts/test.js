$(document).ready( function() {

	//var it = [{type: 9, data: "xyz"}, {type: 7, data: "car1"}, {type: 8, data: "Hotel Jayshri"}];
	
	/** On load * */
	var reqObj = {
		"email" : "test@gmail.com"
	};
	$.ajax( {
		type : 'POST',
		data : reqObj,
		url : "http://10.245.231.50:8080/viewcart",
		success : function(response) {
			alert("Data = " + response);
			
			$.each(response, function() {
				$('#cartbody').append('<div style="background: #CCCCCC">' + this.data + '</div>');
			});
			
		}
	});

	/*
	 * $(document).on("click", "#submitBtn", function() { var reqObj = {
	 * "passengerData" : JSON.stringify( { "emailId" : "test@gmail.com" }) };
	 * $.ajax( { type : 'POST', data : reqObj, url : "getallitems", success :
	 * function(data) { // Check if page needs to be redirected
	 * 
	 * if (!!data) { alert("hurrayyyy!!!!!!!!!!!!!!!"); } } }); });
	 */

});