DROP TABLE IF EXISTS ValorVariavel CASCADE;
DROP TABLE IF EXISTS ValorFixo CASCADE; 
DROP TABLE IF EXISTS Conta_Usuario_Devedor CASCADE;
DROP TABLE IF EXISTS Conta CASCADE;
DROP TABLE IF EXISTS Emprestimo_Usuario_Credor CASCADE;
DROP TABLE IF EXISTS Emprestimo_Usuario_Devedor CASCADE;
DROP TABLE IF EXISTS Emprestimo CASCADE;
DROP TABLE IF EXISTS ItemFaturaTelefonica CASCADE;
DROP TABLE IF EXISTS FaturaTelefonica CASCADE;
DROP TABLE IF EXISTS Usuario_NumeroTelefonico CASCADE;
DROP TABLE IF EXISTS NumeroTelefonico CASCADE;
DROP TABLE IF EXISTS Usuario CASCADE;

CREATE TABLE Usuario (
	email VARCHAR(50) CONSTRAINT usuario_pk PRIMARY KEY,
	nome VARCHAR(50) CONSTRAINT usuario_nome_nn NOT NULL,
	senha CHAR(32) CONSTRAINT usuario_senha_nn NOT NULL
);

CREATE TABLE NumeroTelefonico (
	numero VARCHAR(16) CONSTRAINT numerotelefonico_pk PRIMARY KEY
);

CREATE TABLE Usuario_NumeroTelefonico (
	email VARCHAR(50),
	numero VARCHAR(16),
	data_hora TIMESTAMP,
	recorrencia NUMERIC(1) CONSTRAINT usuario_numtelefonico_nn NOT NULL, 					
	CONSTRAINT usuario_numtelefonico_email_fk FOREIGN KEY (email) REFERENCES Usuario(email) ON DELETE CASCADE,
	CONSTRAINT usuario_numtelefonico_num_fk FOREIGN KEY (numero) REFERENCES NumeroTelefonico(numero) ON DELETE CASCADE,
	CONSTRAINT usuario_numtel_data_hora_pk PRIMARY KEY (email, numero, data_hora)
);

CREATE TABLE FaturaTelefonica (
	mes NUMERIC(2),
	ano NUMERIC(4),
	vencimento TIMESTAMP,
	CONSTRAINT pk_fatura PRIMARY KEY (mes,ano)
);

CREATE TABLE ItemFaturaTelefonica (
	numero VARCHAR(16),
	data_hora TIMESTAMP,
	duracao INTERVAL,
	valor REAL NOT NULL,
	mes NUMERIC(2),
	ano NUMERIC(4),
	CONSTRAINT IFT_numero_fk FOREIGN KEY (numero) REFERENCES  NumeroTelefonico(numero) ON DELETE CASCADE,
	CONSTRAINT IFT_mes_ano_fk FOREIGN KEY (mes,ano) REFERENCES FaturaTelefonica(mes,ano) ON DELETE CASCADE,
	CONSTRAINT IFT_numero_data_hora PRIMARY KEY (numero, data_hora)
);

CREATE TABLE Emprestimo (
    data_hora TIMESTAMP,
    valor NUMERIC(7,2) CONSTRAINT nn_emprestimo_valor NOT NULL,
    descricao VARCHAR(150),
    CONSTRAINT pk_emprestimo PRIMARY KEY (data_hora)
);


CREATE TABLE Emprestimo_Usuario_Devedor (
	data_hora TIMESTAMP,
	email VARCHAR(50),
	CONSTRAINT fk_emprestimo_datahora FOREIGN KEY (data_hora) REFERENCES Emprestimo (data_hora) ON DELETE CASCADE,
	CONSTRAINT fk_usuario_email FOREIGN KEY (email) REFERENCES Usuario (email) ON DELETE CASCADE,
	CONSTRAINT pk_emprestimousuariodevedor PRIMARY KEY (data_hora,email)
);

