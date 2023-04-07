CREATE TABLE cliente (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(150) NOT NULL,
  documento varchar(14) NOT NULL,
  email varchar(255) NOT NULL,
  telefone varchar(14) NOT NULL,
  data_cadastro datetime NOT NULL,
  data_atualizacao datetime DEFAULT NULL,
  PRIMARY KEY (id)
)