using Microsoft.VisualStudio.TestTools.UnitTesting;
using JogoMegaMan;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace JogoMegaManTest
{
    namespace BotTest
    {
        [TestClass]
        public class BotTest
        {
            [TestMethod]
            public void BotTomaCincoDeDano()
            {
                var bot = new Bot();
                var botDois = new Bot();
                botDois.Atacar(bot);
                Assert.AreEqual(bot.Vida, 95);
            }

            [TestMethod]
            public void BotCausaCincoDeDano()
            {
                var bot = new Bot();
                var botDois = new Bot();
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 95);
            }

            [TestMethod]
            public void BotToString()
            {
                var bot = new Bot();
                Assert.AreEqual(bot.ToString(), "Nome: {Bot}, Vida: {100}, Ataque: {5}, Defesa: {0}");
            }

            [TestMethod]
            public void BotRecebeCanhaoPlasmaAtaqueCausa7Dano()
            {
                var bot = new Bot();
                var canhao = new CanhaoDePlasma();
                var botDois = new Bot();
                bot.EquiparUpgrade(canhao);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 93);
            }

            [TestMethod]
            public void BotRecebeEscudoDeEnergiaToma3Dano()
            {
                var bot = new Bot();
                var escudo = new EscudoDeEnergia();
                var botDois = new Bot();
                botDois.EquiparUpgrade(escudo);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 97);
            }

            [TestMethod]
            public void BotRecebeLendarioToma4Causa6Dano()
            {
                var bot = new Bot();
                var botas = new BotasDeSuperVelocidade();
                var botDois = new Bot();
                bot.EquiparUpgrade(botas);
                bot.Atacar(botDois);
                botDois.Atacar(bot);
                Assert.AreEqual(botDois.Vida, 94);
                Assert.AreEqual(bot.Vida, 96);
            }

            [TestMethod]
            public void BotTentaEquiparQuatroCanhoesRecebe6DeBonus()
            {
                var bot = new Bot();
                var canhao = new CanhaoDePlasma();
                var botDois = new Bot();
                for (int i = 0; i < 4; i++)
                {
                    bot.EquiparUpgrade(canhao);
                }
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 89);
            }

            [TestMethod]
            public void BotEquipaRushCausa9Toma2Dano()
            {
                var bot = new Bot();
                var rush = new Rush();
                var botDois = new Bot();
                bot.EquiparUpgrade(rush);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 91);
                botDois.Atacar(bot);
                Assert.AreEqual(bot.Vida, 98);
            }

            [TestMethod]
            public void BotEquipaRushEquipadoComDoisCanhoesCausa13Dano()
            {
                var bot = new Bot();
                var rush = new Rush();
                var botDois = new Bot();
                var canhao = new CanhaoDePlasma();
                rush.EquiparUpgrade(canhao);
                rush.EquiparUpgrade(canhao);
                bot.EquiparUpgrade(rush);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 87);
                botDois.Atacar(bot);
                Assert.AreEqual(bot.Vida, 98);
            }

            [TestMethod]
            public void BotEquipaRushEquipadoComDoisEscudosNaoAlteraDef()
            {
                var bot = new Bot();
                var rush = new Rush();
                var botDois = new Bot();
                var escudo = new EscudoDeEnergia();
                rush.EquiparUpgrade(escudo);
                rush.EquiparUpgrade(escudo);
                bot.EquiparUpgrade(rush);
                botDois.Atacar(bot);
                Assert.AreEqual(bot.Vida, 98);
            }

            [TestMethod]
            public void BotEquipaRushEquipadoBotasDeSuperVelocidadeECanhao()
            {
                var bot = new Bot();
                var rush = new Rush();
                var botDois = new Bot();
                var canhao = new CanhaoDePlasma();
                var botas = new BotasDeSuperVelocidade();
                rush.EquiparUpgrade(canhao);
                rush.EquiparUpgrade(botas);
                bot.EquiparUpgrade(rush);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 88);
                botDois.Atacar(bot);
                Assert.AreEqual(bot.Vida, 98);
            }

            [TestMethod]
            public void BotEquipaEscudoCanhaoERushEquipadoDoisCanhoes()
            {
                var bot = new Bot();
                var rush = new Rush();
                var botDois = new Bot();
                var canhao = new CanhaoDePlasma();
                var escudo = new EscudoDeEnergia();
                rush.EquiparUpgrade(canhao);
                rush.EquiparUpgrade(canhao);
                bot.EquiparUpgrade(rush);
                bot.EquiparUpgrade(canhao);
                bot.EquiparUpgrade(escudo);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 85);
            }

            [TestMethod]
            public void BotEquipa3RushCom2RushEquipados() //equipa 3 rush com 2 rush equipados
            {
                var bot = new Bot();
                var botDois = new Bot();
                var rush = new Rush();
                var rushEquipDeRush = new Rush();
                rush.EquiparUpgrade(rushEquipDeRush);
                rush.EquiparUpgrade(rushEquipDeRush);
                bot.EquiparUpgrade(rush);
                bot.EquiparUpgrade(rush);
                bot.EquiparUpgrade(rush);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 59);
            }

            [TestMethod]
            public void BotChipPadrao()
            {
                var bot = new Bot();
                Assert.AreEqual(bot.ToString(), "Nome: {Bot}, Vida: {100}, Ataque: {5}, Defesa: {0}");
            }

            [TestMethod]
            public void BotComChip1()
            {
                var bot = new Bot(Chip.Nivel1);
                Assert.AreEqual(bot.ToString(), "Nome: {Bot}, Vida: {100}, Ataque: {4}, Defesa: {0}");
            }

            [TestMethod]
            public void BotComChip1AtacaChip1()
            {
                var bot = new Bot(Chip.Nivel1);
                var botDois = new Bot(Chip.Nivel1);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 96);

            }

            [TestMethod]
            public void BotComChip1AtacaChip3()
            {
                var bot = new Bot(Chip.Nivel1);
                var botDois = new Bot(Chip.Nivel3);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 97);

            }

            [TestMethod]
            public void BotComChip2()
            {
                var bot = new Bot(Chip.Nivel2);
                Assert.AreEqual(bot.ToString(), "Nome: {Bot}, Vida: {100}, Ataque: {5}, Defesa: {0}");
            }

            [TestMethod]
            public void BotComChip2AtacaChip1()
            {
                var bot = new Bot(Chip.Nivel2);
                var botDois = new Bot(Chip.Nivel1);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 95);

            }

            [TestMethod]
            public void BotComChip2AtacaChip3()
            {
                var bot = new Bot(Chip.Nivel2);
                var botDois = new Bot(Chip.Nivel3);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 96);

            }

            [TestMethod]
            public void BotComChip3()
            {
                var bot = new Bot(Chip.Nivel3);
                Assert.AreEqual(bot.ToString(), "Nome: {Bot}, Vida: {100}, Ataque: {7}, Defesa: {1}");

            }

            [TestMethod]
            public void BotComChip3AtacaChip1()
            {
                var bot = new Bot(Chip.Nivel3);
                var botDois = new Bot(Chip.Nivel1);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 93);

            }

            [TestMethod]
            public void BotComChip3AtacaChip3()
            {
                var bot = new Bot(Chip.Nivel3);
                var botDois = new Bot(Chip.Nivel3);
                bot.Atacar(botDois);
                Assert.AreEqual(botDois.Vida, 94);
            }

        }
    }
}




