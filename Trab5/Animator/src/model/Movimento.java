package model;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Dom Quixote
 */
public class Movimento {
    private final int maxLadoRaio = 120;
    private final int minLadoRaio = 50;
    private Dimension dim;
    
    public Movimento(Dimension dim){
        this.dim = dim;
    }
    
    public Point reta(Point centro){
        centro.setLocation(centro.getX(), centro.getY()+2);
        if(centro.getY() >= dim.height)
            centro.setLocation(centro.getX(), -100);
        return centro;
    }
    
    public Point circulo(Point centro, int raio_circulo, double volta){
        int x = (int) Math.floor(centro.getX() + Math.cos(volta)*raio_circulo/4);
        int y = (int) Math.floor(centro.getY() + Math.sin(volta)*raio_circulo/4);
        Point centro2 = new Point(x, y);
        if(centro2.x < -170 || centro2.y < -170){
            centro2.x = dim.width+30;
            centro2.y = dim.height+30;
        }
        return centro2;
    }
    
    public int zoom(int raio_ou_lado, boolean aumentando){
        if(aumentando){
            return ++raio_ou_lado;
        }else
            return --raio_ou_lado;
    }
    
    public boolean isAumentando(int ladoRaio, boolean aumentando){
        if(ladoRaio >= maxLadoRaio && aumentando)
            return false;
        if(ladoRaio <= minLadoRaio && !aumentando)
            return true;
        return aumentando;
    }
    
    public Point bordas(Point point, double volta){
        if ((int)volta == 1){
            point.x+=3;
        }if ((int)volta == 2){
            point.y+=3;
        }if ((int)volta == 3){
            point.x-=3;
        }if ((int)volta == 4){
            point.y-=3;
        }
        return point;
    }
    public double setVolta(Point p, int alt, int larg, double volta){
        if((int)volta == 1 && (larg+p.x)>=dim.width)
            return 4;
        if((int)volta == 2 && (alt+p.y)>=dim.height)
            return 1;
        if((int)volta == 3 && (p.x)<=0)
            return 2;
        if((int)volta == 4 && (p.y)<=0)
            return 3;
        return volta;
    }
    
}

