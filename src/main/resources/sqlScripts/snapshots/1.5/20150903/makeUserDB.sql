SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `slaskdb` ;
CREATE SCHEMA IF NOT EXISTS `slaskdb` DEFAULT CHARACTER SET utf8 ;
USE `slaskdb` ;

-- -----------------------------------------------------
-- Table `slaskdb`.`finance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`finance` (
  `id` INT(11) NOT NULL,
  `Budget` INT(11) NULL,
  `TransferBudget` INT(11) NULL,
  `WageBudget` INT(11) NULL,
  `StadiumCost` INT(11) NULL,
  `AvgTicketCost` INT(11) NULL,
  `AvgSeasonTicketCost` INT(11) NULL,
  `SeasonTicketsNumber` INT(11) NULL,
  `Dept` INT(11) NULL,
  `FromSponsors` INT(11) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`tactic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`tactic` (
  `id` INT(11) NOT NULL,
  `Attack` INT(11) NULL,
  `Marking` INT(11) NULL,
  `Offside` INT(11) NULL,
  `Pressing` INT(11) NULL,
  `Tempo` INT(11) NULL,
  `PlayWide` INT(11) NULL,
  `PlayHigh` INT(11) NULL,
  `Flair` INT(11) NULL,
  `LongPass` INT(11) NULL,
  `PlayToDefenders` INT(11) NULL,
  `TacticName` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`formation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`formation` (
  `id` INT(11) NOT NULL,
  `FormationName` VARCHAR(45) NULL,
  `DefendersNumber` INT(1) NULL,
  `MidfieldNumber` INT(1) NULL,
  `ForwardNumber` INT(1) NULL,
  `tactic_idTactic` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_formation_tactic1_idx` (`tactic_idTactic` ASC),
  CONSTRAINT `fk_formacje_taktyki1`
    FOREIGN KEY (`tactic_idTactic`)
    REFERENCES `slaskdb`.`tactic` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`person` (
  `id` INT(11) NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Surname` VARCHAR(45) NULL,
  `BirthDate` DATETIME NULL,
  `Nation` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`coach`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`coach` (
  `id` INT(11) NOT NULL,
  `TacticalKnowledge` INT(11) NULL,
  `TreningMental` INT(11) NULL,
  `TreningTactic` INT(11) NULL,
  `TreningTechnique` INT(11) NULL,
  `Motivating` INT(11) NULL,
  `Management` INT(11) NULL,
  `Discipline` INT(11) NULL,
  `SkillRate` INT(11) NULL,
  `person_idPerson` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_trenerzy_osoby1_idx` (`person_idPerson` ASC),
  CONSTRAINT `fk_trenerzy_osoby1`
    FOREIGN KEY (`person_idPerson`)
    REFERENCES `slaskdb`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`tournament`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`tournament` (
  `id` INT(11) NOT NULL,
  `TournamentName` VARCHAR(45) NULL,
  `TournamentReputation` INT(11) NULL,
  `TeamsNumber` INT(11) NULL,
  `RelegatesNumber` INT(11) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`city` (
  `id` INT(11) NOT NULL,
  `CityName` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`stadium` (
  `id` INT(11) NOT NULL,
  `StadiumName` VARCHAR(45) NULL,
  `SitsNumber` INT(11) NULL,
  `YearBuild` INT(4) NULL,
  `Modernity` INT(11) NULL,
  `FieldWidth` INT(11) NULL,
  `FieldHeight` INT(11) NULL,
  `city_idCity` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_stadium_city1_idx` (`city_idCity` ASC),
  CONSTRAINT `fk_stadiony_miasta1`
    FOREIGN KEY (`city_idCity`)
    REFERENCES `slaskdb`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`training`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`training` (
  `id` INT(11) NOT NULL,
  `TrainingName` VARCHAR(45) NULL,
  `Pace` INT(1) NULL,
  `Strength` INT(1) NULL,
  `Stamina` INT(1) NULL,
  `SetPieces` INT(1) NULL,
  `Technique` INT(1) NULL,
  `Finishing` INT(1) NULL,
  `Passing` INT(1) NULL,
  `Marking` INT(1) NULL,
  `Tackling` INT(1) NULL,
  `Heading` INT(1) NULL,
  `Reflex` INT(1) NULL,
  `Handling` INT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`club`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`club` (
  `id` INT(11) NOT NULL,
  `AttendanceAvg` INT(11) NULL,
  `AttendanceMin` INT(11) NULL,
  `AttendanceMax` INT(11) NULL,
  `TrainingAssets` INT(11) NULL,
  `Youth` INT(11) NULL,
  `ClubName` VARCHAR(45) NULL,
  `ClubNick` VARCHAR(45) NULL,
  `YearFound` INT(4) NULL,
  `Morale` INT(11) NULL,
  `ClubReputation` INT(11) NULL,
  `Colours` VARCHAR(45) NULL,
  `PointsScored` INT(11) NULL,
  `GoalsScored` INT(11) NULL,
  `GoalsLost` INT(11) NULL,
  `YellowCards` INT(11) NULL,
  `RedCards` INT(11) NULL,
  `coach_idCoach` INT(11) NULL,
  `finance_idFinance` INT(11) NULL,
  `tournament_idTournament` INT(11) NULL,
  `stadium_idStadium` INT(11) NULL,
  `training_idTraining` INT(11) NULL,
  `formation_idFormation` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_club_coach1_idx` (`coach_idCoach` ASC),
  INDEX `fk_club_finance1_idx` (`finance_idFinance` ASC),
  INDEX `fk_club_tournament1_idx` (`tournament_idTournament` ASC),
  INDEX `fk_club_stadium1_idx` (`stadium_idStadium` ASC),
  INDEX `fk_club_training1_idx` (`training_idTraining` ASC),
  INDEX `fk_club_formation1_idx` (`formation_idFormation` ASC),
  CONSTRAINT `fk_kluby_trenerzy1`
    FOREIGN KEY (`coach_idCoach`)
    REFERENCES `slaskdb`.`coach` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kluby_finanse1`
    FOREIGN KEY (`finance_idFinance`)
    REFERENCES `slaskdb`.`finance` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kluby_rozgrywki1`
    FOREIGN KEY (`tournament_idTournament`)
    REFERENCES `slaskdb`.`tournament` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kluby_stadiony1`
    FOREIGN KEY (`stadium_idStadium`)
    REFERENCES `slaskdb`.`stadium` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kluby_trening1`
    FOREIGN KEY (`training_idTraining`)
    REFERENCES `slaskdb`.`training` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kluby_formacje1`
    FOREIGN KEY (`formation_idFormation`)
    REFERENCES `slaskdb`.`formation` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`position` (
  `id` INT(11) NOT NULL,
  `Goalkeeper` INT(11) NULL,
  `DefenderLeft` INT(11) NULL,
  `DefenderCenter` INT(11) NULL,
  `DefenderRight` INT(11) NULL,
  `MidfieldDef` INT(11) NULL,
  `MidfieldRight` INT(11) NULL,
  `MidfieldLeft` INT(11) NULL,
  `MidfieldCenter` INT(11) NULL,
  `WingerLeft` INT(11) NULL,
  `WingerRight` INT(11) NULL,
  `Forward` INT(11) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`player` (
  `id` INT(11) NOT NULL,
  `CurrentForm` INT(11) NULL,
  `Reputation` INT(11) NULL,
  `Potential` INT(11) NULL,
  `LegLeft` INT(11) NULL,
  `LegRight` INT(11) NULL,
  `Determination` INT(11) NULL,
  `Dirtness` INT(11) NULL,
  `Influence` INT(11) NULL,
  `Injury` INT(11) NULL,
  `Pace` INT(11) NULL,
  `Strength` INT(11) NULL,
  `Stamina` INT(11) NULL,
  `SetPieces` INT(11) NULL,
  `Technique` INT(11) NULL,
  `Finishing` INT(11) NULL,
  `Passing` INT(11) NULL,
  `Marking` INT(11) NULL,
  `Tackling` INT(11) NULL,
  `Heading` INT(11) NULL,
  `Reflex` INT(11) NULL,
  `Handling` INT(11) NULL,
  `Weight` INT(11) NULL,
  `Height` INT(11) NULL,
  `BestPosition` VARCHAR(45) NULL,
  `BestPositionShort` VARCHAR(45) NULL,
  `person_idPerson` INT(11) NULL,
  `position_idPosition` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_player_person1_idx` (`person_idPerson` ASC),
  INDEX `fk_player_position1_idx` (`position_idPosition` ASC),
  CONSTRAINT `fk_pilkarze_osoby1`
    FOREIGN KEY (`person_idPerson`)
    REFERENCES `slaskdb`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pilkarze_pozycje1`
    FOREIGN KEY (`position_idPosition`)
    REFERENCES `slaskdb`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`contract`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`contract` (
  `id` INT(11) NOT NULL,
  `Fee` DECIMAL(10,2) NULL,
  `Wage` DECIMAL(10,2) NULL,
  `DateStart` DATETIME NULL,
  `DateEnd` DATETIME NULL,
  `club_idClub` INT(11) NULL,
  `player_idPlayer` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Contract_player_idx` (`player_idPlayer` ASC),
  INDEX `fk_Contract_club1_idx` (`club_idClub` ASC),
  CONSTRAINT `fk_Kontrakt_pilkarze`
    FOREIGN KEY (`player_idPlayer`)
    REFERENCES `slaskdb`.`player` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Kontrakt_kluby1`
    FOREIGN KEY (`club_idClub`)
    REFERENCES `slaskdb`.`club` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`referee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`referee` (
  `id` INT(11) NOT NULL,
  `Refereeing` INT(11) NULL,
  `Punishing` INT(11) NULL,
  `person_idPerson` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_coach_person1_idx` (`person_idPerson` ASC),
  CONSTRAINT `fk_sedziowie_osoby1`
    FOREIGN KEY (`person_idPerson`)
    REFERENCES `slaskdb`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`fixture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`fixture` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `SeasonYear` INT(4) NULL,
  `tournament_idTournament` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Fixture_tournament1_idx` (`tournament_idTournament` ASC),
  CONSTRAINT `fk_Terminarz_rozgrywki1`
    FOREIGN KEY (`tournament_idTournament`)
    REFERENCES `slaskdb`.`tournament` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`arrange`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`arrange` (
  `id` INT(11) NOT NULL,
  `ArrangeDate` DATETIME NULL,
  `referee_idReferee` INT(11) NULL,
  `fixture_idFixture` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Arrange_coach1_idx` (`referee_idReferee` ASC),
  INDEX `fk_arrange_fixture1_idx` (`fixture_idFixture` ASC),
  CONSTRAINT `fk_Mecz_sedziowie1`
    FOREIGN KEY (`referee_idReferee`)
    REFERENCES `slaskdb`.`referee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mecz_terminarz1`
    FOREIGN KEY (`fixture_idFixture`)
    REFERENCES `slaskdb`.`fixture` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`staff` (
  `id` INT(11) NOT NULL,
  `StaffFunction` VARCHAR(45) NULL,
  `person_idPerson` INT(11) NULL,
  `club_idClub` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_staff_person1_idx` (`person_idPerson` ASC),
  INDEX `fk_staff_club1_idx` (`club_idClub` ASC),
  CONSTRAINT `fk_personel_osoby1`
    FOREIGN KEY (`person_idPerson`)
    REFERENCES `slaskdb`.`person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_personel_kluby1`
    FOREIGN KEY (`club_idClub`)
    REFERENCES `slaskdb`.`club` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `slaskdb`.`club_has_arrange`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `slaskdb`.`club_has_arrange` (
  `club_idClub` INT(11) NOT NULL,
  `ArrangeDate` DATETIME NULL,
  `Describtion` VARCHAR(45) NULL,    
  `arrange_idArrange` INT(11) NULL,
  PRIMARY KEY (`club_idClub`, `arrange_idArrange`),
  INDEX `fk_club_has_arrange_arrange1_idx` (`arrange_idArrange` ASC),
  INDEX `fk_club_has_arrange_club1_idx` (`club_idClub` ASC),
  CONSTRAINT `fk_club_has_arrange_club1`
    FOREIGN KEY (`club_idClub`)
    REFERENCES `slaskdb`.`club` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_club_has_arrange_arrange1`
    FOREIGN KEY (`arrange_idArrange`)
    REFERENCES `slaskdb`.`arrange` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;