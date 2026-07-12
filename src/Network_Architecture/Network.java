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
        // We need to create and index the connections for neurons.
        connections = new Connection[layers.length][find_largest_layer_length()][find_largest_layer_length()]; // some space will be unused due to variable sizes of layers.
        // for every layer,
        for(int layer = 0; layer < layers.length-1; layer++){ // Minus 1 because the final layer does not have outgoing connections.
            //for every neuron in that layer,
            for(int current_neuron = 0; current_neuron < layers[layer].neurons.length; current_neuron++){
                //A new connection will be initialized with this current neuron and every single neuron in the NEXT layer
                for(int next_layer_current_neuron = 0; next_layer_current_neuron < layers[layer+1].neurons.length; next_layer_current_neuron++){
                    //initialize the connection
                    connections[layer][current_neuron][next_layer_current_neuron] = new Connection(layers[layer].neurons[current_neuron],layers[layer+1].neurons[next_layer_current_neuron],1);
                }
            }
        }
    }
    public Connection init_connection(Neuron target_neuron, Neuron base_neuron){ // initialized weight to be one
        return new Connection(base_neuron,target_neuron,1);
    }
    public int find_largest_layer_length(){
        int largestLayer = 0;
        for(int layer = 0; layer < layers.length; layer++){
            if(layers[layer].neurons.length > largestLayer){
                largestLayer = layers[layer].neurons.length;
            }
        }
        return largestLayer;
    }
}
