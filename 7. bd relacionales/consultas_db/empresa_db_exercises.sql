DROP DATABASE empresa_db;
CREATE DATABASE empresa_db;

USE empresa_db;

CREATE TABLE DEPARTAMENTO(
	depto_nro VARCHAR(7) PRIMARY KEY,
    nombre_depto VARCHAR(20),
    localidad VARCHAR(20)
);

CREATE TABLE EMPLEADO(
	cod_emp VARCHAR(6) PRIMARY KEY,
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    puesto VARCHAR(20),
    fecha_alta DATE,
    salario FLOAT,
    comision FLOAT,
    depto_nro VARCHAR(7),
    CONSTRAINT `depto_nro`
    FOREIGN KEY (`depto_nro`)
    REFERENCES `empresa_db`.`DEPARTAMENTO` (`depto_nro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO DEPARTAMENTO VALUES ('D-000-1', 'Software', 'Los Tigres');
INSERT INTO DEPARTAMENTO VALUES ('D-000-2', 'Sistemas', 'Guadalupe');
INSERT INTO DEPARTAMENTO VALUES ('D-000-3', 'Contabilidad', 'La Roca');
INSERT INTO DEPARTAMENTO VALUES ('D-000-4', 'Ventas', 'Plata');


INSERT INTO EMPLEADO VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4');
INSERT INTO EMPLEADO VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2');
INSERT INTO EMPLEADO VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');
INSERT INTO EMPLEADO VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');
INSERT INTO EMPLEADO VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');
INSERT INTO EMPLEADO VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');
INSERT INTO EMPLEADO VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');


-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT em.nombre, em.puesto, dep.localidad
FROM EMPLEADO em INNER JOIN DEPARTAMENTO dep ON em.depto_nro = dep.depto_nro;

-- Visualizar los departamentos con más de dos empleados.
SELECT dep.nombre_depto, COUNT(em.depto_nro) AS total
FROM EMPLEADO em 
INNER JOIN DEPARTAMENTO dep ON dep.depto_nro = em.depto_nro
GROUP BY dep.nombre_depto, em.depto_nro
HAVING total >= 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘César Piñero’.
SELECT em.nombre, em.salario, dep.nombre_depto
FROM EMPLEADO em INNER JOIN DEPARTAMENTO dep ON dep.depto_nro = em.depto_nro
WHERE em.puesto = (SELECT puesto FROM EMPLEADO WHERE nombre = 'César' AND apellido = 'Piñero');

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * 
FROM EMPLEADO 
INNER JOIN DEPARTAMENTO ON DEPARTAMENTO.depto_nro = EMPLEADO.depto_nro
WHERE DEPARTAMENTO.depto_nro = 'D-000-3'
ORDER BY EMPLEADO.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT em.nombre
FROM EMPLEADO em
WHERE em.salario = (SELECT MIN(salario) FROM EMPLEADO);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT *
FROM EMPLEADO em 
WHERE em.salario = (SELECT MAX(em.salario) FROM EMPLEADO em INNER JOIN DEPARTAMENTO dep ON em.depto_nro = dep.depto_nro WHERE dep.nombre_depto = 'Ventas');