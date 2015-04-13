-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pizzeriaweb
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Table structure for table `itens_pedido`
--

DROP TABLE IF EXISTS `itens_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itens_pedido` (
  `id_itens_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL,
  `valor_item` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_itens_pedido`),
  KEY `pedidoID_idx` (`id_pedido`),
  KEY `FKC65363A52161DF86` (`id_itens_pedido`),
  CONSTRAINT `pedidoID` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='Cadastro de itens do pedido - pizzeriaweb';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_pedido`
--

LOCK TABLES `itens_pedido` WRITE;
/*!40000 ALTER TABLE `itens_pedido` DISABLE KEYS */;
INSERT INTO `itens_pedido` VALUES (31,37,11.40),(32,38,11.40),(33,114,15.00),(34,115,18.00),(35,115,7.00),(36,115,17.00),(37,116,21.90);
/*!40000 ALTER TABLE `itens_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COMMENT='Cadastro de pedidos - pizzeriaweb';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (33),(37),(38),(58),(63),(71),(73),(81),(82),(83),(84),(114),(115),(116);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_produto` int(11) NOT NULL,
  `descricao_produto` varchar(100) NOT NULL,
  `valor_produto` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='Cadastro de produtos - pizzeriaweb';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (13,1,'Margueritta',26.90),(14,1,'Calabreza',15.00),(15,1,'Quatro Queijos',17.00),(16,1,'Baiana',16.00),(17,1,'Mussarela',15.00),(18,1,'Toscana',17.00),(19,1,'Rucula',28.50),(20,1,'Siciliana',21.90),(21,2,'Antartica Original',11.00),(22,2,'Coca Cola 2L',7.00),(23,2,'Agua Mineral',4.00),(24,2,'Guarana 2L',7.00),(25,3,'Bolo Morango',6.00),(26,3,'Mousse Chocolate',5.00),(27,3,'Sorvete 1L',18.00),(28,1,'Parma',34.50);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subitens_pedido`
--

DROP TABLE IF EXISTS `subitens_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subitens_pedido` (
  `id_subitens_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_itens_pedido` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  KEY `itensPedidoID_idx` (`id_itens_pedido`),
  KEY `produtoID_idx` (`id_produto`),
  KEY `FKAC69C1E5BF6EEDCD` (`id_subitens_pedido`),
  CONSTRAINT `itensPedidoID` FOREIGN KEY (`id_itens_pedido`) REFERENCES `itens_pedido` (`id_itens_pedido`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `produtoID` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id_produto`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='Cadastro de subitens do pedido - pizzeriaweb';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subitens_pedido`
--

LOCK TABLES `subitens_pedido` WRITE;
/*!40000 ALTER TABLE `subitens_pedido` DISABLE KEYS */;
INSERT INTO `subitens_pedido` VALUES (14,31,13),(15,32,13),(16,33,17),(17,33,17),(18,33,17),(19,33,17),(20,34,27),(21,35,22),(22,36,16),(23,36,14),(24,36,18),(25,36,15),(26,37,17),(27,37,18),(28,37,20),(29,37,18);
/*!40000 ALTER TABLE `subitens_pedido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-12 22:32:18
