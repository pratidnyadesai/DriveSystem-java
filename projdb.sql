-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: projdb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `drive`
--

DROP TABLE IF EXISTS `drive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `cmpname` varchar(45) DEFAULT NULL,
  `noofres` int(11) DEFAULT NULL,
  `expreq` tinyint(2) DEFAULT '0',
  `ctc` float DEFAULT NULL,
  `joincrt` tinyint(2) DEFAULT '0',
  `bond` float DEFAULT NULL,
  `position` tinyint(2) DEFAULT '0',
  `followup` date DEFAULT NULL,
  `educrt` tinyint(2) DEFAULT '0',
  `cur_status` tinyint(2) DEFAULT '0',
  `nxt_act` tinyint(2) DEFAULT '0',
  `nxt_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `poy_req` int(11) DEFAULT NULL,
  `gap_req` tinyint(2) DEFAULT '0',
  `creation_date` date DEFAULT NULL,
  `tpoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`did`),
  KEY `tpoid_idx` (`tpoid`),
  CONSTRAINT `tpoid` FOREIGN KEY (`tpoid`) REFERENCES `tpo` (`tpoid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive`
--

LOCK TABLES `drive` WRITE;
/*!40000 ALTER TABLE `drive` DISABLE KEYS */;
INSERT INTO `drive` VALUES (4,'Zensor',22,1,300000,0,0,1,'2020-01-28',0,0,0,'2020-01-20 07:36:50',NULL,0,NULL,NULL),(6,'RajaSoft',10,1,300000,0,0,0,'2020-01-28',0,0,0,'2020-01-21 09:58:37',NULL,0,NULL,NULL),(7,'GreenLight',2,1,300000,0,0,0,'2020-01-28',0,0,0,'2020-01-21 09:58:39',NULL,0,NULL,NULL),(9,'GreenLight',2,1,300000,0,0,0,'2020-01-28',0,0,0,'2020-01-21 09:58:41',NULL,0,NULL,NULL),(11,'GreenLight',2,1,300000,0,0,0,'2020-01-28',0,0,0,'2020-01-21 09:58:42',NULL,0,NULL,NULL),(12,'GreenLight',2,1,300000,0,0,0,'2020-01-28',0,0,0,'2020-01-21 09:58:43',NULL,0,NULL,NULL),(14,'pppp',3,2,700000,0,1,2,'2020-01-28',0,0,0,'2020-01-21 10:08:46',NULL,0,NULL,NULL),(15,'pppp',3,2,700000,0,1,2,'2020-01-28',0,0,0,'2020-01-21 10:08:46',NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `drive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_stud`
--

DROP TABLE IF EXISTS `drive_stud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_stud` (
  `dsid` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL,
  `st_id` int(11) NOT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tpoid` int(11) DEFAULT NULL,
  PRIMARY KEY (`st_id`),
  UNIQUE KEY `dsid_UNIQUE` (`dsid`),
  KEY `topidfk_idx` (`tpoid`),
  CONSTRAINT `topidfk` FOREIGN KEY (`tpoid`) REFERENCES `tpo` (`tpoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_stud`
--

LOCK TABLES `drive_stud` WRITE;
/*!40000 ALTER TABLE `drive_stud` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_stud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_stud_track`
--

DROP TABLE IF EXISTS `drive_stud_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_stud_track` (
  `dsrid` int(11) NOT NULL,
  `did` int(11) DEFAULT NULL,
  `stid` int(11) DEFAULT NULL,
  `tpoid` int(11) DEFAULT NULL,
  `survived_status` tinyint(2) DEFAULT '0',
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`dsrid`),
  KEY `tpoid_fk_idx` (`tpoid`),
  KEY `stdid_fk_idx` (`stid`),
  CONSTRAINT `stdid_fk` FOREIGN KEY (`stid`) REFERENCES `drive_stud` (`st_id`),
  CONSTRAINT `tpoid_fk` FOREIGN KEY (`tpoid`) REFERENCES `tpo` (`tpoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_stud_track`
--

LOCK TABLES `drive_stud_track` WRITE;
/*!40000 ALTER TABLE `drive_stud_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_stud_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drive_track`
--

DROP TABLE IF EXISTS `drive_track`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `drive_track` (
  `trid` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(11) DEFAULT NULL,
  `status` tinyint(2) DEFAULT '0',
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tpoid` int(11) DEFAULT NULL,
  `remark` varchar(45) DEFAULT NULL,
  `no_of_stud` int(11) DEFAULT NULL,
  PRIMARY KEY (`trid`),
  KEY `tpoidfk_idx` (`tpoid`),
  CONSTRAINT `tpoid_f` FOREIGN KEY (`tpoid`) REFERENCES `tpo` (`tpoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drive_track`
--

LOCK TABLES `drive_track` WRITE;
/*!40000 ALTER TABLE `drive_track` DISABLE KEYS */;
/*!40000 ALTER TABLE `drive_track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tpo`
--

DROP TABLE IF EXISTS `tpo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tpo` (
  `tpoid` int(11) NOT NULL AUTO_INCREMENT,
  `tpo_name` varchar(45) DEFAULT NULL,
  `tpo_email` varchar(45) DEFAULT NULL,
  `tpo_username` varchar(45) DEFAULT NULL,
  `tpo_password` varchar(45) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `role` tinyint(2) DEFAULT '0',
  PRIMARY KEY (`tpoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpo`
--

LOCK TABLES `tpo` WRITE;
/*!40000 ALTER TABLE `tpo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tpo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-27 16:16:36
