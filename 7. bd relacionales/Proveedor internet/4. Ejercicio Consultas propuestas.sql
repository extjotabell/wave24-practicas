-- Consulta 1: Obtener todos los clientes
SELECT * FROM Clientes;

-- Consulta 2: Obtener todos los planes de Internet
SELECT * FROM Planes;

-- Consulta 3: Obtener la información de los clientes que tienen planes de Internet
SELECT C.*, CP.*,P.*
FROM Clientes C
JOIN ClientesPlanes CP ON C.id_cliente = CP.id_clienteFK
JOIN Planes P ON CP.id_planFK = P.id_plan;

-- Consulta 4: Obtener los planes de Internet que tiene un cliente específico 
SELECT C.id_cliente, C.nombre ,P.*
FROM Clientes C
JOIN ClientesPlanes CP ON C.id_cliente = CP.id_clienteFK
JOIN Planes P ON CP.id_planFK = P.id_plan
WHERE C.nombre = 'James';

-- Consulta 5: Obtener la cantidad de planes de Internet que tiene cada cliente
SELECT C.nombre, COUNT(CP.id_planFK) AS cantidad_planes
FROM Clientes C
LEFT JOIN ClientesPlanes CP ON C.id_cliente = CP.id_clienteFK
GROUP BY C.id_cliente;

-- Consulta 6: Obtener el plan de Internet con la mayor velocidad
SELECT *
FROM Planes
ORDER BY velocidad DESC
LIMIT 1;

-- Consulta 7: Obtener los clientes que tienen un plan con descuento
SELECT C.*
FROM Clientes C
JOIN ClientesPlanes CP ON C.id_cliente = CP.id_clienteFK
JOIN Planes P ON CP.id_planFK = P.id_plan
WHERE P.descuento > 0;

-- Consulta 8: Calcular el total de ingresos por mes si todos los clientes pagaran el precio completo de sus planes
SELECT MONTH(CURDATE()) AS mes, SUM(P.precio) AS ingresos_totales
FROM ClientesPlanes CP
JOIN Planes P ON CP.id_planFK = P.id_plan;

-- Consulta 9: Obtener los clientes que no tienen planes de Internet
SELECT C.*
FROM Clientes C
LEFT JOIN ClientesPlanes CP ON C.id_cliente = CP.id_clienteFK
WHERE CP.id_clienteFK IS NULL;

-- Consulta 10: Actualizar el descuento de un plan específico
UPDATE Planes
SET descuento = 0.20
WHERE id_plan = 1;
