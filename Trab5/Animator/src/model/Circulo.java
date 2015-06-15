package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Dom Quixote
 */
public class Circulo {
    protected Point centro;
    protected int raio;
    protected String path;
    protected boolean aumentando;
    protected double volta;
    protected int raio2;

    public Circulo(Point centro, int raio, String path) {
        this.centro = centro;
        this.raio = raio;
        this.path = path;
        raio2 = -1;
        aumentando = true;
        volta = 1.2;
    }
    
    public Circulo(Point centro, int raio, int raio2, String path) {
        this.centro = centro;
        this.raio = raio;
        this.raio2 = raio2;
        this.path = path;
        aumentando = true;
        volta = 1.2;
    }

    public void draw(Graphics graphics){
        graphics.setColor(Color.yellow);
        graphics.fillOval(centro.x, centro.y, raio, raio);
    }
    
    
    
    public double getVolta() {
        return volta;
    }

    public void setVolta(double volta) {
        this.volta = volta;
    }
    public Point getCentro() {
        return centro;
    }

    public void setCentro(Point centro) {
        this.centro = centro;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
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

}
