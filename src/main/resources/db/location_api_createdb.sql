create database location_api;
create table `location_api`.`geolocations` (
    `id` int(11) unsigned not null AUTO_INCREMENT,
    `latitude` double  not null,
    `longitude` double not null,
    `city` varchar(25),
    `country` varchar(25),
    `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `latitudelongitude` (`latitude`,`longitude`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
