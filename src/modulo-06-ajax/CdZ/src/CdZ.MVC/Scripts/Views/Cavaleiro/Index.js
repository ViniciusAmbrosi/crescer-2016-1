'use strict';

var idUltimoCavaleiro = 0;

//TODO: remover repetição de código ao inserir cavaleiro / botao na tela
function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .then(
        function onSuccess(res) {
            console.log(res.data);
            var $cavaleiros = $('#cavaleiros');
            res.data.forEach(function (cava) {
                var $liCavaleiro = $('<li>').append(cava.Nome);
                $cavaleiros.append($liCavaleiro);
                idUltimoCavaleiro = cava.Id;
                var $btnExcluir = $("<button>").attr('data-id-btn', cava.Id).addClass('btn btn-danger');
                $liCavaleiro.append($btnExcluir);
                $btnExcluir.click(excluirCavaleiro);
                $btnExcluir.text("Excluir");
            });
        },
        function onError(res) {
            console.error(':(');
            console.error(res);

            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
            .append(criarSpanComErro(res.status))
            .append($('<br>'))
            .append(criarSpanComErro(res.statusText));
        }
    )
    .always(function (res) {
        console.log('acabouuuuuuuu');
    });
};

carregarDadosNaPagina();

function registrarEventoDoBotao() {
    $('#btnCriar').click(function () {

        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: {
                Nome: 'Xiru ' + new Date().getTime(),
                AlturaCm: 187,
                Signo: 7,
                TipoSanguineo: 1,
                DataNascimento: new Date(Date.UTC(2010, 9, 10)).toISOString(),
                Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
                LocalNascimento: {
                    Texto: 'Beijing'
                },
                LocalTreinamento: {
                    Texto: '5 picos de rosan'
                },
                Imagens: [{
                    Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
                    IsThumb: true
                }, {
                    Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
                    IsThumb: false
                }]
            }
        });

    });
};

registrarEventoDoBotao();

var contagemCavaleiros = 0;
setInterval(function atualizarTela() {
    contagemCavaleiros = 0;
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .done(function (res) {
        var $cavaleiros = $('#cavaleiros');
        res.data.forEach(function (cava) {
            if (cava.Id > idUltimoCavaleiro) {
                $liCavaleiro = $('<li>').append(cava.Nome);
                $cavaleiros.append($liCavaleiro);
                var $btnExcluir = $('<button>').attr('data-id-btn', cava.Id).addClass('btn btn-small btn-danger');
                $btnExcluir.insertAfter($liCavaleiro);
                $btnExcluir.click(excluirCavaleiro);
                idUltimoCavaleiro = cava.Id;
                contagemCavaleiros++;
            }
        });
        if(contagemCavaleiros > 0)
            validaNotificacao();
    });
}, 5000)

function validaNotificacao() {
    if (!("Notification" in window)) {
        alert("Essa tentativa de browser não suporta notificações!!!!");
    }
    else if (Notification.permission === "granted") {
        notificarUsuario(contagemCavaleiros + "novos cavaleiros foram adicionados!");
    }
    else if (Notification.permission !== 'denied') {
        Notification.requestPermission(function (permission) {
            if (permission === "granted") {
                notificarUsuario(contagemCavaleiros + "novos cavaleiros foram adicionados!");
            }
        });
    }
}

function notificarUsuario (msg) {
    var notification = new Notification(msg);
}

function excluirCavaleiro() {
    var idCavaleiroASerRemovido = parseInt($(this).attr('data-id-btn'));
    $.ajax({ url: "/Cavaleiro/Delete/" + idCavaleiroASerRemovido, type: "DELETE" })
    .done
    {
        notificarUsuario("Cavaleiro de ID 'idCavaleiroASerRemovido' Excluído com sucesso");
    }

}
//setInterval(atualizarTela, 5000); //executa funçao a cada 5 segundos

/*.done(function (res) {
    console.log(res.data);
        var $cavaleiros = $('#cavaleiros');
        res.data.forEach(function (cava) {
            $cavaleiros.append(
                $('<li>').append(cava.Nome)
            );
        });
})
.fail(function (res) {
    console.error(':(');
    console.error(res);

    var criarSpanComErro = function (msg) {
        return $('<span>').text(msg).addClass('erro');
    };

    $('#feedback')
    .append(criarSpanComErro(res.status))
    .append($('<br>'))
    .append(criarSpanComErro(res.statusText));
});*/