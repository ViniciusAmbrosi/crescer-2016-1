import java.util.Random;

public class Elfo{
    public String name;
    public int xp;
    public int flecha = 42;   
    
    public Elfo(String name){
        this.name = name;
        this.xp = 0;
    }
    
    public boolean atirarFlecha(){
        if(flecha == 0)
           return false;
        xp++;
        flecha--;
        return true;
    }
    
    /**public boolean acertouFlecha(){ 
        Random random = new Random();
        int def = random.nextInt(21);
        int atkroll = random.nextInt(21);
        if(atkroll >= def)
            return true;
        return false;
    }*/
    
    public boolean atirarFlechaRefactory(){
         if(flecha == 0)
             return false;
         /**if(acertouFlecha())
             xp++;*/
         xp++;
         flecha--;   
         return true;
    }

    public void atirarFlecha(Anao anao){ //Ret bool para det sucesso
        if(this.atirarFlecha())
            anao.perdeVida(10);
    }
}