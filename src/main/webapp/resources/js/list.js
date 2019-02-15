$(document).ready( function () {
var DatatablesBasicPaginations = {
    init: function() {
        $("#list_table").DataTable({
            responsive: !0,
            pagingType: "full_numbers"
        })
    }
};
jQuery(document).ready(function() {
    DatatablesBasicPaginations.init()
});
});