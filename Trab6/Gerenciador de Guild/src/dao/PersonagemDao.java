package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import model.Horario;
import model.Personagem;

public class PersonagemDao {

    private PersonagemDao(){}
    private static PersonagemDao instancia;
    public static PersonagemDao getInstance(){
        if(instancia == null)
            instancia = new PersonagemDao();
        return instancia;
    }
    
    public Collection loadPersonagens(){
        System.out.println("Carregando Personagens...");
        FileInputStream fos;
        Collection personagens = null;
        try {
            fos = new FileInputStream("personagens");
            ObjectInputStream oos = new ObjectInputStream(fos);
            personagens = (Collection) oos.readObject();
            fos.close();
            System.out.println("Carregado: "+personagens.size()+" personagens!");
        }catch(Exception e){
            personagens = null;
            System.out.println(e.getMessage()); 
        }
        return personagens;
    }
    public void savePersonagem(Personagem p){
        System.out.println("Salvando Personagem...");
        Collection personagens = PersonagemDao.this.loadPersonagens();
        if(personagens == null)
            personagens = new ArrayList<>();
        personagens.add(p);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("personagens", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(personagens);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void deletePersonagem(Personagem p){
        System.out.println("Removendo Personagem...");
        ArrayList<Personagem> personagens = (ArrayList<Personagem>) PersonagemDao.this.loadPersonagens();
        if(personagens == null)
            personagens = new ArrayList<>();
        for(int i=0; i<personagens.size(); i++)
            if(personagens.get(i).getId() == p.getId())
                personagens.remove(i);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("personagens", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(personagens);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void atualizaPersonagem(Personagem p){
        deletePersonagem(p);
        savePersonagem(p);
    }
    
    
    public Collection loadPersonagens(int n, String especialidade, Horario horario){
        ArrayList<Personagem> l = new ArrayList<>();
        ArrayList<Personagem> l2 = (ArrayList<Personagem>) PersonagemDao.this.loadPersonagens();
        for(int i=0; i<l2.size(); i++){
            for(int j=0; j<l2.get(i).getDisponibilidade().size(); j++)
                if(l2.get(i).getDisponibilidade().get(j).getDia().equalsIgnoreCase(horario.getDia()))
                    if(l2.get(i).getDisponibilidade().get(j).getHorario().equalsIgnoreCase(horario.getHorario()))
                        if(l2.get(i).getEspecialidade().equalsIgnoreCase(especialidade))
                            l.add(l2.get(i));
        }
        return l;
    }
    public Collection loadPersonagens(Horario horario){
        ArrayList<Personagem> l = new ArrayList<>();
        ArrayList<Personagem> l2 = (ArrayList<Personagem>) PersonagemDao.this.loadPersonagens();
        for(int i=0; i<l2.size(); i++){
            for(int j=0; j<l2.get(i).getDisponibilidade().size(); j++)
                if(l2.get(i).getDisponibilidade().get(j).getDia().equalsIgnoreCase(horario.getDia()))
                    if(l2.get(i).getDisponibilidade().get(j).getHorario().equalsIgnoreCase(horario.getHorario()))
                            l.add(l2.get(i));
        }
        return l;
    }
    
    public int nextId(){
        int n=0;
        ArrayList<Personagem> lista = (ArrayList<Personagem>) PersonagemDao.this.loadPersonagens();
        if(lista!=null)
            for(int i=0; i<lista.size(); i++){
                if(lista.get(i).getId() > n)
                    n = lista.get(i).getId();
            }
        return (n+1);
    }
}
