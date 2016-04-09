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
}
