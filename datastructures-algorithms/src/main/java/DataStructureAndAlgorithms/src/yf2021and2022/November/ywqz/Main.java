package November.ywqz;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder("人民币");
        int len  = str.length();

            for (int i = 0; i < str.length(); i++) {
                method1(str, i, sb);
            }


        System.out.println(sb.toString());

    }

    private static void method1(String str, int i, StringBuilder sb) {
        switch (str.charAt(i)) {
            case 0:
                sb.append("零");
                break;
            case 1:
                sb.append("壹");
                break;
            case 2:
                sb.append("贰");
                break;
            case 3:
                sb.append("叁");
                break;
            case 4:
                sb.append("肆");
                break;
            case 5:
                sb.append("伍");
                break;
            case 6:
                sb.append("陆");
                break;
            case 7:
                sb.append("柒");
                break;
            case 8:
                sb.append("捌");
                break;
            case 9:
                sb.append("玖");
                break;
            default:
                break;
        }
    }
}
/*
*  if (str.charAt(i) == '.') {
                method1(str, i, sb);

            } else {
*
*
* */