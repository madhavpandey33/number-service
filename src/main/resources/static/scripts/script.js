$(function(){
	hideErrorLabel();
});

function convert() {
	var inputNumber = $("#inputNumber").val();
	if(inputNumber) {
		$.ajax({
			url : "/v1/roman_number/"+inputNumber,
			success : function(result) {
				$("#romanValue").val(result);
			}
		});
	} else {
		$("#errorLabel").show();
	}
}

function hideErrorLabel(){
	$("#errorLabel").hide();
}