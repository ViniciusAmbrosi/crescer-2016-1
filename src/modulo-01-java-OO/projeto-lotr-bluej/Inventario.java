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
        Collections.sort(this.itens, new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                return Integer.compare(item1.getQtd(), item2.getQtd());
            }
        });
    }
    
    public void adiciona1000UnidadesPorItem(){
        for(Item item : this.itens)
            item.adiciona1000Unidades();
    }
    
    public void adicionaItemProporcionalQuantidade(){
        for(Item item : this.itens)
            item.adicionaItemProporcionalQuantidade();
    }
    public ArrayList<Item> getItens(){return this.itens;}   
}