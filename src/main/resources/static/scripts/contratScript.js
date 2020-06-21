

$(document).ready(function () {
	
	$(function () {
	    $("#example1").DataTable({
	      "responsive": true,
	      "autoWidth": false,
	    });
	    $('#example2').DataTable({
	      "paging": true,
	      "lengthChange": false,
	      "searching": false,
	      "ordering": true,
	      "info": true,
	      "autoWidth": false,
	      "responsive": true,
	    });
	  });
	
	
	  $('#quickForm').validate({
	    rules: {
	      email: {
	        required: true,
	        email: true,
	      },
	      libelle: {
	          required: true,
	        },
	      ville: {
	          required: true,
	        },
	      adresse: {
	          required: true,
	        },
	        tele: {
	            required: true,
	          }
	    },
	    messages: {
	      email: {
	        required: "Please enter a email address",
	        email: "Please enter a vaild email address"
	      },
	      libelle: {
	        required: "Please provide a libelle",
	      },
	      ville: {
	          required: "Please provide a ville",
	        },
	      adresse: {
	          required: "Please provide a adresse",
	        },
	        tele: {
	            required: "Please provide a tele",
	          }
	    },
	    errorElement: 'span',
	    errorPlacement: function (error, element) {
	      error.addClass('invalid-feedback');
	      element.closest('.form-group').append(error);
	    },
	    highlight: function (element, errorClass, validClass) {
	      $(element).addClass('is-invalid');
	    },
	    unhighlight: function (element, errorClass, validClass) {
	      $(element).removeClass('is-invalid');
	    }
	  });
	  
	  
	  
	  $(document).on('click','#editContrat',function(){
		    let id = $(this).parent().find('#idContrat').val();
		    let tr = $(this).closest('tr');
		    $("#updateDateS1").val($(tr).find('td').eq(0).text());
		    $("#updateDateD1").val($(tr).find('td').eq(1).text());
		    $("#updateDateF1").val($(tr).find('td').eq(2).text());
		    
		    /* Get the text field */
		    var copyText = tr.find('#descC');
		    /* Select the text field */
		    copyText.select();
		    //copyText.setSelectionRange(0, 99999); /*For mobile devices*/
		    /* Copy the text inside the text field */
		    document.execCommand("copy");
		    /* Alert the copied text */
		    $(".textareaUp").summernote('code',copyText.val());
		    
		    $('#update-modal #idCt').val($(this).parent().find('#idContrat').val());
		    
		  	//if(window.clipboardData){
		  		//window.clipboardData.clearData();
		  		//window.clipboardData.setData("TextC",tr.find('#descC').val());
		  		//document.getElementById("updateDesc1").text = window.clipboardData.getData("TextC");
		  		//console.log(window.clipboardData.getData("TextC")+"walo");
		  	//}
		    //$("#updateDesc1").html(tr.find('#descC').val());
		     
	  });
	  
	  $(document).on('click','#deleteContrat',function(){
		  	let id = $(this).parent().find('#idContrat').val();
		  	$('#delete-modal #idCt').val(id);
	  });

	  $(document).on('click','#closeMod',function(){
		    $("#exampleInputDesc1").val("");
	  });
	  
	  $(document).on('change','#exampleInputEntr1',function(){
		    $.ajax({
		        url: "clientDetails/findByEntr",
		        type: 'POST',
		        cache: false,
		        dataType: 'json',
		        data:{idE:$(this).val()},
		        success: function (data, textStatus, jqXHR) {
		        	$('#exampleInputClient1 option').remove(); // clear all values 
		        	$('#exampleInputClient1').append('<option selected disabled>Choisir Client</option>');
		        	for(var i=0; i<data.length ; i++){
		        		$('#exampleInputClient1').append('<option value="'+data[i].id+'">'+data[i].nom+'</option>');
		        	}
				    
		            //console.log(data);
		        },
		        error: function (jqXHR, textStatus, errorThrown) {
		            console.log(textStatus);
		        }
		    });
	  });
		
	  
	  $(document).on('change','#updateEntr1',function(){
		    //console.log($(this).val());
		    //$("#exampleInputClient1").empty();
		    //$("#exampleInputClient1").append("<optiont value='2'>hello</optiont>");
		    $.ajax({
		        //url: "entrDetails/findById?idE="+idE,
		        url: "clientDetails/findByEntr",
		        type: 'POST',
		        cache: false,
		        dataType: 'json',
		        data:{idE:$(this).val()},
		        success: function (data, textStatus, jqXHR) {
		        	$('#updateClient1 option').remove(); // clear all values 
		        	$('#updateClient1').append('<option selected disabled>Choisir Client</option>');
		        	for(var i=0; i<data.length ; i++){
		        		$('#updateClient1').append('<option value="'+data[i].id+'">'+data[i].nom+'</option>');
		        	}
				    
		            //console.log(data);
		        },
		        error: function (jqXHR, textStatus, errorThrown) {
		            console.log(textStatus);
		        }
		    });
	  });
	  
	  
	  $(document).on('click','#entrDetails',function(){
		    let idE = $(this).parent().find('#idE').val();
		    //var idE = $(this).closest('tr').find('#idE').val();
		  	$.ajax({
		        //url: "entrDetails/findById?idE="+idE,
		        url: "entrDetails/findById",
		        type: 'POST',
		        cache: false,
		        dataType: 'json',
		        data:{idE:idE},
		        success: function (data, textStatus, jqXHR) {
		            //console.log(data);
		        	$("#teleE").text(data.tele);
		        	$("#libelleE").text(data.libelle);
		        	$("#emailE").text(data.email);
		        	$("#villeE").text(data.ville);
		        	$("#adresseE").text(data.adresse);
		        },
		        error: function (jqXHR, textStatus, errorThrown) {
		            console.log(textStatus);
		        }
		    });
		 });
		 
		 $(document).on('click','#contDesc',function(){
			  	$("#descContrat").html($(this).parent().find("#descC").val());
			 });
		    
});

