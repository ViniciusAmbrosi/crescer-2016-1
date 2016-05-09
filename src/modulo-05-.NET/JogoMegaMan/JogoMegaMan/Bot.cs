using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public class Bot : Robo
    {
        public Bot() : base() { }
        public Bot(Chip chip) : base(chip) { } 
        public override string Nome
        {
            get
            {
                return "Bot";
            }
        }
    }
}
