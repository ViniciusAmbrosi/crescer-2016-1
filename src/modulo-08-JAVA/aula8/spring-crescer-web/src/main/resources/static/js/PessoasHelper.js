"use strict";

var PessoasHelper = {};

PessoasHelper.deletarPessoa = function (id) {
    return $.ajax({
        url: "/Pessoa?id=" + id,
        type: 'DELETE'
    }).done(function(res) {
        $('#tabela-pessoa').empty();
        $('#tabela-pessoa').append(res);
    });;
};

PessoasHelper.alterarPessoa = function (id) {
    return $.ajax({
        url: "Pessoa/Update?id=" + id,
        type:'GET'
    }).done(function(res) {
        $('#form-pessoa').empty();
        $('#form-pessoa').append(res);
    });
};