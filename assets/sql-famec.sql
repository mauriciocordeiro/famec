CREATE TABLE IF NOT EXISTS usuario (
	cd_usuario INT,
	nm_usuario VARCHAR(128),
	nm_login VARCHAR(64),
	nm_senha VARCHAR(128),
	nm_email VARCHAR(128),
	st_usuario SMALLINT,
	nm_funcao VARCHAR(64),
	
	PRIMARY KEY(cd_usuario)
);

CREATE TABLE IF NOT EXISTS familia (
	cd_familia INT NOT NULL,
	dt_cadastro TIMESTAMP,
	cd_usuario_cadastro INTEGER,
	PRIMARY KEY (cd_familia)
);

ALTER TABLE familia ADD FOREIGN KEY (cd_usuario_cadastro) REFERENCES usuario(cd_usuario);

CREATE TABLE IF NOT EXISTS responsavel (
	cd_responsavel INT NOT NULL,
	cd_familia INT NOT NULL,
	nm_responsavel VARCHAR(128),
	tp_parentesco SMALLINT,
	tp_genero SMALLINT,
	dt_nascimento DATETIME,
	nm_naturalidade VARCHAR(64),
	tp_estado_civil SMALLINT,
	nr_telefone_1 VARCHAR(16),
	nr_telefone_2 VARCHAR(16),
	nr_rg VARCHAR(16),
	nm_orgao_expedidor_rg VARCHAR(16),
	sg_uf_rg VARCHAR(2),
	nr_cpf VARCHAR(11),
	ds_escolaridade VARCHAR(128),
	lg_estudante BOOLEAN,
	tp_nivel_escolar SMALLINT,
	tp_turno SMALLINT,
	nm_ocupacao VARCHAR(64),
	vl_renda_mensal REAL,
	nm_local_trabalho VARCHAR(64),
	nr_telefone_trabalho VARCHAR(16),
	
	PRIMARY KEY (cd_responsavel)
);

ALTER TABLE responsavel ADD FOREIGN KEY (cd_familia) REFERENCES familia(cd_familia);

CREATE TABLE IF NOT EXISTS endereco_responsavel (
	cd_endereco INT NOT NULL,
	cd_responsavel INT NOT NULL,
	nm_rua VARCHAR(128),
	nr_casa INT,
	nm_complemento VARCHAR(128),
	nm_bairro VARCHAR(128),
	nm_cidade VARCHAR(128),
	nm_estado VARCHAR(32),
	
	PRIMARY KEY(cd_endereco)
);

ALTER TABLE endereco_responsavel ADD FOREIGN KEY (cd_responsavel) REFERENCES responsavel(cd_responsavel);

CREATE TABLE IF NOT EXISTS perfil_social (
	cd_perfil_social INT NOT NULL,
	cd_familia NOT NULL,
	lg_nis BOOLEAN,
	nr_nis VARCHAR(32),
	lg_beneficio BOOLEAN,
	nm_beneficio VARCHAR(64),
	vl_beneficio REAL,
	
	PRIMARY KEY (cd_perfil_social)
);

ALTER TABLE perfil_social ADD FOREIGN KEY (cd_familia) REFERENCES familia(cd_familia);

CREATE TABLE IF NOT EXISTS habitacao (
	cd_habitacao INT NOT NULL,
	cd_familia INT NOT NULL,
	tp_situacao SMALLINT,
	vl_aluguel REAL,
	nr_comodos INT,
	tp_abastecimento SMALLINT,
	tp_tratamento_agua SMALLINT,
	tp_iluminacao  SMALLINT,
	tp_escoamento_sanitario SMALLINT,
	tp_destino_lixo SMALLINT,
	
	PRIMARY KEY(cd_habitacao)
);

ALTER TABLE habitacao ADD FOREIGN KEY (cd_familia) REFERENCES familia(cd_familia);

CREATE TABLE IF NOT EXISTS aluno (
	cd_aluno INT NOT NULL,
	cd_familia INT NOT NULL,
	nm_aluno VARCHAR(128),
	dt_nascimento DATETIME,
	tp_sexo SMALLINT,
	nm_naturalidade VARCHAR(128),
	nm_escola VARCHAR(128),
	nr_nivel_escolar SMALLINT,
	tp_modalidade_escolar SMALLINT,
	tp_horario_escolar SMALLINT,
	tp_turno_famec SMALLINT,
	st_aluno SMALLINT,
	hr_saida DATETIME,
	lg_acompanhante_saida BOOLEAN,
	nm_acompanhante_saida VARCHAR(128),
	lg_almoco_instituicao BOOLEAN,
	
	PRIMARY KEY(cd_aluno)
);

ALTER TABLE aluno ADD FOREIGN KEY (cd_familia) REFERENCES familia(cd_familia);
