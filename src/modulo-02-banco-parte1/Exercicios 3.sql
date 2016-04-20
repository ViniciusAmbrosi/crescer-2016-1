--Consulta primeiro nome associados 
SELECT 
	LEFT(Nome, CHARINDEX(' ', Nome)) as Nome
	FROM Associado

SELECT Nome,
	   DateDiff(YEAR, DataNascimento, getDate()) as Idade
	FROM Associado;

SELECT NomeEmpregado, DATEDIFF(month, DataAdmissao, convert(datetime, '31/12/2000', 103)) as Meses de Trabalho
	FROM Empregado
	WHERE DataAdmissao BETWEEN convert(datetime, '01/05/1980', 103) AND convert(datetime, '20/01/1982', 103);

SELECT TOP 1 Cargo as CargoMaisPopuloso, COUNT(Cargo)
    FROM Empregado
	GROUP BY Cargo
	ORDER BY Cargo DESC
