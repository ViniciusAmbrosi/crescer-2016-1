'use strict';

describe('Ex 1. Doadores de sangue', function () {
  it('obterDoadores retorna cavaleiros com tipo sanguíneo O', function () {
    var doadores = JSON.parse('[{"id":5,"nome":"Aiolia","dataNascimento":"1967-08-16T03:00:00.000Z","alturaCm":185,"pesoLb":187.392923,"signo":"Leão","tipoSanguineo":"O","localNascimento":"Grécia","localTreinamento":"Santuário, Grécia","golpes":["Cápsula do Poder","Pata do Leão","Relâmpago de Plasma"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14900613/c4ba42f0-0d67-11e6-9c0e-e79c2278ab0b.png","isThumb":true}]},{"id":9,"nome":"Aiolos","dataNascimento":"1960-11-30T03:00:00.000Z","alturaCm":187,"pesoLb":187.392923,"signo":"Sagitário","tipoSanguineo":"O","localNascimento":"Grécia","localTreinamento":"Santuário, Grécia","golpes":["Trovão Atômico","Flecha da Justiça"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14901061/e5fe3b90-0d69-11e6-9a78-2449055be1fa.png","isThumb":true}]},{"id":12,"nome":"Afrodite","dataNascimento":"1965-03-10T03:00:00.000Z","alturaCm":183,"pesoLb":158.732829,"signo":"Peixes","tipoSanguineo":"O","localNascimento":"Suécia","localTreinamento":"Groelândia","golpes":["Rosas Diabólicas Reais","Rosas Piranhas","Rosa Branca"],"imagens":[{"url":"https://cloud.githubusercontent.com/assets/526075/14901259/f4a0b3ca-0d6a-11e6-89b1-59855cabc43d.png","isThumb":true}]}]');
    expect(doadores).toEqual(obterDoadores());
  });
});

describe('Ex 2. Cavaleiro Com Mais Golpes', function () {
  it('Cavaleiro com mais golpes retorna cavaleiro com mais golpes', function () {
    expect(goldSaints[5]).toEqual(obterCavaleiroComMaisGolpes());
  });
});