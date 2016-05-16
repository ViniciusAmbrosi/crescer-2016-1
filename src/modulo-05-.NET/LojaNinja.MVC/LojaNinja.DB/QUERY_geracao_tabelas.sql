CREATE TABLE Permissao
	(
	 permissaoId int IDENTITY NOT NULL PRIMARY KEY,
	 permissao varchar(50) NOT NULL,
	 CONSTRAINT chk_permissao CHECK (permissao = 'COMUM' OR permissao = 'ADMIN')
	);


CREATE TABLE Usuario
	(
	 usuarioId int IDENTITY NOT NULL PRIMARY KEY,
	 nome varchar(50) NOT NULL,
	 email varchar(100) UNIQUE NOT NULL,
	 senha varchar(50) NOT NULL
	);

CREATE TABLE PermissaoUsuario
	(
	 usuarioPermissaoId int IDENTITY NOT NULL PRIMARY KEY,
	 usuarioId int,
	 permissaoId int,
	 CONSTRAINT fk_permissaoUsuario_usuarioId FOREIGN KEY (usuarioId) REFERENCES Usuario(usuarioId),
	 CONSTRAINT fk_permissaoUsuario_permissaoId FOREIGN KEY (permissaoId) REFERENCES Permissao(permissaoId)
	);
