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





