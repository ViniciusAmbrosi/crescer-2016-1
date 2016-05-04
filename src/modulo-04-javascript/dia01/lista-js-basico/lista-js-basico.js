//DaisyGame
function daisyGame(number) { if (number % 2 === 0) { return 'Love me not' } else return 'Love me'; };

//Maior Texto
function maiorTexto(palavras) {
  var maior = "";
  for (var palavra in palavras) {
    if (maior.length < palavras[palavra].length) {
      maior = palavras[palavra];
    }
  }
  return maior;
}

//Instrutor Querido
function imprime(e, fn) {
  if (typeof fn === 'function') {
    for (var instrutor in e) {
      fn(e[instrutor]);
    }
  }
  else {
    console.log('TypeError: second value is not a function');
  }
};

//adicionar Diferentona
function adicionar(numeroUm) {
  return function (numeroDois) {
    return numeroUm + numeroDois;
  };
}

//fibona
var fibonacci = function (n) {
  if (n === 1 || n === 2) return 1;
  return fibonacci(n - 1) + fibonacci(n - 2);
};

var fiboSum = function (n) {
  if (n === 1) return 1;
  return fibonacci(n, true) + fiboSum(n - 1, true);
}


//queroCafe
function queroCafe(mascada, precos) {
  precos.sort(function (a, b) { return a > b; });
  for (var i = precos.length - 1; precos[i] > mascada; i--) {
    precos.pop(precos[i]);
  }
  return precos.toString();
}

//variosTipos 
function contarPorTipo(obj, tipo) {
  function getType(v) {
    return v === null ? 'null' : typeof v !== 'undefined' && v.constructor === Array ? 'array' : typeof v;
  }

  var count = 0;
  for (var campo in obj) {
    if (getType(obj[campo]) === tipo) count++;
  }

  return count;
}
//Exercício 8
/* O motivo de retornar Son undefined é que, na atribuição - var gohan = 'Son ' + gohan; - se declara uma variavel do tipo local gohan, essa sem valor. A mesma é utilizada na concatenação.
   Se o valor de gohan fosse passado por parametro e utilizado então na função, tal erro nao aconteceria.*/
