package cn.xiaotian.file;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description 一个表头对应多个列
 * @Date 2023/9/17 11:39
 **/
public class CSVExport {

	public static void main(String[] args) {
			// 定义CSV文件路径
			String filePath = "output.csv";

			try (FileWriter fileWriter = new FileWriter(filePath)) {
				// 写入CSV文件头，每个文件头对应多个列
				fileWriter.append("Name,Age,Address,Phone,Email\n");

				// 写入数据
				fileWriter.append("John,30,\"123 Main St\",123-456-7890,john@example.com\n");
				fileWriter.append("Alice,25,\"456 Elm St\",987-654-3210,alice@example.com\n");
				fileWriter.append("Bob,35,\"789 Oak St\",555-555-5555,bob@example.com\n");

				System.out.println("CSV文件已导出到 " + filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}


}
