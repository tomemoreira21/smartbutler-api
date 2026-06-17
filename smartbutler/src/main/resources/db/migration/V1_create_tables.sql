CREATE DATABASE SmartButler;
USE SmartButler;

CREATE TABLE Utilizador (
	id INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE Categoria (
	id INT AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Transacao (
	id INT AUTO_INCREMENT,
    utilizador_id INT NOT NULL,
    categoria_id INT NOT NULL,
    descricao VARCHAR(255),
    valor DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    data_transacao DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (utilizador_id) REFERENCES Utilizador(id),
    FOREIGN KEY (categoria_id) REFERENCES Categoria(id)
);

