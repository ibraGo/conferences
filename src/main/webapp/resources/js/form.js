$(document).ready(function() {
	var BootstrapDatepicker = {
		init : function() {
			$(".data-field").datepicker({
				format : "yyyy-mm-dd"
			}),
			$(".datetime-field").datetimepicker({
	            todayHighlight: !0,
	            autoclose: !0,
	            format: "yyyy-mm-dd hh:ii:ss"
	        })
		}
	};
	jQuery(document).ready(function() {
		BootstrapDatepicker.init()
	});
});