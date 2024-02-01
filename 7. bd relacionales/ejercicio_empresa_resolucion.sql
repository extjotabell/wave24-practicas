-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT DISTINCT d.nombre_depto, e.puesto, d.localidad
FROM empleado e INNER JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = "Vendedor";

-- Visualizar los departamentos con más de cinco empleados.

SELECT nombre_depto, COUNT(cod_emp) as cantidad_empleados 
FROM departamento d JOIN empleado e ON d.depto_nro = e.depto_nro
GROUP BY nombre_depto
HAVING cantidad_empleados > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que 
-- ‘Mito Barchuk’.

SELECT e.nombre, e.salario, d.nombre_depto 
FROM empleado e JOIN departamento d ON d.depto_nro = e.depto_nro
WHERE e.puesto IN (SELECT puesto from empleado WHERE nombre = "Mito" AND apellido = "Barchuk")
AND nombre != "Mito" AND apellido != "Barchuk";

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.

SELECT e.* 
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.apellido asc , e.nombre asc; 

-- Mostrar el nombre del empleado que tiene el salario más bajo.

SELECT nombre, apellido, salario
FROM EMPLEADO
WHERE salario = (SELECT MIN(salario) FROM EMPLEADO);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.

SELECT nombre, apellido, salario
FROM EMPLEADO e JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE salario = (SELECT MAX(salario) 
	FROM EMPLEADO e JOIN departamento d ON e.depto_nro = d.depto_nro 
	WHERE d.nombre_depto = "Ventas")
AND d.nombre_depto = "Ventas";
    
