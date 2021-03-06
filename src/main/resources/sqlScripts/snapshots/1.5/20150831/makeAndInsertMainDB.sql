SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `slaskdb` ;
CREATE SCHEMA IF NOT EXISTS `slaskdb` DEFAULT CHARACTER SET utf8 ;
USE `slaskdb` ;

-- -------------------------------------------------------
-- Table `slaskdb`.`user_roles`
-- -------------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`role`(
    `id` INT(11) NOT NULL,
    `role_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `slaskdb`.`clubs_dictionary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`clubs_dictionary`(
    `id` INT(11) NOT NULL,
    `club_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

-- -------------------------------------------------------
-- Table `slaskdb`.`users`
-- -------------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`user_data`(
	`id` INT(11) NOT NULL,
	`first_name` VARCHAR(30) NULL,
	`second_name` VARCHAR(40) NULL,
	`login` VARCHAR(50) NULL,
	`password` VARCHAR(20) NULL,
	`enabled` INT(1) NOT NULL DEFAULT 1,
        `role_idRole` INT(11) NULL,
	PRIMARY KEY (`id`),
            INDEX `fk_user_data_role_idx` (`role_idRole` ASC),
            CONSTRAINT `fk_user_data_role`
              FOREIGN KEY (`role_idRole`)
              REFERENCES `slaskdb`.`role` (`id`)
              ON DELETE NO ACTION
              ON UPDATE NO ACTION)
          ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`game` (
	`id` INT(11) NOT NULL,
	`game_code` INT(11) NOT NULL,
	`session_id` VARCHAR(45) NULL,
        `game_name` VARCHAR(45) NULL,
	`user_status` INT(1) NULL DEFAULT 0,
	`next_turn_wanted` INT(1) NULL DEFAULT 0,
	`clubs_dictionary_idClub` INT(11) NULL,
	`user_data_idUser` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_game_clubs_dictionary_idx` (`clubs_dictionary_idClub` ASC),
	INDEX `fk_game_user_data1_idx` (`user_data_idUser` ASC),
	CONSTRAINT `fk_game_clubs_dictionary`
	FOREIGN KEY (`clubs_dictionary_idClub`)
	REFERENCES `slaskdb`.`clubs_dictionary` (`id`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,
	CONSTRAINT `fk_game_user_data1`
	FOREIGN KEY (`user_data_idUser`)
	REFERENCES `slaskdb`.`user_data` (`id`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `slaskdb`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `slaskdb`;
INSERT INTO `slaskdb`.`role` (`id`, `role_name`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `slaskdb`.`role` (`id`, `role_name`) VALUES (2, 'ROLE_USER');
INSERT INTO `slaskdb`.`role` (`id`, `role_name`) VALUES (3, 'ROLE_CODER');

COMMIT;

-- -----------------------------------------------------
-- Data for table `slaskdb`.`clubs_dictionary`
-- -----------------------------------------------------
START TRANSACTION;
USE `slaskdb`;
INSERT INTO `slaskdb`.`clubs_dictionary` (`id`, `club_name`) VALUES (1, 'Śląsk Wrocław');
INSERT INTO `slaskdb`.`clubs_dictionary` (`id`, `club_name`) VALUES (2, 'Legia Warszawa');

COMMIT;

-- -----------------------------------------------------
-- Data for table `slaskdb`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `slaskdb`;
INSERT INTO `slaskdb`.`user_data` (`id`, `first_name`, `second_name`, `login`, `password`, `enabled`, `role_idRole`) VALUES (1, 'Mariusz', 'Czarny', 'mczarny', '123', 1, 1);
INSERT INTO `slaskdb`.`user_data` (`id`, `first_name`, `second_name`, `login`, `password`, `enabled`, `role_idRole`) VALUES (2, 'Jacek', 'Bednarczyk', 'jbednarczyk', '123', 1, 1);
INSERT INTO `slaskdb`.`user_data` (`id`, `first_name`, `second_name`, `login`, `password`, `enabled`, `role_idRole`) VALUES (3, 'Jan', 'Kowalski', 'jkowalski', '123', 0, 2);
COMMIT;

-- -----------------------------------------------------
-- Data for table `slaskdb`.`game`, user_status = 0 - user, user_status = 1 - owner
-- -----------------------------------------------------
START TRANSACTION;
USE `slaskdb`;
INSERT INTO `slaskdb`.`game` (`id`, `game_code`, `session_id`, `game_name`, `user_status`, `next_turn_wanted`, `clubs_dictionary_idClub`, `user_data_idUser`) VALUES (1, '1', '1', 'mariuszGra', 1, 0, 1, 1);
INSERT INTO `slaskdb`.`game` (`id`, `game_code`, `session_id`, `game_name`, `user_status`, `next_turn_wanted`, `clubs_dictionary_idClub`, `user_data_idUser`) VALUES (2, '1', '2', 'jacekGra', 0, 0, 2, 2);

COMMIT;