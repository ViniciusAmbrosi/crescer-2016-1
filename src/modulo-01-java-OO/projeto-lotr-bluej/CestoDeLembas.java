public class CestoDeLembas{
    private int lembas;
    int[] valores = new int[3];
    
    public CestoDeLembas(int lembas){
        this.lembas = lembas;
    }
    
    /**                                                                                                              Exercício 1 OO - L2 
     * 
     * Baseado na documentação não é necessário verificar os valores, independente de valor de n, logo, se é par, é verdadeiro. É possivel fazer qualquer combinação de pares para todo valor >= 3, desde que limite inicial para operações seja 1*/
     
    public boolean podeDividirEmPares(){
        boolean podeDividir = lembas > 3 && lembas <=100 && lembas % 2 == 0;
        return podeDividir ? true : false;
    }
    
    public boolean podeDividirEmParesUm(){ //Dividindo entre n personagens utilizando o maior numero par comum possivel por n(garantindo que MAXIMO de n <= 100) n = personagens
        int n = lembas; //personagens por par estabelecido
        int par = 1; //valor par minimo encontrado para n <= 100 inicializado em 1 because reasons
        int aux = 0;
        if(lembas < 4)
            return false;
        else if(lembas % 2 != 0)                                    /**Método OK, funciona da forma esperada, acha n personagens para valor par, sendo n <= 100 - MAIOR QTD DE PARES*/
            return false;
        do{ // é necessario remover do maximo n * par para encontrar restante dos valores, lembas - n*2 é um valor par, logo se n é < 99, n + resto == lembas, e resto é par e n == 100.
            n = (n/2) % 2 == 0 ? n/2 : n/2 - 1;
            par *= 2; //escala proporcionalemnte com n/2
            aux += n; //somatorio de valores obtidos
        }while(n > 99); 
        valores[0] = n; //qtd personagens
        valores[1] = par; //valor par para qtd personagens
        valores[2] = lembas - n * par; //ultimo valor par do sistema
        return true;
    }
    
    public boolean podeDividirEmParesDois(){ 
        int menor = lembas;
        int maior = lembas;
        int x = 0; //personagens
        int pow = 1;
        int n = lembas;
        if(lembas < 4)                                               /**Método OK, funciona da forma esperada, acha o menor numero de pares possíveis de det valor - MENOR QTD DE PARES*/
            return false;
        else if(lembas % 2 != 0)
            return false;
        do{ // se menor == maior, lembas - menor * x da a dif. se menor != maior, lembas = menor * (x/2) + maior * (x/2)
            x = (int)Math.pow(2,pow++); 
            if(menor % 2 != 0)
                menor = (int) menor/2;
            else
                menor = menor/2 % 2 == 0 ? n/2 : n/2 - 1; 
            if(maior % 2 != 0)
                maior = (int) maior/2;
            else
                maior = maior/2 % 2 == 0 ? n/2 : n/2 + 1; 
            n = menor;
        }while(n > 100); // no caso o valor fecha baseado em x * menor + x * maior caso != lembas, lembas - soma dos produtos.
        valores[0] = menor * x/2; //
        valores[1] = maior * x/2;
        valores[2] = lembas - (valores[0] + valores[1]);
        return true;
    }
    
    public boolean podeDividirEmParesTres(){
        int x = 0;
        int pow = 1;
        int n = lembas; // n = par 1 <= n >= 100
        int aux = 0;
        if(lembas < 4)                                               /**Método OK, funciona da forma esperada, acha x personagens para par n, sendo 1 < n <= 100 - MAIOR PAR < 100*/
            return false;
        else if(lembas % 2 != 0)
            return false;
        do{
            x = (int)Math.pow(2,pow++);
            n = (n/2) % 2 == 0 ? n/2 : n/2 - 1;
            aux += n; //somatorio de valores obtidos
        }while(n > 99);
        valores[0] = x;
        valores[1] = n;
        valores[2] = lembas - n * x;
        return true;
    }
}
