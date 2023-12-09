

public class Main {
    public static void main(String[] args) {

        Service service= new Service(new MyArray());
        int[] array1 = service.createArray();
        int[] array2 = service.createArray();
        double mean1 = service.meanCalculation(array1);
        double mean2 = service.meanCalculation(array2);
        service.compareMeans(mean1, mean2);
    }
}