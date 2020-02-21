use bibliotech;

--
-- Dumping data for table `categoria`
--
insert into `categoria` Values (1, 'Arte'), (2, 'Arquitetura'), (3, 'Botânica'),(4, 'Ciências'),(5, 'Comunicação Social'),(6, 'Design'),(7, 'Dicionários'),(8, 'Economia'),
				(9, 'Educação'),(10, 'Empreendorismo'),(11, 'Filosofia'),(12, 'Fotografia'),(13, 'Gestão'),(14, 'História'),(15, 'Ilustração'),
				(16, 'Informática'),(17, 'Marketing'),(18, 'Matemática'),(19, 'Política'),(20, 'Psicologia'),(21, 'Religião'),(22, 'Sociologia'),(23, 'Urbanismo'), (24, 'Ficção');
           
           
 --
-- Dumping data for table `linguas`
--       
insert into `linguas` Values (1, 'pt'), (2, 'en-us'), (3, 'en-uk'),(4, 'pl'),(5, 'de'),(6, 'br'),(7, 'rus'),(8, 'es'),
				(9, 'zh'),(10, 'fr'), (11, 'gk'), (12, 'ita');
                
                
--
-- Dumping data for table `colecoes`
--            
insert into `colecoes` Values (1, 'Harry Potter'), (2, 'Game of Thrones'), (3, 'Lord of the Rings');
			
            
--
-- Dumping data for table `biblioteca`
--
INSERT INTO `estados` VALUES (1,'NOVO'),(2,'USADO'), (3, 'MUITO USADO');            
            
            
-- Dumping data for table `aluno`
--

INSERT INTO `aluno` VALUES (50037,'Diogo Santos','15/3/1997','EI'),(50037177,'Hugo Varela','21/09/1998','EI'),(50037564,'João Cardo','19/04/1996','EI');


--
-- Dumping data for table `universidade`
--
INSERT INTO `universidade` VALUES (1,'EUROPEIA'), (2, 'NOVA');


--
-- Dumping data for table `biblioteca`
--
INSERT INTO `biblioteca` VALUES (1,'IADE', 1),(2,'LISPOLIS',1),(3,'BOM NOME',1), (4, 'FCT',2), (5, 'SBE',2);


--
-- Dumping data for table `user`
--

INSERT INTO `user` VALUES (1,'admin',0),(2,'teste',0),(316,'798',1),(50037564,'123',1);


--
-- Dumping data for table `staff`
--
INSERT INTO `staff` VALUES (123,'Maria Luiza','25/06/1980','Professora'),(126,'Luiza Maria','25/06/1960','Bar'),(158,'Manel da Silva','25/06/1975','Porteiro'),(316,'Francisco Otavio','25/06/1980','Biblioteca'),(260,'João Maria','25/06/1980','Reitor');


