package January.leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/26 17:04
 */


public class Demo04 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String qus = bf.readLine().toLowerCase();
        char[] chars = bf.readLine().toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i < qus.length(); i++) {
            if (qus.charAt(i) == chars[0] || qus.charAt(i) - 32 == chars[0] ||qus.charAt(i) + 32 == chars[0]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
