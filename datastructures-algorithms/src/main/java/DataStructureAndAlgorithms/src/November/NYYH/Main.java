package November.NYYH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int ans = 1;
        int total = helper(n,ans);
        System.out.println("total="+total);
    }

    private static int helper(int n, int ans) {
        while (n != 1){
            ans = (ans + 1) *2;
            n--;
        }
        return ans;
    }
}
