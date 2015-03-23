-- Soma os quadrados de 2 numeros
doubleUs :: Int -> Int -> Int   
doubleUs x y = x^2 + y^2
  
-- Verifica se um numero eh par (mod retorna resto da divisao inteira)
isEven :: Int -> Bool
isEven n = if mod n 2 == 0 then True else False
  
-- Gera um numero a partir de um caracter
encodeMe :: Char -> Int
encodeMe c 
  | c == 'S'  = 0
  | c == 'N'  = 1
  | otherwise = 2
  
-- Calcula o quadrado do primeiro elemento da lista
doubleFirst :: [Int] -> Int
doubleFirst lis = (head lis)^2

-- 1. verifica se as 2 listas possuem o mesmo primeiro elemento. 
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads lista1 lista2
	|head(lista1) == head(lista2) = True
	|otherwise = False
	
-- 2. eleva ao cubo cada elemento da lista, produzindo outra lista.
pot3 :: [Int] -> [Int]
pot3 lista = map (^2) lista

-- 3. adiciona a constante 10 a cada elemento de uma lista, produzindo outra lista.
add10 :: [Int] -> [Int]
add10 [] = []
add10 lista = head(lista)+10 : add10(tail(lista))

-- 4. adicione uma vírgula no final de cada string contida numa lista
addComma :: [String] -> [String]
addComma [] = []
addComma lista = ((head(lista))++",") : addComma(tail(lista))

-- 5. Exercicio 5 (os dois anteriores usando "map")
add10M :: [Int] -> [Int]
add10M [] = []
add10M lista = map (+10) lista
addCommaM :: [String] -> [String]
addCommaM [] = []
addCommaM lista = map (++",") lista 

-- 6. receba uma lista de strings e retorne outra lista contendo as strings formatadas como itens de lista em HTML
htmlListItems :: [String] -> [String]
htmlListItems [] = []
htmlListItems lista = ("<LI>"++(head(lista))++"</LI>") : htmlListItems(tail(lista))

-- 7. verifique se o caracter (primeiro argumento) está contido na string (segundo argumento)
charFound :: Char -> String -> Bool
charFound char string
	|string == [] = False
	|char == head(string) = True 
	|otherwise = charFound char (tail(string))
	
-- 8. Reescreva a função anterior sem recursão, usando outras funções pré-definidas já vistas em aula.
charFound2 :: Char -> String -> Bool
charFound2 char [] = False
charFound2 char string = if (filter (== char) string) == [] then False else True

-- 9. Use a função de alta ordem 'zipWith' para produzir uma função que obtenha as diferenças, par a par, dos elementos de duas listas. 
-- Por exemplo: para listas de entrada [1,2,3,4] e [2,2,1,1], o resultado será [-1,0,2,3].
difListas :: [Int] -> [Int] -> [Int]
difListas [] [] = []
difListas lista1 lista2 = zipWith (-) lista1 lista2

-- 1. Dada uma lista de números, calcular 2*n+1 para cada número n contido na lista.
funcao2n1 :: [Int] -> [Int]
funcao2n1 [] = []
funcao2n1 lista = map (+1) (map (2*) lista)

-- 2. Dadas duas listas X e Y de números inteiros, calcular 4*x+2*y+1 para cada par de números x e y pertencentes às listas. 
funcao4x2y1 :: [Int] -> [Int] -> [Int]
funcao4x2y1 listaX listaY
	| (listaX == [] || listaY == []) = []
	| otherwise = map (1+) (zipWith (+) (map (4*) listaX) (map (2*) listaY))
	
-- 3. Dada uma lista de strings, produzir outra lista com strings de 10 caracteres, usando o seguinte esquema: 
-- strings de entrada com mais de 10 caracteres são truncadas, strings com até 10 caracteres são completadas com '.' até ficarem com 10 caracteres.
funcTrunca :: [Char] -> [Char]
funcTrunca palavra
	|length palavra < 10 = funcTrunca (palavra ++ ".")
	|length palavra > 10 = take 10 palavra
	|otherwise = palavra

funcStrings :: [String] -> [String]
funcStrings strings
	|strings == [] = []
	|otherwise = map (funcTrunca) strings
	
-- 4. Dada uma lista de idades, selecionar as que são maiores que 20 e, para cada uma, calcular o ano de nascimento correspondente (aproximado, considerando o ano atual).
funcCalc :: Int -> Int
funcCalc idade = 2015 - idade

funcIdade :: [Int] -> [Int]
funcIdade idades = map (funcCalc) (filter (>20) idades)









