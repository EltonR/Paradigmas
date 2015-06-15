package animator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

class AnimationPanel extends JPanel implements Runnable {

    private Dimension dim;
    private ObjectSet objs;
    private int millis;
    private boolean horrorshow;

    public AnimationPanel(ObjectSet objs, Dimension dim, int millis, boolean horrorshow) {
        this.setBackground(Color.BLACK);
        this.objs = objs;
        this.dim = dim;
        this.millis = millis;
        this.horrorshow = horrorshow;
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        objs.drawAll(g);
    }

    @Override
    public void run() {
        boolean isRunning = true;
        System.out.println("Running");
        int cor=0;
        if(horrorshow){
            //playSound();
            
        }
        while (isRunning) {
            objs.moveAll();
            repaint();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                isRunning = false;
                System.out.println("Stopped");
            }
            if(horrorshow){
                switch(cor){
                    case 0: setBackground(Color.BLUE); cor++; break;
                    case 1: setBackground(Color.yellow); cor++; break;
                    case 2: setBackground(Color.BLACK); cor++; break;
                    case 3: setBackground(Color.red); cor=0; break;
                }
            }
        }
    }
    
    public synchronized void playSound() {
        try {
                Thread.sleep(2700);
            } catch (InterruptedException e) {
                System.out.println("Stopped");
            }
    }
}

