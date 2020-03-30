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
    `hashedPIN` VARCHAR(100) DEFAULT NULL,
    `attemps` int(2) DEFAULT NULL,
    `saldo` FLOAT(255, 2) DEFAULT NULL,
    primary key (`iBan`)
)CHARSET=utf8;


INSERT INTO `rekening` VALUES ("TEST 12 3456789", "D2 42 3A 1B", 1, 9191, "1746992", 3, 500.34), ("TEST 98 7654321", "10987654321", 2, 4567, "1601794", 1, 99.21), 
("RABO TEST 12345", "96 5R 4C CE", 3, 4213, "1598752", 3, 9420.69), ("1234567890", "21 9C 87 6A", 1, 1111, "1508416", 3, 1.01), 
("Derde rekening", "Geen UID", 1, 8516, "1720802", 0, 1000.01), ("Tweede rekening", "Geen UID", 2, 6742, "1663231", 2, 999.42);


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

#test query met alles als resultaat
SELECT concat(rekeninghouder.achternaam, ", ", rekeninghouder.voornaam) AS Rekeninghouder, 
rekeninghouder.geboortedatum,
CONCAT(rekeninghouder.postcode, ", ", rekeninghouder.huisnummer) AS adres, 
rekening.iBan, rekening.hashedPIN, rekening.cardUID AS UID, 
rekening.attemps AS pogingen, rekening.saldo 

FROM rekeninghouder, rekening 
WHERE rekeninghouder.id = rekening.rekeninghouder_id
ORDER BY rekening.rekeninghouder_id, rekening.saldo desc;