CREATE TABLE pessoa_tb (
matricula INT UNSIGNED PRIMARY KEY,
name VARCHAR(30) NOT NULL,
email VARCHAR(30),
telefone INT(30),
permissao VARCHAR(30)
);

CREATE TABLE administrador_tb(
siap INT(30) PRIMARY KEY,
pessoa_matricula INT UNSIGNED,
CONSTRAINT fk_administrador_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE discente_tb (
matricula VARCHAR (20)PRIMARY KEY,    
curso VARCHAR(30),
sala VARCHAR(10),
turma VARCHAR(10),
pessoa_matricula INT UNSIGNED,
CONSTRAINT fk_dicente_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);


CREATE TABLE docente_tb (
siap INT UNSIGNED PRIMARY KEY,
cargo VARCHAR(20), 
area VARCHAR(15),
turno VARCHAR(10),
pessoa_matricula INT UNSIGNED,
CONSTRAINT fk_docente_pessoa FOREIGN KEY 
(pessoa_matricula) REFERENCES pessoa_tb(matricula)
);

CREATE TABLE chaves_tb (
idChave INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
numeroSala INT(10),
nomeSala VARCHAR(30),
status VARCHAR(30)
);

CREATE TABLE materiais_tb (
idMaterial INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(30) NOT NULL,
status VARCHAR(30), 
numeroSala int,
nomeSala VARCHAR(30),
observacao VARCHAR(30)
);

CREATE TABLE utensilios_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(30) NOT NULL,
status VARCHAR(30), 
observacao VARCHAR(30),
locall VARCHAR(30),
marca VARCHAR(30)
);


CREATE TABLE Pessoa_Reserva_Chaves_tb (
id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
horaPedido  TIME,
horaDevolucao TIME,
data DATE,
matricula INT(10)  UNSIGNED, 
idChave INT(10) UNSIGNED,
CONSTRAINT fk_Pessoa_Chaves FOREIGN KEY (matricula) REFERENCES pessoa_tb(matricula),
CONSTRAINT fk_chave_pessoa FOREIGN KEY (idChave) REFERENCES chaves_tb(idChave)
);

CREATE TABLE Pessoa_Pesquisa_Utensilios_tb (
horaPedido TIME PRIMARY KEY,
horaDevolucao TIME,
data DATE,
matricula Int(10) UNSIGNED, 
idUtensilio INT(10) UNSIGNED,
CONSTRAINT fk_Pessoa_Utencilios FOREIGN KEY 
(matricula) REFERENCES pessoa_tb(matricula),
CONSTRAINT fk_Utensilios_Pessoa FOREIGN KEY 
(idUtensilio) REFERENCES utensilios_tb(id)
);

CREATE TABLE Pessoa_Reserva_Materiais_tb (
horaPedido TIME PRIMARY KEY,
horaDevolucao TIME,
data DATE,
matricula int(10) UNSIGNED,
idMaterial INT(10) UNSIGNED, 
CONSTRAINT fk_Pessoa_Materiais FOREIGN KEY 
(matricula) REFERENCES pessoa_tb(matricula),
CONSTRAINT fk_Materiais_Pessoa FOREIGN KEY 
(idMaterial) REFERENCES materiais_tb(idMaterial)
);

CREATE TABLE bkpPessoa_tb (
matricula INT UNSIGNED PRIMARY KEY,
name VARCHAR(30) NOT NULL,
email VARCHAR(30),
senha VARCHAR(30),
telefone VARCHAR(30)
);


INSERT INTO pessoa_tb( matricula, name, email, telefone, permissao)
VALUES('1234','Jao', 'jaorock3000@gmail.com','9965', 'todos');

INSERT INTO pessoa_tb( matricula, name, email, telefone,permissao)
VALUES('54788','Robervaldo', 'robervaldoroc@gmail.com','995778','todos');

INSERT INTO pessoa_tb( matricula, name, email,telefone,permissao)
VALUES('54778','Maria', 'mariarock@gmail.com','9956578','todos'); 

INSERT INTO pessoa_tb( matricula, name, email, telefone, permissao)
VALUES('2234','Jjao', 'jjaorock3000@gmail.com','9965','todos');

INSERT INTO pessoa_tb( matricula, name, email, telefone, permissao)
VALUES('34788','Rrobervaldo', 'rrobervaldorock@gmail.com','995778','todos');

