-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema library_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library_db` DEFAULT CHARACTER SET utf8 ;
USE `library_db` ;

-- -----------------------------------------------------
-- Table `library_db`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`libro` (
  `idLibro` INT UNSIGNED NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `editorial` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLibro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`estudiante` (
  `idLector` INT UNSIGNED NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  `edad` TINYINT(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`idLector`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`prestamo` (
  `idLector` INT UNSIGNED NOT NULL,
  `idLibro` INT UNSIGNED NOT NULL,
  `fechaPrestamo` DATE NOT NULL,
  `fechaDevolucion` DATE NULL,
  `devuelto` BIT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`idLector`, `idLibro`),
  INDEX `fk_prestamo_libro_idx` (`idLibro` ASC) VISIBLE,
  INDEX `fk_prestamo_estudiante1_idx` (`idLector` ASC) VISIBLE,
  CONSTRAINT `fk_prestamo_libro`
    FOREIGN KEY (`idLibro`)
    REFERENCES `library_db`.`libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prestamo_estudiante1`
    FOREIGN KEY (`idLector`)
    REFERENCES `library_db`.`estudiante` (`idLector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`autor` (
  `idAutor` INT UNSIGNED NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `nacionalidad` VARCHAR(45) NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_db`.`libroautor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_db`.`libroautor` (
  `autor_idAutor` INT UNSIGNED NOT NULL,
  `libro_idLibro` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`autor_idAutor`, `libro_idLibro`),
  INDEX `fk_autor_has_libro_libro1_idx` (`libro_idLibro` ASC) VISIBLE,
  INDEX `fk_autor_has_libro_autor1_idx` (`autor_idAutor` ASC) VISIBLE,
  CONSTRAINT `fk_autor_has_libro_autor1`
    FOREIGN KEY (`autor_idAutor`)
    REFERENCES `library_db`.`autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autor_has_libro_libro1`
    FOREIGN KEY (`libro_idLibro`)
    REFERENCES `library_db`.`libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
