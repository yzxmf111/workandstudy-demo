package cn.xiaotian.json.jackson;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.Date;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/10/30 15:50
 **/
public class demo {

	public static void main(String[] args) throws IOException {
		String param = "{\n" +
				"\t\"start\":\"2023-10-30 11:30:14\",\n" +
				"\t\"end\":\"2023-10-30 11:40:14\"\n" +
				"}";
//		ScmAndSaleReconciliationParam req = JsonUtil.fromJsonWithEx(param, ScmAndSaleReconciliationParam.class);
		ScmAndSaleReconciliationParam scmAndSaleReconciliationParam = JSONObject.parseObject(param, ScmAndSaleReconciliationParam.class);
		System.out.println(scmAndSaleReconciliationParam);

	}
	@Getter
	@Setter
	@ToString
	private static class ScmAndSaleReconciliationParam {
		private Date start;
		private Date end;
		private Integer offset;
	}
}
