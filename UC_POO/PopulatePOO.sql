
insert into `categoria` Values ('Arte'), ('Arquitetura'), ('Botânica'),('Ciências'),('Comunicação Social'),('Design'),('Dicionários'),('Economia'),
				('Educação'),('Empreendorismo'),('Filosofia'),('Fotografia'),('Gestão'),('História'),('Ilustração'),
				('Informática'),('Marketing'),('Matemática'),('Política'),('Psicologia'),('Religião'),('Sociologia'),('Urbanismo');
--
-- Dumping data for table `aluno`
--

INSERT INTO `aluno` VALUES (50037,'Diogo Santos','15/3/1997','EI'),(50037177,'Hugo Varela','12/12/1997','EI'),(50037564,'João Cardo','19/04/1996','EI');

--
-- Dumping data for table `biblioteca`
--
INSERT INTO `universidade` VALUES (0,'DEFAULT'),(1,'EUROPEIA');

INSERT INTO `biblioteca` VALUES ('TODOS','TODOS',0),('IADE','IADE', 1),('LIS','LISPOLIS',1),('BN','BOM_NOME',1);


--
-- Dumping data for table `user`
--

INSERT INTO `user` VALUES (1,'admin',0),(2,'teste',0),(316,'798',1),(50037564,'123',1);




--
-- Dumping data for table `livros`
--

-- id, titulo, autor, editora, lingua, isbn, codigo de barras, data de publicaçao, descriçao, genero, idbiblioteca 
 
INSERT INTO `livros` VALUES 
('How to Draw','"Design Studio Press"','"Bukupedia "','EN','9781933492735','BN-8752','"2013-06-13"','Drawing is almost a magical power. It enables you to communicate in a different way than spoken or written language. Perspective drawing lets you convey how things work and how they look.','Design','IADE',0),
('How To Render','"Scott Robertson","Thomas Bertling"','','EN','9781933492964','BN-5455','2014','"Explains how the human brain interprets the visual world around us, as well as the subject of visually communicating the form of an object in easy to understand lessons through the use of drawings, photography, and more."','Arte','LIS',0),
('The Little Know-It-All','"Silja Bilz","Robert Klanten","Michael Mischler"','"Gestalten"','EN','9783899555431','3','2015-02-15','This updated edition of Gestaltens popular reference book gives designers practical answers to questions related to their daily work.','Design','BN',0),
('Ecological Intelligence','"Daniel Goleman"','"Penguin UK"','EN','9780141039091','4','2010','"Although we all want to help the environment, our knowledge of what are green choices is often so limited that we can do more harm than good. But now a new phenomenon radical transparency, the availability of complete information about all aspects of a products history','Ciências','IADE',0),
('Critical Design in Context','"Matt Malpass"','"Bloomsbury Publishing"','EN','9781472575173','5','2017-02-23','Machine generated contents note: -- Chapter 1: Introducing critical design -- Challenging orthodoxy -- Challenging colloquialism: the problem with critical design -- Whats so critical about critical design practice -- Why study critical design? ','Design','LIS',0);

--
-- Dumping data for table `requisito`
--

-- INSERT INTO `requisito` VALUES (1,'9781933492735','IADE','19/3/2018','23/3/2018'),(2,'9780141039091','LIS','27/8/2019','29/9/2019');


--
-- Dumping data for table `staff`
--

INSERT INTO `staff` VALUES (123,'Maria Luiza','25/06/1980','Professora'),(126,'Luiza Maria','25/06/1960','Bar'),(158,'Manel da Silva','25/06/1975','Porteiro'),(316,'Francisco Otavio','25/06/1980','Biblioteca'),(260,'João Maria','25/06/1980','Reitor');



--
-- Dumping data for table `universidade`
--




--
-- Dumping data for table `reserva`
--

-- INSERT INTO `reserva` VALUES (2,'BN-5455',2,'15/12/2018','20/12/2018');



