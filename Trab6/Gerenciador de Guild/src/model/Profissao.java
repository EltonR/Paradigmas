package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Profissao implements Serializable{
    
    private int id;
    private String nome;
    private ArrayList<String> especialidades;
    
    public Profissao(){
        especialidades = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(ArrayList<String> especialidades) {
        this.especialidades = especialidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
