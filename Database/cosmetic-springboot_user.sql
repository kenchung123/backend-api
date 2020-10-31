-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cosmetic-springboot
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth_date` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` int DEFAULT NULL,
  `fullname` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `image_profile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,'string','2020-06-03','user@gmail.com',0,'sssssffffffff','string','$2a$10$fEkai3IRRsJsuoV4M45GeOrN.uuhu2pjIrhhfXG9qE3v/lmHXJLs.','0376543234',NULL,NULL),(15,'Đn','2020-06-01','nhi123@gmail.com',0,'nhi123ooo','Nữ','$2a$11$LjxY3K4D4jluWBWtffcue.0MLtN7Mv9JT/cm6A8FV9kpv5RVj/CRO','0378594736',NULL,''),(34,'Huế','2020-06-02','chungvo@gmail.com',0,'Chung Võ','Nữ','$2a$11$dOaZ2A4Pwy/PuVRyyZCJLuTje82qFqLjKcxMghzrp078DGF8M9Jpm','0378594736',1,'avatar.jpg'),(17,'Đn','2020-06-02','vothihoai567@gmail.com',0,'vothihoai99999','Nữ','$2a$11$W9CODZwrOZSWrTRIjbMoh.CN8zlXdwf6bTvcD.koV4X6sEoAlMrDS','0378594736',NULL,'49949980_2158066171123776_1966653340016181248_n.jpg'),(20,'Đn','1998-07-17','hoaivo@gmail.com',0,'hoaivo','Nữ','$2a$11$FxbYRKCXNzz/WLbpk1jO9eZNs0lipJ/teuJoQsS6tzpSmi4XPejNC','0378594736',1,NULL),(21,'Đn','2020-06-08','vohoai@gmail.com',0,'vohoai','Nữ','$2a$11$CwOsBX9BLnG6P740b8AUwu/ZIexnFv81jXYdMsCZZnDeK6FRtRWyy','0378594736',NULL,'avatar.jpg'),(22,'Đn','2020-06-01','hoainani@gmail.com',0,'hoai nà ní','Nữ','$2a$11$cxO7AXc6UYw9EXA8p0xmv.xaA4lu7Z/I1OelQEjwgnoAaIPrjIuNO','0378594736',NULL,'avatar.jpg'),(23,'Đn','1998-07-17','hoaihi@gmail.com',0,'vothihoai','Nữ','$2a$11$oUQUe0NUM58Nb8W.4J4Ma.fT.cEVLrAQu4Dv3XZx4OCZE3YP9jJKa','0378594736',1,NULL),(25,'Kp 5-TT Gio Linh - Quảng Trị','2020-06-14','chung123@gmail.com',0,'chung','Nữ','$2a$11$wn0ur6peh6jXL9s.dgc2deJSPuU0trmwmpGOh7AhwlqZcfDO2ywN6','0368092101',NULL,''),(26,'Kp5 - TT Gio Linh -Gio Linh- Quảng Trị','1998-07-17','kenchung@gmail.com',0,'Ken chung','Nữ','$2a$11$LBrTbuuMCqYF7kZvLFDb9.cbaV5rBari217s90lYuS6qWoelLY2uW','0368092101',2,'avatar.jpg'),(28,'38- Duy Tân- Đn','1998-06-13','vothichung@gmail.com',0,'Võ Thị Chung','Nam','$2a$11$KS9WgMxmhh5HxXwSTDHLbu7mx18.tF9dCoiz.gPJXW/EMi64GcmKy','0367587487',1,''),(31,'QN','2020-06-10','vinh@gmail.com',0,'vĩnh','Nữ','$2a$11$u2vrrEILVhRIaJblVKCPUuSM/CpuCcLEWDaD8vlJqAcnPORuBQQEO','0378594736',1,''),(35,'huế','2000-10-10','dinhvinh@gmail.com',0,'Trần Thiên Nam','Nam','$2a$11$jQ1bci45MAJhlp0lOrSFHOVtov2XNzIeyPsERgpYmgThlXmwbm6qG','0323456789',1,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-01  0:01:30
