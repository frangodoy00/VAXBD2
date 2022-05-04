-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: covid-19
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `centre`
--

DROP TABLE IF EXISTS `centre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `centre`
--

LOCK TABLES `centre` WRITE;
/*!40000 ALTER TABLE `centre` DISABLE KEYS */;
/*!40000 ALTER TABLE `centre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(128) NOT NULL,
  `dayOfBirth` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `dni` int NOT NULL,
  `discriminator` varchar(45) NOT NULL,
  `yearsExperience` int DEFAULT NULL,
  `area_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_areaPersonal_idx` (`area_id`),
  CONSTRAINT `fk_areaPersonal` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_centre`
--

DROP TABLE IF EXISTS `personal_centre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal_centre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `centre_id` int NOT NULL,
  `personal_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_centrePersonal_centre_idx` (`centre_id`),
  KEY `fkpersonalPersonal_centre_idx` (`personal_id`),
  CONSTRAINT `fk_centrePersonal_centre` FOREIGN KEY (`centre_id`) REFERENCES `centre` (`id`),
  CONSTRAINT `fkpersonalPersonal_centre` FOREIGN KEY (`personal_id`) REFERENCES `personal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_centre`
--

LOCK TABLES `personal_centre` WRITE;
/*!40000 ALTER TABLE `personal_centre` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_centre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shot`
--

DROP TABLE IF EXISTS `shot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dateApplication` date NOT NULL,
  `certificate_id` int NOT NULL,
  `patient_id` int NOT NULL,
  `vaccine_id` int NOT NULL,
  `centre_id` int NOT NULL,
  `nurse_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_certificateShot_idx` (`certificate_id`) /*!80000 INVISIBLE */,
  KEY `fk_patientShot_idx` (`patient_id`),
  KEY `fk_centreShot_idx` (`centre_id`),
  KEY `fk_nurseShot_idx` (`nurse_id`),
  KEY `fk_vaccineShot_idx` (`vaccine_id`),
  CONSTRAINT `fk_centreShot` FOREIGN KEY (`centre_id`) REFERENCES `centre` (`id`),
  CONSTRAINT `fk_certificateShot` FOREIGN KEY (`certificate_id`) REFERENCES `shotcertificate` (`id`),
  CONSTRAINT `fk_nurseShot` FOREIGN KEY (`nurse_id`) REFERENCES `personal` (`id`),
  CONSTRAINT `fk_patientShot` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `fk_vaccineShot` FOREIGN KEY (`vaccine_id`) REFERENCES `vaccine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shot`
--

LOCK TABLES `shot` WRITE;
/*!40000 ALTER TABLE `shot` DISABLE KEYS */;
/*!40000 ALTER TABLE `shot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shotcertificate`
--

DROP TABLE IF EXISTS `shotcertificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shotcertificate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `numSerie` int NOT NULL,
  `idVaccine` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shot_vaccine_id_idx` (`idVaccine`),
  CONSTRAINT `fk_shot_vaccine_id` FOREIGN KEY (`idVaccine`) REFERENCES `vaccine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shotcertificate`
--

LOCK TABLES `shotcertificate` WRITE;
/*!40000 ALTER TABLE `shotcertificate` DISABLE KEYS */;
/*!40000 ALTER TABLE `shotcertificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccinationschedule`
--

DROP TABLE IF EXISTS `vaccinationschedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccinationschedule` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccinationschedule`
--

LOCK TABLES `vaccinationschedule` WRITE;
/*!40000 ALTER TABLE `vaccinationschedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaccinationschedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccinationschedule_vaccine`
--

DROP TABLE IF EXISTS `vaccinationschedule_vaccine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccinationschedule_vaccine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vaccinationschedule_id` int NOT NULL,
  `vaccine_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vaccinationschedule_idx` (`vaccinationschedule_id`),
  KEY `fk_vaccine_idx` (`vaccine_id`),
  CONSTRAINT `fk_vaccinationschedule` FOREIGN KEY (`vaccinationschedule_id`) REFERENCES `vaccinationschedule` (`id`),
  CONSTRAINT `fk_vaccine` FOREIGN KEY (`vaccine_id`) REFERENCES `vaccine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccinationschedule_vaccine`
--

LOCK TABLES `vaccinationschedule_vaccine` WRITE;
/*!40000 ALTER TABLE `vaccinationschedule_vaccine` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaccinationschedule_vaccine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccine`
--

DROP TABLE IF EXISTS `vaccine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaccine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `lab` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccine`
--

LOCK TABLES `vaccine` WRITE;
/*!40000 ALTER TABLE `vaccine` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaccine` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-04 16:15:59
