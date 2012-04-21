$(function() {
	$("#addTheme").click(function() {
		$.get(
			"backlog",
			{ action: "ADDTHEME"}
		);
	});
});