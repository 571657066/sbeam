
/**
  * 自动加载规则流水信息
  */

window.onload = function () {

    $.ajax({
        type: 'GET',
        url: "/admin/list",
        contentType: "application/json;cherset=utf-8",
        dataType: "json",
        success: function (data){
        $('.table_node').empty()
    //取出后端传过来的list值
    var chargeRuleLogs = data.data
    //对list值进行便利
    $.each(chargeRuleLogs, function (index, n) {

        var rowTr = document.createElement('tr')
        //找到html的tr节点

        rowTr.className = "tr_node"
        var child =

            "<td><input type=\"checkbox\" id='chargeRuleLogs[index].id'></td>"
            +"<td>" + chargeRuleLogs[index].id +  "</td>"
            + "<td>" + chargeRuleLogs[index].adminName + "</td>"
            + "<td>" + chargeRuleLogs[index].password + "</td>"
            + "<td>"+"\t\t\t\t<td class=\"td-status\"><span class=\"label label-success radius\">已启用</span></td>\n"+"</td>"
            + "<td>" + "\t\t\t\t<td class=\"td-manage\"><a style=\"text-decoration:none\" onClick=\"admin_stop(this,'10001')\" href=\"javascript:;\" title=\"停用\"><i class=\"Hui-iconfont\">&#xe631;</i></a> <a title=\"编辑\" href=\"javascript:;\" onclick=\"admin_edit('管理员编辑','admin-add.html','1','800','500')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i></a> <a title=\"删除\" href=\"javascript:;\" onclick=\"admin_del(this,'1')\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6e2;</i></a></td>\n"+ "</td>"

        //将要展示的信息写入页面
        rowTr.innerHTML = child
        //将信息追加
        $(".table_node").append(rowTr)
    });
}
});
}