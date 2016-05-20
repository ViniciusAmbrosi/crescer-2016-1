String.prototype.replaceAll = function (search, replacement) {
    var target = this;
    return target.replace(new RegExp(search, 'g'), replacement);
};

var jogaDado = function () { return Math.floor((Math.random() * 10) + 1); }
var $frmArtista = $('#frmArtista');
var id = "";

$frmArtista.submit(function (e) {
    $('#album-cover').children().detach();
    var artista = $("#artista").val();
    var search = artista + "&type=artist";
    search = search.replaceAll(" ", "%20");
    $.ajax({ url: "https://api.spotify.com/v1/search?q=" + search, type: "GET" })
    .done(function (res) {
        if (artista === "Justin Bieber") {
            id = jogaDado > 8 ? "douchebag" : res.artists.items[0].id
        }
        else
            id = res.artists.items[0].id
        exibirAlbums("https://api.spotify.com/v1/artists/" + id + "/albums?limit=50");
    })
    .fail(function (res) {
        console.error(res);
        var criarSpanComErro = function (msg) { return $('<span>').text(msg).addClass('erro'); };
        $('#album-cover')
        .append(criarSpanComErro("Caro usuário, favor informar um artista."))
    });
    return e.preventDefault();
})
