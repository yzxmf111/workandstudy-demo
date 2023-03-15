package cn.xiaotian.groovy;

/**
 * @author xiaotian
 * @description
 * @date 2023-03-15 10:24
 */

//import com.alibaba.fastjson.JSONArray
//import com.alibaba.fastjson.JSONObject
//import org.apache.commons.lang3.StringUtils

import java.util.Iterator;
//
//class CreditResultParse {
//    public JSONObject creditParse(JSONObject jsonObject) {
//        JSONObject creditJSON = new JSONObject();
//        JSONArray jsonOutFieldsArray = jsonObject.getJSONArray("output_fields");
//        if (null != jsonOutFieldsArray) {
//            JSONObject creditDesc = outputFields(jsonOutFieldsArray);
//            creditJSON.put("detail", creditDesc);
//        }
//        String decision = jsonObject.getString("final_decision");
//        int score = jsonObject.getIntValue("final_score");
//        creditJSON.put("score", score);
//        creditJSON.put("decision", getBodyGuardDecision(decision));
//        return creditJSON;
//    }
//
//    public String creditDecision(JSONObject jsonObject) {
//        String decisionString = jsonObject.getString("decision");
//        if (null == decisionString) {
//            return null;
//        }
//        if (null == jsonObject.get("score")) {
//            return null;
//        }
//        return decisionString;
//    }
//
//    private String getBodyGuardDecision(String decision) {
//        String bodyGuardDecision = null;
//        switch (decision) {
//            case "Accept":
//                bodyGuardDecision = "PASS";
//                break;
//            case "Review":
//                bodyGuardDecision = "REVIEW";
//                break;
//            case "Reject":
//                bodyGuardDecision = "REJECT";
//                break;
//            default:
//                break;
//        }
//        return bodyGuardDecision;
//    }
//
//    private JSONObject outputFields(JSONArray outputFieldArray) {
//        JSONObject outputResult = new JSONObject();
//        if (null == outputFieldArray) {
//            return outputResult;
//        }
//        Iterator<Object> outputFieldIter = outputFieldArray.iterator();
//        while (outputFieldIter.hasNext()) {
//            JSONObject outputField = (JSONObject) outputFieldIter.next();
//            String fieldName = outputField.get("field_name");
//            Object value = outputField.get("value");
//            outputResult.put(fieldName, value);
//        }
//        return outputResult;
//    }
//}
