# Ejercicio 1

-- 1. Crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”
CREATE TEMPORARY TABLE TWD
SELECT ep.id, ep.title, ep.number, ep.rating, ep.release_date, se.number AS season_number
FROM series s
         JOIN seasons se ON s.id = se.serie_id
         JOIN episodes ep ON se.id = ep.season_id
WHERE s.title = 'The Walking Dead';

-- 2. Mostrar los episodios de la primera temporada de “The Walking Dead”
SELECT *
FROM TWD
WHERE season_number = 1;


# Ejercicio 2

-- 1. Seleccionar una tabla donde crear un índice y luego chequear la creación del mismo
CREATE INDEX idx_title ON actors (last_name);
SHOW INDEX FROM actors;

EXPLAIN SELECT * FROM actors WHERE last_name LIKE 'W%';