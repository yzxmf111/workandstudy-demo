package cn.xiaotian.json.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/21 14:01
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class PurchaseConfirmRequest extends SaleActivityBaseRequest{

	@Size(min = 1)
	@NotNull(message = "采购预测量信息不可为空")
	private List<PurchaseForecast> purchaseForecast;

	@NotNull(message = "最晚确认时间不可为空")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime scheduleConfirmEnd;


	@NotNull(message = "大仓id不可为空")
	private Long generalStoreId;

}
