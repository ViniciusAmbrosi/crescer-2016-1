import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SimulacaoDeGuerra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ExercitoDeElfos ede = new ExercitoDeElfos();
		ArrayList<Dwarf> hordaDwarfs = new ArrayList<>();
		Estrategia strat = new ArteDaGuerra();
		;
		int qtdPersonagem;
		String stratType = "";
		boolean cont = false;
		try {
			do {
				// cria elfos noturnos
				System.out.println("Quantos elfos Noturnos quer que o exercito tenha?");
				qtdPersonagem = sc.nextInt();
				for (int i = 0; i < qtdPersonagem; i++)
					ede.alistaElfo(new ElfoNoturno("elfoNoturno" + i));
				// cria elfos verdes
				System.out.println("Quantos elfos Verdes quer que o exercito tenha?");
				qtdPersonagem = sc.nextInt();
				for (int i = 0; i < qtdPersonagem; i++)
					ede.alistaElfo(new ElfoVerde("elfoVerde" + i));
				// cria anoes
				System.out.println("Qual o tamanho da horda de anoes?");
				qtdPersonagem = sc.nextInt();
				for (int i = 0; i < qtdPersonagem; i++)
					hordaDwarfs.add(new Dwarf("dwarf" + i));
				// limbo
				ede.agrupaPorStatus();
				sc.nextLine();
				// define estrategia
				boolean stratVal;
				do {
					stratVal = true;
					System.out.println(" Qual estrategia devera o general usar? \n"
							+ "[adg]ArteDaGuerra [npu]NoturnosPorUltimo [ai]AtaqueIntercalado \n");
					stratType = sc.nextLine();
					switch (stratType.toLowerCase()) {
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
					// ATACA
					ede.atacar(strat, hordaDwarfs);
					ArrayList<Elfo> atacaram = strat.getOrdemDoUltimoAtaque();
					System.out.println("A ordem de ataque foi: ");
					for (Elfo elfo : atacaram)
						System.out.println(elfo.getClass() + " " + elfo.getNome());
					if (!stratVal)
						System.out.println("Deseja fazer mais um ataque? [S]im ou qualquer tecla para encerrar");
					stratType = sc.nextLine();
					switch (stratType.toLowerCase()) {
					case "s":
						stratVal = true;
						break;
					default:
						break;
					}

				} while (stratVal);
			} while (cont);
			sc.close();
		} catch (InputMismatchException e) {
			System.out.println("Um dos valores inseridos foi invalido");
		} catch (EstrategiaInvalidaException e) {
			System.out.println(e.toString());
		}
	}
}
