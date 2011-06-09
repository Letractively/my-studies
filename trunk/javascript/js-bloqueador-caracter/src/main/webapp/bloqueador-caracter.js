$(function(){
	$("input").keypress(function(event){		
		var caracter = String.fromCharCode(event.which);		
		if (caracter.search(/[@#%&*!%]/g) != -1){
			return false;
		}
	});	
});