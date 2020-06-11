

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
		    let id = $(this).parent().find('#idEntr').val();
		    let tr = $(this).closest('tr');
		    $("#updateDateS2").val($(tr).find('td').eq(0).text());
		    $("#updateDateD2").val($(tr).find('td').eq(1).text());
		    $("#updateDateF2").val($(tr).find('td').eq(2).text());
		    $('#example2 #idContrat').val(id);
		    $('#update-modal #idCt').val(id);
		  	console.log("ttttttttttttttt "+$('#update-modal #idCt').val());
		 });
	  
	  $(document).on('click','#deleteContrat',function(){
		  	let id = $(this).parent().find('#idContrat').val();
		  	$('#delete-modal #idCt').val(id);
		 });

	  $(document).on('click','#closeMod',function(){
		    $("#exampleInputDesc1").val("");
	  });
	  
	  $(document).on('change','#exampleInputEntr1',function(){
		    console.log($(this).val())
	  });
	  
});

