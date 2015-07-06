package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Personagem implements Serializable{
    private int id;
    private String nome_jogador;
    private String nome_personagem;
    private String raca;
    private String classe;
    private int level;
    private String profissao;
    private int profissao_level;
    private String especialidade;
    private ArrayList<Horario> disponibilidade;
    
    public Personagem(){
        disponibilidade = new ArrayList<>();
    }

    public String getNomePersonagem() {
        return nome_personagem;
    }

    public void setNomePersonagem(String nome) {
        this.nome_personagem = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getProfissao_level() {
        return profissao_level;
    }

    public void setProfissao_level(int profissao_level) {
        this.profissao_level = profissao_level;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public ArrayList<Horario> getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(ArrayList<Horario> disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getNomeJogador() {
        return nome_jogador;
    }

    public void setNomeJogador(String nome_jogador) {
        this.nome_jogador = nome_jogador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_jogador() {
        return nome_jogador;
    }

    public void setNome_jogador(String nome_jogador) {
        this.nome_jogador = nome_jogador;
    }

    public String getNome_personagem() {
        return nome_personagem;
    }

    public void setNome_personagem(String nome_personagem) {
        this.nome_personagem = nome_personagem;
    }
    
    
}
