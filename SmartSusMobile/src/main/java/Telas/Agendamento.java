/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

import BD.DAO.AgendaDAO;
import BD.DAO.FuncionarioDAO;
import BD.DAO.UnidadeDAO;
import DadosGlobaisTemporarios.Logado;
import Entidades.Agenda;
import Entidades.Funcionario;
import Entidades.UnidadeUbs;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Leo
 */
public class Agendamento extends javax.swing.JFrame {

    /**
     * Creates new form Agendamento
     */
    public Agendamento() {
        
        initComponents();
        setListaUnidades();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        detalhesConsulta4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tipoConsulta = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        doutorSelect = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        motivoConsulta = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        unidadeSelect = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAgenda = new javax.swing.JTable();
        entraData = new javax.swing.JFormattedTextField();
        pesquisar = new javax.swing.JButton();
        confirmaConsulta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setForeground(new java.awt.Color(0, 0, 0));
        voltar.setText("<-");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        detalhesConsulta4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Tipo da Consulta:");

        tipoConsulta.setBackground(new java.awt.Color(204, 204, 204));
        tipoConsulta.setForeground(new java.awt.Color(0, 0, 0));
        tipoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consulta Médica", "Consulta Odontológica" }));
        tipoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoConsultaActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Doutor:");

        doutorSelect.setBackground(new java.awt.Color(204, 204, 204));
        doutorSelect.setForeground(new java.awt.Color(0, 0, 0));

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Motivo da consulta: ");

        motivoConsulta.setBackground(new java.awt.Color(255, 255, 255));
        motivoConsulta.setColumns(20);
        motivoConsulta.setLineWrap(true);
        motivoConsulta.setRows(5);
        jScrollPane1.setViewportView(motivoConsulta);

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Unidade:");

        unidadeSelect.setBackground(new java.awt.Color(204, 204, 204));
        unidadeSelect.setForeground(new java.awt.Color(0, 0, 0));
        unidadeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        unidadeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadeSelectActionPerformed(evt);
            }
        });

        tbAgenda.setBackground(new java.awt.Color(204, 204, 204));
        tbAgenda.setForeground(new java.awt.Color(0, 0, 0));
        tbAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "DATA", "HORARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbAgenda);

        entraData.setBackground(new java.awt.Color(255, 255, 255));
        entraData.setForeground(new java.awt.Color(0, 0, 0));
        try {
            entraData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        pesquisar.setBackground(new java.awt.Color(51, 204, 0));
        pesquisar.setForeground(new java.awt.Color(0, 0, 0));
        pesquisar.setText("Pesquisar");
        pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarActionPerformed(evt);
            }
        });

        confirmaConsulta.setBackground(new java.awt.Color(0, 204, 0));
        confirmaConsulta.setForeground(new java.awt.Color(0, 0, 0));
        confirmaConsulta.setText("Confirmar Consulta");
        confirmaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaConsultaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Selecione um horario: ");

        javax.swing.GroupLayout detalhesConsulta4Layout = new javax.swing.GroupLayout(detalhesConsulta4);
        detalhesConsulta4.setLayout(detalhesConsulta4Layout);
        detalhesConsulta4Layout.setHorizontalGroup(
            detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detalhesConsulta4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detalhesConsulta4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel18)
                            .addGroup(detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detalhesConsulta4Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(18, 18, 18)
                                    .addComponent(unidadeSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detalhesConsulta4Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(18, 18, 18)
                                    .addComponent(doutorSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detalhesConsulta4Layout.createSequentialGroup()
                                    .addComponent(entraData, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                    .addComponent(pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addComponent(confirmaConsulta))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        detalhesConsulta4Layout.setVerticalGroup(
            detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detalhesConsulta4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(unidadeSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(doutorSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(detalhesConsulta4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entraData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(detalhesConsulta4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoConsultaActionPerformed
    }//GEN-LAST:event_tipoConsultaActionPerformed

    private void unidadeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadeSelectActionPerformed
        setListaDoutores();
    }//GEN-LAST:event_unidadeSelectActionPerformed

    private void pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarActionPerformed
        preencheTabela();
    }//GEN-LAST:event_pesquisarActionPerformed

    private void confirmaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaConsultaActionPerformed
        
        int idFunc = FuncionarioDAO.lerIdFunc(retornaDoutor());
        int idUbs = unidadeSelect.getSelectedIndex();
        String horario = tbAgenda.getValueAt(tbAgenda.getSelectedRow(), 1).toString();
        String dia = tbAgenda.getValueAt(tbAgenda.getSelectedRow(), 0).toString();
        
        AgendaDAO.salvarConsulta(idFunc, Logado.getPaciente().getId(), idUbs,
                dia, horario, motivoConsulta.getText());
        
        voltar.doClick();
    }//GEN-LAST:event_confirmaConsultaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Agendamento().setVisible(true);
//            }
//        });
//    }
    
    public void setListaUnidades(){
        for(UnidadeUbs u : UnidadeDAO.lerListaUnidadeUbs()){
            unidadeSelect.addItem(u.getId()+"  "+u.getNome());
        }
    }
    
    public void setListaDoutores(){
        String tipo = tipoConsulta.getSelectedIndex() == 0 ? "M" : "D";
        for(Funcionario f : FuncionarioDAO.lerListaFuncionario(tipo)){
            doutorSelect.addItem(f.getId()+"  "+f.getNome());
        }
    }
    
    public Funcionario retornaDoutor(){
        String tipo = tipoConsulta.getSelectedIndex() == 0 ? "M" : "D";
        for(Funcionario f : FuncionarioDAO.lerListaFuncionario(tipo)){
            
            //se o doutor selecionado for igual ao doutor verificado retorna o doutor
            if(doutorSelect.getSelectedItem().toString().equals((f.getId()+"  "+f.getNome()))){
                return f;
            }
        }
        return null;
    }
    
    public void preencheTabela(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        String data = entraData.getText();
        Time horario = Time.valueOf("08:00:00");

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(horario);

        ArrayList<Agenda> agenda = new ArrayList<Agenda>();
        agenda = AgendaDAO.lerAgenda(data, FuncionarioDAO.lerIdFunc(retornaDoutor()));

        DefaultTableModel listaA = (DefaultTableModel) tbAgenda.getModel();
        listaA.setNumRows(0);

        for(int i = 0; i<20; i++ ){

            if(!horarioIndisponivel(agenda, horario.toString())){
                listaA.addRow(new Object[]{
                    data,
                    sdf.format(horario)
                });
            }
            gc.add(Calendar.MINUTE, 30);
            horario.setTime(gc.getTimeInMillis());
        }
    }

    public boolean horarioIndisponivel(ArrayList<Agenda> agenda, String horario){
        
        for(Agenda a : agenda){
            if(a.getHora().toString().equals(horario)){
                return true;
            }
        }
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmaConsulta;
    private javax.swing.JPanel detalhesConsulta4;
    private javax.swing.JComboBox<String> doutorSelect;
    private javax.swing.JFormattedTextField entraData;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea motivoConsulta;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTable tbAgenda;
    private javax.swing.JComboBox<String> tipoConsulta;
    private javax.swing.JComboBox<String> unidadeSelect;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
