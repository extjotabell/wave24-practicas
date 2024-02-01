-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad from empleado e join departamento d on d.depto_nro = e.depto_nro where e.puesto = 'Vendedor';
-- 2. Visualizar los departamentos con más de cinco empleados.
select d.depto_nro, d.nombre, count(e.depto_nro)
from departamento d join empleado e on d.depto_nro = e.depto_nro
group by d.depto_nro, d.nombre
having count(e.depto_nro) > 5;
-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre
from empleado e join departamento d on d.depto_nro = e.depto_nro
where e.puesto = (select e.puesto from empleado e where e.nombre = 'Mito Barchuk');

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select * from empleado e
join departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Contabilidad' order by e.nombre;
-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
select e.nombre from empleado e order by e.salario limit 1;
-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select * from empleado e
join departamento d on d.depto_nro = e.depto_nro
where d.nombre_depto = 'Ventas' order by e.salario desc limit 1;