-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT
	e.nombre,
    e.puesto,
    d.localidad
FROM empleado e
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE e.puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT COUNT(*) AS cantidad_empleados, d.nombre_depto 
FROM empleado e
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
GROUP BY d.nombre_depto 
HAVING cantidad_empleados > 5;


-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT
	e.nombre,
    e.salario,
    d.nombre_depto
FROM empleado e
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (SELECT puesto FROM EMPLEADO WHERE nombre = 'Mito' AND apellido = "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*, d.*
FROM empleado e
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT
	nombre
FROM empleado
WHERE salario IN (SELECT MIN(salario) FROM empleado);

SELECT
	nombre
FROM empleado
ORDER BY salario
LIMIT 1;


-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT 
	*
FROM empleado 
WHERE salario IN (
					SELECT MAX(e.salario) FROM empleado e
					INNER JOIN departamento d
					ON e.depto_nro = d.depto_nro
					WHERE d.nombre_depto = "Ventas"
				);
                
SELECT 	e.*
FROM empleado e
INNER JOIN departamento d
ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Ventas"
ORDER BY salario DESC
LIMIT 1;