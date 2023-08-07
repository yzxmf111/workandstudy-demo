package cn.xiaotian.collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/20 17:27
 **/
public class SalesPlanQueryParameterDO {


    /**
     * 用户信息
     */
//        private CurrentUser user;
    /**
     * 是否top品: 0->否，1->是, -1->全部`
     */
    private Integer isTop;
    /**
     * 包含原料的品类管理组名称
     */
    private List<String> includeMaterialPMGNames;
    /**
     * 需要排除原料的品类管理组名称
     */
    private List<String> excludeMaterialPMGNames;
    /**
     * 采购第1分类ID
     */
    private List<Integer> purchaseFirstCategoryIds;
    /**
     * 采购第2分类ID
     */
    private List<Integer> purchaseSecondCategoryIds;
    /**
     * 采购第3分类ID
     */
    private List<Integer> purchaseThirdCategoryIds;
    /**
     * 商品id
     */
    private List<Integer> productIds;

    /**
     * 大仓id
     */
    private List<Integer> generalStoreIds;
    /**
     * 城市id
     */
    private List<String> cityIds;
    /**
     * 门店id
     */
    private List<Integer> storeIds;
    /**
     * 事业部名称
     */
    private List<String> businessNames;
    /**
     * 区域名称
     */
    private List<String> bAreas;

//    /**
//     * 自定义标签
//     */
//    private List<String> customTags;
    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;
    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDate endDate;

//        public SalesPlanQueryParameterDO createSalesPlanQueryParameterDOByDto(SalesPlanQueryParameterDto salesPlanQueryParameterDto) {
//            SalesPlanQueryParameterDO salesPlanQueryParameterDO = new SalesPlanQueryParameterDO();
//            this.user = UserContextUtils.getUserContextForceLogin();
//            //获取品类管理组的中文名称
//            writeInManagementGroupNames(salesPlanQueryParameterDto.getPurchaseManagementGroupName());
//
////        salesPlanQueryParameterDO.includeMaterialPMGNames
////        BeanUtils.copyProperties();
//        }

    private void writeInManagementGroupNames(List<String> purchaseManagementGroupIds) {
        List<String> managementGroupNames = new ArrayList<>();
        if (CollectionUtils.isEmpty(purchaseManagementGroupIds)) {
            return;
        }
        for (String purchaseManagementGroupId : purchaseManagementGroupIds) {
            managementGroupNames.add("11");
        }
        managementGroupNames.forEach(
                managementGroupName -> {
                    includeMaterialPMGNames.add(managementGroupName);
                    excludeMaterialPMGNames.add(managementGroupName);
                }
        );
    }

    public static void main(String[] args) {
        SalesPlanQueryParameterDO salesPlanQueryParameterDO = new SalesPlanQueryParameterDO();
        salesPlanQueryParameterDO.writeInManagementGroupNames(Arrays.asList("12","2"));

    }
}
