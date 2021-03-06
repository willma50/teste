-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51a-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bdprojeto
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ bdprojeto;
USE bdprojeto;

--
-- Table structure for table `bdprojeto`.`agendavisita`
--

DROP TABLE IF EXISTS `agendavisita`;
CREATE TABLE `agendavisita` (
  `idVisita` int(11) NOT NULL auto_increment,
  `dataVisita` date NOT NULL default '0000-00-00',
  `horario` time NOT NULL default '00:00:00',
  `endereco` varchar(45) NOT NULL default '',
  `idCliente` int(10) unsigned default '0',
  PRIMARY KEY  (`idVisita`),
  KEY `FK_AgendaVisita_1` (`idCliente`),
  CONSTRAINT `FK_AgendaVisita_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`agendavisita`
--

/*!40000 ALTER TABLE `agendavisita` DISABLE KEYS */;
INSERT INTO `agendavisita` (`idVisita`,`dataVisita`,`horario`,`endereco`,`idCliente`) VALUES 
 (1,'1987-11-11','12:45:00','ttttttttttt',1),
 (2,'2009-08-09','12:00:00','sacramento',1),
 (4,'1987-11-11','12:30:00','111111111111111',3);
/*!40000 ALTER TABLE `agendavisita` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`cidade`
--

DROP TABLE IF EXISTS `cidade`;
CREATE TABLE `cidade` (
  `idCidade` int(11) NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`idCidade`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`cidade`
--

/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` (`idCidade`,`nome`) VALUES 
 (2,'Santo Amaro'),
 (3,'Salvador'),
 (4,'Feira de Santana'),
 (5,'Caculé'),
 (6,'Alagoinhas'),
 (7,'Salvador'),
 (8,'Salvador');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idcliente` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL default '',
  `sexo` char(1) NOT NULL default '',
  `cpf` varchar(20) NOT NULL default '',
  `dtnascimento` date default '0000-00-00',
  `cep` varchar(20) default '',
  `endereco` varchar(45) default '',
  `idcidade` int(11) default '0',
  PRIMARY KEY  (`idcliente`),
  KEY `FK_cliente_1` (`idcidade`),
  CONSTRAINT `FK_cliente_1` FOREIGN KEY (`idcidade`) REFERENCES `cidade` (`idCidade`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idcliente`,`nome`,`sexo`,`cpf`,`dtnascimento`,`cep`,`endereco`,`idcidade`) VALUES 
 (1,'Ana Maria','F',' 343535345 - 34','2009-11-11',' 23423 - 453','dtrtert',3),
 (2,'marcos ','M',' 353453456 - 34','2009-11-11',' 34245 - 235','ggdfggd',4),
 (3,'Margarida','F',' 565765768 - 76','2009-11-11',' 44444 - 444','terterter',6),
 (5,'Marcos Vinícios','M',' 356457567 - 65','1984-11-11',' 56645 - 454','frgttrfgtre',3);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`itemordemservico`
--

