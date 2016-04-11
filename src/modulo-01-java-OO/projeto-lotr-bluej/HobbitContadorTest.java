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
       divida.add(new ArrayList<>(Arrays.asList(15, 18)));
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 180); 
   }
   
   @Test
   public void retorna0DiferencaProtudosMinimoMultiplo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       divida.add(new ArrayList<>(Arrays.asList(4, 5)));
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 0); 
   }
   
   @Test
   public void retorna660DiferencaProtudosMinimoMultiplo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       divida.add(new ArrayList<>(Arrays.asList(12, 60)));
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 660); 
   }
   
   @Test
   public void retorna840DiferencaProtudosMinimoMultiplo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       divida.add(new ArrayList<>(Arrays.asList(15, 18)));
       divida.add(new ArrayList<>(Arrays.asList(4, 5)));
       divida.add(new ArrayList<>(Arrays.asList(12, 60)));
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 840); 
   }
   
   @Test
   public void retorna0ArrayListVazio(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 0);
   }
   
   @Test
   public void retorna0PrimeiroValorDoParZero(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       divida.add(new ArrayList<>(Arrays.asList(0, 18)));
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 0);
   }
   
   @Test
   public void retorna0SegundoValorDoParZero(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       divida.add(new ArrayList<>(Arrays.asList(4, 0)));
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 0);
   }
   
   @Test
   public void retorna0AmbosValorerDoParZero(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       divida.add(new ArrayList<>(Arrays.asList(0, 0)));
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 0);
   }
   
   @Test
   public void retorna840ComParesComZero(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       divida.add(new ArrayList<>(Arrays.asList(15, 18)));
       divida.add(new ArrayList<>(Arrays.asList(0, 18)));
       divida.add(new ArrayList<>(Arrays.asList(4, 5)));
       divida.add(new ArrayList<>(Arrays.asList(4, 0)));
       divida.add(new ArrayList<>(Arrays.asList(12, 60)));
       divida.add(new ArrayList<>(Arrays.asList(0, 0)));
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 840); 
   }
   
   @Test
   public void retorna0ArrayListNulo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = null;
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 0);
   }
   
   @Test
   public void retorna840ComParesComZeroEParNulo(){
       HobbitContador frumbleFoot = new HobbitContador();
       ArrayList<ArrayList<Integer>> divida = new ArrayList<>();
       divida.add(new ArrayList<>(Arrays.asList(15, 18)));
       divida.add(new ArrayList<>(Arrays.asList(0, 18)));
       divida.add(new ArrayList<>(Arrays.asList(4, 5)));
       divida.add(new ArrayList<>(Arrays.asList(4, 0)));
       divida.add(new ArrayList<>(Arrays.asList(12, 60)));
       divida.add(new ArrayList<>(Arrays.asList(0, 0)));
       divida.add(null);
       assertTrue(frumbleFoot.calcularDiferenca(divida) == 840); 
   }
   
   @Test
   public void retorna9MaiorMultiplo10(){
       HobbitContador frumbleFoot = new HobbitContador();
       assertTrue(frumbleFoot.obterMaiorMultiploDeTresAte(10) == 9);
   }
   
   @Test
   public void retorna18MaiorMultiplo20(){
       HobbitContador frumbleFoot = new HobbitContador();
       assertTrue(frumbleFoot.obterMaiorMultiploDeTresAte(20) == 18);
   }
   
   @Test
   public void retorna0MaiorMultiplo0(){
       HobbitContador frumbleFoot = new HobbitContador();
       assertTrue(frumbleFoot.obterMaiorMultiploDeTresAte(0) == 0);
   }
}
