create schema Bibliotech;
use bibliotech;


create table `categoria`(
`idCategoria` varchar(45),
PRIMARY KEY (`idCategoria`));

--
-- Table structure for table `aluno`
--

CREATE TABLE `aluno` (
  `idAluno` int(11) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Data de Nascimento` varchar(45) NOT NULL,
  `Curso` varchar(45) NOT NULL,
  PRIMARY KEY (`idAluno`));


CREATE TABLE `universidade` (
  `idUniversidade` int(11) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idUniversidade`));

--
-- Table structure for table `biblioteca`
--

CREATE TABLE `biblioteca` (
  `idBiblioteca` varchar(11) NOT NULL,
  `Nome` varchar(11) NOT NULL,
  `idUniversidade` int(11),
  PRIMARY KEY (`idBiblioteca`),
  KEY `fk_biblioteca_Universidade_idx`(`idUniversidade`),
  CONSTRAINT `fk_biblioteca_Universidade` FOREIGN KEY (`idUniversidade`) REFERENCES `universidade` (`idUniversidade`));

  
  
  --
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `password` varchar(45) NOT NULL,
  `cargo` tinyint NOT NULL,
  PRIMARY KEY (`idUser`));
  
  
--
-- Table structure for table `livros`
--
  
  CREATE TABLE `livros` (
  `Titulo` varchar(100) NOT NULL,
  `Autor` varchar(100) NOT NULL,
  `Editora` varchar(100) NOT NULL,
  `Língua` varchar(44) NOT NULL,
  `ISBN` varchar(13) NOT NULL,
  `Codigo_de_barras` varchar(10) NOT NULL,
  `Data de Publicação` varchar(20) NOT NULL,
  `Descrição` varchar(700) DEFAULT NULL,
  `idCategoria` varchar(45) NOT NULL,
  `idBiblioteca` varchar(11) NOT NULL,
  `Reservado` tinyint not null,
  PRIMARY KEY (`Codigo_de_barras`,`idBiblioteca`),
  UNIQUE KEY `Codigo_de_barras_UNIQUE` (`Codigo_de_barras`),
  KEY `fk_Livros_Biblioteca_idx` (`idBiblioteca`),
  KEY `fk_Livros_Categoria_idx` (`idCategoria`),
  CONSTRaint `fk_Livros_Categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`),
  CONSTRAINT `fk_Livros_Biblioteca` FOREIGN KEY (`idBiblioteca`) REFERENCES `biblioteca` (`idbiblioteca`));
  
  
--
-- Table structure for table `requisito`
--

/*CREATE TABLE `requisito` (
  `idUser` int(11) NOT NULL,
  `ISBN` varchar(13) NOT NULL,
  `idBiblioteca` varchar(11) NOT NULL,
  `Data de Requisição` varchar(10) NOT NULL,
  `Data de Entrega` varchar(10) NOT NULL,
  PRIMARY KEY (`idUser`,`ISBN`,`idBiblioteca`),
  KEY `fk_User_has_Livros_Livros2_idx` (`ISBN`),
  KEY `fk_User_has_Livros_User2_idx` (`idUser`),
  KEY `fk_Requisito_Biblioteca1_idx` (`idBiblioteca`),
  CONSTRAINT `fk_Requisito_Biblioteca1` FOREIGN KEY (`idBiblioteca`) REFERENCES `biblioteca` (`idbiblioteca`),
  CONSTRAINT `fk_User_has_Livros_Livros2` FOREIGN KEY (`ISBN`) REFERENCES `livros` (`ISBN`),
  CONSTRAINT `fk_User_has_Livros_User2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`));
  */
--
-- Table structure for table `reserva`
-- 
  
CREATE TABLE `reserva` (
  `idUser` int(11) NOT NULL,
  `Codigo_de_barras` varchar(13) NOT NULL,
  `idBiblioteca` varchar(11) NOT NULL,
  `DataLevantamento` varchar(40) NOT NULL,
  `Prazo_Maximo` varchar(45) NOT NULL,
  PRIMARY KEY (`Codigo_de_barras`),
  KEY `fk_User_has_Livros_Livros1_idx` (`Codigo_de_barras`),
  KEY `fk_User_has_Livros_User1_idx` (`idUser`),
  KEY `fk_Reserva_Biblioteca1_idx` (`idBiblioteca`),
  CONSTRAINT `fk_Reserva_Biblioteca1` FOREIGN KEY (`idBiblioteca`) REFERENCES `biblioteca` (`idbiblioteca`),
  CONSTRAINT `fk_User_has_Livros_Livros1` FOREIGN KEY (`Codigo_de_barras`) REFERENCES `livros` (`Codigo_de_barras`),
  CONSTRAINT `fk_User_has_Livros_User1` FOREIGN KEY (`idUser`) REFERENCES `user` (`iduser`));

--
-- Table structure for table `staff`
--
  
  CREATE TABLE `staff` (
  `idStaff` int(11) NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Data de Nascimento` varchar(45) NOT NULL,
  `Cargo` varchar(45) DEFAULT NULL);

--
-- Table structure for table `universidade`
--


  





  