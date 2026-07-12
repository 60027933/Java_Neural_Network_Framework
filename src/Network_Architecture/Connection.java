package Network_Architecture;

public class Connection { // A Connection refers to a connection between neurons.
    public Neuron base_neuron;
    public Neuron target_neuron;
    public float weight;
    public Connection(Neuron base_neuron, Neuron target_neuron, float weight){
        this.base_neuron = base_neuron;
        this.target_neuron = target_neuron;
        this.weight = weight;
    }

}
