
public class Anao
{
   private int vida;
   
   public Anao(){
       this.vida = 110;
   }

   public void perdeVida(int dano){
       this.vida -= dano;
   }
}
