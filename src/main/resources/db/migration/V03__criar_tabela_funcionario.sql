create table funcionario (
  id int unsigned auto_increment,
  id_pessoa int unsigned,
  cargo varchar (15) not null,
  primary key(id),
  foreign key(id_pessoa) references pessoa(id)

) engine = INNODB  default charset = utf8;