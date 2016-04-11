import java.util.*;

public class HobbitContador{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
        int produtoPares= 1; 
        int mmcPares= 0;
        int produtosMenosMmc = 0;
        if(arrayDePares == null) 
            return 0 ;
        while(arrayDePares.contains(null)) //retira pares nulos
            arrayDePares.remove(null);
        for(ArrayList<Integer> pares : arrayDePares){
            int primeiroNumero = pares.get(0);
            int segundoNumero = pares.get(1);
            mmcPares = mmc(primeiroNumero, segundoNumero);
            produtoPares = primeiroNumero * segundoNumero;
            produtosMenosMmc += produtoPares - mmcPares;
        } 
        return produtosMenosMmc;
    }
    
    private int mmc (int a, int b){
        if(b == 0)
            return 0;
        int aux = a;
        while(a % b != 0) 
            a += aux;
        return a;
    }    
    
    public int obterMaiorMultiploDeTresAte(int numero){ 
        int maior = 0; //retorna maior, logo nao é necessario ArrayList
        for (int i = 3; i <= numero; i += 3){ //começar com i em 3, já que se i < 3 nao vai ser multiplo do mesmo. Variavel utilizada como parametro invalida.
            if (i % 3 == 0 && i > maior){ //nao verificava se o valor era maior, e alocava todos multiplos de 3 em um arrayList
                maior = i;
                //nao é necessario utilizar continue;
            }
        }
        return maior;
    }
    
    public ArrayList<Integer> obterMultiplosDeTresAte(int numero){
        ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0));
        for (int i = 3; i <= numero; i += 3){ //otimiza laço com i = 3 e somando mais 3 a i. Variavel utilizada como parametro invalida.
            if (i % 3 == 0) //break sairia do laço se i % 3 fosse zero
            multiplos.add(i);
        }
        return multiplos;
    }
}
