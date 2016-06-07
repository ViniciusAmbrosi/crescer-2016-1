create or replace package PCK_CONCURSO is

  -- Author  : ANDRENUNES
  -- Created : 03/06/2016 10:40:29
  -- Purpose : Gerar informações reference a cada concurso
  
  -- Public type declarations
  procedure geraProximoConcurso;
  procedure atualizaAcertadores;

end PCK_CONCURSO;
/

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
   vUltimoConcurso integer;
   vContadorAcertos integer;   
   vAcumulou BOOLEAN := true;
  CURSOR c_apostas (pIdConcurso in integer) IS
      SELECT IDAPOSTA, Valor
      FROM APOSTA 
      WHERE IDCONCURSO = pIdConcurso; 
  BEGIN
    vContadorAcertos := 0;
    SELECT MAX(IDCONCURSO) 
    INTO vUltimoConcurso
    FROM CONCURSO;
    FOR aposta IN c_apostas(vUltimoConcurso) LOOP
       vContadorAcertos := NumerosAposta(aposta.IDAPOSTA, vUltimoConcurso);
       IF(vContadorAcertos > 3) THEN
         INSERT INTO APOSTA_PREMIADA (IDAPOSTA, ACERTOS, VALOR)
         VALUES(aposta.IDAPOSTA, vContadorAcertos, aposta.Valor);
       END IF;
        --altera valor de acumulou do ultimo concurso
       IF(vContadorAcertos = 6 AND vAcumulou) THEN
          vAcumulou := false;
          UPDATE CONCURSO
          SET ACUMULOU = 1
          WHERE IDCONCURSO = vUltimoConcurso;
       END IF;
    END LOOP;
  END;
  ----------------------------------------------------------------------
  
begin
  -- Initialization
  null;
end PCK_CONCURSO;
/