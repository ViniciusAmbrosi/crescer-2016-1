import java.util.*;

public class HobbitContador{
    //arrayDePares.get(0).get(0)
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares){
        ArrayList<Integer> produtoPares = new ArrayList<>(); 
        ArrayList<Integer> mmcPares = new ArrayList<>();
        int produtoParesAux = 1; 
        int produtosMenosMmc = 0;
        for(int i = 0; i < arrayDePares.size(); i++){
            for(int j = 0; j < arrayDePares.get(i).size(); j++){
                produtoParesAux *= arrayDePares.get(i).get(j); //guarda produto dos pares
                mmcPares.add(arrayDePares.get(i).get(j)); //guarda mmcDosPares
            }
            mmcPares.set(i, mmc(mmcPares.get(i), mmcPares.get(i+1)));
            mmcPares.remove(i + 1); //remove segundo valor do par
            produtoPares.add(produtoParesAux);   
            produtosMenosMmc += produtoPares.get(i) - mmcPares.get(i);
            produtoParesAux = 1;
        } 
        //return soma da dif entre o produto e o minimo múltiplo comum de cada par
        return produtosMenosMmc;
    }
    
    public int mmc (int a, int b){
        int aux = a;
        while(a % b != 0) 
            a += aux;
        return a;
    }
}
