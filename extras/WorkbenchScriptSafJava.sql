-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema safJava
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema safJava
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `safJava` DEFAULT CHARACTER SET utf8 ;
USE `safJava` ;

-- -----------------------------------------------------
-- Table `safJava`.`Family`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `safJava`.`Family` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Contact` VARCHAR(50) NOT NULL,
  `Address` VARCHAR(50) NULL,
  `Relation` VARCHAR(50) NULL,
  `Photo` VARCHAR(50) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `safJava`.`Deceased`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `safJava`.`Deceased` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Age` INT NOT NULL,
  `Sex` CHAR(1) NOT NULL,
  `Comment` VARCHAR(50) NULL,
  `Photo` VARCHAR(50) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `safJava`.`Service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `safJava`.`Service` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `FamilyId` INT NOT NULL,
  `DeceasedId` INT NOT NULL,
  `Comment` VARCHAR(50) NOT NULL,
  `Date` DATE NULL,
  `Price` DECIMAL(18,0) NOT NULL,
  `CheckPay` TINYINT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Service_Family_idx` (`FamilyId` ASC) VISIBLE,
  INDEX `fk_Service_Deceased1_idx` (`DeceasedId` ASC) VISIBLE,
  CONSTRAINT `fk_Service_Family`
    FOREIGN KEY (`FamilyId`)
    REFERENCES `safJava`.`Family` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Service_Deceased1`
    FOREIGN KEY (`DeceasedId`)
    REFERENCES `safJava`.`Deceased` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
