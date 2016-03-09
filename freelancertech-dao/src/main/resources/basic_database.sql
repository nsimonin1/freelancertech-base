CREATE DATABASE  IF NOT EXISTS `freelancertech_base` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `freelancertech_base`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: freelancertech_base
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ge_groupes`
--

DROP TABLE IF EXISTS `ge_groupes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ge_groupes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_create` datetime NOT NULL,
  `date_maj` datetime NOT NULL,
  `user_create` varchar(255) NOT NULL,
  `user_maj` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `actif` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(55) NOT NULL,
  `parent_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2xlg5wbqm2ardegrxjjh1ns06` (`libelle`),
  KEY `FK_fn8lyet9uqdcf6bmui3eic0ie` (`parent_id`),
  CONSTRAINT `FK_fn8lyet9uqdcf6bmui3eic0ie` FOREIGN KEY (`parent_id`) REFERENCES `ge_groupes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ge_groupes`
--

LOCK TABLES `ge_groupes` WRITE;
/*!40000 ALTER TABLE `ge_groupes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ge_groupes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ge_photo`
--

DROP TABLE IF EXISTS `ge_photo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ge_photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_create` datetime NOT NULL,
  `date_maj` datetime NOT NULL,
  `user_create` varchar(255) NOT NULL,
  `user_maj` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `code` varchar(155) NOT NULL,
  `contenu` longblob NOT NULL,
  `description` longtext,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ge_photo`
--

LOCK TABLES `ge_photo` WRITE;
/*!40000 ALTER TABLE `ge_photo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ge_photo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ge_taches`
--

DROP TABLE IF EXISTS `ge_taches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ge_taches` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_create` datetime NOT NULL,
  `date_maj` datetime NOT NULL,
  `user_create` varchar(255) NOT NULL,
  `user_maj` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `actif` bit(1) NOT NULL,
  `description` longtext,
  `nom` varchar(155) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s8plq1fw3v3an9v2ucfso4t1v` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ge_taches`
--

LOCK TABLES `ge_taches` WRITE;
/*!40000 ALTER TABLE `ge_taches` DISABLE KEYS */;
/*!40000 ALTER TABLE `ge_taches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ge_taches_groupes`
--

DROP TABLE IF EXISTS `ge_taches_groupes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ge_taches_groupes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_create` datetime NOT NULL,
  `date_maj` datetime NOT NULL,
  `user_create` varchar(255) NOT NULL,
  `user_maj` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `actif` bit(1) NOT NULL,
  `groupe_id` bigint(20) NOT NULL,
  `tache_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3nwa945v73ien9jr2putn3uqn` (`groupe_id`,`tache_id`),
  KEY `FK_4b5cdc9mrouegwtr13qf7un93` (`tache_id`),
  CONSTRAINT `FK_4b5cdc9mrouegwtr13qf7un93` FOREIGN KEY (`tache_id`) REFERENCES `ge_taches` (`id`),
  CONSTRAINT `FK_c1pjw1opfy61jliasko102p8i` FOREIGN KEY (`groupe_id`) REFERENCES `ge_groupes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ge_taches_groupes`
--

LOCK TABLES `ge_taches_groupes` WRITE;
/*!40000 ALTER TABLE `ge_taches_groupes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ge_taches_groupes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ge_utilisateur`
--

DROP TABLE IF EXISTS `ge_utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ge_utilisateur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_create` datetime NOT NULL,
  `date_maj` datetime NOT NULL,
  `user_create` varchar(255) NOT NULL,
  `user_maj` varchar(255) NOT NULL,
  `version` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `expired` bit(1) NOT NULL,
  `groupe_id` bigint(20) NOT NULL,
  `login` varchar(25) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `poste` varchar(25) DEFAULT NULL,
  `pwd` varchar(255) NOT NULL,
  `status` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_18vwp4resqussqmlpqnymfqxk` (`login`),
  KEY `FK_ayy7hank4729ef2j9834m81ff` (`groupe_id`),
  CONSTRAINT `FK_ayy7hank4729ef2j9834m81ff` FOREIGN KEY (`groupe_id`) REFERENCES `ge_groupes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ge_utilisateur`
--

LOCK TABLES `ge_utilisateur` WRITE;
/*!40000 ALTER TABLE `ge_utilisateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `ge_utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-07 18:58:02
