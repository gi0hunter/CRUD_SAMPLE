use CRUD;
create table USUARIO(
   id INT NOT NULL AUTO_INCREMENT,
   nome VARCHAR(255) NOT NULL,
   dataNascimento Date NOT NULL,
   imgPath VARCHAR(255),
   PRIMARY KEY ( id )
);