var goku = 'Goku';
typeof goku; //string

goku = 10;
typeof goku //number

goku = false;
typeof goku; //boolean

typeof Goku; //undefined

goku = null;
typeof goku; //object

goku = undefined;
typeof goku; //undefined

var goku = function(){console.log('Goku');};
typeof goku; //function

goku; //function() {console.log('Goku';)};

goku();//faz uma chamada da function em goku

goku = function(numero) {console.log(numero);};

goku();//nao exibe nada pois passou undefined

goku(3.14);//exibe 3.14

goku('3.14');//exibe 3.14

goku(true); //exibe true

goku({});//exibe Object {}

1+2;

1+'2'; //exibe '12'

1+2+'3'; //exibe '33'

'1' + 2 + 3; //exibe '123'

1+true; //exibe 2

var goku = {nome: 'Goku', idade:30};

goku; //Object{nome:'goku', idade:30}

goku.nome; //exibe "Goku"

goku.nome = 'Son Goku'; //atribui son goku ao nome

goku.filhos = ['Gohan', 'Goten']; //arraaaaaay

goku; //Object{nome:'goku', idade:30 Array[2]}

goku.filhos = ['Gohan', 'Goten',,,,,,];

goku.filhos = ['Gohan', 'Goten',,,,,,10,,,,];

typeof goku.nome; //string

typeof goku.idade; //number

typeof goku.filhos; //object

goku.filho.constructor; //funciton Array(){[native code]}

goku.filhos.constructor == Array; //true

false == '0'; //true

//nao é recomendado usar ==, pois tenta converter, logo, pode retornar verdades 'forçadas'

false === '0'; //false

10/false; //infinity

10/'2'; //5

10/'dois'; // Nan

NaN == NaN; //false

isNaN(10/'2'); //false

isNan(10/'dois'); //true

[1,2,3].constructor == Array; //true

[1,2,3] instanceof Array;//true

[1,2,3] instanceof Object; //true

[1,2,3].constructor == Object; //false

if(goku) {console.log('Ta definido');} else { console.log('Nao');}; //errado

if(typeof goku !== 'undefined') {console.log('Ta definido');} else { console.log('Nao');}; //forma correta, mesmo nao tendo a variavel nao da errado

function isDefined(obj){ return typeof obj !== 'undefined';};

function somar(a,b) { return a + b; };


//--------------------------------------------------------------------------------------------------------

function somar(a,b) {return a+b;};
var sub = function(a,b, fn) {fn(a-b)};
var funcoes = [somar(1,1), sub];
funcoes[1](3,2, function(res) {console.log('O resultado é: ', res)});

//ou

var imprimirResultado = function(res){console.log('O resultado é: ' + res)};
funcoes[1](3,2, imprimirResultado);

//------------------------------------------------------------------
var subRed = funcoes[1];
subRef(3,2, imprimirResultado);

var imprimirResultado = 'vegeta';
var sub = function(a,b, fn) {
  if(typeof fn == 'function') fn(a-b)};

function verificarFuncao(fn){ return typeof fn == 'function';};
  var sub = function(a,b, fn) {
    if(verificarFuncao(fn)) fn(a-b)};

var sub = function(){
  var a = arguments[0];
  var b = arguments[1];
  var fn = argumentes[2];
  if(verificarFuncao(fn)) fn (a-b);};


'use scrict'; //forçar erro pra declarar variavel errada

for(var i = 0, len =goku.gilhos.length; i < len, i++){
  console.log(goku.filhos[i]);
}

for(var i in goku){console.log(goku[i]);};
goku.filhos.forEach(function(e, index) {console.log(e), index;});
var imprimeFilho = function(e){console.log(e);};
goku.filhos.forEach(imprimeFilho);

imprimeFIlho = function()

goku.hasOwnProperty(asdasd); //retorna se tem tal coisa
