ALTER TABLE pessoa
RENAME TO person;

ALTER TABLE person
CHANGE COLUMN nome full_name varchar(100);

ALTER TABLE person
CHANGE COLUMN cpf document_number varchar(14);

ALTER TABLE person
CHANGE COLUMN telefone telephone_number varchar(18);

ALTER TABLE person
ADD COLUMN inclusion_date date;

ALTER TABLE person
DROP FOREIGN KEY person_ibfk_1;

ALTER TABLE person
DROP FOREIGN KEY person_ibfk_2;

ALTER TABLE person
DROP COLUMN id_funcionario;

ALTER TABLE person
DROP COLUMN id_endereco;







