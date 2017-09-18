function initMenu() {
    var menuHtml = '<div class="container-fluid"><div class="navbar-header"><button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span>    <span class="icon-bar"></span>        <span class="icon-bar"></span>        <span class="icon-bar"></span>        </button>        <a class="navbar-brand" href="' + ctx + '">后台管理</a>        </div>        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">        ' +
        '<ul class="nav navbar-nav">  ';

    for (var i = 0; i < menu.length; i++) {

        if (menu[i].children) {
            menuHtml += '<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">' + menu[i].name + ' <span class="caret"></span></a>';

            menuHtml += '<ul class="dropdown-menu">';
            for (var j = 0; j < menu[i].children.length; j++) {
                menuHtml += getMenuA(menu[i].children[j]);
            }
            menuHtml += '</ul></li>';
        } else {
            menuHtml += getMenuA(menu[i]);
        }
    }

    menuHtml += ' </ul>   </div><!-- /.navbar-collapse -->    </div><!-- /.container-fluid -->';
    $(".navbar").html(menuHtml);
}

function getMenuA(obj) {
    return '<li><a href="/' + obj.url + '">' + obj.name + '</a></li>';
}

var menu = [
    {url: 'hotel/list', name: '酒店列表'},
    {url: 'line/list', name: '线路列表'},
    {url: 'scenery/list', name: '景点列表'},
    {name: '会员列表', url: 'member/list'},
    {name: '签证列表', url: 'visa/list'},
    {name: '数据字典', url: 'dict/list'},
    {
        name: '配置',
        children: [
            {url: 'config', name: '操作习惯'},
            {url: 'hotel/service/list', name: '酒店服务列表'},
            {url: 'hotel/service/category/list', name: '酒店服务分类列表'}
        ]
    }
    /*
     {
     name: '怪物',
     children: [
     {name: '怪物数据', url: 'monster'},
     ]
     }*/
];

$(document).ready(function () {
    initMenu();
});