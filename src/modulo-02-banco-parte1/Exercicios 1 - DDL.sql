--considerando valores previamente inseridos por lab2
--insere associados
INSERT INTO Associado
		(IDAssociado, Nome, DataNascimento, Sexo, CPF)
	VALUES
		(3, 'Julio de Castilhos', convert(datetime, '14/12/1947', 103), 'M', '21234567895'),
		(4, 'Antonio Augusto Borges de Medeiros', convert(datetime, '19/03/1942', 103), 'M', '81234567891'),
		(5, 'Osvaldo Aranha', convert(datetime, '08/02/1958', 103), 'M', '01234567893');

--copia cidade para cidadeaux
Select * 
	INTO CidadeAux
	FROM Cidade;

--limpa cidadeaux
TRUNCATE TABLE CidadeAux;

--passa todos elementos de cidade para cidadeaux
INSERT INTO CidadeAux
SELECT * FROM Cidade;

--cria tabela produto
CREATE TABLE Produto
(
	IDProduto		int			 NOT NULL,
	Nome			varchar(15)  NOT NULL,
	NomeDescritivo	varchar(35),
	DataCriacao		datetime     NOT NULL,
	LocalEstoque	varchar(25),
	Quantidade		int,
	Preco			decimal(7,3),	  
	CONSTRAINT PK_Produto PRIMARY KEY (IDProduto),
	CONSTRAINT UK_Nome    UNIQUE	  (Nome)
);

--insere elementos em produto
INSERT INTO Produto
		(IDProduto, Nome, Preco, DataCriacao)
	VALUES
		(1, 'Notebook', 2800, getDate()),
		(2, 'Mouse', 50, getDate())

