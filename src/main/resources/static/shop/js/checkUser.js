function checkUser() {
    var username;
    $.ajax({
        url : '/user/checkUser',
        type : "post",
        data : {},
        async : false,
        success: function (data) {
            username = data.username;
            var password = data.password;
            if (username != null) {
                var loginBar = $("#loginBar");
                loginBar.empty();
                loginBar.append(" <div class=\"menu-hd\">\n" +
                    "<a href=\"#\" target=\"_top\" class=\"h\">" + username + "</a>\n" +
                    "<a href=\"#\" target=\"_top\">欢迎您</a>\n" +
                    "</div>");
            }
        }

    });
    return username;

}

