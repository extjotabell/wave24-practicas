-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title as titulo, g.name as genero
FROM series s INNER JOIN genres g
ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title as episodio, CONCAT(a.first_name, ' ', a.last_name) as nombreApellido
FROM actor_episode ae 
INNER JOIN actors a ON a.id  = ae.actor_id 
INNER JOIN episodes e ON e.id = ae.episode_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s1.title as serie, COUNT(s.id) as totalTemporadas 
FROM seasons s 
INNER JOIN series s1 ON s.serie_id = s1.id
GROUP BY s1.title ;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
-- siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.genre_id) AS total
FROM movies m
INNER JOIN genres g ON m.genre_id = g.id
GROUP BY g.name
HAVING total >= 3; 

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias 
-- y que estos no se repitan.
SELECT DISTINCT a.first_name as nombre, a.last_name as apellido
FROM actor_movie am 
INNER JOIN actors a ON a.id = am.actor_id 
INNER JOIN movies m ON m.id = am.movie_id 
WHERE m.title LIKE 'La Guerra de las galaxias%';