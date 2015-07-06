package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import model.Classe;
import model.Profissao;

public class ProfissaoDao {

    private ProfissaoDao(){}
    private static ProfissaoDao instancia;
    public static ProfissaoDao getInstance(){
        if(instancia == null)
            instancia = new ProfissaoDao();
        return instancia;
    }
    
    public Collection loadProfissoes(){
        System.out.println("Carregando Profissoes...");
        Collection profissoes = null;
        FileInputStream fos;
        try {
            fos = new FileInputStream("profissoes");
            ObjectInputStream oos = new ObjectInputStream(fos);
            profissoes = (ArrayList) oos.readObject();
            fos.close();
            System.out.println("Carregado!");
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage()); 
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        if(profissoes == null){
            profissoes = new ArrayList<>();
            Profissao p1 = new Profissao();
            Profissao p2 = new Profissao();
            Profissao p3 = new Profissao();
            Profissao p4 = new Profissao();
            Profissao p5 = new Profissao();
            Profissao p6 = new Profissao();            
            
            p1.setNome("Cacador");
            String[] p1E = {"Arqueiro", "Maceman", "Atirador", "Armadilhas", "Rastreamento"};
            p1.setEspecialidades(new ArrayList<String>(Arrays.asList(p1E)));
            p2.setNome("Fazendeiro");
            String[] p2E = {"Plantador", "Vaqueiro", "Suinocultor", "Avicultor", "Apicultor"};
            p2.setEspecialidades(new ArrayList<String>(Arrays.asList(p2E)));
            p3.setNome("Lenhador");
            String[] p3E = {"Cortes Precisos", "Madeira de Lei", "Moto-Serra"};
            p3.setEspecialidades(new ArrayList<String>(Arrays.asList(p3E)));
            p4.setNome("Pescador");
            String[] p4E = {"Arpao", "Anzol", "Rede", "Agua Salgada", "Pesca com as Maos", "Mergulho"};
            p4.setEspecialidades(new ArrayList<String>(Arrays.asList(p4E)));
            p5.setNome("Mineiro");
            String[] p5E = {"Escavador", "Motorista de Escavadeira", "Explosivos", "Prospector"};
            p5.setEspecialidades(new ArrayList<String>(Arrays.asList(p5E)));
            p6.setNome("Marceneiro");
            String[] p6E = {"Moveis", "Tabuas", "Pre-moldados", "Construcao"};
            p6.setEspecialidades(new ArrayList<String>(Arrays.asList(p6E)));
            
            profissoes.add(p1);profissoes.add(p2);profissoes.add(p3);profissoes.add(p4);profissoes.add(p5);profissoes.add(p6);
        } 
        return profissoes;
    }
    public void saveProfissao(Profissao p){
        System.out.println("Salvando Profissao...");
        Collection profissoes = loadProfissoes();
        if(profissoes == null)
            profissoes = new ArrayList<>();
        profissoes.add(p);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("profissoes", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(profissoes);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void deleteProfissao(Profissao p){
        System.out.println("Removendo Profissao...");
        ArrayList<Profissao> profissoes = (ArrayList<Profissao>) loadProfissoes();
        if(profissoes == null)
            profissoes = new ArrayList<>();
        for(int i=0; i<profissoes.size(); i++)
            if(profissoes.get(i).getId() == p.getId())
                profissoes.remove(i);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("profissoes", false);
            out = new ObjectOutputStream(fos);
            out.writeObject(profissoes);
            out.close();
            System.out.println("SALVO!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public int nextId(){
        int n=0;
        ArrayList<Profissao> lista = (ArrayList<Profissao>) loadProfissoes();
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getId() > n)
                n = lista.get(i).getId();
        }
        return (n+1);
    }
    
}
