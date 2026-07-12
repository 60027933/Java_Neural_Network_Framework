package Network_Architecture;

public class Network {
    public Layer[] layers;
    public Connection[][][] connections;
    /*
    { // Every layer 
        { // Every Neuron
            { // Every Connection
            }
        }
    }
    */

    public Network(Layer[] layers){
        this.layers = layers;
        initialize();
    }
    public void initialize(){
        // We need to create and index connections for neurons.
        // for every layer,
        for(int layer = 0; layer < layers.length; layer++){
            //for every neuron,
            for(int current_neuron = 0; current_neuron < layers[layer].neurons.length; current_neuron++){
                //A new connection will be initialized with this current neuron and every single neuron in the NEXT layer
                for(int next_layer_neurons = 0; next_layer_neurons < layers[layer+1].neurons.length; next_layer_neurons++){
                    //so to be clear: For every neuron in the layer we are currently on, a new connection will be created and indexed with start_neuron being the current neuron and end_neuron being every neuron in the next layer.
                }
            }
        }
    }
    public Connection init_connection(Neuron target_neuron, Neuron base_neuron){ // initialized weight to be one
        return new Connection(base_neuron,target_neuron,1);
    }
}
