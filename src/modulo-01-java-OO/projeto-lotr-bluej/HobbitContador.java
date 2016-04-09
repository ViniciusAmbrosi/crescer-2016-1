import java.util.*;

public class HobbitContador{
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
        int produtoPares= 1; 
        int mmcPares= 0;
        int produtosMenosMmc = 0;
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
        int aux = a;
        while(a % b != 0) 
            a += aux;
        return a;
    }    
}
