using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public class ProtoMan : Robo
    {
        public override string Nome
        {
            get
            {
                return "Protoman";
            }
        }

        private bool hasDied = false;
        private bool HasDied
        {
            get
            {
                return hasDied;
            }
            set
            {
                hasDied = value;
            }
        }

        protected override int Ataque
        {
            get
            {
                if (HasDied) { return 7 + BonusEquipAtaque; }
                return 5 + BonusEquipAtaque;
            }
        }
        protected override int Defesa
        {
            get
            {
                return 2 + BonusEquipDefesa;
            }
        }
        public override void RecebeDano(int dano)
        {
            Vida -= (dano - Defesa);
            if (!hasDied && Vida <= 0)
            {
                Vida = 20;
                HasDied = true;
            }
        }
    }
}

