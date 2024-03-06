package cn.xiaotian.file;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.Escape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-20 10:34
 */
public class CsvUtils {


    public static void main(String[] args) {
        // 测试 导出
        // List<String> dataList = new ArrayList<String>();
        // dataList.add("1,张三,男");
        // dataList.add("2,李四,男");
        // dataList.add("3,小红,女");
        // boolean isSuccess = exportCsv(new File("D:/test.csv"), dataList);
        // System.out.println(isSuccess);

        // 测试 导入
        List<String> dataList = importCsv(new File("/Users/xiaotian/Downloads/csv/111.csv"));
        Map<String, String> map = new HashMap<>();
        if (dataList != null && !dataList.isEmpty()) {
            for (int i = 0; i < dataList.size(); i++) {
                if (i == 0) continue;
                String line = dataList.get(i);
                String[] split = line.split(",");
                String productId = split[0];
                int startIndex = line.indexOf("\"");
                int endIndex = line.indexOf("\"", startIndex + 1);
                String extractedValue = "";
                if (startIndex != -1 && endIndex != -1) {
                     extractedValue = line.substring(startIndex + 1, endIndex);
                    //System.out.println(productId + ":" + extractedValue + ",i="+ i );
                    //System.out.println("===============");
                }
                String storeId = extractedValue;
                String storeIds = map.getOrDefault(productId, "");
                if (StringUtils.isBlank(storeIds)) {
                    map.put(productId, storeId);
                } else  {
                    map.put(productId, map.get(productId)+"," + storeId);

                }
            }
        }
        List<String> outList= new ArrayList<>();
        int j = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            j++;
            System.out.println("j="+ j + "," +entry.getKey() + ":" + entry.getValue() );
            System.out.println("===============");
            //去除0，
            String[] split = entry.getValue().split(",");
            String subres = "";
            for (int i = 0; i < split.length; i++) {
                if (StringUtils.equals(split[i], "000")) {
                    continue;
                } else if (StringUtils.startsWith(split[i],"0")){
                    split[i] = split[i].replaceAll("^0*","");
                }
                    subres = subres + split[i] + ",";
            }

            String join = StringUtils.join(subres.split(","), ",");

            String a = entry.getKey() + ","+  "\"" + join + "\"";
            outList.add(a);
        }
        exportCsv(new File("/Users/xiaotian/Downloads/csv/out.csv"), outList);
    }

    /**
     * 导出
     *
     * @param file
     *            csv文件(路径+文件名)，csv文件不存在会自动创建
     * @param dataList
     *            数据
     * @return
     */
    public static boolean exportCsv(File file, List<String> dataList) {
        boolean isSucess = false;

        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out);
            bw = new BufferedWriter(osw);
            if (dataList != null && !dataList.isEmpty()) {
                for (String data : dataList) {
                    bw.append(data).append("\r\n");
                }
            }
            isSucess = true;
        } catch (Exception e) {
            isSucess = false;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                    bw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                    osw = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                    out = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return isSucess;
    }

    /**
     * 导入
     *
     * @param file
     *            csv文件(路径+文件)
     * @return
     */
    public static List<String> importCsv(File file) {
        List<String> dataList = new ArrayList<String>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        } catch (Exception e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }




}
