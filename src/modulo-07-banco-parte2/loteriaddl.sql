
create table Aposta ( 
  ID          integer  not null,
  Concurso_ID    integer  not null ,
  Data        date not null,
  QtdeNumeros number(2)    not null,
  Valor       number(12,2) not null,
  Numeros     varchar2(200) not null,
   constraint Aposta_PK primary key (ID)
 ); 

ALTER TABLE Aposta 
MODIFY Data DEFAULT SYSDATE;

CREATE TABLE Concurso
  (
    ID                INTEGER NOT NULL ,
    Data              DATE NOT NULL ,
    Premio_Bruto      NUMBER (12,2) NOT NULL ,
    Premio_Parcial_ID INTEGER NOT NULL
  ) ;
CREATE UNIQUE INDEX Concurso__IDX ON Concurso
  (
    Premio_Parcial_ID ASC
  )
  ;
ALTER TABLE Concurso ADD CONSTRAINT Concurso_PK PRIMARY KEY ( ID ) ;


CREATE TABLE Ganhador
  (
    ID                 INTEGER NOT NULL ,
    Quantidade_Acertos INTEGER NOT NULL ,
    Premio             NUMBER (12,2) NOT NULL ,
    Aposta_ID          INTEGER NOT NULL
  ) ;
CREATE UNIQUE INDEX Ganhador__IDX ON Ganhador
  (
    Aposta_ID ASC
  )
  ;
ALTER TABLE Ganhador ADD CONSTRAINT Ganhador_PK PRIMARY KEY ( ID ) ;


CREATE TABLE Numero
  (
    ID                INTEGER NOT NULL ,
    Quantidade_Numero INTEGER NOT NULL ,
    Valor             NUMBER (12,2) NOT NULL
  ) ;
ALTER TABLE Numero ADD CONSTRAINT Numero_PK PRIMARY KEY ( ID ) ;


CREATE TABLE Premio_Parcial
  (
    ID                        INTEGER NOT NULL ,
    Sena                      NUMBER (12,2) NOT NULL ,
    Quina                     NUMBER (12,2) NOT NULL ,
    Quadra                    NUMBER (12,2) NOT NULL ,
    Acumulado_Proximo_Sorteio NUMBER (12,2) NOT NULL ,
    Acumulado_Sorteio_Final   NUMBER (12,2) NOT NULL
  ) ;
ALTER TABLE Premio_Parcial ADD CONSTRAINT Premio_Parcial_PK PRIMARY KEY ( ID ) ;


ALTER TABLE Aposta ADD CONSTRAINT Aposta_Concurso_FK FOREIGN KEY ( Concurso_ID ) REFERENCES Concurso ( ID ) ;

ALTER TABLE Aposta ADD CONSTRAINT Aposta_Numero_FK FOREIGN KEY ( Numero_ID ) REFERENCES Numero ( ID ) ;

ALTER TABLE Concurso ADD CONSTRAINT Concurso_Premio_Parcial_FK FOREIGN KEY ( Premio_Parcial_ID ) REFERENCES Premio_Parcial ( ID ) ;

ALTER TABLE Ganhador ADD CONSTRAINT Ganhador_Aposta_FK FOREIGN KEY ( Aposta_ID ) REFERENCES Aposta ( ID ) ;