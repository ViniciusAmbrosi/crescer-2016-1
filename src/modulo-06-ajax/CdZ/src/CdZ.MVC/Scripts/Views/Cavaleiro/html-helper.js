'use strict';

var htmlHelper = {}

htmlHelper.adicionarCavaleiroComBotoes = function (cava) {
    var $cavaleiros = $('#cavaleiros');
    var $liCavaleiro = $('<li>').append(cava.Nome);
    $cavaleiros.append($liCavaleiro);
    idUltimoCavaleiro = cava.Id;

    var $btnExcluir = $("<button>").attr('data-id-btn', cava.Id).addClass('btn btn-danger').addClass("btnExcluir");
    $liCavaleiro.append($btnExcluir);
    $btnExcluir.click(excluirCavaleiro);
    $btnExcluir.text("Excluir");

    var $btnEditar = $("<button>").attr('data-id-btn', cava.Id).addClass('btn btn-danger').addClass("btnEditar");
    $liCavaleiro.append($btnEditar);
    $btnEditar.click(editarCavaleiro);
    $btnEditar.text("Editar");
};

htmlHelper.gerarInputUrl = function () {
    var $novoInput = $('<input>').attr('name', 'Imagens.imagem.Url')
                               .attr('type', 'text')
                               .attr("id", "Imagens_imagem_Url")
                               .attr('placeholder', 'Ex: bit.ly/shiryu.png')
                               .addClass("form-control").addClass("text-box").addClass("single-line");
    return $('<li>').append($novoInput);
}

htmlHelper.gerarInputThumb = function () {
    var $novoInput = $('<input>').attr('name', 'Imagens.imagem.IsThumb')
                                 .attr('type', 'checkbox')
                                 .attr("id", "Imagens.imagem.IsThumb")
                                 .attr("checked", "checked")
                                 .attr("data-val", "true")
                                 .attr("data-val-required", "The IsThumb field is required.")
                                 .attr("value", "true");
    return $('<li>').append($novoInput).append($("<label>").attr("for", "Imagens_imagem_IsThumb").text("IsThumb"));
}

htmlHelper.gerarInputTexto = function () {
    var $novoInput = $('<input>').attr('name', 'Golpes.golpe.Nome')
                                 .attr('type', 'text')
                                 .attr("id", "Golpes.golpe.Nome")
                                 .attr('placeholder', 'Ex: Meteoro de pegasus')
                                 .addClass("form-control").addClass("text-box").addClass("single-line");
    return $('<li>').append($novoInput);
}
