import java.util.*;

public class AtaqueIntercalado implements Estrategia {
	ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();
	ArrayList<Elfo> delayed = new ArrayList<>();

	public void atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
		ArrayList<Elfo> exercitoElfosVivos = exercitoElfos.get(Status.VIVO);
		if (dwarfs == null || exercitoElfosVivos == null || dwarfs.isEmpty()
				|| !mesmaQuantidadeVerdesNoturnos(exercitoElfosVivos))
			return;
		Elfo previous = null;
		ordenaAtaque(previous, dwarfs, exercitoElfosVivos);
	}

	private boolean mesmaQuantidadeVerdesNoturnos(ArrayList<Elfo> exercitoElfos) {
		int countVerde = 0;
		int countNoturno = 0;
		for (Elfo elfo : exercitoElfos) {
			if (elfo instanceof ElfoVerde)
				countVerde++;
			else
				countNoturno++;
		}
		return countVerde == countNoturno;
	}

	private void ordenaAtaque(Elfo previous, ArrayList<Dwarf> dwarfs, ArrayList<Elfo> elfos) {
		Elfo elfoD = null;
		for (Elfo elfo : elfos) {
			if (!(elfo.getClass().equals(previous.getClass()))) {
				elfoAtacaAnoes(elfo, dwarfs);
				previous = elfo;
				if (!delayed.isEmpty()) {
					Iterator<Elfo> it = delayed.iterator();
					while(it.hasNext())
						elfoD =  it.next();
						if (!(elfoD.getClass().equals(previous.getClass()))) {
							elfoAtacaAnoes(elfoD, dwarfs);
							previous = elfoD;
							it.remove();
					}
				}
			} else
				delayed.add(elfo);
		}
	}

	private void elfoAtacaAnoes(Elfo elfo, ArrayList<Dwarf> dwarfs) {
		for (Dwarf dwarf : dwarfs)
			elfo.atirarFlecha(dwarf);
		ordemAtaque.add(elfo);
	}
	
	public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemAtaque;
    }
}
