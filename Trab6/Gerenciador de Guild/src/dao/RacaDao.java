package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import model.Personagem;
import model.Raca;

public class RacaDao {

    private RacaDao() {}
    private static RacaDao instancia;
    public static RacaDao getInstance(){
        if(instancia == null)
            instancia = new RacaDao();
        return instancia;
    }
    
    public Collection loadRacas(){
        System.out.println("Carregando Raças...");
        Collection racas = null;
        FileInputStream fos;
        try {
            fos = new FileInputStream("racas");
            ObjectInputStream oos = new ObjectInputStream(fos);
            racas = (ArrayList) oos.readObject();
            fos.close();
            System.out.println("Raças Carregado!");
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage()); 
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        if(racas == null){
            racas = new ArrayList<>();
            Raca p1 = new Raca();
            Raca p2 = new Raca();
            Raca p3 = new Raca();
            Raca p4 = new Raca();
            Raca p5 = new Raca();
            Raca p6 = new Raca();            
            
            p1.setNome("Cacador");p1.setId(1);
            p2.setNome("Fazendeiro");p2.setId(2);
            p3.setNome("Lenhador");p3.setId(3);
            p4.setNome("Pescador");p4.setId(4);
            p5.setNome("Mineiro");p5.setId(5);
            p6.setNome("Marceneiro");p6.setId(6);
            
            racas.add(p1);racas.add(p2);racas.add(p3);racas.add(p4);racas.add(p5);racas.add(p6);
        } 
        return racas;
    }
    
    public void saveRaca(Raca p){
        System.out.println("Salvando Raça...");
        Collection racas = loadRacas();
        if(racas == null)
            racas = new ArrayList<>();
        racas.add(p);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("racas", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(racas);
            out.close();
            System.out.println("Raça SALVA!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteRaca(Raca p){
        System.out.println("Removendo Raça...");
        ArrayList<Raca> racas = (ArrayList<Raca>) loadRacas();
        if(racas == null)
            racas = new ArrayList<>();
        for(int i=0; i<racas.size(); i++)
            if(racas.get(i).getId() == p.getId())
                racas.remove(i);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("racas", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(racas);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public int nextId(){
        int n=0;
        ArrayList<Raca> lista = (ArrayList<Raca>) loadRacas();
        if(lista!=null)
            for(int i=0; i<lista.size(); i++){
                if(lista.get(i).getId() > n)
                    n = lista.get(i).getId();
            }
        return (n+1);
    }
    
}
