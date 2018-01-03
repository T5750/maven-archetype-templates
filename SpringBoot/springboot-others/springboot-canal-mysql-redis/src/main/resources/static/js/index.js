;$(function () {
    $('#datatable').dataTable({"bPaginate": false, "bLengthChange": false, "bSort": false, "bInfo": false});
    $(".btn-add").click(function () {
        $("#tableName").attr("value", "");
        $("#cacheKey").attr("value", "");
        $("#modalform").attr("action", "/add");
        $('#myModal_02').modal({});
    });

    $("#btn-del-true").click(function () {
        location.href = "remove?tableName=" + $(this).attr("tableName");
    });
});

function alterf(tableName) {
    $("#modalform").attr("action", "/alter");
    $.get("/toAlter?tableName=" + tableName, function (data) {
        if (!$.isEmptyObject(data)) {
            $("#tableName").attr("value", data.tableName);
            $("#cacheKey").attr("value", data.cacheKey);
        }
    });
    $('#myModal_02').modal({});
}
function deletef(tableName) {
    $("#btn-del-true").attr("tableName", tableName);
    $('#myModal_03').modal({});
}

