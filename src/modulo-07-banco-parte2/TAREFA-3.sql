create or replace package body PCK_CONCURSO is

procedure geraProximoConcurso as
       vIdUltimoConcurso INTEGER;
       vValorArrecadado DECIMAL(12,2);
       vDiaUltimoConcurso INTEGER;
       vAcumulouSena INTEGER;
       vSenaAcumulada DECIMAL(12,2);
       vDataProximoConcurso DATE;
    begin      
        SELECT IDCONCURSO, TO_CHAR(DATA_SORTEIO, 'D'), ACUMULOU, PREMIO_SENA
        INTO vIdUltimoConcurso, vDiaUltimoConcurso, vAcumulouSena, vSenaAcumulada
        FROM CONCURSO
        WHERE ROWNUM = 1
        ORDER BY IDCONCURSO DESC;
        
        SELECT SUM(VALOR)
        INTO vValorArrecadado
        FROM APOSTA
        WHERE IDCONCURSO = vIdUltimoConcurso;
        
        vIdUltimoConcurso := vIdUltimoConcurso + 1;
        
        IF(vDiaUltimoConcurso = 4) THEN
          vDiaUltimoConcurso := 7;
        ELSE
          vDiaUltimoConcurso := 4;
        END IF;
        
        SELECT NEXT_DAY(SYSDATE, vDiaUltimoConcurso)
        INTO vDataProximoConcurso
        FROM DUAL;

        PCK_MEGASENA.SALVACONCURSO(vIdUltimoConcurso,vDataProximoConcurso,vValorArrecadado * 0.453);
        
        IF(vAcumulouSena = 0) THEN
          UPDATE CONCURSO 
          SET PREMIO_SENA = PREMIO_SENA + vSenaAcumulada
          WHERE IDCONCURSO = vIdUltimoConcurso;
        END IF;
    end;
  ----------------------------------------------------------------------
procedure atualizaAcertadores as

   vContadorAcertos INTEGER;   
   vAcumulou BOOLEAN := TRUE;
   vPrimeiraAposta INTEGER;
   vVencedoresSena INTEGER := 0;
   vVencedoresQuina INTEGER := 0;
   vVencedoresQuadra INTEGER := 0;
   vValorSena DECIMAL(12,2);
   vValorQuina DECIMAL(12,2);
   vValorQuadra DECIMAL(12,2);
   vConcursoAtual INTEGER;
   
  CURSOR c_apostas (pIDConcurso INTEGER)IS
      SELECT ap.IDAPOSTA
      FROM APOSTA ap
      LEFT JOIN APOSTA_PREMIADA ap_p ON ap.IDAPOSTA = ap_p.IDAPOSTA
      WHERE ap_p.IDAPOSTA IS NULL AND ap.IDCONCURSO = pIDConcurso
      ORDER BY ap.IDAPOSTA ASC; 
      
  CURSOR c_concursos IS
      SELECT IDCONCURSO
      FROM CONCURSO
      ORDER BY IDCONCURSO;
      
  BEGIN
    vPrimeiraAposta := 0;
    vContadorAcertos := 0;
    SYS.DBMS_OUTPUT.PUT_LINE(vConcursoAtual);
    FOR concurso in c_concursos LOOP
      vConcursoAtual := concurso.IDCONCURSO;
      SELECT PREMIO_SENA, PREMIO_QUINA, PREMIO_QUADRA
      INTO  vValorSena, vValorQuina, vValorQuadra
      FROM CONCURSO
      WHERE IDCONCURSO = vConcursoAtual;
      
      FOR aposta IN c_apostas(concurso.IDCONCURSO) LOOP
       vContadorAcertos := NumerosAposta(aposta.IDAPOSTA, vConcursoAtual);
       
       IF(vContadorAcertos > 3) THEN
         INSERT INTO APOSTA_PREMIADA (IDAPOSTA, ACERTOS, VALOR)
         VALUES(aposta.IDAPOSTA, vContadorAcertos, 0);   
         IF(vContadorAcertos = 4)THEN
          vVencedoresQuadra := vVencedoresQuadra + 1;
         ELSIF(vContadorAcertos = 5) THEN
          vVencedoresQuina := vVencedoresQuina + 1;
         ELSIF (vContadorAcertos = 6) THEN
          vVencedoresSena := vVencedoresSena + 1;
         END IF;
       END IF;
       IF(vContadorAcertos = 6 AND vAcumulou) THEN
          vAcumulou := false;
          UPDATE CONCURSO
          SET ACUMULOU = 1
          WHERE IDCONCURSO = vConcursoAtual;
       END IF;
      END LOOP;
      
      IF(vVencedoresSena != 0) THEN
        UPDATE APOSTA_PREMIADA
        SET VALOR = vValorSena / vVencedoresSena
        WHERE ACERTOS = 6 AND IDAPOSTA_PREMIADA > vPrimeiraAposta;
      END IF;
      
      IF(vVencedoresQuina != 0) THEN
        UPDATE APOSTA_PREMIADA
        SET VALOR = vValorQuina / vVencedoresQuina
        WHERE ACERTOS = 5 AND IDAPOSTA_PREMIADA > vPrimeiraAposta;
      END IF;
       
      IF(vVencedoresQuadra != 0) THEN
        UPDATE APOSTA_PREMIADA
        SET VALOR = vValorQuadra / vVencedoresQuadra
        WHERE ACERTOS = 4 AND IDAPOSTA_PREMIADA > vPrimeiraAposta;
      END IF;
      
      SELECT MAX(IDAPOSTA_PREMIADA)
      INTO vPrimeiraAposta
      FROM APOSTA_PREMIADA;
      
      vVencedoresSena := 0;
      vVencedoresQuina := 0;
      vVencedoresQuadra := 0;
    END LOOP;
  END;
  ----------------------------------------------------------------------
  
begin
  null;
end PCK_CONCURSO;