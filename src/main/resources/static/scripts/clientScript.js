

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
	      nom: {
	          required: true,
	        },
	      entreprise: {
	          required: true,
	        },
	      fonction: {
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
	      nom: {
	        required: "Please provide a name",
	      },
	      fonction: {
	          required: "Please provide a fonction",
	        },
	      entreprise: {
	          required: "Please provide a entreprise",
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
	  
	  
	  
	  $(document).on('click','#editClient',function(){
		    let id = $(this).parent().find('#idClient').val();
		    let tr = $(this).closest('tr');
		    $("#updateNom2").val($(tr).find('td').eq(0).text());
		    $("#updateEmail2").val($(tr).find('td').eq(1).text());
		    $("#updateTele2").val($(tr).find('td').eq(2).text());
		    $("#updateFonction2").val($(tr).find('td').eq(3).text());
		    $("#updateEntreprise2").val($(tr).find('td').eq(4).text());
		    $('#example2 #idClient').val(id);
		    $('#update-modal #idCl').val(id);
		  	console.log("ttttttttttttttt "+$('#update-modal #idCl').val());
		 });
	  
	  //$(document).on('click','#updateEntr',function(){
		  	
		//  	$('#update-modal #idE').val($('#idEntr').val());
		  //	console.log("kjlllllll " + $('#update-modal #idE').val());
		 //});
	  
	  $(document).on('click','#deleteClient',function(){
		  	let id = $(this).parent().find('#idClient').val();
		  	$('#delete-modal #idCl').val(id);
		 });

		$(document).on('click','#closeMod',function(){
		    $("#exampleInputNom1").val("");
		    $("#exampleInputEmail1").val("");
		    $("#exampleInputTele1").val("");
		    $("#exampleInputFonction1").val("");
		    $("#exampleInputEntreprise1").val("");
		 });
	  
	  
});

