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
cpf VARCHAR (20)PRIMARY KEY,    
curso VARCHAR(30),
sala INT(10),
turma VARCHAR(10),
pessoa_matricula INT UNSIGNED,
CONSTRAINT fk_dicente_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);


CREATE TABLE docente_tb (
cpf VARCHAR(20) PRIMARY KEY,
cargo VARCHAR(20), 
area VARCHAR(15),
turno VARCHAR(10),
pessoa_matricula INT UNSIGNED,
CONSTRAINT fk_docente_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE chaves_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
nSala INT(10),
tipo VARCHAR(30) NOT NULL,
observacao VARCHAR(30)
);

CREATE TABLE materiais_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(30) NOT NULL,
status VARCHAR(30), 
observacao VARCHAR(30), 
salaDestino VARCHAR(30) NOT NULL
);
CREATE TABLE utencilios_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(30) NOT NULL,
status VARCHAR(30), 
observacao VARCHAR(30), 
nome VARCHAR(30) NOT NULL
);
CREATE TABLE Pessoa_Reserva_Chaves_tb (
horaPedido VARCHAR(20) PRIMARY KEY,
horaDevolucao VARCHAR(15),
data VARCHAR(15),
matricula VARCHAR(15), 
numeroSala INT(5),
CONSTRAINT fk_Pessoa_Chaves FOREIGN KEY 
(matricula) REFERENCES pessoa_tb(matricula)
CONSTRAINT fk_chave_pessoa FOREIGN KEY 
(numeroSala) REFERENCES pessoa_tb(numeroSala)
);

CREATE TABLE Pessoa_Reserva_Utensilio_tb (
horaPedido VARCHAR PRIMARY KEY,
horaDevolucao VARCHAR(15),
data VARCHAR(15),
matricula VARCHAR(15), 
idUtensilio INT UNSIGNED AUTO_INCREMENT,
CONSTRAINT fk_Pessoa_Utencilios FOREIGN KEY 
(matricula) REFERENCES pessoa_tb(matricula)
CONSTRAINT fk_Utencilios_Pessoa FOREIGN KEY 
(idUtensilio) REFERENCES pessoa_tb(idUtensilio)
);

CREATE TABLE Pessoa_Reserva_Materiais_tb (
horaPedido VARCHAR PRIMARY KEY,
horaDevolucao VARCHAR(15),
data VARCHAR(15),
matricula VARCHAR(15), 
idUtensilio INT UNSIGNED AUTO_INCREMENT,
CONSTRAINT fk_Pessoa_Utencilios FOREIGN KEY 
(matricula) REFERENCES pessoa_tb(matricula)
CONSTRAINT fk_Utencilios_Pessoa FOREIGN KEY 
(idUtencilio) REFERENCES pessoa_tb(idUtencilio)
);


INSERT INTO pessoa_tb(matricula, name, email, senha, telefone)
VALUES('54789','Jao', 'jaorock3000@gmail.com','123','9965');

INSERT INTO pessoa_tb(matricula, name, email, senha, telefone)
VALUES('54788','João', 'jaorock@gmail.com','1234','995778');

INSERT INTO pessoa_tb(matricula, name, email, senha, telefone)
VALUES('54778','Maria', 'mariarock@gmail.com','1334','9956578'); 

INSERT INTO administrador_tb (matricula, senha)
VALUES('58475','58765');

INSERT INTO administrador_tb (matricula, senha)
VALUES('58485','59765');

INSERT INTO administrador_tb (matricula, senha)
VALUES('58175','458765');

INSERT INTO dicente_tb(cpf,sala, curso, turma)
VALUES('4444444','01','Informatica','A');

INSERT INTO dicente_tb(cpf,sala, curso, turma)
VALUES('5555555','02','Informatica','A');

INSERT INTO dicente_tb(cpf,sala, curso, turma)
VALUES('6666666','03','Informatica','A');

INSERT INTO docente_tb (cpf,cargo ,area, turno)
VALUES('1111111','professor', 'geografia','manha');

INSERT INTO docente_tb (cpf,cargo ,area, turno)
VALUES('2222222','professor', 'geografia','manha');

INSERT INTO docente_tb (cpf,cargo ,area, turno)
VALUES('3333333','professor', 'matematica','manha');

INSERT INTO chaves_tb(nSala, tipo, observacao)
VALUES('01','tiponsei','soobservo');

INSERT INTO chaves_tb(nSala, tipo, observacao)
VALUES('02','tiponsei','soobservo');

INSERT INTO chaves_tb(nSala, tipo, observacao)
VALUES('03','tiponsei','soobservo');


INSERT INTO materiais_tb(tipo, status, observacao,salaDestino)	
VALUES('cabo','emprestado','esta novo','11');

INSERT INTO materiais_tb(tipo, status, observacao,salaDestino)	
VALUES('datashow','emprestado','esta novo','11');

INSERT INTO materiais_tb(tipo, status, observacao,salaDestino)	
VALUES('datashow','emprestado','esta novo','13');

INSERT INTO utencilios_tb(tipo,status,observacao,nome)
VALUES('notebook','perdido','com a tela quebrada','macbook');

INSERT INTO utencilios_tb(tipo,status,observacao,nome)
VALUES('celular','perdido','com a tela quebrada','sansung');

INSERT INTO utencilios_tb(tipo,status,observacao,nome)
VALUES('pendrive','perdido','com a tela quebrada','pendrive');

DELETE FROM pessoa_tb
WHERE name = 'Jão';
DELETE FROM pessoa_tb
WHERE matricula = '0000';
DELETE FROM pessoa_tb
WHERE email LIKE 'gmail.com';


DELETE FROM dicente_tb
WHERE turma = 'A';
DELETE FROM dicente_tb
WHERE curso = 'p&g';
DELETE FROM dicente_tb
WHERE sala = '0';

DELETE FROM administrador_tb
WHERE senha = '666';
DELETE FROM administrador_tb
WHERE matricula = '40028922';
DELETE FROM administrador_tb
WHERE senha = '999';


DELETE FROM docente_tb
WHERE cargo = 'professor';
DELETE FROM docente_tb
WHERE turno = 'manha';
DELETE FROM docente_tb
WHERE area = 'saude';

DELETE FROM chaves_tb
WHERE nSala = '69';
DELETE FROM chaves_tb
WHERE tipo = 'pado';
DELETE FROM chaves_tb
WHERE observacao = 'sumida';


DELETE FROM materiais_tb
WHERE tipo = 'controle';
DELETE FROM materiais_tb
WHERE status = 'solteiro';
DELETE FROM materiais_tb
WHERE obeservacao = 'falhando';

DELETE FROM utencilios_tb
WHERE tipo = 'fone';
DELETE FROM utencilios_tb
WHERE status = 'sumido';
DELETE FROM utencilios_tb
WHERE obeservacao = 'quebrado';

DROP TABLE administrador_tb;
DROP TABLE dicente_tb;
DROP TABLE docente_tb;
DROP TABLE pessoa_tb;
DROP TABLE chaves_tb;
DROP TABLE materiais_tb;
DROP TABLE utencilios_tb;
