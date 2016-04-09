import java.util.*;

public class HobbitContador{
    //arrayDePares.get(0).get(0)
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
        int produtoPares= 1; 
        int mmcPares= 0;
        int produtosMenosMmc = 0;
        for(int i = 0; i < arrayDePares.size(); i++){
            produtoPares = arrayDePares.get(i).get(0) * 
                           arrayDePares.get(i).get(1); //guarda produto dos pares
            mmcPares = mmc(arrayDePares.get(i).get(0), 
                           arrayDePares.get(i).get(1));
            produtosMenosMmc += produtoPares - mmcPares;
        }  
        return produtosMenosMmc;
    }
    
    public int mmc (int a, int b){
        int aux = a;
        while(a % b != 0) 
            a += aux;
        return a;
    }    
    //método de diferença simplificado para pares utilizando forEach
    public int calcularDiferencaComForEach(ArrayList<ArrayList<Integer>> arrayDePares){
        int produtoPares= 1; 
        int mmcPares= 0;
        int produtosMenosMmc = 0;
        for(ArrayList<Integer> pares : arrayDePares){
            mmcPares = mmc(pares.get(0), pares.get(1));
            produtoPares = pares.get(0) * pares.get(1);
            produtosMenosMmc += produtoPares - mmcPares;
        } 
        return produtosMenosMmc;
    }
}
