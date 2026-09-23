package Network_Architecture;

public class Network {
    public Layer[] layers;


    public Network(Layer[] layers){
        this.layers = layers;
        initialize();
    }
    public void initialize(){
        // We need to initialize the arrays for every neuron's 'inputNeurons'
        for(int _L = 1; _L < layers.length; _L++){ //1 because the first layer does not have inputNeurons
            for(int init_c_neuron = 0; init_c_neuron < layers[_L].neurons.length; init_c_neuron++){
                //Every neuron will have connections to the neuron in the previous layer
                layers[_L].neurons[init_c_neuron].inputConnections = new Connection[layers[_L-1].neurons.length];
            }
        }

        // for every layer,            
        for(int L = 0; L < layers.length-1; L++){ // Minus 1 because the final layer does not have outgoing connections.
            //for every neuron in that layer,
            for(int N = 0; N < layers[L].neurons.length; N++){
                //A new connection will be initialized with this current neuron and every single neuron in the NEXT layer
                for(int N_L = 0; N_L < layers[L+1].neurons.length; N_L++){ // every neuron in the next layer

                    //INITIALIZE CONNECTION (INITAL WEIGHT VALUE HERE)
                    Connection c = new Connection
                    (
                        layers[L].neurons[N], // start_neuron
                        layers[L+1].neurons[N_L], // end_neuron
                        Math.random()*2-1 // weight, random to start with
                    );
                    //Update the 'n_neuron' 'inputneurons' with the new connection
                    for(int i = 0; i < layers[L+1].neurons[N_L].inputConnections.length; i++){ // to get the next empty position in the inputConnections
                        if(layers[L+1].neurons[N_L].inputConnections[i] == null){
                            layers[L+1].neurons[N_L].inputConnections[i] = c;
                            break; // otherwise we'll just fill up all the empty connections with this specific connection
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
