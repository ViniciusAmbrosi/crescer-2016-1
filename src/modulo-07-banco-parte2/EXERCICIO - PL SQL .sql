DECLARE
  vIDCLIENTE CLIENTE.IDCLIENTE%TYPE;
  vNomeCliente CLIENTE.NOME%TYPE;
  vNomeCidade CIDADE.NOME%TYPE;
  vMenorData PEDIDO.DATAPEDIDO%TYPE;
  vMaiorData PEDIDO.DATAPEDIDO%TYPE;
  vSomaValores PEDIDO.VALORPEDIDO%TYPE;
BEGIN
  vIDCLIENTE := &vIDCLIENTE;
  SELECT cli.NOME, cid.NOME, MIN(ped.DATAPEDIDO), MAX(ped.DATAPEDIDO), SUM(ped.VALORPEDIDO)
  INTO vNomeCliente, vNomeCidade, vMenorData, vMaiorData, vSomaValores
  FROM CLIENTE cli
  LEFT JOIN CIDADE cid ON cli.IDCIDADE = cid.IDCIDADE
  INNER JOIN PEDIDO ped ON ped.IDCLIENTE = cli.IDCLIENTE
  WHERE cli.IDCLIENTE = vIDCLIENTE
  GROUP BY cli.NOME, cid.NOME;
  DBMS_OUTPUT.PUT_LINE(vNomeCliente);
  DBMS_OUTPUT.PUT_LINE(vNomeCidade);
  DBMS_OUTPUT.PUT_LINE(vMenorData);
  DBMS_OUTPUT.PUT_LINE(vMaiorData);
  DBMS_OUTPUT.PUT_LINE(vSomaValores);
END;

/*2) Procedimento para inserir dados
    Fa�a um bloco PL/SQL que receba DOIS par�metros (em tempo de execu��o apenas): nome e uf, verifique
      se j� existe um registro em Cidade para a combina��o, caso n�o exista fa�a um INSERT na tabela de Cidade.
        o Utilize uma SEQUENCE para gerar o pr�ximo ID v�lido;
        o Ignore o case sensitive na valida��o.
        o Se j� existir a cidade+uf deve imprimir uma mensagem informando.*/
        
DECLARE
  vNome CIDADE.NOME%TYPE;
  vUF CIDADE.UF%TYPE;
  vExisteCidade integer;
BEGIN
  vNome := '&vNome';
  vUF := '&vUF';
  SELECT COUNT(1)
  INTO vExisteCidade
  FROM Cidade
  WHERE Nome = vNome AND UF = vUF;
  IF(vExisteCidade = 0)
    THEN 
      INSERT INTO Cidade (NOME, UF) VALUES (vNome,vUF);
      Commit;
  ELSE
      DBMS_OUTPUT.PUT_LINE('J� existe uma cidade com este Nome e UF');
  END IF;
END;


        
        
        
        
        