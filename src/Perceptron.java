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

    public int predict() {
        for(Map.Entry<ArrayList<Double>, String> entry : Main.testMap.entrySet()){
            ArrayList<Double> pararmeters = entry.getKey();
            ArrayList<Double> newWeights = new ArrayList<>();
            double y;
            double sum = 0;
            double d;
            for (int i = 0; i < weights.size(); i++) {
                sum = sum + (weights.get(i) * entry.getKey().get(i));
            }
            if (sum >= theta) {
                y = 1;
                if(entry.getValue() == "Iris-versicolor"){
                    d = 1;
                }else{
                    d = 0;
                }
            } else {
                y = 0;
                if(entry.getValue() == "Iris-virginica"){
                    d = 0;
                }else{
                    d = 1;
                }
            }
            for (int i = 0; i < weights.size(); i++) {
                double newWeight = weights.get(i) + (d - y) * alpha * pararmeters.get(i);
                newWeights.add(newWeight);
            }
            weights = newWeights;
            theta = theta - (d - y) * alpha;
        }
        return 0;
    }
}