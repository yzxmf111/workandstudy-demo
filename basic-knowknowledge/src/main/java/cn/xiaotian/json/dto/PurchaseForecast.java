package cn.xiaotian.json.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/21 14:06
 **/
@Data
public class PurchaseForecast {

	/**
	 * 定量日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String scheduleDate;
	/**
	 * 采购某日的定量
	 */
	private BigDecimal purchaseForecastTotal;

}
