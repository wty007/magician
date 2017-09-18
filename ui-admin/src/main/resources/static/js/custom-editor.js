var editorParam = {
    //这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
    toolbars: [['FullScreen', 'Source', 'Undo', 'Redo', 'Bold', 'test']],
    //focus时自动清空初始化时的内容
    autoClearinitialContent: true,
    //关闭字数统计
    wordCount: false,
    //关闭elementPath
    elementPathEnabled: false
};



//    var briefDescriptionEditor = UE.getEditor('briefDescription', editorParam);
//    var introductionEditor = UE.getEditor('introduction', editorParam);
//    var trafficGuideEditor = UE.getEditor('trafficGuide', editorParam);
//    var buyTicketNotesEditor = UE.getEditor('buyTicketNotes', editorParam);
//    var characteristicShoppingEditor = UE.getEditor('characteristicShopping', editorParam);
//    var specialtyFoodEditor = UE.getEditor('specialtyFood', editorParam);

function customFill(data) {

    if (!editorProperties) {
        editorProperties = [];
    }

    for (var i = 0; i < editorProperties.length; i++) {
        eval('var ' + editorProperties[i] + 'Editor = UE.getEditor("' + editorProperties[i] + '",editorParam);');
    }

    for (var prop in data) {
        var evalString = 'if (';
        for (var i = 0; i < editorProperties.length; i++) {
            evalString += 'prop == "' + editorProperties[i] + '" ';
            if (i < editorProperties.length - 1) {
                evalString += ' || ';
            }
        }
        evalString += ')';
        evalString += '{';
        evalString += prop + 'Editor.ready(function () {'
            + prop + 'Editor.setContent("' + data[prop] + '");'
            + '});'
        evalString += '}';
        eval(evalString);

//            if (prop == 'briefDescription' || prop == 'introduction' || prop == 'trafficGuide'
//                    || prop == 'buyTicketNotes' || prop == 'characteristicShopping' || prop == 'specialtyFood') {
//                eval(prop + 'Editor.ready(function () {'
//                        + prop + 'Editor.setContent("' + data[prop] + '");'
//                        + '});');
//            }

    }
}