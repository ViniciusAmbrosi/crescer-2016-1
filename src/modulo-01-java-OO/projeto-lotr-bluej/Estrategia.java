import java.util.*;

public interface Estrategia {
	public ArrayList<Elfo> atacar(HashMap<Status,ArrayList<Elfo>> elfos, ArrayList<Dwarf> dwarves);
}
