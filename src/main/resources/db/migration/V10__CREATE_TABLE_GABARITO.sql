CREATE TABLE gabarito (
	id INT8 PRIMARY KEY,
	questao_id INT8,
	item_resposta VARCHAR(1),
	FOREIGN KEY (questao_id) REFERENCES questao (id)
);