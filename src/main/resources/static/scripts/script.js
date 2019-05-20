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
				$("#romanValue").val("");
			}
		});
	} else {
		hideLodingGif();
		showErrorLabel();
	}
}

function hideErrors(){
	$("#errorLabel").hide();
	$("#errorResponse").hide();
}

function hideLodingGif(){
	$("#animated-gif").hide();
}

function showErrorLabel(){
	$("#errorLabel").show();
	$("#romanValue").val("");
}

function validateInput(){
	if(window.currentAscii == 46){
		window.currentAscii = null;
		$("#errorLabel").show();
		$("#errorResponse").hide();
	} else {
		hideErrors();
	}
	
}
