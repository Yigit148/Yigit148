import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LAB7 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\n" + "\n" + "Part 1" + "\n" + "*******************************");
        printList(readNums("Lab07.txt"));

        System.out.println("\n" + "\n" + "Part 2" + "\n" + "*******************************");
        printList(unique(readNums("Lab07.txt")));

        System.out.println("\n" + "\n" + "Part 3" + "\n" + "*******************************");
        printList(reverseAL(unique(readNums("Lab07.txt"))));

        System.out.println("\n" + "\n" + "Part 4" + "\n" + "*******************************");

        ArrayList a = readNums("Lab07.txt");
        ArrayList<Integer> list_new = new ArrayList<Integer>();
        ArrayList<Object> list_new2 = new ArrayList<Object>();

        int max = 0;
        Object max2 = 0;
        for (int i = 0; i < a.toArray().length;i++){
            int count = 0;
            Object b = a.get(i);
            while (a.contains(b)){
                count++;
                a.remove(b);
            }
            if (max < count){
                max = count;
                max2 = b;
            }
            list_new.add(count);
            list_new2.add(b);
        }

        int maximum = list_new.get(0);
        for (int i = 1; i < list_new.size(); i++) {
            if (maximum < list_new.get(i))
                maximum = list_new.get(i);
        }
        System.out.println("The number that repeats most is " + max2 + " and it repeats " + maximum + " times");
    }




    public static ArrayList readNums(String file_name) throws FileNotFoundException {
        Scanner fileScan = new Scanner (new File(file_name));
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (fileScan.hasNextLine())
        {
            int num = fileScan.nextInt();
            list.add(num);
        }
        fileScan.close();
        return list;
    }

    public static void printList(ArrayList list){
        System.out.println("There are "+list.toArray().length + " numbers in the file.");
        for (int i = 0; i < list.toArray().length;i++){
            if (i % 10==0){
                System.out.println();
            }
            System.out.print(list.get(i)+" ");
        }
    }

    public static ArrayList unique(ArrayList list) {
        ArrayList<Integer> unique_list = new ArrayList<Integer>();
        for (int i = 0; i < list.toArray().length;i++){
            if (!unique_list.contains(list.get(i))){
                unique_list.add((Integer) list.get(i));
            }
        }
        return unique_list;
    }

    public static ArrayList reverseAL(ArrayList list) {
        ArrayList<Integer> unique_list = new ArrayList<Integer>();
        for (int i = list.toArray().length-1; i >= 0;i--){
            if (!unique_list.contains(list.get(i))){
                unique_list.add((Integer) list.get(i));
            }
        }
        return unique_list;
    }
}
