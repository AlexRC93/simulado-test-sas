CREATE TABLE prova (
	id INT8 PRIMARY KEY,
	disciplina VARCHAR(50),
	simulado_id INT8,
	FOREIGN KEY (simulado_id) REFERENCES simulado (id)
);