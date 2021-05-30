CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `location` varchar(20) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `ameneties` (
  `ameneties_id` int(11) NOT NULL AUTO_INCREMENT,
  `ameneties` varchar(50) NOT NULL,
  PRIMARY KEY (`ameneties_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `hotels` (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_name` varchar(50) NOT NULL,
  `available_rooms` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `address` varchar(500) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `ameneties_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`hotel_id`),
  KEY `location_id` (`location_id`),
  KEY `ameneties_id` (`ameneties_id`),
  CONSTRAINT `hotels_ibfk_3` FOREIGN KEY (`ameneties_id`) REFERENCES `ameneties` (`ameneties_id`),
  CONSTRAINT `hotels_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`),
  CONSTRAINT `hotels_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



CREATE TABLE `hotel_amenety_map_tbl` (
  `hotel_amenety_map_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL,
  `ameneties_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`hotel_amenety_map_id`),
  KEY `hotel_id` (`hotel_id`),
  KEY `ameneties_id` (`ameneties_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`hotel_id`),
  CONSTRAINT `fk2` FOREIGN KEY (`ameneties_id`) REFERENCES `ameneties` (`ameneties_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `user_id` int(30) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `gendre` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `comment` varchar(500) NOT NULL,
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `hotel_id` (`hotel_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotels` (`hotel_id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

INSERT INTO ameneties (ameneties) VALUES
	 ('AC'),
	 ('lift'),
	 ('Freezer');
	
	INSERT INTO location (location_id,location) VALUES
	 (1,'Hyderabad'),
	 (2,'Mumbai'),
	 (3,'Chennai');
	
