package cn.xiaotian.json.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/22 15:13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionResponse<T> {
	private boolean success;
	private Integer code;
	private String msg;
	private T data;
}
