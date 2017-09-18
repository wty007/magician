function del(deleteUrl, id) {

    if (confirm("是否要执行删除操作?")) {
        $.post({
            url: deleteUrl,
            data: {id: id},
            error: function (request) {
                alert("Connection error");
            },
            success: function (data) {
                console.log(data);
                $("#" + id).parent().remove();
            }
        });
    }
}

var afterFetchFunctions = new Array();

function fillData(params) {

    var defaultParams = {
        url: null, formId: 'form', params: {},
        afterFetchFunctions: afterFetchFunctions,
        afterFill: function (data) {
        }
    };

    var $params = $.extend(defaultParams, params);

    $.get({
        url: $params.url,
        data: $params.params,
        error: function (request) {
            alert("Connection error");
        },
        success: function (data) {
            for (prop in data) {

                var value = data[prop];

                if (value instanceof Object) {
                    $("#" + $params.formId + " [name='" + prop + ".id']")
                        .find("option[value='" + value.id + "']")
                        .attr("selected", true);

                    $("#" + $params.formId + " [name='" + prop + "']")
                        .find("option[value='" + value.id + "']")
                        .attr("selected", true);
                } else {
                    var element = $("#" + $params.formId + " [name=" + prop + "]");
                    var type = $(element).attr("type");

                    if (type == 'checkbox') {
                        var checked = false;
                        if (value > 0 || value == 'true' || value == true) {
                            checked = true;
                        }
                        element.attr('checked', checked);
                    } else {
                        element.val(value);
                    }
                }
            }

            //for (var i = 0; i < afterFetchFunctions.length; i++) {
            //    eval(afterFetchFunctions[i] + '(data)');
            //}

            for (var i = 0; i < $params.afterFetchFunctions.length; i++) {
                $params.afterFetchFunctions[i](data);
            }

            $params.afterFill(data);
        }
    });
}

function afterAjaxSave() {
    if (isTrue(getCookie("isAfterAjaxSaveRedirectToList"))) {
        window.location.href = "./list";
    } else {
        UI.tips("保存成功");
    }
}

//$(document).ready(function() {
//    var orderBy = $("#${id}").val().split(" ");
//    $(".sort-column").each(function(){
//        if ($(this).hasClass(orderBy[0])){
//            orderBy[1] = orderBy[1]&&orderBy[1].toUpperCase()=="DESC"?"down":"up";
//            $(this).html($(this).html()+" <i class=\"icon icon-arrow-"+orderBy[1]+"\"></i>");
//        }
//    });
//    $(".sort-column").click(function(){
//        var order = $(this).attr("class").split(" ");
//        var sort = $("#${id}").val().split(" ");
//        for(var i=0; i<order.length; i++){
//            if (order[i] == "sort-column"){order = order[i+1]; break;}
//        }
//        if (order == sort[0]){
//            sort = (sort[1]&&sort[1].toUpperCase()=="DESC"?"ASC":"DESC");
//            $("#${id}").val(order+" DESC"!=order+" "+sort?"":order+" "+sort);
//        }else{
//            $("#${id}").val(order+" ASC");
//        }
//        ${callback}
//    });
//});