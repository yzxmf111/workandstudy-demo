package November.GSX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.valueOf(br.readLine().charAt(1));
        int n = Integer.valueOf(br.readLine().charAt(3));


        int[] arr = new int[n];
        int i = 0;
        String[] str = br.readLine().split(" ");
        while (i < n) {
            arr[i] = Integer.valueOf(str[i]);
            i++;
        }
        helper(arr,m);
    }
    private static void helper( int[] arr,int m){
        //code here
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % m == 0) System.out.println(sum % m);
        else System.out.println(sum / m + 1);
    }
}
