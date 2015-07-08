package gui;

import dao.ClasseDao;
import dao.EventoDao;
import dao.GrupoDao;
import dao.PersonagemDao;
import dao.ProfissaoDao;
import dao.RacaDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Classe;
import model.Evento;
import model.Grupo;
import model.Personagem;
import model.Profissao;
import model.Raca;

public class Listar extends javax.swing.JFrame {
    
    private String titulo;

    private void atualiza(){
        String[] colunasPers = {"Nome Personagem", "Nome Jogador", "Raça", "Classe", "Level", "Profissao", "Level Profissao", "Especialidade"};
        String[] colunasProfs = {"Profissao"};
        String[] colunasEvents = {"Evento", "Grupo", "Data"};
        String[] colunasClasses = {"Classe"};
        String[] colunasRacas = {"Raça"};
        String[] colunasGrupos = {"Grupo", "Total de Personagens", "Horario"};
        DefaultTableModel dtm = null;
        
        if(titulo.equalsIgnoreCase("Listar Personagens")){
            dtm = new DefaultTableModel(null,colunasPers);
            if(PersonagemDao.getInstance().loadPersonagens() != null){
                ArrayList<Personagem> c = (ArrayList<Personagem>) PersonagemDao.getInstance().loadPersonagens();
                for(int i=0; i<c.size(); i++){
                    dtm.addRow(new Object[]{c.get(i).getNomePersonagem(), c.get(i).getNomeJogador(), c.get(i).getRaca(), c.get(i).getClasse(), 
                        c.get(i).getLevel(), c.get(i).getProfissao(), c.get(i).getProfissao_level(), c.get(i).getEspecialidade()});
                }
            }
        }
        
        if(titulo.equalsIgnoreCase("Listar Profissoes")){
            dtm = new DefaultTableModel(null,colunasProfs);
            if(ProfissaoDao.getInstance().loadProfissoes()!= null){
                ArrayList<Profissao> c = (ArrayList<Profissao>) ProfissaoDao.getInstance().loadProfissoes();
                for(int i=0; i<c.size(); i++){
                    dtm.addRow(new Object[]{c.get(i).getNome()});
                }
            }
            
        }
        
        if(titulo.equalsIgnoreCase("Listar Eventos")){
            dtm = new DefaultTableModel(null,colunasEvents);
            if(EventoDao.getInstance().loadEventos()!= null){
                ArrayList<Evento> c = (ArrayList<Evento>) EventoDao.getInstance().loadEventos();
                for(int i=0; i<c.size(); i++){
                    dtm.addRow(new Object[]{c.get(i).getNome(), c.get(i).getGrupo().getNome(), c.get(i).getHorario().getDia() + " - " + c.get(i).getHorario().getHorario()});
                }
            }
        }
        
        if(titulo.equalsIgnoreCase("Listar Raças")){
            dtm = new DefaultTableModel(null,colunasRacas);
            if(RacaDao.getInstance().loadRacas() != null){
                ArrayList<Raca> c = (ArrayList<Raca>) RacaDao.getInstance().loadRacas();
                for(int i=0; i<c.size(); i++){
                    dtm.addRow(new Object[]{c.get(i).getNome()});
                }
            }
        }
        
        if(titulo.equalsIgnoreCase("Listar Classes")){
            dtm = new DefaultTableModel(null,colunasClasses);
            if(ClasseDao.getInstance().loadClasses() != null){
                ArrayList<Classe> c = (ArrayList<Classe>) ClasseDao.getInstance().loadClasses();
                for(int i=0; i<c.size(); i++){
                    dtm.addRow(new Object[]{c.get(i).getNome()});
                }
            }
        }
        
        if(titulo.equalsIgnoreCase("Listar Grupos")){
            dtm = new DefaultTableModel(null,colunasGrupos);
            if(GrupoDao.getInstance().loadGrupos() != null){
                ArrayList<Grupo> c = (ArrayList<Grupo>) GrupoDao.getInstance().loadGrupos();
                for(int i=0; i<c.size(); i++){
                    dtm.addRow(new Object[]{c.get(i).getNome(), c.get(i).getPersonagens().size(), c.get(i).getHorario().getDia()+" - "+c.get(i).getHorario().getHorario()});
                }
            }
        }
        
        jTable1.setModel(dtm);
        this.setTitle(titulo);
    }
    
    public Listar(String titulo) {
        this.titulo = titulo;
        initComponents();
        atualiza();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Personages");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Atualizar");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        if(titulo.equalsIgnoreCase("Listar Personagens") || titulo.equalsIgnoreCase("Listar Profissoes"))
            jButton3.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(titulo.equalsIgnoreCase("Listar Personagens")){
            InsertPersonagem i = new InsertPersonagem();
            i.setVisible(true);
        }
        if(titulo.equalsIgnoreCase("Listar Profissoes")){
            InsertProfissao i = new InsertProfissao();
            i.setVisible(true);
        }
        if(titulo.equalsIgnoreCase("Listar Eventos")){
            InsertEvento i = new InsertEvento();
            i.setVisible(true);
        }
        if(titulo.equalsIgnoreCase("Listar Grupos")){
            InsertGrupo i = new InsertGrupo();
            i.setVisible(true);
        }
        if(titulo.equalsIgnoreCase("Listar Classes")){
            InsertClasse i = new InsertClasse();
            i.setVisible(true);
        }
        if(titulo.equalsIgnoreCase("Listar Raças")){
            InsertRaca i = new InsertRaca();
            i.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(titulo.equalsIgnoreCase("Listar Personagens")){
            InsertPersonagem i = new InsertPersonagem(jTable1.getSelectedRow());
            i.setVisible(true);
        }
        if(titulo.equalsIgnoreCase("Listar Profissoes")){
            InsertProfissao i = new InsertProfissao(jTable1.getSelectedRow());
            i.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(titulo.equalsIgnoreCase("Listar Personagens")){
            ArrayList<Personagem> personagens = (ArrayList<Personagem>) PersonagemDao.getInstance().loadPersonagens();
            PersonagemDao.getInstance().deletePersonagem(personagens.get(jTable1.getSelectedRow()));
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
        }
        if(titulo.equalsIgnoreCase("Listar Raças")){
            ArrayList<Raca> racas = (ArrayList<Raca>) RacaDao.getInstance().loadRacas();
            RacaDao.getInstance().deleteRaca(racas.get(jTable1.getSelectedRow()));
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
        }
        if(titulo.equalsIgnoreCase("Listar Classes")){
            ArrayList<Classe> classes = (ArrayList<Classe>) ClasseDao.getInstance().loadClasses();
            ClasseDao.getInstance().deleteClasse(classes.get(jTable1.getSelectedRow()));
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
        }
        if(titulo.equalsIgnoreCase("Listar Grupos")){
            ArrayList<Grupo> classes = (ArrayList<Grupo>) GrupoDao.getInstance().loadGrupos();
            GrupoDao.getInstance().deleteGrupo(classes.get(jTable1.getSelectedRow()));
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
        }
        if(titulo.equalsIgnoreCase("Listar Eventos")){
            ArrayList<Evento> classes = (ArrayList<Evento>) EventoDao.getInstance().loadEventos();
            EventoDao.getInstance().deleteEvento(classes.get(jTable1.getSelectedRow()));
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
        }
        if(titulo.equalsIgnoreCase("Listar Profissoes")){
            ArrayList<Profissao> profissoes = (ArrayList<Profissao>) ProfissaoDao.getInstance().loadProfissoes();
            ProfissaoDao.getInstance().deleteProfissao(profissoes.get(jTable1.getSelectedRow()));
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
        }
        atualiza();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
