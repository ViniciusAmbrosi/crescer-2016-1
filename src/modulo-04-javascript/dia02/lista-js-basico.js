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
function fiboSum(number) {
  if (number == 0) {
    return 0;
  }
  if (number <= 2) {
    return 1;
  }
  return fiboSum(number - 1) + fiboSum(number - 2);
}

//queroCafe
function queroCafe(mascada, precos) {
  var precosAteMascada = " ";
  precos.sort();
  for (var i in precos) {
    if (precos[i] <= mascada) {
      precosAteMascada += precos[i].toString() + ",";
    }
  }
  return precosAteMascada;
}

//variosTipos ---------------- Deve ter uma forma mais facil!!!!
function contarPorTipo(obj, tipo){
    var soma = 0;
    var tipoValidacao = 0;
    if(tipo === 'null'){
       tipoValidacao = 3;
    }
    if(tipo === 'array'){
       tipoValidacao = 2;
    }
    if(tipo === 'object'){
       tipoValidacao = 1;
    }
    for(var atributo in obj){
       if(tipoValidacao === 1){
          if(obj[atributo].constructor === Object){
              soma++;
          }
       }
       else if(tipoValidacao === 2){
          if(obj[atributo].constructor === Array){
              soma++;
          }
       }
       else if(tipoValidacao ===3){
          if(obj[atributo] === null && typeof obj[atributo] === "object"){
              soma++;
          }
       }
       else
          if(typeof obj[atributo] === tipo){
              soma++;
          }
    }
    return soma;
}
//Exercício 8
/* O motivo de retornar Son undefined é que, na atribuição - var gohan = 'Son ' + gohan; - se declara uma variavel do tipo local gohan, essa sem valor. A mesma é utilizada na concatenação.
   Se o valor de gohan fosse passado por parametro e utilizado então na função, tal erro nao aconteceria.*/
