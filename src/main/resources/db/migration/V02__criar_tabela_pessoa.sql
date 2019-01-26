create table pessoa(
  id int unsigned auto_increment,
  id_endereco int unsigned,
  nome varchar (50) not null ,
  cpf varchar (15) not null,
  telefone varchar(25) not null,
  email varchar(25) not null,
  primary key (id),
  foreign key (id_endereco) references endereco(id)
) engine = INNODB default charset = utf8;