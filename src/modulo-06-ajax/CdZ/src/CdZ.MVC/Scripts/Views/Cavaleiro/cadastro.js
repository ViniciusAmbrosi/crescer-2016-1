'use strict';

$(function () {

    var $frmNovoCavaleiro = $('#frmNovoCavaleiro');
    $frmNovoCavaleiro.submit(function (e) {
        var cavaleiro = converterFormParaCavaleiro($frmNovoCavaleiro);
        enviarCavaleiroParaServidor(cavaleiro);
        $frmNovoCavaleiro[0].reset();
        return e.preventDefault();
    });

    $('#btnAdicionarImg').click(function () {
        var $novoLi = gerarElementoLiComInputs();
        $('#novasImagens').append($novoLi);
    });

    $('#btnAdicionarGolpe').click(function () {
        $('#novosGolpes').append(gerarElementoLiComInputTexto());
    });
});


//TODO: revisar onde colocar esse ajax
function enviarCavaleiroParaServidor(cavaleiro)
{
    $.ajax({
        url: urlCavaleiroPost,
        type: 'POST',
        data: cavaleiro 
    });
}

function converterFormParaCavaleiro($form) {
    var formData = new FormData($form[0]);
    var novasImagens = [];
    $('#novasImagens li').each(function () {
        novasImagens.push({
            url: $(this).find('input[name=urlImagem]').val(),
            isThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });
    var novosGolpes = [];
    $('#novosGolpes li').each(function (i) {
        novosGolpes.push($(this).find('input[name=golpe]').val());
    });

    return {
        Nome: formData.get('nome'),
        TipoSanguineo: parseInt(formData.get('tipoSanguineo')),
        Imagens: novasImagens,
        DataNascimento: (Date.UTC(formData.get("txtAnoNascimento"), formData.get("txtMesNascimento"), formData.get("txtDiaNascimento")) || new Date(Date.UTC(2010, 9, 10))).toISOString(),
        AlturaCm: parseFloat(formData.get('alturaMetros')) * 100,
        PesoLb: parseFloat(formData.get('pesoKg')) * 2.20462262,
        Signo: parseInt(formData.get('signo')),
        LocalNascimento: formData.get('localNascimento'),
        LocalTreinamento: formData.get('localTreinamento'),
        Golpes: novosGolpes
    };
}
    function gerarElementoLiComInputs() {
        var $novoTxt = $('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: bit.ly/shiryu.png');
        var $novoCheckbox =
          $('<label>').append($('<input>')
            .attr('type', 'checkbox')
            .attr('name', 'isThumb')
            .attr('checked', 'checked')
          ).append('É thumbnail?');
        return $('<li>').append($novoTxt).append($novoCheckbox);
    };

    function gerarElementoLiComInputTexto() {
        var $novoTxt = $('<input>').attr('name', 'golpe').attr('type', 'text').attr('placeholder', 'Ex: Pó de diamante');
        return $('<li>').append($novoTxt);
    }