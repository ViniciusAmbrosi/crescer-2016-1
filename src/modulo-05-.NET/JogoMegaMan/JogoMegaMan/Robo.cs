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

        public int Vida { get; protected set; }

        protected virtual int MaxUpgrades
        {
            get { return 3; }
        }

        public Robo()
        {
            Vida = 100;
        }
        protected virtual int Ataque
        {
            get
            {
                return 5 + BonusEquipAtaque;
            }
        }
        protected virtual int Defesa
        {
            get
            {
                return 0 + BonusEquipDefesa;
            }
        }
        public virtual void Atacar(Robo robo)
        {
            robo.RecebeDano(Ataque);
        }

        public virtual void RecebeDano(int dano)
        {
            Vida -= (dano - this.Defesa);
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
