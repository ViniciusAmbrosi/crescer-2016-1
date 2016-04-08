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
   
   public Inventario getInventario(){
       return this.inventario;
   }
   
   public Status getStatus(){
       return this.status;
   }
   
   public String getName(){
       return this.name;
   }
   
   public int getVida(){
       return this.vida;
   }
   
   public DataTerceiraEra getDataNasc(){
       return  this.dataNasc;
   }
   
   public void perdeVida(){
       int vidaAposFlechada = vida - 10;
       if(vidaAposFlechada == 0)
           status = status.MORTO;
       if(vida > 0)
           vida -= 10;        
   }
   
   public double getNumeroSorte(){
       double numeroSorte = 101;
       boolean ehBissexto = dataNasc.ehBissexto();
       boolean vidaEntreOitentaENoventa = this.vida >= 80 && this.vida <=90;
       boolean nameEhSeixasOuMeireles = this.name.equals("Seixas") || this.name.equals("Meireles");
       
       return ehBissexto ?
              vidaEntreOitentaENoventa ? -33 * 101 : numeroSorte :
              nameEhSeixasOuMeireles ? (33 * 101) % 100 : numeroSorte;
   }
   
   public void adicionarItem(Item item){
       this.inventario.addItem(item);
   }
   
   public void perderItem(Item item){
       this.inventario.removerItem(item);
   }
   
   
}
