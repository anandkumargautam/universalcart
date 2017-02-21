$(document).ready( function() {

	//var it = [{type: 9, data: "xyz"}, {type: 7, data: "car1"}, {type: 8, data: "Hotel Jayshri"}];
	
	/** On load * */
	var reqObj = {
		"email" : "test@gmail.com"
	};
	$.ajax( {
		type : 'GET',
		data : reqObj,
		dataType : 'application/json; charset=utf-8',
		url : "http://10.245.231.50:8080/viewcart",
		success : function(data) {
			alert("Data = " + data);
			
			$.each(data, function() {
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