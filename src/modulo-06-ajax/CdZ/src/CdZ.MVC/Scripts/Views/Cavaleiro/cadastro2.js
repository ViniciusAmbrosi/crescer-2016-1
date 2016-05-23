$(function () {

    var $frmEditarCavaleiro = $('#frmEditarCavaleiro');
    $frmEditarCavaleiro.submit(function (e) {
        debugger;
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
    var imgId = [];

    $('#imagens li').each(function () {
        var $url = $(this).find("input[name='Imagens.imagem.Url']").val();
        if ($url !== undefined)
            url.push($url);
    });

    $('#imagens li').each(function () {
        var $isThumb = $(this).find("input[name='Imagens.imagem.IsThumb']").val();
        if ($isThumb !== undefined)
            isThumb.push($isThumb);
    });

    $('#imagens li').each(function () {
        var $id = $(this).find("input[name='Imagens.imagem.Id']").val();
        if ($id !== undefined)
            imgId.push($id);
    });

    for (var i = 0; i < url.length; i++) {
        novasImagens.push({ id: imgId[i], url: url[i], isThumb: isThumb[i] });
    }

    var novosGolpes = [];
    var golpesId = [];
    var golpesNome = []
    $('#golpes li').each(function () {
        var $Id = $(this).find("input[name='Golpes.golpe.Id']").val();
        if ($Id !== undefined)
            golpesId.push($Id);
    });

    $('#golpes li').each(function () {
        var $Nome = $(this).find("input[name='Golpes.golpe.Nome']").val();
        if ($Nome !== undefined)
            golpesNome.push($Nome);
    });

    for (var i = 0; i < url.length; i++) {
        novosGolpes.push({ id: golpesId[i], Nome: golpesNome[i] });
    }

    return {
        Id: formData.get("Id"),
        Nome: formData.get('Nome'),
        TipoSanguineo: parseInt(formData.get('TipoSanguineo')),
        Imagens: novasImagens,
        DataNascimento: new Date(Date.UTC(2010, 9, 10)).toISOString(), //TODO: arrumar data
        AlturaCm: parseFloat(formData.get('AlturaCm')) * 100,
        PesoLb: parseFloat(formData.get('PesoLb')) * 2.20462262,
        Signo: parseInt(formData.get('Signo')),
        LocalNascimento: { Id: parseInt($("#LocalNascimento_Id").val()), Texto: $("#LocalNascimento_Texto").val() },
        LocalTreinamento: { Id: parseInt($("#LocalTreinamento_Id").val()), Texto: $("#LocalTreinamento_Texto").val() },
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
