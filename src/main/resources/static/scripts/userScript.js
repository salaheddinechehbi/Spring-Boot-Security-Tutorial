

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
	      role: {
	          required: true,
	        },
	      username: {
	          required: true,
	          minlength: 5
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
	      role: {
	          required: "Please provide a role",
	        },
	      username: {
	          required: "Please provide a login",
	          minlength: "Your login must be at least 5 characters long"
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
	  
	  
	  
	  $(document).on('click','#editUser',function(){
		    let id = $(this).parent().find('#idUser').val();
		    let tr = $(this).closest('tr');
		    $("#updateNom1").val($(tr).find('td').eq(0).text());
		    $("#updateEmail1").val($(tr).find('td').eq(1).text());
		    $("#updateTele1").val($(tr).find('td').eq(3).text());
		    $("#updateLogin1").val($(tr).find('td').eq(2).text());
		    $('#example2 #idUser').val(id);
		    $('#update-modal #idU').val(id);
		 });
	  
	  //$(document).on('click','#updateEntr',function(){
		  	
		//  	$('#update-modal #idE').val($('#idEntr').val());
		  //	console.log("kjlllllll " + $('#update-modal #idE').val());
		 //});
	  
	  $(document).on('click','#deleteUser',function(){
		  	let id = $(this).parent().find('#idUser').val();
		  	$('#delete-modal #idU').val(id);
		  	console.log($('#delete-modal #idU').val());
		 });

		$(document).on('click','#closeMod',function(){
		    $("#exampleInputLibelle1").val("");
		    $("#exampleInputEmail1").val("");
		    $("#exampleInputTele1").val("");
		    $("#exampleInputAdresse1").val("");
		    $("#exampleInputVille1").val("");
		 });
	  
	  
});



