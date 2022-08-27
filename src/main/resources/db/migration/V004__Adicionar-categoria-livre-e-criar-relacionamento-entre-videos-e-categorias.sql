ALTER TABLE videos 
	ADD COLUMN 
	categoria_id BIGINT NOT NULL; 
	
INSERT INTO categorias 
	(titulo, cor) VALUES 
	('LIVRE', '#b7d5ac');
UPDATE videos 
	SET categoria_id = 1 
	WHERE categoria_id = 0;
	
ALTER TABLE videos 
	ADD CONSTRAINT 
	fk_categoria_id 
	FOREIGN KEY (categoria_id) REFERENCES  categorias(id);