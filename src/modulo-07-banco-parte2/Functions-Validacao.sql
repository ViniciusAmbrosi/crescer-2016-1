--se fosse o caso poderia inserir na tabela de ganhadores

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