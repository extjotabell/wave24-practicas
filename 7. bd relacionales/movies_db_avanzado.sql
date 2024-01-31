-- 1. Mostrar el título y el nombre del género de todas las series.
select title, name from series s inner join movies_db.genres g on s.genre_id = g.id;
-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title, a.first_name, a.last_name from episodes e
join actor_episode ae on e.id = ae.episode_id
join actors a on ae.actor_id = a.id;

-- 3.Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title, count(se.serie_id) from series s
join seasons se on s.id = se.serie_id
group by s.title
-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name, count(m.genre_id) from genres g
join movies m on g.id = m.genre_id
group by g.name
having count(m.genre_id) >= 3;
-- 5.Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct a.first_name, a.last_name from actors a
join actor_movie am on a.id = am.actor_id
join movies m on am.movie_id = m.id
where m.title like 'La guerra de las galaxias%';
