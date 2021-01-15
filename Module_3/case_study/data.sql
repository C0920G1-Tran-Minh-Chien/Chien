-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: case_study
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `bo_phan`
--

DROP TABLE IF EXISTS `bo_phan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bo_phan` (
  `id_bo_phan` int NOT NULL AUTO_INCREMENT,
  `ten_bo_phan` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_bo_phan`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bo_phan`
--

LOCK TABLES `bo_phan` WRITE;
/*!40000 ALTER TABLE `bo_phan` DISABLE KEYS */;
INSERT INTO `bo_phan` VALUES (1,'marketing'),(2,'an ninh'),(3,'sale');
/*!40000 ALTER TABLE `bo_phan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dich_vu`
--

DROP TABLE IF EXISTS `dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dich_vu` (
  `id_dich_vu` int NOT NULL AUTO_INCREMENT,
  `ten_dich_vu` varchar(50) DEFAULT NULL,
  `dien_tich` varchar(50) DEFAULT NULL,
  `so_tang` int DEFAULT NULL,
  `so_nguoi_toi_da` varchar(50) DEFAULT NULL,
  `chi_phi_thue` varchar(50) DEFAULT NULL,
  `trang_thai` varchar(50) DEFAULT NULL,
  `id_kieu_thue` int DEFAULT NULL,
  `id_loai_dich_vu` int DEFAULT NULL,
  PRIMARY KEY (`id_dich_vu`),
  KEY `id_kieu_thue` (`id_kieu_thue`),
  KEY `id_loai_dich_vu` (`id_loai_dich_vu`),
  CONSTRAINT `dich_vu_ibfk_1` FOREIGN KEY (`id_kieu_thue`) REFERENCES `kieu_thue` (`id_kieu_thue`),
  CONSTRAINT `dich_vu_ibfk_2` FOREIGN KEY (`id_loai_dich_vu`) REFERENCES `loai_dich_vu` (`id_loai_dich_vu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dich_vu`
--

LOCK TABLES `dich_vu` WRITE;
/*!40000 ALTER TABLE `dich_vu` DISABLE KEYS */;
INSERT INTO `dich_vu` VALUES (1,'Villa','200m2',3,'10 nguoi','1 trieu','Sach se',1,1),(2,'House','100m2',2,'5 nguoi','5 tram','Sach se',2,2),(3,'Room','50m2',1,'2 nguoi','1 tram','Sach se',3,3);
/*!40000 ALTER TABLE `dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dich_vu_di_kem`
--

DROP TABLE IF EXISTS `dich_vu_di_kem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dich_vu_di_kem` (
  `id_dich_vu_di_kem` int NOT NULL AUTO_INCREMENT,
  `ten_dich_vu_di_kem` varchar(50) DEFAULT NULL,
  `gia` int DEFAULT NULL,
  `don_vi` varchar(50) DEFAULT NULL,
  `trang_thai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_dich_vu_di_kem`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dich_vu_di_kem`
--

LOCK TABLES `dich_vu_di_kem` WRITE;
/*!40000 ALTER TABLE `dich_vu_di_kem` DISABLE KEYS */;
INSERT INTO `dich_vu_di_kem` VALUES (1,'massage',1000,'USD','ngon'),(2,'karakole',100,'USD','oke');
/*!40000 ALTER TABLE `dich_vu_di_kem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hop_dong`
--

DROP TABLE IF EXISTS `hop_dong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hop_dong` (
  `id_hop_dong` int NOT NULL AUTO_INCREMENT,
  `ngay_lam_hop_dong` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `tien_dat_coc` int DEFAULT NULL,
  `tong_tien` int DEFAULT NULL,
  `id_nhan_vien` int DEFAULT NULL,
  `id_khach_hang` int DEFAULT NULL,
  `id_dich_vu` int DEFAULT NULL,
  PRIMARY KEY (`id_hop_dong`),
  KEY `id_nhan_vien` (`id_nhan_vien`),
  KEY `id_khach_hang` (`id_khach_hang`),
  KEY `id_dich_vu` (`id_dich_vu`),
  CONSTRAINT `hop_dong_ibfk_1` FOREIGN KEY (`id_nhan_vien`) REFERENCES `nhan_vien` (`id_nhan_vien`),
  CONSTRAINT `hop_dong_ibfk_2` FOREIGN KEY (`id_khach_hang`) REFERENCES `khach_hang` (`id_khach_hang`),
  CONSTRAINT `hop_dong_ibfk_3` FOREIGN KEY (`id_dich_vu`) REFERENCES `dich_vu` (`id_dich_vu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hop_dong`
--

LOCK TABLES `hop_dong` WRITE;
/*!40000 ALTER TABLE `hop_dong` DISABLE KEYS */;
INSERT INTO `hop_dong` VALUES (1,'1995-05-05','2000-05-05',200,1000,1,1,1),(2,'2018-02-05','2020-05-05',500,2000,1,2,2),(3,'2019-05-05','2021-05-15',700,1500,2,2,1),(4,'1995-05-05','2000-05-05',200,1000,1,1,3),(5,'2018-02-05','2020-05-05',500,2000,1,2,2),(6,'2019-05-05','2021-05-15',700,1500,2,4,1);
/*!40000 ALTER TABLE `hop_dong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hop_dong_chi_tiet`
--

DROP TABLE IF EXISTS `hop_dong_chi_tiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hop_dong_chi_tiet` (
  `id_hop_dong_chi_tiet` int NOT NULL AUTO_INCREMENT,
  `id_hop_dong` int DEFAULT NULL,
  `id_dich_vu_di_kem` int DEFAULT NULL,
  `so_luong` int DEFAULT NULL,
  PRIMARY KEY (`id_hop_dong_chi_tiet`),
  KEY `id_hop_dong` (`id_hop_dong`),
  KEY `id_dich_vu_di_kem` (`id_dich_vu_di_kem`),
  CONSTRAINT `hop_dong_chi_tiet_ibfk_1` FOREIGN KEY (`id_hop_dong`) REFERENCES `hop_dong` (`id_hop_dong`),
  CONSTRAINT `hop_dong_chi_tiet_ibfk_2` FOREIGN KEY (`id_dich_vu_di_kem`) REFERENCES `dich_vu_di_kem` (`id_dich_vu_di_kem`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hop_dong_chi_tiet`
--

LOCK TABLES `hop_dong_chi_tiet` WRITE;
/*!40000 ALTER TABLE `hop_dong_chi_tiet` DISABLE KEYS */;
INSERT INTO `hop_dong_chi_tiet` VALUES (1,1,2,10),(2,2,2,20),(3,1,1,30);
/*!40000 ALTER TABLE `hop_dong_chi_tiet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khach_hang`
--

DROP TABLE IF EXISTS `khach_hang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khach_hang` (
  `id_khach_hang` int NOT NULL AUTO_INCREMENT,
  `id_loai_khach` int DEFAULT NULL,
  `ten_khach_hang` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `cmnd` varchar(20) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dia_chi` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_khach_hang`),
  KEY `id_loai_khach` (`id_loai_khach`),
  CONSTRAINT `khach_hang_ibfk_1` FOREIGN KEY (`id_loai_khach`) REFERENCES `loai_khach` (`id_loai_khach`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khach_hang`
--

LOCK TABLES `khach_hang` WRITE;
/*!40000 ALTER TABLE `khach_hang` DISABLE KEYS */;
INSERT INTO `khach_hang` VALUES (1,1,'Han Minh Chien','1995-01-10','123321','0987654321','chien@gmail.com','Quang Binh'),(2,1,'Tuong The Anh','1993-01-10','123321','0982354321','the@gmail.com','Quang Tri'),(3,3,'Koc Anh','2000-01-10','123321','043554321','anh@gmail.com','Da Nang'),(4,1,'Le Nguyen Dinh Phuc','1992-01-10','123321','0982344321','phuc@gmail.com','Hue');
/*!40000 ALTER TABLE `khach_hang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kieu_thue`
--

DROP TABLE IF EXISTS `kieu_thue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kieu_thue` (
  `id_kieu_thue` int NOT NULL AUTO_INCREMENT,
  `ten_kieu_thue` varchar(50) DEFAULT NULL,
  `gia` int DEFAULT NULL,
  PRIMARY KEY (`id_kieu_thue`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kieu_thue`
--

LOCK TABLES `kieu_thue` WRITE;
/*!40000 ALTER TABLE `kieu_thue` DISABLE KEYS */;
INSERT INTO `kieu_thue` VALUES (1,'Dai han',1000),(2,'Ngan han',500),(3,'Khong thoi han',0),(4,'1 Ngay',100);
/*!40000 ALTER TABLE `kieu_thue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_dich_vu`
--

DROP TABLE IF EXISTS `loai_dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_dich_vu` (
  `id_loai_dich_vu` int NOT NULL AUTO_INCREMENT,
  `ten_loai_dich_vu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_loai_dich_vu`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_dich_vu`
--

LOCK TABLES `loai_dich_vu` WRITE;
/*!40000 ALTER TABLE `loai_dich_vu` DISABLE KEYS */;
INSERT INTO `loai_dich_vu` VALUES (1,'Villa 1'),(2,'House 1'),(3,'Room 1');
/*!40000 ALTER TABLE `loai_dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_khach`
--

DROP TABLE IF EXISTS `loai_khach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_khach` (
  `id_loai_khach` int NOT NULL AUTO_INCREMENT,
  `ten_loai_khach` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_loai_khach`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_khach`
--

LOCK TABLES `loai_khach` WRITE;
/*!40000 ALTER TABLE `loai_khach` DISABLE KEYS */;
INSERT INTO `loai_khach` VALUES (1,'vip'),(2,'vip_pro'),(3,'dang_cap'),(4,'v_vip');
/*!40000 ALTER TABLE `loai_khach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `id_nhan_vien` int NOT NULL AUTO_INCREMENT,
  `ten_nhan_vien` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `cmnd` varchar(50) DEFAULT NULL,
  `luong` varchar(50) DEFAULT NULL,
  `sdt` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dia_chi` varchar(50) DEFAULT NULL,
  `id_vi_tri` int DEFAULT NULL,
  `id_trinh_do` int DEFAULT NULL,
  `id_bo_phan` int DEFAULT NULL,
  PRIMARY KEY (`id_nhan_vien`),
  KEY `id_vi_tri` (`id_vi_tri`),
  KEY `id_trinh_do` (`id_trinh_do`),
  KEY `id_bo_phan` (`id_bo_phan`),
  CONSTRAINT `nhan_vien_ibfk_1` FOREIGN KEY (`id_vi_tri`) REFERENCES `vi_tri` (`id_vi_tri`),
  CONSTRAINT `nhan_vien_ibfk_2` FOREIGN KEY (`id_trinh_do`) REFERENCES `trinh_do` (`id_trinh_do`),
  CONSTRAINT `nhan_vien_ibfk_3` FOREIGN KEY (`id_bo_phan`) REFERENCES `bo_phan` (`id_bo_phan`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (1,'Tran Van A','1995-01-10','123456789','10 trieu','09128445','A@abc.com','Quang Nam',1,1,1),(2,'Tran Van B','1998-01-11','123456789','1 trieu','09128445','A@abc.com','Quang Ngai',1,2,3),(3,'Tran Van C','2002-11-10','123456789','5 trieu','09128445','A@abc.com','Da Nang',2,2,3),(4,'Han Van C','2000-11-12','123456789','5 trieu','09128445','A@abc.com','Da Nang',1,3,2),(5,'Mran Van C','1995-01-10','123456789','5 trieu','09128445','A@abc.com','Da Nang',2,3,3);
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trinh_do`
--

DROP TABLE IF EXISTS `trinh_do`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trinh_do` (
  `id_trinh_do` int NOT NULL AUTO_INCREMENT,
  `trinh_do` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_trinh_do`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trinh_do`
--

LOCK TABLES `trinh_do` WRITE;
/*!40000 ALTER TABLE `trinh_do` DISABLE KEYS */;
INSERT INTO `trinh_do` VALUES (1,'Dai hoc'),(2,'Cao dang'),(3,'thpt');
/*!40000 ALTER TABLE `trinh_do` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vi_tri`
--

DROP TABLE IF EXISTS `vi_tri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vi_tri` (
  `id_vi_tri` int NOT NULL AUTO_INCREMENT,
  `ten_vi_tri` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_vi_tri`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vi_tri`
--

LOCK TABLES `vi_tri` WRITE;
/*!40000 ALTER TABLE `vi_tri` DISABLE KEYS */;
INSERT INTO `vi_tri` VALUES (1,'Le tan'),(2,'Phuc vu'),(3,'Bao ve');
/*!40000 ALTER TABLE `vi_tri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-04 11:32:23
