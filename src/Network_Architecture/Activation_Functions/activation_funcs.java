package Network_Architecture.Activation_Functions;
public class activation_funcs {
    
    public static double apply(double val, actfn fn){
        switch(fn){
            case RELU:
                val = Math.max(0, val);
                break;
            case STEP:
                val = val > 0 ? 1 : 0;    
                break;
            case SIGMOID:
                val = 1/(1+(Math.pow(Math.E,val))); 
                break;
            case LINEAR:
                break; 
                // linear does nothing; the purpose of activation functions is to introduce non-linearity, so this is the same as not having an activation function.
        }
        return val;
    }
}
