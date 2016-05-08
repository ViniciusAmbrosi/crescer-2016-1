using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public class Rush : Robo, IUpgrade
    {
        public int BonusAtaque
        {
            get
            {
                return Ataque;
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
                return 4 + BonusEquipAtaque;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 3 + BonusEquipDefesa;
            }
        }
    }
}
