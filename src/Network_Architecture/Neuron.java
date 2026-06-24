package Network_Architecture;
import Network_Architecture.Activation_Functions.*;
public class Neuron {
    //NEEDS TO STORE: ACTIVATION FUNCTION, BIAS
    // Activation is the value of the neuron.
    public actfn fn;
    public float activation = 0; // 0 base value; 
    public float bias = 0; // 0 base;
    public Connection[] inputConnections; // up to the network to properly initialize this
    
    public Neuron(actfn fn){
        this.fn = fn;
    }
    //
    public float sum_connections(Connection[] c){
        float sum = 0;
        for(int i = 0; i < c.length; i++){
            sum += c[i].baseNeuron.activation * c[i].weight;
        }
        return sum;
    }
    public void calc_activation(Connection[] c){
        activation = 0; // 'reset' the neuron
        activation = sum_connections(c);
        activation += bias;
        activation = activation_funcs.apply(activation,fn);
    }
}
