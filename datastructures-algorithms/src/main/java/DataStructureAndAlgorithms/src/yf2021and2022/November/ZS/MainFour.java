package November.ZS;

import java.util.*;

public class MainFour {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String printArray(int[][] array) {
        int m = array.length;
        int n = array[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {

            sb.append(array[i][i]);
        }
        return sb.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _array_rows = 0;
        int _array_cols = 0;
        _array_rows = Integer.parseInt(in.nextLine().trim());
        _array_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _array = new int[_array_rows][_array_cols];
        for(int _array_i=0; _array_i<_array_rows; _array_i++) {
            for(int _array_j=0; _array_j<_array_cols; _array_j++) {
                _array[_array_i][_array_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = printArray(_array);
        System.out.println(res);
    }
}
