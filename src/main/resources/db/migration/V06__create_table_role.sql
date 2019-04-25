create table TB_ROLE (

  ID_ROLE int unsigned auto_increment,
  DESCRIPTION varchar(100) not null unique,
  primary key (ID_ROLE)

) engine = INNODB default  charset = utf8;

insert into TB_ROLE (DESCRIPTION) values ('Gerente'), ('Cabelereira'), ('Manicure e Pedicure'), ('Secretaria'), ('Técnico de Informática');