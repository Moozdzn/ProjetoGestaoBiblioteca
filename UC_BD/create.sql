

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bibliotech
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bibliotech
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bibliotech` ;

-- -----------------------------------------------------
-- Table `bibliotech`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`aluno` (
  `idAluno` INT(11) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Data de Nascimento` VARCHAR(45) NOT NULL,
  `Curso` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAluno`));


-- -----------------------------------------------------
-- Table `bibliotech`.`universidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`universidade` (
  `idUniversidade` INT(11) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUniversidade`));


-- -----------------------------------------------------
-- Table `bibliotech`.`biblioteca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`biblioteca` (
  `idBiblioteca` INT NOT NULL,
  `Nome` VARCHAR(11) NOT NULL,
  `universidade_idUniversidade` INT(11) NOT NULL,
  PRIMARY KEY (`idBiblioteca`, `universidade_idUniversidade`),
  INDEX `fk_biblioteca_universidade1_idx` (`universidade_idUniversidade` ASC) VISIBLE,
  CONSTRAINT `fk_biblioteca_universidade1`
    FOREIGN KEY (`universidade_idUniversidade`)
    REFERENCES `bibliotech`.`universidade` (`idUniversidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `bibliotech`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`categoria` (
  `idCategoria` INT(2) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCategoria`));


-- -----------------------------------------------------
-- Table `bibliotech`.`linguas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`linguas` (
  `idlinguas` INT NOT NULL,
  `linguas` VARCHAR(45) NULL,
  PRIMARY KEY (`idlinguas`));


-- -----------------------------------------------------
-- Table `bibliotech`.`colecoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`colecoes` (
  `idcolecoes` INT NOT NULL,
  `colecaoTitulo` VARCHAR(45) NULL,
  PRIMARY KEY (`idcolecoes`));


-- -----------------------------------------------------
-- Table `bibliotech`.`titulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`titulos` (
  `Titulo` VARCHAR(100) NOT NULL,
  `Autor` VARCHAR(100) NOT NULL,
  `Editora` VARCHAR(100) NOT NULL,
  `ISBN` VARCHAR(13) NOT NULL,
  `dataPublicacao` DATE NULL DEFAULT NULL,
  `Descrição` VARCHAR(700) NULL DEFAULT NULL,
  `categoria_idCategoria` INT(2) NOT NULL,
  `linguas_idlinguas` INT(11) NOT NULL,
  `colecoes_idcolecoes` INT(11) NULL,
  PRIMARY KEY (`ISBN`),
  INDEX `fk_titulos_categoria1_idx` (`categoria_idCategoria` ASC) VISIBLE,
  INDEX `fk_titulos_linguas1_idx` (`linguas_idlinguas` ASC) VISIBLE,
  INDEX `fk_titulos_colecoes1_idx` (`colecoes_idcolecoes` ASC) VISIBLE,
  CONSTRAINT `fk_titulos_categoria1`
    FOREIGN KEY (`categoria_idCategoria`)
    REFERENCES `bibliotech`.`categoria` (`idCategoria`),
  CONSTRAINT `fk_titulos_colecoes1`
    FOREIGN KEY (`colecoes_idcolecoes`)
    REFERENCES `bibliotech`.`colecoes` (`idcolecoes`),
  CONSTRAINT `fk_titulos_linguas1`
    FOREIGN KEY (`linguas_idlinguas`)
    REFERENCES `bibliotech`.`linguas` (`idlinguas`));


-- -----------------------------------------------------
-- Table `bibliotech`.`edicoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`edicoes` (
  `idedicoes` INT NOT NULL,
  `nrEdicao` INT(2) NULL,
  `editora` VARCHAR(45) NULL,
  `nrPaginas` INT(4) NULL,
  `ano` INT(4) NULL,
  `local` VARCHAR(45) NULL,
  `titulos_ISBN` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`idedicoes`, `titulos_ISBN`),
  INDEX `fk_edicoes_titulos1_idx` (`titulos_ISBN` ASC) VISIBLE,
  CONSTRAINT `fk_edicoes_titulos1`
    FOREIGN KEY (`titulos_ISBN`)
    REFERENCES `bibliotech`.`titulos` (`ISBN`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `bibliotech`.`estados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`estados` (
  `idEstado` INT(1) NOT NULL,
  `estado` VARCHAR(45) DEFAULT 1,
  PRIMARY KEY (`idEstado`));



-- -----------------------------------------------------
-- Table `bibliotech`.`exemplares`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`exemplares` (
  `codigoBarras` INT(4) NOT NULL,
  `reservado` BIT(1) NULL DEFAULT NULL,
  `NrReservas` INT(11) NOT NULL,
  `estados_idEstado` INT(1) NOT NULL DEFAULT 1,
  `edicoes_idedicoes` INT(11) NOT NULL,
  `biblioteca_idBiblioteca` INT(11) NOT NULL,
  PRIMARY KEY (`codigoBarras`, `edicoes_idedicoes`, `estados_idEstado`, `biblioteca_idBiblioteca`),
  INDEX `fk_exemplares_edicoes1_idx` (`edicoes_idedicoes` ASC) VISIBLE,
  INDEX `fk_exemplares_estados` (`estados_idEstado` ASC) VISIBLE,
  INDEX `fk_exemplares_biblioteca1_idx` (`biblioteca_idBiblioteca` ASC) VISIBLE,
  CONSTRAINT `fk_exemplares_edicoes1`
    FOREIGN KEY (`edicoes_idedicoes`)
    REFERENCES `bibliotech`.`edicoes` (`idedicoes`),
  CONSTRAINT `fk_exemplares_estados`
    FOREIGN KEY (`estados_idEstado`)
    REFERENCES `bibliotech`.`estados` (`idEstado`),
  CONSTRAINT `fk_exemplares_biblioteca1`
    FOREIGN KEY (`biblioteca_idBiblioteca`)
    REFERENCES `bibliotech`.`biblioteca` (`idBiblioteca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `bibliotech`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`user` (
  `idUser` INT(11) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `cargo` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idUser`));


-- -----------------------------------------------------
-- Table `bibliotech`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`reserva` (
  `idreservas` INT(10) NOT NULL,
  `DataLevantamento` DATE NOT NULL,
  `Prazo_Maximo` DATE NOT NULL,
  `exemplares_codigoBarras` INT(11) NOT NULL,
  `exemplares_titulos_ISBN` VARCHAR(13) NOT NULL,
  `biblioteca_idBiblioteca` INT NOT NULL,
  `user_idUser` INT(11) NOT NULL,
  PRIMARY KEY (`idreservas`),
  INDEX `fk_User_has_Livros_Livros1_idx` (`idreservas` ASC) VISIBLE,
  INDEX `fk_reserva_exemplares1_idx` (`exemplares_codigoBarras` ASC, `exemplares_titulos_ISBN` ASC) VISIBLE,
  INDEX `fk_reserva_biblioteca1_idx` (`biblioteca_idBiblioteca` ASC) VISIBLE,
  INDEX `fk_reserva_user1_idx` (`user_idUser` ASC) VISIBLE,
  UNIQUE INDEX `exemplares_codigoBarras_UNIQUE` (`exemplares_codigoBarras` ASC) VISIBLE,
  CONSTRAINT `fk_reserva_biblioteca1`
    FOREIGN KEY (`biblioteca_idBiblioteca`)
    REFERENCES `bibliotech`.`biblioteca` (`idBiblioteca`),
  CONSTRAINT `fk_reserva_exemplares1`
    FOREIGN KEY (`exemplares_codigoBarras`)
    REFERENCES `bibliotech`.`exemplares` (`codigoBarras`),
  CONSTRAINT `fk_reserva_user1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `bibliotech`.`user` (`idUser`));


-- -----------------------------------------------------
-- Table `bibliotech`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bibliotech`.`staff` (
  `idStaff` INT(11) NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Data de Nascimento` VARCHAR(45) NOT NULL,
  `Cargo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idStaff`));
  
