create schema if not exists barbearia;

use barbearia;

create table user(id_admin int(3) not null primary key auto_increment, login varchar(50) not null unique, senha text not null);

create table comentario(id_comentario int(3) not null primary key auto_increment, nome varchar(150) not null, texto text, bairro varchar(50) not null, nota double not null, publicar enum('S', 'N') default 'N' not null);

create table equipe(id_equipe int(3) not null primary key auto_increment, nome varchar(150) not null, descricao text, foto varchar(255) not null, xp year not null);

create table servico(id_servico int(3) not null primary key auto_increment, nome varchar(150) not null, valor float not null, foto varchar(255) not null);