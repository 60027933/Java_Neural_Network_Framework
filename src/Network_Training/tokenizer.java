package Network_Training;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class tokenizer {
    public ArrayList<String> tokens;
    public void initialize(String[] filenames){
        // Try-with-resources automatically closes the reader
        for(int f = 0; f < filenames.length; f++){
            try (BufferedReader br = new BufferedReader(new FileReader(filenames[f].toString()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    // Proceseses each line individually without keeping past lines in memory
                    line = line.toLowerCase();
                    line = line.replace("."," <dot> ");
                    line = line.replace(","," <comma> ");
                    
                    String[] words = line.split(" ");

                    for(int w = 0; w < words.length; w++){
                        if(in_tokenizer(words[w].toString()) == false){
                            tokens.add(words[w].toString());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean in_tokenizer(String token){
        return tokens.contains(token);
    }
}
