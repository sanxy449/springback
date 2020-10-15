CREATE TABLE `credentials` (
	`username` varchar(40) NOT NULL,
	`password` varchar(128) NOT NULL,
	`enabled` tinyint(1) NOT NULL,
	PRIMARY KEY (`username`)
) ;


CREATE TABLE `person` (
	`email` varchar(45) NOT NULL,
	`first_name` varchar(45) NOT NULL,
	`last_name` varchar(45) NOT NULL,
	`birthday` varchar(12) NOT NULL,
	`phone` VARCHAR(10) default null,
	PRIMARY KEY (`email`)
); 


CREATE TABLE `credentials_person` (
	`email` varchar(45) NOT NULL,
	`username` varchar(40) NOT NULL,
	  
	PRIMARY KEY (`email`,`username`),
	  
	CONSTRAINT `fk_to_person` FOREIGN KEY (`email`) 
	REFERENCES `person` (`email`),
	CONSTRAINT `FK_to_credentials` FOREIGN KEY (`username`) 
	REFERENCES `credentials` (`username`) 
) ;

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) 