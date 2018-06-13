create table funcionario(

cpf varchar(11) not null,
nome varchar(100) not null,
telefone varchar(15),
email varchar(70), 
endereco varchar (200) not null,
constraint funcionario_cpf_pk primary key(cpf)
);

insert into funcionario values ("45631720817", "Gabriel Gregorio", "(13)991674735", "eu@eumesmo.com", "Rua Rua Rua, 10- SP/SP");
delete from funcionario where cpf like "321";
commit;
select * from funcionario;
update funcionario set telefone = "123", email = "123" , endereco = "123" where cpf like "1";


create table fornecedor(
cnpj varchar(14) not null,
nome varchar(100) not null,
telefone varchar(15),
email varchar(70),
endereco varchar (200),
constraint funcionario_cpf_pk primary key(cnpj)
);

insert into fornecedor values ("45631720817", "Gabriel Gregorio", "(13)991674735", "eu@eumesmo.com", "Rua Rua Rua, 10- SP/SP");
select * from fornecedor;


create table produto(
cod varchar(10) not null,
nome varchar(100) not null, 
marca varchar(50),
preco_compra varchar(10),
preco_venda varchar(10),
fornecedor varchar(100),
constraint produto_cod_pk primary key(cod)
);

insert into produto values("1", "Perfume", "O Boticário", 10.5, 50.50, "Dahora");
insert into produto values("2", "Prerere", "Tcharara", 15, 25, "Boladão");
select * from produto;







