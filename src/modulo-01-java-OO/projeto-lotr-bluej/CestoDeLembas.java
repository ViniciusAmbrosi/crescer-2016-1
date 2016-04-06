public class CestoDeLembas{
    private int lembas;
    
    public CestoDeLembas(int lembas){
        this.lembas = lembas;
    }
     
    public boolean podeDividirEmPares(){
        boolean podeDividir = lembas > 3 && lembas <=100 && lembas % 2 == 0;
        return podeDividir ? true : false;
    }   
}