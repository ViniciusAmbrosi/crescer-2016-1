using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public class ProtoMan : Robo
    {
        public ProtoMan(Chip chip) : base(chip) { }
        public ProtoMan() : base() { }
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
                if (HasDied) { return 7 + ModificadorChipDano; }
                return 5 + ModificadorChipDano;
            }
        }
        protected override int Defesa
        {
            get
            {
                return 2 + ModificadorChipDefesa;
            }
        }
        public override void RecebeDano(int dano)
        {
            var danoRecebido = dano - (Defesa + BonusEquipDefesa);
            if (danoRecebido <= 0)
                return;
            Vida -= danoRecebido;
            if (!hasDied && Vida <= 0)
            {
                Vida = 20;
                HasDied = true;
            }
        }
    }
}

