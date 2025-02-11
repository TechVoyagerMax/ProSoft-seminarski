/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;

USE `seminarski`;

/*Table structure for table `nastavnik` */

DROP TABLE IF EXISTS `nastavnik`;

CREATE TABLE `nastavnik` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `nastavnik` */

insert  into `nastavnik`(`id`,`ime`,`prezime`,`username`,`password`) values 
(1,'admin','admin','a','a'),
(2,'Jelena','Djapovic','jeca','jeca123');

/*Table structure for table `nivo_takmicenja` */

DROP TABLE IF EXISTS `nivo_takmicenja`;

CREATE TABLE `nivo_takmicenja` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `nivo_takmicenja` */

insert  into `nivo_takmicenja`(`id`,`naziv`) values 
(1,'Skolsko takmicenje');

/*Table structure for table `predmet` */

DROP TABLE IF EXISTS `predmet`;

CREATE TABLE `predmet` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `predmet` */

insert  into `predmet`(`id`,`naziv`) values 
(1,'Matematika');

/*Table structure for table `razred` */

DROP TABLE IF EXISTS `razred`;

CREATE TABLE `razred` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `redni_broj` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `razred` */

insert  into `razred`(`id`,`redni_broj`) values 
(1,5),
(2,6),
(3,7),
(4,8);

/*Table structure for table `sala` */

DROP TABLE IF EXISTS `sala`;

CREATE TABLE `sala` (
  `id_nastavnik` bigint(20) unsigned NOT NULL,
  `id_takmicenja` bigint(20) unsigned NOT NULL,
  `id_stavka` bigint(20) unsigned NOT NULL,
  `broj_sale` int(11) NOT NULL,
  `vreme_pocetka_dezurstva` varchar(30) NOT NULL,
  `trajanje_dezurstva` varchar(30) NOT NULL,
  PRIMARY KEY (`id_nastavnik`,`id_takmicenja`,`id_stavka`),
  KEY `id_takmicenja` (`id_takmicenja`),
  KEY `id_stavka` (`id_stavka`),
  CONSTRAINT `sala_ibfk_1` FOREIGN KEY (`id_nastavnik`) REFERENCES `nastavnik` (`id`),
  CONSTRAINT `sala_ibfk_2` FOREIGN KEY (`id_takmicenja`) REFERENCES `takmicenje` (`id`),
  CONSTRAINT `sala_ibfk_3` FOREIGN KEY (`id_stavka`) REFERENCES `stavka_takmicenja` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `sala` */

insert  into `sala`(`id_nastavnik`,`id_takmicenja`,`id_stavka`,`broj_sale`,`vreme_pocetka_dezurstva`,`trajanje_dezurstva`) values 
(2,1,1,12,'10:00:00','2h 15min');

/*Table structure for table `skola` */

DROP TABLE IF EXISTS `skola`;

CREATE TABLE `skola` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  `grad` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `skola` */

insert  into `skola`(`id`,`naziv`,`grad`) values 
(1,'OS \"Dusan Jerkovic\"','Uzice');

/*Table structure for table `stavka_stavke_takmicenja` */

DROP TABLE IF EXISTS `stavka_stavke_takmicenja`;

CREATE TABLE `stavka_stavke_takmicenja` (
  `id_takmicenja` bigint(20) unsigned NOT NULL,
  `id_stavke` bigint(20) unsigned NOT NULL,
  `rb` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `broj_poena` int(11) NOT NULL,
  `rang` enum('BEZ_NAGRADE','PRVO_MESTO','DRUGO_MESTO','TRECE_MESTO') NOT NULL,
  `id_ucenik` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id_takmicenja`,`id_stavke`,`rb`),
  KEY `rb` (`rb`),
  KEY `id_stavke` (`id_stavke`),
  KEY `id_ucenik` (`id_ucenik`),
  CONSTRAINT `stavka_stavke_takmicenja_ibfk_1` FOREIGN KEY (`id_takmicenja`) REFERENCES `takmicenje` (`id`),
  CONSTRAINT `stavka_stavke_takmicenja_ibfk_2` FOREIGN KEY (`id_stavke`) REFERENCES `stavka_takmicenja` (`id`),
  CONSTRAINT `stavka_stavke_takmicenja_ibfk_3` FOREIGN KEY (`id_ucenik`) REFERENCES `ucenik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `stavka_stavke_takmicenja` */

insert  into `stavka_stavke_takmicenja`(`id_takmicenja`,`id_stavke`,`rb`,`broj_poena`,`rang`,`id_ucenik`) values 
(1,1,1,0,'BEZ_NAGRADE',1);

/*Table structure for table `stavka_takmicenja` */

DROP TABLE IF EXISTS `stavka_takmicenja`;

CREATE TABLE `stavka_takmicenja` (
  `id_takmicenja` bigint(20) unsigned NOT NULL,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `broj_nagrada` int(11) NOT NULL,
  `id_razreda` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id_takmicenja`,`id`),
  KEY `id` (`id`),
  KEY `id_razreda` (`id_razreda`),
  CONSTRAINT `stavka_takmicenja_ibfk_1` FOREIGN KEY (`id_takmicenja`) REFERENCES `takmicenje` (`id`),
  CONSTRAINT `stavka_takmicenja_ibfk_2` FOREIGN KEY (`id_razreda`) REFERENCES `razred` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `stavka_takmicenja` */

insert  into `stavka_takmicenja`(`id_takmicenja`,`id`,`broj_nagrada`,`id_razreda`) values 
(1,1,0,1);

/*Table structure for table `takmicenje` */

DROP TABLE IF EXISTS `takmicenje`;

CREATE TABLE `takmicenje` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `datum_odrzavanja` date NOT NULL,
  `id_predmeta` bigint(20) unsigned NOT NULL,
  `id_skole` bigint(20) unsigned NOT NULL,
  `id_nivoa` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_predmeta` (`id_predmeta`),
  KEY `id_skole` (`id_skole`),
  KEY `id_nivoa` (`id_nivoa`),
  CONSTRAINT `takmicenje_ibfk_1` FOREIGN KEY (`id_predmeta`) REFERENCES `predmet` (`id`),
  CONSTRAINT `takmicenje_ibfk_2` FOREIGN KEY (`id_skole`) REFERENCES `skola` (`id`),
  CONSTRAINT `takmicenje_ibfk_3` FOREIGN KEY (`id_nivoa`) REFERENCES `nivo_takmicenja` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `takmicenje` */

insert  into `takmicenje`(`id`,`datum_odrzavanja`,`id_predmeta`,`id_skole`,`id_nivoa`) values 
(1,'2025-02-10',1,1,1);

/*Table structure for table `ucenik` */

DROP TABLE IF EXISTS `ucenik`;

CREATE TABLE `ucenik` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `jmbg` varchar(13) NOT NULL,
  `id_razred` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_razred` (`id_razred`),
  CONSTRAINT `ucenik_ibfk_1` FOREIGN KEY (`id_razred`) REFERENCES `razred` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `ucenik` */

insert  into `ucenik`(`id`,`ime`,`prezime`,`jmbg`,`id_razred`) values 
(1,'Anja','Djapovic','1105002795027',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
