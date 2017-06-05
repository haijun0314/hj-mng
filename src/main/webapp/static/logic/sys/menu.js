var MenuUtil = {
    /********************加载登陆用户数据***********************************/
    loadLeftMenus: function() {

        AjaxRequest.httpPost("/sys/environment?loadUserMenus", {

        },
        function(result) {
            var template_leftMenu = Handlebars.compile($("#leftMenu-template").html());
            var datalist = result.data;
            $('#leftMenu_nav').append(template_leftMenu(datalist));
        });
    },
    /********************父类加载下拉框数据***********************************/
    loadParent: function() {

        AjaxRequest.httpPost("/sys/security?getMenuBarList&parentid=0", {

        },
        function(result) {
            var parent = $("#parent");
            $.each(result,
            function(idx, item) {
                parent.append('<option value=' + item.menuId + '> ' + item.menuName + '</option>');
            });

        });
    },
    /********************子类加载下拉框数据***********************************/
    loadSon: function() {
        var parent = $("#parent").val();
        $("#son").empty();
        var son = $("#son");
        son.append("<option value=''>请选择</option>");
        if (parent == null || parent == '') {
            return;
        }

        AjaxRequest.httpPost("/sys/security?getMenuBarList&parentid=" + parent, {

        },
        function(result) {

            $.each(result,
            function(idx, item) {
                son.append('<option value=' + item.menuId + '> ' + item.menuName + '</option>');
            });
        });

    },

};