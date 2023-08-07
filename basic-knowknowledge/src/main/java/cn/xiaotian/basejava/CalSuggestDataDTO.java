package cn.xiaotian.basejava;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author tianyifan
 * @Description
 * @Date 2023/6/9 14:31
 * @Version 1.0
 **/
@Data
public class CalSuggestDataDTO {

    @ApiModelProperty("jobId")
    private Long jobId;

    @ApiModelProperty("供应商id")
    private String vendorId;

    @ApiModelProperty("供应商名称")
    private String vendorName;

    @ApiModelProperty("计算使用供应商接单日")
    private String vendorDistributionDay;

    @ApiModelProperty("计算使用供应商配送耗时（到大仓维度")
    private Integer vendorConsumeDay;

    @ApiModelProperty("大仓良品库存")
    private Integer stockGoodQty;

    @ApiModelProperty("大仓在途")
    private Integer stockAtTransport;

    @ApiModelProperty("门店可用库存")
    private Integer usableStock;

    @ApiModelProperty("门店锁定库存")
    private Integer lockStock;

    @ApiModelProperty("未来7日预测值")
    private String forecastNumForWeek;

    @ApiModelProperty("今日临期")
    private Integer expireNum;

    @ApiModelProperty("箱规")
    private String boxSize;

    @ApiModelProperty("推送时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date pushDate;

    @ApiModelProperty("商品ID")
    private Long productId;

    @ApiModelProperty("大仓ID")
    private Long generalStoreId;
}
