package Network_Architecture.Activation_Functions;
public class activation_funcs {
    
    public static float apply(float val, actfn fn){
        switch(fn){
            case RELU:
                val = Math.max(0, val);
                break;
            case STEP:
                val = val > 0 ? 1 : 0;    
                break;
            case SIGMOID:
                break;
            case LINEAR:
                break; 
                // linear does nothing; the purpose of activation functions is to introduce non-linearity
        }
        return val;
    }
}