alter table emprestimo_usuario_devedor
    drop constraint "fk_emprestimo_datahora",
    drop constraint "fk_usuario_email",
    add constraint "fk_emprestimo_datahora" FOREIGN KEY (data_hora) REFERENCES emprestimo(data_hora) ON DELETE CASCADE,
    add constraint "fk_usuario_email" FOREIGN KEY (email) REFERENCES usuario(email) ON DELETE CASCADE;


CREATE TABLE Emprestimo_Usuario_Credor (
    data_hora TIMESTAMP,
    email VARCHAR(50),
    CONSTRAINT EUC_data_hora_fk FOREIGN KEY (data_hora) REFERENCES Emprestimo (data_hora),
    CONSTRAINT EUC_email_fk FOREIGN KEY (email) REFERENCES Usuario (email),
    CONSTRAINT EUC_data_hora_e_email_pk PRIMARY KEY (data_hora,email)
);  

alter table emprestimo_usuario_credor
    drop constraint euc_data_hora_fk,
    drop constraint euc_email_fk,
    add constraint euc_data_hora_fk foreign key (data_hora) references emprestimo(data_hora) ON DELETE CASCADE,
    add constraint euc_email_fk foreign key (email) references usuario(email) ON DELETE CASCADE;


CREATE TABLE Conta (
	nome VARCHAR(50),
	valor NUMERIC(7,2) CONSTRAINT conta_valor_nn NOT NULL,
	email VARCHAR(50) CONSTRAINT conta_email_nn NOT NULL,
	descricao VARCHAR(150),
	CONSTRAINT conta_email_fk FOREIGN KEY (email) REFERENCES Usuario(email) ON DELETE CASCADE,
	CONSTRAINT conta_nome_pk PRIMARY KEY (nome)
);


CREATE TABLE Conta_Usuario_Devedor (
	nome VARCHAR(50),
	email VARCHAR(50),
	proporcao NUMERIC(6,3) CONSTRAINT conta_us_deved_prop_nn NOT NULL, -- a proporcao de participacao do usuario na conta
	CONSTRAINT conta_us_deved_nome_fk FOREIGN KEY (nome) REFERENCES Conta(nome) ON DELETE CASCADE,
	CONSTRAINT conta_us_deved_email_fk FOREIGN KEY (email) REFERENCES Usuario(email) ON DELETE CASCADE,
	CONSTRAINT conta_us_deved_pk PRIMARY KEY (nome, email)
);

CREATE TABLE ValorVariavel (
	nome VARCHAR(50),
	data_de_vencimento TIMESTAMP,
	CONSTRAINT valor_variavel_nome_fk FOREIGN KEY (nome) REFERENCES Conta(nome) ON DELETE CASCADE,
	CONSTRAINT valor_variavel_pk PRIMARY KEY (nome, data_de_vencimento)
);


CREATE TABLE ValorFixo (
	nome VARCHAR(50),
	data_inicial TIMESTAMP, -- se nao houver recorrencia, eh a data de pagamento da conta
	tempo_recorrencia NUMERIC,   -- numero de periodos de recorrencia
	periodo_recorrencia INTERVAL, -- enumerador a ser definido com as seguintes possibilidades: semanal, quinzenal, mensal, bimestral, trimestral, quadrimestral, semestral, anual
        CONSTRAINT VF_nome_fk FOREIGN KEY (nome) REFERENCES Conta (nome),
        CONSTRAINT VF_nome_e_inicial_pk PRIMARY KEY (nome,data_inicial)
);


alter table valorfixo drop constraint vf_nome_fk;
alter table valorfixo add constraint vf_nome_fk foreign key (nome) references conta(nome) ON DELETE CASCADE;


alter table valorvariavel drop constraint valor_variavel_nome_fk;
alter table valorvariavel add constraint valor_variavel_nome_fk foreign key (nome) references conta(nome) ON DELETE CASCADE;

alter table emprestimo_usuario_credor
   drop constraint euc_data_hora_fk,
   drop constraint euc_email_fk,
   add constraint euc_data_hora_fk foreign key (data_hora) references emprestimo(data_hora) ON DELETE CASCADE,
   add constraint euc_email_fk foreign key (email) references usuario(email) ON DELETE CASCADE;
   
   
