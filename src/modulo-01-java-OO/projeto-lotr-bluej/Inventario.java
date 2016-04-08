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
    
    public ArrayList<Item> getItens(){return this.itens;}   
}