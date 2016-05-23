$(function () {

    var $frmEditarCavaleiro = $('#frmEditarCavaleiro');
    $frmEditarCavaleiro.submit(function (e) {
        var cavaleiro = converterFormParaCavaleiro($frmEditarCavaleiro);
        enviarCavaleiroParaServidor(cavaleiro);
        $frmEditarCavaleiro[0].reset();
        return e.preventDefault();
    });

    $('#btnAdicionarImg').click(function () {
        var $inputUrl = htmlHelper.gerarInputUrl();
        var $inputThumb = htmlHelper.gerarInputThumb();
        $('#imagens').append($inputUrl);
        $('#imagens').append($inputThumb);
    });

    $('#btnAdicionarGolpe').click(function () {
        var $inputTexto = htmlHelper.gerarInputTexto();
        $('#golpes').append($inputTexto);
    });
});


function converterFormParaCavaleiro($form) {
    var formData = new FormData($form[0]);
    var novasImagens = [];
    var url = [];
    var isThumb = [];

    $('#imagens li').each(function () {
        var $url = $(this).find("input[name='Imagens.imagem.Url']").val();
        if($url !== undefined)
            url.push($url);
    });

    $('#imagens li').each(function () {
        var $isThumb = $(this).find("input[name='Imagens.imagem.IsThumb']").val();
        if ($isThumb !== undefined)
            isThumb.push($isThumb);
    });

    for (var i = 0; i < url.length; i++) {
        novasImagens.push({ url: url[i], isThumb: isThumb[i] });
    }

    var novosGolpes = [];
    $('#golpes li').each(function () {
        novosGolpes.push($(this).find("input[name='Golpes.golpe']").val());
    });

    return {
        Id: formData.get("Id"),
        Nome: formData.get('Nome'),
        TipoSanguineo: parseInt(formData.get('TipoSanguineo')),
        Imagens: novasImagens,
        DataNascimento: new Date(Date.UTC(2010, 9, 10)).toISOString(), //TODO: arrumar data
        AlturaCm: parseFloat(formData.get('AlturaCm')) * 100,
        PesoLb: parseFloat(formData.get('PesoLb')) * 2.20462262,
        Signo: parseInt(formData.get('Signo')),
        LocalNascimento: formData.get('LocalNascimento'),
        LocalTreinamento:  formData.get('LocalTreinamento'),
        Golpes: novosGolpes
    };
}

function enviarCavaleiroParaServidor(cavaleiro) {
    $.ajax({
        url: urlCavaleiroPost,
        type: 'POST',
        data: cavaleiro
    });
}