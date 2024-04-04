import java.io.*;
import java.util.*;

public class Main {
    static int checker = 0;
    static LinkedHashMap<ArrayList<Double>, String> trainingMap;
    static LinkedHashMap<ArrayList<Double>, String> testMap;
    public static void main(String[] args) throws IOException {
        File trainingFile = new File("perceptron.data");
        trainingMap = new LinkedHashMap<>(read(trainingFile));
        File testFile = new File("perceptron.test.data");
        testMap = new LinkedHashMap<>(read(testFile));
        Perceptron perceptron = new Perceptron();
        for(int i = 0; i < 1000; i++) {
            perceptron.predict(trainingMap);
        }
        checker = 0;
        perceptron.predict(testMap);
        System.out.println(checker);
    }
    public static Map<ArrayList<Double>, String> read(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        HashMap<ArrayList<Double>, String> results = new HashMap<>();
        String line;
        while((line = br.readLine()) != null){
            ArrayList<Double> coords = new ArrayList<>();
            ArrayList<String> allData = new ArrayList<>(Arrays.asList(line.split(",")));
            for(int i = 0; i < allData.size()-1; i++){
                coords.add(Double.parseDouble(allData.get(i)));
            }
            results.put(coords, allData.get(allData.size()-1));
        }
        br.close();
        return results;
    }
}