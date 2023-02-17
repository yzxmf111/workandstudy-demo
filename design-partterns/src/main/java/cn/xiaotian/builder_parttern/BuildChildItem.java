package cn.xiaotian.builder_parttern;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-14 14:30
 */
public class BuildChildItem extends BuildItem {

    @Override
    protected void buildItemName() {
        item.setName("儿童玩具");
    }

    @Override
    protected void buildItemType() {
        item.setType("weapon");
    }

    @Override
    protected void buildItemMoney() {
        item.setMoney("1212");
    }

    @Override
    protected void buildItemlevel() {
        item.setLevel(12);
    }
}
