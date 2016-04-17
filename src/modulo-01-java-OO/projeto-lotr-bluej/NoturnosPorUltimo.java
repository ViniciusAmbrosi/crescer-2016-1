import java.util.*;

public class NoturnosPorUltimo implements Estrategia {
    ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();

    public void atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
    	ArrayList<Elfo> exercitoElfosVivos = exercitoElfos.get(Status.VIVO);
        if (dwarfs == null || exercitoElfosVivos == null  || dwarfs.isEmpty())
            return;
        Class current = ElfoVerde.class;
        Iterator<Elfo> it = exercitoElfosVivos.iterator();
        while(it.hasNext()){
            Elfo elfo = it.next();
            if(elfo.getClass().equals(current)){
                ordemAtaqueElfos(elfo.getClass(), exercitoElfos, dwarfs);
                if(current.equals(ElfoNoturno.class))
                    break;
                current = ElfoNoturno.class;
                it = exercitoElfosVivos.iterator();
            }
            if(!it.hasNext() && current.equals(ElfoVerde.class)){
                it = exercitoElfosVivos.iterator();
                current = ElfoNoturno.class;
            }
        }
    }

    private void ordemAtaqueElfos(Class tipo, HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
        for (Elfo elfo : exercitoElfos.get(Status.VIVO)) {
            if (elfo.getClass().equals(tipo)) {
                ordemAtaque.add(elfo);
                for (Dwarf dwarf : dwarfs)
                    elfo.atirarFlecha(dwarf);
            }
		}
	}
	
	public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemAtaque;
    }
}
