
public class Item {
	private int quantidade;
	private String descricao;

	public Item(int quantidade, String descricao) {
		this.quantidade = quantidade;
		this.descricao = descricao;
	}

	public void adiciona1000Unidades() {
		this.quantidade += 1000;
	}

	public void adicionaItemProporcionalQuantidade() {
		this.quantidade += (this.quantidade * (this.quantidade + 1) / 2) * 1000;
	}

	public boolean equals(Object obj) {
		Item item = ((Item) obj);
		if (this == item) // mesmo principio do equals em inventario
			return true;
		if (obj == null)
			return false;
		return this.quantidade == item.quantidade && this.descricao != null && obj != null
				&& this.descricao.equals(item.descricao);
	}

	public int getQtd() {
		return this.quantidade;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
