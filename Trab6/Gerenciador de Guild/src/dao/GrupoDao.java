package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import model.Grupo;
import model.Horario;

public class GrupoDao {
    
    private GrupoDao(){}
    private static GrupoDao instancia;
    public static GrupoDao getInstance(){
        if(instancia == null)
            instancia = new GrupoDao();
        return instancia;
    }
    
    
    public Collection loadGrupos(){
        System.out.println("Carregando Grupos...");
        FileInputStream fos;
        Collection grupos = new ArrayList<Grupo>();
        try {
            fos = new FileInputStream("grupos");
            ObjectInputStream oos = new ObjectInputStream(fos);
            grupos = (ArrayList) oos.readObject();
            fos.close();
            System.out.println("Grupos Carregados!");
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        return grupos;
    }
    public Collection loadGrupos(Horario horario){
        System.out.println("Carregando Grupos por horario...");
        ArrayList<Grupo> l2 = (ArrayList<Grupo>) loadGrupos();
        ArrayList<Grupo> l = new ArrayList<>();
        for(int i=0; i<l2.size(); i++)
            if(l2.get(i).getHorario().getDia().equalsIgnoreCase(horario.getDia()))
                if(l2.get(i).getHorario().getHorario().equalsIgnoreCase(horario.getHorario()))
                    l.add(l2.get(i));
        System.out.println("Grupos nesse horario: "+l.size());
        return l;
    }
    
    public void saveGrupo(Grupo p){
        System.out.println("Salvando Grupo...");
        Collection grupos = loadGrupos();
        if(grupos == null)
            grupos = new ArrayList<>();
        grupos.add(p);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("grupos", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(grupos);
            out.close();
            System.out.println("Grupos SALVOS!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteGrupo(Grupo p){
        System.out.println("Removendo Grupo...");
        ArrayList<Grupo> grupos = (ArrayList<Grupo>) loadGrupos();
        if(grupos == null)
            grupos = new ArrayList<>();
        for(int i=0; i<grupos.size(); i++)
            if(grupos.get(i).getId() == p.getId())
                grupos.remove(i);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("grupos", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(grupos);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    public int nextId(){
        int n=0;
        ArrayList<Grupo> lista = (ArrayList<Grupo>) loadGrupos();
        if(lista!=null)
            for(int i=0; i<lista.size(); i++){
                if(lista.get(i).getId() > n)
                    n = lista.get(i).getId();
            }
        return (n+1);
    }
    
}
