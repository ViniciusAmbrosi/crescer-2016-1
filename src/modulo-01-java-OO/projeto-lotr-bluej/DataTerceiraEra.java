
public class DataTerceiraEra{
    private int dia, mes, ano;
    
    public DataTerceiraEra(int dia, int mes, int ano){ //Validação não definida no exercício, logo(?)
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public boolean ehBissexto(){ //é bissexto aquele que é múltiplo de 400 ou é multiplo de 4 mas nao de 100
        boolean multQuatrocentos = this.ano % 400 == 0; //É multiplo de Quatrocentos?
        boolean multQuatroNaoMultCem = this.ano % 4 == 0 && this.ano % 100 != 0; //É múltiplo de 4 sem ser de 100?
        return multQuatrocentos ? true : multQuatroNaoMultCem; //Se é multiplo de quatrocentos, true, se não, é multiplo de 4 sem ser de 100?
    }

    public int getDia(){return this.dia;}
    
    public int getMes(){return this.mes;}
    
    public int getAno(){return this.ano;}   
}