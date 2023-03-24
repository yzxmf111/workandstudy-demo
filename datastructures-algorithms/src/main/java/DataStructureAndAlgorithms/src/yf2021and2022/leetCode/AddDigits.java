package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/19 16:43
 */


public class AddDigits {

    public static void main(String[] args) {
        AddDigits A = new AddDigits();
        int i = A.addDigits(38);
        System.out.println(i);
    }

    public int addDigits(int num) {
        //递归的写法

        if (num < 10) return num;
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }
}
