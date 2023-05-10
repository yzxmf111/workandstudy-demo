package DataStructureAndAlgorithms.src.review.huawei;

import java.util.*;

public class Solution {

//    public static void main(String[] args) {
//        String a = "123dsadas";
//        a.split()
//        Scanner sc = new Scanner(System.in);
//        //获取个数
//        int num = sc.nextInt();
//        //创建TreeSet进行去重排序
//        TreeSet set = new TreeSet();
//        //输入
//        for(int i =0 ; i < num ;i++){
//            set.add(sc.nextInt());
//        }
//
//        //输出
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//    }
//
//    // 注意类名必须为 Main, 不要有任何 package xxx 信息
//    public class Main {
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            // 注意 hasNext 和 hasNextLine 的区别
//            while (in.hasNextLine()) { // 注意 while 处理多个 case
//                String a = in.nextLine();
//                List<String> list = splitString(a);
//                for(String str : list) {
//                    System.out.println(str);
//                }
//
//            }
//        }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            List<String> list = splitString(a);
            for(String str : list) {
                System.out.println(str);
            }

        }
    }

        public static List<String> splitString(String a) {
            List<String> list = new ArrayList<>();
            if (a == null || a.length() == 0) {
                list.add("00000000");
            }
            int j = 0;
            char[] chars = a.toCharArray();
            String res = "";
            for (char c : chars) {
                j++;
                res = res+c;
                if (j == 8) {
                    list.add(res+"");
                    res = "";
                    j = 0;
                }
            }

            if(j>0 && j < 8) {
                for (int m = 0; m <  8-j; m++) {
                    res+="0" ;
                }
                list.add(res+"");
            }
            return list;
        }
}
