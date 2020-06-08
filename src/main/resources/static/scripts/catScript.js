

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
	      libelle: {
	          required: true,
	        }
	    },
	    messages: {
	      libelle: {
	        required: "Please provide a libelle",
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
	  
	  
	  
	  $(document).on('click','#editCat',function(){
		    let id = $(this).parent().find('#idCat').val();
		    let tr = $(this).closest('tr');
		    $("#updateLibelle2").val($(tr).find('td').eq(0).text());
		    $('#example2 #idCat').val(id);
		    $('#update-modal #idC').val(id);
		  	console.log("ttttttttttttttt "+$('#update-modal #idC').val());
		 });
	  
	  //$(document).on('click','#updateEntr',function(){
		  	
		//  	$('#update-modal #idE').val($('#idEntr').val());
		  //	console.log("kjlllllll " + $('#update-modal #idE').val());
		 //});
	  
	  $(document).on('click','#deleteCat',function(){
		  	let id = $(this).parent().find('#idCat').val();
		  	$('#delete-modal #idC').val(id);
		 });

		$(document).on('click','#closeMod',function(){
		    $("#exampleInputLibelle1").val("");
		 });
	  
	  
});

