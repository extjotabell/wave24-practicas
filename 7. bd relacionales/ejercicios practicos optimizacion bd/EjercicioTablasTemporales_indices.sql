-- ejercicio 1
create temporary table TWD (episode VARCHAR(40), serie VARCHAR(40), season VARCHAR (40));

insert into TWD
SELECT epi.title as episode, ser.title as serie, sea.title as season from episodes as epi
join seasons as sea on epi.season_id = sea.id
join series as ser on sea.serie_id = ser.id
where ser.title = "The Walking Dead";

select * from TWD;

-- ejercicio 2
-- en la tabla movies, se le hace un alter table y se le agrega en indexes un indice asociado al campo de length
explain select * from movies where length=120;