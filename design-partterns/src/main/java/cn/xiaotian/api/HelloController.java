package cn.xiaotian.api;

import cn.xiaotian.entity.Item;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/11/8 15:09
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

	@PostMapping("/item")
	public ResponseVO<Item> queryItems() {
		Item item = new Item();
		item.setWeight(null);
		item.setName(null);
		return ResponseVO.ok(item);
	}
}
