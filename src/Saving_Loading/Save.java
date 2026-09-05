package Saving_Loading;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import Network_Architecture.*;

public class Save {
    public void save(Network network){
        String content = "";
        //modify the string such to represent the layers, their neurons, and the connections between
        
        try { 
            // Creates or overwrites 'network_default.txt' in the root directory
            Files.write(Paths.get("network_default.txt"), content.getBytes());
            System.out.println("Saved network successfully to 'network_default.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void save_to_path(Network network, String filepath){

    }
}
