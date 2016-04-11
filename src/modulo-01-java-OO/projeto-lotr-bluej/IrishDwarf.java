
public class IrishDwarf extends Dwarf{
   
   public IrishDwarf(String name){
       super(name);
   }
   
   public IrishDwarf(String name, DataTerceiraEra dte){
       super(name, dte);
   }
   
      public void tentarSorte(){
       double sorte = getNumeroSorte();
       int fatorDeMult = 0;
       int qtdItens = 0;
       if(sorte == -3333)
           for(int i = 0; i < this.inventario.getItens().size(); i++){
               qtdItens = inventario.getItens().get(i).getQtd(); //Quantidade de current Item
               fatorDeMult = (qtdItens) * ((qtdItens + 1) /2); //soma dos termos de progressão aritmética
               inventario.getItens().get(i).addQtd(fatorDeMult * 1000);
           }
   }
}
