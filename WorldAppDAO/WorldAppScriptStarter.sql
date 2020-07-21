/*
Assignment 1 
using Mysql environment on a Amazon RDS instance assigned to me
and using MYSQL driver and DAO pattern

Create a database called WorldApp

Create table Country 
CountryId int 
CountryName varchar(50)
Population int
CityId int



Create table City
CityId int 
Name varchar(50)
isCaptial ENUM(Y,N) //Capital of nation

core reqs: 
in sql
Insert sample data(5 records each) into the tables.
 Ensure atleast 2 records in City table have isCapital set as ‘Y’

question// do i display in JDBC
Display the country and city details for cityId = 3.
Display the country and city details for isCapital = Y.


*/

CREATE DATABASE WorldApp;

CREATE TABLE Country;
CREATE TABLE `WorldApp`.`Country` (
  `CountryId` INT NOT NULL AUTO_INCREMENT,
  `CountryName` VARCHAR(50) NOT NULL,
  `Population` INT NOT NULL,
  `CityId` INT NOT NULL,
  PRIMARY KEY (`CountryId`));
  
  
  UPDATE `WorldApp`.`Country` SET `Population` = '328' WHERE (`CountryId` = '1');
  
  INSERT INTO `WorldApp`.`Country` (`CountryId`, `CountryName`, `Population`, `CityId`) VALUES ('1', 'Washington DC', '328', '1');
  INSERT INTO `WorldApp`.`Country` (`CountryId`, `CountryName`, `Population`, `CityId`) VALUES ('2', 'Lebanon', '6', '2');
  INSERT INTO `WorldApp`.`Country` (`CountryId`, `CountryName`, `Population`, `CityId`) VALUES ('3', 'United States of America', '331', '3');
INSERT INTO `WorldApp`.`Country` (`CountryId`, `CountryName`, `Population`, `CityId`) VALUES ('4', 'United States of America', '331', '4');
INSERT INTO `WorldApp`.`Country` (`CountryId`, `CountryName`, `Population`, `CityId`) VALUES ('5', 'United States of America', '331', '5');

  
  ALTER TABLE `WorldApp`.`Country` 
ADD INDEX `CityId_idx` (`CityId` ASC) VISIBLE;
;
ALTER TABLE `WorldApp`.`Country` 
ADD CONSTRAINT `CityIdFK`
  FOREIGN KEY (`CityId`)
  REFERENCES `WorldApp`.`City` (`CityId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

use WorldApp;

CREATE TABLE `WorldApp`.`City` (
  `CityId` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `IsCaptial` ENUM('yes', 'no') NOT NULL,
  PRIMARY KEY (`CityId`));
  
INSERT INTO `WorldApp`.`City` (`CityId`, `Name`, `IsCaptial`) VALUES ('1', 'Washington DC', 'Y');
INSERT INTO `WorldApp`.`City` (`CityId`, `Name`, `IsCaptial`) VALUES ('2', 'Beirut', 'Y');
INSERT INTO `WorldApp`.`City` (`CityId`, `Name`, `IsCaptial`) VALUES ('3', 'Pittsburgh', 'N');
INSERT INTO `WorldApp`.`City` (`CityId`, `Name`, `IsCaptial`) VALUES ('4', 'Milaukee', 'N');
INSERT INTO `WorldApp`.`City` (`CityId`, `Name`, `IsCaptial`) VALUES ('5', 'Seattle', 'N');

SELECT 
    CountryId,
    CountryName,
    FORMAT(Population,0),
    Country.CityId,
    `City`.`Name` AS `City Name`,
    City.IsCapital
FROM
    Country
        JOIN
    City ON Country.CityId = City.CityId;
    
UPDATE `WorldApp`.`Country` SET `Population` = '328000000' WHERE (`CountryId` = '1');
UPDATE `WorldApp`.`Country` SET `Population` = '6000000' WHERE (`CountryId` = '2');


CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `admin`@`%` 
    SQL SECURITY DEFINER
VIEW `ViewCityNationDetails` AS
    SELECT 
        `Country`.`CountryId` AS `CountryId`,
        `Country`.`CountryName` AS `CountryName`,
        FORMAT(`Country`.`Population`, 0) AS `Population`,
        `Country`.`CityId` AS `CityId`,
        `City`.`Name` AS `City Name`,
        `City`.`IsCapital` AS `IsCapital`
    FROM
        (`Country`
        JOIN `City` ON ((`Country`.`CityId` = `City`.`CityId`)));


SELECT * FROM Country inner join City on Country.CityId = City.CityId WHERE City.IsCaptial='Y';
