//DaisyGame
function daisyGame(number){if(number % 2 === 0){ return 'Love me not'} else return 'Love me';};

//Maior Texto
function maiorText(palavras){
  var maior = "";
  for(var palavra in palavras){
      if(maior.length < palavras[palavra].length){
          maior = palavras[palavra];
      }
  }
  return maior;
  }

//Instrutor Querido
function imprime(e, fn){
  if(typeof fn === 'function'){
   for(var instrutor in e){
      fn(e[instrutor]);
   }
  }
  else{
    console.log('TypeError: second value is not a function');
  }
};

//Soma Diferentona
