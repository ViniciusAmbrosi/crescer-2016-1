using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public class BotasDeSuperVelocidade : IUpgrade
    {
        public int BonusAtaque
        {
            get
            {
                return 1;
            }
        }

        public int BonusDefesa
        {
            get
            {
                return 1;
            }
        }

        public string TipoUpgrade
        {
            get
            {
                return "Lendário"; 
            }
        }
    }
}
