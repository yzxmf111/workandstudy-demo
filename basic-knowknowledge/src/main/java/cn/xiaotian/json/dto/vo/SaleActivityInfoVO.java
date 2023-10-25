package cn.xiaotian.json.dto.vo;

import cn.xiaotian.json.dto.DeliverActivity;
import cn.xiaotian.json.dto.PlanPromotionActivity;
import cn.xiaotian.json.dto.RealPromotionActivity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/22 15:24
 **/
@Data
public class SaleActivityInfoVO {

	private Long productId;

	private String productName;

	private String scheduleId;

	private List<Long> storeIds;

	/**
	 * 投放活动
	 */
	private List<DeliverActivity> deliverActivityType;

	/**
	 * 计划促销活动
	 */
	private List<PlanPromotionActivity> planPromotionActivity;

	/**
	 * 实际促销活动
	 */
	private List<RealPromotionActivity> realPromotionActivity;

	/**
	 * 运营预测量总量
	 */
	private BigDecimal operatorForecastNum;

	/**
	 * 算法预测量总量
	 */
	private BigDecimal algoForecastNum;

	/**
	 * 采购预测量总量
	 */
	private BigDecimal purchaserForecast;

	/**
	 * 算法每日预测量
	 */
	private Map<String, BigDecimal> algoForecastMap;

	/**
	 * 运营每日预测量总量
	 */
	private Map<String, BigDecimal> operatorForecastMap;

	/**
	 * 采购每日预测量总量
	 */
	private Map<String, BigDecimal> purchaseForecastMap;
}
