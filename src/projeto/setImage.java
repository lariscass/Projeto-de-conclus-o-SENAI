package projeto;

import java.util.*;
import javax.swing.*;

public class setImage extends JFrame {

    public static Scanner intro = new Scanner(System.in);
    JLabel label;

    setImage(String gifFilename) {
        setLayout(null);
        setLocation(450, 150);
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        ImageIcon image = new ImageIcon(getClass().getResource("/jogogifs/" + gifFilename));
        label = new JLabel(image);
        label.setBounds(0, 0, 450, 450);
        add(label);

        setVisible(true);
    }

    public static int randomer(int x) {
        Random rand = new Random();
        return rand.nextInt(x);
    }

    public static void inicio() {
       // String inicioGifFilename = "começo.gif";
       // new setImage(inicioGifFilename);
        try {
            Thread.sleep(3000); // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void end(int acertos) {
//        String endGifFilename = "final.gif";
//        new setImage(endGifFilename);
//        JOptionPane.showMessageDialog(null, "Você acertou " + acertos + " perguntas!", "Pontuação Final", JOptionPane.INFORMATION_MESSAGE);
//
//        try {
//            Thread.sleep(2000); // 2 segundos
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.exit(0); // Finaliza o programa
//    }

    public static void end(int acertos) {
    String endGifFilename = "final.gif";
    new setImage(endGifFilename);
    
    //  pontuação
    JOptionPane.showMessageDialog(null, "Você acertou " + acertos + " perguntas!", "Pontuação Final", JOptionPane.INFORMATION_MESSAGE);
    
  
    String[] options = {"Jogar Novamente", "Voltar ao Menu Principal"};
    int escolha = JOptionPane.showOptionDialog(null, "Deseja continuar jogando ou voltar para o menu principal?", "Escolha uma opção",
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    
    if (escolha == 0) {
        // Jogar novamente
        new setImage("começo.gif");
        try {
            Thread.sleep(2000); // 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executarQuiz();  
    } else if (escolha == 1) {
        //home
       home home = new home();
       home.setLocationRelativeTo(null);
       home.setVisible(true);
      
        JOptionPane.showMessageDialog(null, "Voltando para o menu principal...", "Menu Principal", JOptionPane.INFORMATION_MESSAGE);
        
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     
    }
    
    //System.exit(0); 
}

    
    
    public static void executarQuiz() {
        //inicio();

       
        String[][] options = new String[20][7];

       
        options[0][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
        options[0][1] = "Puppet";
        options[0][2] = "Bonnie";
        options[0][3] = "Chica";
        options[0][4] = "Mangle";
        options[0][5] = "Puppet";
        options[0][6] = "puppet.gif";

        options[1][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
        options[1][1] = "Music Man";
        options[1][2] = "Freddy";
        options[1][3] = "Bonnie";
        options[1][4] = "Golden Freddy";
        options[1][5] = "Freddy";
        options[1][6] = "freddy.gif";

        // terceira pergunta mangle ok
         options[2][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[2][1] = "Moldem Freddy";
         options[2][2] = "Chica";
         options[2][3] = "Mangle";
         options[2][4] = "Rockstar Bonnie";
         options[2][5] = "Mangle";
         options[2][6] = "Mangle.gif";
 
         // quarta pergunta bonnie ok
         options[3][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[3][1] = "Bonnie";
         options[3][2] = "Toy Freddy";
        options[3][3] = "Rockstar Foxy";
         options[3][4] = "Pig Patch";
         options[3][5] = "Bonnie";
         options[3][6] = "bonnie.gif";
 
         // quinta pergunta chica ok 
         options[4][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[4][1] = "Happy Frog";
         options[4][2] = "Music Man";
         options[4][3] = "Orville Elephant";
         options[4][4] = "Chica";
        options[4][5] = "Chica";
        options[4][6] = "chica.gif";
 
         // sexta pergunta foxy ok
         options[5][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[5][1] = "Foxy";
         options[5][2] = "Funtime Foxy";
         options[5][3] = "Baby";
         options[5][4] = "Balloon Boy";
         options[5][5] = "Foxy";
         options[5][6] = "foxy.gif";
  
         // sétima pergunta baloon boy ok
         options[6][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
        options[6][1] = "Spring trap";
         options[6][2] = "Funtime Chica";
         options[6][3] = "Ballora";
         options[6][4] = "Balloon Boy";
         options[6][5] = "Balloon Boy";
         options[6][6] = "ballonboy.gif";
 
         // oitava pergunta springtrap ok
         options[7][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[7][1] = "Springtrap";
        options[7][2] = "Scraptrap";
         options[7][3] = "Funtime Freddy";
         options[7][4] = "Lefty";
         options[7][5] = "Springtrap";
         options[7][6] = "springtrap.gif";
     
         // nona pergunta ballora ok
         options[8][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
            options[8][1] = "Ballora";
         options[8][2] = "Baby";
         options[8][3] = "Foxy";
         options[8][4] = "Circus Baby";
         options[8][5] = "Ballora";
         options[8][6] = "ballora.gif";
 
         // décima pergunta baby ok
         options[9][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[9][1] = "Baby";
         options[9][2] = "Ballora";
         options[9][3] = "Funtime Foxy";
         options[9][4] = "Funtime Freddy";
         options[9][5] = "Baby";
         options[9][6] = "baby.gif";
 
         //11 pergunta Happy Frog ok
         options[10][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[10][1] = "Rockstar Foxy";
        options[10][2] = "Rockstar Foxy";
         options[10][3] = "Happy Frog";
         options[10][4] = "Rockstar Foxy";
         options[10][5] = "Happy Frog";
         options[10][6] = "HappyFrog.gif";
 
         //12 pergunta Rockstar Bonnie ok
         options[11][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
        options[11][1] = "Rockstar Bonnie";
         options[11][2] = "Happy Frog";
         options[11][3] = "Ned Bear";
         options[11][4] = "Lefty";
         options[11][5] = "Rockstar Bonnie";
         options[11][6] = "rockstarbonnie.gif";
 
         //13 lefty
         options[12][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[12][1] = "Lefty";
         options[12][2] = "Funtime Freddy";
         options[12][3] = "Molten Freddy";
         options[12][4] = "Helpy";
         options[12][5] = "Lefty";
         options[12][6] = "lefty.gif";
 
         //14 helpy
         options[13][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[13][1] = "Helpy";
         options[13][2] = "Happy Frog";
         options[13][3] = "Ned Bear";
         options[13][4] = "Orville Elephant";
         options[13][5] = "Helpy";
         options[13][6] = "Helpy.gif";
         
         //15 scraptrap
         options[14][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[14][1] = "Scraptrap";
         options[14][2] = "Springtrap";
         options[14][3] = "Lefty";
        options [14][4] = "Molten Freddy";
         options[14][5] = "Scraptrap";
         options[14][6] = "scrap.gif";
         
         //16  molten freddy
         options[15][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[15][1] = "Molten Freddy";
         options[15][2] = "Funtime Foxy";
        options[15][3] = "Funtime Freddy";
         options[15][4] = "Bonnie";
         options[15][5] = "Molten Freddy";
         options[15][6] = "moltenfreddy.gif";
 
 
         //17 ned bear
         options[16][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[16][1] = "Ned Bear";
         options[16][2] = "Happy Frog";
         options[16][3] = "Rockstar Foxy";
         options[16][4] = "Pigpatch";
         options[16][5] = "Ned Bear";
         options[16][6] = "nedbear.gif";
         
         //18 orville elephant
         options[17][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[17][1] = "Orville Elephant";
         options[17][2] = "Happy Frog";
         options[17][3] = "Ned Bear";
         options[17][4] = "Pigpatch";
         options[17][5] = "Orville Elephant";
         options[17][6] = "orvilleelephant.gif";
         
         //19 pigpatch
         options[18][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[18][1] = "Pigpatch";
        options[18][2] = "Happy Frog";
         options[18][3] = "Ned Bear";
         options[18][4] = "Rockstar Foxy";
         options[18][5] = "Pigpatch";
         options[18][6] = "pigpatch.gif";
         
         //20 rocktar chica
         options[19][0] = "ℚ𝕌𝔼𝕄 𝔼́ 𝔼𝕊𝕋𝔼 ℙ𝔼ℝ𝕊𝕆ℕ𝔸𝔾𝔼𝕄?";
         options[19][1] = "Rockstar Chica";
         options[19][2] = "Rockstar Freddy";
         options[19][3] = "Rockstar Bonnie";
         options[19][4] = "Rockstar Foxy";
         options[19][5] = "Rockstar Chica";
         options[19][6] = "rockstarchica.gif";

       
        Random rand = new Random();
        Set<Integer> usedIndices = new HashSet<>();
        int contador = 10;  //  perguntas no quiz
        int totalQuest = 20; //  perguntas disponíveis
        int nPergunta = 1;   //  número da questão

       
        
        
        String correctGifFilename = "acerto.gif";
        String incorrectGifFilename = "erro.gif";

        int acertos = 0;  //  acertos

       
        for (int i = 0; i < contador; i++) {
            int randomIndex;
            do {
                randomIndex = rand.nextInt(totalQuest);  
            } while (usedIndices.contains(randomIndex)); 
            usedIndices.add(randomIndex); 

           
            String question = options[randomIndex][0];
            String[] choices = {options[randomIndex][1], options[randomIndex][2], options[randomIndex][3], options[randomIndex][4]};
            String correctAnswer = options[randomIndex][5];
            String gifFilename = options[randomIndex][6];

         
            new setImage(gifFilename);

           
            String selectedOption = (String) JOptionPane.showInputDialog(null, question, "QUESTÃO " + nPergunta++, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

      
            if (selectedOption != null && selectedOption.equals(correctAnswer)) {
                //new setImage(correctGifFilename);  // Exibe gif de acerto
                acertos++;  // Incrementa contador de acertos
            } else {
                new setImage(incorrectGifFilename);  
                JOptionPane.showMessageDialog(null, correctAnswer, "RESPOSTA CERTA ERA", JOptionPane.ERROR_MESSAGE);
            }

           
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

      
        end(acertos);
    }
    
}
