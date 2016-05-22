'use strict';

var htmlHelper = {}

htmlHelper.adicionarCavaleiroComBotoes = function (cava) {
    var $cavaleiros = $('#cavaleiros');
    var $liCavaleiro = $('<li>').append(cava.Nome);
    $cavaleiros.append($liCavaleiro);
    idUltimoCavaleiro = cava.Id;
    var $btnExcluir = $("<button>").attr('data-id-btn', cava.Id).addClass('btn btn-danger');
    $liCavaleiro.append($btnExcluir);
    $btnExcluir.click(excluirCavaleiro);
    $btnExcluir.text("Excluir");
};