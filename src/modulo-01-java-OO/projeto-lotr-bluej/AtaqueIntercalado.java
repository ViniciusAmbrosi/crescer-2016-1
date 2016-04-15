import java.util.*;

public class AtaqueIntercalado implements Estrategia {
	ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();

	public ArrayList<Elfo> atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
		if (dwarfs == null || exercitoElfos.get(Status.VIVO) == null || dwarfs.isEmpty()
				|| mesmaQuantidadeVerdesNoturnos(exercitoElfos))
			return ordemAtaque;
		Elfo previous = new Elfo("gambiarra?");
		for (Elfo elfo : exercitoElfos.get(Status.VIVO)) {
			if (!(elfo.getClass().equals(previous.getClass()))) {
				previous = elfo;
				for (Dwarf dwarf : dwarfs)
					elfo.atirarFlecha(dwarf);
				ordemAtaque.add(previous);
			}
		}
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

}
