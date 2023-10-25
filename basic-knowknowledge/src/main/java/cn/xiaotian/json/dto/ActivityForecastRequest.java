package cn.xiaotian.json.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/25 15:43
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityForecastRequest extends SaleActivityBaseRequest{
	/**
	 * 大仓id
	 */
	@NotNull(message = "大仓id不可为空")
	private Long generalStoreId;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private String queryTime;

	public ActivityForecastRequest(Long productId, List<Long> stores, Long scheduleId, Long generalStoreId, String queryTime){
		super(productId, stores, scheduleId);
		this.generalStoreId = generalStoreId;
		this.queryTime = queryTime;
	}

	public ActivityForecastRequest(){
	}

}
