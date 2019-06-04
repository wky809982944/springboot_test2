function getUser() {
    var user;
    $.ajax({
        url: '/user/getUser',
        type: "post",
        data: {},
        async: false,
        success: function (data) {
            user = data;
            username = data.username;
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
    return user;
}

