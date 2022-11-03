package cn.xiaotian.time;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xiaotian
 * @description
 * @date 2022-10-21 17:46
 */
public class CurrentMonthFirstDay {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth()); // 获取当前月的第一天
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth()); // 获取当前月的最后一天
        String s = firstDay.toString().replaceAll("-", "");
        System.out.println(date);
        System.out.println(firstDay);
        System.out.println(s);
        System.out.println(lastDay);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        String incTime = simpleDateFormat.format(new Date()) + "01";
        //String incTimeParam = "20201201";
        //if(StringUtils.isNotEmpty(incTimeParam)){
        //    int incTimeValue = Integer.parseInt(incTime);
        //    int incTimeParamValue = Integer.parseInt(incTimeParam);
        //    if(incTimeParamValue < incTimeValue){
        //        incTime = incTimeParam;
        //    }
        //}
        System.out.println(incTime);
    }
}
