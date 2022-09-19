package cn.xiaotian.observerpattern;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-16 17:31
 */
public interface Subject {

    void register(Observer observer);

    boolean remove(Observer observer);

    boolean publish(String message);
}
