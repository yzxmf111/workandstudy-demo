package cn.xiaotian.concurrency;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-13 11:39
 */
public class ThreadLocalManagement {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public User getUser() {
        User user = userThreadLocal.get();
        if (user == null) return new User();
        return user;
    }

    public void setUser(User user) {
        userThreadLocal.set(user);
    }

    public void remove() {
        userThreadLocal.remove();
    }


}
