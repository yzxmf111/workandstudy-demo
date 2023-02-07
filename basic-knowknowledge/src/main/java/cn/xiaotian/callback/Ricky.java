package cn.xiaotian.callback;

/**
 * @author xiaotian
 * @description
 * @date 2022-12-01 09:51
 */
public class Ricky implements Student {
    @Override
    public void resolveQuestion(Callback callback) {
        // 模拟解决问题
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        // 回调，告诉老师作业写了多久
        callback.tellAnswer(3);
    }



}