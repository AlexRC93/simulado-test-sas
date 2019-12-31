CREATE TABLE questao (
	id INT8 PRIMARY KEY,
	prova_id INT8,
	enunciado VARCHAR(500),
	item_a VARCHAR(100),
	item_b VARCHAR(100),
	item_c VARCHAR(100),
	item_d VARCHAR(100),
	peso VARCHAR(20),
	FOREIGN KEY (prova_id) REFERENCES prova (id)
);