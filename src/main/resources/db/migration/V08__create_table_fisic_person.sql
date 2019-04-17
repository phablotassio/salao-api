CREATE TABLE fisic_person (

  id_person int unsigned,
  date_birth date not null,
  full_name varchar (100) not null ,
  nick_name varchar(30) not null,
  sex_type ENUM('M','F'),
  primary key (id_person),
  foreign key (id_person) references person(id)

)