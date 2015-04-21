SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

USE `slaskdb` ;

-- -------------------------------------------------------
-- Table `slaskdb`.`users`
-- -------------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`user`(
`idUser` INT(11) NOT NULL,
`name` VARCHAR(30) NULL,
`sname` VARCHAR(40) NULL,
`login` VARCHAR(50) NULL,
`password` VARCHAR(20) NULL,
`enabled` INT(1) NOT NULL DEFAULT 1,
`club_idClub` INT(11) NOT NULL,
  PRIMARY KEY (`idUser`),
  INDEX `fk_user_club1_idx` (`club_idClub` ASC),
  CONSTRAINT `fk_user_club1`
    FOREIGN KEY (`club_idClub`)
    REFERENCES `slaskdb`.`club` (`idClub`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -------------------------------------------------------
-- Table `slaskdb`.`user_roles`
-- -------------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`role`(
`idRole` INT(11) NOT NULL,
`user_idUser` INT(11) NULL,
`rolename` VARCHAR(45) NOT NULL,
PRIMARY KEY (`idRole`),
  INDEX `fk_role_user_idx` (`user_idUser` ASC),
  CONSTRAINT `fk_role_user`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `slaskdb`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
COMMIT;