import java.util.*;

public class ExercitoDeElfos{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();
    
    public void alistaElfo(Elfo elfo){
        if(elfo instanceof ElfoVerde ||
           elfo instanceof ElfoNoturno)
           exercito.put(elfo.getNome(), elfo);
    }
    
    public Elfo buscarPorNome(String nome){
        return exercito.get(nome);
    } 
    
    public HashMap<String, Elfo> getExercito(){
        return exercito;
    }
    
    public void agrupaPorStatus(){
        for(Elfo value : exercito.values()){
            Status status = value.getStatus();
            if(!exercitoAgrupado.containsKey(status))
                exercitoAgrupado.put(status, new ArrayList<Elfo>());
            exercitoAgrupado.get(status).add(value);
        }
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoAgrupado(){
        return exercitoAgrupado;
    }
}
