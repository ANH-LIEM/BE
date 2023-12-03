-- MySQL dump 10.13  Distrib 8.1.0, for macos12.6 (x86_64)
--
-- Host: localhost    Database: ITSS
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Hồ Hoàn Kiếm còn được gọi là Hồ Gươm là một hồ nước ngọt tự nhiên nằm ở trung tâm thành phố Hà Nội.','Hà Nội','Hồ Gươm',4.5),(2,'Vịnh Hạ Long là một trong những di sản thiên nhiên thế giới, nổi tiếng với hình ảnh những hòn đảo đá kỳ diệu.','Quảng Ninh','Vịnh Hạ Long',4.7),(3,'Phong Nha - Kẻ Bàng là khu du lịch sinh thái nổi tiếng, có hang động lớn nhất thế giới.','Quảng Bình','Phong Nha - Kẻ Bàng',4.8),(4,'Đà Nẵng là thành phố biển hiện đại với bãi biển Mỹ Khê nổi tiếng và cầu Rồng độc đáo.','Đà Nẵng','Đà Nẵng',4.6),(5,'Núi Chúa là khu du lịch quốc gia với cảnh đẹp hòa quyện giữa núi, biển và rừng.','Ninh Thuận','Núi Núi Chúa',4.4),(6,'Mũi Né có bãi cát trắng dài, đồi cát bay và là điểm đến phổ biến cho windsurfing và lướt sóng.','Bình Thuận','Mũi Né',4.5),(7,'Đà Lạt, thành phố ngàn hoa, nổi tiếng với khí hậu mát mẻ, hoa đào và hồ Xuân Hương.','Lâm Đồng','Đà Lạt',4.6),(8,'Hội An là một trong những thành phố cổ nhất và đẹp nhất Việt Nam với kiến trúc cổ kính và đèn lồng lung linh.','Quảng Nam','Hội An',4.7),(9,'Cần Thơ, thành phố ven sông, nổi tiếng với cầu Cần Thơ và thị trường nổi Cái Răng.','Cần Thơ','Cần Thơ',4.5),(10,'Vũng Tàu, thành phố biển gần Sài Gòn, nổi tiếng với bãi Trước và bãi Sau.','Bà Rịa - Vũng Tàu','Vũng Tàu',4.4),(11,'Sa Pa, vùng cao nguyên nổi tiếng với những cánh đồng bậc thang và văn hóa độc đáo của các dân tộc dân dụ.','Lào Cai','Sa Pa',4.6);
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tour_and_locations`
--

DROP TABLE IF EXISTS `tour_and_locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tour_and_locations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location_id` int DEFAULT NULL,
  `tour_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb3d14j5fsc9iyv3cedh66gelo` (`location_id`),
  KEY `FKk86h1cpvj0qtubcatnb27a8xx` (`tour_id`),
  CONSTRAINT `FKb3d14j5fsc9iyv3cedh66gelo` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`),
  CONSTRAINT `FKk86h1cpvj0qtubcatnb27a8xx` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tour_and_locations`
--

LOCK TABLES `tour_and_locations` WRITE;
/*!40000 ALTER TABLE `tour_and_locations` DISABLE KEYS */;
INSERT INTO `tour_and_locations` VALUES (1,1,1),(2,4,1),(3,8,1),(4,3,2),(5,2,2),(6,7,2),(7,9,2),(8,5,3),(9,4,4),(10,6,4),(11,10,4);
/*!40000 ALTER TABLE `tour_and_locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tours`
--

DROP TABLE IF EXISTS `tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tours` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `due` datetime(6) DEFAULT NULL,
  `from_date` datetime(6) DEFAULT NULL,
  `is_closed` bit(1) NOT NULL,
  `max_capacity` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `to_date` datetime(6) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tours`
--

