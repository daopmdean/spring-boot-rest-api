CREATE DATABASE  IF NOT EXISTS `the_company`;
USE `the_company`;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `customers`
--

INSERT INTO `customers` VALUES 
	(1,'John','Doe','john@doe.com','09878987898','Ho Chi Minh'),
	(2,'Jane','Moe','jane@moe.com','09878987898','Ha Noi'),
	(3,'Moew','Cono','moew@gmail.com','09878987898','Da Nang'),
	(4,'Dao','Pham','daopm.dean@gmail.com','09878987898','Ho Chi Minh'),
	(5,'He','Ho','heho@gmail.com','09878987898','Vung Tau');

