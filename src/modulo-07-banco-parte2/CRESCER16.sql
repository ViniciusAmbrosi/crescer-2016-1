SELECT * FROM USER_TABLES;

--1) Liste os clientes e suas respectivas cidades. 
  --a. IDCliente, Nome, Nome da Cidade e UF.

SELECT cl.IDCLIENTE, cl.NOME, cid.NOME, cid.UF  FROM
CLIENTE cl
INNER JOIN Cidade cid ON cl.IDCIDADE = cid.IDCIDADE;

--2) Liste o total de pedidos realizados no mês de maio de 2016.
  --(Dica: verifique o uso do TO_DATE para conversão de String em Date).

SELECT COUNT(1) FROM PEDIDO WHERE DATAPEDIDO BETWEEN TO_DATE('01-05-2016') AND TO_DATE('01-05-2016');
--TO_DATE('31-05-2016')+.99999
--3) Liste todos os clientes que tenham o LTDA no nome ou razao social.

SELECT * FROM CLIENTE WHERE UPPER(RAZAOSOCIAL) LIKE '%LTDA%' OR UPPER(NOME) LIKE '%LTDA%';

--4) Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
/*Nome: Galocha Maragato
Preço de custo: 35.67
Preço de venda: 77.95
Situação: A*/

CREATE SEQUENCE SQPRODUTO START WITH 8001;

INSERT INTO PRODUTO (IDPRODUTO, NOME, PRECOCUSTO, PRECOVENDA, SITUACAO)
VALUES (SQPRODUTO.nextval, 'Galocha Maragato', 35.67, 77.95, 'A');

commit;

--5) Identifique e liste os produtos que não tiveram nenhum pedido,
--considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
--Obs.: o produto criado anteriormente deverá ser listado (apenas este)

SELECT ped.NOME, ped.DATACADASTRO, ped.PRECOCUSTO, ped.PRECOVENDA, ped.SITUACAO
FROM PRODUTO ped
WHERE NOT EXISTS (SELECT * FROM PEDIDOITEM peditem
                  WHERE ped.IDPRODUTO = peditem.IDPRODUTO);
                  
/*6) Liste todos os pedidos de um determinado cliente, considere que sempre que for executar esta consulta será informado o IDCliente como parâmetro.
Deverão ser listados: Data do Pedido, Produto, Quantide, Valor Unitário, e valor total.
Exemplo: SELECT Nome FROM Cliente WHERE IDCliente = :pIDCliente
Neste exemplo será solicitado que informe o parâmetro para execução da consulta.*/

SELECT ped.DATAPEDIDO as DATA,prod.NOME as PRODUTO, peditem.QUANTIDADE, peditem.PRECOUNITARIO, ped.VALORPEDIDO
FROM PEDIDO ped
INNER JOIN PEDIDOITEM peditem ON ped.IDPEDIDO = peditem.IDPEDIDO
INNER JOIN PRODUTO prod ON peditem.IDPRODUTO = prod.IDPRODUTO
WHERE ped.IDCLIENTE = :produto;

/*7) Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com 
este IDProduto foram vendidos no último ano (desde janeiro/2016)*/

SELECT SUM(peditem.QUANTIDADE) as Quantidade_Vendas_2016 -- cuidar valores numlos para nao dar jabu, usar sum(nvl(quantidade,0))
FROM PEDIDOITEM peditem
INNER JOIN PEDIDO ped ON peditem.IDPEDIDO = ped.IDPEDIDO
WHERE peditem.IDPRODUTO = :idproduto AND ped.DATAPEDIDO BETWEEN TO_DATE('01-01-2016') AND TO_DATE('31-12-2016');

/*8) Utilizando de funções de agrupamento (aggregation function), faça uma consulta que liste agrupando por ano e mês a quantidade 
de pedidos comprados, a quantidade de produtos distintos comprados, o valor total dos pedidos, o menor valor de um pedido, 
o maior valor de um pedido e valor médio de um pedido.
(Dica: a função TO_CHAR permite converter Dates em String considerando formatos específicos).*/

SELECT TO_CHAR(ped.DATAPEDIDO, 'MON-YYYY') as datas, 
       COUNT(DISTINCT peditem.IDPEDIDO) Total_Pedidos,
       COUNT(DISTINCT peditem.IDPRODUTO) Produtos_Distintos,
       /*SUM(peditem.Quantidade) AS Vendas_Quantidade_Total,
       SUM(DISTINCT peditem.Quantidade) AS Vendas_Quantidade_Produtos ,*/ 
       SUM(VALORPEDIDO) AS Valor_Total,
       MIN(VALORPEDIDO) AS Valor_Menor,
       MAX(VALORPEDIDO) AS Valor_Maior, 
       ROUND(AVG(VALORPEDIDO),2) AS Valor_Medio
FROM PEDIDOITEM peditem
INNER JOIN PEDIDO ped ON ped.IDPEDIDO = peditem.IDPEDIDO
GROUP BY TO_CHAR(ped.DATAPEDIDO, 'MON-YYYY')
ORDER BY datas;


