
public class IrishDwarf extends Dwarf {
	public IrishDwarf(String name) {
		super(name);
	}

	public IrishDwarf(String name, DataTerceiraEra dataTerceiraEra) {
		super(name, dataTerceiraEra);
	}

	public void tentarSorte() {
		double sorte = getNumeroSorte();
		if (sorte == -3333)
			this.inventario.adicionaItemProporcionalQuantidade();
	}
}
