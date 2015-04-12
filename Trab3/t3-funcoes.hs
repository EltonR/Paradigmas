import Data.Char

-- 1. Escreva uma função recursiva firstName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu primeiro nome. 
-- Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.
firstName :: String -> String
firstName string
	|string == [] = []
	|head string == ' ' = ""
	|otherwise = head string : firstName(tail string)
	
-- 2. Escreva uma função firstName' :: String -> String com o mesmo resultado do exercício anterior, mas sem usar recursão. 
-- Dica: estude funções pré-definidas em Haskell (List operations -> Sublists) em...
firstName' :: String -> String
firstName' string = takeWhile (/= ' ') string

-- 3. Escreva uma função lastName :: String -> String que, dado o nome completo de uma pessoa, obtenha seu último sobrenome. 
-- Suponha que cada parte do nome seja separada por um espaço e que não existam espaços no início ou fim do nome.
lastName :: String -> String
lastName string = reverse (takeWhile (/= ' ') (reverse string))

-- 4. Escreva uma função não-recursiva userName :: String -> String que, dado o nome completo de uma pessoa, crie um nome de usuário (login) da pessoa, formado por:
-- primeira letra do nome seguida do sobrenome, tudo em minúsculas. Dica: estude as funções pré-definidas no módulo Data.Char, para manipulação de maiúsculas e minúsculas.
userName :: String -> String
userName string = [toLower x | x <- [head(string)]] ++ [toLower x | x <- lastName(string)]

-- 5. Escreva uma função não-recursiva encodeName :: String -> String que substitua vogais em uma string, conforme o esquema a seguir:
-- a = 4, e = 3, i = 1, o = 0, u = 00.
encodeName :: String -> String
encodeName string = 
	let troca c
		|toLower(c) == 'a' = "4"
		|toLower(c) == 'e' = "3"
		|toLower(c) == 'i' = "1"
		|toLower(c) == 'o' = "0"
		|toLower(c) == 'u' = "00"
		|otherwise = [c]
	in concat(map (troca) string)
	
-- 6. Escreva uma função isElem :: Int -> [Int] -> Bool que verifique se um dado elemento pertence a uma lista,
-- conforme os exemplos abaixo:
isElem :: Int -> [Int] -> Bool
isElem n1 lista
	| lista == [] = False
	| head(lista) == n1 = True
	| otherwise = isElem n1 (tail lista)
	
-- 7. Escreva uma função recursiva que retorne o número de vogais em uma string.
vogais :: String -> Int
vogais string
	|string == [] = 0
	|toLower(head string) `elem` "aeiou" = 1 + vogais(tail(string))
	|otherwise = vogais(tail(string))

-- 8. Escreva uma função não-recursiva que retorne o número de consoantes em uma string.
consoantes :: String -> Int
consoantes string = length [ x | x <- string, ((toLower x) `elem` "aeiou ") == False]
	
-- 9. Escreva uma função não-recursiva isInt :: String -> Bool 
-- que verifique se uma dada string só contém dígitos (0 a 9).
isInt :: String -> Bool
isInt string
	| (length(filter (`elem` ['0','1'..'9']) string) == length (string)) = True
	| otherwise = False
	
	
-- 10. Escreva uma função não-recursiva strToInt :: String -> Int que converta 
-- uma string em um número inteiro, fazendo operações aritméticas com seus dígitos 
-- (p.ex.: "356" = 3*100 + 5*10 + 6*1 = 356). Considere que a string seja um número 
-- válido, isto é, só contenha dígitos de 0 a 9. Dica: se não souber por onde começar, 
-- estude o exemplo de validação de CPF visto em aula.
strToInt :: String -> Int
strToInt string = sum (zipWith (*) (map (converte) (reverse string)) (1:(map (10^) [1,2..])) )
	where converte x
		|x == '0' = 0
		|x == '1' = 1
		|x == '2' = 2
		|x == '3' = 3
		|x == '4' = 4
		|x == '5' = 5
		|x == '6' = 6
		|x == '7' = 7
		|x == '8' = 8
		|otherwise = 9
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	