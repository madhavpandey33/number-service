$(function(){
	hideErrors();
	hideLodingGif();
});

function convert() {
	var inputNumber = $("#inputNumber").val();
	if(inputNumber) {
		$("#animated-gif").show();
		$.ajax({
			url : "/v1/roman_number/"+inputNumber,
			success : function(result) {
				hideLodingGif();
				$("#romanValue").val(result);
			},
			error: function(error){
				hideLodingGif();
				$("#serverError").html(error.responseJSON.message);
				$("#errorResponse").show();
			}
		});
	} else {
		hideLodingGif();
		$("#errorLabel").show();
	}
}

function hideErrors(){
	$("#errorLabel").hide();
	$("#errorResponse").hide();
}

function hideLodingGif(){
	$("#animated-gif").hide();
}