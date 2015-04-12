--
-- Este programa ilustra:
-- 1) Uso de registros (record syntax) em Haskell
-- 2) Leitura de arquivo CSV
--

--
-- Declara novo tipo de dado 'GalleryItem' usando record syntax
-- Cada GalleryItem é um registro formado por 3 campos / atributos
-- Com esta sintaxe, Haskell automaticamente cria funções de acesso aos campos
-- Por exemplo, dado um GalleryItem x, 'title x' vai retornar o atributo 'title' de x,
-- 'description x' vai retornar o atributo 'description' de x, e assim por diante
-- Mais sobre isso em: http://learnyouahaskell.com/making-our-own-types-and-typeclasses
--
data GalleryItem =
   GalleryItem {title :: String,
                description :: String,
                author :: String}
               
-- Converte uma lista de String em um GalleryItem
toGalleryItem :: [String] -> GalleryItem
toGalleryItem [s1, s2, s3] = GalleryItem {title = s1, description = s2, author = s3}



-- Funcao principal que faz leitura de arquivo e mostra atributos de um item da galeria
main :: IO ()
main = do
    strcontent <- readFile infile							-- lê conteúdo do arquivo em string
    let strlist = map (splitOnChar ';') (lines strcontent)	-- extrai linhas e quebra cada uma delas
        itemlist = map (toGalleryItem) strlist				-- transforma cada linha num GalleryItem   
	in writeFile outfile (geraHead  ++ (geraHtml 1 itemlist) ++ "</div>\n</body>\n</html>")
    where
	infile = "data.csv"
	outfile = "output.html"
	
geraHead :: String
geraHead = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> <html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n <title>Galeria de Trabalhos de Paradigmas de Programacao</title>\n <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" /> </head><body>\n <div id=\"main\">\n <h1>Galeria de Trabalhos de Paradigmas de Programacao</h1>\n"
	
geraFigura :: Int -> String
geraFigura n = "<div class=\"csslisting\"><div class=\"floatbox\"><a href=\"image.html?src=./images/T"++show(n)++"_1.png&height=450&alt=Imagem "++show(n)++"\"><img src=\"./images/T"++show(n)++"_1.png\" width=\"200\" border=\"0\" /></a>\n"
	
geraItem :: GalleryItem -> String
geraItem gitem = "</div><p><b>"++(title gitem)++"</b><br/>"++(description gitem)++"<br/>\nAutor: "++(author gitem)++"<br/>\n</p>\n</div>\n\n"

geraHtml :: Int -> [GalleryItem] -> String
geraHtml n itens
	| null itens = ""
	| otherwise = (geraFigura(n) ++ geraItem (head itens) ++ (geraHtml (n+1) (tail itens)))


-- Funcao que decompoe string usando um caracter delimitador
splitOnChar :: Char -> String -> [String]
splitOnChar x y = auxSplitOnChar x y [[]]

auxSplitOnChar :: Char -> String -> [String] -> [String]
auxSplitOnChar x [] z = reverse (map reverse z)
auxSplitOnChar x (y:ys) (z:zs) = 
	if y == x then 
            auxSplitOnChar x ys ([]:(z:zs)) 
        else 
            auxSplitOnChar x ys ((y:z):zs)
            
