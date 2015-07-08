package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import model.Classe;
import model.Raca;

public class ClasseDao {

    private ClasseDao(){}
    private static ClasseDao instancia;
    public static ClasseDao getInstance(){
        if(instancia == null)
            instancia = new ClasseDao();
        return instancia;
    }
    
    public Collection loadClasses(){
        System.out.println("Carregando Classes...");
        FileInputStream fos;
        Collection classes = null;
        try {
            fos = new FileInputStream("classes");
            ObjectInputStream oos = new ObjectInputStream(fos);
            classes = (ArrayList) oos.readObject();
            fos.close();
            System.out.println("Carregado!");
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        if (classes == null){
            classes = new ArrayList<>();
            Classe r1 = new Classe();
            Classe r2 = new Classe();
            Classe r3 = new Classe();
            Classe r4 = new Classe();
            Classe r5 = new Classe();
            Classe r6 = new Classe();
            
            r1.setId(1);r1.setId(1);
            r2.setId(2);r2.setId(2);
            r3.setId(3);r3.setId(3);
            r4.setId(4);r4.setId(4);
            r5.setId(5);r5.setId(5);
            r6.setId(6);r6.setId(6);
            r1.setNome("Albion");
            r2.setNome("Hibernia");
            r3.setNome("Midgard");
            r4.setNome("Wilding");
            r5.setNome("Schotz");
            r6.setNome("Anschau");
            classes.add(r1);classes.add(r2);classes.add(r3);classes.add(r4);classes.add(r5);classes.add(r6);
        }
        return classes;
    }
    public void saveClasse(Classe p){
        System.out.println("Salvando Classe...");
        Collection classes = loadClasses();
        if(classes == null)
            classes = new ArrayList<>();
        classes.add(p);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("classes", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(classes);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void deleteClasse(Classe p){
        System.out.println("Removendo Classe...");
        ArrayList<Classe> classes = (ArrayList<Classe>) loadClasses();
        if(classes == null)
            classes = new ArrayList<>();
        for(int i=0; i<classes.size(); i++)
            if(classes.get(i).getId() == p.getId())
                classes.remove(i);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("classes", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(classes);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public int nextId(){
        int n=0;
        ArrayList<Classe> lista = (ArrayList<Classe>) loadClasses();
        if(lista!=null)
            for(int i=0; i<lista.size(); i++){
                if(lista.get(i).getId() > n)
                    n = lista.get(i).getId();
            }
        return (n+1);
    }
}
