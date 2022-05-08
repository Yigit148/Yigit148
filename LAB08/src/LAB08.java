import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LAB08 {
    public static void main (String[] args) throws FileNotFoundException {

        System.out.println("\n" + "\n" + "Part 1" + "\n" + "*******************************");
        int x = countNums("Lab08.txt");
        System.out.println(x);

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
            Double x = fileScan.nextDouble();
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
                if (Double.parseDouble(x[j].toString()) < Double.parseDouble(x[j+1].toString()))
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
            if(Double.parseDouble(x[i].toString()) > maxValue){
                maxValue = Double.parseDouble(x[i].toString());
            }
        }
        System.out.println("Maximum: "+maxValue);
        double minValue =Double.parseDouble(x[0].toString());
        for(int i=1;i<x.length;i++){
            if(Double.parseDouble(x[i].toString())< minValue){
                minValue = Double.parseDouble(x[i].toString());
            }
        }
        System.out.println("Minimum: "+ minValue);

        double sum=0;
        int count=0;
        for (Double m : x) {
            sum += Double.parseDouble(m.toString());
            count++;
        }
        double ave=sum/count;
        System.out.printf("Average: %.4f",ave);
    }

}
