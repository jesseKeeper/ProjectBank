DROP DATABASE IF EXISTS `Bank3C`;
CREATE DATABASE `Bank3C`;
USE `Bank3C`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `rekening`;
CREATE TABLE `rekening` (
    `iBan` varchar(15) NOT NULL,
    `cardUID` varchar(11) DEFAULT NULL,
    `rekeninghouder_id` int(5) NOT NULL,
    `PIN` varchar(4) NOT NULL,
    `salt` VARCHAR(100) NOT NULL,
    `hashedPIN` VARCHAR(100) DEFAULT NULL,
    `attemps` int(2) DEFAULT NULL,
    `saldo` FLOAT(255, 2) DEFAULT NULL,
    primary key (`iBan`)
)CHARSET=utf8;

INSERT INTO `rekening` VALUES ("TEST 12 3456789", "D2 42 3A 1B", 1, 9191, "Jesse", "1746992", 3, 500.34);

DROP TABLE IF EXISTS `rekeninghouder`;
CREATE TABLE `rekeninghouder` (
    `id` INT(5) auto_increment,
    `voornaam` varchar(100) NOT NULL,
    `achternaam` varchar(100) NOT NULL,
    `geboortedatum` DATE NOT NULL,
    `postcode` varchar(15) NULL, 
    `huisnummer` varchar(15) NULL,
    primary key (`id`)
)CHARSET=utf8;

INSERT INTO `rekeninghouder` VALUES (1, "Jesse", "Doelman", "2000-10-29", "1234 NL", "17"), 
(2, "TEST", "TESTER", "1999-1-1", "4321 NL", "15"), (3, "tester", "test", "1999-2-2",NULL, NULL), 
(NULL, "testAuto", "incrementTest", "2020-3-11", NULL, NULL);

# The needed user for the java Application
#DROP USER if EXISTS `JavaApp`@`localhost`;
#CREATE USER `JavaApp`@`localhost` IDENTIFIED BY 'TheBestAnAppCanGet';
#REVOKE ALL ON bank3C.rekening FROM `JavaApp`@`localhost`;
#GRANT SELECT (iBan, cardUID, PIN, hashedPIN, Salt, attemps, saldo), 
#UPDATE (attemps, saldo) ON bank3C.rekening 
#TO `JavaApp`@`localhost`;
#rekeningFLUSH PRIVILEGES;