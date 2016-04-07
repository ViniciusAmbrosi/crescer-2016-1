public class Dwarf
{
   private int vida;
   private String name;
   private Status status;
   
   public Dwarf(String name){
       this.name = name;
       this.vida = 110;
       this.status = status.VIVO;
   }
   
   public void setNome(String nome){
       this.name = name;
   }
   
   public Status getStatus(){
       return this.status;
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
