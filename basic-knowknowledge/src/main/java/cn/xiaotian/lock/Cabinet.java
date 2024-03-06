package cn.xiaotian.lock;

/**
 * @author xiaotian
 * @description
 * @date 2023-05-24 16:34
 */
public class Cabinet {
    //柜子中存储的数字
    private int storeNumber;

    public synchronized void setStoreNumber(int storeNumber){
        this.storeNumber = storeNumber;
    }

    public int getStoreNumber(){
        return this.storeNumber;
    }

}
