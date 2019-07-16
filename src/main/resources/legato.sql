-- Dumping database structure for legato
CREATE DATABASE IF NOT EXISTS `legato`;
USE `legato`;

-- Dumping structure for table legato.authority
CREATE TABLE IF NOT EXISTS `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT b'1',
  `create_date_time` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_ROLENAME` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table legato.authority: 3 rows
DELETE FROM `authority`;

INSERT INTO `authority` (`id`, `active`, `create_date_time`, `created_by`, `update_date_time`, `updated_by`, `valid_from`, `valid_to`, `version`, `name`) VALUES
	(1, b'1', '2019-05-08 18:51:25', NULL, NULL, NULL, '2019-05-08 18:51:29', '8888-05-08 18:51:30', NULL, 'ROLE_ADMIN'),
	(2, b'1', '2019-05-08 18:51:25', NULL, NULL, NULL, '2019-05-08 18:51:29', '8888-05-08 18:51:30', NULL, 'ROLE_SUPERADMIN'),
	(3, b'1', '2019-05-08 18:51:25', NULL, NULL, NULL, '2019-05-08 18:51:29', '8888-05-08 18:51:30', NULL, 'ROLE_USER');

-- Dumping structure for table legato.user_authority
CREATE TABLE IF NOT EXISTS `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKiwgsyem2maacfmh11eknji0se` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table legato.user_authority: 1 rows
DELETE FROM `user_authority`;

INSERT INTO `user_authority` (`user_id`, `role_id`) VALUES(1, 1), (1, 2);

-- Dumping structure for table legato.user_profile
CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT b'1',
  `create_date_time` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `profile_pic` varchar(200) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_USERNAME` (`username`),
  UNIQUE KEY `UNIQUE_EMAIL` (`email`),
  UNIQUE KEY `UNIQUE_MOBILE` (`mobile`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table legato.user_profile: 2 rows
DELETE FROM `user_profile`;

INSERT INTO `user_profile` (`id`, `active`, `create_date_time`, `created_by`, `update_date_time`, `updated_by`, `valid_from`, `valid_to`, `version`, `email`, `full_name`, `mobile`, `password`, `profile_pic`, `username`) VALUES
	(1, b'1', '2019-05-08 18:53:49', 'anonymousUser', NULL, NULL, '2019-05-08 18:53:53', '8888-05-08 18:53:55', 1, 'niranjanmaharana95@gmail.com', 'Niranjan Maharana', '9556824846', '$2a$10$whMQnrAY6E657tTBZdgen.A8w/c7bKm5gmYODkGnXokRP8zqDIT46', NULL, 'admin');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;

-- Dumping structure for table legato.user_type
CREATE TABLE IF NOT EXISTS `user_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) DEFAULT b'1',
  `create_date_time` datetime DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `valid_from` datetime DEFAULT NULL,
  `valid_to` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table legato.user_type: 0 rows
DELETE FROM `user_type`;
