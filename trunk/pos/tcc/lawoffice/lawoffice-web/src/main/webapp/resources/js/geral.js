// menu .....


jQuery(function(){ 
	jQuery("ul.sf-menu").supersubs({ 
        minWidth:    12,   // minimum width of sub-menus in em units 
        maxWidth:    20,   // maximum width of sub-menus in em units 
        extraWidth:  1     // extra width can ensure lines don't sometimes turn over 
                           // due to slight rounding differences and font-family 
    }).superfish({delay:0});  // call supersubs first, then superfish, so that subs are 
                     // not display:none when measuring. Call before initialising 
                    // containing tabs for same reason. 
}); 


jQuery(function(){
	jQuery('ul.sf-menu > li').hover(
		function (){
			jQuery(this)
			.children('a')
			.css('color', '#FFFFFF');
		},
		function (){
			jQuery(this)
			.children('a')
			.css('color', '#1B5790');
		}		
	);
});



jQuery(function(){
	jQuery('input:submit').button();
});




jQuery(function(){
	hideTable();
});


function hideTable(){
	jQuery('table').hide();
	jQuery('#commandButtons').hide();
}


function showTable(){
	jQuery('table').show();
	jQuery('#commandButtons').show();
}



/**
 * exibi ou esconde a tabela ao adicioanar uma custa.
 */
function showHideTable() {
	
	var trs =  jQuery('table > tbody > tr');
	
	if(trs.length == 1){
		if(jQuery(trs).text() != 'No records found.'){
			showTable();	
		}else{
			hideTable();
		}		
	}
}


/**
 * esconde a tabela de custas 
 */
function hideTableRemove(data){
	
	if (data.status == "success"){		
		
		var trs =  jQuery('table > tbody > tr');
		
		if(trs.length == 1)
			if(jQuery(trs).text() == 'No records found.')
				hideTable();
	}
}


