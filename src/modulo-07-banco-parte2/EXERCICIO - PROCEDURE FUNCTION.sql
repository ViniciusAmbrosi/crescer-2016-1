--1) Crie um procedimento que receba por parâmetro o IDPedido e atualize o valor do pedido conforme seus itens.
--Valor unitário * Quantidade
CREATE OR REPLACE PROCEDURE ATUALIZA_PEDIDO (pIDPedido in integer) AS
BEGIN
  UPDATE PEDIDO ped
  SET ped.VALORPEDIDO =(SELECT SUM(PRECOUNITARIO * QUANTIDADE)
                        FROM PEDIDOITEM
                        WHERE IDPEDIDO = pIDPedido)
  WHERE ped.IDPEDIDO = pIDPEDIDO;
END;

--2) Crie uma função que receba por parâmetro o IDCliente e retorne a data do último pedido realizado pelo cliente.
CREATE OR REPLACE FUNCTION DATA_ULTIMO_PEDIDO (pIDCliente in integer) RETURN PEDIDO.DATAPEDIDO%TYPE AS
  vData PEDIDO.DATAPEDIDO%TYPE;
BEGIN
  SELECT MAX(DATAPEDIDO)
  INTO vData
  FROM PEDIDO
  WHERE IDCLIENTE = pIDCliente;
  
  RETURN vData;
END;
  

--3) Crie uma função que receba por parâmetro o IDProduto e o período (mês e ano) e retorne a quantidade (total)
--desde produtos vendidos no período (considere todos os dias do mês).
CREATE OR REPLACE FUNCTION PRODUTOS_VENDIDOS_NO_MES (pIDProduto in integer, pData in DATE) RETURN PEDIDOITEM.QUANTIDADE%TYPE AS
  vQuantidade PEDIDOITEM.QUANTIDADE%TYPE;
BEGIN
  SELECT SUM(peditem.QUANTIDADE)
  INTO vQuantidade
  FROM PEDIDOITEM peditem
  INNER JOIN PEDIDO ped ON peditem.IDPEDIDO = ped.IDPEDIDO
  WHERE ped.DATAPEDIDO BETWEEN TRUNC(pData, 'MM') AND LAST_DAY(pDATA) AND
        peditem.IDPRODUTO = pIDProduto;
        
  RETURN vQuantidade;
END;



