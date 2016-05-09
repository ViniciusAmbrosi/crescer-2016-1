using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public class Rush : Robo, IUpgrade
    {
        public Rush(Chip chip) : base(chip) { }
        public Rush() : base() { }
        public int BonusAtaque
        {
            get
            {
                return Ataque + BonusEquipAtaque;
            }
        }

        protected override int MaxUpgrades
        {
            get { return 2; }
        }

        public int BonusDefesa
        {
            get
            {
                return 3;
            }
        }

        public override string Nome
        {
            get
            {
                return "Rush";
            }
        }

        public string TipoUpgrade
        {
            get
            {
                return "Lendário";
            }
        }

        protected override int Ataque
        {
            get
            {
                return 4 + ModificadorChipDano;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 3 + ModificadorChipDefesa;
            }
        }

        public override void Atacar(Robo robo)
        {
            if (robo is MegaMan)
                return;
            robo.RecebeDano(Ataque + BonusEquipAtaque);
        }
    }
}
