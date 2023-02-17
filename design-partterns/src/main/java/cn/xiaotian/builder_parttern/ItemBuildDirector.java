package cn.xiaotian.builder_parttern;

import cn.xiaotian.entity.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaotian
 * @description  item创建控制器，用它来控制建造过程，也用来隔离用户与建造过程的关联。
 * @date 2023-02-14 14:36
 */
public class ItemBuildDirector {

    private static final Logger logger = LoggerFactory.getLogger(ItemBuildDirector.class);

    public BuildItem itemBuilder;

    public ItemBuildDirector(BuildItem itemBuilder) {
        this.itemBuilder = itemBuilder;
    }

    public Item createItem(BuildItem itemBuilder) {
        itemBuilder.buildItemName();
        itemBuilder.buildItemType();
        itemBuilder.buildItemMoney();
        itemBuilder.buildItemlevel();
        logger.info(itemBuilder.item.toString());
        return itemBuilder.item;
    }
}
