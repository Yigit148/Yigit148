import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LAB08 {
    public static void main (String[] args) throws FileNotFoundException {

        System.out.println("\n" + "\n" + "Part 1" + "\n" + "*******************************");
        int x = countNums("Lab08.txt");
        System.out.println("There are " + x + "numbers in the file.");

        System.out.println("\n" + "\n" + "Part 2" + "\n" + "*******************************");
        printArray(readNums("Lab08.txt", x));

        System.out.println("\n" + "\n" + "Part 3" + "\n" + "*******************************");
        printArray(bubbleSort(readNums("Lab08.txt",x)));

        System.out.println("\n" + "\n" + "Part 4" + "\n" + "*******************************");
        average(readNums("Lab08.txt",x));
    }

    private static int countNums(String filename) throws FileNotFoundException {
        Scanner fileScan = new Scanner (new File(filename));
        int count = 0;
        while (fileScan.hasNextLine())
        {
            fileScan.nextDouble();
            count++;
        }
        return count;
    }

    private static Double[] readNums(String filename, int size) throws FileNotFoundException {
        Double[] Arr = new Double[size];
        Scanner fileScan = new Scanner(new File(filename));
        int j = 0;
        while (fileScan.hasNext()) {
            double x = fileScan.nextDouble();
            Arr[j] = x;
            j++;
        }
        return Arr;
    }

    private static void printArray(Double[] x) {
        for (int j = 0; j < x.length; j++) {
            if (j % 10 == 0) {
                System.out.println();
            }
            System.out.print(x[j] + " ");
        }
    }

    private static Double[] bubbleSort(Double[] x){
        for (int i = 0; i < ( x.length - 1 ); i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] < x[j+1])
                {
                    Double temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
        }
        return x;
    }

    private static void average(Double[] x) {
        double maxValue=0;
        for(int i=1;i <x.length;i++){
            if(x[i]> maxValue){
                maxValue = x[i];
            }
        }
        System.out.println("Maximum: "+ maxValue);

        double minValue = x[0];
        for(int i=1;i<x.length;i++){
            if(x[i] < minValue){
                minValue = x[i];
            }
        }
        System.out.println("Minimum: "+ minValue);

        double sum=0;
        int count=0;
        for (Double m : x) {
            sum += m;
            count++;
        }
        double ave=sum/count;
        System.out.printf("Average: %.4f",ave);
    }

}
