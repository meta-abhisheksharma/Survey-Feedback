SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `survey_system` ;
CREATE SCHEMA IF NOT EXISTS `survey_system` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `survey_system` ;

-- -----------------------------------------------------
-- Table `survey_system`.`users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`users` (
  `userID` VARCHAR(30) NOT NULL ,
  `email` VARCHAR(90) NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `userRole` VARCHAR(15) NULL DEFAULT 'viewer' ,
  `name` VARCHAR(45) NOT NULL ,
  `blockUser` VARCHAR(1) NULL DEFAULT 'N' ,
  `createdTime` DATETIME NULL ,
  `updatedTime` DATETIME NULL ,
  PRIMARY KEY (`userID`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`surveys`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`surveys` (
  `surveyID` VARCHAR(30) NOT NULL ,
  `surveyName` VARCHAR(40) NOT NULL ,
  `surveyType` VARCHAR(10) NULL DEFAULT 'public' ,
  `label` VARCHAR(45) NULL ,
  `status` VARCHAR(1) NULL DEFAULT 'N' ,
  `updatedBy` VARCHAR(50) NULL ,
  `createdTime` DATETIME NOT NULL ,
  `updatedTime` DATETIME NULL ,
  PRIMARY KEY (`surveyID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`questions`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`questions` (
  `questionID` VARCHAR(30) NOT NULL ,
  `questionText` VARCHAR(200) NOT NULL ,
  `questionType` VARCHAR(1) NULL DEFAULT 'S' ,
  `createdBy` VARCHAR(30) NOT NULL ,
  `updatedBy` VARCHAR(30) NULL ,
  `createdTime` DATETIME NOT NULL ,
  `updatedTime` DATETIME NULL ,
  PRIMARY KEY (`questionID`) ,
  INDEX `questions_createdBy` (`createdBy` ASC) ,
  INDEX `questions_updatedBy` (`updatedBy` ASC) ,
  CONSTRAINT `questions_createdBy`
    FOREIGN KEY (`createdBy` )
    REFERENCES `survey_system`.`users` (`userID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `questions_updatedBy`
    FOREIGN KEY (`updatedBy` )
    REFERENCES `survey_system`.`users` (`userID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'It Store the question text';


-- -----------------------------------------------------
-- Table `survey_system`.`options`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`options` (
  `optionID` VARCHAR(30) NOT NULL ,
  `optionText` VARCHAR(100) NOT NULL ,
  `nextQuestionID` VARCHAR(30) NULL ,
  `createdBy` VARCHAR(30) NOT NULL ,
  `updatedBy` VARCHAR(30) NULL ,
  `createdTime` DATETIME NOT NULL ,
  `updatedTime` DATETIME NULL ,
  PRIMARY KEY (`optionID`) ,
  INDEX `options_nextQuestionID` (`nextQuestionID` ASC) ,
  INDEX `options_createdBy` (`createdBy` ASC) ,
  INDEX `options_updatedBy` (`updatedBy` ASC) ,
  CONSTRAINT `options_nextQuestionID`
    FOREIGN KEY (`nextQuestionID` )
    REFERENCES `survey_system`.`questions` (`questionID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `options_createdBy`
    FOREIGN KEY (`createdBy` )
    REFERENCES `survey_system`.`users` (`userID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `options_updatedBy`
    FOREIGN KEY (`updatedBy` )
    REFERENCES `survey_system`.`users` (`userID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`responces`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`responces` (
  `responceID` VARCHAR(30) NOT NULL ,
  `responceText` VARCHAR(100) NOT NULL ,
  `createdTime` DATETIME NOT NULL ,
  `updatedTime` DATETIME NULL ,
  PRIMARY KEY (`responceID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`users_responses`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`users_responses` (
  `userID` VARCHAR(30) NOT NULL ,
  `responsesID` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`userID`, `responsesID`) ,
  INDEX `users_responses_userID` (`userID` ASC) ,
  INDEX `users_responses_reponseID` (`responsesID` ASC) ,
  CONSTRAINT `users_responses_userID`
    FOREIGN KEY (`userID` )
    REFERENCES `survey_system`.`users` (`userID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `users_responses_reponseID`
    FOREIGN KEY (`responsesID` )
    REFERENCES `survey_system`.`responces` (`responceID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`users_surveys`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`users_surveys` (
  `userID` VARCHAR(30) NOT NULL ,
  `surveyID` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`userID`, `surveyID`) ,
  INDEX `users_surveys_userID` (`userID` ASC) ,
  INDEX `users_surveys_surveyID` (`surveyID` ASC) ,
  CONSTRAINT `users_surveys_userID`
    FOREIGN KEY (`userID` )
    REFERENCES `survey_system`.`users` (`userID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `users_surveys_surveyID`
    FOREIGN KEY (`surveyID` )
    REFERENCES `survey_system`.`surveys` (`surveyID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`surveys_responses`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`surveys_responses` (
  `surveyID` VARCHAR(30) NOT NULL ,
  `responsesID` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`surveyID`, `responsesID`) ,
  INDEX `surveys_responses_surveyID` (`surveyID` ASC) ,
  INDEX `surveys_responses_reponseID` (`responsesID` ASC) ,
  CONSTRAINT `surveys_responses_surveyID`
    FOREIGN KEY (`surveyID` )
    REFERENCES `survey_system`.`surveys` (`surveyID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `surveys_responses_reponseID`
    FOREIGN KEY (`responsesID` )
    REFERENCES `survey_system`.`responces` (`responceID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`questions_responses`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`questions_responses` (
  `questionID` VARCHAR(30) NOT NULL ,
  `responseID` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`questionID`, `responseID`) ,
  INDEX `questions_responses_questionID` (`questionID` ASC) ,
  INDEX `questions_responses_responseID` (`responseID` ASC) ,
  CONSTRAINT `questions_responses_questionID`
    FOREIGN KEY (`questionID` )
    REFERENCES `survey_system`.`questions` (`questionID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `questions_responses_responseID`
    FOREIGN KEY (`responseID` )
    REFERENCES `survey_system`.`responces` (`responceID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`surveys_questions`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`surveys_questions` (
  `surveyID` VARCHAR(30) NOT NULL ,
  `questionID` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`surveyID`, `questionID`) ,
  INDEX `surveys_questions_surveyID` (`surveyID` ASC) ,
  INDEX `surveys_questions_questionID` (`questionID` ASC) ,
  CONSTRAINT `surveys_questions_surveyID`
    FOREIGN KEY (`surveyID` )
    REFERENCES `survey_system`.`surveys` (`surveyID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `surveys_questions_questionID`
    FOREIGN KEY (`questionID` )
    REFERENCES `survey_system`.`questions` (`questionID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`questions_options`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`questions_options` (
  `questionID` VARCHAR(30) NOT NULL ,
  `optionID` VARCHAR(30) NOT NULL ,
  PRIMARY KEY (`questionID`, `optionID`) ,
  INDEX `questions_options_questionID` (`questionID` ASC) ,
  INDEX `questions_options_optionID` (`optionID` ASC) ,
  CONSTRAINT `questions_options_questionID`
    FOREIGN KEY (`questionID` )
    REFERENCES `survey_system`.`questions` (`questionID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `questions_options_optionID`
    FOREIGN KEY (`optionID` )
    REFERENCES `survey_system`.`options` (`optionID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `survey_system`.`users_users`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `survey_system`.`users_users` (
  `createdBy` VARCHAR(30) NOT NULL ,
  `createdTo` VARCHAR(30) NOT NULL ,
  `createdTime` DATETIME NOT NULL ,
  PRIMARY KEY (`createdBy`, `createdTo`) ,
  INDEX `users_users_createdBy` (`createdBy` ASC) ,
  INDEX `users_users_createdTo` (`createdTo` ASC) ,
  CONSTRAINT `users_users_createdBy`
    FOREIGN KEY (`createdBy` )
    REFERENCES `survey_system`.`users` (`userID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `users_users_createdTo`
    FOREIGN KEY (`createdTo` )
    REFERENCES `survey_system`.`users` (`userID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
