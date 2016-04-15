import java.util.*;

public class AtaqueIntercalado implements Estrategia {
	ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();
	ArrayList<Elfo> delayed = new ArrayList<>();

	public ArrayList<Elfo> atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
		if (dwarfs == null || exercitoElfos.get(Status.VIVO) == null || dwarfs.isEmpty()
				|| mesmaQuantidadeVerdesNoturnos(exercitoElfos))
			return ordemAtaque;
		Elfo previous = new Elfo("previous");
		ordenaAtaque(previous, dwarfs, exercitoElfos.get(Status.VIVO));
		return ordemAtaque;
	}

	private boolean mesmaQuantidadeVerdesNoturnos(HashMap<Status, ArrayList<Elfo>> exercitoElfos) {
		int countVerde = 0;
		int countNoturno = 0;
		for (Elfo elfo : exercitoElfos.get(Status.VIVO)) {
			if (elfo instanceof ElfoVerde)
				countVerde++;
			else
				countNoturno++;
		}
		return !(countVerde == countNoturno);
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
}
