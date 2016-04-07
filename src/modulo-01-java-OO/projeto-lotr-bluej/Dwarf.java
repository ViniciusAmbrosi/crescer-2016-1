public class Dwarf
{
   private int vida;
   private String name;
   private Status status;
   private Inventario inventario;
   private DataTerceiraEra dataNasc = new DataTerceiraEra(1,1,1);
   
   public Dwarf(String name){
       this.name = name;
       this.vida = 110;
       this.status = status.VIVO;
       this.inventario = new Inventario();
   }
   
   public Dwarf(String name, DataTerceiraEra dte){
       this(name);
       this.dataNasc = dte;
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
       int vidaAposFlechada = vida - 10;
       if(vidaAposFlechada == 0)
           status = status.MORTO;
       if(vida > 0)
           vida -= 10;        
   }
   
   public void adicionarItem(Item item){
       this.inventario.addItem(item);
   }
   
   public void perderItem(Item item){
       this.inventario.removerItem(item);
   }
   
   
}
