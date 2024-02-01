-- Mostrar el título y el nombre del género de todas las series.
SELECT ser.title, gen.name
FROM series ser
INNER JOIN genres gen ON ser.genre_id = gen.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, acts.first_name, acts.last_name
FROM episodes ep
INNER JOIN actor_episode act_ep ON ep.id = act_ep.episode_id
INNER JOIN actors acts ON act_ep.actor_id = acts.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(ss.id) AS seasons_count
FROM series s
INNER JOIN seasons ss ON s.id = ss.serie_id
GROUP BY s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.id) AS movies_count
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING movies_count >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE "La guerra de las galaxias%";