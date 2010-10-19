$(function() {
	$("table").tablesorter();
});


function temp(data){
	//if ( data.status == "begin")
		//$('#ajaxLoader').show();	
	//else 
	if (data.status == "success")
		$("table").tablesorter();
}



// menu .....

$(function(){
	$('ul.sf-menu')
		.superfish({delay:0});
});


$(function(){
	$('ul.sf-menu > li').hover(
		function (){
			$(this)
			.children('a')
			.css('color', '#FFFFFF');
		},
		function (){
			$(this)
			.children('a')
			.css('color', '#1B5790');
		}		
	);
});

// fim menu ...

