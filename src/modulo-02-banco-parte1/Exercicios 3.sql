--TERCEIRA LISTA DE EXERCICIOS
--Exercício 1
SELECT 
	LEFT(Nome, CHARINDEX(' ', Nome)) as Nome
	FROM Associado

--Exercício 2
SELECT Nome,
	   DateDiff(YEAR, DataNascimento, getDate()) as Idade
	FROM Associado;

--Exercício 3
SELECT NomeEmpregado,
	   DATEDIFF(month, DataAdmissao, convert(datetime, '31/12/2000', 103)) as Meses_de_Trabalho
	FROM Empregado
	WHERE DataAdmissao BETWEEN convert(datetime, '01/05/1980', 103) AND convert(datetime, '20/01/1982', 103);

--Exercício 4
SELECT TOP 1 Cargo as CargoMaisPopuloso, COUNT(Cargo) AS Top_Vendedor
    FROM Empregado
	GROUP BY Cargo
	ORDER BY Top_Vendedor DESC

SELECT * FROM Empregado
--Exercício 6
SELECT Nome,
	   DATEADD(YEAR, 50, convert(date, DataNascimento)) as Completa50AnosEm,
	   DATENAME(dw, DATEADD(YEAR, 50, convert(date, DataNascimento))) as RespectivoDiaDaSemana
	FROM Associado

--Exercício 7
SELECT UF, COUNT(UF)
	FROM Cidade
	GROUP BY UF

--Exercício 8
SELECT Nome
	FROM Cidade
	GROUP BY Nome
	HAVING COUNT(1) > 1

--Exercício 9
SELECT (MAX(IDAssociado) + 1) as ProximoID
	FROM Associado

--Exercício 10
TRUNCATE TABLE CidadeAux;

INSERT INTO CidadeAux
	(IDCidade, 
	 Nome,
	 UF)
	SELECT  
		min(IDCidade), 
		Nome, 
		UF 
	FROM Cidade
	GROUP BY Nome, UF

--Exercício 11
UPDATE Cidade
SET Nome = '*' + cidade2.Nome
	FROM (
		  SELECT Nome FROM CIDADE
   		  GROUP BY Nome		
		  HAVING COUNT(Nome) > 1
		  ) AS cidade2
	WHERE Cidade.Nome = cidade2.Nome

--Exercício 11.2 Atualiza maior ID de nome com '*' somente duplicados
UPDATE Cidade
SET Nome = '*' + Cidade3.Nome
  FROM(
		SELECT MAX(IDCidade) AS IDCidade2, Nome FROM CIDADE
		GROUP BY Nome
		HAVING COUNT(Nome) > 1
		) AS Cidade3
	WHERE Cidade.IDCidade = Cidade3.IDCidade2

--Exercício 12
SELECT Nome,
	   CASE UPPER(Sexo) WHEN 'F' THEN 'Feminino'
						WHEN 'M' THEN 'Masculino'
	   END 
FROM Associado

--Exercício 13
SELECT NomeEmpregado,
	   Salario,
	   CASE WHEN Salario < 1164 THEN '0%'
			WHEN Salario > 2326 THEN '27,5%'
			ELSE '15%'
	   END PercentualImpostoDeRenda
FROM Empregado

--Exercício 14 Busca de forma diferente do exercicio 11, utilizando agora os '*'
DELETE Cidade
	FROM 
		(
		 SELECT max(IDCidade) AS ID FROM Cidade
		 WHERE Nome LIKE '*%'
		 GROUP BY Nome
		) as Cidade2
	WHERE Cidade.IDCidade = Cidade2.ID

--Exercício 14.2 Busca baseado em 11.2m onde tem * somente nos duplicados de maior ID
DELETE Cidade
	WHERE Nome LIKE '*%';


--Exercício 15
ALTER TABLE Cidade 
ADD CONSTRAINT UK_Cidade_Nome_UF UNIQUE (Nome, UF)

--Adicionais ( tirar '*' dos nomes das cidades ) e testar nova constraint
--Remove '*'
UPDATE Cidade
SET Nome = RIGHT(Nome, LEN(Nome)-1)
WHERE Nome LIKE '*%';

--Testa Constraint
BEGIN TRANSACTION
INSERT INTO Cidade
	(IDCidade, Nome, UF)
	VALUES 
	(2412, 'Rio de Janeiro', 'RS');
	SELECT * FROM Cidade
ROLLBACK

