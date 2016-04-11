
public class Dwarf extends Personagem{
   private int vida = 110;
   private Status status = Status.VIVO;
   private DataTerceiraEra dataNasc = new DataTerceiraEra(1,1,1);
   
   public Dwarf(String nome){
       super(nome);
   }
   
   public Dwarf(String nome, DataTerceiraEra dte){
       super(nome);
       dataNasc = dte;
   }

   public void perdeVida(){
       double numeroSorte = getNumeroSorte();
       if(numeroSorte < 0){
           experiencia += 2;
           return;
       }
       else if(numeroSorte <= 100)   
           return;
       else{
           int vidaAposFlechada = vida - 10;
           if(vidaAposFlechada == 0)
                status = status.MORTO;
           if(vida > 0)
                vida -= 10;       
       }
   }
   
   public double getNumeroSorte(){
       double numeroSorte = 101;
       boolean ehBissexto = dataNasc.ehBissexto();
       boolean vidaEntreOitentaENoventa = this.vida >= 80 && this.vida <=90;
       boolean nomeEhSeixasOuMeireles = this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"));
       return ehBissexto ?
              vidaEntreOitentaENoventa ? -33 * 101 : numeroSorte :
              nomeEhSeixasOuMeireles ? (33 * 101) % 100 : numeroSorte;
   }
   
   public void tentarSorte(){
       double sorte = getNumeroSorte();
       if(sorte == -3333)
           for(int i = 0; i < this.inventario.getItens().size(); i++)
               inventario.getItens().get(i).addQtd(1000);
   }
   
   public Status getStatus(){return this.status;}
   
   public int getVida(){return this.vida;}
   
   public DataTerceiraEra getDataNasc(){return this.dataNasc;}
}