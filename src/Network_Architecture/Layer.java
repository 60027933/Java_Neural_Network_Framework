package Network_Architecture;

import Network_Architecture.Activation_Functions.actfn;

public class Layer {
    public Neuron[] neurons; // up to the initializer
    public actfn l_fn; // layer_function
    public Layer(actfn l_fn, int neuron_count){
        this.l_fn = l_fn;
        initialize(neuron_count);
    }
    public void initialize(int neuron_count){
        neurons = new Neuron[neuron_count];
        for(int i = 0; i < neurons.length; i++){
            neurons[i] = new Neuron(l_fn);
        }
    }
}
