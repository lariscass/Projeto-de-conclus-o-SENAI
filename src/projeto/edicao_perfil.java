
package projeto;

import com.mysql.jdbc.Connection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import projeto.UOficial.DatabaseConnection;

public class edicao_perfil extends javax.swing.JFrame {

     public String usuarioAtual;
     
    public edicao_perfil() {
        initComponents();
         
    }
    
  public edicao_perfil(String usuarioAtual) {
        initComponents();
        this.usuarioAtual = usuarioAtual;  
        carregarDadosUsuario();  
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        campoUsuario = new javax.swing.JTextField();
        campoNickname = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        salvar1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(951, 2, 70, 60));

        campoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        campoUsuario.setBorder(null);
        campoUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        campoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(campoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 200, 40));

        campoNickname.setBackground(new java.awt.Color(255, 255, 255));
        campoNickname.setBorder(null);
        campoNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNicknameActionPerformed(evt);
            }
        });
        getContentPane().add(campoNickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 200, 40));

        campoSenha.setBackground(new java.awt.Color(255, 255, 255));
        campoSenha.setBorder(null);
        getContentPane().add(campoSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 200, 40));

        salvar1.setBorder(null);
        salvar1.setContentAreaFilled(false);
        salvar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar1ActionPerformed(evt);
            }
        });
        getContentPane().add(salvar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 140, 40));

        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 580, 160, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oficial/ed perfil.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

 public void carregarDadosUsuario() {
        try (Connection conn = (Connection) DatabaseConnection.getConnection()) {
            String query = "SELECT c.nickname, l.senha2, l.usuario2 " +
                           "FROM login2 l " +
                           "JOIN cadastro2 c ON l.fk_cadastro = c.idcadastro " +
                           "WHERE l.usuario2 = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuarioAtual); 
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nickname = rs.getString("nickname");
                String senha = rs.getString("senha2");
                String usuario2 = rs.getString("usuario2");

              
                campoNickname.setText(nickname);
                campoSenha.setText(senha);
                campoUsuario.setText(usuario2);
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados do usuário.");
        }
    }
     private void salvarDados() {
        try (Connection conn = (Connection) DatabaseConnection.getConnection()) {
            System.out.println("Usuário Atual: " + usuarioAtual);
            System.out.println("Usuário atual: " + usuarioAtual);


            String query = "UPDATE login2 l " +
                           "JOIN cadastro2 c ON l.fk_cadastro = c.idcadastro " +
                           "SET l.usuario2 = ?, l.senha2 = ?, c.nickname = ?, c.usuario3 = ?, c.senha3 = ? " +
                           "WHERE l.usuario2 = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, campoUsuario.getText());
            stmt.setString(2, new String(campoSenha.getPassword()));  
            stmt.setString(3, campoNickname.getText());
            stmt.setString(4, campoUsuario.getText());// 
            stmt.setString(5, new String(campoSenha.getPassword())); 
            stmt.setString(6, usuarioAtual); 
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao atualizar os dados.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar os dados.");
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    home home = new home();
        home.setLocationRelativeTo(null);
        home.setVisible(true);
        this.dispose();  
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void salvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar1ActionPerformed
    salvarDados();
     JOptionPane.showMessageDialog(null, "Realize o login de novo", "Atenção", JOptionPane.WARNING_MESSAGE);
    
   

    }//GEN-LAST:event_salvar1ActionPerformed

    private void campoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUsuarioActionPerformed

    private void campoNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNicknameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        telalogin login = new telalogin();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
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
            java.util.logging.Logger.getLogger(edicao_perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edicao_perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edicao_perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edicao_perfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new edicao_perfil("usuario_logado").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoNickname;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton salvar1;
    // End of variables declaration//GEN-END:variables
}
