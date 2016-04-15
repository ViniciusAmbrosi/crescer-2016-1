import java.util.*;

public class NoturnosPorUltimo implements Estrategia {
    ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();

    public void atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
        if (dwarfs == null || exercitoElfos.get(Status.VIVO) == null  || dwarfs.isEmpty())
            return;
        Class previous = ElfoVerde.class;
        Iterator<Elfo> it = exercitoElfos.get(Status.VIVO).iterator();
        while(it.hasNext()){
            Elfo aux = it.next();
            if(aux.getClass().equals(previous)){
                ordemAtaqueElfos(aux.getClass(), exercitoElfos, dwarfs);
                if(previous.equals(ElfoNoturno.class))
                    break;
                previous = ElfoNoturno.class;
                it = exercitoElfos.get(Status.VIVO).iterator();
            }
            if((!(it.hasNext())) && previous.equals(ElfoVerde.class)){
                it = exercitoElfos.get(Status.VIVO).iterator();
                previous = ElfoNoturno.class;
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
