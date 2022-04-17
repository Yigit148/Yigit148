import java.util.Random;

public class Lab {
    public static void main(String[] args){
        Random random = new Random();


        System.out.println("\n" + "\n" + "Part 1" + "\n" + "*******************************");

        int[] int_array = new int[20];

        for (int i = 0; i < 20; i++){
            int_array[i] = (random.nextInt(100));
        }

        System.out.println("Array :");
        printArray(int_array);

        System.out.println("\n" + "\n" + "Part 2" + "\n" + "*******************************");

        System.out.println("Original Array :");
        printArray(int_array);
        System.out.println("\nReversed Array :");
        printArray(reverse(int_array));

        System.out.println("\n" + "\n" + "Part 3" + "\n" + "*******************************");

        int[] array = { 53, 34, 12, 15, 76, 99, 1, 3, 64, 69, 7, 27, 44, 9, 73, 2, 87, 50, 6, 6};

        System.out.println("Original Array :");
        printArray(array);
        System.out.println("\nMerged Array :");
        printDoubleArray(merge4(array));

        System.out.println("\n" + "\n" + "Part 4" + "\n" + "*******************************");

        System.out.println("Original Array :");
        printArray(array);
        System.out.println("\nString Array :");
        printStringArray(merge2(array));
    }

    static void printArray(int[] array){
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    static int[] reverse(int[] array){
        int[] reversed_array = new int[array.length];
        int count = 0;
        for (int i = array.length-1; i >= 0; i--) {
            reversed_array[count] = array[i];
            count++;
        }
        return reversed_array;
    }

    static double[] merge4(int[] array){
        double[] new_array = new double[array.length/4];
        int count = 0;
        while (count < array.length/4){
            double x = 0;
            int count2 = 0;
            for (int i = count*4; i < count*4+4; i++) {
                x += array[i]/Math.pow(10,2*count2);
                count2++;
            }
            new_array[count] = x;
            count++;
        }
        return new_array;
    }

    static void printDoubleArray(double[] array){
        for (double j : array) {
            String temp;
            temp = String.format("%.6f", j);
            System.out.print(temp + " ");
        }
    }

    static String[] merge2(int[] array){
        String[] new_array = new String[array.length/2];
        int count = 0;

        while (count < array.length/2){
            String  x;
            String temp = "";
            for (int i = count*2; i < count*2+2; i++) {
                x = String.format("%02d",array[i]);
                temp += x + ".";
            }
            new_array[count] = temp;
            count++;
        }
        return new_array;
    }

    static void printStringArray(String[] array){
        for (String j : array) {
            String temp;
            temp = String.format("%.5s", j);
            System.out.print(temp + " ");
        }
    }

}
