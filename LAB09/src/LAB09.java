import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LAB09 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n" + "Part 1");
        ArrayList list = readBooks("books.txt");
        readBooks("books.txt");
        printBooks(list);

        System.out.println("\n" + "Part 2");
        System.out.println("Enter part of author name:");
        String auth_name = scanner.nextLine();
        System.out.println("Books written by " + auth_name);
        findBooks(list,auth_name);

        System.out.println("\n" + "Part 3");
        System.out.println("Enter an integer number:");
        int num = scanner.nextInt();
        System.out.println("Sum of digits of " + num + " is " + sumDigits(num));

    }

    public static ArrayList<Book> readBooks(String filename) throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File(filename));
        ArrayList<Book> lst = new ArrayList<>();

        while (fileScan.hasNext()) {
            String x = fileScan.nextLine();
            String[] values = x.split(";");
            int i = Integer.parseInt(values[2]);
            int j = Integer.parseInt(values[3]);
            Book names = new Book(values[0], values[1], i, j);
            lst.add(names);
        }
        return lst;
    }

    public static void printBooks (ArrayList<Book> Arr) {
        for (Object x : Arr) {
            System.out.println(x.toString());
        }
    }

    public static void findBooks(ArrayList<Book> Arr, String author_name) {
        for (Book x : Arr){
            if (x.author.contains(author_name)){
                System.out.println(x);
            }
        }
    }

    public static int sumDigits(int num){
        if (num == 0){
            return 0;}
        return (num % 10 + sumDigits(num / 10));
    }


}

class Book extends LAB09{
    public String name;
    public String author;
    public int year;
    public int pages;

    public Book(String name, String author, int year, int pages) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.pages = pages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPage(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public String toString() {
        return name + ", " + author + ", " + year + ", " + pages + " p.";
    }


}

