-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: test_db
-- ------------------------------------------------------
-- Server version	5.5.50

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
-- Table structure for table `options`
--

DROP TABLE IF EXISTS `options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `options` (
  `optionID` varchar(255) NOT NULL,
  `CreatedTime` datetime DEFAULT NULL,
  `Updatedtime` datetime DEFAULT NULL,
  `optionText` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `linked_question_id` varchar(30) DEFAULT NULL,
  `question_id` varchar(30) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`optionID`),
  KEY `FKB586869E15E0B480` (`linked_question_id`),
  KEY `FKB586869E2A4939C9` (`updatedBy`),
  KEY `FKB586869EC22200B6` (`createdBy`),
  KEY `FKB586869E74AB0DA6` (`question_id`),
  CONSTRAINT `FKB586869E74AB0DA6` FOREIGN KEY (`question_id`) REFERENCES `questions` (`questionID`),
  CONSTRAINT `FKB586869E15E0B480` FOREIGN KEY (`linked_question_id`) REFERENCES `questions` (`questionID`),
  CONSTRAINT `FKB586869E2A4939C9` FOREIGN KEY (`updatedBy`) REFERENCES `users` (`userID`),
  CONSTRAINT `FKB586869EC22200B6` FOREIGN KEY (`createdBy`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `options`
--

LOCK TABLES `options` WRITE;
/*!40000 ALTER TABLE `options` DISABLE KEYS */;
INSERT INTO `options` VALUES ('1','2009-10-12 22:05:36','2009-10-12 22:11:36','USA','2',NULL,'1','2'),('10','2014-04-21 23:04:57','2014-04-21 23:08:57','Ireland','6',NULL,'4','6'),('11','2014-04-21 23:01:58','2014-04-21 23:03:58','Male','6',NULL,'5','6'),('12','2014-04-21 23:02:58','2014-04-21 23:04:58','Female','6',NULL,'5','6'),('13','2013-12-02 22:05:36','2013-12-02 22:09:36','USA','5',NULL,'7','1'),('14','2013-12-02 22:06:36','2013-12-02 22:10:36','India','5',NULL,'7','1'),('15','2013-12-02 22:07:36','2013-12-02 22:11:36','Australia','5',NULL,'7','1'),('16','2013-12-02 22:08:36','2013-12-02 22:12:36','Ireland','5',NULL,'7','1'),('17','2013-12-02 22:05:37','2013-12-02 22:07:37','Male','5',NULL,'8','1'),('18','2013-12-02 22:06:37','2013-12-02 22:08:37','Female','5',NULL,'8','1'),('19','2010-12-09 22:05:35','2010-12-09 22:09:35','USA','3',NULL,'10','3'),('2','2009-10-12 22:06:36','2009-10-12 22:12:36','India','2',NULL,'1','2'),('20','2010-12-09 22:06:35','2010-12-09 22:10:35','India','3',NULL,'10','3'),('21','2010-12-09 22:07:35','2010-12-09 22:11:35','Australia','3',NULL,'10','3'),('22','2010-12-09 22:08:35','2010-12-09 22:12:35','Ireland','3',NULL,'10','3'),('23','2010-12-09 22:05:36','2010-12-09 22:05:36','Male','3',NULL,'11','3'),('24','2010-12-09 22:06:36','2010-12-09 22:06:36','Female','3',NULL,'11','3'),('25','2011-03-10 22:05:35','2011-03-10 22:09:35','USA','4',NULL,'13','1'),('26','2011-03-10 22:06:35','2011-03-10 22:10:35','India','4',NULL,'13','1'),('27','2011-03-10 22:07:35','2011-03-10 22:11:35','Australia','4',NULL,'13','1'),('28','2011-03-10 22:08:35','2011-03-10 22:12:35','Ireland','4',NULL,'13','1'),('29','2011-03-10 22:05:36','2011-03-10 22:07:36','Male','4',NULL,'14','1'),('3','2009-10-12 22:07:36','2009-10-12 22:13:36','Australia','2',NULL,'1','2'),('30','2011-03-10 22:06:36','2011-03-10 22:08:36','Female','4',NULL,'14','1'),('4','2009-10-12 22:08:36','2009-10-12 22:14:36','Ireland','2',NULL,'1','2'),('5','2009-10-12 22:09:37','2009-10-12 22:15:37','Male','2',NULL,'2','2'),('6','2009-10-12 22:10:37','2009-10-12 22:16:37','Female','2',NULL,'2','2'),('7','2014-04-21 23:01:57','2014-04-21 23:05:57','USA ','6',NULL,'4','6'),('8','2014-04-21 23:02:57','2014-04-21 23:06:57','India','6',NULL,'4','6'),('9','2014-04-21 23:03:57','2014-04-21 23:07:57','Australia','6',NULL,'4','6');
/*!40000 ALTER TABLE `options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `questionID` varchar(30) NOT NULL,
  `CreatedTime` datetime DEFAULT NULL,
  `UpdatedTime` datetime DEFAULT NULL,
  `questionText` varchar(255) DEFAULT NULL,
  `questionType` varchar(255) DEFAULT NULL,
  `createdBy` varchar(255) DEFAULT NULL,
  `surveyID` varchar(255) DEFAULT NULL,
  `updatedBy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`questionID`),
  KEY `FK95C5414D7C2155FB` (`surveyID`),
  KEY `FK95C5414D2A4939C9` (`updatedBy`),
  KEY `FK95C5414DC22200B6` (`createdBy`),
  CONSTRAINT `FK95C5414DC22200B6` FOREIGN KEY (`createdBy`) REFERENCES `users` (`userID`),
  CONSTRAINT `FK95C5414D2A4939C9` FOREIGN KEY (`updatedBy`) REFERENCES `users` (`userID`),
  CONSTRAINT `FK95C5414D7C2155FB` FOREIGN KEY (`surveyID`) REFERENCES `surveys` (`surveyID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES ('1','2009-10-12 22:04:36','2009-10-12 22:04:39','Select the countries you have visited so far','checkbox','2','1','2'),('10','2010-12-09 22:04:35','2010-12-09 22:04:38','Select the countries you have visited so far','checkbox','3','4','3'),('11','2010-12-09 22:04:36','2010-12-09 22:04:39','What is your gender?','radio','3','4','3'),('12','2010-12-09 22:04:37','2010-12-09 22:04:40','Write about yourself','text','3','4','3'),('13','2011-03-10 22:04:35','2011-03-10 22:04:38','Select the countries you have visited so far','checkbox','4','5','1'),('14','2011-03-10 22:04:36','2011-03-10 22:04:39','What is your gender?','radio','4','5','1'),('15','2011-03-10 22:04:37','2011-03-10 22:04:40','Write about yourself','text','4','5','1'),('2','2009-10-12 22:04:37','2009-10-12 22:04:40','What is your gender?','radio','2','1','2'),('3','2009-10-12 22:04:38','2009-10-12 22:04:41','Write about yourself','text','2','1','2'),('4','2014-04-21 23:00:57','2014-04-21 23:01:56','Select the countries you have visited so far','checkbox','6','2','6'),('5','2014-04-21 23:00:58','2014-04-21 23:02:56','What is your gender?','radio','6','2','6'),('6','2014-04-21 23:00:59','2014-04-21 23:03:56','Write about yourself','text','6','2','6'),('7','2013-12-02 22:04:36','2013-12-02 22:04:39','Select the countries you have visited so far','checkbox','5','3','1'),('8','2013-12-02 22:04:37','2013-12-02 22:04:40','What is your gender?','radio','5','3','1'),('9','2013-12-02 22:04:38','2013-12-02 22:04:41','Write about yourself','text','5','3','1');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responses`
--

DROP TABLE IF EXISTS `responses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responses` (
  `responseID` varchar(255) NOT NULL,
  `createdTime` datetime DEFAULT NULL,
  `responseText` varchar(255) DEFAULT NULL,
  `updatedTime` datetime DEFAULT NULL,
  PRIMARY KEY (`responseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responses`
--

LOCK TABLES `responses` WRITE;
/*!40000 ALTER TABLE `responses` DISABLE KEYS */;
INSERT INTO `responses` VALUES ('',NULL,NULL,NULL),('1','2016-01-01 00:00:01','USA','2016-01-01 00:00:20'),('10','2016-01-01 00:00:10','USA','2016-01-01 00:00:29'),('11','2016-01-01 00:00:11','India','2016-01-01 00:00:30'),('12','2016-01-01 00:00:12','Australia','2016-01-01 00:00:31'),('13','2016-01-01 00:00:13','Female','2016-01-01 00:00:32'),('14','2016-01-01 00:00:14','Ireland ','2016-01-01 00:00:33'),('15','2016-01-01 00:00:15','Female','2016-01-01 00:00:34'),('2','2016-01-01 00:00:02','India ','2016-01-01 00:00:21'),('3','2016-01-01 00:00:03','Ireland','2016-01-01 00:00:22'),('4','2016-01-01 00:00:04','Female','2016-01-01 00:00:23'),('5','2016-01-01 00:00:05','Ireland','2016-01-01 00:00:24'),('6','2016-01-01 00:00:06','Male','2016-01-01 00:00:25'),('7','2016-01-01 00:00:07','India','2016-01-01 00:00:26'),('8','2016-01-01 00:00:08','Australia','2016-01-01 00:00:27'),('9','2016-01-01 00:00:09','Male','2016-01-01 00:00:28');
/*!40000 ALTER TABLE `responses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveys`
--

DROP TABLE IF EXISTS `surveys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `surveys` (
  `surveyID` varchar(255) NOT NULL,
  `createdTime` datetime DEFAULT NULL,
  `label` varchar(45) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `surveyName` varchar(40) NOT NULL,
  `surveyType` varchar(10) DEFAULT NULL,
  `updatedBy` varchar(50) DEFAULT NULL,
  `updatedTime` datetime DEFAULT NULL,
  `userID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`surveyID`),
  KEY `FK919144596CA2C19D` (`userID`),
  CONSTRAINT `FK919144596CA2C19D` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveys`
--

LOCK TABLES `surveys` WRITE;
/*!40000 ALTER TABLE `surveys` DISABLE KEYS */;
INSERT INTO `surveys` VALUES ('1','2009-10-12 22:04:34','educational','L','GET2016 survey','education','2','2009-10-13 22:04:34','2'),('2','2014-04-21 23:00:56','environmental','N','GoGreen survey','envirnment','6','2014-04-22 23:00:56','6'),('3','2013-12-02 22:04:34','corporate','N','Cognizant survey','business','1','2013-12-03 22:04:34','5'),('4','2010-12-09 22:04:34','family','L','BetiBachao survey','family','3','2010-12-10 22:04:34','3'),('5','2011-03-10 22:04:34','sports','L','Cricket survey','sports','1','2011-03-11 22:04:34','4');
/*!40000 ALTER TABLE `surveys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userID` varchar(255) NOT NULL,
  `blockUser` varchar(255) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updatedTime` datetime DEFAULT NULL,
  `userRole` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('1','unblocked','2012-12-30 23:00:55','kuldeep@yadav.com','Kuldeep Yadav','yadav@123','2012-12-31 23:00:55','admin'),('2','unblocked','2009-09-12 22:04:34','pranav@pande.com','pranav pande','pande@123','2009-10-12 22:04:34','surveyor'),('3','unblocked','2010-11-08 22:04:34','jyoti @saxena.com','jyoti saxena','saxena@123','2010-12-15 22:04:34','surveyor'),('4','unblocked','2011-01-10 22:04:34','prakash@dubey.com','prakash dubey','dubey@123','2011-05-15 22:04:34','surveyor'),('5','unblocked','2013-12-01 22:04:34','deepika@jain.com','deepika jain','jain@123','2013-12-31 22:04:34','surveyor'),('6','unblocked','2014-03-21 23:00:56','astha@jain.com','astha jain','jain@123','2014-04-21 23:59:56','surveyor');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-24 14:36:28
