using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MegaMan
{
    public abstract class Robo
    {
        public abstract string Nome { get; }
        public int Vida { get; private set; }
        protected virtual int Ataque {
            get
            {
                return 5;
            }
        }
        protected virtual int Defesa
        {
            get
            {
                return 0;
            }
        }
        public void Atacar(Robo robo) {
            robo.Vida -= this.Ataque - robo.Defesa;
        }
    }
}
