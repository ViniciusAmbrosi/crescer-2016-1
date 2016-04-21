import java.util.*;

public class Inventario {
	private ArrayList<Item> itens;

	public Inventario() {
		itens = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		itens.add(item);
	}

	public void removerItem(Item item) {
		itens.remove(item);
	}

	public String getDescricaoItens() {
		String itens = "";
		for (int i = 0; i < this.itens.size(); i++)
			itens += this.itens.get(i).getDescricao() + ",";
		return this.itens.isEmpty() ? itens : itens.substring(0, itens.length() - 1);
	}

	public Item getItemMaisComum() {
		Item itemComum = itens.get(0);
		for (Item item : itens)
			itemComum = itemComum.getQtd() < item.getQtd() ? item : itemComum;
		return itemComum;
	}

	public void ordenarItens() {
		Collections.sort(this.itens, new Comparator<Item>() {
			public int compare(Item item1, Item item2) {
				return Integer.compare(item1.getQtd(), item2.getQtd());
			}
		});
	}

	public void adiciona1000UnidadesPorItem() {
		for (Item item : this.itens)
			item.adiciona1000Unidades();
	}

	public void adicionaItemProporcionalQuantidade() {
		for (Item item : this.itens)
			item.adicionaItemProporcionalQuantidade();
	}

	private static boolean equals(ArrayList<Item> inventarioUm, ArrayList<Item> inventarioDois, int numExecucoes,
			boolean equals) {
		// sai da recursividade
		if (equals == false)
			return false;
		if (numExecucoes == 1)
			return equals;
		// valida
		for (Item item : inventarioUm) {
			if (inventarioDois.contains(item))
				continue;
			return false;
		}
		return equals(inventarioDois, inventarioUm, ++numExecucoes, true);
	}

	/*
	 * Critério de igualdade é que ambos inventários devem possuir os mesmos
	 * itens, tendo eles a mesma quantidade e descrição (em uma mesma
	 * instância). Para garantir a verdade da igualdade é necessârio comparar
	 * inventário A com invetário B e TAMBEM B com A. Pois se A contêm duas
	 * instâncias de X (X e X) e b contém uma instância de X e uma de Y (X e Y),
	 * ao comparar A e B baseando-se somente em A.equals(B), seria determiado
	 * como igual. Mas tal inverdade é provada se comparado B com A.
	 */
	public boolean equals(Object obj) {
		int numExecucoes = 0; // numero de vezes que executa recursão
		Inventario invCast = ((Inventario) this);
		Inventario invCastDois = ((Inventario) obj);
		ArrayList<Item> inventarioUm = invCast.itens;
		ArrayList<Item> inventarioDois = invCastDois.itens;
		// inventarioUm NUNCA vai ser nulo para chamar
		if (inventarioDois == null)
			return false;
		// se nao tiverem mesmo tamanho nao podem ser iguais
		if (inventarioUm.size() != inventarioDois.size())
			return false;
		return equals(inventarioUm, inventarioDois, numExecucoes, true);
	}

	public ArrayList<Item> getItens() {
		return this.itens;
	}
}