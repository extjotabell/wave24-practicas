-- Mostrar el título y el nombre del género de todas las series.
select title, genres.name from series join genres on series.genre_id=genres.id

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title,actors.first_name,actors.last_name from episodes e join actor_episode a join actors on e.id=a.episode_id and a.id=actors.id order by e.title

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, temp.total_seasons from series s join (select serie_id, count(serie_id) as total_seasons from seasons group by serie_id) as temp on s.id=temp.serie_id

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
-- select title, genres.name from movies join genres on movies.genre_id=genres.id
select genres.name, count(movies.id) as total_movies from movies join genres on movies.genre_id=genres.id group by genres.id having count(movies.id) >=3

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct a.first_name, a.last_name from actors a join actor_movie am join movies m on a.id=am.actor_id and am.movie_id=m.id where m.title like "La Guerra de las galaxias%"