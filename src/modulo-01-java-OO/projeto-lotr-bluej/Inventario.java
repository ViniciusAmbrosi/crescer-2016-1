import java.util.*;

public class Inventario{
    private ArrayList<Item> itens;
    
    public Inventario(){
        itens = new ArrayList<Item>();
    }
    
    public void addItem(Item item){
        itens.add(item);
    }
    
    public void removerItem(Item item){
        itens.remove(item);
    }
    
    public String getDescricaoItens(){
        String itens =  "";
        for(int i = 0; i < this.itens.size(); i++)
             itens += this.itens.get(i).getDescricao() + ",";
        return this.itens.isEmpty() ? 
               itens :
               itens.substring(0, itens.length()-1);
    }
    
    public Item getItemMaisComum(){
        Item itemComum = itens.get(0);
        for(Item item : itens)
            itemComum = itemComum.getQtd() < item.getQtd() ? item : itemComum;
        return itemComum;  
    } 
    
    public void ordenarItens(){
        int size = itens.size();
        boolean trocou;
        for(int i = size; i >= 1; i--){
            trocou = false;
            for(int j = 0; j < i - 1; j++){
                Item current = itens.get(j);
                Item next = itens.get(j+1);
                if(current.getQtd() > next.getQtd()){
                    itens.set(j, next); //passa j+1 para j
                    itens.set(j+1, current); //pass j para j + 1
                    trocou = true; //valida troca
                }
            }
            if(!trocou)
                break;
        }
    }
    
    public ArrayList<Item> getItens(){return this.itens;}   
}