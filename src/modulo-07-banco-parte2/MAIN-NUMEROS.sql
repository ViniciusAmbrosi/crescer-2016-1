DECLARE
  CURSOR concursos IS
    SELECT IDCONCURSO
    FROM CONCURSO;
  
  vVencedor integer;
BEGIN
  OPEN concursos;
    FOR concurso in concursos LOOP
      
      NUMERO
    END LOOP;
  CLOSE concursos;
END;