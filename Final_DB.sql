-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafit_final
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafit_final
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafit_final` DEFAULT CHARACTER SET utf8 ;
USE `ssafit_final` ;

-- -----------------------------------------------------
-- Table `ssafit_final`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_final`.`users` (
  `userID` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nickName` VARCHAR(45) NOT NULL,
  `stateMsg` VARCHAR(15) NULL,
  `lastingCnt` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`userID`),
  UNIQUE INDEX `userID_UNIQUE` (`userID` ASC) VISIBLE,
  UNIQUE INDEX `nickName_UNIQUE` (`nickName` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `ssafit_final`.`follow`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_final`.`follow` (
  `follower` VARCHAR(45) NOT NULL,
  `following` VARCHAR(45) NOT NULL,
  `followId` INT NOT NULL AUTO_INCREMENT,
  INDEX `follower_idx` (`follower` ASC) VISIBLE,
  INDEX `following_idx` (`following` ASC) VISIBLE,
  PRIMARY KEY (`followId`),
  CONSTRAINT `follower`
    FOREIGN KEY (`follower`)
    REFERENCES `ssafit_final`.`users` (`nickName`),
  CONSTRAINT `following`
    FOREIGN KEY (`following`)
    REFERENCES `ssafit_final`.`users` (`nickName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-----------------------------------------------------
-- Table `ssafit_final`.`videos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_final`.`videos` (
  `thumbnails` VARCHAR(1000) NOT NULL,
  `youtubeId` VARCHAR(45) NOT NULL,
  `channelName` VARCHAR(1000) NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `viewCnt` INT NOT NULL DEFAULT '0',
  PRIMARY KEY (`youtubeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ssafit_final`.`likevideos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_final`.`likevideos` (
  `nickName` VARCHAR(45) NOT NULL,
  `youtubeId` VARCHAR(45) NOT NULL,
  `likeVideosId` INT NOT NULL AUTO_INCREMENT,
  INDEX `nickName_idx` (`nickName` ASC) VISIBLE,
  INDEX `youtubeId_idx` (`youtubeId` ASC) VISIBLE,
  PRIMARY KEY (`likeVideosId`),
  CONSTRAINT `nickName1`
    FOREIGN KEY (`nickName`)
    REFERENCES `ssafit_final`.`users` (`nickName`),
  CONSTRAINT `youtubeId1`
    FOREIGN KEY (`youtubeId`)
    REFERENCES `ssafit_final`.`videos` (`youtubeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `ssafit_final`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_final`.`comments` (
  `youtubeId` VARCHAR(45) NOT NULL,
  `nickName` VARCHAR(45) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `registDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `likeCnt` INT NOT NULL DEFAULT '0',
  `commentId` INT NOT NULL AUTO_INCREMENT,
  INDEX `nickName_idx` (`nickName` ASC) VISIBLE,
  PRIMARY KEY (`commentId`),
  CONSTRAINT `nickName3`
    FOREIGN KEY (`nickName`)
    REFERENCES `ssafit_final`.`users` (`nickName`),
  CONSTRAINT `youtubeId`
    FOREIGN KEY (`youtubeId`)
    REFERENCES `ssafit_final`.`videos` (`youtubeId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ssafit_final`.`food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_final`.`food` (
  `nickName` VARCHAR(45) NOT NULL,
  `foodName` VARCHAR(45) NOT NULL,
  `kcal` INT NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `foodId` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`foodId`),
  CONSTRAINT `nickName1`
    FOREIGN KEY (`nickName`)
    REFERENCES `ssafit_final`.`users` (`nickName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafit_final`.`workout`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_final`.`workout` (
  `nickName` VARCHAR(45) NOT NULL,
  `workoutName` VARCHAR(45) NOT NULL,
  `workoutCnt` INT NOT NULL,
  `workoutSetCnt` INT NOT NULL,
  `createdDate` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `workoutId` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`workoutId`),
  CONSTRAINT `nickName2`
    FOREIGN KEY (`nickName`)
    REFERENCES `ssafit_final`.`users` (`nickName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


select * from users;
select * from follow;
select * from videos;
select * from likevideos;
select * from comments;
select * from food;
select * from workout;
-- -----------------------------------------------------

INSERT INTO users (userid, name, password, nickName)
VALUES ("wwldwwld7", "김라현", "1234", "라효니");

SELECT *
FROM users
WHERE userid = "wwldwwld7";   -- 아이디 자리에 입력값이 연결되서 들어가야함 

-- -----------------------------------------------------

-- INSERT INTO videos (youtubeId, channelName, title)
-- VALUES
-- ("gMaB-fG4u4g","ThankyouBUBU", "전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]" ),
-- ("swRNeYw1JkY", "ThankyouBUBU", "하루 15분! 전신 칼로리 불태우는 다이어트 운동"),
-- ("54tTYO-vU2E", "ThankyouBUBU", "상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]"),
-- ("QqqZH3j_vH0", "ThankyouBUBU", "상체비만 다이어트 최고의 운동 [상체 핵매운맛]"),
-- ("tzN6ypk6Sps", "김강민", "하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]"),
-- ("u5OgcZdNbMo", "GYM종국", "저는 하체 식주의자 입니다"),
-- ("PjGcOP-TQPE", "ThankyouBUBU", "11자복근 복부 최고의 운동 [복근 핵매운맛]"),
-- ("7TLk7pscICk", "SomiFit", "(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)");

SELECT *
FROM videos;

SELECT *
FROM videos
WHERE youtubeId = "gMaB-fG4u4g"; -- youtubeId 자리에 아무튼 받아서 보내줘

SELECT *
FROM videos
WHERE title like concat( '%', '다이어트', '%');   -- 다이어트 자리는 검색 키워드 자리

-- -----------------------------------------------------

INSERT INTO follow ( follower, following)
VALUES ("쿠기", "라효니");

SELECT *
FROM follow
WHERE following	 = "쿠기";  -- follower 자리가 follower 거나 following 둘다 있어야해

DELETE FROM follow
WHERE follower = "쿠기" and following = "라효니";

-- -----------------------------------------------------

INSERT INTO likevideos (nickName, youtubeId)
VALUES ("쿠기", "gMaB-fG4u4g");

SELECT channelName, title, viewCnt
FROM videos
WHERE youtubeId = 
(SELECT youtubeId
FROM likevideos
WHERE nickName = "쿠기");   -- 쿠기 자리 

DELETE FROM likevideos
WHERE youtubeId = "gMaB-fG4u4g" and nickName = "쿠기";

-- -----------------------------------------------------

INSERT INTO comments (youtubeId, nickName, content)
VALUES ("gMaB-fG4u4g", "쿠기", "집갈래");

UPDATE comments 
SET content = "집못가"
WHERE commentId = 1;    -- commentId는 받아와야해

DELETE FROM comments
WHERE commentId = 1;

SELECT *
FROM comments
WHERE youtubeId = 
(SELECT youtubeId
FROM videos
WHERE youtubeId = "gMaB-fG4u4g");

SELECT *
FROM comments
WHERE nickName = "쿠기";

-- -----------------------------------------------------