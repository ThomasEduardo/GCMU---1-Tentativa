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
pessoa_matricula INT UNSIGNED,
CONSTRAINT fk_administrador_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE dicente_tb (
matricula INT(30) PRIMARY KEY,
sala INT(10),
curso VARCHAR(20) NOT NULL,
turma VARCHAR(10),
pessoa_matricula INT UNSIGNED,
CONSTRAINT fk_administrador_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);


CREATE TABLE docente_tb (
matricula INT(30) PRIMARY KEY,
cargo VARCHAR(20),
area VARCHAR(15),
turno VARCHAR(10),
pessoa_matricula INT UNSIGNED,
CONSTRAINT fk_administrador_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE chaves_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nSala INT(10),
tipo VARCHAR(30) NOT NULL,
observacao VARCHAR(30),
);

CREATE TABLE materiais_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(30) NOT NULL,
status VARCHAR(30), 
obeservacao VARCHAR(30), 
salaDestino VARCHAR(30) NOT NULL
);
CREATE TABLE utencilios_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(30) NOT NULL,
status VARCHAR(30), 
obeservacao VARCHAR(30), 
nome VARCHAR(30) NOT NULL
);


INSERT INTO pessoa_tb(matriculaname, email, senha, telefone)
VALUES(‘54789’,‘Jao’, ‘jaorock3000@gmail.com’,’ 123’,’ 9965’);

INSERT INTO administrador_tb (matricula, senha)
VALUES(‘58475’,‘58765’);

INSERT INTO dicente(matricula, sala, curso, turma)
VALUES(‘58625’,’02’,’Informatica’,’A’)

INSERT INTO docente_tb (matricula, cargo ,area, turno)
VALUES(‘58475’,‘professor’, ‘geografia’,’manha’);

INSERT INTO chaves_tb(nSala, tipo, observacao)
VALUES(‘02’,’tiponsei’,’soobservo’);


INSERT INTO materiais_tb(tipo, status, observacao,salaDestino)	
VALUES(‘cabo’,’emprestado’,’esta novo’,’11’);

INSERT INTO utencilio_tb(tipo,status,observacao,nome)
VALUES(‘notebook’,’perdido’,’com a tela quebrada’,’macbook’);




DELETE from pessoa_tb;
DELETE from administrador_tb;
DELETE from dicente_tb;
DELETE from docente_tb;
DELETE from chaves_tb;
DELETE from materiais_tb;
DELETE from utencilios_tb;

DROP TABLE pessoa_tb;
DROP TABLE administrador_tb;
DROP TABLE dicente_tb;
DROP TABLE docente_tb;
DROP TABLE chaves_tb;
DROP TABLE materiais_tb;
DROP TABLE utencilios_tb;

