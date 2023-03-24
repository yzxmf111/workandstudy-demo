package November.XC;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();

            //Start coding -- Input Data
            Main main = new Main();
            main.helper(incomeOfA, incomeOfB);


        }

    }

    //Start coding

    int sum = 0;
    private void helper(int incomeOfA, int incomeOfB) {
        try {
            sum += incomeOfA > incomeOfB ? incomeOfA : incomeOfB;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            System.out.println(sum);
        }



    }
}

