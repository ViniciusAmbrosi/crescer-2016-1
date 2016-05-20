function exibirAlbums(caminho) {
    $.ajax({ url: caminho, type: "GET" })
        .done(function (res) {
            res.items.forEach(function (item) {
                var url = item.images[1].url;
                var imgAlbum = new Image();
                imgAlbum.src = url;
                imgAlbum.onload = function () {
                    var $img = $(imgAlbum);
                    $("#album-cover").append($('<div>').addClass("col-lg-3").addClass("col-md-4").addClass("col-xs-6").append($img));
                };
            });
        })
        .fail(function (res) {
            console.error(res);
            var criarSpanComErro = function (msg) { return $('<span>').text(msg).addClass('erro'); };
            $('#album-cover')
            .append(criarSpanComErro("Caro usuário, devido a um erro <" + res.status + ">, não foi possível pesquisar por <" + id + ">."))
        });
};