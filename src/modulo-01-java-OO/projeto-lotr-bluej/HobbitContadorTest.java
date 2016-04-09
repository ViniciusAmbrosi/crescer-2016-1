import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest{   
   @Test
   public void retorna180DiferencaProtudosMinimoMultiplo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       ArrayList<Integer> par = new ArrayList<>();
       par.add(15);par.add(18);
       divida.add(par);
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 180); 
   }
   
   @Test
   public void retorna0DiferencaProtudosMinimoMultiplo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       ArrayList<Integer> par = new ArrayList<>();
       par.add(4);par.add(5);
       divida.add(par);
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 0); 
   }
   
   @Test
   public void retorna660DiferencaProtudosMinimoMultiplo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       ArrayList<Integer> par = new ArrayList<>();
       par.add(12);par.add(60);
       divida.add(par);
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 660); 
   }
   
   @Test
   public void retorna840DiferencaProtudosMinimoMultiplo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       ArrayList<Integer> parUm = new ArrayList<>();
       ArrayList<Integer> parDois = new ArrayList<>();
       ArrayList<Integer> parTres = new ArrayList<>();
       parUm.add(15);parUm.add(18);
       parDois.add(4);parDois.add(5);
       parTres.add(12);parTres.add(60);
       divida.add(parUm);
       divida.add(parDois);
       divida.add(parTres);
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 840); 
   }
   
   @Test
   public void retorna840DiferencaProtudosMinimoMultiploComForEach(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       ArrayList<Integer> parUm = new ArrayList<>();
       ArrayList<Integer> parDois = new ArrayList<>();
       ArrayList<Integer> parTres = new ArrayList<>();
       parUm.add(15);parUm.add(18); 
       parDois.add(4);parDois.add(5);
       parTres.add(12);parTres.add(60);
       divida.add(parUm);
       divida.add(parDois);
       divida.add(parTres);
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 840); 
   }
   
   @Test
   public void retorna90mmc(){
       HobbitContador hc = new HobbitContador();
       assertTrue(hc.mmc(15,18) == 90);
   }
}
