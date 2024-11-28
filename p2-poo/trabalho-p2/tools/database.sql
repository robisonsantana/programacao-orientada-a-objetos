CREATE DATABASE usuariodb;

USE usuariodb;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100),
    email VARCHAR(100),
    telefone CHAR(50),
    data_cadastro VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE vacinas (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    fabricante VARCHAR(100),
    lote VARCHAR(50),
    validade VARCHAR(50),
    PRIMARY KEY (id)
);
