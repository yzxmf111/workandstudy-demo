package cn.xiaotian.time;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/25 14:18
 **/
public class Demo {

    public static void main(String[] args) throws ParseException {
//        String algoPredictForDay = "{\"2023-07-20\":\"5\",\"2023-07-18\":\"6\",\"2023-07-21\":\"5\",\"2023-07-22\":\"3\",\"2023-07-23\":\"3\",\"2023-07-24\":\"1\",\"2023-07-25\":\"6\"}";
//        JSONObject algoPredictForOneDayObj = JSONObject.parseObject(algoPredictForDay);
//        List<String> dateList = algoPredictForOneDayObj.keySet().stream().sorted().collect(Collectors.toList());
//        System.out.println(dateList);
//
////        BigDecimal decimal1 = new BigDecimal(0);
////        BigDecimal decimal2 = new BigDecimal(1);
////        System.out.println(decimal2.divide(decimal1));
//
//        // 日期格式化
//        DateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = simpleFormat.parse("2023-03-01 01:10:00");
//        Date endDate = simpleFormat.parse("2023-03-05 03:59:59");
//        long startTime = startDate.getTime();
//        long endTime = endDate.getTime();
//        float days = ((float)(endTime - startTime) / (float)(1000 * 60 * 60 * 24))+1;
//        System.out.println("两个时间之间的天数间隔为：" + days);
//
        String a = "2023-07-03 10:10:10";
        String b = "2023-07-05 10:10:10";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simpleDateFormat.parse(a);
        Date date2 = simpleDateFormat.parse(b);
        Demo.assembleActivityTime(date1,date2);
        BigDecimal[][] operationSplitArray = new BigDecimal[10][12];
//        operationSplitArray[1][2] =BigDecimal.ZERO;
        boolean zeroFlag = Arrays.stream(operationSplitArray).flatMap(Arrays::stream).allMatch(value -> Objects.isNull(value));

        if (operationSplitArray[1][1]==null) {
            System.out.println("1");
        }
    }

    public static void assembleActivityTime(Date activityStartTime, Date activityEndTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = activityStartTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = activityEndTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        List<LocalDate> dateList = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            dateList.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        // 输出所有日期
        for (LocalDate date : dateList) {
            System.out.println(date);
        }
    }
}
