CREATE TABLE resposta (
	id INT8 PRIMARY KEY,
	aluno_id INT8,
	questao_id INT8,
	item_resposta VARCHAR(1),
	FOREIGN KEY (aluno_id) REFERENCES aluno (id),
	FOREIGN KEY (questao_id) REFERENCES questao (id)
);

CREATE SEQUENCE resposta_id_seq INCREMENT 1 START 1;