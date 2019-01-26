alter table pessoa
add column id_funcionario int unsigned,
add constraint foreign key (id_funcionario) references funcionario(id);