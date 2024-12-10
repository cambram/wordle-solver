import java.io.IOException;
import javax.swing.JOptionPane;

public class Main{
    public static void main(String args[]) throws IOException{
        String exclude = JOptionPane.showInputDialog("Type the letters you want to exclude (abcd...)");
        String include = JOptionPane.showInputDialog("Type the letters you want to include (abcd...)");
        String positions = JOptionPane.showInputDialog("Type the positions of letters like this (##c##)");
        
        Words word = new Words();
        word.init();
        String letter; 
        String [] includeArr = new String[include.length()];

        if(include.length() != 0){
            for(int i = 0; i < exclude.length(); i++){
                letter = String.valueOf(exclude.charAt(i));
                word.removeLetter(letter);
            }
        }

        for(int i = 0; i < include.length(); i++){
            includeArr[i] = String.valueOf(include.charAt(i));
        }
        word.includeLetter(includeArr);

        char[] positionArr = new char[5];
        for(int i = 0; i < positionArr.length; i++){
            positionArr[i] = positions.charAt(i);
        }
        word.position(positionArr);
        word.output();
    }
}