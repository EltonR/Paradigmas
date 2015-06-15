package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Dom Quixote
 */
public class Triangulo {
    private Point centro;
    private int lado;
    private String path;
    private boolean aumentando;
    private double volta;

    public Triangulo(Point centro, int lado, String path) {
        this.centro = centro;
        this.lado = lado;
        this.path = path;
        volta = 1.0;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        int[] x = {centro.x, centro.x+lado, centro.x+lado};
        int[] y = {centro.y, centro.y+lado, centro.y};
        g.fillPolygon(x, y, 3);
    }
    

    public Point getCentro() {
        return centro;
    }

    public void setCentro(Point centro) {
        this.centro = centro;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isAumentando() {
        return aumentando;
    }

    public void setAumentando(boolean aumentando) {
        this.aumentando = aumentando;
    }

    public double getVolta() {
        return volta;
    }

    public void setVolta(double volta) {
        this.volta = volta;
    }
    
    
}
