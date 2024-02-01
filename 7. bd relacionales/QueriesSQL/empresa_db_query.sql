-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad 
FROM empleados e 
INNER JOIN departamentos d ON d.depto_nro = e.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, d.localidad , COUNT(d.depto_nro) as cant_depto
FROM empleados e 
INNER JOIN departamentos d ON d.depto_nro = e.depto_nro
GROUP BY d.nombre_depto, d.localidad
HAVING cant_depto > 5;

-- Mostrar el nombre, salario y nombre del departamentos de los
-- empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleados e 
INNER JOIN departamentos d ON d.depto_nro = e.depto_nro
WHERE e.puesto LIKE '%Presidente%';

-- Mostrar los datos de los empleados que trabajan 
-- en el departamentos de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleados e 
INNER JOIN departamentos d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleados
ORDER BY salario
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamentos de ‘Ventas’.
SELECT e.*
FROM empleados e
INNER JOIN departamentos d ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto = "Ventas"
ORDER BY e.salario DESC
LIMIT 1;
