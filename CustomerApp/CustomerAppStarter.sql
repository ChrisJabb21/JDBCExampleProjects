/* CustomerAppSQLscript.sql

Reqs:
Create a JavaApplication called CustomerApp for the following ER diagram using
DAO pattern implementation 


ER Specs: Create three tables based on specifications 
by management and test several methods 

presentation  go over code
run code

---Customer-----
CustomerNumber
CustomerName
Address
City 
Country 
ProductCode  

----Product----
ProductCode
ProductName

==============
*/


CREATE DATABASE CustomerApp;

use CustomerApp;


#Foreign key generatered
UPDATE `CustomerApp`.`Product` SET `Price` = '16.00', `Quantity` = '100' WHERE (`ProductCode` = '1');
UPDATE `CustomerApp`.`Product` SET `Price` = '5.95', `Quantity` = '50' WHERE (`ProductCode` = '2');
UPDATE `CustomerApp`.`Product` SET `Price` = '50.95', `Quantity` = '50' WHERE (`ProductCode` = '3');

#Print Customer with their products
SELECT Customer.CustomerNumber, Customer.CustomerName, Orders.ProductCode, Product.ProductName, Product.Price
FROM ((Orders
 inner join Customer ON Orders.CustomerNumber = Customer.CustomerNumber)
inner join Product on Orders.ProductCode= Product.ProductCode) ORDER BY CustomerNumber;

#Update quantity for a particular Product entry like a restock or transaction
#change quality from 25 to 50
SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;

UPDATE Product 
SET Quantity = 50
Where ProductName = "Gaming Headphones";

SELECT * FROM Product;

#Delete all the orders placed for a product by a particular Customer
#Delete all the orders placed for a product by a particular Customer
#Delete Orders (all order ids) based on product and specified customer
#delete all order entrys by product name based on customerId
DELETE Orders FROM ((Orders
inner join Product on Orders.ProductCode= Product.ProductCode)
 inner join Customer ON Orders.CustomerNumber = Customer.CustomerNumber)
where ProductName = 'Premium Sun Glasses' and CustomerName = 'John Doe';

SELECT 
    C.CustomerName,
    P.ProductName,
    MAX(P.Price) AS 'Most Expensive Product Ordered'
FROM
    ((Orders AS O
    INNER JOIN Product AS P ON P.ProductCode = O.ProductCode)
    INNER JOIN Customer AS C ON C.CustomerNumber = O.CustomerNumber)
WHERE
    C.CustomerNumber = 3; 
  
  



SELECT C.CustomerNumber, C.CustomerName, P.ProductName, MAX(P.Price) as 'Most Expensive Product Ordered'
FROM ((Orders as O inner join Product as P on P.ProductCode = O.ProductCode)
inner join Customer as C on C.CustomerNumber = O.CustomerNumber) WHERE C.CustomerNumber = 1;




CREATE TABLE `Customer` (
  `CustomerNumber` INT NOT NULL AUTO_INCREMENT,
  `CustomerName` VARCHAR(50) NOT NULL,
  `Address` VARCHAR(50) NOT NULL,
  `City` VARCHAR(45) NOT NULL,
  `Country` VARCHAR(45) NOT NULL,
  `OrderNumber` int(11) NOT NULL,
  PRIMARY KEY (`CustomerNumber`));


CREATE TABLE `Orders` (
  `OrderNumber` int(11) NOT NULL,
  `CustomerNumber` int(11) NOT NULL,
  `ProductCode` int(11) NOT NULL,
  `Price` decimal(10,0) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`OrderNumber`));


CREATE TABLE `Product` (
  `ProductCode` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(45) NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProductCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* results from console for JDBC program with sample data
Customer | name=Chris Jabbour, | ProductCode=1| ProductName= Rubber Duck| Price=$16.00|
Customer | name=Chris Jabbour, | ProductCode=2| ProductName= Rubber Duck Capes| Price=$6.00|
Customer | name=Chris Jabbour, | ProductCode=4| ProductName= Debugging reading glasses| Price=$25.00|
Customer | name=Stephen Jabbour, | ProductCode=5| ProductName= Gaming Headphones| Price=$100.50|
Customer | name=John Doe, | ProductCode=6| ProductName= Premium Sun Glasses| Price=$150.00|
Customer | name=John Doe, | ProductCode=6| ProductName= Premium Sun Glasses| Price=$150.00|
Customer | name=John Doe, | ProductCode=1| ProductName= Rubber Duck| Price=$16.00|

if successful print record updated
Connection closed...

if successful print records deleted
*/