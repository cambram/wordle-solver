import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> listOfWords;
    private BufferedReader bf;

    public Words() throws FileNotFoundException{
        listOfWords = new ArrayList<String>();
        bf = new BufferedReader(new FileReader("words.txt"));
    }

    public void init() throws IOException{
        String line = bf.readLine();
        while (line != null) {
            listOfWords.add(line);
            line = bf.readLine();
        }
        bf.close();
    }

    public void removeLetter(String letter){
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < listOfWords.size(); i++) {
            if(!listOfWords.get(i).contains(letter)){
                temp.add(listOfWords.get(i));
            }
        }

        listOfWords.clear();
        for(int i = 0; i < temp.size(); i++){
            listOfWords.add(temp.get(i));
        } 
    }

    public void includeLetter(String[] letter){
        int check = 0;
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < listOfWords.size(); i++) {
            check = 0;
            for(int j = 0; j < letter.length; j++){
                if(listOfWords.get(i).contains(letter[j])){
                    check++;
                }
                if(check == letter.length){
                    temp.add(listOfWords.get(i));
                }
            }
        }
        
        listOfWords.clear();
        for(int i = 0; i < temp.size(); i++){
            listOfWords.add(temp.get(i));
        } 
    }

    public void position(char[] positions){
        int check = 0, letters = 0;
        for(int i = 0; i < positions.length; i++){
            if(positions[i] != '#')
                letters++;
        }

        if(letters == 0){
            return;
        }

        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < listOfWords.size(); i++) {
            check = 0;
            for(int j = 0; j < positions.length; j++){
                if(positions[j] != '#'){
                    if(listOfWords.get(i).charAt(j) == positions[j])
                        check++;
                }
                if(letters == check){
                    temp.add(listOfWords.get(i));
                    break;
                }
            }
        }
        
        listOfWords.clear();
        for(int i = 0; i < temp.size(); i++){
            listOfWords.add(temp.get(i));
        }
    }

    public void output(){
        Path output = Paths.get("output.txt");
        try {
            Files.write(output, listOfWords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
