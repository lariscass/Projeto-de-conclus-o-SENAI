package projeto;



import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class UOficial {



    public static class DatabaseConnection {
       
      
        
        private static final String URL = "jdbc:mysql://localhost:3306/pixelpulse";
        private static final String USER = "root"; 
        private static final String PASSWORD = "123456";

       
        public static Connection getConnection() throws SQLException {
           
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
       
    }

    
    
    
   private static String usuarioLogado;  






////O CERTOOO
    public String verificarLogin(String usuario, String senha) {
        String nickname = null;  

        
        try (Connection conn = DatabaseConnection.getConnection()) {            
            String query = "SELECT l.senha2, c.nickname FROM login2 l JOIN cadastro2 c ON l.usuario2 = c.usuario3 WHERE l.usuario2 = ?";  
            
          
           PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuario);  

         
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {  
                String senhaBanco = rs.getString("senha2");  

               
                if (senha.equals(senhaBanco)) {
                    nickname = rs.getString("nickname");  
                    
                 
                    usuarioLogado = usuario;  
                    return nickname;  
                }
            }

       } catch (SQLException ex) {
            ex.printStackTrace();  
        }

        return null;  
    }


    public static String getUsuarioLogado() {
        return usuarioLogado;
   }
//O CERTOOO
   
 
  

}



  




    
    
    



  
    

   
    

