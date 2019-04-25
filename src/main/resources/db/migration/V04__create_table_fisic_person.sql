CREATE TABLE TB_FISIC_PERSON (

  ID_FISIC_PERSON int unsigned,
  BIRTH_DATE date not null,
  FULL_NAME varchar (100) not null,
  NICK_NAME varchar(30),
  SEX_TYPE ENUM('M','F') not null,
  primary key (ID_FISIC_PERSON),
  CONSTRAINT FK_PERSON_TB_FISIC_PERSON foreign key (ID_FISIC_PERSON) references TB_PERSON(ID_PERSON)

) engine = INNODB default  charset = utf8;