

$(function() {
	$("#addTheme", $('.menu'))
		.click(function() {
			$('#themes')
				.fadeOut(
					1000,
					function() {
						$('#addTheme').fadeIn(100);
					}
				);
		});
});



$(function() {
	$("#btnAddTheme").click(function() {
		$.post( "backlog",
				$('#formAddTheme').serialize(),
				function(data){
					$("#themes").html(data);
					$('#addTheme').fadeOut(
							1000,
							function() {
								$('#themes').fadeIn(100);
							}
						);
					},
				'html'

			);
		});
});
