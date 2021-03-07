CREATE TABLE IF NOT EXISTS laboratorio(
idLab int not null primary key,
nome varchar(200)
);

CREATE TABLE IF NOT EXISTS sala(
idSala int not null primary key,
idLab int not null,
nome varchar(200),
foreign key (idLab) references laboratorio(idLab)
);

CREATE TABLE IF NOT EXISTS equipamento(
idEqui int not null primary key,
idSala int not null,
nome varchar(200),
tombamento int not null,
foreign key (idSala) references sala(idSala)
);