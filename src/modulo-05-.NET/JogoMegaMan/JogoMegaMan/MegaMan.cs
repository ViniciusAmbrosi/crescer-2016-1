using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public class MegaMan : Robo
    {
        public override string Nome
        {
            get
            {
                return "Megaman";
            }
        }
        protected override int Ataque
        {
            get
            {
                return 6 + BonusEquipAtaque;
            }
        }

        public virtual void Atacar(Robo robo)
        {
            if (Vida <= 30)
                robo.RecebeDano(3 + Ataque);
            else
                robo.RecebeDano(Ataque);
        }
    }
}
