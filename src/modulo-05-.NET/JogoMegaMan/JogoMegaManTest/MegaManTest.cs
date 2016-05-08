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
    public class MegaManTest
    {
        [TestMethod]
        public void MegaManCausaSeisDeDano()
        {
            var bot = new Bot();
            var megaman = new MegaMan();
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 94);
        }

        [TestMethod]
        public void MegaManTomaCincoDano()
        {
            var bot = new Bot();
            var megaman = new MegaMan();
            bot.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 95);
        }

        [TestMethod]
        public void MegaManCausaNoveDeDano()
        {
            var bot = new Bot();
            var megaman = new MegaMan();
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaman);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 91);
        }


        [TestMethod]
        public void MegaManToString()
        {
            var megaman = new MegaMan();
            Assert.AreEqual(megaman.toString(), "Nome: {Megaman}, Vida: {100}, Ataque: {6}, Defesa: {0}");
        }

        [TestMethod]
        public void MegaManRecebeCanhaoPlasmaAtaqueCausa8Dano()
        {
            var megaman = new MegaMan();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            megaman.EquiparUpgrade(canhao);
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 92);
        }

        [TestMethod]
        public void MegaManRecebeEscudoDeEnergiaToma3Dano()
        {
            var megaman = new MegaMan();
            var escudo = new EscudoDeEnergia();
            var bot = new Bot();
            megaman.EquiparUpgrade(escudo);
            bot.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 97);
        }

        [TestMethod]
        public void MegaManRecebeLendarioToma4Causa7Dano()
        {
            var megaman = new MegaMan();
            var botas = new BotasDeSuperVelocidade();
            var bot = new Bot();
            megaman.EquiparUpgrade(botas);
            megaman.Atacar(bot);
            bot.Atacar(megaman);
            Assert.AreEqual(bot.Vida, 93);
            Assert.AreEqual(megaman.Vida, 96);
        }

        [TestMethod]
        public void MegaManTentaEquiparQuatroCanhoesRecebe6DeBonus()
        {
            var megaman = new MegaMan();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            for (int i = 0; i < 4; i++)
            {
                megaman.EquiparUpgrade(canhao);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 88);
        }

        [TestMethod]
        public void MegaManComEquipETrintaDeVida()
        {
            var megaman = new MegaMan();
            var canhao = new CanhaoDePlasma();
            var bot = new Bot();
            for (int i = 0; i < 4; i++)
            {
                megaman.EquiparUpgrade(canhao);
            }
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaman);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(bot.Vida, 85);
        }

        [TestMethod]
        public void MegaManEquipaRushCausa9Toma2Dano()
        {
            var megaman = new MegaMan();
            var rush = new Rush();
            var botDois = new Bot();
            megaman.EquiparUpgrade(rush);
            megaman.Atacar(botDois);
            Assert.AreEqual(botDois.Vida, 90);
            botDois.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 98);
        }

        [TestMethod]
        public void MegaManEquipaRushEquipadoComDoisCanhoesCausa14Dano()
        {
            var megaman = new MegaMan();
            var rush = new Rush();
            var botDois = new Bot();
            var canhao = new CanhaoDePlasma();
            rush.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(canhao);
            megaman.EquiparUpgrade(rush);
            megaman.Atacar(botDois);
            Assert.AreEqual(botDois.Vida, 86);
            botDois.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 98);
        }

        [TestMethod]
        public void MegaManEquipaRushEquipadoComDoisEscudosNaoAlteraDef()
        {
            var megaman = new MegaMan();
            var rush = new Rush();
            var botDois = new Bot();
            var escudo = new EscudoDeEnergia();
            rush.EquiparUpgrade(escudo);
            rush.EquiparUpgrade(escudo);
            megaman.EquiparUpgrade(rush);
            botDois.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 98);
        }

        [TestMethod]
        public void MegaManEquipaRushEquipadoBotasECanhao()
        {
            var megaman = new MegaMan();
            var rush = new Rush();
            var botDois = new Bot();
            var botas = new BotasDeSuperVelocidade();
            var canhao = new CanhaoDePlasma();
            rush.EquiparUpgrade(botas);
            rush.EquiparUpgrade(canhao);
            megaman.EquiparUpgrade(rush);
            megaman.Atacar(botDois);
            Assert.AreEqual(botDois.Vida, 87);
            botDois.Atacar(megaman);
            Assert.AreEqual(megaman.Vida, 98);
        }

        [TestMethod]
        public void MegaManEquipaEscudoCanhaoERushEquipadoDoisCanhoes()
        {
            var megaman = new MegaMan();
            var rush = new Rush();
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            rush.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(canhao);
            megaman.EquiparUpgrade(rush);
            megaman.EquiparUpgrade(canhao);
            megaman.EquiparUpgrade(escudo);
            Assert.AreEqual(megaman.toString(), "Nome: {Megaman}, Vida: {100}, Ataque: {16}, Defesa: {5}");
        }

        [TestMethod]
        public void MegaManEquipa3RushCom2RushEquipados()
        {
            var megaman = new MegaMan();
            var rush = new Rush();
            var rushEquipDeRush = new Rush();
            rush.EquiparUpgrade(rushEquipDeRush);
            rush.EquiparUpgrade(rushEquipDeRush);
            megaman.EquiparUpgrade(rush);
            megaman.EquiparUpgrade(rush);
            megaman.EquiparUpgrade(rush);
            Assert.AreEqual(megaman.toString(), "Nome: {Megaman}, Vida: {100}, Ataque: {42}, Defesa: {9}");
        }
    }
}
