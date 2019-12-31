CREATE TABLE ranking (
	id INT8 PRIMARY KEY,
	aluno_id INT8,
	nota FLOAT8,
	colocacao INT2,
	simulado_id INT8,
	FOREIGN KEY (aluno_id) REFERENCES aluno (id),
	FOREIGN KEY (simulado_id) REFERENCES simulado (id)
);

CREATE SEQUENCE ranking_id_seq INCREMENT 1 START 1;