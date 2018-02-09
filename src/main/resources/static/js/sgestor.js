$(function() {

	$(".phone").intlTelInput({
		initialCountry : "auto",
		geoIpLookup : function(callback) {
			$.get('https://ipinfo.io', function() {}, "jsonp").always(function(resp) {
				var countryCode = (resp && resp.country) ? resp.country : "";
				callback(countryCode);
			});
		},
		utilsScript : "/build/js/utils.js" // just for formatting/placeholders etc
	});

	// update the hidden input on submit
	$("form").submit(function() {
		$("#hiddenPhone").val($("#phone").intlTelInput("getNumber"));
	});

	// update the hidden input on submit
	$("form").submit(function() {
		$("#hiddenCellPhone").val($("#cellPhone").intlTelInput("getNumber"));
	});

	$('.form_date').datetimepicker({
		pickTime : false,
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 2,
		forceParse : 0
	});
	
	$('#event_time').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'DD/MM/YYYY h:mm A'});
	
	 //color picker with addon
    $(".my-colorpicker2").colorpicker();
	
	//Date range picker with time picker
	$(".js-example-basic-multiple").select2();

	//Timepicker
	$(".timepicker").timepicker({
		showInputs : false,
		showMeridian : false
	});

	
	$('.js-remove-photo').on('click', function() {
		$('.js-person-photo').remove();
		//uploadDrop.removeClass('hidden');
		//inputNomeFoto.val('');
		//inputContentType.val('');
	});
	
	//DataTable
	
	$("#dataTable").dataTable();
    $('.example2').dataTable({
      "bPaginate": true,
      "bLengthChange": false,
      "bFilter": false,
      "bSort": true,
      "bInfo": true,
      "bAutoWidth": false
    });
    
  //iCheck for checkbox and radio inputs
    $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
      checkboxClass: 'icheckbox_minimal-blue',
      radioClass: 'iradio_minimal-blue'
    });
    
    
});

