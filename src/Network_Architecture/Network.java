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
        // We also need to initialize the arrays for every neuron's 'inputNeurons'
        for(int init_c_layer = 1; init_c_layer < layers.length; init_c_layer++){ //1 because the first layer does not have inputNeurons
            for(int init_c_neuron = 0; init_c_neuron < layers[init_c_layer].neurons.length; init_c_neuron++){
                //Every neuron will have connections to the neuron in the previous layer
                layers[init_c_layer].neurons[init_c_neuron].inputConnections = new Connection[layers[init_c_layer-1].neurons.length];
            }
        }
        // for every layer,
            //and for every neuron in that layer,
            
        for(int layer = 0; layer < layers.length-1; layer++){ // Minus 1 because the final layer does not have outgoing connections.
            //for every neuron in that layer,
            for(int neuron = 0; neuron < layers[layer].neurons.length; neuron++){
                //A new connection will be initialized with this current neuron and every single neuron in the NEXT layer
                for(int next_layer_neuron = 0; next_layer_neuron < layers[layer+1].neurons.length; next_layer_neuron++){
                    //initialize the connection
                    connections[layer][neuron][next_layer_neuron] = new Connection(layers[layer].neurons[neuron],layers[layer+1].neurons[next_layer_neuron],1);
                    //Update the 'next_layer_neuron' 'inputneurons' with the new connection
                    for(int i = 0; i < layers[layer+1].neurons[next_layer_neuron].inputConnections.length; i++){
                        if(layers[layer+1].neurons[next_layer_neuron].inputConnections[i] == null){
                            layers[layer+1].neurons[next_layer_neuron].inputConnections[i] = connections[layer][neuron][next_layer_neuron];
                            break; //
                        }
                    }
                }  
            }
        }
    }// surely there's some way to cut down on all this nesting...
    public void run(double[] inputs){
        if(inputs.length == layers[0].neurons.length){
            //set the activation of input neurons to the inputs.
            for(int i = 0; i < layers[0].neurons.length; i++){
                layers[0].neurons[i].activation = inputs[i];
            }
            //for neuron, layer by layer (starting with layer 2): Run 'calc_activation'
            for(int z = 1; z < layers.length; z++){
                for(int n = 0; n < layers[z].neurons.length; n++){
                    layers[z].neurons[n].calc_activation();
                }
            }
            //display final value
            for(int k = 0;  k < layers[layers.length-1].neurons.length; k++){
                System.out.println(layers[layers.length-1].neurons[k].activation);
            }
        }else{
            System.out.println("\nError: You need to include enough inputs.");
            System.out.println("You gave me " + inputs.length + " inputs; You should have included " + layers[0].neurons.length + " inputs.");
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
