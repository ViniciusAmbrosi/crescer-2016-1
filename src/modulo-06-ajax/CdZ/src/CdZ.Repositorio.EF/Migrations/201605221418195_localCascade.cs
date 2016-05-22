namespace CdZ.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class localCascade : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local");
            AddForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local");
            AddForeignKey("dbo.Cavaleiro", "LocalNascimento_Id", "dbo.Local", "Id");
        }
    }
}