INSERT INTO pessoa_tb(matricula, name, email, telefone, permissao)
VALUES('44778','aaria', 'mariarock@gmail.com','9956578','todos'); 

INSERT INTO pessoa_tb( matricula, name, email, telefone, permissao)
VALUES('51234','jjJao', 'jjjaorock3000@gmail.com','9965','todos');

INSERT INTO pessoa_tb( matricula, name, email, telefone,permissao)
VALUES('654788','rrRobervaldo', 'rrrobervaldoroc@gmail.com','995778','todos');

INSERT INTO pessoa_tb( matricula, name, email, telefone, permissao)
VALUES('754778','mmmMaria', 'mmmariarock@gmail.com','9956578','todos'); 

INSERT INTO administrador_tb (SIAP, pessoa_matricula)
VALUES('58475','1234');

INSERT INTO administrador_tb (SIAP,  pessoa_matricula)
VALUES('58485','54788');

INSERT INTO administrador_tb (SIAP, pessoa_matricula)
VALUES('58175','54778');

INSERT INTO discente_tb(matricula, sala, curso, turma,pessoa_matricula)
VALUES('2234','kjk','Informática','A','2234');

INSERT INTO discente_tb(matricula,sala, curso, turma,pessoa_matricula) 
VALUES('34788','dgf','quimica','B', '34788');

INSERT INTO discente_tb(matricula,sala, curso, turma, pessoa_matricula)
VALUES('44778','fg','Informática','C', '44778');

INSERT INTO docente_tb (siap, cargo ,area, turno, pessoa_matricula)
VALUES('1222','tecnico', 'informatica','manha', '51234');

INSERT INTO docente_tb (siap,cargo ,area, turno, pessoa_matricula)
VALUES('2222222','professor', 'informatica','manha', '654788');

INSERT INTO docente_tb (siap,cargo ,area, turno, pessoa_matricula)
VALUES('3333333','professor', 'matematica','manha', '754778');

INSERT INTO chaves_tb(numeroSala, nomeSala, status)
VALUES('12','BD','reservado');

INSERT INTO chaves_tb(numeroSala, nomeSala, status)
VALUES('02','COPED','reservado');

INSERT INTO chaves_tb(numeroSala, nomeSala, status)
VALUES('13','BD','Livre');

INSERT INTO materiais_tb(tipo, status, observacao, numeroSala, nomeSala)	
VALUES('Controle','reservado','novo','11','CAEST');

INSERT INTO materiais_tb(tipo, status, observacao,numeroSala, nomeSala)	
VALUES('datashow','rerservado','novo','13', 'BD');

INSERT INTO materiais_tb(tipo, status, observacao,numeroSala, nomeSala)	
VALUES('datashow','livre','quebrado','15','LRC');

INSERT INTO utensilios_tb(tipo,status, observacao, locall, marca)
VALUES('notebook','perdido','azul','vivencia', 'NIKE');

INSERT INTO utensilios_tb(tipo,status,observacao,locall, marca)
VALUES('celular','perdido','com a tela quebrada','quadra', 'SAMSUMG');

INSERT INTO utensilios_tb(tipo,status,observacao,locall, marca)
VALUES('pendrive','perdido','com a tela quebrada','sala de aula','THOMASIL');

INSERT INTO Pessoa_Reserva_Chaves_tb(data,horaPedido, horaDevolucao, matricula, idChave)
VALUES('2018-03-20','10:01:00','11:01:00','1234','01'); 

INSERT INTO Pessoa_Reserva_Chaves_tb(data,horaPedido, horaDevolucao, matricula, idChave)
VALUES('2017-01-30','10:02:00','12:01:00','54788','02'); 

INSERT INTO Pessoa_Reserva_Chaves_tb(data,horaPedido, horaDevolucao, matricula, idChave)
VALUES('2017-01-10','10:03:00','13:01:00','54778','03');

INSERT INTO Pessoa_Pesquisa_Utensilios_tb(data,horaPedido, horaDevolucao, matricula, idUtensilio)
VALUES('2017-01-25','10:04:00','14:01:00','1234','01');

INSERT INTO Pessoa_Pesquisa_Utensilios_tb(data,horaPedido, horaDevolucao, matricula, idUtensilio)
VALUES('2017-01-30','10:05:00','15:01:00','54788','02');

INSERT INTO Pessoa_Pesquisa_Utensilios_tb(data,horaPedido, horaDevolucao, matricula, idUtensilio)
VALUES('2017-02-04','10:06:00','16:01:00','54778','03');

