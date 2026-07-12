import Network_Architecture.*;
import Network_Architecture.Activation_Functions.actfn;

public class Main {
    public static void main(String[] args){
        
        Layer[] test_layers = new Layer[] {
            new Layer(actfn.RELU,20),
            new Layer(actfn.SIGMOID, 50),
        };
        Network test_network = new Network(test_layers);


        for(int i = 0; i < test_network.layers.length; i++){
            System.out.println("Layer " + i);
            for(int x = 0; x < test_network.layers[i].neurons.length; x++){
                System.out.println("Neuron no. " + x + ", activation: "+ test_network.layers[i].neurons[x].activation + ", activation function: " + test_network.layers[i].neurons[x].fn.name());
            }
        }
    }
}
