-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema internet_plans_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema internet_plans_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `internet_plans_db` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema internet_plans
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema internet_plans
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `internet_plans` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `internet_plans_db` ;

-- -----------------------------------------------------
-- Table `internet_plans_db`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_plans_db`.`Cliente` (
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_plans_db`.`Coche`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_plans_db`.`Coche` (
  `id_coche` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(45) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `no_serie` VARCHAR(45) NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `anio` SMALLINT(4) UNSIGNED NOT NULL,
  `Cliente_id_cliente` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_coche`, `Cliente_id_cliente`),
  INDEX `fk_Coche_Cliente_idx` (`Cliente_id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_Coche_Cliente`
    FOREIGN KEY (`Cliente_id_cliente`)
    REFERENCES `internet_plans_db`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_plans_db`.`Servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_plans_db`.`Servicio` (
  `id_servicio` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `costo` DOUBLE NOT NULL,
  PRIMARY KEY (`id_servicio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_plans_db`.`Coche_has_Servicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_plans_db`.`Coche_has_Servicio` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `costo` DOUBLE NOT NULL,
  `Coche_id_coche` INT UNSIGNED NOT NULL,
  `Coche_Cliente_id_cliente` INT UNSIGNED NOT NULL,
  `Servicio_id_servicio` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `Coche_id_coche`, `Coche_Cliente_id_cliente`, `Servicio_id_servicio`),
  INDEX `fk_Coche_has_Servicio_Coche1_idx` (`Coche_id_coche` ASC, `Coche_Cliente_id_cliente` ASC) VISIBLE,
  INDEX `fk_Coche_has_Servicio_Servicio1_idx` (`Servicio_id_servicio` ASC) VISIBLE,
  CONSTRAINT `fk_Coche_has_Servicio_Coche1`
    FOREIGN KEY (`Coche_id_coche` , `Coche_Cliente_id_cliente`)
    REFERENCES `internet_plans_db`.`Coche` (`id_coche` , `Cliente_id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Coche_has_Servicio_Servicio1`
    FOREIGN KEY (`Servicio_id_servicio`)
    REFERENCES `internet_plans_db`.`Servicio` (`id_servicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_plans_db`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_plans_db`.`Cliente` (
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_plans_db`.`Plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_plans_db`.`Plan` (
)
ENGINE = InnoDB;

USE `internet_plans` ;

-- -----------------------------------------------------
-- Table `internet_plans`.`planes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_plans`.`planes` (
  `idplanes` INT NOT NULL,
  `velocidad` INT NULL DEFAULT NULL,
  `precio` DECIMAL(10,2) NULL DEFAULT NULL,
  `descuento` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idplanes`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `internet_plans`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_plans`.`clientes` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `apellido` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `provincia` VARCHAR(45) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NULL DEFAULT NULL,
  `planes_idplanes` INT NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_clientes_planes_idx` (`planes_idplanes` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_planes`
    FOREIGN KEY (`planes_idplanes`)
    REFERENCES `internet_plans`.`planes` (`idplanes`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
