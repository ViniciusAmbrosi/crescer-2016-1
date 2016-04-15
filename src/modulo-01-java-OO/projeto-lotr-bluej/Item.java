
public class Item {
	private int qtd;
	private String descricao;

	public Item(int qtd, String descricao) {
		this.qtd = qtd;
		this.descricao = descricao;
	}

	public void adiciona1000Unidades() {
		this.qtd += 1000;
	}

	public void adicionaItemProporcionalQuantidade() {
		this.qtd += (this.qtd * (this.qtd + 1) / 2) * 1000;
	}

	public boolean equals(Object obj) {
		Item item = ((Item) obj);
		if (this == item) // mesmo principio do equals em inventario
			return true;
		if (obj == null)
			return false;
		return this.qtd == item.qtd && this.descricao != null && obj != null && this.descricao.equals(item.descricao);
	}

	public int getQtd() {
		return this.qtd;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
