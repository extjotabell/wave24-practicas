-- CONSULTAS

-- 1. Obtener el nombre y apellido de los clientes que tengan el plan 1
SELECT nombre, apellido
FROM clientes
WHERE id_plan = 1;

-- 2. Obtener los planes cuyo precio sea mayor a 1000
SELECT *
FROM planes
WHERE precio > 1000;

-- 3. Obtener los planes cuyas megas sean mayores o iguales a 400
SELECT *
FROM planes
WHERE megas >= 400;

-- 4. Obtener clientes ordenados por nombre
SELECT *
FROM clientes
ORDER BY nombre;

-- 5. Obtener clientes con nombre y apellido en una misma columna
SELECT CONCAT(nombre, ' ', apellido) AS nombre_completo
FROM clientes;

-- 6. Obtener los planes cuyo descuento sea mayor a 10
SELECT *
FROM planes
WHERE descuento > 10;

-- 7. Obtener el nombre, precio total y precio con descuento de los planes
SELECT nombre_plan, precio, ROUND(precio - (precio * descuento / 100), 2) AS precio_con_descuento
FROM planes;

-- 8. Obtener el nombre y precio del plan maás económico
SELECT nombre_plan, precio
FROM planes
ORDER BY precio
LIMIT 1;

-- 9. Obtener el nombre y precio del plan más caro
SELECT nombre_plan, precio
FROM planes
ORDER BY precio DESC
LIMIT 1;

-- 10. Obtener las distintas provincias de los clientes
SELECT DISTINCT provincia
FROM clientes;

-- 11. Obtener los clientes que hayan nacido después del 01/01/1990
SELECT *
FROM clientes
WHERE YEAR(fecha_nacimiento) > 1990;