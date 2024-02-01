SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `biblioteca`;
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8;
USE `biblioteca`;
-- -----------------------------------------------------
-- Table `biblioteca`.`libro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`libro`;
CREATE TABLE IF NOT EXISTS `biblioteca`.`libro`
(
    `id_libro`  INT         NOT NULL,
    `titulo`    VARCHAR(45) NULL,
    `editorial` VARCHAR(45) NULL,
    `area`      VARCHAR(45) NULL,
    PRIMARY KEY (`id_libro`)
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `biblioteca`.`estudiante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`estudiante`;
CREATE TABLE IF NOT EXISTS `biblioteca`.`estudiante`
(
    `id_estudiante` INT         NOT NULL,
    `nombre`        VARCHAR(45) NULL,
    `apellido`      VARCHAR(45) NULL,
    `direccion`     VARCHAR(45) NULL,
    `carrera`       VARCHAR(45) NULL,
    `edad`          INT(2)      NULL,
    PRIMARY KEY (`id_estudiante`)
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `biblioteca`.`prestamo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`prestamo`;
CREATE TABLE IF NOT EXISTS `biblioteca`.`prestamo`
(
    `id_lector`        INT  NOT NULL,
    `id_libro`         INT  NOT NULL,
    `fecha_prestamo`   DATE NOT NULL,
    `fecha_devolucion` DATE NOT NULL,
    `devuelto`         BIT  NOT NULL,
    PRIMARY KEY (`id_libro`, `id_lector`),
    CONSTRAINT `prestamo_id_libro`
        FOREIGN KEY (`id_libro`)
            REFERENCES `biblioteca`.`libro` (`id_libro`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `prestamo_id_lector`
        FOREIGN KEY (`id_lector`)
            REFERENCES `biblioteca`.`estudiante` (`id_estudiante`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;
SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `biblioteca`.`autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`autor`;
CREATE TABLE IF NOT EXISTS `biblioteca`.`autor`
(
    `id_autor`     INT         NOT NULL,
    `nombre`       VARCHAR(45) NULL,
    `nacionalidad` VARCHAR(45) NULL,
    PRIMARY KEY (`id_autor`)
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `biblioteca`.`libro_autor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`libro_autor`;
CREATE TABLE IF NOT EXISTS `biblioteca`.`libro_autor`
(
    `id_libro` INT NOT NULL,
    `id_autor` INT NOT NULL,
    PRIMARY KEY (`id_libro`, `id_autor`),
    CONSTRAINT `libro_autor_id_libro`
        FOREIGN KEY (`id_libro`)
            REFERENCES `biblioteca`.`libro` (`id_libro`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `libro_autor_id_autor`
        FOREIGN KEY (`id_autor`)
            REFERENCES `biblioteca`.`autor` (`id_autor`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Insert data into `biblioteca`.`libro`
-- -----------------------------------------------------
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`)
VALUES (1, 'El principito', 'Santillana', 'Literatura');
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`)
VALUES (2, 'El alquimista', 'Santillana', 'Literatura');
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`)
VALUES (3, 'El arte de la guerra', 'Salamandra', 'Literatura');
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`)
VALUES (4, 'El código Da Vinci', 'Santillana', 'Literatura');
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`)
VALUES (5, 'El señor de los anillos', 'Santillana', 'Literatura');
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`)
VALUES (6, 'Harry Potter', 'Salamandra', 'Literatura');
INSERT INTO `biblioteca`.`libro` (`id_libro`, `titulo`, `editorial`, `area`)
VALUES (7, 'El Universo: Guía de Viaje', 'Santillana', 'Ciencia');

-- -----------------------------------------------------
-- Insert data into `biblioteca`.`estudiante`
-- -----------------------------------------------------
INSERT INTO `biblioteca`.`estudiante` (`id_estudiante`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`)
VALUES (1, 'Juan', 'Perez', 'Calle 1', 'Ing. Sistemas', 20);
INSERT INTO `biblioteca`.`estudiante` (`id_estudiante`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`)
VALUES (2, 'Maria', 'Lopez', 'Calle 2', 'Ing. Sistemas', 21);
INSERT INTO `biblioteca`.`estudiante` (`id_estudiante`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`)
VALUES (3, 'Pedro', 'Gomez', 'Calle 3', 'Ing. Sistemas', 22);
INSERT INTO `biblioteca`.`estudiante` (`id_estudiante`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`)
VALUES (4, 'Luis', 'Garcia', 'Calle 4', 'Ing. Sistemas', 23);
INSERT INTO `biblioteca`.`estudiante` (`id_estudiante`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`)
VALUES (5, 'Ana', 'Gomez', 'Calle 5', 'Informática', 24);
INSERT INTO `biblioteca`.`estudiante` (`id_estudiante`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`)
VALUES (6, 'Filippo', 'Galli', 'Calle 6', 'Informática', 25);

-- -----------------------------------------------------
-- Insert data into `biblioteca`.`prestamo`
-- -----------------------------------------------------
INSERT INTO `biblioteca`.`prestamo` (`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (1, 1, '2024-01-31', '2024-02-01', 0);
INSERT INTO `biblioteca`.`prestamo` (`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (2, 2, '2024-01-31', '2024-02-01', 0);
INSERT INTO `biblioteca`.`prestamo` (`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (3, 3, '2024-01-31', '2024-02-01', 0);
INSERT INTO `biblioteca`.`prestamo` (`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (4, 4, '2024-01-31', '2024-02-01', 0);
INSERT INTO `biblioteca`.`prestamo` (`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (5, 5, '2020-01-31', '2021-07-16', 0);
INSERT INTO `biblioteca`.`prestamo` (`id_lector`, `id_libro`, `fecha_prestamo`, `fecha_devolucion`, `devuelto`)
VALUES (6, 6, '2020-01-31', '2021-07-16', 0);


-- -----------------------------------------------------
-- Insert data into `biblioteca`.`autor`
-- -----------------------------------------------------
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`)
VALUES (1, 'Antoine de Saint-Exupéry', 'Francesa');
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`)
VALUES (2, 'Paulo Coelho', 'Brasileña');
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`)
VALUES (3, 'Sun Tzu', 'China');
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`)
VALUES (4, 'Dan Brown', 'Estadounidense');
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`)
VALUES (5, 'J.R.R. Tolkien', 'Sudafricana');
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`)
VALUES (6, 'J.K. Rowling', 'Británica');
INSERT INTO `biblioteca`.`autor` (`id_autor`, `nombre`, `nacionalidad`)
VALUES (7, 'Stephen Hawking', 'Británica');

