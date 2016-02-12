CREATE TABLE pessoa_tb (
matricula INT UNSIGNED PRIMARY KEY,
name VARCHAR(30) NOT NULL,
email VARCHAR(30),
senha VARCHAR(30),
telefone VARCHAR(30)
);

CREATE TABLE administrador_tb (
matricula INT(30) PRIMARY KEY,
senha INT(30),
CONSTRAINT fk_administrador_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE dicente_tb (
matricula INT(30) PRIMARY KEY,
sala INT(10),
curso VARCHAR(20),
turma VARCHAR(10),
CONSTRAINT fk_administrador_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE docente_tb (
matricula INT(30) PRIMARY KEY,
cargo VARCHAR(20),
area VARCHAR(15),
turno VARCHAR(10),
CONSTRAINT fk_administrador_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE docente_tb (
matricula INT(30) PRIMARY KEY,
cargo VARCHAR(20),
area VARCHAR(15),
turno VARCHAR(10),
CONSTRAINT fk_administrador_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE chaves_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nSala INT(10),
tipo VARCHAR(30) NOT NULL,
observaçao VARCHAR(30),
);

CREATE TABLE utencilios_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(30), 
status VARCHAR(30), 
obeservaçao VARCHAR(30), 
nome VARCHAR(30)
);

CREATE TABLE materiais_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(30), 
status VARCHAR(30), 
obeservaçao VARCHAR(30), 
salaDestino VARCHAR(30)
);