alter table emprestimo_usuario_devedor
   drop constraint "fk_emprestimo_datahora",
   drop constraint "fk_usuario_email",
   add constraint "fk_emprestimo_datahora" FOREIGN KEY (data_hora) REFERENCES emprestimo(data_hora) ON DELETE CASCADE,
   add constraint "fk_usuario_email" FOREIGN KEY (email) REFERENCES usuario(email) ON DELETE CASCADE;
   

alter table itemfaturatelefonica
   drop constraint    "ift_mes_ano_fk",
   drop constraint    "ift_numero_fk",
   add constraint "ift_mes_ano_fk" FOREIGN KEY (mes, ano) REFERENCES faturatelefonica(mes, ano) ON DELETE CASCADE,
   add constraint "ift_numero_fk" FOREIGN KEY (numero) REFERENCES numerotelefonico(numero) ON DELETE CASCADE;

--------------------------------------


-- Usuario --
INSERT INTO Usuario (email, nome, senha)
VALUES ('danilod100@gmail.com','Danilo G Rodrigues',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('nelsonguicg@gmail.com','Nelson G C Guimaraes',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('endril.caps@gmail.com','Endril Capelli da Silva',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('danielpes91@gmail.com','Daniel de Paula e Silva',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('zepitanga@gmail.com','Henrique Jose Pires Barcelos',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('alexcrondon@gmail.com','Alexandre Coelho Rondon',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('neco2neco@dominio.com','Roberty Amaral',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('daisyflor@dominio.com','Deizenil da Silva Santos',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('madalena@dominio.com','Madalena Yuki Hichara',md5('12345'));

INSERT INTO Usuario (email, nome, senha)
VALUES ('celsorock_skate@dominio.com','Celso Abreu',md5('12345'));


-- NumeroTelefonico --
INSERT INTO NumeroTelefonico (numero)
VALUES ('5534159898');

INSERT INTO NumeroTelefonico (numero)
VALUES ('5535837698');

INSERT INTO NumeroTelefonico (numero)
VALUES ('5534156543');

INSERT INTO NumeroTelefonico (numero)
VALUES ('4487656543');

INSERT INTO NumeroTelefonico (numero)
VALUES ('5535288765');

INSERT INTO NumeroTelefonico (numero)
VALUES ('5534153467');

INSERT INTO NumeroTelefonico (numero)
VALUES ('5597977979');

INSERT INTO NumeroTelefonico (numero)
VALUES ('55333685268');

INSERT INTO NumeroTelefonico (numero)
VALUES ('5591873456');

INSERT INTO NumeroTelefonico (numero)
VALUES ('5588836575');


-- Usuario_NumeroTelefonico --
INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('danilod100@gmail.com', '5591873456', to_timestamp('15/03/2011 - 18:45','dd/mm/yyyy - HH24:mi'), 0);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('danilod100@gmail.com','4487656543', to_timestamp('25/05/2011 - 18:00','dd/mm/yyyy - HH24:mi'), 1);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('endril.caps@gmail.com', '5534159898', to_timestamp('19/10/2012 - 00:00','dd/mm/yyyy - HH24:mi'), 1);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('nelsonguicg@gmail.com', '5535288765', to_timestamp('01/01/2012 - 23:40','dd/mm/yyyy - HH24:mi'), 1);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('nelsonguicg@gmail.com', '5597977979', to_timestamp('01/01/2012 - 09:35','dd/mm/yyyy - HH24:mi'), 1);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('danilod100@gmail.com', '5591873456', to_timestamp('20/10/2011 - 10:00','dd/mm/yyyy - HH24:mi'), 0);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('celsorock_skate@dominio.com', '5591873456', to_timestamp('20/10/2011 - 19:00','dd/mm/yyyy - HH24:mi'), 0);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('danielpes91@gmail.com', '5588836575', to_timestamp('15/04/2011 - 16:55','dd/mm/yyyy - HH24:mi'), 1);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('danielpes91@gmail.com', '5535837698', to_timestamp('15/04/2011 - 17:00','dd/mm/yyyy - HH24:mi'), 0);

INSERT INTO Usuario_NumeroTelefonico (email, numero, data_hora, recorrencia)
VALUES ('daisyflor@dominio.com', '5534153467', to_timestamp('15/03/2012 - 07:30','dd/mm/yyyy - HH24:mi'), 1);


-- FaturaTelefonica
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (2,2012,to_timestamp('20/02/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (3,2012,to_timestamp('20/03/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (4,2012,to_timestamp('20/04/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (5,2012,to_timestamp('20/05/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (6,2012,to_timestamp('20/06/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (7,2012,to_timestamp('20/07/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (8,2012,to_timestamp('20/08/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (9,2012,to_timestamp('20/09/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (10,2012,to_timestamp('20/10/2012','dd/mm/yyyy'));
INSERT INTO FaturaTelefonica (mes,ano,vencimento) VALUES (11,2012,to_timestamp('20/11/2012','dd/mm/yyyy'));

-- Emprestimo
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('15/02/2012 12:23','dd/mm/yyyy hh24:mi'),12.50,'Pizzaria Torre de Pizza');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('23/03/2012 15:01','dd/mm/yyyy hh24:mi'),21.00,'Xerox Guidorizzi');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('07/04/2012 20:10','dd/mm/yyyy hh24:mi'),5.00,'Salgado');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('22/06/2012 07:51','dd/mm/yyyy hh24:mi'),1.80,'RU');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('30/04/2012 11:42','dd/mm/yyyy hh24:mi'),12.00,'Convite Cervejada da Formatura');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('05/02/2012 10:25','dd/mm/yyyy hh24:mi'),20.00,'Pastel');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('07/04/2012 01:18','dd/mm/yyyy hh24:mi'),60.00,'Rodizio japones');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('22/05/2012 21:31','dd/mm/yyyy hh24:mi'),5.00,'Salgado');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('11/12/2012 20:42','dd/mm/yyyy hh24:mi'),7.00,'Açaí');
INSERT INTO Emprestimo (data_hora,valor,descricao) VALUES (to_timestamp('01/10/2012 18:37','dd/mm/yyyy hh24:mi'),1.00,'Esmola');

-- Emprestimo_Usuario_Devedor
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('15/02/2012 12:23','dd/mm/yyyy hh24:mi'),'nelsonguicg@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('15/02/2012 12:23','dd/mm/yyyy hh24:mi'),'danilod100@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('15/02/2012 12:23','dd/mm/yyyy hh24:mi'),'celsorock_skate@dominio.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('23/03/2012 15:01','dd/mm/yyyy hh24:mi'),'zepitanga@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('23/03/2012 15:01','dd/mm/yyyy hh24:mi'),'nelsonguicg@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('07/04/2012 20:10','dd/mm/yyyy hh24:mi'),'alexcrondon@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('22/06/2012 07:51','dd/mm/yyyy hh24:mi'),'danielpes91@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('30/04/2012 11:42','dd/mm/yyyy hh24:mi'),'neco2neco@dominio.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('05/02/2012 10:25','dd/mm/yyyy hh24:mi'),'danilod100@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('05/02/2012 10:25','dd/mm/yyyy hh24:mi'),'daisyflor@dominio.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('07/04/2012 01:18','dd/mm/yyyy hh24:mi'),'celsorock_skate@dominio.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('22/05/2012 21:31','dd/mm/yyyy hh24:mi'),'alexcrondon@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('11/12/2012 20:42','dd/mm/yyyy hh24:mi'),'endril.caps@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('11/12/2012 20:42','dd/mm/yyyy hh24:mi'),'zepitanga@gmail.com');
INSERT INTO Emprestimo_Usuario_Devedor (data_hora,email) VALUES (to_timestamp('01/10/2012 18:37','dd/mm/yyyy hh24:mi'),'neco2neco@dominio.com');


--Emprestimo_Usuario_Credor 
INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES ( to_timestamp('15/02/2012 12:23','dd/mm/yyyy hh24:mi') , 'danilod100@gmail.com' );
	
INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES ( to_timestamp('23/03/2012 15:01','dd/mm/yyyy hh24:mi') , 'nelsonguicg@gmail.com' );

INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES (  to_timestamp('07/04/2012 20:10','dd/mm/yyyy hh24:mi') , 'endril.caps@gmail.com' );

INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES (  to_timestamp('22/06/2012 07:51','dd/mm/yyyy hh24:mi') , 'danielpes91@gmail.com' );
	
INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES (  to_timestamp('30/04/2012 11:42','dd/mm/yyyy hh24:mi') , 'zepitanga@gmail.com' );
	
INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES ( to_timestamp('05/02/2012 10:25','dd/mm/yyyy hh24:mi') , 'alexcrondon@gmail.com' );
	
INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES ( to_timestamp('07/04/2012 01:18','dd/mm/yyyy hh24:mi')  , 'neco2neco@dominio.com' );

INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES ( to_timestamp('22/05/2012 21:31','dd/mm/yyyy hh24:mi')  , 'daisyflor@dominio.com' );

INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES (  to_timestamp('11/12/2012 20:42','dd/mm/yyyy hh24:mi')  , 'madalena@dominio.com' );
	
INSERT INTO Emprestimo_Usuario_Credor (data_hora , email )
VALUES (  to_timestamp('01/10/2012 18:37','dd/mm/yyyy hh24:mi')  , 'celsorock_skate@dominio.com' );


--ItemFaturaTelefonica 
INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '5534159898' , to_timestamp('12/08/2012','dd/mm/yyyy') , '10 minutes' , 100 ,9,2012 );

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '5535837698', to_timestamp('12/09/2012','dd/mm/yyyy') , '1 minute 10 seconds' , 200 , 10,2012 );

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '5534156543' , to_timestamp('12/10/2012','dd/mm/yyyy') , '5 minutes', 300 , 11,2012 );

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '4487656543' , to_timestamp('12/01/2012','dd/mm/yyyy') , '25 minutes 2 seconds'  , 400 , 2,2012);

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '5535288765' , to_timestamp('12/02/2012','dd/mm/yyyy') , '1 hour' , 500 , 3,2012);

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '5534153467' , to_timestamp('12/03/2012','dd/mm/yyyy') , '2 minutes 4 seconds'  , 600 , 4,2012);

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '5597977979' , to_timestamp('12/04/2012','dd/mm/yyyy') , '15 minutes 30 seconds'  , 700 , 5,2012);

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '55333685268' , to_timestamp('12/05/2012','dd/mm/yyyy') , '5 minutes'  , 800 , 6,2012);

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '5591873456' , to_timestamp('12/06/2012','dd/mm/yyyy') , '35 minutes'  , 900 , 7,2012);