-- -------------------------- TRIGGERS -------------------------- --
  
  DROP TRIGGER IF EXISTS `bibliotech`.`reserva_AFTER_INSERT`;

DELIMITER $$
USE `bibliotech`$$
CREATE DEFINER = CURRENT_USER TRIGGER `bibliotech`.`reserva_AFTER_INSERT` AFTER INSERT ON `reserva` FOR EACH ROW
BEGIN
	SET SQL_SAFE_UPDATES=0;
	UPDATE exemplares SET nrreservas=(SELECT nrreservas WHERE codigobarras = NEW.exemplares_codigoBarras) + 1, reservado = 1 WHERE codigoBarras = NEW.exemplares_codigoBarras;
	SET SQL_SAFE_UPDATES=1;
END$$
DELIMITER ;
DROP TRIGGER IF EXISTS `bibliotech`.`reserva_AFTER_DELETE`;

DELIMITER $$
USE `bibliotech`$$
CREATE DEFINER = CURRENT_USER TRIGGER `bibliotech`.`reserva_AFTER_DELETE` AFTER DELETE ON `reserva` FOR EACH ROW
BEGIN
	SET SQL_SAFE_UPDATES=0;
    UPDATE exemplares set reservado = 0 where codigoBarras = OLD.exemplares_codigoBarras;
	IF (SELECT nrreservas from exemplares where CodigoBarras = OLD.exemplares_codigobarras) = 10 THEN
		UPDATE exemplares set estados_idEstado = 2 where CodigoBarras = OLD.exemplares_codigobarras;
	ELSEIF (SELECT nrreservas from exemplares where CodigoBarras = OLD.exemplares_codigobarras) = 30 THEN
		UPDATE exemplares set estados_idEstado = 3 where CodigoBarras = OLD.exemplares_codigobarras; 
	END IF ;
	SET SQL_SAFE_UPDATES=1;
END$$
DELIMITER ;



--
-- PROCEDURE QUE RETORNA O NR DE RESRVAS DO DIA ATUAL
--

DELIMITER //
DROP PROCEDURE IF EXISTS getReservas //
CREATE PROCEDURE getReservas ()
	BEGIN
		CREATE TEMPORARY TABLE TemporaryTable SELECT * FROM reserva where DAY(datalevantamento) = day(sysdate());
		ALTER TABLE TemporaryTable DROP COLUMN datalevantamento;
		SELECT * FROM TemporaryTable; 
		DROP TABLE TemporaryTable;
	END
//
DELIMITER ;



--
-- FUNCAO QUE RETORNA O NR DE RESERVAS NUM DIA ESPECIFICADO
--

DELIMITER //
DROP FUNCTION IF EXISTS getNRReservas //
CREATE FUNCTION getNRReservas (param varchar(2))
	RETURNS INT
    DETERMINISTIC
    BEGIN
		DECLARE nrReservas INT(2);
			SELECT COUNT(*) INTO nrReservas from reserva where DAY(datalevantamento) = param;
			IF (nrReservas IS NULL) THEN
			SET nrReservas = 0;
			END IF;
		RETURN nrReservas;  
	END
//
DELIMITER ; 