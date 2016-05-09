using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaMan
{
    public abstract class Robo
    {
        public abstract string Nome { get; }

        List<IUpgrade> upgrades = new List<IUpgrade>();
        public virtual int BonusEquipAtaque { get; set; }
        public virtual int BonusEquipDefesa { get; set; }
        public int ModificadorChipDano { get; set; }
        public int ModificadorChipDefesa { get; set; }
        public Chip ChipEquipado { get; set; }
        public int Vida { get; protected set; }

        protected virtual int MaxUpgrades
        {
            get { return 3; }
        }
        public Robo()
        {
            Vida = 100;
            ChipEquipado = Chip.Nivel2;
            ModificadorChipDano = 0;
            ModificadorChipDefesa = 0;
        }
        public Robo(Chip chip)
        {
            Vida = 100;
            ChipEquipado = chip;
            switch (chip)
            {
                case Chip.Nivel1:
                    ModificadorChipDano = -1;
                    ModificadorChipDefesa = 0;
                    break;
                case Chip.Nivel2:
                    ModificadorChipDano = 0;
                    ModificadorChipDefesa = 0;
                    break;
                case Chip.Nivel3:
                    ModificadorChipDano = 2;
                    ModificadorChipDefesa = 1;
                    break;
                default:
                    break;
            }
        }
        protected virtual int Ataque
        {
            get
            {
                return 5 + ModificadorChipDano;
            }
        }
        protected virtual int Defesa
        {
            get
            {
                return 0 + ModificadorChipDefesa;
            }
        }
        public virtual void Atacar(Robo robo)
        {
            robo.RecebeDano(Ataque + BonusEquipAtaque);
        }

        public virtual void RecebeDano(int dano)
        {
            var danoRecebido = dano - (Defesa + BonusEquipDefesa);
            if (danoRecebido <= 0)
                return;
            Vida -= danoRecebido;
        }

        public virtual string toString()
        {
            return "Nome: {" + this.Nome + "}, Vida: {" + this.Vida + "}, Ataque: {" + this.Ataque + "}, Defesa: {" + this.Defesa + "}";
        }

        public virtual void EquiparUpgrade(IUpgrade upgrade)
        {
            if (upgrades.Count < this.MaxUpgrades)
            {
                upgrades.Add(upgrade);
                switch (upgrade.TipoUpgrade)
                {
                    case "UpgradeDeAtaque":
                        this.BonusEquipAtaque += upgrade.BonusAtaque;
                        break;
                    case "UpgradeDeDefesa":
                        this.BonusEquipDefesa += upgrade.BonusDefesa;
                        break;
                    default:
                        this.BonusEquipAtaque += upgrade.BonusAtaque;
                        this.BonusEquipDefesa += upgrade.BonusDefesa;
                        break;
                }
            }
        }
    }
}
