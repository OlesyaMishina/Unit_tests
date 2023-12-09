import java.util.Arrays;
import java.util.Random;

public class MyArray {

    public MyArray() {
    }

    public int[] createArray(){
        Random random = new Random();
        int [] array= random.ints(0, 100).limit(15).toArray();
        System.out.println(Arrays.toString(array));
        return array;
    }

    public double averageMean(int [] array){
//        OptionalDouble mean = IntStream.of(array).average();
        int sum=0;
        for (int i : array) {
            sum = sum +i;
        }
        double mean = Math.round(sum/array.length);
        System.out.println(mean);
        return mean;
    }

    public String compareMeans(double mean1,  double mean2) {
        if (mean1 > mean2)
            return "Среднее значение первого массива больше.";
        else if (mean1 < mean2)
            return "Среднее значение второго массива больше.";
        else
        return "Средние значения массивов равны.";
    }
}
