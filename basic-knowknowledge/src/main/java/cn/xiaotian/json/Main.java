package cn.xiaotian.json;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/13 11:08
 **/
import cn.xiaotian.json.dto.PlanPromotionActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String json = "{\"purchase_management_group_names\":[\"蔬菜组\"],\"city_ids\":[\"5c2f1c3301e70c327d8b865a\"],\"store_ids\":[293],\"td_amount\":[{\"target_date\":\"2023-01-27\",\"predict_amount\":1120000}],\"split_way\":0}";
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            MyData myData = objectMapper.readValue(json, MyData.class);
//
//            // 获取转换后的List对象
//            List<Integer> storeIdsList = myData.getStoreIds();
//
//            // 输出List对象内容
//            System.out.println(storeIdsList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        String a = "[{\"activityId\":\"88272\",\"activityName\":\"\",\"promoArea\":[\"华东大区\"],\"promoAreaId\":[\"7775\"],\"activityType\":\"单品满赠\",\"activityTypeId\":4,\"firstActivityTypeId\":1,\"firstActivityTypeName\":\"单品促销\",\"promoPattern\":null,\"activityStartTime\":1695049200000,\"activityEndTime\":1696085999000,\"promoPrice\":\"9.90\",\"promotionPurpose\":null,\"firstPromotionPurposeId\":11,\"secondPromotionPurposeId\":null,\"firstPromotionPurpose\":\"其他\",\"remark\":\"\",\"source\":1},{\"activityId\":\"88273\",\"activityName\":\"\",\"promoArea\":[\"华东大区\"],\"promoAreaId\":[\"7775\"],\"activityType\":\"特价\",\"activityTypeId\":6,\"firstActivityTypeId\":1,\"firstActivityTypeName\":\"单品促销\",\"promoPattern\":null,\"activityStartTime\":1696172400000,\"activityEndTime\":1696863599000,\"promoPrice\":\"9.90\",\"promotionPurpose\":null,\"firstPromotionPurposeId\":11,\"secondPromotionPurposeId\":null,\"firstPromotionPurpose\":\"其他\",\"remark\":\"\",\"source\":1}]";
//        List<PlanPromotionActivity> planPromotionActivities = JSONArray.parseArray(a, PlanPromotionActivity.class);
//        System.out.println(planPromotionActivities);


        StringBuilder sb = new StringBuilder();
        sb.append(new MyData().name).append("12").append("");
        System.out.println(sb.toString());
    }

    static class MyData {
        private List<Integer> store_ids;
        private  String name;



        public List<Integer> getStoreIds() {
            return store_ids;
        }

        public void setStoreIds(List<Integer> store_ids) {
            this.store_ids = store_ids;
        }
    }

}

