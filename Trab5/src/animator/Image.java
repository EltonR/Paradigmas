package animator;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

// Uma imagem na animacao.
class Image {

    private BufferedImage img;
    private Point centro;
    private String path;
    private double volta;

    

    public Image(Point pos, BufferedImage img, String path) {
        this.centro = pos;
        this.img = img;
        this.path = path;
        volta=1.0;
    }

    
    
    public void draw(Graphics g) {
        g.drawImage(img, centro.x, centro.y, null);
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public Point getCentro() {
        return centro;
    }

    public void setCentro(Point centro) {
        this.centro = centro;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getVolta() {
        return volta;
    }

    public void setVolta(double volta) {
        this.volta = volta;
    }
    
    
    
}
