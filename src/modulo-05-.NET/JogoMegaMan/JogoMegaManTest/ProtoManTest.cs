using JogoMegaMan;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JogoMegaManTest
{
    namespace JogoProtoManTest
    {
        [TestClass]
        public class ProtoManTest
        {
            [TestMethod]
            public void ProtoManCausaCincoDeDano()
            {
                var bot = new Bot();
                var protoman = new ProtoMan();
                protoman.Atacar(bot);
                Assert.AreEqual(bot.Vida, 95);
            }

            [TestMethod]
            public void ProtoManTomaTresDano()
            {
                var bot = new Bot();
                var protoman = new ProtoMan();
                bot.Atacar(protoman);
                Assert.AreEqual(protoman.Vida, 97);
            }

            [TestMethod]
            public void ProtoManMorreEReviveCom20DeVida()
            {
                var bot = new Bot();
                var protoman = new ProtoMan();
                for (int i = 0; i < 34; i++)
                {
                    bot.Atacar(protoman);
                }
                Assert.AreEqual(protoman.Vida, 20);
            }

            [TestMethod]
            public void ProtoManMorreNaoReviveDuasVezes()
            {
                var bot = new Bot();
                var protoman = new ProtoMan();
                for (int i = 0; i < 41; i++)
                {
                    bot.Atacar(protoman);
                }
                Assert.AreEqual(protoman.Vida, -1);
            }

            [TestMethod]
            public void ProtoManCausaSeteDeDano()
            {
                var bot = new Bot();
                var protoman = new ProtoMan();
                for (int i = 0; i < 34; i++)
                {
                    bot.Atacar(protoman);
                }
                protoman.Atacar(bot);
                Assert.AreEqual(bot.Vida, 93);
            }


            [TestMethod]
            public void ProtoManToString()
            {
                var protoman = new ProtoMan();
                Assert.AreEqual(protoman.toString(), "Nome: {Protoman}, Vida: {100}, Ataque: {5}, Defesa: {2}");
            }

            [TestMethod]
            public void ProtoManRecebeCanhaoPlasmaAtaqueCausa7Dano()
            {
                var protoman = new ProtoMan();
                var canhao = new CanhaoDePlasma();
                var bot = new Bot();
                protoman.EquiparUpgrade(canhao);
                protoman.Atacar(bot);
                Assert.AreEqual(bot.Vida, 93);
            }

            [TestMethod]
            public void ProtoManRecebeEscudoDeEnergiaToma1Dano()
            {
                var protoman = new ProtoMan();
                var escudo = new EscudoDeEnergia();
                var bot = new Bot();
                protoman.EquiparUpgrade(escudo);
                bot.Atacar(protoman);
                Assert.AreEqual(protoman.Vida, 99);
            }

            [TestMethod]
            public void ProtoManRecebeLendarioToma2Causa6Dano()
            {
                var protoman = new ProtoMan();
                var botas = new BotasDeSuperVelocidade();
                var bot = new Bot();
                protoman.EquiparUpgrade(botas);
                protoman.Atacar(bot);
                bot.Atacar(protoman);
                Assert.AreEqual(bot.Vida, 94);
                Assert.AreEqual(protoman.Vida, 98);
            }

            [TestMethod]
            public void ProtoManTentaEquiparQuatroCanhoesRecebe6DeBonus()
            {
                var protoman = new ProtoMan();
                var canhao = new CanhaoDePlasma();
                var bot = new Bot();
                for (int i = 0; i < 4; i++)
                {
                    protoman.EquiparUpgrade(canhao);
                }
                protoman.Atacar(bot);
                Assert.AreEqual(bot.Vida, 89);
            }

            [TestMethod]
            public void ProtoManComEquipERevividoCausa13()
            {
                var protoman = new ProtoMan();
                var canhao = new CanhaoDePlasma();
                var bot = new Bot();
                for (int i = 0; i < 4; i++)
                {
                    protoman.EquiparUpgrade(canhao);
                }
                for (int i = 0; i < 40; i++)
                {
                    bot.Atacar(protoman);
                }
                protoman.Atacar(bot);
                Assert.AreEqual(bot.Vida, 87);
            }


            [TestMethod]
            public void ProtoManEquipaRushCausa9Toma0Dano()
            {
                var protoman = new ProtoMan();
                var rush = new Rush();
                var botDois = new Bot();
                protoman.EquiparUpgrade(rush);
                protoman.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 91);
                botDois.Atacar(protoman);
                Assert.AreEqual(protoman.Vida, 100);
            }

            [TestMethod]
            public void ProtoManEquipaRushEquipadoComDoisCanhoesCausa13Dano()
            {
                var protoman = new ProtoMan();
                var rush = new Rush();
                var botDois = new Bot();
                var canhao = new CanhaoDePlasma();
                rush.EquiparUpgrade(canhao);
                rush.EquiparUpgrade(canhao);
                protoman.EquiparUpgrade(rush);
                protoman.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 87);
                botDois.Atacar(protoman);
                Assert.AreEqual(protoman.Vida, 100);
            }

            [TestMethod]
            public void ProtoManEquipaRushEquipadoComDoisEscudosNaoAlteraDef()
            {
                var protoman = new ProtoMan();
                var rush = new Rush();
                var botDois = new Bot();
                var escudo = new EscudoDeEnergia();
                rush.EquiparUpgrade(escudo);
                rush.EquiparUpgrade(escudo);
                protoman.EquiparUpgrade(rush);
                Assert.AreEqual(protoman.toString(), "Nome: {Protoman}, Vida: {100}, Ataque: {9}, Defesa: {5}");
            }

            [TestMethod]
            public void ProtoManEquipaRushEquipadoComBotasECanhao()
            {
                var protoman = new ProtoMan();
                var rush = new Rush();
                var botDois = new Bot();
                var canhao = new CanhaoDePlasma();
                var botas = new BotasDeSuperVelocidade();
                rush.EquiparUpgrade(canhao);
                rush.EquiparUpgrade(botas);
                protoman.EquiparUpgrade(rush);
                protoman.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 88);
                botDois.Atacar(protoman);
                Assert.AreEqual(protoman.Vida, 100);
            }

            [TestMethod]
            public void MegaManEquipaEscudoCanhaoERushEquipadoDoisCanhoes()
            {
                var protoman = new ProtoMan();
                var rush = new Rush();
                var canhao = new CanhaoDePlasma();
                var escudo = new EscudoDeEnergia();
                rush.EquiparUpgrade(canhao);
                rush.EquiparUpgrade(canhao);
                protoman.EquiparUpgrade(rush);
                protoman.EquiparUpgrade(canhao);
                protoman.EquiparUpgrade(escudo);
                Assert.AreEqual(protoman.toString(), "Nome: {Protoman}, Vida: {100}, Ataque: {15}, Defesa: {7}");
            }

            [TestMethod]
            public void ProtoManEquipa3RushCom2RushEquipados()
            {
                var protoman = new ProtoMan();
                var rush = new Rush();
                var rushEquipDeRush = new Rush();
                rush.EquiparUpgrade(rushEquipDeRush);
                rush.EquiparUpgrade(rushEquipDeRush);
                protoman.EquiparUpgrade(rush);
                protoman.EquiparUpgrade(rush);
                protoman.EquiparUpgrade(rush);
                Assert.AreEqual(protoman.toString(), "Nome: {Protoman}, Vida: {100}, Ataque: {41}, Defesa: {11}");
            }
        }
    }
}