-- -----------------------------------------------------
-- Insert data into `biblioteca`.`libro_autor`
-- -----------------------------------------------------
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`)
VALUES (1, 1);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`)
VALUES (2, 2);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`)
VALUES (3, 3);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`)
VALUES (4, 4);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`)
VALUES (5, 5);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`)
VALUES (6, 6);
INSERT INTO `biblioteca`.`libro_autor` (`id_libro`, `id_autor`)
VALUES (7, 7);


-- -----------------------------------------------------
-- Queries for the biblioteca
-- -----------------------------------------------------

-- Listar los datos de los autores.
SELECT *
FROM autor;

-- LISTAR NOMBRE Y EDAD DE LOS ESTUDIANTES
SELECT nombre, edad
FROM estudiante;

-- ¿QUÉ ESTUDIANTES PERTENECEN A LA CARRERA INFORMÁTICA?
SELECT nombre, apellido
FROM estudiante
WHERE carrera = 'Informática';

-- ¿QUÉ AUTORES SON DE NACIONALIDAD FRANCESA O ITALIANA?
SELECT *
FROM autor
WHERE nacionalidad = 'Francesa'
   OR nacionalidad = 'Italiana';

-- ¿QUÉ LIBROS NO SON DEL ÁREA DE INTERNET?
SELECT titulo
FROM libro
WHERE area <> 'internet';

-- LISTAR LOS LIBROS DE LA EDITORIAL SALAMANDRA.
SELECT titulo
FROM libro
WHERE editorial = 'Salamandra';

-- LISTAR LOS DATOS DE LOS ESTUDIANTES CUYA EDAD ES MAYOR AL PROMEDIO.
SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- LISTAR LOS NOMBRES DE LOS ESTUDIANTES CUYO APELLIDO COMIENCE CON LA LETRA G.
SELECT nombre
FROM estudiante
WHERE apellido LIKE 'G%';

-- LISTAR LOS AUTORES DEL LIBRO “EL UNIVERSO: GUÍA DE VIAJE”. (SE DEBE LISTAR SOLAMENTE LOS NOMBRES).
SELECT nombre
FROM autor
WHERE id_autor IN
      (SELECT id_autor
       FROM libro_autor
       WHERE id_libro =
             (SELECT id_libro FROM libro WHERE titulo = 'El Universo: Guía de Viaje'));

-- ¿QUÉ LIBROS SE PRESTARON AL LECTOR “FILIPPO GALLI”?
SELECT titulo
FROM libro
WHERE id_libro IN
      (SELECT id_libro
       FROM prestamo
       WHERE id_lector =
             (SELECT id_estudiante FROM estudiante WHERE nombre = 'Filippo' AND apellido = 'Galli'));

-- LISTAR EL NOMBRE DEL ESTUDIANTE DE MENOR EDAD.
SELECT nombre, apellido , edad
FROM estudiante
ORDER BY edad
LIMIT 1;

-- LISTAR NOMBRES DE LOS ESTUDIANTES A LOS QUE SE PRESTARON LIBROS DE BASE DE DATOS.
SELECT nombre
FROM estudiante
WHERE id_estudiante IN
      (SELECT id_lector
       FROM prestamo
       WHERE id_libro =
             (SELECT id_libro FROM libro WHERE area = 'BASE DE DATOS'));

-- LISTAR LOS LIBROS QUE PERTENECEN A LA AUTORA J.K. ROWLING.
SELECT titulo
FROM libro
WHERE id_libro IN
      (SELECT id_libro
       FROM libro_autor
       WHERE id_autor =
             (SELECT id_autor FROM autor WHERE nombre = 'J.K. ROWLING'));

-- LISTAR TÍTULOS DE LOS LIBROS QUE DEBÍAN DEVOLVERSE EL 16/07/2021.
SELECT l.titulo
FROM libro l
         JOIN prestamo p ON p.id_libro = l.id_libro
WHERE p.fecha_devolucion = '2021-07-16';