INSERT INTO ItemFaturaTelefonica (numero , data_hora, duracao, valor, mes, ano)
VALUES ( '5588836575' , to_timestamp('12/07/2012','dd/mm/yyyy') , '1 hour 35 seconds' , 50 , 8,2012);


--Conta
INSERT INTO Conta(nome, valor, email, descricao)
VALUES ('Água-02/2013', 81.67, 'danilod100@gmail.com', 'Conta referente ao consumo de água do mes de fevereiro');
    
INSERT INTO Conta (nome, valor, email, descricao)
VALUES ('Luz-02/2013', 124.18, 'endril.caps@gmail.com', 'Conta referente ao consumo de luz do mes de fevereiro');

INSERT INTO Conta (nome, valor, email, descricao)
VALUES ('Água-03/2013', 77.14, 'danilod100@gmail.com', 'Conta referente ao consumo de água do mes de março');

INSERT INTO Conta(nome, valor, email, descricao)
VALUES ('Luz-03/2013', 161.02, 'endril.caps@gmail.com', 'Conta referente ao consumo de luz do mes de março');

INSERT INTO Conta (nome, valor, email,descricao)
VALUES ('Água-04/2013', 97.18, 'danilod100@gmail.com', 'Conta referente ao consumo de água do mes de abril');

