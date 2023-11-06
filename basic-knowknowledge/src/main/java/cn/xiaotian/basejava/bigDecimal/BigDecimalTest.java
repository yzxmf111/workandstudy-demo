package cn.xiaotian.basejava.bigDecimal;

import cn.xiaotian.basejava.Person;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/29 09:53
 **/
public class BigDecimalTest {

	public static void main(String[] args) {
//		String s = "{\"2023-09-04\":10,\"2023-09-05\":15000}\n";
//		JSONObject jsonObject = JSONObject.parseObject(s);
//		List<ConfirmQuantity> res = new ArrayList<>();
//		for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
//			LocalDate date = LocalDate.parse(entry.getKey());
//			ConfirmQuantity confirmQuantity = new ConfirmQuantity(date, new BigDecimal((String)entry.getValue()));
//			res.add(confirmQuantity);
//		}
//		Object remove = jsonObject.remove("2023-09-05");
//
//
//		System.out.println(jsonObject);
//
//		Map<String, Person> map = new HashMap<>();
//		Person person = new Person(1, "张三");
//		Person person2 = new Person(1, "李四");
//		Person person3 = new Person(1, "王五");
//		map.put("2023-03-04", person);
//		map.put("2023-03-04", person2);
//		map.put("2023-03-04", person3);
//		System.out.println(map);

//		List<String> s = new ArrayList<>();
//s.add("s");
//s.add("a");
//		String  a = String.join("、", s);
//		System.out.println(a);

		Optional<Integer> dataStatus = Optional.ofNullable(null);

		if (dataStatus.isPresent()) {
			System.out.println("21");
		} else {
			System.out.println(11111);
		}

		BigDecimal one = new BigDecimal("1");
		if (one.compareTo(null) == 0) {
			System.out.println("ppp");
		}
		}

}

