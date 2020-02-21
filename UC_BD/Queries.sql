--
-- Queries
--


--
-- Apresentar livros sem coleção
--
SELECT * FROM Titulos WHERE ISNULL(colecoes_idcolecoes);


--
-- Apresentar livros cujo nome comece por "How"
--
SELECT * FROM Titulos WHERE Titulo LIKE 'How%';


--
-- Apresentar livros com "and" no nome
--
SELECT * FROM Titulos WHERE Titulo LIKE '%and%';

--
-- Queries para o trigger
--
INSERT INTO `reserva` VALUES(4,'2019-01-22','2019-01-28',3846,'9781933492735',1,1);
DELETE from reserva where idreservas = 4;

DELETE from reserva where idreservas = 1;

-- exemplar do harry potter
INSERT INTO `reserva` VALUES(4,'2019-01-22','2019-01-28',3849,'9781781100219',4,1);
DELETE from reserva where idreservas = 4;


--
-- Retirar aspas da editora
--
SET SQL_SAFE_UPDATES = 0;
UPDATE Titulos SET Editora =substr(Editora, 2, length(Editora) - 2);
SET SQL_SAFE_UPDATES = 1;
SELECT * FROM Titulos;


-- 
-- INNER JOIN 
--
SELECT T.titulo AS 'Título', X.codigoBarras AS 'Código de Barras', B.Nome as 'Biblioteca', CASE WHEN X.Reservado = 1 THEN 'Sim' ELSE 'Não' END as 'Reservado', X.NrReservas AS 'Número de Reservas', E.estado AS 'Estado do Livro', D.nrEdicao AS 'Edição Número'
FROM estados AS E INNER JOIN exemplares AS X ON E.idEstado = X.estados_idEstado INNER JOIN biblioteca AS B ON X.biblioteca_idBiblioteca = B.idbiblioteca INNER JOIN edicoes AS D ON X.edicoes_idedicoes = D.idedicoes  INNER JOIN titulos AS T ON T.ISBN = D.titulos_ISBN WHERE X.CodigoBarras  = 3849;

SELECT T.titulo as 'Nome', E.nrEdicao as 'Número da Edição', C.colecaoTitulo as 'Nome da Coleção', B.Nome as 'Biblioteca', CASE WHEN X.Reservado = 1 THEN 'Sim' ELSE 'Não' END as 'Reservado', X.codigoBarras as 'Código de Barras'
FROM titulos AS T INNER JOIN edicoes AS E ON T.ISBN = E.titulos_ISBN INNER JOIN exemplares AS X ON E.idedicoes = X.edicoes_idedicoes LEFT JOIN colecoes AS C ON C.idcolecoes = T.colecoes_idcolecoes INNER JOIN biblioteca as B ON B.idbiblioteca = X.biblioteca_idBiblioteca ORDER BY B.Nome, E.nrEdicao;

SELECT  C.colecaoTitulo AS 'Nome da Coleção', COUNT(T.Titulo) AS 'Número de Títulos'
FROM colecoes AS C LEFT JOIN titulos AS T ON C.idcolecoes = T.colecoes_idcolecoes GROUP BY C.colecaotitulo;

SELECT T.titulo AS 'Título', B.Nome as 'Biblioteca', X.NrReservas AS 'Número de Reservas', E.estado AS 'Estado do Livro', D.nrEdicao AS 'Edição Número'
FROM estados AS E INNER JOIN exemplares AS X ON E.idEstado = X.estados_idEstado INNER JOIN biblioteca AS B ON X.biblioteca_idBiblioteca = B.idbiblioteca INNER JOIN edicoes AS D ON X.edicoes_idedicoes = D.idedicoes  INNER JOIN titulos AS T ON T.ISBN = D.titulos_ISBN WHERE X.reservado = 0 ORDER BY B.Nome, T.Titulo;


--
-- QUERY QUE MOSTRA A DURAÇÃO DAS RESERVAS
--

SELECT R.user_iduser as 'Utilizador', T.Titulo as 'Título', R.exemplares_codigoBarras as 'Codigo de Barras', R.exemplares_titulos_ISBN AS 'ISBN',
        CONCAT(R.prazo_maximo - R.datalevantamento ,' dias') as 'Duração da Reserva' FROM reserva as R INNER JOIN titulos as T ON R.exemplares_titulos_ISBN = T.ISBN ;



--
-- FUNCAO QUE RETORNA O NR DE RESERVAS NUM DIA ESPECIFICADO
--

SELECT getNRReservas(24) AS 'Nr de Reservas';
SELECT getNRReservas(25) AS 'Nr de Reservas';

--
-- PROCEDURE QUE RETORNA O NR DE RESRVAS DO DIA ATUAL
--

call getReservas();


