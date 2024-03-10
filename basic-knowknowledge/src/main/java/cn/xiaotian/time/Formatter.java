package cn.xiaotian.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/25 09:46
 **/
public class Formatter {

    /**
     * 按照yyyy-MM-dd HH:mm:ss格式获取当前时间
     * @return
     */
    public static String nowTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static void main(String[] args) {
        String now = Formatter.nowTimestamp();
        System.out.println(now);
    }
}
