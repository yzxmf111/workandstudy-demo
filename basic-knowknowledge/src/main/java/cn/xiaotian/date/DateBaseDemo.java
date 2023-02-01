package cn.xiaotian.date;

import java.sql.Timestamp;
import java.util.Date;

public class DateBaseDemo {

    public static void main(String[] args) {
        Date time = new Date(1507601410000L);//时间戳反转化
//        Timestamp timestamp = new Timestamp("1507601410000");
        System.out.println(time);
//        System.out.println(timestamp);
    }
}
