"use strict";

var PessoasHelper = {};

PessoasHelper.deletarPessoa = function (id) {
    return $.ajax({
        url: "/Pessoa?id=" + id,
        type: 'DELETE'
    });
};