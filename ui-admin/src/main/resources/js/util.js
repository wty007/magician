function isEmpty(str) {
    return typeof (str ) == 'undefined' || str == '' || str == null;
}

function isNotEmpty(str) {
    return !isEmpty(str);
}

function lt(a, b) {
    return a < b;
}

function gt(a, b) {
    return a > b;
}

function isTrue(obj) {

    if (isEmpty(obj)) {
        return false;
    }

    return obj.toString().toLocaleLowerCase() == 'true';
}

function isFalse(obj) {
    return !isTrue(obj);
}

function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=")
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1
            c_end = document.cookie.indexOf(";", c_start)
            if (c_end == -1) c_end = document.cookie.length
            return unescape(document.cookie.substring(c_start, c_end))
        }
    }
    return ""
}

function setCookie(c_name, value, expiredays) {
    var exdate = new Date()
    exdate.setDate(exdate.getDate() + expiredays)
    document.cookie = c_name + "=" + escape(value) +
        ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
}

function appendElementError(element, error) {
    if (element.is(":checkbox") || element.is(":radio") || element.parent().is(".input-append")) {
        error.appendTo(element.parent().parent());
    } else {
        error.insertAfter(element.parent());
    }
}

$._messengerDefaults = {
    extraClasses: 'messenger-fixed messenger-theme-block messenger-on-top'
}

var UI = {
    tips: function (message) {
        $.globalMessenger().post(message);
        setTimeout(function () {
            $.globalMessenger().hideAll();
        }, 3000);
    }
};
