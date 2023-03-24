package March;

import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to online interview system of Acmcoder.");
        strings.add("This system is running Java 8.");

        for (String string : strings) {
            System.out.println(string);
        }

        int a, b;
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.printf("Your result is : %d\n", a + b);
        }
    }
}