INSERT INTO Pessoa_Reserva_Materiais_tb(data,horaPedido, horaDevolucao, matricula, idMaterial)
VALUES('2017-01-25','10:07:00','17:01:00','1234', '01');

INSERT INTO Pessoa_Reserva_Materiais_tb(data,horaPedido, horaDevolucao, matricula, idMaterial)
VALUES('2017-01-30','10:08:00','18:01:00','54788','02');

INSERT INTO Pessoa_Reserva_Materiais_tb(data,horaPedido, horaDevolucao, matricula, idMaterial)
VALUES('2017-01-10','10:09:00','19:01:00','54778','03');

SELECT * FROM pessoa_tb
WHERE Matricula = '1234';

select * FROM docente_tb
WHERE siap = '1222';

SELECT  status
FROM chaves_tb
WHERE nomeSala = 'BD'
OR numeroSala = '12';

SELECT  status
FROM materiais_tb
WHERE nomeSala = 'BD'
OR numeroSala = '13';

SELECT  marca
FROM utensilios_tb
WHERE observacao = 'azul';

SELECT  tipo, locall
FROM utensilios_tb
WHERE marca = 'NIKE';

SELECT  cargo
FROM docente_tb
WHERE area = 'informatica';

SELECT  idMaterial
FROM materiais_tb
WHERE status = 'Reservado';

SELECT  numeroSala, nomeSala
FROM materiais_tb
WHERE idMaterial = '01';

SELECT  idChave
FROM chaves_tb
WHERE status = 'Livre';

SELECT  numeroSala, nomeSala
FROM chaves_tb
WHERE idChave = '01';

SELECT *
FROM pessoa_reserva_chaves_tb
WHERE data
BETWEEN '25-Jan-2017'
AND '30-Jan-2017';

SELECT *
FROM Pessoa_Pesquisa_Utensilios_tb
WHERE data
BETWEEN '25-Jan-2017'
AND '30-Jan-2017';

SELECT *
FROM Pessoa_Reserva_Materiais_tb
WHERE data
BETWEEN '25-Jan-2017'
AND '30-Jan-2017';

SELECT matricula, email, telefone 
FROM pessoa_tb
WHERE Name
IN ('Jao', 'Maria');


SELECT  status
FROM chaves_tb
WHERE numeroSala
IN ('12', '02');

SELECT  Observacao
FROM Materiais_tb
WHERE numeroSala
IN ('11','13');

SELECT  Observacao
FROM Materiais_tb
WHERE numeroSala
IN ('11', '15')
OR nomeSala = 'LRC';

SELECT  status
FROM chaves_tb
WHERE nomeSala
IN ('BD','COPED');

SELECT  Observacao
FROM Materiais_tb
WHERE nomeSala
IN ('LRC', 'CAEST');

SELECT R.data , P.name 
FROM Pessoa_Reserva_Chaves_tb R
inner join pessoa_tb P
on P.matricula = R.matricula
inner join chaves_tb C
on C.idchave = R.idChave
AND C.status = 'reservado';

SELECT D.data, P.name 
FROM Pessoa_Reserva_Materiais_tb D
inner join pessoa_tb P                           
on P.matricula = D.matricula
inner join materiais_tb M
on M.idMaterial = D.idMaterial
AND M.status = 'reservado';

SELECT R.horaDevolucao, R.data
FROM Pessoa_Reserva_Chaves_tb R 
inner join pessoa_tb P
on P.matricula = R.matricula
inner join chaves_tb C
on C.idChave= R.idChave;

SELECT D.horaDevolucao, D.data
FROM Pessoa_Reserva_Materiais_tb D                            
inner join pessoa_tb P
on P.matricula = D.matricula
inner join materiais_tb M
on M.idMaterial= D.idMaterial;


SELECT P.matricula, C.numeroSala, C.nomeSala, A.horaPedido 
FROM Pessoa_Reserva_Chaves_tb A 
inner join pessoa_tb P                                     
on P.matricula = A.matricula AND A.data = '2017-01-10'
inner join chaves_tb C
on C.idChave= A.idChave;


 SELECT P.matricula, M.tipo, M.nomeSala, M.numeroSala, D.horaPedido 
FROM Pessoa_Reserva_Materiais_tb D
inner join pessoa_tb P
on P.matricula = D.matricula and D.data =  '2017-01-25'
inner join materiais_tb M
on M.idMaterial = D.idMaterial;

