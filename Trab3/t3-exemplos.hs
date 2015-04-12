-- 1. As funções de alta ordem any e all são pré-definidas na biblioteca Prelude do Haskell (veja seção Special Folds).
-- Estude e teste essas funções e apresente 2 exemplos de uso de cada uma delas.
-- Fonte Consultada: http://zvon.org/other/haskell/Outputprelude/any_f.html
-- Resposta: a função any aplica um teste, estabelecido no primeiro argumento, à todos os elementos da lista, que entra como segundo argumento,
-- retornando verdadeiro se ao menos um elemento satisfaz a condição do teste, e falso em caso contrário.
-- Já a função all faz a mesma coisa, retornando True se TODOS os elementos da lista passaram no teste, e falso caso contrário.
-- Exemplos:
pertenceConjunto :: Int -> [Int] -> Bool
pertenceConjunto x conjunto
	| any (x==) conjunto = True
	| otherwise = False
	
pertenceConjunto' :: Int -> [Int] -> Bool
pertenceConjunto' x conjunto
	| all (x/=) conjunto = False
	| otherwise = True
	
checaIntervalo :: Int -> Int -> [Int] -> Bool
checaIntervalo min max vetor
	| all (>=min) vetor  && all (<=max) vetor= True
	| otherwise = False
	
checaIntervalo' :: Int -> Int -> [Int] -> Bool
checaIntervalo' min max vetor
	| any (<min) vetor  || any (>max) vetor = False
	| otherwise = True
	
-- 2. Em Haskell, o símbolo '$' pode ser usado para escrever códigos ainda mais curtos. Descubra seu significado e apresente 2 exemplos de uso.
-- O símbolo "$" pode ser utilizado para economizar a recorrência aos parênteses.
-- Fonte: https://www.fpcomplete.com/blog/2012/09/ten-things-you-should-know-about-haskell-syntax
-- Assim, ao invés de chamarmos uma funcao como "f1 (arg1 arg2 arg3)" podemos chamala "f1 $ arg1 arg2 arg3".
-- Em outras palavras: o operador $ faz com que a função à direita seja aplicada ao argumento à esquerda.
-- Exemplos:
pertenceUmConjunto :: Int -> [Int] -> [Int] -> Bool
pertenceUmConjunto x conjuntoX conjuntoY
	| any (x==) $  [x | x <- conjuntoX] ++ [ x | x<-conjuntoY] = True
	| otherwise = False

menorDosConjuntos :: [Int] -> [Int] -> Int
menorDosConjuntos conjuntoX conjuntoY = min (minimum conjuntoX) $ minimum conjuntoY

-- 3. Haskell permite composição de funções, exatamente como em matemática. Descubra como fazer isso e apresente 2 exemplos de aplicação de funções compostas.
-- Fonte: https://wiki.haskell.org/Function_composition
-- As funções compostas permitem que se utilize outras funções como argumento, de modo a criar funções que utilizam outras funções para realizar partes das tarefas da função original.
-- Para isso, se utiliza o ponto (.), como em "função1 . função2", de modo que executamos primeiro a função 2, e com o resultado, a função 1;
-- Exemplos:
eleva2Soma1 :: Int -> Int
eleva2Soma1 n =
	let 
		func1 = (+1)
		func2 = (^2)
	in (func1 . func2) n

eleva2Soma2 :: [Int] -> [Int]
eleva2Soma2 vetor =
	let
		func1 = (+1)
	in map (func1 . eleva2Soma1) vetor











