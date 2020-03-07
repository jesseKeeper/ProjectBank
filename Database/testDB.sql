DROP DATABASE IF EXISTS `Bank3C`;
CREATE DATABASE `Bank3C`;
USE `Bank3C`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `KaartGegevens`;
CREATE TABLE `KaartGegevens` (
    `iBanNR` varchar(15) NOT NULL,
    `CardUID` varchar(10) DEFAULT NULL,
    `Eigenaar_id` int(5) NOT NULL,
    `PIN` varchar(4) NOT NULL,
    `Attemps` int(2) DEFAULT NULL,
    `Saldo` FLOAT(255, 2) DEFAULT null,
    primary key (`iBanNR`)
    #CONSTRAINT `Eigenaar_id` FOREIGN KEY (`EigenaarInfo`),
    #REFERENCES `EigenaarInfo` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
)CHARSET=utf8;

BEGIN;
INSERT INTO `KaartGegevens` VALUES ("TEST 12 3456789", "1234567890", 1, 9191, 3, 500.34), ("TEST 98 7654321", "9876543210", 2, 4567, 1, 99.21);
COMMIT;

DROP TABLE IF EXISTS `EigenaarInfo`;
CREATE TABLE `EigenaarInfo` (
    `id` int(5) NOT NULL auto_increment,
    `Voornaam` varchar(100) NOT NULL,
    `Achternaam` varchar(100) NOT NULL,
    `postcode` varchar(15) DEFAULT NULL, 
    `huisnummer` varchar(15) DEFAULT NULL,
    primary key (`id`)
)CHARSET=utf8;

BEGIN;
INSERT INTO `EigenaarInfo` VALUES (1, "Jesse", "Doelman", "1234NL", "17"), (2, "TEST", "TESTER", "4321NL", "15");

SELECT concat(eigenaarinfo.Achternaam, ", ", eigenaarinfo.Voornaam) AS Rekeninghouder, kaartgegevens.iBanNR, kaartgegevens.PIN, kaartgegevens.Saldo FROM eigenaarinfo, kaartgegevens WHERE eigenaarinfo.id = kaartgegevens.Eigenaar_id;