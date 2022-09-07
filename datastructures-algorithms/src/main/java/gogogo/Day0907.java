package gogogo;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-07 16:14
 */
public class Day0907 {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--letters[t.charAt(i) - 'a'] < 0) return t.charAt(i);
        }
        //for (int letter : letters) {
        //    if (letter == -1) return Char;
        //}
        return ' ';
    }

    public static void main(String[] args) {

        Day0907 day0907 = new Day0907();
        System.out.println(day0907.findTheDifference("abcd", "adecb"));
    }
}
