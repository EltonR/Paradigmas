package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Dom Quixote
 */
public class Oval extends Circulo{

    public Oval(Point centro, int raio, int raio2, String path) {
        super(centro, raio, raio2, path);
    }
    
    @Override
    public void draw(Graphics graphics){
        graphics.setColor(Color.yellow);
        graphics.fillOval(centro.x, centro.y, raio, raio2);
    }
    
}
