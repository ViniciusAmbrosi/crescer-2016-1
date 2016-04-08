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
             itens = this.itens.get(i)+",";
        return /**itens.equals("") ? "Não tem itens" :*/ itens;
    }
    
    public ArrayList<Item> getItens(){return this.itens;}   
}