public class Dwarf
{
   private int vida;
   private String name;
   
   public Dwarf(String name){
       this.name = name;
       this.vida = 110;
   }
   
   public void setNome(String nome){
       this.name = name;
   }
   
   public String getNome(){
       return this.name;
   }
   
   public int getVida(){
       return vida;
   }
   
   public void perdeVida(){
       this.vida -= 10;
   }
}
