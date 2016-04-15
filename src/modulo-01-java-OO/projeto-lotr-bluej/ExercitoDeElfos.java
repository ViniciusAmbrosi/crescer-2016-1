import java.util.*;

public class ExercitoDeElfos{
	private HashMap<String, Elfo> exercito = new HashMap<>();
	private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();

	public void alistaElfo(Elfo elfo) {
		if (elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
			exercito.put(elfo.getNome(), elfo);
	}

	public Elfo buscarPorNome(String nome) {
		return exercito.get(nome);
	}

	public void agrupaPorStatus() {
		exercitoAgrupado.clear();
		for (Elfo value : exercito.values()) {
			Status status = value.getStatus();
			if (!exercitoAgrupado.containsKey(status))
				exercitoAgrupado.put(status, new ArrayList<Elfo>());
			exercitoAgrupado.get(status).add(value);
		}
		System.runFinalization();
	}

	public void atacar(Estrategia strat, ArrayList<Dwarf> dwarfs) {
		agrupaPorStatus();
		strat.atacar(exercitoAgrupado, dwarfs);
	}

	public HashMap<Status, ArrayList<Elfo>> getExercitoAgrupado() {
		return exercitoAgrupado;
	}

	public HashMap<String, Elfo> getExercito() {
		return exercito;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ExercitoDeElfos ede = new ExercitoDeElfos();
		ArrayList<Dwarf> hordaDwarfs = new ArrayList<>();
		Estrategia strat = new ArteDaGuerra();;
		int aux;
		String stratType = "";
		boolean cont = false;
		try{
		do{
			//cria elfos noturnos
			System.out.println("Quantos elfos Noturnos quer que o exercíto tenha?");
			aux = sc.nextInt();
			for(int i = 0; i < aux; i++)
				ede.alistaElfo(new ElfoNoturno("elfoNoturno"+i));
			//cria elfos verdes
			System.out.println("Quantos elfos Verdes quer que o exercíto tenha?");
			aux = sc.nextInt();
			for(int i = 0; i < aux; i++)
				ede.alistaElfo(new ElfoVerde("elfoVerde"+i));
			//cria anoes
			System.out.println("Qual o tamanho da horda de elfos?");
			aux = sc.nextInt();
			for(int i = 0; i < aux; i++)
				hordaDwarfs.add(new Dwarf("dwarf"+i));
			//limbo
			ede.agrupaPorStatus();
			sc.nextLine();
			//define estrategia
			boolean stratVal;
			do{ 	
				stratVal = true;
				System.out.println(" Qual estratégia devera o general usar? \n"
						+  "[adg]ArteDaGuerra [npu]NoturnosPorUltimo [ai]AtaqueIntercalado \n");
				stratType = sc.nextLine(); 
				switch(stratType.toLowerCase()){
					case "adg":
						strat = new ArteDaGuerra();
						stratVal = false;
						break;
					case "npu":
						strat = new NoturnosPorUltimo();
						stratVal = false;
						break;
					case "ai":
						strat = new AtaqueIntercalado();
						stratVal = false;
						break;
					default:
						throw new EstrategiaInvalidaException();
				}
				//ATACA
				ede.atacar(strat, hordaDwarfs);
				ArrayList<Elfo> atacaram = strat.getOrdemDoUltimoAtaque();
				System.out.println("A ordem de ataque foi: ");
				for(Elfo elfo : atacaram)
					System.out.println(elfo.getClass() + " " + elfo.getNome());		
				if(!stratVal)
					System.out.println("Deseja fazer mais um ataque? [S]im ou qualquer tecla para encerrar");
					stratType = sc.nextLine();
					switch (stratType.toLowerCase()){
						case "s":
							stratVal = true;
							break;
						default:
							break;
					}
					
			}while(stratVal);
		}while(cont);
		sc.close();
		}catch(InputMismatchException e){
			System.out.println("Um dos valores inseridos foi invalido");
		}catch(EstrategiaInvalidaException e){
			System.out.println(e.toString());
		}
		
	}

}
