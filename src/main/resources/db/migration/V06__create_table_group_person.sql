CREATE TABLE TB_GROUP_PERSON(

  ID_GROUP_PERSON int unsigned not null auto_increment,
  DESCRIPTION varchar(50) not null,
  PRIMARY KEY (ID_GROUP_PERSON)

)engine = INNODB default  charset = utf8;

insert into TB_GROUP_PERSON (DESCRIPTION) values ('Salão Dirce');
insert into TB_GROUP_PERSON (DESCRIPTION) values ('DF SINUCA');