--
-- Dumping data for table `titulos`
--
INSERT INTO `titulos` VALUES 
('How to Draw','"Design Studio Press"','"Bukupedia "','9781933492735','2013-06-13','Drawing is almost a magical power. It enables you to communicate in a different way than spoken or written language. Perspective drawing lets you convey how things work and how they look.',1,2,NULL),
('How To Render','"Scott Robertson","Thomas Bertling"','','9781933492964','2014-05-21','"Explains how the human brain interprets the visual world around us, as well as the subject of visually communicating the form of an object in easy to understand lessons through the use of drawings, photography, and more."',1,2,NULL),
('The Little Know-It-All','"Silja Bilz","Robert Klanten","Michael Mischler"','"Gestalten"','9783899555431','2015-02-15','This updated edition of Gestaltens popular reference book gives designers practical answers to questions related to their daily work.',6,2,NULL),
('Ecological Intelligence','"Daniel Goleman"','"Penguin UK"','9780141039091','2010-04-17','"Although we all want to help the environment, our knowledge of what are green choices is often so limited that we can do more harm than good. But now a new phenomenon radical transparency, the availability of complete information about all aspects of a products history',5,2,NULL),
('Critical Design in Context','"Matt Malpass"','"Bloomsbury Publishing"','9781472575173','2017-02-23','Machine generated contents note: -- Chapter 1: Introducing critical design -- Challenging orthodoxy -- Challenging colloquialism: the problem with critical design -- Whats so critical about critical design practice -- Why study critical design? ',4,2,NULL),
('Harry Potter and the Philosofers Stone','"J.K. Rowling"','"Pottermore Publishing"','9781781100219','2015-12-08','"On Harrys eleventh birthday, a great beetle-eyed giant of a man called Rubeus Hagrid bursts in with some astonishing news: Harry Potter is a wizard, and he has a place at Hogwarts School of Witchcraft and Wizardry. An incredible adventure is about to begin!"',24,3,1),
('Harry Potter and the Goblet of Fire','"J.K. Rowling"','"Pottermore Publishing"','9781781100523','2015-12-08','"There will be three tasks, spaced throughout the school year, and they will test the champions in many different ways ... their magical prowess - their daring - their powers of deduction - and, of course, their ability to cope with danger. The Triwizard Tournament is to be held at Hogwarts. Only wizards who are over seventeen are allowed to enter"',24,3,1),
('A Game of Thrones','"George R. R. Martin"','"Bantam Books"','9780553573404','1997-04-11','A Clash of Kings and A Storm of Swords. As a whole, this series comprises a genuine masterpiece of modern fantasy, bringing together the best the genre has to offer.',24,2,2),
('A Game of Thrones vol.2','"George R. R. Martin"','"Bantam Books"','9780440423225','2013-10-01','Now, in the second volume, the sweeping action moves from the icy north, where the bastard Jon Snow seeks to carve out a place for himself among bitter outcasts and hardened criminals sworn to service upon the Wall . . . to the decadent south and the capital city of Kings Landing, where Jons father, Lord Eddard Stark, serves as the Hand of King Robert Baratheon amid a nest of courtly vipers . . . to the barbarian lands across the Narrow Sea, where the young princess Daenerys Targaryen has found the unexpected in her forced marriage to the Dothraki warlord Khal Drogo: love--and with it, for the first time in her life, power.',24,2,2);


--
-- Dumping data for table `edicoes`
--
INSERT INTO `edicoes` VALUES (1,3,'Bukupedia',500,2013,'California','9781933492735'),
							 (2,1,'Penguin UK',489,2010, 'Colorado','9780141039091'),
                             (3,1,'Bloomsbury Publishing',619,2017, 'New York','9781472575173'),
                             (4,8,'Pottermore Publishing',362,2015, 'London','9781781100219'),
							 (5,10,'Pottermore Publishing',389,2015, 'London','9781781100523'),
                             (6,12,'Pottermore Publishing',353,2015, 'London','9781781100219'),
                             (7,14,'Pottermore Publishing',353,2015, 'London','9781781100219'),
                             (8,1,'Bantam Books',853,1997, 'Cardiff','9780553573404'),
                             (9,7,'Bantam Books', 347,2013, 'Cardiff','9780440423225');


--
-- Dumping data for table `exemplares`
--
INSERT INTO `exemplares` VALUES(3846,0,0,1,1,1), 
								(3847,0,9,1,2,3),
								(3848,0,0,1,3,2),
                                (3849,0,0,1,4,4),
                                (3850,0,0,1,5,4), 
                                (3851,0,0,1,6,1), 
                                (3852,0,0,1,7,2), 
                                (3853,0,0,1,7,4), 
                                (3854,0,29,2,8,5), 
                                (3855,0,0,1,9,5);


-- 
-- Dumping data for table `reserva`
-- 

INSERT INTO `reserva` VALUES(1,'2019-01-25','2019-01-28',3847,'9780141039091',1,1),
							(2,'2019-01-24','2019-01-28',3848,'9781472575173',1,1),
							(3,'2019-01-26','2019-01-28',3850,'9781781100523',1,1);




