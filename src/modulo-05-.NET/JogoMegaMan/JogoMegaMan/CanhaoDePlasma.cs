using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public class CanhaoDePlasma : IUpgrade
    {
        public int BonusAtaque
        {
            get
            {
                return 2;
            }
        }

        public int BonusDefesa
        {
            get
            {
                return 0;
            }
        }

        public string TipoUpgrade
        {
            get
            {
                return "UpgradeDeAtaque";
            }
        }
    }
}
