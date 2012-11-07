$(function() {

	$('.btn').click(function(event) {
		jsf.ajax.request(this,event,
			{
				render: 'upper-case-name',
				execute: 'btn name'
			}
		);
	});

});






