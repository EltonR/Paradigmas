package model;

import java.io.Serializable;

public class Horario implements Serializable{
    
    private String dia;
    private String horario;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
}
