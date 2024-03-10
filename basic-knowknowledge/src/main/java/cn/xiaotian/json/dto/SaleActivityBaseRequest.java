package cn.xiaotian.json.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/21 14:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleActivityBaseRequest {

	@NotNull(message = "商品id不可为空")
	protected Long productId;

	@Size(min = 1)
	@NotNull(message = "门店列表不可为空")
	protected List<Long> storeIds;

	/**
	 * 档期id
	 */
	@NotNull(message = "档期id不可为空")
	protected Long scheduleId;

}
