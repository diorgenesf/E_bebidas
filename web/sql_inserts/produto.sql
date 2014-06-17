-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 17-Jun-2014 às 14:39
-- Versão do servidor: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ebebidas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `idproduto` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `descricao` varchar(6000) NOT NULL,
  `quantidade` int(11) NOT NULL DEFAULT '0',
  `valor_unitario` decimal(9,2) NOT NULL DEFAULT '0.00',
  `desconto` decimal(9,2) NOT NULL DEFAULT '0.00',
  `idcategoria` int(11) NOT NULL,
  `destaque` varchar(1) DEFAULT NULL COMMENT 'Aparecer na página inicial\ns = SIM\nn = NÃO',
  `imagem` varchar(100) DEFAULT NULL,
  `vendidos` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idproduto`),
  KEY `fk_produto_categoria1_idx` (`idcategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`idproduto`, `titulo`, `descricao`, `quantidade`, `valor_unitario`, `desconto`, `idcategoria`, `destaque`, `imagem`, `vendidos`) VALUES
(1, 'WHISKY JOHNNIE WALKER BLUE LABEL', 'O design contemporâneo da nova garrafa apresenta detalhes que refletem o compromisso da marca tanto com a herança quanto com a modernidade: a base e as laterais de vidro mais espessas formam a moldura perfeita para esse blend incomparável; o vidro no tom azul claro permite que o whisky brilhe através dele, criando um contraste harmonioso; o monograma John Walker & Sons e o brasão da realeza britânica são gravados em dourado diretamente no vidro para realçar sua excelência; enquanto a numeração individual em destaque das garrafas reflete a natureza estritamente limitada e exclusiva deste Scotch Whisky sublime.BLUE LABEL é o ápice dos whiskies da Casa de Walker – a epítome da arte de preparar blends. Criado para refletir o estilo dos whiskies do início do século 19, é preparado com alguns dos barris mais raros dos estoques de JOHNNIE WALKER, que possui o maior estoque do mundo.Os barris são selecionados a mão e separados, por sua excepcional qualidade, caráter e sabor. O caráter de BLUE LABEL é realmente único; é complexo, vigoroso e incrivelmente suave, com a característica defumada de JOHNNIE WALKER.JOHNNIE WALKER BLUE LABEL foi criado pelo Mestre Destilador, Jim Beveridge, que continua a tradição de inigualável comprometimento para fazer os melhores whiskies do mundo. Com acesso às mais valiosas e preciosas reservas de whisky, os guardiões do legado de John Walker conseguiram criar este blend excepcional.O Master Blender de JOHNNIE WALKER utiliza as maiores reservas de whisky no mundo; um legado que remonta a 200 anos atrás. Os whiskies para o JOHNNIE WALKER BLUE LABEL são literalmente escolhidos a mão e cultivados a partir da maior seleção de barris no mundo.\r\nNenhuma outra companhia chega perto dessa gama de sabores que é a base para o caráter excepcional do JOHNNIE WALKER BLUE LABEL.Dos 7 milhões de tonéis disponíveis para o Máster Blender de Johnnie Walker, apenas 1 em 1000 possui as propriedades e os sabores excepcionais procurados para a produção de BLUE LABEL.', 0, '899.90', '0.00', 14, NULL, 'whisky-johnnie-walker-blue-label_1_350.jpg', 0),
(2, 'WHISKY JOHNNIE WALKER RED LABEL', 'É um “Blend Scotch Whisky” rico e incorporado. Tem uma seleção inigualável de mais de 35 maltes na sua composição que garantem a sua superioridade.\r\nCom aroma doce amadeirado, cravo-da-índia, doce de manteiga e sabor rico com mel. A marca Johnnie Walker existe desde 1920 e hoje é o whisky escocês mais vendido no mundo.', 0, '89.90', '0.00', 14, NULL, 'whisky-johnnie-walker-red-label_1_350.jpg', 0),
(3, 'WHISKY JOHNNIE WALKER BLUE LABEL KING GEORGE V', 'A Casa da Bebida apresenta o Johnnie Walker Blue Label King George Edition, bebida seleta e feita de uísques raros produzidos somente em destilarias que funcionaram durante o reino do Rei George V inclusive várias que já não existem.\r\n\r\nÉ apresentado num decante único de cristal acompanhado por um certificado de autenticidade individualmente numerado.', 0, '2999.90', '0.00', 14, NULL, 'whisky-johnnie-walker-blue-label-king-george-v_1_350.jpg', 0),
(4, 'WHISKY JOHNNIE WALKER GOLD LABEL', 'Foi criado em 1920 em comemoração aos 100 anos da fundação dos negócios de Johnnie Walker.\r\n\r\nEm sua formulação são usados os melhores Whiskys da Escócia, envelhecidos por, no mínimo, 18 anos.\r\n\r\nÉ suntuosamente luxuoso e suave, com uma textura cremosa que o torna único na categoria.\r\n\r\nA água utilizada em sua composição provém de um manancial de onde se extrai ouro, fazendo com que seu sabor seja único.', 0, '429.90', '0.00', 14, NULL, 'whisky-johnnie-walker-gold-label_1_350.jpg', 0),
(5, 'WHISKY JOHNNIE WALKER DOUBLE BLACK', 'Diferentemente do Black Label Clássico (12 anos), o Double Black possuí o sabor defumado mais Intenso.\r\n\r\nAs características de Johnnie Walker Black Label, especialmente as notas defumadas, são ainda mais intensas em Johnnie Walker Double Black.\r\n\r\nProduzido a partir da combinação de alguns maltes exclusivos, selecionados especialmente para garantir o sabor defumado e envelhecidos em barris de carvalho, o que significa uma qualidade exemplar.\r\n\r\nTem aromas trufados mais encorpados e intensos e sabor defumado.\r\n\r\nA produção é artesanal, feita em pequenos lotes, a partir de uísques de destilarias da costa oeste escocesa.\r\n\r\nNo ano passado, a bebida foi premiada na categoria “Best Super Premium Blends” do prêmio World Whisky Masters.', 0, '199.90', '0.00', 14, NULL, 'whisky-johnnie-walker-double-black_1_350.jpg', 0),
(6, 'WHISKY CHIVAS REGAL 12 ANOS', 'Blended Scotch Whisky 12 Anos, Chivas Regal é reconhecido mundialmente como o melhor dos premium blended scoth whiskies, constituindo-se em um padrão de excelência para todos os destilados. Com seu aroma complexo, mas ainda suave, e seu sabor esfumaçado, balanceado por sua qualidade harmonizada, Chivas Regal é o predileto entre os apreciadores de whisky.', 0, '129.90', '0.00', 14, NULL, 'whisky-chivas-regal-12-anos_1_350.jpg', 0),
(7, 'JOHNNIE WALKER THE COLLECTION', 'CONTÉM:\r\n\r\n01 Johnnie Walker Black Label " 12 anos " de 200 ml.\r\n01 Johnnie Walker Green Label " 15 anos " de 200 ml.\r\n01 Johnnie Walker Gold Label " 18 anos " de 200 ml.\r\n01 Johnnie Walker Blue Label " 21 anos " de 200 ml.', 0, '449.90', '0.00', 14, NULL, 'johnnie-walker-the-collection_1_350.jpg', 0),
(8, 'WHISKY JOHNNIE WALKER PLATINUM LABEL 18 ANOS', 'Inspirado na tradição da família Walker em criar Private Blends - Whiskies exclusivos, oferecidos apenas para um seleto grupo de clientes e diretores da companhia para ser degustado em encontros mais íntimos, excepcionais e apenas degustados em ocasiões verdadeiramente especiais.\r\n\r\nElaborado a partir de whiskies de maltes e grãos, Johnnie Walker Platinum Label é um whisky mais rico e perfeitamente elaborado pela House of Walker.\r\n\r\nCom sabor e aroma incrivelmente ricos e refinados, assim como o metal (origem do nome), esse blend complexo e marcante incorpora as notas intensas e adocicadas, porém elegantes do estilo da região de Speyside e um delicado defumado característico da região de Islay.\r\n\r\nDe cor âmbar profundo. Aroma rico e refinado, com um toque de frutas frescas e elegantes notas defumadas.\r\n\r\nPaladar de um blend moderno, intenso e complexo, com sabores ricos e marcantes de frutas, cereais e amêndoas, elegantemente combinados com um final suave e defumado.', 0, '429.90', '0.00', 14, NULL, 'whisky-johnnie-walker-platinum-label-18-anos_1_350.jpg', 0),
(9, 'WHISKY JOHNNIE WALKER GREEN LABEL', 'Ultimas unidades, pois o estoque dessa qualidade de whisky se esgotou. Aproveite!\r\n\r\nEstá sendo substituído pelo Johnnie Walker Gold Label Reserve.\r\n\r\nGreen Label é o quinto Whisky lançado por Johnnie Walker em 200 anos e é o único composto apenas por maltes, cada um envelhecido por no mínimo 15 anos.\r\n\r\nUm equilíbrio perfeito de maltes complexos e sutis das Highlands na Escócia, maltes pesados e defumados das ilhas de Islay e de Speyside, utilizando predominantemente os maltes Caol Ila, é o Whisky ideal para o consumidor que está procurando algo mais exclusivo e menos conhecido.', 0, '399.90', '0.00', 14, NULL, 'whisky-johnnie-walker-green-label_1_350.jpg', 0),
(10, 'WHISKY JOHNNIE WALKER GOLD LABEL RESERVE', 'Whisky Johnnie Walker Gold Label Reserve.\r\n\r\nGold Label Reserve é obra do master blender nº 1 da Johnnie Walker, Jim Beveridge, que usou whiskys de sua reserva pessoal e barris estocados em Clynelish, região da Escócia onde foi descoberto o ouro, razão pela qual o rótulo é dourado.\r\n\r\nO diferencial deste blend é a harmonia entre as frutas doces e o mel.\r\n\r\nO whisky traz equilíbrio entre o sabor de frutas doces e as notas profundas de mel. Ondas de madeira e toques defumados também fazem parte da novidade, que pode ser apreciada em um copo alto com gelo e uma fatia de laranja.', 0, '299.90', '0.00', 14, NULL, 'whisky-johnnie-walker-gold-label-reserve_1_350.jpg', 0);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_produto_categoria1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
