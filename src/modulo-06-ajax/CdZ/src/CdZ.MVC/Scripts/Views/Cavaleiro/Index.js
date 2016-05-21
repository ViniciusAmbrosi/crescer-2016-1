'use strict';

var idUltimoCavaleiro = 0;

function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .then(
        function onSuccess(res) {
            console.log(res.data);
            var $cavaleiros = $('#cavaleiros');
            res.data.forEach(function (cava) {
                $cavaleiros.append(
                    $('<li>').append(cava.Nome)
                );
                idUltimoCavaleiro = cava.Id;
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
                $cavaleiros.append(
                    $('<li>').append(cava.Nome)
                );
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
        notificarUsuario(contagemCavaleiros);
    }
    else if (Notification.permission !== 'denied') {
        Notification.requestPermission(function (permission) {
            if (permission === "granted") {
                notificarUsuario(contagemCavaleiros);
            }
        });
    }
}

function notificarUsuario (qtd) {
    var notification = new Notification(contagemCavaleiros + "novos cavaleiros foram adicionados!");
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