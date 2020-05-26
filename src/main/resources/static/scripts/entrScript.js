

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
	  
	  
	  
	  $(document).on('click','#editEntr',function(){
		    let id = $(this).parent().find('#idEntr').val();
		    let tr = $(this).closest('tr');
		    $("#exampleInputLibelle1").val($(tr).find('td').eq(0).text());
		    $("#exampleInputEmail1").val($(tr).find('td').eq(1).text());
		    $("#exampleInputTele1").val($(tr).find('td').eq(2).text());
		    $("#exampleInputAdresse1").val($(tr).find('td').eq(3).text());
		    $("#exampleInputVille1").val($(tr).find('td').eq(4).text());
		    $("#addEntr").attr("disabled",true);
		    $("#updateEntr").attr("disabled",false);
		 });
	  
	  $(document).on('click','#deleteEntr',function(){
		  	let id = $(this).parent().find('#idEntr').val();
		  	$('#delete-modal #idE').val(id);
		 });

		$(document).on('click','#closeMod',function(){
		    $("#exampleInputLibelle1").val("");
		    $("#exampleInputEmail1").val("");
		    $("#exampleInputTele1").val("");
		    $("#exampleInputAdresse1").val("");
		    $("#exampleInputVille1").val("");
		    $("#addEntr").val('Ajouter');
		    $("#addEntr").attr("disabled",false);
		    $("#updateEntr").attr("disabled",true);
		 });
	  
	  
});

