$.ajax({ url: "https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50", type: 'GET' })
    .done(function (res) {
        res.items.forEach(function (item) {
            var url = item.images[1].url;
            var imgAlbum = new Image();
            imgAlbum.src = url;
            imgAlbum.onload = function () {
                var $img = $(imgAlbum);
                $("#album-cover").append($('<div>').addClass("col-lg-3").addClass("col-md-6").addClass("col-xs-12").append($img));
            }
        });
    });