DROP TABLE IF EXISTS `itemordemservico`;
CREATE TABLE `itemordemservico` (
  `idItemOs` int(11) NOT NULL auto_increment,
  `idOs` int(11) default '0',
  `idServico` int(10) unsigned default '0',
  PRIMARY KEY  (`idItemOs`),
  KEY `FK_itemOrdemEServico_1` (`idOs`),
  KEY `FK_itemOrdemEServico_2` (`idServico`),
  CONSTRAINT `FK_itemOrdemEServico_1` FOREIGN KEY (`idOs`) REFERENCES `ordemservico` (`id_ordenServico`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_itemOrdemEServico_2` FOREIGN KEY (`idServico`) REFERENCES `servico` (`id_servico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`itemordemservico`
--

/*!40000 ALTER TABLE `itemordemservico` DISABLE KEYS */;
INSERT INTO `itemordemservico` (`idItemOs`,`idOs`,`idServico`) VALUES 
 (43,22,2),
 (44,20,27),
 (45,20,28);
/*!40000 ALTER TABLE `itemordemservico` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`itemordemservicopeca`
--

DROP TABLE IF EXISTS `itemordemservicopeca`;
CREATE TABLE `itemordemservicopeca` (
  `idItemPeca` int(10) unsigned NOT NULL auto_increment,
  `quantidade` int(11) default '0',
  `idpeca` int(11) default '0',
  `idItemOs` int(11) default '0',
  PRIMARY KEY  (`idItemPeca`),
  KEY `FK_itemPeca_2` (`idpeca`),
  KEY `FK_itemPeca_1` (`idItemOs`),
  CONSTRAINT `FK_itemordemservicopeca_1` FOREIGN KEY (`idpeca`) REFERENCES `peca` (`idpeca`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_itemordemservicopeca_2` FOREIGN KEY (`idItemOs`) REFERENCES `itemordemservico` (`idItemOs`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`itemordemservicopeca`
--

/*!40000 ALTER TABLE `itemordemservicopeca` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemordemservicopeca` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`ordemservico`
--

DROP TABLE IF EXISTS `ordemservico`;
CREATE TABLE `ordemservico` (
  `id_ordenServico` int(11) NOT NULL auto_increment,
  `data_abertura` date NOT NULL default '1500-01-01',
  `configuracao` text NOT NULL,
  `defeito` varchar(45) NOT NULL default '',
  `diagnostico` text,
  `valor` decimal(10,2) default NULL,
  `data_previsao` date default '1500-01-01',
  `data_conclusao` date default '1500-01-01',
  `data_fechamento` date default '1500-01-01',
  `status` varchar(45) NOT NULL default '',
  `idcliente` int(10) unsigned default NULL,
  `nserie` varchar(15) NOT NULL default '',
  PRIMARY KEY  (`id_ordenServico`),
  KEY `FK_ordemservico_1` (`idcliente`),
  CONSTRAINT `FK_ordemservico_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`ordemservico`
--

/*!40000 ALTER TABLE `ordemservico` DISABLE KEYS */;
INSERT INTO `ordemservico` (`id_ordenServico`,`data_abertura`,`configuracao`,`defeito`,`diagnostico`,`valor`,`data_previsao`,`data_conclusao`,`data_fechamento`,`status`,`idcliente`,`nserie`) VALUES 
 (20,'2009-11-11','dfdsfdsf','dfdsfds',NULL,NULL,'1500-01-01','1500-01-01','1500-01-01','aberta',1,'123'),
 (21,'2009-11-11','fdgfdgfd','fdfdgfd','fdgdfgdfgf',NULL,'2009-08-02','2009-08-11','1500-01-01','Aprovada',2,'012'),
 (22,'2009-11-11','sdasd','sdsd','asssss',NULL,'2009-11-11','2009-11-11','1500-01-01','Liberada',3,'abc');
/*!40000 ALTER TABLE `ordemservico` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
CREATE TABLE `pagamento` (
  `idpagamento` int(10) unsigned NOT NULL auto_increment,
  `tipoPagamento` varchar(30) NOT NULL default '',
  `totalvalor` decimal(10,2) NOT NULL default '0.00',
  `datapagamento` date NOT NULL default '0000-00-00',
  `idOs` int(11) default '0',
  PRIMARY KEY  (`idpagamento`),
  KEY `FK_pagamento_1` (`idOs`),
  CONSTRAINT `FK_pagamento_1` FOREIGN KEY (`idOs`) REFERENCES `ordemservico` (`id_ordenServico`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`pagamento`
--

/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`peca`
--

DROP TABLE IF EXISTS `peca`;
CREATE TABLE `peca` (
  `idpeca` int(11) NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL default '',
  `valor` decimal(10,2) NOT NULL default '0.00',
  PRIMARY KEY  (`idpeca`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`peca`
--

/*!40000 ALTER TABLE `peca` DISABLE KEYS */;
INSERT INTO `peca` (`idpeca`,`nome`,`valor`) VALUES 
 (1,'HD','100.00'),
 (2,'Memória','150.00'),
 (3,'cabo fleche','45.00'),
 (4,'fffffffff','44.00');
/*!40000 ALTER TABLE `peca` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`servico`
--

DROP TABLE IF EXISTS `servico`;
CREATE TABLE `servico` (
  `id_servico` int(10) unsigned NOT NULL auto_increment,
  `descricao` text NOT NULL,
  `valor` decimal(10,2) NOT NULL default '0.00',
  PRIMARY KEY  (`id_servico`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`servico`
--

/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` (`id_servico`,`descricao`,`valor`) VALUES 
 (1,'Troca de memória','100.00'),
 (2,'Instalação do serviço do Sistema Operacional','200.00'),
 (3,'Troca de hd','200.00'),
 (18,'Limpeza do gabinete','30.00'),
 (19,'formatação','35.00'),
 (20,'instalação do so','20.00'),
 (25,'Trocar driver dvd','120.00'),
 (27,'TROCAR MEMORIA','80.00'),
 (28,'TROCAR DRIVER DVD/CD','40.00');
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;


--
-- Table structure for table `bdprojeto`.`telefone`
--

DROP TABLE IF EXISTS `telefone`;
CREATE TABLE `telefone` (
  `id_telefone` int(11) NOT NULL auto_increment,
  `tipo` varchar(15) default '',
  `numero` varchar(20) NOT NULL default '',
  `idcliente` int(10) unsigned default '0',
  PRIMARY KEY  (`id_telefone`),
  KEY `FK_telefone_1` (`idcliente`),
  CONSTRAINT `FK_telefone_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdprojeto`.`telefone`
--

/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
INSERT INTO `telefone` (`id_telefone`,`tipo`,`numero`,`idcliente`) VALUES 
 (6,'FIXO',' (54) 6456 - 4564 ',1),
 (7,'CELULAR',' (45) 6456 - 4564 ',1),
 (8,'FIXO',' (56) 3645 - 6456 ',2),
 (9,'CELULAR',' (45) 6456 - 4564 ',2),
 (10,'FIXO',' (53) 4543 - 5345 ',3);
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;


--
-- View structure for view `bdprojeto`.`visao`
--

DROP VIEW IF EXISTS `visao`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bdprojeto`.`visao` AS select `o`.`id_ordenServico` AS `id_ordenservico`,`o`.`status` AS `status`,`s`.`descricao` AS `Serviço`,`s`.`valor` AS `valor`,`o`.`data_abertura` AS `data_abertura` from ((`bdprojeto`.`ordemservico` `o` join `bdprojeto`.`itemordemservico` `i` on((`i`.`idOs` = `o`.`id_ordenServico`))) join `bdprojeto`.`servico` `s` on((`s`.`id_servico` = `i`.`idServico`))) group by `o`.`id_ordenServico`,`o`.`status`,`s`.`descricao`;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