INSERT INTO Conta(nome, valor, email, descricao)
VALUES ('Luz-04/2013', 121.15, 'endril.caps@gmail.com', 'Conta referente ao consumo de luz do mes de abril');
   
INSERT INTO Conta (nome, valor, email, descricao)
VALUES ('Água-05/2013', 71.23, 'danilod100@gmail.com', 'Conta referente ao consumo de água do mes de maio');

INSERT INTO Conta(nome, valor, email, descricao)
VALUES ('Luz-05/2013', 197.51, 'endril.caps@gmail.com', 'Conta referente ao consumo de luz do mes de maio');
   
INSERT INTO Conta (nome, valor, email, descricao)
VALUES ('Água-06/2013', 82.55, 'danilod100@gmail.com', 'Conta referente ao consumo de água do mes de junho');

INSERT INTO Conta(nome, valor, email, descricao)
VALUES ('Luz-06/2013', 171.53, 'endril.caps@gmail.com', 'Conta referente ao consumo de luz do mes de junho');

INSERT INTO Conta (nome, valor, email)
VALUES ('Aluguel', 1221.15, 'nelsonguicg@gmail.com');

INSERT INTO Conta (nome, valor, email)
VALUES ('Condominio', 200.00, 'nelsonguicg@gmail.com');
    
