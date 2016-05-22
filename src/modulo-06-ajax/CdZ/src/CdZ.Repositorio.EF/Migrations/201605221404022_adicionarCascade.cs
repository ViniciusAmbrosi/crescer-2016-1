namespace CdZ.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarCascade : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropIndex("dbo.Golpe", new[] { "Cavaleiro_Id" });
            DropIndex("dbo.Imagem", new[] { "Cavaleiro_Id" });
            AlterColumn("dbo.Golpe", "Cavaleiro_Id", c => c.Int(nullable: false));
            AlterColumn("dbo.Imagem", "Cavaleiro_Id", c => c.Int(nullable: false));
            CreateIndex("dbo.Golpe", "Cavaleiro_Id");
            CreateIndex("dbo.Imagem", "Cavaleiro_Id");
            AddForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro", "Id", cascadeDelete: true);
            AddForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro");
            DropIndex("dbo.Imagem", new[] { "Cavaleiro_Id" });
            DropIndex("dbo.Golpe", new[] { "Cavaleiro_Id" });
            AlterColumn("dbo.Imagem", "Cavaleiro_Id", c => c.Int());
            AlterColumn("dbo.Golpe", "Cavaleiro_Id", c => c.Int());
            CreateIndex("dbo.Imagem", "Cavaleiro_Id");
            CreateIndex("dbo.Golpe", "Cavaleiro_Id");
            AddForeignKey("dbo.Imagem", "Cavaleiro_Id", "dbo.Cavaleiro", "Id");
            AddForeignKey("dbo.Golpe", "Cavaleiro_Id", "dbo.Cavaleiro", "Id");
        }
    }
}
