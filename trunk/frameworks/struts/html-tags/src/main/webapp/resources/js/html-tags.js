$(function() {
	
	$("#radio > :radio").click(function(){
		$.ajax({
			type: "POST",
			url: 'htmltags.do?method=radio',
			data: $("#formRadio").serialize(),
			success: function(data){
					$("#msg").text(data);
				}			
			});
		});
});