INSERT INTO Conta(nome, valor, email, descricao)
VALUES ('Empregada', 250.00, 'zepitanga@gmail.com', 'Pagamento da empregada');
    
INSERT INTO Conta (nome, valor, email)
VALUES ('Sky', 254.72, 'alexcrondon@gmail.com');

INSERT INTO Conta(nome, valor, email, descricao)
VALUES ('Carro', 811.02, 'danielpes91@gmail.com', 'Mensalidade da compra do carro');
    
INSERT INTO Conta (nome, valor, email, descricao)
VALUES('Pintura', 2871.14, 'zepitanga@gmail.com', 'Referente à pintura realizada');

INSERT INTO Conta (nome, valor, email, descricao)
VALUES('TV Nova', 265.10, 'zepitanga@gmail.com', 'Referente à compra da nova TV');

INSERT INTO Conta (nome, valor, email, descricao)
VALUES('Sofá', 81.00, 'zepitanga@gmail.com', 'Referente à compra do sofá');

INSERT INTO Conta (nome, valor, email)
VALUES('Mesa da sala', 71.14, 'zepitanga@gmail.com');

INSERT INTO Conta (nome, valor, email, descricao)
VALUES('Geladeira', 180.14, 'zepitanga@gmail.com', 'Referente à compra da geladeira');
    

--Conta_Usuario_Devedor
INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','danilod100@gmail.com', 0.2);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','nelsonguicg@gmail.com', 0.05);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','endril.caps@gmail.com', 0.05);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','danielpes91@gmail.com', 0.75);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','zepitanga@gmail.com', 0.75);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','alexcrondon@gmail.com', 0.75);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','neco2neco@dominio.com', 0.75);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','daisyflor@dominio.com', 0.15);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','madalena@dominio.com', 0.15);

INSERT INTO Conta_Usuario_Devedor (nome, email, proporcao)
VALUES ('Aluguel','celsorock_skate@dominio.com', 0.1);


--ValorVariavel
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Água-02/2013', to_timestamp('09/02/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Luz-02/2013', to_timestamp('11/02/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Água-03/2013', to_timestamp('09/03/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Luz-03/2013', to_timestamp('11/03/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Água-04/2013', to_timestamp('09/04/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Luz-04/2013', to_timestamp('11/04/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Água-05/2013', to_timestamp('09/05/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Luz-05/2013', to_timestamp('11/05/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Água-06/2013', to_timestamp('09/06/2013','dd/mm/yyyy'));
    
INSERT INTO ValorVariavel (nome, data_de_vencimento)
    VALUES ('Luz-06/2013', to_timestamp('11/06/2013','dd/mm/yyyy'));


--ValorFixo 
INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia  , periodo_recorrencia)
VALUES ( 'Aluguel' , to_timestamp('12/05/2013', 'dd/mm/yyyy') ,  02 , '1 month');

INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'Empregada', to_timestamp('12/02/2013', 'dd/mm/yyyy') ,  11 , '1 week');
	
INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'Sky', to_timestamp('15/05/2012', 'dd/mm/yyyy') ,  10 , '1 month');

INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'Carro', to_timestamp('01/06/2012', 'dd/mm/yyyy') ,  12 , '2 weeks');

INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'Condominio', to_timestamp('30/02/2012', 'dd/mm/yyyy') ,  09 , '1 month');

INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'Pintura', to_timestamp('31/01/2014', 'dd/mm/yyyy') ,  01 , '1 day');

INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'TV Nova', to_timestamp('20/03/2013', 'dd/mm/yyyy') ,  08 , '1 week');

INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'Sofá', to_timestamp('10/07/2012', 'dd/mm/yyyy') ,  12 , '1 week');

INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'Mesa da sala', to_timestamp('22/04/2012', 'dd/mm/yyyy') ,  08 , '1 week');

INSERT INTO ValorFixo (nome, data_inicial , tempo_recorrencia , periodo_recorrencia)
VALUES ( 'Geladeira', to_timestamp('10/08/2012', 'dd/mm/yyyy') ,  19 , '1 week');


CREATE OR REPLACE FUNCTION ValorPorUsuario (valor numeric, usuarios bigint)
RETURNS real AS $$
BEGIN
	return valor/usuarios;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE VIEW EmprestimoDetalhado AS
	SELECT E.data_hora, E.valor Total,
COUNT(DISTINCT D.email) Devedores,
COUNT(DISTINCT C.email) Credores,
ValorPorUsuario(E.valor,COUNT(DISTINCT D.email)) ValorPorDevedor,
ValorPorUsuario(E.valor,COUNT(DISTINCT C.email)) ValorPorCredor
	FROM Emprestimo E
		JOIN Emprestimo_Usuario_Devedor D ON E.data_hora=D.data_hora
		JOIN Emprestimo_Usuario_Credor C ON E.data_hora=C.data_hora
	GROUP BY E.data_hora;

CREATE OR REPLACE VIEW TotalDividas AS
	SELECT U.email, COALESCE(SUM(E.ValorPorDevedor),0) Dividas
	FROM Usuario U
		LEFT JOIN Emprestimo_Usuario_Devedor D ON U.email=D.email
		LEFT JOIN EmprestimoDetalhado E ON D.data_hora=E.data_hora
	GROUP BY U.email;

CREATE OR REPLACE VIEW TotalCreditos AS
	SELECT U.email, COALESCE(SUM(E.ValorPorCredor),0) Creditos
	FROM Usuario U
		LEFT JOIN Emprestimo_Usuario_Credor C ON U.email=C.email
		LEFT JOIN EmprestimoDetalhado E ON C.data_hora=E.data_hora
	GROUP BY U.email;

CREATE OR REPLACE FUNCTION Saldo (devedor real, credor real)
RETURNS real AS $$
BEGIN
	return credor-devedor;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE VIEW UsuarioV AS
	SELECT U.email, U.nome, U.senha, Saldo(dividas,creditos)
	FROM TotalDividas D, TotalCreditos C, Usuario U
	WHERE D.email=C.email AND U.email=D.email;




CREATE OR REPLACE FUNCTION insereItemFaturaProcedure()
RETURNS TRIGGER AS
$$
DECLARE
	temp1 numeric;
BEGIN
	SELECT count(numero) INTO temp1 FROM NumeroTelefonico WHERE numero=new.numero;

	IF (temp1=0) THEN
		INSERT INTO NumeroTelefonico(numero) VALUES (new.numero);
	END IF;	

	
	return new;
END;
$$ LANGUAGE plpgsql;



CREATE TRIGGER insertLigacao
BEFORE INSERT ON Usuario_NumeroTelefonico
FOR EACH ROW
EXECUTE PROCEDURE insereItemFaturaProcedure();

CREATE TRIGGER insereItemFaturaTrigger
BEFORE INSERT ON ItemFaturaTelefonica
FOR EACH ROW
EXECUTE PROCEDURE insereItemFaturaProcedure();