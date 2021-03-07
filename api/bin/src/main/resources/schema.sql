CREATE TABLE IF NOT EXISTS laboratorio (
  id              INT     NOT NULL PRIMARY KEY,
  nome       	  VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS sala (
  id              INT      NOT NULL PRIMARY KEY,
  idLab			  INT      NOT NULL,
  nome       	  VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS equipamento (
  id              INT      NOT NULL PRIMARY KEY,
  idSala	      INT      NOT NULL,
  tombamento	  INT      NOT NULL,
  nome       	  VARCHAR(200) NOT NULL
);
