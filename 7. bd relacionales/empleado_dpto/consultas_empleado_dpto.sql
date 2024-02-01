-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM Empleado e
INNER JOIN Departamento d ON d.dpto_nro  = e.dpto_nro
WHERE e.puesto = "vendedor";

-- Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_dpto, d.localidad, COUNT(d.dpto_nro) as cant_empleados
FROM Empleado e 
INNER JOIN Departamento d ON d.dpto_nro = e.dpto_nro
GROUP BY d.nombre_dpto, d.localidad 
HAVING cant_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_dpto
FROM Empleado e 
INNER JOIN Departamento d on d.dpto_nro = e.dpto_nro 
WHERE e.puesto LIKE "presidente";

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* 
FROM Empleado e 
INNER JOIN Departamento d ON d.dpto_nro = e.dpto_nro 
WHERE d.nombre_dpto = "Contabilidad"
ORDER BY e.nombre DESC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario
FROM Empleado
ORDER BY salario ASC
LIMIT 1; 

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM Empleado e 
INNER JOIN Departamento d ON e.dpto_nro = d.dpto_nro 
WHERE d.nombre_dpto = "Ventas"
ORDER BY e.salario ASC 
LIMIT 1;