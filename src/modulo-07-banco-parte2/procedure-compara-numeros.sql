create or replace FUNCTION NumerosAposta (aposta APOSTA.IDAPOSTA%TYPE, concurso CONCURSO.IDCONCURSO%TYPE) RETURN integer AS
  CURSOR numeros IS
            SELECT NUMERO 
            FROM NUMERO_APOSTA 
            WHERE IDAPOSTA = aposta
            ORDER BY 1;
  
  type num_table_type is table of number
     index by binary_integer;
      
  sorteados_table num_table_type;
  
  vCount integer := 0;
BEGIN
   SELECT PRIMEIRA_DEZENA,
          SEGUNDA_DEZENA,
          TERCEIRA_DEZENA,
          QUARTA_DEZENA,
          QUINTA_DEZENA,
          SEXTA_DEZENA
   INTO   sorteados_table(1),
          sorteados_table(2),
          sorteados_table(3),
          sorteados_table(4),
          sorteados_table(5),
          sorteados_table(6)
   FROM CONCURSO
   WHERE IDCONCURSO = concurso;
   
   FOR numero IN numeros LOOP
      FOR f IN 1..6 LOOP
        if(numero.Numero = sorteados_table(f))
          THEN
            vCount := vCount + 1;
        END IF;
      END LOOP;
   END LOOP;
   
   RETURN vCount;
END;

--ver sobre receber um array como parametro, para nao buscar dados do concurso para cada aposta