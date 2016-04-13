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
    
    private static boolean equals(ArrayList<Item> inv1, ArrayList<Item> inv2, int c, boolean equals){
        //sai da recursividade
        if(equals == false)
            return false;
        if(c == 1)
            return equals;
        //valida
        for(Item item : inv1){
            if(inv2.contains(item))
                continue;
            return false;
        }
        return equals(inv2,inv1, ++c, true);
    } 
    
    public boolean equals(Object obj){
        int c = 0;
        Inventario invCast = ((Inventario)this);
        Inventario invCast2 = ((Inventario)obj);
        ArrayList<Item> inv1 = invCast.itens;
        ArrayList<Item> inv2 = invCast2.itens;
        if(inv2 == null) //se inv1 é nulo, logo inv2 não é, logo inv1 != inv2 !!!inv2 pq inv1 NUNCA vai ser nulo para chamar equals
            return false;
        if(inv1.size() != inv2.size()) //se nao tiverem mesmo tamanho nao podem ser iguais
            return false;
        return equals(inv1,inv2,c,true);
    }
    
    public ArrayList<Item> getItens(){return this.itens;}   
}