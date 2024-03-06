package cn.xiaotian.lock;

/**
 * @author xiaotian
 * @description
 * @date 2023-05-24 16:34
 */
public class User {
    //柜子
    private Cabinet cabinet;
    //存储的数字
    private int storeNumber;

    public User(Cabinet cabinet,int storeNumber){
        this.cabinet = cabinet;
        this.storeNumber = storeNumber;
    }

    //使用柜子
    public void useCabinet(){
        cabinet.setStoreNumber(storeNumber);
    }

}
