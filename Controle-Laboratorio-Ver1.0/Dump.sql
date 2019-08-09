-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lhmecatronica
-- ------------------------------------------------------
-- Server version	5.5.46

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
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS `bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bairro` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_BAIRRO` varchar(80) DEFAULT NULL,
  `TX_ENTREGA` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairro`
--

LOCK TABLES `bairro` WRITE;
/*!40000 ALTER TABLE `bairro` DISABLE KEYS */;
INSERT INTO `bairro` VALUES (1,'Retiro ',6.10),(2,'Santo Agostinho',12.00),(3,'Vila Brasília',8.30),(4,'Casa de Pedra',10.00),(5,'Água Limpa',10.00),(6,'Açude',12.20),(7,'Siderlândia',8.00),(8,'Jardim Amália',10.00),(9,'Vila Mury',8.00),(10,'Santa Cruz',12.00),(11,'Belmonte',9.00),(12,'São Luiz',12.00),(13,'Conforto',5.00),(14,'Aterrado',9.00),(15,'Eucaliptal',6.00),(16,'Três Poços',12.00),(17,'Padre Josimo',12.00),(18,'Vila Americana',12.00),(19,'Jardim Belvedere',5.00),(20,'Ponte Alta',4.00),(21,'Vila Santa Cecília',6.00),(22,'Monte Castelo',8.00),(23,'São Geraldo',9.00),(24,'Vila Rica',11.00),(25,'Brasilândia',9.00),(26,'Santa Rita do Zarur',25.00),(27,'Sessenta',8.00),(28,'São João',9.00),(29,'São Lucas',4.00),(30,'249',4.00),(31,'Dom Bosco',12.00),(32,'Santa Cruz II',15.00),(33,'Siderópolis',6.00),(34,'Barreira Cravo',8.00),(35,'Laranjal',6.00),(36,'Niterói',10.00),(37,'São Cristóvão',6.00),(38,'Belo Horizonte',5.00),(39,'Aero Clube',8.00),(40,'Voldac ',5.00),(41,'Candelária ',5.00),(42,'Jardim Belmonte',5.00),(43,'Nossa Senhora das Graças',8.00),(44,'Laranjal',5.00),(45,'Rústico',6.00),(46,'Jardim Europa',6.00),(47,'Bela Vista',6.00),(48,'Jardim Paraíba',5.00),(49,'São João Batista ',5.00),(50,'Pinto da Serra ',5.00),(51,'Jardim Suiça ',5.00),(52,'Vila Elmira',5.00),(53,'Morada da Granja I',5.00),(54,'Morada da Granja II',5.00),(55,'Minerlândia.',5.00),(56,'São Carlos',5.00),(57,'Santa Inês',5.00),(58,'Cajueiro',1.50),(59,'Jardim Ponte Alta (Morrão)',5.00),(60,'Mangueira ',5.00),(61,'Paraíso',5.00),(62,'Volta Grande I',5.00),(63,'Volta Grande II',5.00),(64,'Volta Grande III',5.00),(65,'Jardim Amália I',5.00),(66,'Jardim Amália II',5.00),(67,'Jardim Normandia',5.00),(68,'Morada da Colina',5.00),(69,'Mirante do Vale',5.00),(70,'Jardim Tancredo Neves',5.00),(71,'207',3.50),(72,'Boa Vista',5.00),(73,'Jardim Guanabara',8.00),(74,'9 de Abril',10.00),(75,'São Dudas Tadeu',10.00),(76,'Recanto do Sol',4.00),(77,'Limoeiro',6.00),(78,'Sidervile',8.00),(79,'Parque das Ilhas',11.00),(80,'208',4.20),(81,'Jardim Provence',9.00);
/*!40000 ALTER TABLE `bairro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_BAIRRO` int(11) DEFAULT NULL,
  `CPF` varchar(14) DEFAULT NULL,
  `NOME` varchar(45) DEFAULT NULL,
  `CEP` varchar(11) DEFAULT NULL,
  `LOGRADOURO` varchar(255) DEFAULT NULL,
  `NR` varchar(10) DEFAULT NULL,
  `COMPLEMENTO` varchar(45) DEFAULT NULL,
  `CIDADE` varchar(50) DEFAULT NULL,
  `UF` varchar(2) DEFAULT NULL,
  `PAIS` varchar(20) DEFAULT NULL,
  `FIXO` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `IDBAIRRO` int(11) DEFAULT NULL,
  `LOGRADROURO` varchar(255) DEFAULT NULL,
  `TELEFONE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK2ideh799w8dmbcb5nj93cuflx` (`IDBAIRRO`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,71,'215.585.658-66','Adriana da Silva Teles','27267450','Rua José Miguel','126','','Volta Redonda','RJ','Brasil','(24) 99999 - 5212','',0,NULL,NULL),(2,11,'222.256.333.99','Maria das Dores da Silva','27568223','Rua Jaquim Barbosa','1250','','Volta Redonda','RJ','Brasil','(24) 3652 - 5221','',0,NULL,NULL),(4,77,'222.658.987.96','Armando Torres','','Rua Valter Moore','57','','Volta Redonda','RJ','Brasil','(24) 3385 - 9585','',0,NULL,NULL),(6,14,'222.695.658.88','Thais','','Rua Luiz Alves Pereira','13','Apt. 301','Volta Redonda','RJ','Brasil','(24) 98995 - 6585','',0,NULL,NULL),(7,66,'111.555.666.99','Sabrina','','Rua Carlos Gomes','85','Apt. 909','Volta Redonda','RJ','Brasil','(24) 3356 - 2522','',0,NULL,NULL),(8,47,'222.65.985-65','Carolina','','Rua 19 C','15','Apt. 601','Volta Redonda','RJ','Brasil','(24) 3342 - 5685','',0,NULL,NULL),(9,24,'325.658.698-77','Debora','','Rua 43','112','Casa','Volta Redonda','RJ','Brasil','(24) 3356 - 8558','',0,NULL,NULL),(10,53,'325.698.569.66','Guilherme','','Rua José Moisés','860','Casa','Volta Redonda','RJ','Brasil','(24) 99956 - 2562','',0,NULL,NULL),(11,20,'254.698.985-66','Thais','','Rua Tirana','141','Casa','Volta Redonda','RJ','Brasil','(24) 3342 - 1066','',0,NULL,NULL),(12,40,'254.987.635.11','Carla','','Rua Cleopatra','246','Casa','Volta Redonda','RJ','Brasil','(24) 3358 - 6585','',0,NULL,NULL),(13,20,'222.695.658.88','Giulia','','Rua Roterdam','447','Casa','Volta Redonda','RJ','Brasil','(24) 99985 - 6523','',0,NULL,NULL),(15,80,'222.695.658.88','Tania','','Rua 208','12','Casa','Volta Redonda','RJ','Brasil','(24) 99935 - 0137','',0,NULL,NULL),(16,13,'254.987.635.11','Marcio','','Rua 220','66','Casa','Volta Redonda','RJ','Brasil','(24) 3385 - 6545','',0,NULL,NULL),(17,52,'215.585.658-66','Lilian','','Rua Manoel José da Silva','406','Casa','Volta Redonda','RJ','Brasil','(24) 99985 - 6325','3342-0849',0,NULL,NULL),(18,60,'222.695.658.88','Viviane','','Rua Rui Silveira Henriques','164','Casa','Barra Mansa','RJ','Brasil','(24) 99856 - 2522','99836-6182',0,NULL,NULL),(19,64,'215.585.658-66','David','','Rua 1586','85','Quadra 340 - Casa','Volta Redonda','RJ','Brasil','(24) 97256 - 3256','99973-3664',0,NULL,NULL),(21,56,'254.987.635.11','Priscila','','Rua Farias de Brito','244','Casa','Volta Redonda','RJ','Brasil','(24) 98754 - 2563','998692612',0,NULL,NULL),(22,76,'222.695.658.88','Daiane','','Rua 3','66','Casa','Barra Mansa','RJ','Brasil','(24) 98545 - 2512','',0,NULL,NULL),(23,68,'254.987.635.11','Igor','','Rua Vereador Fernando Mario Neto (antiga rua W)','151','Casa','Volta Redonda','RJ','Brasil','(24) 99956 - 6221','998550936',0,NULL,NULL),(24,13,'215.585.658-66','Taty Nobre','','Rua 243','22','Casa','Volta Redonda','RJ','Brasil','(24) 3658 - 5452','999617719',0,NULL,NULL),(26,21,'867.011.267-15','Luiz Henrique d','27267450','Rua José Miguel','126','Casa','Volta Redonda','RJ','Brasil','(24) 99954 - 4637','teste@teste.com.br',NULL,NULL,NULL),(27,71,'254.987.635.11','Entrega Bairro','','Av. Amaral peixoto','1080','Apt. 1025','Volta Redonda','RJ','Brasil','(24) 0000 - 0001','',NULL,NULL,NULL),(28,71,'215.585.658-66','Entrega Bairro','','','','','','','','(24) 0000 - 0001','',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componente`
--

DROP TABLE IF EXISTS `componente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componente` (
  `_idComponente` int(11) NOT NULL AUTO_INCREMENT,
  `_idEncapsulamento` int(11) DEFAULT NULL,
  `_idTipoComponente` int(11) DEFAULT NULL,
  `_idFabricante` int(11) DEFAULT NULL,
  `_idSimilaridade` int(11) DEFAULT NULL,
  `_CodigoComponente` varchar(45) DEFAULT NULL,
  `_Descricao` varchar(125) DEFAULT NULL,
  `_Fabricante` varchar(120) DEFAULT NULL,
  `_Encapsulamento` varchar(15) DEFAULT NULL,
  `_Gaveta` int(2) DEFAULT NULL,
  `_Divisao` int(2) DEFAULT NULL,
  `_Equivalente` int(4) DEFAULT NULL,
  `_PrecoCompra` double(11,2) DEFAULT NULL,
  `_PrecoVenda` double(11,2) DEFAULT NULL,
  PRIMARY KEY (`_idComponente`),
  KEY `fk_COMPONENTES_table11_idx` (`_idTipoComponente`),
  KEY `fk_COMPONENTES_COMPONENTE_FABRICANTE1_idx` (`_idFabricante`),
  KEY `fk_COMPONENTES_COMPONENTE_EMCAPSULAMENTO1_idx` (`_idEncapsulamento`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componente`
--

LOCK TABLES `componente` WRITE;
/*!40000 ALTER TABLE `componente` DISABLE KEYS */;
INSERT INTO `componente` VALUES (55,NULL,NULL,NULL,NULL,'30343','Multi-Drive reparo ECU','Bosch',' HSSOP-36',1,1,1,25.90,25.90),(56,NULL,NULL,NULL,NULL,'30402','Multi-Drive reparo ECU','Bosch',' HSSOP-36',1,1,1,22.30,30.63),(57,NULL,NULL,NULL,NULL,'30407','Multi-Drive reparo ECU','Bosch','PQFP-64',1,2,0,20.00,25.90),(58,NULL,NULL,NULL,NULL,' B58298','Processador ','Infineon','PLCC-84',1,3,0,25.90,25.90),(59,NULL,NULL,NULL,NULL,'40N06','Transistor Mosfet Canal N','Infineon','TO253',2,3,0,4.50,15.30),(60,NULL,NULL,NULL,NULL,'25N06','Transistor Mosfet Canal N','Infineon','TO253',2,4,0,5.36,15.80);
/*!40000 ALTER TABLE `componente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componente_encapsulamento`
--

DROP TABLE IF EXISTS `componente_encapsulamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componente_encapsulamento` (
  `_idEncapsulamento` int(11) NOT NULL AUTO_INCREMENT,
  `_encapsulamentoTipo` varchar(10) DEFAULT NULL,
  `_encapsulamentoFoto` varchar(125) DEFAULT NULL,
  `_encapsulamentoDescricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`_idEncapsulamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componente_encapsulamento`
--

LOCK TABLES `componente_encapsulamento` WRITE;
/*!40000 ALTER TABLE `componente_encapsulamento` DISABLE KEYS */;
INSERT INTO `componente_encapsulamento` VALUES (1,'PQFP-64',NULL,NULL),(2,'QFP-64',NULL,NULL),(3,'HSSOP-36',NULL,NULL);
/*!40000 ALTER TABLE `componente_encapsulamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componente_fabricante`
--

DROP TABLE IF EXISTS `componente_fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componente_fabricante` (
  `_idFabricante` int(11) NOT NULL AUTO_INCREMENT,
  `_fabricanteNome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`_idFabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componente_fabricante`
--

LOCK TABLES `componente_fabricante` WRITE;
/*!40000 ALTER TABLE `componente_fabricante` DISABLE KEYS */;
INSERT INTO `componente_fabricante` VALUES (1,'Bosch');
/*!40000 ALTER TABLE `componente_fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componente_tipo`
--

DROP TABLE IF EXISTS `componente_tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componente_tipo` (
  `_idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `_tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`_idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componente_tipo`
--

LOCK TABLES `componente_tipo` WRITE;
/*!40000 ALTER TABLE `componente_tipo` DISABLE KEYS */;
INSERT INTO `componente_tipo` VALUES (1,'Drive');
/*!40000 ALTER TABLE `componente_tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ecu_fabricante`
--

DROP TABLE IF EXISTS `ecu_fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ecu_fabricante` (
  `_idEcuFabricante` int(11) NOT NULL AUTO_INCREMENT,
  `_nome` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`_idEcuFabricante`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ecu_fabricante`
--

LOCK TABLES `ecu_fabricante` WRITE;
/*!40000 ALTER TABLE `ecu_fabricante` DISABLE KEYS */;
INSERT INTO `ecu_fabricante` VALUES (1,'Bosch'),(2,'Magnet Marelli'),(3,'Delphi');
/*!40000 ALTER TABLE `ecu_fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estoque` (
  `_idEstoque` int(11) NOT NULL AUTO_INCREMENT,
  `_idCompoenente` int(11) DEFAULT NULL,
  `_dataCompra` datetime DEFAULT NULL,
  `_precoCompra` double(11,2) DEFAULT NULL,
  `_idOS` int(11) DEFAULT NULL,
  `_dataVenda` datetime DEFAULT NULL,
  `_precoVenda` double(11,2) DEFAULT NULL,
  PRIMARY KEY (`_idEstoque`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,55,NULL,15.69,NULL,NULL,25.90),(2,55,NULL,15.69,NULL,NULL,25.90),(3,55,NULL,15.69,NULL,NULL,25.90),(4,56,NULL,12.80,NULL,NULL,28.30),(5,56,NULL,12.80,NULL,NULL,28.30),(6,56,NULL,12.80,NULL,NULL,28.30);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabricante`
--

DROP TABLE IF EXISTS `fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fabricante` (
  `_Id` int(11) NOT NULL AUTO_INCREMENT,
  `_Descricao` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricante`
--

LOCK TABLES `fabricante` WRITE;
/*!40000 ALTER TABLE `fabricante` DISABLE KEYS */;
INSERT INTO `fabricante` VALUES (1,'STMicroelectronics'),(2,' Infineon'),(3,'Philips'),(4,'Bosch');
/*!40000 ALTER TABLE `fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo` (
  `_idModulo` int(9) NOT NULL,
  `_idModuloFabricante` int(9) NOT NULL,
  `_codigoMotronic` varchar(45) DEFAULT NULL,
  `_Fabricante` varchar(45) DEFAULT NULL,
  `_Aplicação` varchar(45) DEFAULT NULL,
  `_Processador` varchar(45) DEFAULT NULL,
  `_DriveBico` varchar(45) DEFAULT NULL,
  `_DriveBobina` varchar(45) DEFAULT NULL,
  `_CorpoBorboleta` varchar(45) DEFAULT NULL,
  `_Acelerador` varchar(45) DEFAULT NULL,
  `_Regulador` varchar(45) DEFAULT NULL,
  `_CAN` varchar(45) DEFAULT NULL,
  `_Kline` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`_idModulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES (1,0,'5NF',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,0,'2.1 0.4','BOSCH','Marea 2.0 20v',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,0,'1. 7','MONO MOTRONIC ','Tipo 1 .6 IE 8v',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,0,'M E 7.9 .6','BOSCH','Palio 1. 3 1 6v',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,0,'M E 7.9 .9','BOSCH','Idea Flex / Pali o Flex',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,0,'HSFI -2.3','MOTRONIC','St ilo 1.8 16 v',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,0,'LE -Je t ro nic','LE -Je t ro nic','Uno 1.6 R',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,0,'4 AF B','MAGNET MARELLI','P alio 1.0 8 v Gasolina',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,0,'4CF','MAGNET MARELLI','U no / Pa lio',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,0,'4GF','MAGNET MARELLI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,0,'4DF','MAGNET MARELLI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,0,'4SD','MAGNET MARELLI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,0,'4SGF','MAGNET MARELLI',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,0,'49FB','MAGNET MARELLI','Pal io 1. 6 1 6v / Brava M area.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,0,'59F B','MAGNET MARELLI','Palio 1. 0 .',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,0,'IAW P 8 -','MAGNET MARELLI','Tipo 2 .0 8 v',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `montadora`
--

DROP TABLE IF EXISTS `montadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `montadora` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `_montadora` varchar(45) DEFAULT NULL,
  `_modelo` varchar(45) DEFAULT NULL,
  `_versao` varchar(45) DEFAULT NULL,
  `_calculador` varchar(45) DEFAULT NULL,
  `_bc` varchar(45) DEFAULT NULL,
  `_immo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `montadora`
--

LOCK TABLES `montadora` WRITE;
/*!40000 ALTER TABLE `montadora` DISABLE KEYS */;
INSERT INTO `montadora` VALUES (1,'GM','Onix','TL 1.0',NULL,NULL,NULL),(2,'GM','ONIX','LT 1.4',NULL,NULL,NULL),(3,'GM','ONIX','Advantage',NULL,NULL,NULL),(4,'GM','ONIX','LTZ 1.4',NULL,NULL,NULL),(5,'GM','ONIX','Effect',NULL,NULL,NULL),(6,'Fiat','Palio','Fire 1.0 8v',NULL,NULL,NULL),(7,'Fiat','Palio','ELX 1.0 8v',NULL,NULL,NULL),(8,'Fiat','Palio','ELX 1.4 8v',NULL,NULL,NULL),(9,'Fiat','Palio','HLX 1.8 8v',NULL,NULL,NULL);
/*!40000 ALTER TABLE `montadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oscorpo`
--

DROP TABLE IF EXISTS `oscorpo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oscorpo` (
  `_idOs` int(9) NOT NULL,
  `_idCliente` int(9) DEFAULT NULL,
  `_idMontadora` int(9) DEFAULT NULL,
  `_idModulo` int(9) DEFAULT NULL,
  `_dataOs` timestamp NULL DEFAULT NULL,
  `_dataEntrada` timestamp NULL DEFAULT NULL,
  `_dataOrcamento` timestamp NULL DEFAULT NULL,
  `_dataAutorizacao` timestamp NULL DEFAULT NULL,
  `_dataReparo` timestamp NULL DEFAULT NULL,
  `_dataGarantia` timestamp NULL DEFAULT NULL,
  `_anoVeiculo` varchar(4) DEFAULT NULL,
  `_codidoErro` varchar(255) DEFAULT NULL,
  `_defeito` text,
  PRIMARY KEY (`_idOs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oscorpo`
--

LOCK TABLES `oscorpo` WRITE;
/*!40000 ALTER TABLE `oscorpo` DISABLE KEYS */;
INSERT INTO `oscorpo` VALUES (10519,10,5,8,NULL,NULL,NULL,NULL,NULL,NULL,'2005','P0015','Não comunica com scanner'),(20519,16,8,15,NULL,NULL,NULL,NULL,NULL,NULL,'2010','Não Informado','Não tem pulos de bicos e bobinas'),(30519,2,1,1,NULL,NULL,NULL,NULL,NULL,NULL,'2000','P1015','Totalmente parado');
/*!40000 ALTER TABLE `oscorpo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ositens`
--

DROP TABLE IF EXISTS `ositens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ositens` (
  `_idOsCorpo` int(9) NOT NULL AUTO_INCREMENT,
  `_idOS` int(9) NOT NULL,
  `_idItens` int(9) DEFAULT NULL,
  `_idQtd` int(9) DEFAULT NULL,
  `_valorUnit` double DEFAULT NULL,
  `_valorTotal` double DEFAULT NULL,
  `_valorMOD` double DEFAULT NULL,
  PRIMARY KEY (`_idOsCorpo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ositens`
--

LOCK TABLES `ositens` WRITE;
/*!40000 ALTER TABLE `ositens` DISABLE KEYS */;
INSERT INTO `ositens` VALUES (21,1,4,1,100.25,0,0),(22,1,3,1,100.25,0,0),(23,1,9,2,100.25,0,0),(24,1,2,2,100.25,0,0),(25,1,12,1,100.25,0,0);
/*!40000 ALTER TABLE `ositens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'lhmecatronica'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-01 11:47:00
