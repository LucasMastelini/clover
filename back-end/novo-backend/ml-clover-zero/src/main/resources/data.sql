INSERT INTO categoria (nome) VALUES
('Animes'),
('Filmes'),
('Séries'),
('Desenhos'),
('Jogos');


INSERT INTO subcategoria (nome, categoria_id) VALUES
('One Piece', 1),
('Naruto', 1),
('Attack on Titan', 1),
('O Senhor dos Aneis', 2),
('Star Wars', 2),
('Dark', 3),
('Breaking Bad', 3),
('Ricky And Morty', 4),
('BoJack Horseman', 4),
('Red Dead Redemption 2', 5),
('God Of War Ragnarok', 5);


INSERT INTO tamanho VALUES
('P'),
('M'),
('G'),
('GG'),
('XG'),
('XGG');

INSERT INTO cor VALUES
('#FFFFFF', 'Branco'),
('#008000', 'Verde'),
('#0000FF', 'Azul'),
('#FF0000', 'Vermelho'),
('#000000', 'Preto'),
('#D58E1A', 'Bege'),
('#FF66B7', 'Rosa'),
('#28064B', 'Azul Marinho');

INSERT INTO produto (nome, preco, subtitulo, descricao) VALUES
('CAMISETA ONE PIECE CHIBI', 65.90, 'Os chapéus de palha de um jeito que se acomodam melhor no coração', 'A amizade é um dos valores mais importantes. Se você não sabe cozinhar, navegar ou até mesmo mentir, seus amigos são forças complementares que tornam a sua vida uma aventura! Você não precisa partir em uma jornada para encontrar um tesouro, pois a qualidade dessa estampa serigrafada em tecido de algodão, com os personagens que você ama de forma tão adorável, são um pequeno tesouro valoroso o bastante para você sempre guardar no coração.'),
('CAMISETA NARUTO - AVENGER SASUKE', 75.90, 'A escuridão do vingador Uchiha', 'Sasuke trilhou o caminho das trevas. Ele é um vingador disposto a descontar as feridas que o mundo deixou em seu coração e em seus olhos poderosos. Para isso, Konoha deve perecer! Ao vestir essa camiseta feita de tecido poliéster, você não precisa temer ao ser dominado pelo espírito da vingança. O conforto do tecido e sua resistência, a qual inclui a estampa serigrafada, faz da vingança um sentimento mais sedutor do que você imagina…'),
('MOLETOM NARUTO - MISSÃO JOUNIN', 139.90, 'Chega de amadorismo. Hora de missões avançadas, com estilo!', 'Chegou o momento de subir de nível. Ninjas amadores não podem ser dignos de herdar a vontade do fogo. Seu traje simboliza onde o seu coração está, e carrega sua força para combater. É por isso que esse tecido poliéster fibroso e persistente contra amassaduras irá te revestir com durabilidade e segurança contra o frio para te honrar como um verdadeiro Jounin!'),
('NARUTO - A PRIMAVERA DE SAKURA', 75.90, 'O vento primaveril corta a paisagem transbordando folhas de cerejeira, concedendo a momentos da vida suavidade e força merecidas.', 'Quando as cerejeiras caem em Konoha, pode-se apreciar de longe ternura e beleza que se sobressaem na paisagem poderosamente, destacando a força e a sensibilidade que emanam da alma de uma mulher. Sakura personifica a alma da primavera, além de toda a classe de uma ninja médica inteligente. Essa camiseta de algodão, confortável e suave, exala a essência da discípula de Tsunade, aliando feminilidade com o poder visual capaz de destacar uma mulher valorosa como você.'),
('ATTACK ON TITAN - A FÚRIA DE EREN', 75.90, 'O ódio que motiva a liberdade além das muralhas tem estilo e estampa.', 'O grito de liberdade de Eren pulsando no seu peito (você vai até declamar em alto e bom tom: SASAGEYO)! Camiseta serigrafada com estampa titânica e tecido em algodão, resistente a dobras. Não existem muralhas que podem te impedir de viver esse mundo colossal com o estilo que você merece.');

INSERT INTO produto_tamanho (produto_id, tamanho_id) VALUES
(1, 'P'),
(1, 'M'),
(1, 'G'),
(1, 'GG'),
(1, 'XG'),
(1, 'XGG'),

(2, 'P'),
(2, 'M'),
(2, 'G'),

(3, 'P'),
(3, 'M'),
(3, 'G'),
(3, 'GG'),

(4, 'P'),
(4, 'M'),

(5, 'P'),
(5, 'M');

INSERT INTO produto_categoria (categoria_id, produto_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5);

INSERT INTO produto_subcategoria (produto_id, subcategoria_id) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 3);

INSERT INTO produto_cor (cor_id, produto_id) VALUES
('#28064B', 1),
('#000000', 2),
('#D58E1A', 3),
('#FF66B7', 4),
('#000000', 5);


INSERT INTO imagens VALUES
(1, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669944888043_162051-800-auto.jpg'),
(1, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669945259207_162052-800-auto.jpg'),
(2, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669943862667_04.jpg'),
(2, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669944631055_sasuke-back.jpg'),
(3, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669945717351_01.jpg'),
(3, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669945727681_02.jpg'),
(4, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669946422975_159757-800-auto.jpg'),
(4, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669946516739_159758-800-auto.jpg'),
(5, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669946979746_165518-800-auto.jpg'),
(5, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669946990883_165519-800-auto.jpg'),
(5, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669947002427_165520-800-auto.jpg'),
(5, 'https://cloverstorages.s3.us-east-2.amazonaws.com/1669947013862_165521-800-auto.jpg');



INSERT INTO LOCALIDADE_CEP (cep, logradouro, complemento, bairro, cidade, uf, tipo_logradouro, id_usuario_ins, dt_usuario_ins, st_ativo, latitude, longitude) VALUES
('01002900', 'Viaduto do Chá 15', '', 'Centro', 'São Paulo', 'SP', '', '0', '2022-09-23 14:38:01', '1', '-23.5472091', '-46.6370514'),
('01003901', 'Rua José Bonifácio 93', '', 'Sé', 'São Paulo', 'SP', '', '0', '2022-09-23 14:38:01', '1', '-23.6624011', '-46.6366836'),
('09854690', 'Pau Brasil', '(Jd Pinheiros)', 'Alvarenga', 'São Bernardo do Campo', 'SP', 'Rua', '0', '2022-09-23 14:38:01', '1', '-23.7604539', '-46.5984107');