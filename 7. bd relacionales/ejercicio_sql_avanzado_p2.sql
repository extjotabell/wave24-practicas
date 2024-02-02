-- 1. Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, release_date, length, genre_id)
VALUES ('The Dark Knight', 9.0, '2008-07-18', 152, 4);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ('Independiente', 13, 1);

-- 3. Asignar el género creado a la película creada.
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = 'Independiente')
WHERE title = 'The Dark Knight';

-- 4. Asignar la película creada como favorita a un actor.
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'The Dark Knight')
WHERE first_name = 'Aaron'
  AND last_name = 'Paul';

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies AS
SELECT *
FROM movies;

-- 6. Eliminar las películas con premios menores o iguales a 5.
DELETE
FROM temp_movies
WHERE awards <= 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name, COUNT(m.title) AS number_of_movies
FROM genres g
         LEFT JOIN movies m ON g.id = m.genre_id
GROUP BY g.id, g.name
HAVING number_of_movies > 0;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards
SELECT a.first_name, a.last_name
FROM movies m
         LEFT JOIN actors a ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

-- 9. Crear un índice en la tabla movies para el campo title.
CREATE INDEX idx_movies_title ON movies (title);

-- 10. Verificar que el índice fue creado.
SHOW INDEX FROM movies;
