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
            Assert.AreEqual(rush.toString(), "Nome: {Rush}, Vida: {100}, Ataque: {4}, Defesa: {3}");
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
        public void RushEquipaRushTem8Dano6Defesa()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            rush.EquiparUpgrade(rushEquip);
            Assert.AreEqual(rush.toString(), "Nome: {Rush}, Vida: {100}, Ataque: {8}, Defesa: {6}");
        }

        [TestMethod]
        public void RushEquipaRushEquipadoComDoisCanhoesCausa13Dano()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var canhao = new CanhaoDePlasma();
            rushEquip.EquiparUpgrade(canhao);
            rushEquip.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(rushEquip);
            Assert.AreEqual(rush.toString(), "Nome: {Rush}, Vida: {100}, Ataque: {12}, Defesa: {6}");
        }

        [TestMethod]
        public void RushEquipaRushEquipadoComDoisEscudosNaoAlteraDef()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var escudo = new EscudoDeEnergia();
            rushEquip.EquiparUpgrade(escudo);
            rushEquip.EquiparUpgrade(escudo);
            rush.EquiparUpgrade(rushEquip);
            Assert.AreEqual(rush.toString(), "Nome: {Rush}, Vida: {100}, Ataque: {8}, Defesa: {6}");
        }

        [TestMethod]
        public void RushEquipaRushEquipadoBotasDeSuperVelocidadeECanhao()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var canhao = new CanhaoDePlasma();
            var botas = new BotasDeSuperVelocidade();
            rushEquip.EquiparUpgrade(canhao);
            rushEquip.EquiparUpgrade(botas);
            rush.EquiparUpgrade(rushEquip);
            Assert.AreEqual(rush.toString(), "Nome: {Rush}, Vida: {100}, Ataque: {11}, Defesa: {6}");
        }

        [TestMethod]
        public void RushEquipaEscudoERushEquipadoDoisCanhoes()
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            rushEquip.EquiparUpgrade(canhao);
            rushEquip.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(rushEquip);
            rush.EquiparUpgrade(canhao);
            Assert.AreEqual(rush.toString(), "Nome: {Rush}, Vida: {100}, Ataque: {14}, Defesa: {6}");
        }

        [TestMethod]
        public void RushEquipa2RushCom2RushEquipados() //equipa 3 rush com 2 rush equipados
        {
            var rush = new Rush();
            var rushEquip = new Rush();
            var rushEquipDeRush = new Rush();
            rushEquip.EquiparUpgrade(rushEquipDeRush);
            rushEquip.EquiparUpgrade(rushEquipDeRush);
            rush.EquiparUpgrade(rushEquip);
            rush.EquiparUpgrade(rushEquip);
            Assert.AreEqual(rush.toString(), "Nome: {Rush}, Vida: {100}, Ataque: {28}, Defesa: {9}");
        }
    }
}
    
