import Network_Architecture.*;
import Network_Architecture.Activation_Functions.actfn;

public class Main {
    public static void main(String[] args){
        
        Layer[] test_layers = new Layer[] {
            new Layer(actfn.RELU,20),
            new Layer(actfn.RELU, 50),
            new Layer(actfn.SIGMOID,10)
        };
        Network test_network = new Network(test_layers);

        double[] inputs = new double[] {
            0.0,2.0,3.0,3.0,3.0,2.0,3.0,3.0,1.0,3.0,3.0,3.0,3.0,9.0,3.0,3.0,1.0,3.0,3.0,3.0
        };
        test_network.run(inputs);
    }
}
