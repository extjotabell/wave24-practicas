-- Mostrar el título y el nombre del género de todas las series.
select title, genre_id from series;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select epi.title, act.first_name, act.last_name from actors as act 
inner join actor_episode as act_ep on act.id = act_ep.actor_id 
inner join episodes as epi on act_ep.episode_id = epi.id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select ser.title as title, max(sea.number) as tot_temp from series as ser
inner join seasons as sea on ser.id = sea.serie_id group by title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select gen.name as name_gen, count(mov.genre_id) as cant_mov from movies as mov 
join genres as gen on gen.id = mov.genre_id group by name_gen having cant_mov >=3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select distinct act.first_name, act.last_name from actors as act 
join actor_movie as act_mov on act.id = act_mov.actor_id  
join movies as mov on mov.id = act_mov.movie_id where mov.title like "%La Guerra de las galaxias%";

