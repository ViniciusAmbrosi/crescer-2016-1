String.prototype.replaceAll = function (search, replacement) {
    var target = this;
    return target.replace(new RegExp(search, 'g'), replacement);
};

var $frmArtista = $('#frmArtista');

$frmArtista.submit(function (e) {
    var search = $("#artista").val() + "&type=artist";
    search = search.replaceAll(" ", "%20");
    var id;
    $.ajax({ url: "https://api.spotify.com/v1/search?q=" + search, type: "GET" })
    .done(function (res) {
        id = res.artists.items[0].id
        $.ajax({ url: "https://api.spotify.com/v1/artists/" + id + "/albums?limit=50", type: "GET" })
            //TODO: refatorar
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
        });
    });
    return e.preventDefault();
})
