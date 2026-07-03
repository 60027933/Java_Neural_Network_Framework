import Network_Architecture.*;
import Network_Architecture.Activation_Functions.actfn;

public class Main {
    public static void main(String[] args){
        Layer test_layer = new Layer(actfn.RELU,20);
        for(int i = 0; i < test_layer.neurons.length; i++){
            System.out.println("Neuron no. " + i + ", activation: "+ test_layer.neurons[i].activation + ", activation function: " + test_layer.neurons[i].fn.name());
        }
    }
}