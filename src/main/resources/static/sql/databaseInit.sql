drop database if exists progest;
create database progest;
use progest;
drop table if exists questao;
drop table if exists materia;
create table materia (id bigint not null auto_increment, nome varchar(255), primary key (id));
create table questao (id bigint not null auto_increment, adicionada_em date, corpo varchar(255), descricao varchar(255), dificuldade varchar(255), url_questao varchar(255), usada_em date, id_questao bigint, primary key (id));
alter table questao add constraint FKtd0clqgdljgaysl693lwr97h4 foreign key (id_questao) references materia (id);

/* Inserting all materias*/
insert into materia (nome) values ('Linguagem para Fins Profissionais');
insert into materia (nome) values ('Matemática Básica');
insert into materia (nome) values ('Informática Geral');
insert into materia (nome) values ('Leitura de Projetos Arquitetônicos');
insert into materia (nome) values ('Materiais de Construção');
insert into materia (nome) values ('Leitura de Projetos Elétricos');
insert into materia (nome) values ('Leitura de Projetos Estruturais');
insert into materia (nome) values ('Tecnologia das Construções');
insert into materia (nome) values ('Gestão de pessoas');
insert into materia (nome) values ('Logística, arranjos e fluxos');
insert into materia (nome) values ('Gestão Ambiental');
insert into materia (nome) values ('Qualidade e Produtividade');
insert into materia (nome) values ('Ergonomia e Segurança do Trabalho');
insert into materia (nome) values ('Legislação Trabalhista');

insert into materia (nome) values ('Informática Básica');
insert into materia (nome) values ('Equipamentos Elétricos');
insert into materia (nome) values ('Interpretação de Projetos Elétricos');
insert into materia (nome) values ('Proteção de Instalações Elétricas');
insert into materia (nome) values ('Segurança em Instalações Elétricas');
insert into materia (nome) values ('Instrumentos de Medições');
/*End inserting*/

show tables;
