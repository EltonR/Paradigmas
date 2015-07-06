package control;

import gui.MenuPrincipal;

public class Control {
    
    
    private static Control control;
    
    private Control(){}
    public static Control getInstance(){
        if(control == null)
            new Control();
        return control;
    }
    
    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
    }
    
    
}
