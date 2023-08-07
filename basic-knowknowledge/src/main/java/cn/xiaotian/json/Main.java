package cn.xiaotian.json;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/13 11:08
 **/
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String json = "{\"purchase_management_group_names\":[\"蔬菜组\"],\"city_ids\":[\"5c2f1c3301e70c327d8b865a\"],\"store_ids\":[293],\"td_amount\":[{\"target_date\":\"2023-01-27\",\"predict_amount\":1120000}],\"split_way\":0}";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MyData myData = objectMapper.readValue(json, MyData.class);

            // 获取转换后的List对象
            List<Integer> storeIdsList = myData.getStoreIds();

            // 输出List对象内容
            System.out.println(storeIdsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyData {
        private List<Integer> store_ids;

        public List<Integer> getStoreIds() {
            return store_ids;
        }

        public void setStoreIds(List<Integer> store_ids) {
            this.store_ids = store_ids;
        }
    }
}

