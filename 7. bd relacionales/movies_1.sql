-- EJERCICIO movies_db.sql

-- 1
SELECT * FROM movies;
-- 2
SELECT first_name, last_name, rating
from actors;
-- 3
Select title as titulo
from series as series_de_television;
-- 4
SELECT first_name, last_name, rating
from actors where rating > 7.5;
-- 5
Select title, rating, awards
from movies where rating > 7.5 AND awards > 2;
-- 6
Select title, rating
from movies
order by rating;
-- 7
select *
from movies
limit 3;
-- 8
select title, rating
from movies
order by rating DESC
limit 5;
-- 9
select *
from actors
limit 10;
-- 10
select title, rating
from movies
where title LIKE 'TOY STORY%';
-- 11
select *
from actors
where first_name LIKE 'SAM%';
-- 12
select title, release_date
from movies
where release_date BETWEEN '2004-01-01' AND '2008-12-31';
-- 13
select title, rating, awards, release_date
from movies
where rating > 3 AND awards >1 AND release_date BETWEEN '1988-01-01' AND '2009-12-31'
order by rating;

