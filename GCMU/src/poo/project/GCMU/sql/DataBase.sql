use GCMU;

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
dataChave TIMESTAMP,
matricula INT(10) unsigned, 
idChave INT(10) unsigned auto_increment,
CONSTRAINT fk_Pessoa_Chaves FOREIGN KEY (matricula) REFERENCES pessoa_tb(matricula),
CONSTRAINT fk_chave_pessoa FOREIGN KEY (idChave) REFERENCES chaves_tb(id)
);

CREATE TABLE Pessoa_Reserva_Utencilio_tb (
horaPedido VARCHAR(255) PRIMARY KEY,
horaDevolucao VARCHAR(15),
dataUtensilio TIMESTAMP(15),
matricula Int(10) unsigned, 
idUtensilio INT(10) UNSIGNED AUTO_INCREMENT,
CONSTRAINT fk_Pessoa_Utencilios FOREIGN KEY 
(matricula) REFERENCES pessoa_tb(matricula),
CONSTRAINT fk_Utencilios_Pessoa FOREIGN KEY 
(idUtensilio) REFERENCES utencilios_tb(id)
);

CREATE TABLE Pessoa_Reserva_Materiais_tb (
horaPedido VARCHAR(255) PRIMARY KEY,
horaDevolucao VARCHAR(15),
dataMaterial TIMESTAMP(15),
matricula int(10) unsigned, 
idMaterial INT(10) UNSIGNED AUTO_INCREMENT,
CONSTRAINT fk_Pessoa_Materiais FOREIGN KEY 
(matricula) REFERENCES pessoa_tb(matricula),
CONSTRAINT fk_Materiais_Pessoa FOREIGN KEY 
(idMaterial) REFERENCES materiais_tb(id)
);
CREATE TABLE bkpPessoa_tb (
matricula INT UNSIGNED PRIMARY KEY,
name VARCHAR(30) NOT NULL,
email VARCHAR(30),
senha VARCHAR(30),
telefone VARCHAR(30)
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
VALUES('cabo','emprestado','reservado','11');

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

DELETE FROM pessoa_tb WHERE matricula = '54789' and matricula = '54788' and matricula = '54778';

DELETE FROM dicente_tb where cpf='4444444' and cpf = '5555555' and cpf='6666666';

DELETE FROM administrador_tb WHERE matricula = '58475' and matricula = '58485' and matricula = '58175';

DELETE FROM docente_tb where cpf='1111111' and cpf='2222222' and cpf = '3333333';

DELETE FROM chaves_tb where id <= 3;

DELETE FROM materiais_tb where id <=3;

DELETE FROM utencilios_tb where id<=3;

delimiter $$
Create trigger insertPessoa before insert
on pessoa_tb
for each row
begin
	if(length(new.telefone) != 11) then
	  set new.matricula = null;
    end if;

end $$
delimiter ;
delimiter $$
Create trigger insertDicente before insert
on dicente_tb
for each row
begin
	if(length(new.cpf) != 14) then
	  set new.cpf = null;
    end if;

end $$
delimiter ;

delimiter $$
Create trigger insertDocente before insert
on docente_tb
for each row
begin
	if(length(new.cpf) != 14) then
	  set new.cpf = null;
    end if;

end $$
delimiter ;

delimiter $$
Create trigger insertAdministrador before insert
on administrador_tb
for each row
begin
	if(new.senha != '123') then
	  set new.matricula = null;
    end if;

end $$
delimiter ;


delimiter $$
Create trigger insertChave before insert
on chaves_tb
for each row
begin
	if(new.observacao = 'Reservada') then
	  set new.id = null;
    end if;

end $$
delimiter ;

delimiter $$
Create trigger insertMateriais before insert
on materiais_tb
for each row
begin
	if(new.observacao = 'Reservada') then
	  set new.id = null;
    end if;

end $$
delimiter;


delimiter $$
Create trigger insertUtencilios before insert
on utencilios_tb
for each row
begin
	if(new.observacao = 'Reservada') then
	  set new.id = null;
    end if;

end $$
delimiter ;


delimiter $$
Create trigger deletePessoa before delete
on pessoa_tb
for each row
begin

	INSERT INTO bkppessoa_tb(matricula, name, email, senha, telefone)
	VALUES(old.matricula,old.name,old.email,old.senha,old.telefone);

end $$
delimiter ;



DROP TABLE administrador_tb;
DROP TABLE dicente_tb;
DROP TABLE docente_tb;
DROP TABLE Pessoa_Reserva_Chaves_tb;
DROP TABLE Pessoa_Reserva_Utencilio_tb;
DROP TABLE Pessoa_Reserva_Materiais_tb;
DROP TABLE utencilios_tb;
DROP TABLE chaves_tb;
DROP TABLE materiais_tb;
DROP TABLE bkpPessoa_tb;
DROP TABLE pessoa_tb;SS