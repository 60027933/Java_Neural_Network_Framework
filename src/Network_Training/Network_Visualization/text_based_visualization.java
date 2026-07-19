package Network_Training.Network_Visualization;
import Network_Architecture.*;

public class text_based_visualization {
    public void look_at_neurons(Network network){
        for(int i = 0; i < network.layers.length; i++){
            System.out.println("Layer " + i);
            for(int x = 0; x < network.layers[i].neurons.length; x++){
                System.out.println("Neuron no. " + x + ", activation: "+ network.layers[i].neurons[x].activation + ", activation function: " + network.layers[i].neurons[x].fn.name());
            }
        }
    }
}
