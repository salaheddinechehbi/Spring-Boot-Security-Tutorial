/**
 * 
 */
  	
    $(document).on('click','#infoPers',function(){
	    $.ajax({
	        url: "/findInfo",
	        type: 'GET',
	        cache: false,
	        dataType: 'json',
	        success: function (data, textStatus, jqXHR) {
	        	$('#nomPr').val(data.nom);
	        	$('#emailPr').val(data.email);
	        	$('#telPr').val(data.tele);
	        	$('#unPr').val(data.username);
	            console.log(data);
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            console.log(textStatus);
	        }
	    });
  });
    