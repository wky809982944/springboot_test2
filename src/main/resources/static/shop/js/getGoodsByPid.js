function getGoodsByPid(pid) {
    var Goods;
    $.ajax({
        url: '/goods/query',
        type: "post",
        data: {
            pid:pid
        },
        async: false,
        success: function (data) {
            Goods = data;
        }

    });
    return Goods;
}

