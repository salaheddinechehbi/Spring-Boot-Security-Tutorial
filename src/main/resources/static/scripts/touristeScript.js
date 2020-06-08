

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
	      ville: {
	          required: true,
	        },
	        country: {
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
	      ville: {
	          required: "Please provide a ville",
	        },
	      country: {
	          required: "Please provide a country",
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
	  
	  
	  
	  $(document).on('click','#editTour',function(){
		    let id = $(this).parent().find('#idTour').val();
		    let tr = $(this).closest('tr');
		    $("#updateNom2").val($(tr).find('td').eq(0).text());
		    $("#updateEmail2").val($(tr).find('td').eq(1).text());
		    $("#updateTele2").val($(tr).find('td').eq(2).text());
		    $("#updateCountry2").val($(tr).find('td').eq(4).text());
		    $("#updateVille2").val($(tr).find('td').eq(3).text());
		    $('#example2 #idTour').val(id);
		    $('#update-modal #idT').val(id);
		  	console.log("ttttttttttttttt "+$('#update-modal #idT').val());
		 });
	  
	  //$(document).on('click','#updateEntr',function(){
		  	
		//  	$('#update-modal #idE').val($('#idEntr').val());
		  //	console.log("kjlllllll " + $('#update-modal #idE').val());
		 //});
	  
	  $(document).on('click','#deleteTour',function(){
		  	let id = $(this).parent().find('#idTour').val();
		  	$('#delete-modal #idT').val(id);
		 });

		$(document).on('click','#closeMod',function(){
		    $("#exampleInputNom1").val("");
		    $("#exampleInputEmail1").val("");
		    $("#exampleInputTele1").val("");
		    $("#exampleInputCountry1").val("");
		    $("#exampleInputVille1").val("");
		 });
	  
	  
});

