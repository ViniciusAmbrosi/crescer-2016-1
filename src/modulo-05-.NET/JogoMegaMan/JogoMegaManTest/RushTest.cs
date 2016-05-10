using JogoMegaMan;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaManTest
{
    [TestClass]
    public class RushTest
    {

        [TestMethod]
        public void RushTomaDoisDeDano()
        {
            var rush = new Rush();
            var bot = new Bot();
            bot.Atacar(rush);
            Assert.AreEqual(rush.Vida, 98);
        }

        [TestMethod]
        public void RushCausaQuatroDeDano()
        {
            var rush = new Rush();
            var bot = new Bot();
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 96);
        }

        [TestMethod]
        public void RushToString()
        {
            var rush = new Rush();
            Assert.AreEqual(rush.ToString(), "Nome: {Rush}, Vida: {100}, Ataque: {4}, Defesa: {3}");
        }

        [TestMethod]
        public void RushRecebeCanhaoPlasmaAtaqueCausa6Dano()
        {
            var rush = new Rush();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            rush.EquiparUpgrade(canhao);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 94);
        }

        [TestMethod]
        public void RushRecebeEscudoDeEnergiaTomaZeroDano()
        {
            var rush = new Rush();
            var escudo = new EscudoDeEnergia();
            var bot = new Bot();
            rush.EquiparUpgrade(escudo);
            bot.Atacar(rush);
            Assert.AreEqual(bot.Vida, 100);
        }

        [TestMethod]
        public void RushRecebeLendarioToma1Causa5Dano()
        {
            var rush = new Rush();
            var botas = new BotasDeSuperVelocidade();
            var bot = new Bot();
            rush.EquiparUpgrade(botas);
            rush.Atacar(bot);
            bot.Atacar(rush);
            Assert.AreEqual(bot.Vida, 95);
            Assert.AreEqual(rush.Vida, 99);
        }

        [TestMethod]
        public void RushTentaEquiparTresCanhoesRecebe4DeBonus()
        {
            var rush = new Rush();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            for (int i = 0; i < 3; i++)
            {
                rush.EquiparUpgrade(canhao);
            }
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 92);
        }

        [TestMethod]
        public void RushEquipaRushCausa8Dano()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var bot = new Bot();
            rush.EquiparUpgrade(rushEquip);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 92);
        }

        [TestMethod]
        public void RushEquipaRushEquipadoComDoisCanhoesCausa12Dano()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            rushEquip.EquiparUpgrade(canhao);
            rushEquip.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(rushEquip);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 88);
        }

        [TestMethod]
        public void RushEquipaRushEquipadoComDoisEscudosNaoAlteraDef()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var escudo = new EscudoDeEnergia();
            var bot = new Bot();
            rushEquip.EquiparUpgrade(escudo);
            rushEquip.EquiparUpgrade(escudo);
            rush.EquiparUpgrade(rushEquip);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 92);
            bot.Atacar(rush);
            Assert.AreEqual(rush.Vida, 100);
            Assert.AreEqual(rush.ToString(), "Nome: {Rush}, Vida: {100}, Ataque: {4}, Defesa: {3}");
        }

        [TestMethod]
        public void RushEquipaRushEquipadoBotasDeSuperVelocidadeECanhao()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var canhao = new CanhaoDePlasma();
            var botas = new BotasDeSuperVelocidade();
            var bot = new Bot();
            rushEquip.EquiparUpgrade(canhao);
            rushEquip.EquiparUpgrade(botas);
            rush.EquiparUpgrade(rushEquip);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 89);
            bot.Atacar(rush);
            Assert.AreEqual(rush.Vida, 100);
        }

        [TestMethod]
        public void RushEquipaEscudoERushEquipadoDoisCanhoes()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            var bot = new Bot();
            rushEquip.EquiparUpgrade(canhao);
            rushEquip.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(rushEquip);
            rush.EquiparUpgrade(canhao);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 86);
        }

        [TestMethod]
        public void RushEquipa2RushCom2RushEquipados() //equipa 3 rush com 2 rush equipados
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var rushEquipDeRush = new Rush();
            var bot = new Bot();
            rushEquip.EquiparUpgrade(rushEquipDeRush);
            rushEquip.EquiparUpgrade(rushEquipDeRush);
            rush.EquiparUpgrade(rushEquip);
            rush.EquiparUpgrade(rushEquip);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 72);
            Assert.AreEqual(rush.ToString(), "Nome: {Rush}, Vida: {100}, Ataque: {4}, Defesa: {3}");
        }

        [TestMethod]
        public void RushChipPadrao()
        {
            var rush = new Rush();
            Assert.AreEqual(rush.ToString(), "Nome: {Rush}, Vida: {100}, Ataque: {4}, Defesa: {3}");
        }

        [TestMethod]
        public void RushComChip1()
        {
            var rush = new Rush(Chip.Nivel1);
            Assert.AreEqual(rush.ToString(), "Nome: {Rush}, Vida: {100}, Ataque: {3}, Defesa: {3}");
        }

        [TestMethod]
        public void RushComChip1AtacaChip1()
        {
            var rush = new Rush(Chip.Nivel1);
            var bot = new Bot(Chip.Nivel1);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 97);

        }

        [TestMethod]
        public void RushComChip1AtacaChip3()
        {
            var rush = new Rush(Chip.Nivel1);
            var bot = new Bot(Chip.Nivel3);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 98);

        }

        [TestMethod]
        public void RushComChip2()
        {
            var rush = new Rush(Chip.Nivel2);
            Assert.AreEqual(rush.ToString(), "Nome: {Rush}, Vida: {100}, Ataque: {4}, Defesa: {3}");
        }

        [TestMethod]
        public void RushComChip2AtacaChip1()
        {
            var rush = new Rush(Chip.Nivel2);
            var bot = new Bot(Chip.Nivel1);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 96);

        }

        [TestMethod]
        public void RushComChip2AtacaChip3()
        {
            var rush = new Rush(Chip.Nivel2);
            var bot = new Bot(Chip.Nivel3);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 97);

        }

        [TestMethod]
        public void RushComChip3()
        {
            var rush = new Rush(Chip.Nivel3);
            Assert.AreEqual(rush.ToString(), "Nome: {Rush}, Vida: {100}, Ataque: {6}, Defesa: {4}");

        }

        [TestMethod]
        public void RushComChip3AtacaChip1()
        {
            var rush = new Rush(Chip.Nivel3);
            var bot = new Bot(Chip.Nivel1);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 94);

        }

        [TestMethod]
        public void RushComChip3AtacaChip3()
        {
            var rush = new Rush(Chip.Nivel3);
            var bot = new Bot(Chip.Nivel3);
            rush.Atacar(bot);
            Assert.AreEqual(bot.Vida, 95);
        }

        [TestMethod]
        public void RushNaoAtacaMegaMan()
        {
            var rush = new Rush(Chip.Nivel3);
            var megaman = new MegaMan(Chip.Nivel3);
            rush.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 100);
        }
    }
}
    
