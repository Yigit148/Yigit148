import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.println("\n" + "Part 1" + "\n" + "*******************************");

        System.out.println("Enter first String");
        String first = scanner.nextLine();

        System.out.println("Enter second String");
        String second = scanner.nextLine();

        System.out.println("Mixed string is " + mix(first,second));



        System.out.println("\n" + "Part 2" + "\n" + "*******************************");

        System.out.println("Enter first String");
        String new_1 = scanner.nextLine();

        System.out.println("Enter second String");
        String new_2 = scanner.nextLine();

        System.out.println("Common string is: " +common(new_1, new_2));


        System.out.println("\n" + "Part 3" + "\n" + "*******************************");


        System.out.println("Enter the length of b");
        double side1 = scanner.nextDouble();

        System.out.println("Enter the length of c");
        double side2 = scanner.nextDouble();

        System.out.printf("%.3f", hypotenuse(side1,side2));;

        System.out.println("\n" + "Part 4" + "\n" + "*******************************");

        System.out.println("How many numbers to find: ");
        int to_find = scanner.nextInt();

        System.out.println("Maximum number: ");
        int num = scanner.nextInt();

        int maxi = 0;

        while (maxi < to_find){
            System.out.print(random.nextInt(49) + " ");;
            maxi++;
        }


    }

    static String mix(String a, String b){

        String mixed = "";
        int c;
        int k;
        String longer;

        if (a.length() > b.length()){
            c = b.length();
            k = a.length() - b.length();
            longer = a;
        }else{
            c = a.length();
            k = b.length() - a.length();
            longer = b;
        }


        for (int i = 0; i < c; i++){
            char fir = a.charAt(i);
            mixed += fir;
            char sec = b.charAt(i);
            mixed += sec;
        }


        mixed += longer.substring(longer.length()-k);

        return mixed;
    }

    static String common(String a, String b){
        String commons = "";

        ArrayList <Character> array = new ArrayList<>();

        for (int i = 0; i < a.length(); i++){
            char fir = a.charAt(i);
            if (b.indexOf(fir) >= 0 && !array.contains(fir)){
                array.add(fir);
            }
        }


        for (int i = 0; i < b.length(); i++){
            char sec = b.charAt(i);
            if (a.indexOf(sec) >= 0 && !array.contains(sec)){
                array.add(sec);
            }
        }

        for (char i : array){
            commons += i;
        }

        return commons;
    }

    static double hypotenuse(double a, double b){
        return Math.hypot(a, b);
    }


}