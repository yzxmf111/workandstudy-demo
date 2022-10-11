package April;

public class demo111 {

    public static void main(String[] args) {
        String a = "1,2";
        String[] s = a.split(",");
        int b = Integer.parseInt(s[0]);
        System.out.println(b);
    }
}
