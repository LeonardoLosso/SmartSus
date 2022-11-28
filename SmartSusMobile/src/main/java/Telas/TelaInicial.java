/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;

/**
 *
 * @author Leo
 */
public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        agendaConsulta = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        agendamentos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        remedios = new javax.swing.JLabel();
        vacinas = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 153, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        agendaConsulta.setBackground(new java.awt.Color(255, 255, 255));
        agendaConsulta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        agendaConsulta.setForeground(new java.awt.Color(0, 0, 0));
        agendaConsulta.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\SmartSusMobile\\src\\main\\java\\Imagens\\calendarioVazio.png")); // NOI18N
        agendaConsulta.setText("Agendar Consulta");
        agendaConsulta.setOpaque(true);
        agendaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agendaConsultaMouseClicked(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 153, 0));
        jSeparator1.setForeground(new java.awt.Color(51, 153, 0));
        jSeparator1.setOpaque(true);

        agendamentos.setBackground(new java.awt.Color(0, 0, 0));
        agendamentos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        agendamentos.setForeground(new java.awt.Color(0, 0, 0));
        agendamentos.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\SmartSusMobile\\src\\main\\java\\Imagens\\calendarioCheio.png")); // NOI18N
        agendamentos.setText("Agendamentos");
        agendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agendamentosMouseClicked(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(51, 153, 0));
        jSeparator2.setForeground(new java.awt.Color(51, 153, 0));
        jSeparator2.setOpaque(true);

        remedios.setBackground(new java.awt.Color(0, 0, 0));
        remedios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        remedios.setForeground(new java.awt.Color(0, 0, 0));
        remedios.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\SmartSusMobile\\src\\main\\java\\Imagens\\remedios.png")); // NOI18N
        remedios.setText("Verificar Remedios");
        remedios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remediosMouseClicked(evt);
            }
        });

        vacinas.setBackground(new java.awt.Color(0, 0, 0));
        vacinas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        vacinas.setForeground(new java.awt.Color(0, 0, 0));
        vacinas.setIcon(new javax.swing.ImageIcon("C:\\Users\\Leo\\Documents\\NetBeansProjects\\SmartSusMobile\\src\\main\\java\\Imagens\\vacina.png")); // NOI18N
        vacinas.setText("Verificar Vacinas");
        vacinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vacinasMouseClicked(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(51, 153, 0));
        jSeparator4.setForeground(new java.awt.Color(51, 153, 0));
        jSeparator4.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator4)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agendamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vacinas, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(remedios, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(agendaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(agendaConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agendamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(remedios, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vacinas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vacinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vacinasMouseClicked
        Vacinas tela = new Vacinas();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vacinasMouseClicked

    private void remediosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remediosMouseClicked
        Remedios tela = new Remedios();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_remediosMouseClicked

    private void agendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agendamentosMouseClicked
        ListaAgendamento tela = new ListaAgendamento();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agendamentosMouseClicked

    private void agendaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agendaConsultaMouseClicked
        Agendamento tela = new Agendamento();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agendaConsultaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agendaConsulta;
    private javax.swing.JLabel agendamentos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel remedios;
    private javax.swing.JLabel vacinas;
    // End of variables declaration//GEN-END:variables
}
