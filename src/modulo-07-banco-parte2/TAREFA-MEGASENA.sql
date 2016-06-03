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

CREATE FUNCTION EhSena (pAcertos integer) RETURN INTEGER AS
BEGIN
    IF (pAcertos = 6) THEN 
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;
END;

CREATE FUNCTION EhQuina (pAcertos integer) RETURN INTEGER AS
BEGIN
    IF (pAcertos = 5) THEN 
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;
END;

CREATE FUNCTION EhQuadra (pAcertos integer) RETURN INTEGER AS
BEGIN
    IF (pAcertos = 4) THEN 
        RETURN 1;
    ELSE
        RETURN 0;
    END IF;
END;

DECLARE
  CURSOR concursos IS
    SELECT IDCONCURSO
    FROM CONCURSO;
  
  vVencedorSena integer := 0;
  vVencedorQuina integer := 0;
  vVencedorQuadra integer := 0;
  vContadorAcertos integer := 0;
BEGIN
    FOR concurso in concursos LOOP
    DBMS_OUTPUT.PUT_LINE('----------Concurso' || concurso.IDCONCURSO || '-------------');
      FOR aposta IN (SELECT IDAPOSTA FROM APOSTA WHERE IDCONCURSO = 1816) LOOP
          vContadorAcertos := NumerosAposta(aposta.IDAPOSTA, concurso.IDCONCURSO);
          vVencedorSena := vVencedorSena + EhSena(vContadorAcertos);
          vVencedorQuina := vVencedorQuina + EhQuina(vContadorAcertos);
          vVencedorQuadra := vVencedorQuadra + EhQuadra(vContadorAcertos);
      END LOOP;
      DBMS_OUTPUT.PUT_LINE('Vencedores:');
      DBMS_OUTPUT.PUT_LINE('Sena ' || vVencedorSena || ' Quina ' || vVencedorQuina || ' Quadra '|| vVencedorQuadra);
      vVencedorQuina := 0;
      vVencedorQuadra  := 0;
      vContadorAcertos  := 0;
    END LOOP;
END;





