drop database if exists progest;
create database progest;
use progest;
drop table if exists questao;
drop table if exists materia;
create table materia (id bigint not null auto_increment, nome varchar(255), primary key (id));
create table questao (id bigint not null auto_increment, adicionada_em date, corpo varchar(255), descricao varchar(255), dificuldade varchar(255), is_processo_seletivo bit not null, url_questao varchar(255), usada_em date, id_questao bigint, primary key (id));
alter table questao add constraint FKtd0clqgdljgaysl693lwr97h4 foreign key (id_questao) references materia (id);
show tables;
