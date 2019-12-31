CREATE TABLE simulado (
	id INT8 PRIMARY KEY,
	titulo VARCHAR(100),
	data DATE
);

INSERT INTO simulado (id, titulo, data)
    VALUES (1, 'Simulado Farias Brito', current_date);

INSERT INTO simulado (id, titulo, data)
    VALUES (2, 'Simulado Ari de Sá', current_date);