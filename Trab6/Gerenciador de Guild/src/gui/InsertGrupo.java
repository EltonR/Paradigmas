package gui;

import dao.GrupoDao;
import dao.PersonagemDao;
import dao.ProfissaoDao;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Grupo;
import model.Horario;
import model.Personagem;
import model.Profissao;

public class InsertGrupo extends javax.swing.JFrame {

    private ArrayList<Personagem> personagens_todos;
    private ArrayList<Personagem> personagens_grupo;
    private ArrayList<Profissao> profs;
    
    public InsertGrupo() {
        initComponents();
        profs = (ArrayList<Profissao>) ProfissaoDao.getInstance().loadProfissoes();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<profs.size(); i++){
            for(int j=0; j<profs.get(i).getEspecialidades().size(); j++){
                list.add(profs.get(i).getEspecialidades().get(j));
            }
        }
        Collections.sort(list);
        
        personagens_grupo = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            jComboBox5.addItem(list.get(i));
        }
        
        atualizaPersonagens();
    }

    
    
    private void atualizaTabela(){
        String[] colunas = {"Personagem", "Especialidade"};
        DefaultTableModel dtm = new DefaultTableModel(null, colunas);
        for(int i=0; i<personagens_grupo.size(); i++){
            dtm.addRow(new Object[]{personagens_grupo.get(i).getNomePersonagem(), personagens_grupo.get(i).getEspecialidade()});
        }
        jTable1.setModel(dtm);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserir Grupo");

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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Dia:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Horario:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00 - 01:00", "01:00 - 02:00", "02:00 - 03:00", "03:00 - 04:00", "04:00 - 05:00", "05:00 - 06:00", "06:00 - 07:00", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00", "19:00 - 20:00", "20:00 - 21:00", "21:00 - 22:00", "22:00 - 23:00", "23:00 - 24:00" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton5.setText("Criar Grupo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Personagens Nesse Horario:");

        jButton4.setText("Inserir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel5.setText("Especialidade:");

        jButton1.setText("Inserir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Nome do Grupo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 187, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        boolean adicionado = false;
        for(int j=0; j<personagens_todos.get(jComboBox3.getSelectedIndex()).getDisponibilidade().size(); j++){
            if(personagens_todos.get(jComboBox3.getSelectedIndex()).getDisponibilidade().get(j).getDia().equalsIgnoreCase(jComboBox1.getSelectedItem().toString()))
                if(personagens_todos.get(jComboBox3.getSelectedIndex()).getDisponibilidade().get(j).getHorario().equalsIgnoreCase(jComboBox2.getSelectedItem().toString())){
                    personagens_grupo.add(personagens_todos.get(jComboBox3.getSelectedIndex()));
                    adicionado = true;
                }
        }
        if(adicionado)
            atualizaTabela();
        else
            JOptionPane.showMessageDialog(rootPane, "Personagem nao possui este horario disponivel");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int n = Integer.valueOf(jComboBox4.getSelectedItem().toString());
        String s = jComboBox5.getSelectedItem().toString();
        Horario horario = new Horario();
        horario.setDia(jComboBox1.getSelectedItem().toString());
        horario.setHorario(jComboBox2.getSelectedItem().toString());
        ArrayList<Personagem> lista = (ArrayList<Personagem>) PersonagemDao.getInstance().loadPersonagens(n, s, horario);
        if(lista.size() < n){
            JOptionPane.showMessageDialog(rootPane, "Existem apenas "+lista.size()+ " personagens \ncom este horario e esta especialidade!");
            return;
        }
        for(int i=0; i<n; i++){
            personagens_grupo.add(lista.get(i));
        }
        atualizaTabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(personagens_grupo.size() != 5 && personagens_grupo.size() != 10 && personagens_grupo.size() != 25){
            JOptionPane.showMessageDialog(rootPane, "Grupos devem possuir 5, 10 ou 25 integrantes");
            return;
        }
        if(jTextField1.getText().replace(" ", "").equals("") || jTextField1.getText() == null){
            JOptionPane.showMessageDialog(rootPane, "Grupos Necessitam ter nome!");
            return;
        }
        Grupo g = new Grupo();
        g.setId(GrupoDao.getInstance().nextId());
        g.setPersonagens(personagens_grupo);
        g.setNome(jTextField1.getText());
        Horario horario = new Horario();
        horario.setDia(jComboBox1.getSelectedItem().toString());
        horario.setHorario(jComboBox2.getSelectedItem().toString());
        g.setHorario(horario);
        GrupoDao.getInstance().saveGrupo(g);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        atualizaPersonagens();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        atualizaPersonagens();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void atualizaPersonagens(){
        Horario h = new Horario();
        h.setDia(jComboBox1.getSelectedItem().toString());
        h.setHorario(jComboBox2.getSelectedItem().toString());
        personagens_todos = (ArrayList<Personagem>) PersonagemDao.getInstance().loadPersonagens(h);
        jComboBox3.removeAllItems();
        for(int i=0; i<personagens_todos.size(); i++){
            jComboBox3.addItem(personagens_todos.get(i).getNomePersonagem()+ " - "+personagens_todos.get(i).getEspecialidade());
        }
        personagens_grupo.clear();    
        atualizaTabela();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}


