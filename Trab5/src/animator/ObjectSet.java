package animator;

import static animator.ShapeType.Triangulo;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import model.Circulo;
import model.Estrela;
import model.Movimento;
import model.Oval;
import model.Quadrado;
import model.Triangulo;

class ObjectSet {
    
    private ArrayList<Image> images;
    private ArrayList<Circulo> circulos;
    private ArrayList<Quadrado> quadrados;
    private ArrayList<Estrela> estrelas;
    private ArrayList<Triangulo> triangulos;

    public ObjectSet() {
    }
    private Movimento movimento;
    private Random random;
    
    public ObjectSet(Dimension dim){
        movimento = new Movimento(dim);
        images = new ArrayList<Image>();
        circulos = new ArrayList<Circulo>();
        quadrados = new ArrayList<Quadrado>();
        estrelas = new ArrayList<Estrela>();
        triangulos = new ArrayList<Triangulo>();
        random = new Random();
    }
    
    void addImages(int n, Dimension dim, BufferedImage image, String path) {
        for (int i = 0; i < n; i++) {
            Point centro = new Point(random.nextInt(dim.height-image.getHeight()), random.nextInt(dim.width-image.getWidth()));
            centro.x += 50;
            centro.y += 50;
            images.add(new Image(centro, image, path));
        }
    }
    
    void addStars(int n, Dimension dim, String path) {
        for (int i = 0; i < n; i++) {
            Point local = new Point(random.nextInt(dim.height-100), random.nextInt(dim.width-100));
            local.x += 50;
            local.y += 50;
            Estrela estrela = new Estrela(5, local, path);
            estrelas.add(estrela);
        }
    }
    
    void addRectangles(int n, Dimension dim, String path) {
        for (int i = 0; i < n; i++) {
            Point centro = new Point(random.nextInt(dim.height-100), random.nextInt(dim.width-100));
            centro.x += 50;
            centro.y += 50;
            Quadrado quadrado = new Quadrado(centro, path, 100);
            quadrados.add(quadrado);
        }
    }
    
    void addCircles(int n, Dimension dim, String path) {
        for (int i = 0; i < n; i++) {
            Point centro = new Point(random.nextInt(dim.height-100), random.nextInt(dim.width-100));
            centro.x += 50;
            centro.y += 50;
            Circulo circle = new Circulo(centro, 100, path);
            circulos.add(circle);
        }
    }
    
    void addOval(int n, Dimension dim, String path) {
        for (int i = 0; i < n; i++) {
            Point centro = new Point(random.nextInt(dim.height-100), random.nextInt(dim.width-100));
            centro.x += 50;
            centro.y += 50;
            Oval circle = new Oval(centro, 100, 60, path);
            circulos.add(circle);
        }
    }
    
    void addTriangulo(int n, Dimension dim, String path) {
        for (int i = 0; i < n; i++) {
            Point centro = new Point(random.nextInt(dim.height-100), random.nextInt(dim.width-100));
            centro.x += 50;
            centro.y += 50;
            Triangulo circle = new Triangulo(centro, 100, path);
            triangulos.add(circle);
        }
    }
    
    void drawAll(Graphics g) {
        if(images != null)
            for(int i=0; i<images.size(); i++)
                images.get(i).draw(g);
        if(circulos != null)
            for(int i=0; i<circulos.size(); i++)
                circulos.get(i).draw(g);
        if(quadrados != null)
            for(int i=0; i<quadrados.size(); i++)
                quadrados.get(i).draw(g);
        if(estrelas != null)
            for(int i=0; i<estrelas.size(); i++)
                estrelas.get(i).draw(g);
        if(triangulos != null)
            for(int i=0; i<triangulos.size(); i++)
                triangulos.get(i).draw(g);
    }

