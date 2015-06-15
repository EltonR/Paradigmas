package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Dom Quixote
 */
public class Quadrado {
    private Point centro;
    private int lado;
    private String path;
    private boolean aumentando;
    private double volta;
    

    public Quadrado(Point centro, String path, int lado) {
        this.centro = centro;
        this.path = path;
        this.lado = lado;
        aumentando = true;
        volta = 1.2;
    }
    
    public void draw(Graphics graphics){
        graphics.setColor(Color.RED);
        graphics.fillRect(centro.x, centro.y, lado, lado);
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

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
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
