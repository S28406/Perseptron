import java.util.ArrayList;
import java.util.Map;

class Perceptron {
    Map.Entry<ArrayList<Double>, String> mapEntry = Main.trainingMap.entrySet().iterator().next();
    private double numWeight = mapEntry.getKey().size();
    private ArrayList<Double> weights = new ArrayList<>();
    private double theta = Math.random();
    private double alpha = 0.4;


    public Perceptron() {
        for(int i = 0; i <  numWeight; i++){
            double weight = Math.random();
            weights.add(weight);
        }
    }

    public int predict(double[] inputs) {
        return 0;
    }
}