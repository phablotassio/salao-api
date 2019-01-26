create table endereco (
  id int unsigned auto_increment,
  cidade varchar(25) not null,
  descricao varchar(35) not null,
  cep varchar(11) not null,
  primary key (id)
) engine = INNODB default  charset = utf8;