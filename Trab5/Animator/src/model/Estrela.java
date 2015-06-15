package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Dom Quixote
 */
public class Estrela {
    private int raio1;
    private int raio2;
    private int[] x;
    private int[] y;
    private int[] x1;
    private int[] y1;
    private String path;
    private Point pos;
    private double volta;
    private boolean aumentado;
    
    public Estrela(Point centre, String path){
        this.raio1 = 50;
        this.raio2 = 100;
        this.x = new int[3];
        this.y = new int[3];
        this.x1 = new int[10];
        this.y1 = new int[10];
        this.pos = new Point(centre.x, centre.y);
        this.path = path;
        volta = 1.2;
    }
    
    public void draw(Graphics g){
        double ang = Math.PI/5;
        int t = 0;
        for(int i=0; i<5; i++){
            x[0] = (int) ((raio1 * Math.cos(ang)) + pos.x);
            y[0] = (int) ((raio1 * Math.sin(ang)) + pos.y);
            x1[t] = x[0];
            y1[t] = y[0];
            t++;
            ang+=Math.PI/5;
            x[1] = (int) ((raio2 * Math.cos(ang)) + pos.x);
            y[1] = (int) ((raio2 * Math.sin(ang)) + pos.y);
            ang+=Math.PI/5;
            x[2] = (int) ((raio1 * Math.cos(ang)) + pos.x);
            y[2] = (int) ((raio1 * Math.sin(ang)) + pos.y);
            x1[t] = x[2];
            y1[t] = y[2];
            g.setColor(Color.WHITE);
            g.fillPolygon(x, y, 3);
        }
        g.fillPolygon(x1, y1, 5);
    }

    public int getRaio1() {
        return raio1;
    }

    public void setRaio1(int raio1) {
        this.raio1 = raio1;
    }

    public int getRaio2() {
        return raio2;
    }

    public void setRaio2(int raio2) {
        this.raio2 = raio2;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public int[] getX1() {
        return x1;
    }

    public void setX1(int[] x1) {
        this.x1 = x1;
    }

    public int[] getY1() {
        return y1;
    }

    public void setY1(int[] y1) {
        this.y1 = y1;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public double getVolta() {
        return volta;
    }

    public void setVolta(double volta) {
        this.volta = volta;
    }

    public boolean isAumentado() {
        return aumentado;
    }

    public void setAumentado(boolean aumentado) {
        this.aumentado = aumentado;
    }

    
    
    
    

}
