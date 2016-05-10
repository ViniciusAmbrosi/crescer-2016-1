using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(funcionario => funcionario.Cargo.Titulo == cargo.Titulo).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ThenBy(funcionario => funcionario.Nome).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(funcionario => funcionario.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase) >= 0).ToList();
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            if (turnos == null)
                return Funcionarios.Where(funcionario => funcionario.TurnoTrabalho != null).ToList();
            return Funcionarios.Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho)).ToList();

        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            return Funcionarios.Where(funcionario => IsBetween(funcionario.DataNascimento, idade)).ToList();
        }

        private bool IsBetween(DateTime data, int idade) // método auxiliar para FiltrarPorIdadeAproximada
        {
            int anoAtual = DateTime.Now.Year;
            DateTime anoInferior = new DateTime(anoAtual - (idade + 5), data.Month, data.Day);
            DateTime anoSuperior = new DateTime(anoAtual - (idade - 5), data.Month, data.Day);
            return data >= anoInferior && data <= anoSuperior;

        }

        public double SalarioMedio(TurnoTrabalho? turno = null)//passa turnoTrabalho, se nulo, turno = null?????
        {
            var average = new List<double>();
            if (turno == null)
                average = Funcionarios.Select(funcionario => funcionario.Cargo.Salario).ToList();
            else
                average = Funcionarios.Where(funcionario => turno == funcionario.TurnoTrabalho)
                                      .Select(funcionario => funcionario.Cargo.Salario).ToList();
            return average.Average();

        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(funcionario => EhAniversariante(funcionario.DataNascimento)).ToList();
        }

        private bool EhAniversariante(DateTime dataNascimento) //Método auxiliar para AniversariantesDoMes
        {
            int mesAtual = DateTime.Now.Month;
            int mesAniversarioFuncionario = dataNascimento.Month;
            return mesAtual == mesAniversarioFuncionario;
        }

        public IList<dynamic> BuscaRapida()
        {
            return Funcionarios.Select(funcionario => new { NomeFuncionario = funcionario.Nome, TituloCargo = funcionario.Cargo.Titulo }).Cast<dynamic>().ToList();
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            return Funcionarios.GroupBy(funcionario => funcionario.TurnoTrabalho)
                               .Select(funcionario => new { Turno = funcionario.Key, Quantidade = funcionario.Count() })
                               .Cast<dynamic>().ToList();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            var funcionarios = Funcionarios.Where(funcionario => funcionario.Cargo.Titulo != "Desenvolvedor Júnior")
                               .Where(funcionario => funcionario.TurnoTrabalho != TurnoTrabalho.Tarde).ToList();
            var funcionarioMaisComplexo = FuncionarioComMaiorNumeroDeConsoantes(funcionarios);
            return new
            {
                Nome = funcionarioMaisComplexo.Nome,
                DataNascimento = funcionarioMaisComplexo.DataNascimento.ToString("d"), //ToString() string format
                SalarioRS = string.Format(CultureInfo.GetCultureInfo("pt-BR"), "{0:c}", funcionarioMaisComplexo.Cargo.Salario),
                SalarioUS = string.Format(CultureInfo.GetCultureInfo("en-US"), "{0:c}", funcionarioMaisComplexo.Cargo.Salario),
                QuantidadeMesmoCargo = BuscarPorCargo(funcionarioMaisComplexo.Cargo).Count()
            };
        }

        private Funcionario FuncionarioComMaiorNumeroDeConsoantes(List<Funcionario> funcionarios)
        {
            var vogais = new HashSet<char> { 'a', 'e', 'i', 'o', 'u' };
            var total = 0;
            var maiorQtdConsoantes = 0;
            var funcionarioMaisComplexo = funcionarios[0];
            foreach (var funcionario in funcionarios)
            {
                total = funcionario.Nome.Count(c => vogais.Contains(c));
                var consoantes = funcionario.Nome.Length - total - 1; //-1 because espaços. Já que todos nomes são formados por nome + 1 sobrenome
                if (consoantes > maiorQtdConsoantes)
                {
                    maiorQtdConsoantes = consoantes;
                    funcionarioMaisComplexo = funcionario;
                }
            }
            return funcionarioMaisComplexo;
        }
    }
}
