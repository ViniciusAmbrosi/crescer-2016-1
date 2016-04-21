import java.util.*;

public class NoturnosPorUltimo implements Estrategia {
	ArrayList<Elfo> ordemAtaque = new ArrayList<Elfo>();

	public void atacar(HashMap<Status, ArrayList<Elfo>> exercitoElfos, ArrayList<Dwarf> dwarfs) {
		ArrayList<Elfo> exercitoElfosVivos = exercitoElfos.get(Status.VIVO);
		if (dwarfs == null || exercitoElfosVivos == null || dwarfs.isEmpty())
			return;
		Class current = ElfoVerde.class;
		Iterator<Elfo> iterator = exercitoElfosVivos.iterator();
		while (iterator.hasNext()) {
			Elfo elfo = iterator.next();
			if (elfo.getClass().equals(current)) {
				ordemAtaqueElfos(elfo.getClass(), exercitoElfosVivos, dwarfs);
				if (current.equals(ElfoNoturno.class))
					break;
				current = ElfoNoturno.class;
				iterator = exercitoElfosVivos.iterator();
			}
			if (!iterator.hasNext() && current.equals(ElfoVerde.class)) {
				iterator = exercitoElfosVivos.iterator();
				current = ElfoNoturno.class;
			}
		}
	}

	private void ordemAtaqueElfos(Class tipo, ArrayList<Elfo> exercitoElfos, ArrayList<Dwarf> dwarfs) {
		for (Elfo elfo : exercitoElfos) {
			if (elfo.getClass().equals(tipo)) {
				ordemAtaque.add(elfo);
				for (Dwarf dwarf : dwarfs)
					elfo.atirarFlecha(dwarf);
			}
		}
	}

	public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
		return ordemAtaque;
	}
}
