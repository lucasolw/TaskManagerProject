CREATE DATABASE taskmanager;
USE taskmanager;

CREATE TABLE tarefas(
	id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT,
    concluida BOOLEAN DEFAULT FALSE NOT NULL,
    prioridade VARCHAR(50)
);

SELECT * FROM tarefas;


DROP TABLE tarefas;