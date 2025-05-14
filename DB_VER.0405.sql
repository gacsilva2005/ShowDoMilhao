-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sakila
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sakila
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `poligenio` ;
USE `poligenio` ;

-- -----------------------------------------------------
-- Table `sakila`.`Administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Administrador` (
  `id_administrador` INT NOT NULL,
  `nome_administrador` VARCHAR(60) NOT NULL,
  `email_administrador` VARCHAR(60) NOT NULL,
  `especialidade` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_administrador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`Jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Jogador` (
  `id_jogador` INT NOT NULL,
  `nome_jogador` VARCHAR(60) NOT NULL,
  `serie_jogador` INT NOT NULL,
  `email_jogador` VARCHAR(60) NOT NULL,
  `Administrador_id_administrador` INT NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_jogador`),
  INDEX `fk_Jogador_Administrador1_idx` (`Administrador_id_administrador` ASC),
  CONSTRAINT `fk_Jogador_Administrador1`
    FOREIGN KEY (`Administrador_id_administrador`)
    REFERENCES `poligenio`.`Administrador` (`id_administrador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`Sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Sala` (
  `id_sala` INT NOT NULL,
  `checkpoint` TINYINT(1) NOT NULL,
  `código_sala` INT NOT NULL,
  `dicas` TINYINT(1) NOT NULL DEFAULT 0,
  `objetivo` TEXT(60) NOT NULL,
  `alternativa` VARCHAR(100) NOT NULL,
  `id_administrador` INT NOT NULL,
  PRIMARY KEY (`id_sala`),
  INDEX `fk_Sala_Administrador1_idx` (`id_administrador` ASC),
  CONSTRAINT `fk_Sala_Administrador1`
    FOREIGN KEY (`id_administrador`)
    REFERENCES `poligenio`.`Administrador` (`id_administrador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`Ranking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Ranking` (
  `id_ranking` INT NOT NULL AUTO_INCREMENT,
  `pontuacao_total` TINYINT(3) NOT NULL,
  `Jogador_id_jogador` INT NOT NULL,
  `Sala_id_sala` INT NOT NULL,
  PRIMARY KEY (`id_ranking`),
  INDEX `fk_Ranking_Jogador1_idx` (`Jogador_id_jogador` ASC),
  INDEX `fk_Ranking_Sala1_idx` (`Sala_id_sala` ASC),
  CONSTRAINT `fk_Ranking_Jogador1`
    FOREIGN KEY (`Jogador_id_jogador`)
    REFERENCES `poligenio`.`Jogador` (`id_jogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ranking_Sala1`
    FOREIGN KEY (`Sala_id_sala`)
    REFERENCES `poligenio`.`Sala` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`Dificuldade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Dificuldade` (
  `id_Dificuldade` INT NOT NULL,
  `Dificuldade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_Dificuldade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`Matéria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Matéria` (
  `id_Matéria` INT NOT NULL,
  `Matéria` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_Matéria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`Serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Serie` (
  `id_Serie` INT NOT NULL AUTO_INCREMENT,
  `Serie` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_Serie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`PerguntasCriadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`PerguntasCriadas` (
  `id_Pergunta` INT NOT NULL AUTO_INCREMENT,
  `Alternativa` VARCHAR(60) NOT NULL,
  `id_sala` INT NOT NULL,
  `id_Dificuldade` INT NOT NULL,
  `id_Matéria` INT NOT NULL,
  `id_Serie` INT NOT NULL,
  PRIMARY KEY (`id_Pergunta`),
  INDEX `fk_Pergunta_Sala1_idx` (`id_sala` ASC),
  INDEX `fk_Pergunta_Dificuldade1_idx` (`id_Dificuldade` ASC),
  INDEX `fk_Pergunta_Matéria1_idx` (`id_Matéria` ASC),
  INDEX `fk_PerguntasCriadas_Serie1_idx` (`id_Serie` ASC),
  CONSTRAINT `fk_Pergunta_Sala1`
    FOREIGN KEY (`id_sala`)
    REFERENCES `poligenio`.`Sala` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pergunta_Dificuldade1`
    FOREIGN KEY (`id_Dificuldade`)
    REFERENCES `poligenio`.`Dificuldade` (`id_Dificuldade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pergunta_Matéria1`
    FOREIGN KEY (`id_Matéria`)
    REFERENCES `poligenio`.`Matéria` (`id_Matéria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PerguntasCriadas_Serie1`
    FOREIGN KEY (`id_Serie`)
    REFERENCES `poligenio`.`Serie` (`id_Serie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`AlternativasCriadas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`AlternativasCriadas` (
  `id_alternativasCriadas` INT NOT NULL AUTO_INCREMENT,
  `texto_alternativaCriada` TINYINT(1) NOT NULL,
  `respostaCriada` TINYINT(1) NOT NULL,
  `id_Pergunta` INT NOT NULL,
  PRIMARY KEY (`id_alternativasCriadas`),
  INDEX `fk_AlternativasCriadas_Pergunta1_idx` (`id_Pergunta` ASC),
  CONSTRAINT `fk_AlternativasCriadas_Pergunta1`
    FOREIGN KEY (`id_Pergunta`)
    REFERENCES `poligenio`.`PerguntasCriadas` (`id_Pergunta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`Configurações`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Configurações` (
  `id_configurações` INT NOT NULL,
  `audio` TINYINT(1) NOT NULL,
  `Sala_id_sala` INT NOT NULL,
  PRIMARY KEY (`id_configurações`),
  INDEX `fk_Configurações_Sala1_idx` (`Sala_id_sala` ASC),
  CONSTRAINT `fk_Configurações_Sala1`
    FOREIGN KEY (`Sala_id_sala`)
    REFERENCES `poligenio`.`Sala` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`pontuacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`pontuacao` (
  `id_pontuacao` INT NOT NULL,
  `acertos` TINYINT(1) NOT NULL,
  `Sala_id_sala` INT NOT NULL,
  `Jogador_id_jogador` INT NOT NULL,
  `pontos` SMALLINT(5) NOT NULL,
  `tipo_pergunta` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_pontuacao`),
  INDEX `fk_pontuação_Sala1_idx` (`Sala_id_sala` ASC),
  INDEX `fk_pontuação_Jogador1_idx` (`Jogador_id_jogador` ASC),
  CONSTRAINT `fk_pontuação_Sala1`
    FOREIGN KEY (`Sala_id_sala`)
    REFERENCES `poligenio`.`Sala` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pontuação_Jogador1`
    FOREIGN KEY (`Jogador_id_jogador`)
    REFERENCES `poligenio`.`Jogador` (`id_jogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`PerguntasRandom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`PerguntasRandom` (
  `id_perguntasRandom` INT NOT NULL,
  `texto_pergunta` VARCHAR(100) NOT NULL,
  `id_sala` INT NOT NULL,
  `Serie_id_Serie` INT NOT NULL,
  PRIMARY KEY (`id_perguntasRandom`),
  INDEX `fk_perguntas_generalizadas_Sala1_idx` (`id_sala` ASC),
  INDEX `fk_PerguntasRandom_Serie1_idx` (`Serie_id_Serie` ASC),
  CONSTRAINT `fk_perguntas_generalizadas_Sala1`
    FOREIGN KEY (`id_sala`)
    REFERENCES `poligenio`.`Sala` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PerguntasRandom_Serie1`
    FOREIGN KEY (`Serie_id_Serie`)
    REFERENCES `poligenio`.`Serie` (`id_Serie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`AlternativasRandom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`AlternativasRandom` (
  `id_alternativasRandom` INT NOT NULL,
  `texto_alternativa` VARCHAR(100) NOT NULL,
  `resposta` TINYINT(1) NOT NULL,
  `id_perguntasRandom` INT NOT NULL,
  PRIMARY KEY (`id_alternativasRandom`),
  INDEX `fk_AlternativasRandom_PerguntasRandom1_idx` (`id_perguntasRandom` ASC),
  CONSTRAINT `fk_AlternativasRandom_PerguntasRandom1`
    FOREIGN KEY (`id_perguntasRandom`)
    REFERENCES `poligenio`.`PerguntasRandom` (`id_perguntasRandom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`timestamps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`timestamps` (
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `sakila`.`Dica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Dica` (
  `id_Dica` INT NOT NULL AUTO_INCREMENT,
  `tipo_pergunta` VARCHAR(45) NOT NULL,
  `id_alternativasCriadas` INT NOT NULL,
  `id_alternativasRandom` INT NOT NULL,
  PRIMARY KEY (`id_Dica`),
  INDEX `fk_Dica_AlternativasCriadas1_idx` (`id_alternativasCriadas` ASC),
  INDEX `fk_Dica_AlternativasRandom1_idx` (`id_alternativasRandom` ASC),
  CONSTRAINT `fk_Dica_AlternativasCriadas1`
    FOREIGN KEY (`id_alternativasCriadas`)
    REFERENCES `poligenio`.`AlternativasCriadas` (`id_alternativasCriadas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dica_AlternativasRandom1`
    FOREIGN KEY (`id_alternativasRandom`)
    REFERENCES `poligenio`.`AlternativasRandom` (`id_alternativasRandom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sakila`.`Sala_has_Jogador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `poligenio`.`Sala_has_Jogador` (
  `Sala_id_sala` INT NOT NULL,
  `Jogador_id_jogador` INT NOT NULL,
  PRIMARY KEY (`Sala_id_sala`, `Jogador_id_jogador`),
  INDEX `fk_Sala_has_Jogador_Jogador1_idx` (`Jogador_id_jogador` ASC),
  INDEX `fk_Sala_has_Jogador_Sala1_idx` (`Sala_id_sala` ASC),
  CONSTRAINT `fk_Sala_has_Jogador_Sala1`
    FOREIGN KEY (`Sala_id_sala`)
    REFERENCES `poligenio`.`Sala` (`id_sala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sala_has_Jogador_Jogador1`
    FOREIGN KEY (`Jogador_id_jogador`)
    REFERENCES `poligenio`.`Jogador` (`id_jogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO jogador (id_jogador, nome_jogador, serie_jogador, email_jogador, Administrador_id_administrador, senha)
VALUES
(1, 'Gabriel', 9, 'email@testeALUNO.com', 1, '25007758');
INSERT INTO administrador (id_administrador, nome_administrador, email_administrador, especialidade, senha)
VALUES
(1, 'Victor', 'email@testePROFESSOR.com', 'Python', '25008657');
SELECT * FROM jogador;
SELECT * FROM administrador;