package DataStructureAndAlgorithms.src.gogogo.sort;

import java.util.Comparator;
import java.util.TreeMap;

class Car {


    public static void main(String[] args) {
        testComparator();
    }
    public static void testComparator(){
        //HashMap<Integer,Object> hm = new HashMap<Integer,Object>();
        TreeMap<Integer,Object> tmp = new TreeMap<Integer,Object>(new 		         Comparator<Integer>() {  //匿名内部类
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;//降序排列,这是想对o1,o2进行排序,也可以对map中他们对应的value进行排序  o1 - o2升序
            }
        });
        tmp.put(4, "肆");
        tmp.put(1, "壹");
        tmp.put(5, "伍");
        tmp.put(3, "三");
        tmp.put(2, "贰");
        //System.out.println(tmp);//默认排序结果：{1=壹, 2=贰, 3=三, 4=肆, 5=伍}
        System.out.println(tmp);//修改为比较器排序(升序){5=伍, 4=肆, 3=三, 2=贰, 1=壹}
    }
}