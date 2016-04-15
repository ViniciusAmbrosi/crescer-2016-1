import java.util.*;

public interface Estrategia {
	public void atacar(HashMap<Status,ArrayList<Elfo>> elfos, ArrayList<Dwarf> dwarves);
	
	public ArrayList<Elfo> getOrdemDoUltimoAtaque();
}
