

public class Service {
    private final MyArray myArray;

    public Service(MyArray myArray) {
        this.myArray = myArray;
    }

    public int [] createArray() {
        return myArray.createArray();
    }

    public double meanCalculation (int [] array){
        return myArray.averageMean(array);
    }

    public void compareMeans(double mean1, double mean2){
        System.out.println(myArray.compareMeans(mean1, mean2).toString());
    }
}
