package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projeto.UOficial.DatabaseConnection;
public class perfil extends javax.swing.JFrame {

  
    public perfil() {
        
        initComponents();
         carregarDadosPerfil();
    }
 
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPerfil = new javax.swing.JButton();
        jLabelSenha = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelNickname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editPerfil.setBorder(null);
        editPerfil.setContentAreaFilled(false);
        editPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(editPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 570, 140, 30));

        jLabelSenha.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(jLabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 470, 200, 40));

        jLabelUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 200, 40));

        jLabelNickname.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        getContentPane().add(jLabelNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 200, 40));

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 70, 60));

        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 520, 200, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficial/PERFIL.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
private void carregarDadosPerfil() {
    String usuarioLogado = UOficial.getUsuarioLogado();  

    if (usuarioLogado != null) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT c.nickname, l.senha2, l.usuario2 " +
                           "FROM login2 l " +
                           "JOIN cadastro2 c ON l.fk_cadastro = c.idcadastro " +
                           "WHERE l.usuario2 = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuarioLogado);  

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                jLabelUsuario.setText(  rs.getString("usuario2"));
                jLabelNickname.setText(rs.getString("nickname"));
                jLabelSenha.setText( rs.getString("senha2"));
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } else {
        jLabelUsuario.setText("Usuário não encontrado.");
    }
}

    
    
    

    
    private void editPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPerfilActionPerformed
 
      
    
String usuarioLogado = UOficial.getUsuarioLogado(); //  nome do usuário logado
edicao_perfil edicao = new edicao_perfil(usuarioLogado); 
edicao.setLocationRelativeTo(null);
edicao.setVisible(true);
this.dispose();
        
    }//GEN-LAST:event_editPerfilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        home home = new home();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        biblioteca teca = new biblioteca();
        teca.setLocationRelativeTo(null);
       teca.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new perfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNickname;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    // End of variables declaration//GEN-END:variables
}
