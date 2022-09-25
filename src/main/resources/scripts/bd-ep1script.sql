show tables;

CREATE TABLE USERS (

	id int,
	nombre varchar(255),
	usuario varchar(20),
	tipDoc char(5),
	nroDoc varchar(20),
	enable int
	)


ALTER TABLE USERS ADD PRIMARY KEY (id) ;

ALTER TABLE USERS MODIFY COLUMN id int auto_increment NOT NULL;

INSERT INTO USERS (nombre,usuario,tipDoc,nroDoc,enable)
VALUES ('Andrea','DNI45823695','DNI','45823695',1);

INSERT INTO USERS (nombre,usuario,tipDoc,nroDoc,enable)
VALUES ('Natalia','DNI45369325','DNI','45369325',1);

UPDATE USERS SET nombre='Carolina' WHERE usuario ='DNI45369325';

DELETE FROM USERS WHERE username='DNI45823695';

SELECT * FROM USERS