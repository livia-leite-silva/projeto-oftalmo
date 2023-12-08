CREATE TABLE especialidades (
	id		    SERIAL 			PRIMARY KEY,
	descricao	VARCHAR(255) 	NOT NULL		UNIQUE,
	conselho	VARCHAR(255)	NOT NULL
);

CREATE TABLE medicos (
	id			SERIAL 			PRIMARY KEY,
	nome 		VARCHAR(255) 	NOT NULL,
	crm			VARCHAR(255)	NOT NULL 	UNIQUE
);

CREATE TABLE atributos_estrutura_lente (
	id			SERIAL 			PRIMARY KEY,
	descricao 	VARCHAR(255) 	NOT NULL,
	lado_olho	VARCHAR(255)	NOT NULL
);

CREATE TABLE pacientes (
	id				SERIAL 			PRIMARY KEY,
	nome 			VARCHAR(255) 	NOT NULL,
	cpf				VARCHAR(11)		NOT NULL 	UNIQUE,
	dt_nascimento	DATE			NOT NULL
);

CREATE TABLE especialidades_medicas (
	id					SERIAL 			PRIMARY KEY,
	observacao 			VARCHAR(255),
	dt_conclusao		DATE,
	id_especialidade	INT 			NOT NULL	REFERENCES 	especialidades(id),
	id_medico			INT 			NOT NULL	REFERENCES 	medicos(id)
);

CREATE TABLE consultas_medicas (
	id					SERIAL 			PRIMARY KEY,
	assinatura 			VARCHAR(255)	NOT NULL	UNIQUE,
	dt_consulta			DATE 			NOT NULL,
	id_paciente			INT 			NOT NULL	REFERENCES 	pacientes(id),
	id_medico			INT 			NOT NULL	REFERENCES 	medicos(id)
);

CREATE TABLE receitas_oculos (
	id					SERIAL 			PRIMARY KEY,
	detalhamento 		VARCHAR(255),
	dt_consulta			DATE 			NOT NULL,
	id_consulta_medica	INT 			NOT NULL	REFERENCES 	consultas_medicas(id)
);

CREATE TABLE observacoes_laudos (
	id					SERIAL 			PRIMARY KEY,
	descricao 			VARCHAR(255)	NOT NULL,
	id_receita_oculos	INT 			NOT NULL	REFERENCES 	receitas_oculos(id)
);

CREATE TABLE estruturas_lentes (
	id					SERIAL 			PRIMARY KEY,
	tipo_correcao		VARCHAR(45)		NOT NULL,
	distancia_pupilar 	INT				NOT NULL, 
	id_receita_oculos	INT 			NOT NULL	REFERENCES 	receitas_oculos(id)
);

CREATE TABLE especificacoes_lente (
	id							SERIAL 		PRIMARY KEY,
	valor						FLOAT		NOT NULL,
	id_estrutura_lente			INT 		NOT NULL	REFERENCES 	estruturas_lentes(id),
	id_atributo_estrutura_lente	INT 		NOT NULL	REFERENCES 	atributos_estrutura_lente(id)
);