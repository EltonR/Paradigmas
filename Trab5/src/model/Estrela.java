package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Dom Quixote
 */
public class Estrela {
    private int pontas;
    private Point local;
    private String path;
    private double volta;
    

    public Estrela(int pontas, Point centro, String path) {
        this.pontas = pontas;
        this.local = centro;
        this.path = path;
        volta = 1.2;
    }
    
    public void draw(Graphics graphics){
        int[] pontosX = {-100, -25, 0, 25, 100, 50, 60, 0, -60, -50, -100};
        int[] pontosY = {-15, -25, -90, -25, -15, 25, 90, 50, 90, 25, -15};
        for(int i=0; i < pontosX.length; i++){
            pontosX[i] += local.x;
            pontosY[i] += local.y;
        }
        graphics.setColor(Color.WHITE);
        if(pontas%2 == 0)
            graphics.fillPolygon(pontosX, pontosY, pontas*2+1);
        else{
            graphics.fillPolygon(pontosX, pontosY, pontas*2);
        }
    }
    
    
    
    
    

    public int getPontas() {
        return pontas;
    }

    public void setPontas(int pontas) {
        this.pontas = pontas;
    }

    public Point getLocal() {
        return local;
    }

    public void setLocal(Point centro) {
        this.local = centro;
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
