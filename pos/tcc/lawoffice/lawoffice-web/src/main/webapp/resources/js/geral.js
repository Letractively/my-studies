function temp(data){
	//if ( data.status == "begin")
		//$('#ajaxLoader').show();	
	//else 
	if (data.status == "success")
		$("table").tablesorter();
}



// menu .....


$(function(){ 
    $("ul.sf-menu").supersubs({ 
        minWidth:    12,   // minimum width of sub-menus in em units 
        maxWidth:    20,   // maximum width of sub-menus in em units 
        extraWidth:  1     // extra width can ensure lines don't sometimes turn over 
                           // due to slight rounding differences and font-family 
    }).superfish({delay:0});  // call supersubs first, then superfish, so that subs are 
                     // not display:none when measuring. Call before initialising 
                    // containing tabs for same reason. 
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