    void moveAll() {
        for(int i=0; i<images.size(); i++){
            if(images.get(i).getPath().equalsIgnoreCase("Line"))
                images.get(i).setCentro(movimento.reta(images.get(i).getCentro()));
            if(images.get(i).getPath().equalsIgnoreCase("Circle")){
                images.get(i).setCentro(movimento.circulo(images.get(i).getCentro(), 100, images.get(i).getVolta()));
                images.get(i).setVolta(images.get(i).getVolta()+0.2);
            }
            if(images.get(i).getPath().equalsIgnoreCase("Borda")){
                images.get(i).setCentro(movimento.bordas(images.get(i).getCentro(), images.get(i).getVolta()));
                images.get(i).setVolta(movimento.setVolta(images.get(i).getCentro(), images.get(i).getImg().getHeight(), images.get(i).getImg().getWidth(), images.get(i).getVolta()));
            }
        }
        for(int i=0; i<circulos.size(); i++){
            if(circulos.get(i).getPath().equalsIgnoreCase("Line")){
                circulos.get(i).setCentro(movimento.reta(circulos.get(i).getCentro()));
            }
            if(circulos.get(i).getPath().equalsIgnoreCase("zoom")){
                circulos.get(i).setRaio(movimento.zoom(circulos.get(i).getRaio(), circulos.get(i).isAumentando()));
                circulos.get(i).setAumentando(movimento.isAumentando(circulos.get(i).getRaio(), circulos.get(i).isAumentando()));
            }
            if(circulos.get(i).getPath().equalsIgnoreCase("Circle")){
                circulos.get(i).setCentro(movimento.circulo(circulos.get(i).getCentro(), 100, circulos.get(i).getVolta()));
                circulos.get(i).setVolta(circulos.get(i).getVolta()+0.2);
            }
            if(circulos.get(i).getPath().equalsIgnoreCase("Borda")){
                circulos.get(i).setCentro(movimento.bordas(circulos.get(i).getCentro(), circulos.get(i).getVolta()));
                circulos.get(i).setVolta(movimento.setVolta(circulos.get(i).getCentro(), circulos.get(i).getRaio(), circulos.get(i).getRaio(), circulos.get(i).getVolta()));
            }
        }
        for(int i=0; i<quadrados.size(); i++){
            if(quadrados.get(i).getPath().equalsIgnoreCase("Line"))
                quadrados.get(i).setCentro(movimento.reta(quadrados.get(i).getCentro()));
            if(quadrados.get(i).getPath().equalsIgnoreCase("zoom")){
                quadrados.get(i).setLado(movimento.zoom(quadrados.get(i).getLado(), quadrados.get(i).isAumentando()));
                quadrados.get(i).setAumentando(movimento.isAumentando(quadrados.get(i).getLado(), quadrados.get(i).isAumentando()));
            }
            if(quadrados.get(i).getPath().equalsIgnoreCase("Circle")){
                quadrados.get(i).setCentro(movimento.circulo(quadrados.get(i).getCentro(), 100, quadrados.get(i).getVolta()));
                quadrados.get(i).setVolta(quadrados.get(i).getVolta()+0.2);
            }
            if(quadrados.get(i).getPath().equalsIgnoreCase("Borda")){
                quadrados.get(i).setCentro(movimento.bordas(quadrados.get(i).getCentro(), quadrados.get(i).getVolta()));
                quadrados.get(i).setVolta(movimento.setVolta(quadrados.get(i).getCentro(), quadrados.get(i).getLado(), quadrados.get(i).getLado(), quadrados.get(i).getVolta()));
            }
        }
        for(int i=0; i<estrelas.size(); i++){
            if(estrelas.get(i).getPath().equalsIgnoreCase("Line")){
                estrelas.get(i).setLocal(movimento.reta(estrelas.get(i).getLocal()));
            }
            if(estrelas.get(i).getPath().equalsIgnoreCase("Zoom")){
                //estrelas.get(i).setCentro(movimento.zoom(estrelas.get(i).getCentro()));
            }
            if(estrelas.get(i).getPath().equalsIgnoreCase("Circle")){
                estrelas.get(i).setLocal(movimento.circulo(estrelas.get(i).getLocal(), 100, estrelas.get(i).getVolta()));
                estrelas.get(i).setVolta(estrelas.get(i).getVolta()+0.2);
            }
            if(estrelas.get(i).getPath().equalsIgnoreCase("Borda")){
                estrelas.get(i).setLocal(movimento.bordas(estrelas.get(i).getLocal(), estrelas.get(i).getVolta()));
                estrelas.get(i).setVolta(movimento.setVolta(estrelas.get(i).getLocal(), 100, 100, estrelas.get(i).getVolta()));
            }
        }
        for(int i=0; i<triangulos.size(); i++){
            if(triangulos.get(i).getPath().equalsIgnoreCase("Line")){
                triangulos.get(i).setCentro(movimento.reta(triangulos.get(i).getCentro()));
            }
            if(triangulos.get(i).getPath().equalsIgnoreCase("Zoom")){
                triangulos.get(i).setLado(movimento.zoom(triangulos.get(i).getLado(), triangulos.get(i).isAumentando()));
                triangulos.get(i).setAumentando(movimento.isAumentando(triangulos.get(i).getLado(), triangulos.get(i).isAumentando()));
            }
            if(triangulos.get(i).getPath().equalsIgnoreCase("Circle")){
                triangulos.get(i).setCentro(movimento.circulo(triangulos.get(i).getCentro(), 100, triangulos.get(i).getVolta()));
                triangulos.get(i).setVolta(triangulos.get(i).getVolta()+0.2);
            }
            if(triangulos.get(i).getPath().equalsIgnoreCase("Borda")){
                triangulos.get(i).setCentro(movimento.bordas(triangulos.get(i).getCentro(), triangulos.get(i).getVolta()));
                triangulos.get(i).setVolta(movimento.setVolta(triangulos.get(i).getCentro(), triangulos.get(i).getLado(), triangulos.get(i).getLado(), triangulos.get(i).getVolta()));
            }
        }
    }
    

}
