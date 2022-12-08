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
('#28064B', 'Azul Marinho'),
('#6390EA', 'Azul'),
('#1358EE', 'Azul'),
('#32C442', 'Verde'),
('#F7FA07', 'Amarelo'),
('#FA3707', 'Vermelho'),
('#00A4CE', 'Azul'),
('#06760F', 'Verde'),
('#011046', 'Cinza'),
('#014606', 'Preto'),
('#E4E4E4', 'Verde'),
('#D8D6D6', 'Cinza'),
('#D60C0C', 'Vermelho'),
('#9E022F', 'Vermelho'),
('#00045F', 'Azul'),
('#679F58', 'Verde'),
('#C5C5C8', 'Cinza'),
('#DCD9D9', 'Cinza');

INSERT INTO produto (nome, preco, subtitulo, descricao) VALUES
('CAMISETA ONE PIECE CHIBI', 65.90, 'Os chapéus de palha de um jeito que se acomodam melhor no coração', 'A amizade é um dos valores mais importantes. Se você não sabe cozinhar, navegar ou até mesmo mentir, seus amigos são forças complementares que tornam a sua vida uma aventura! Você não precisa partir em uma jornada para encontrar um tesouro, pois a qualidade dessa estampa serigrafada em tecido de algodão, com os personagens que você ama de forma tão adorável, são um pequeno tesouro valoroso o bastante para você sempre guardar no coração.'),
('CAMISETA NARUTO - AVENGER SASUKE', 75.90, 'A escuridão do vingador Uchiha', 'Sasuke trilhou o caminho das trevas. Ele é um vingador disposto a descontar as feridas que o mundo deixou em seu coração e em seus olhos poderosos. Para isso, Konoha deve perecer! Ao vestir essa camiseta feita de tecido poliéster, você não precisa temer ao ser dominado pelo espírito da vingança. O conforto do tecido e sua resistência, a qual inclui a estampa serigrafada, faz da vingança um sentimento mais sedutor do que você imagina…'),
('MOLETOM NARUTO - MISSÃO JOUNIN', 139.90, 'Chega de amadorismo. Hora de missões avançadas, com estilo!', 'Chegou o momento de subir de nível. Ninjas amadores não podem ser dignos de herdar a vontade do fogo. Seu traje simboliza onde o seu coração está, e carrega sua força para combater. É por isso que esse tecido poliéster fibroso e persistente contra amassaduras irá te revestir com durabilidade e segurança contra o frio para te honrar como um verdadeiro Jounin!'),
('NARUTO - A PRIMAVERA DE SAKURA', 75.90, 'O vento primaveril corta a paisagem transbordando folhas de cerejeira, concedendo a momentos da vida suavidade e força merecidas.', 'Quando as cerejeiras caem em Konoha, pode-se apreciar de longe ternura e beleza que se sobressaem na paisagem poderosamente, destacando a força e a sensibilidade que emanam da alma de uma mulher. Sakura personifica a alma da primavera, além de toda a classe de uma ninja médica inteligente. Essa camiseta de algodão, confortável e suave, exala a essência da discípula de Tsunade, aliando feminilidade com o poder visual capaz de destacar uma mulher valorosa como você.'),
('ATTACK ON TITAN - A FÚRIA DE EREN', 75.90, 'O ódio que motiva a liberdade além das muralhas tem estilo e estampa.', 'O grito de liberdade de Eren pulsando no seu peito (você vai até declamar em alto e bom tom: SASAGEYO)! Camiseta serigrafada com estampa titânica e tecido em algodão, resistente a dobras. Não existem muralhas que podem te impedir de viver esse mundo colossal com o estilo que você merece.'),
('CALÇA STAR WARS - JEDI ORDER', 65.90, 'A força e o conforto sempre com você.', 'Em uma galáxia muito, muito distante… um grupo de Jedis luta para restabelecer a paz. E você foi convocado! Mas você não deixaria de receber tal honraria sem um visual apropriado, certo? Essa calça moletom, tecida em algodão, cai bem com botas e outras peças de roupa mais despojadas. Só cuidado para não deixar seus companheiros Jedi com inveja…'),
('CAMISETA STAR WARS - SIDES', 80.90, 'Não é apenas a força que tem dois lados. Você pode escolher um para se vestir.', 'Kenobi. Yoda. Leia. Chewbacca. Mais que nomes: lendas que resistem ao tempo. A cronologia de Star Wars no seu peito, de duas formas diferentes! Camiseta dupla face, com os personagens que fascinam seu imaginário e com as obras cinematográficas cronológicas que permitiram você se fascinar. Tudo em tecido algodão confortável e respirável.'),
('HARRY POTTER - MOLETOM CORVINA', 154.90, ' Sabedoria, inteligência, classe e intelecto. Um conjunto de quatro palavras que se torna mais grandioso com um toque mágico de estilo.', 'Hogwarts valoriza as mentes brilhantes. E a Clover te fornece a oportunidade de ser um autêntico corvinal até mesmo no estilo! O nosso feitiço consiste em um moletom de algodão que vai aquecer seu corpo e coração, com estampa serigrafada de alta qualidade. E o toque final de mágica é como você vai se sentir estiloso(a).'),
('HARRY POTTER - MOLETOM SONSERINA', 154.90, 'Astúcia, destreza, liderança e ambição. Quatro palavras imponentes demais para pessoas tolas e de gosto pífio como os Weasleys…', 'Charme e elegância para te destacar em Hogwarts como um líder de valor. A pureza do sangue é reforçada com a nobreza que carrega a arte de estar bem apresentável no mundo mágico. Quem são os míseros mortais, afinal, diante desse moletom em algodão com estampa de qualidade serigráfica que a Clover pode te proporcionar?'),
('HARRY POTTER - MOLETOM LUFA-LUFA', 154.90, 'Solidariedade, lealdade, dedicação e honestidade. Quatro palavras para desfrutar um mundo melhor em um estilo agradável e comedido.', 'Você pode apreciar a vida como um feiticeiro modesto, sem pretensões grandiosas. Afinal, muito do aprendizado e dos valores essenciais estão nos momentos solenes. A moda pode te ajudar a apreciar a vida com leveza, irradiando o sol onde você passa. Se fizer isso revestido de um tecido de algodão confortável, carregando no peito a sua casa favorita serigrafada, é melhor ainda.'),
('HARRY POTTER - MOLETOM GRIFINÓRIA', 154.90, 'Coragem, ousadia, cavalheirismo e bravura. Quatro palavras que destacam um verdadeiro nobre. Que tal requintar o visual para elevar sua notoriedade?', 'Tecido aconchegante de algodão com estampa serigráfica e capuz rubros, dignos de um Grifinório. A linhagem sanguínea não diz nada sobre quem você é, mas, de certo, o seu estilo em Hogwarts pode transparecer muita coisa…'),
('CAMISETA ONE PIECE - CHOPPER STYLE', 122.90, 'O médico dos mugiwara quer afofurar o seu cotidiano.', 'Não existe algodão doce que seja tão fofo quanto o Chopper. Nem algodão tão confortável quanto o tecido dessa camiseta, que protagoniza o médico mais icônico dos animes de maneira digital e serigráfica.'),
('CAMISETA ONE PIECE - SANTORYUU ZORO', 104.30, 'Quem ousará mexer contigo quando ver o combatente mais casca grossa dos chapéus de palha no seu peito?', 'Zoro é como um imediato para os chapéus de palha. Ele não teme a dor e está disposto a proteger seus amigos, sem receios de retalhar quem precisar para isso. Ao vestir essa camiseta poliéster com estampa serigráfica, considere-a seu amuleto de proteção!'),
('CAMISETA ONE PIECE - MUGIWARAS WANTED', 79.60, 'Os mugiwara estão sendo procurados. Com essa camiseta, você vai chamar bastante a atenção da Marinha. Quem sabe, Luffy não te recruta?', 'As recompensas aumentaram. Já não é de hoje que a Marinha está de olho nos chapéus de palha. Mas, um fã não faz silêncio de quem gosta, não é mesmo? Você nem vai fazer questão de disfarçar com essa camiseta de tecido poliéster, com  serigrafia dos piratas mais amados do mundo!'),
('CAMISETA ONE PIECE - DESTINY BROTHERS', 79.60, 'Não é preciso partilhar um elo sanguíneo. Ao longo da vida,  acumulamos amigos que partilham conosco um elo de irmandade… e o mesmo gosto para moda!', 'Essa camiseta dupla face, com tecido em algodão de alta qualidade, é perfeita para você viver momentos nerd com seus melhores amigos. Seus laços de amizade ganharão força simbólica ao carregar no peito o profundo elo entre Luffy, Ace e Sabo.'),
('CAMISETA NARUTO - NINE TAILS', 79.60, 'Hora da batalha! Esse moletom é tão foda que parece revestido com o chakra da famosa raposa de nove caudas.', 'O famoso ninja de cabelo loiro possui dentro de si um poder avassalador. Em batalha, poucos podem contra a Kyuubi. Moletom de tecido em algodão, respirável e com estampa serigráfica feito para te motivar a transcender os limites de poder com o chakra de Kurama. Agora, está mais fácil trazer o Sasuke de volta (a menos que você tenha algo melhor pra fazer…).'),
('CALÇA NARUTO - BIJUU STYLE', 110.60, 'Qual seu bijuu favorito? Kurama, Son Goku, Shukaku… que tal todos?', 'Essa bela calça com tecido poliester possui estampa serigráfica das feras mais poderosas do universo Naruto, como se fossem retiradas diretamente dos mangás. E aí, tem um bijuu favorito? Não precisa pensar demais, basta levar todos de uma só vez…'),
('CALÇA NARUTO - AKATSUKI EVOLVED', 110.60, 'Quem disse que é preciso um manto para ser respeitado como um membro da akatsuki?', 'Calça em tecido poliéster, com a icônica nuvem da akatsuki serigrafada, para você atuar nas sombras do mundo ninja. Uma forma um tanto quanto interessante de se destacar dos outros membros da organização, que só trajam aquele clássico manto. Se você não sabe jutsus, pelo menos tem um estilo autêntico, não?'),
('CAMISETA ATTACK ON TITAN - TROPA DE EXPLORAÇÃO', 55.60, 'O mundo oferece liberdade. Essa camiseta sempre te lembrará da importância de viver com esse propósito.', 'Viver em um mundo ameaçador onde gigantes podem acabar com a sua vida. Esse é o pesadelo de quem vive atrás das muralhas. Mas você não vive esse horror, pois o mundo está livre para apreciar os lugares mais especiais com o estilo que você gosta. Essa camiseta em algodão, com estampa serigráfica irá fomentar em você uma das melhores sensações: liberdade!'),
('CAMISETA NARUTO - BROTHERS DIVIDED', 55.60, 'A batalha no Vale do Fim e suas consequências. Um legado de memórias emocionante que essa camiseta te fará relembrar.', 'NARUTOOO!! SASUKEEE!! Chidori e Rasengan colidem. Um confronto épico e dramático no Vale do Fim, mas não o último. O laço entre dois irmãos, embora cruzem caminhos distintos, resiste ao tempo. Essa camiseta em tecido poliéster e estampa serigrafada de alta qualidade carrega a vontade do fogo para nunca desistir de quem amamos.'),
('CAMISETA NARUTO - ITACHI TSUKUYOMI', 55.60, 'O reino de pesadelos de um homem que viveu nas sombras como herói. Seria essa camiseta um genjutsu, de tão perfeita?', 'Os olhos sinistros de Itachi submetem qualquer adversário, mas Sasuke não desistirá de encontrar seu irmão para perpetrar sua vingança. Se você, vestindo essa camiseta de tecido em algodão respirável e estampa serigráfica, trombar com ele, talvez respostas sejam exigidas… esteja preparado!'),
('CAMISETA NARUTO - KAKASHI IN THE SHADOW', 55.60, 'Missões secretas e furtividade. Kakashi sabe tudo sobre isso. Essa camiseta personifica o jeito ninja sorrateiro da ANBU…', 'Camiseta serigrafada de tecido respirável em algodão que estrela um dos personagens mais táticos e icônicos do universo Naruto: Hatake Kakashi. O sexto Hokage, de certo, vai te agradecer quando te ver utilizando-a. Quem não gosta de ter fãs?'),
('CAMISETA BREAKING BAD - LOS POLLOS HERMANOS', 55.60, 'Os Pollos Hermanos estão de vagas abertas!', 'Olá, bem-vindo! Olhamos o seu perfil e gostamos de você. Que tal levar essa camiseta de tecido poliéster respirável e estampa serigráfica para atuar despercebidamente no restaurante enquanto ajuda Gus Fring a planejar um novo império de metanfetamina no México? Só não é para ficar doidão no seu turno, hein? Ele é um homem cuidadoso… '),
('CAMISETA BREAKING BAD - UNIVERSO PINK E CÉREBRO', 55.60, 'Coisas interessantes acontecem quando se viaja pelo multiverso. Pode ser que, todas as noites, Walter e Jesse tentem dominar o mundo!', 'Terra 212. Todas as noites, Heisenbrain, junto com seu assistente Pinkman, tentam dominar o mundo ao sedimentar, pouco a pouco, um império da metanfetamina em todas as nações. Será que eles vão conseguir? Camiseta serigrafada em tecido 100% algodão.'),
('CANECA REI LEÃO - ALVORADA REAL', 60.25, 'O sol nascente se pôs para saudar a linhagem do rei!', 'Sempre a partir do momento que o dia começa, Simba é abençoado com o aprendizado que seu pai, mãe e o ciclo da vida ao redor oferecem. Caneca de porcelana com estampa sublimática para você ficar ainda mais próximo no seu dia a dia desse grande clássico da Disney.'),
('CANECA BREAKING BAD - SAY MY NAME', 60.25, 'Bora dar uma pausa. Depois você cozinha mais…', 'O laboratório de metanfetamina está a todo favor, a gente sabe. Mas isso não quer dizer que você não possa dar uma pausa para desfrutar de um delicioso café nessa caneca de porcelana com estampa sublimada. Vai por mim, não é porque você deu um break que eles vão parar de dizer o seu nome!'),
('CAMISETA REI LEÃO - HAKUNA MATATA', 45.25, 'Hakuna matata… é lindo dizer! Hakuna matata… sim, vai entender!!', 'Ao vestir essa camiseta de tecido poliéster, com serigrafia digital, os seus problemas sobre peças duráveis e confortáveis você deve esquecer. Durabilidade e conforto é viver. É aprender como a Clover faz! Hakuna Matata!!'),
('MOLETOM GAME OF THRONES - LOGO', 145.75, 'Talvez o inverno não esteja chegando… em todo caso, é bom estar pronto para se aquecer.', 'A guerra pelo poder é constante, mas ela não pode deixar você esquecer dos pavores do inverno. Esse tecido de lã serigrafado, construído para reter o calor e impedir o frio de entrar, é o que você precisa para suportar um inverno visceral confortavelmente como um verdadeiro guerreiro.'),
('MOLETOM GAME OF THRONES - DAENERYS DRAGONS ARMY', 145.75, 'A soberania Targaryen, por vezes, pode ser sinônimo de ameaça.', 'Quantos dragões são necessários para influenciar uma monarca a enlouquecer com o poder ainda mais? Basta apenas contar alguns dos muitos dragões nesse moletom de veludo serigrafado, belamente estampado.'),
('MOLETOM SENHOR DOS ANÉIS - HOBBIT ESSENCE', 145.75, 'Viver com simplicidade e desfrutar do que a mãe natureza proporciona. É bom viver o estilo de vida de um hobbit!', 'O estilo de vida pacato e simples dos hobbits personificado nesse belo moletom tecido em pura lã, para te dar conforto e estilo no frio. Se Gandalf te solicitar uma jornada até Mordor, talvez seja melhor deixar pra lá, né? Sossego e tranquilidade é uma experiência que esse moletom visa reforçar.'),
('CAMISETA SENHOR DOS ANÉIS - GONDOR TREE', 65.75, 'A nobreza dos reis de outrora no seu peito.', 'A árvore que possui sete estrelas sobre ela. Cada estrela representa uma das casas de Elendil. O símbolo de Gondor é uma honra para um nobre, pois carregá-lo no peito torna mítico o seu papel na história. E como um nobre merece, esse tecido respirável serigrafado feito de algodão vai te dar o conforto e o estilo necessários para você se sentir uma lenda!'),
('CAMISETA RICK & MORTY - PSICOSE EXTREMA', 79.20, 'Tudo pode acontecer no universo de Rick & Morty. Algumas experiências podem ser bem estranhas e psicóticas…', 'Camiseta dupla face serigrafada em tecido poliéster respirável. Tão lindamente surreal que você vai pensar que comeu alguns cogumelos muito loucos (ou pode apenas ter sido mais uma das façanhas de Rick, mesmo). Ideal para destacar o visual e dar uma fritada!'),
('CAMISETA RICK & MORTY - PAZ ENTRE OS MUNDOS', 79.20, ' Às vezes, para manter a paz em nossas relações basta um belo de um f***-se.', 'Se um dia uma civilização alienígena nos visitar (ou até mesmo se você visitá-los), ensine-os um gesto de saudação amistoso para mostrar que não se incomoda com a chegada dos novos inquilinos. Já sabe qual é? Você pode, inclusive, presenteá-los com essa camiseta em tecido poliéster e serigrafia de alta qualidade para sempre lembrá-los do valor de sua saudação.'),
('CAMISETA KUNG FU PANDA - MARTIAL TRAINING', 79.20, 'Para aperfeiçoar seu corpo e mente, o treinamento tem de ser diário. O Poo pode te dar um gás!', null),
('CAMISETA KUNG FU PANDA - EMOTIONS OF PO', 79.20, 'Se sentir confuso, feliz, faminto… um panda pode ser mais profundo do que você pensa.', 'A psicologia é clara: pandas são como seres humanos. Ok, talvez a Clover tenha inventado isso… fato é que o Po, pelo o menos, é um panda muito parecido com você, e um amigo para todas as horas! Essa camiseta poliéster com serigrafia digital mostra que um panda pode se sentir como você se sente.');




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

INSERT INTO cliente (cpf_ou_cnpj, email, nome, tipo, data_nascimento, genero, is_logado, senha) VALUES
    ('47193770845', 'igor@gmail.com', 'Igor Martins', 1, '1999-02-09', 'Masculino', 0, 'RWNvbm9tMUA=');

INSERT INTO perfis VALUES
    (1, 1);