LOCK TABLES `tours` WRITE;
/*!40000 ALTER TABLE `tours` DISABLE KEYS */;
INSERT INTO `tours` VALUES (1,'Khám phá sự tuyệt vời của Hạ Long trên chuyến du ngoạn thư giãn.','2023-12-01 00:00:00.000000','2023-12-15 00:00:00.000000',_binary '\0',50,'Trải Nghiệm Thanh Xuân',150,'Mở','2023-12-20 00:00:00.000000',''),(2,'Hành trình mạo hiểm tại Phong Nha - Kẻ Bàng.','2023-11-25 00:00:00.000000','2023-12-10 00:00:00.000000',_binary '\0',40,'Du Lịch Chữa lành',120,'Mở','2023-12-15 00:00:00.000000',''),(3,'Trải nghiệm vẻ đẹp hiện đại của Đà Nẵng và bãi biển đẹp.','2023-12-05 00:00:00.000000','2023-12-18 00:00:00.000000',_binary '\0',30,'3 Ngày 2 Đêm Đà Nẵng',80,'Mở','2023-12-23 00:00:00.000000',''),(4,'Thư giãn trong vẻ đẹp thanh bình của Vườn Quốc gia Núi Chúa.','2023-12-08 00:00:00.000000','2023-12-22 00:00:00.000000',_binary '\0',25,'Nghỉ Dưỡng Thiên Nhiên Núi Chúa',100,'Mở','2023-12-27 00:00:00.000000','');
/*!40000 ALTER TABLE `tours` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(255) DEFAULT NULL,
                         `location_id` int DEFAULT NULL,
                         `rating` float DEFAULT NULL,
                         `description` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `foods` VALUES (1,'Phở',1,4.5,'Rất ngon'),(2,'Bun ca',1,4.5,'Rất ngon');



DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `email` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `role` int DEFAULT NULL,
                        `nationality` varchar(255) DEFAULT NULL,
                        `phone` int DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `user` VALUES (1,'oke@gmail.com','oke','oke',4,'oke',0123456789),(2,'oke@gmail.com','oke','oke',4,'oke',0123456789);



DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `user_id` int DEFAULT NULL,
                            `tour_id` int DEFAULT NULL,
                            `price` int DEFAULT NULL,
                            `done` boolean DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `contract` VALUES (1,1,1,2000,true),(2,1,1,2000,true);


DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `message` varchar(255) DEFAULT NULL,
                           `user_id` int DEFAULT NULL,
                           `tour_id` int DEFAULT NULL,
                           `time` datetime(6) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `message` VALUES (1,'Xịn',1,1,'2023-12-01 00:00:00.000000'),(2,'Đắt',1,1,'2023-12-01 00:00:00.000000');


DROP TABLE IF EXISTS `locations_and_foods`;
CREATE TABLE `locations_and_foods` (
                                       `id` int NOT NULL AUTO_INCREMENT,
                                       `location_id` int DEFAULT NULL,
                                       `food_id` int DEFAULT NULL,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `locations_and_foods` VALUES (1,1,1),(2,1,1);


DROP TABLE IF EXISTS `user_and_notification`;
CREATE TABLE `user_and_notification` (
                                         `id` int NOT NULL AUTO_INCREMENT,
                                         `user_id` int DEFAULT NULL,
                                         `notification_id` int DEFAULT NULL,
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `user_and_notification` VALUES (1,1,1),(2,1,1);


DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `description` varchar(255) DEFAULT NULL,
                         `url` varchar(255) DEFAULT NULL,
                         `food_id` int DEFAULT NULL,
                         `location_id` int DEFAULT NULL,
                         `tour_id` int DEFAULT NULL,
                         `time` datetime(6) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `image` VALUES (1,'Xịn','test',1,1,1,'2023-12-01 00:00:00.000000'),(2,'Xịn','test',1,1,1,'2023-12-01 00:00:00.000000');


DROP TABLE IF EXISTS `reviews`;
CREATE TABLE `reviews` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `message` varchar(255) DEFAULT NULL,
                           `rating` float DEFAULT NULL,
                           `user_id` int DEFAULT NULL,
                           `tours_id` int DEFAULT NULL,
                           `time` datetime(6) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `reviews` VALUES (1,'Xịn',4.5,1,1,'2023-12-01 00:00:00.000000'),(2,'Đắt',4.5,1,1,'2023-12-01 00:00:00.000000');

DROP TABLE IF EXISTS `notices`;
CREATE TABLE `notices` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `message` varchar(255) DEFAULT NULL,
                           `time` datetime(6) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `notices` VALUES (1,'Alo alo','2023-12-01 00:00:00.000000'),(2,'Run away','2023-12-01 00:00:00.000000');

DROP TABLE IF EXISTS `support`;
CREATE TABLE `support` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `user_id` int DEFAULT NULL,
                           `user1_id` int DEFAULT NULL,
                           `message` varchar(255) DEFAULT NULL,
                           `time` datetime(6) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
INSERT INTO `support` VALUES (1,1,1,'Alo alo','2023-12-01 00:00:00.000000'),(2,1,1,'Run away','2023-12-01 00:00:00.000000');











/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-23  0:50:43
