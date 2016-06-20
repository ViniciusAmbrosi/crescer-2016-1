"use strict";

function IndexView(options) {
    options = options || {};
    this.botaoDeletar = options.botaoDeletar;
    this.botaoAlterar = options.botaoAlterar;
}

IndexView.prototype.registrar = function () {
    $(this.botaoDeletar.selector).click(function (e) {
        PessoasHelper.deletarPessoa(e.currentTarget.getAttribute('data-id'));
    }.bind(this));
    
    $(this.botaoAlterar.selector).click(function(e){
        PessoasHelper.alterarPessoa(e.currentTarget.getAttribute('data-id'));
    }.bind(this));
};


