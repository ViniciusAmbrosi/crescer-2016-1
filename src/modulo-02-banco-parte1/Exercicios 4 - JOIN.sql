--1)Selecione o nome do empregado e nome do departamento que cada um est� relacionado.SQL - Exerc�cios
SELECT emp.NomeEmpregado, 
       dep.NomeDepartamento
FROM Empregado emp
INNER JOIN Departamento dep ON emp.IDDepartamento = dep.IDDepartamento

--2)Exibir o nome do associado e sua cidade, exibir tamb�m associados sem Cidade relacionada.
SELECT A.Nome,
      cid.Nome
FROM Associado A
LEFT JOIN Cidade cid ON A.IDCidade = cid.IDCidade

/*3)Lista os estados (UF) e total de cidades, exibir apenas as cidades que n�o possuem associados relacionados.

Exemplo: UF Total_Cidades

RS 10

SP 5*/
SELECT cid.UF,
       count(1)
FROM Cidade cid
WHERE NOT EXISTS (SELECT IDCidade
			  FROM Associado A
			  WHERE cid.IDCidade = A.IDCidade)
GROUP BY cid.UF

--4)Fa�a uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade � da regi�o SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), sen�o imprimir nulo.
SELECT A.Nome, 
	   cid.Nome,
	   CASE WHEN cid.UF = 'RS' OR cid.UF = 'RS' OR cid.UF = 'RS' THEN '***'
			ELSE NULL
		END
FROM Associado A
INNER JOIN Cidade cid ON A.IDCidade = cid.IDCidade --considera somente associados com cidade

--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
SELECT emp.NomeEmpregado,
	   dep.NomeDepartamento DepartamentoEmpregado,
	   empG.NomeEmpregado Gerente,
	   depG.NomeDepartamento DepartamentoGerente
FROM Empregado emp 
LEFT JOIN Empregado empG ON emp.IDGerente = empG.IDEmpregado               --Mostra de todos, mesmo se nulo
LEFT JOIN Departamento dep ON emp.IDDepartamento = dep.IDDepartamento
LEFT JOIN Departamento depG ON empG.IDDepartamento = depG.IDDepartamento

--6)Fa�a uma c�pia da tabela Empregado e altere o sal�rio de todos os empregados (Empregado) que o departamento fique na localidade de SAO PAULO, fa�a um reajuste de 14,5%
SELECT *
	INTO EmpregadoReajuste
	FROM Empregado 

ALTER TABLE EmpregadoReajuste
	ADD CONSTRAINT PK_IDEmpregadoReajuste PRIMARY KEY (IDEmpregado)

ALTER TABLE EmpregadoReajuste
	ADD CONSTRAINT FK_Departamento_IDDepartamento FOREIGN KEY (IDDepartamento) REFERENCES Departamento(IDDepartamento)

UPDATE EmpregadoReajuste 
	SET Salario = Salario * 1.145
	WHERE IDDepartamento IN (SELECT IDDepartamento
							 FROM Departamento dep
					         WHERE dep.Localizacao = 'SAO PAULO')

--7)Liste a diferen�a que representar� o reajuste aplicado no item anterior no somat�rio dos sal�rios de todos os empregados.
SELECT SUM(empR.Salario) - SUM(emp.Salario) Diferen�aReajuste
FROM Empregado emp
INNER JOIN EmpregadoReajuste empR ON emp.IDEmpregado = empR.IDEmpregado

SELECT * FROM Empregado
WHERE IDDepartamento = 30 OR IDDepartamento = 10

--8)Liste o departamento com o empregado de maior sal�rio.

--Para EmpregadoReajuste
				--Considerando somente empregados com departamento
SELECT top 1 dep.NomeDepartamento
FROM EmpregadoReajuste empR
INNER JOIN Departamento dep ON empr.IDDepartamento = dep.IDDepartamento 
WHERE Salario = (SELECT MAX(Salario)
				 FROM EmpregadoReajuste
				 WHERE IDDepartamento IS NOT NULL
				 )
				--Considerando todos empregados, mesmo sem departamento
SELECT top 1dep.NomeDepartamento
FROM EmpregadoReajuste empR
INNER JOIN Departamento dep ON empr.IDDepartamento = dep.IDDepartamento 
WHERE Salario = (SELECT MAX(Salario)
				 FROM EmpregadoReajuste
				 )

--Para Empregado
				--Considerando somente empregados com departamento
SELECT top 1 dep.NomeDepartamento
FROM Empregado emp
INNER JOIN Departamento dep ON emp.IDDepartamento = dep.IDDepartamento 
WHERE Salario = (SELECT MAX(Salario)
				 FROM Empregado
				 WHERE IDDepartamento IS NOT NULL
				 )
				 --Considerando todos empregados, mesmo sem departamento
SELECT top 1 dep.NomeDepartamento
FROM Empregado emp
INNER JOIN Departamento dep ON emp.IDDepartamento = dep.IDDepartamento 
WHERE Salario = (SELECT MAX(Salario)
				 FROM Empregado
				 )

--9)Fa�a uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os empregados (nome) e a cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta.
SELECT A.nome,
       cid.Nome
FROM Associado A
INNER JOIN Cidade cid ON A.IDCidade = cid.IDCidade
UNION ALL
SELECT emp.NomeEmpregado as NomeEmpregado,
       dep.Localizacao as LocalDepartamento
FROM Empregado emp
INNER JOIN Departamento dep ON emp.IDDepartamento = dep.IDDepartamento


--10)Lista as cidades que tenham associado relacionados. Exibr: Nome e UF apenas
SELECT cid.Nome, cid.UF
FROM Cidade cid
INNER JOIN Associado A ON cid.IDCidade = A.IDCidade