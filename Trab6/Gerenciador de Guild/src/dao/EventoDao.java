package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import model.Evento;
import model.Personagem;

public class EventoDao {

    private EventoDao(){}
    private static EventoDao instancia;
    public static EventoDao getInstance(){
        if(instancia == null)
            instancia = new EventoDao();
        return instancia;
    }
    
    public Collection loadEventos(){
        System.out.println("Carregando Eventos...");
        FileInputStream fos;
        Collection eventos = null;
        try {
            fos = new FileInputStream("eventos");
            ObjectInputStream oos = new ObjectInputStream(fos);
            eventos = (ArrayList) oos.readObject();
            fos.close();
            System.out.println("Carregado!");
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        return eventos;
    }
    
    public void saveEvento(Evento ev){
        System.out.println("Salvando Evento...");
        Collection eventos = loadEventos();
        if(eventos == null)
            eventos = new ArrayList<>();
        eventos.add(ev);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("eventos", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(eventos);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteEvento(Evento p){
        System.out.println("Removendo Personagem...");
        ArrayList<Evento> eventos = (ArrayList<Evento>) loadEventos();
        if(eventos == null)
            eventos = new ArrayList<>();
        for(int i=0; i<eventos.size(); i++)
            if(eventos.get(i).getId() == p.getId())
                eventos.remove(i);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("eventos", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(eventos);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public int nextId(){
        int n=0;
        ArrayList<Evento> lista = (ArrayList<Evento>) loadEventos();
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getId() > n)
                n = lista.get(i).getId();
        }
        return (n+1);
    }
}
