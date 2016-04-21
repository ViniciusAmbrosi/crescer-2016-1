
public class DataTerceiraEra {
	private int dia, mes, ano;

	public DataTerceiraEra(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
    
    public boolean ehBissexto() { //Ano bissexto aquele que eh multiplo de 400 ou eh multiplo de 4 mas nao de 100
        boolean multQuatrocentos = this.ano % 400 == 0; //Eh multiplo de Quatrocentos?
        boolean multQuatroNaoMultCem = this.ano % 4 == 0 && this.ano % 100 != 0; //Eh multiplo de 4 sem ser de 100?
        return multQuatrocentos ? true : multQuatroNaoMultCem; //Se eh multiplo de quatrocentos, true, se nao, eh multiplo de 4 sem ser de 100?
    }

	public boolean equals(Object obj) {
		DataTerceiraEra dataTerceiraEra = (DataTerceiraEra) obj;
		return this.dia == dataTerceiraEra.dia
				? this.mes == dataTerceiraEra.mes ? this.ano == dataTerceiraEra.ano ? true : false : false : false;
	}

	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}

	public int getAno() {
		return this.ano;
	}
}