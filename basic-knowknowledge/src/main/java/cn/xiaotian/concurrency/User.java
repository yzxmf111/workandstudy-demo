package cn.xiaotian.concurrency;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-13 11:42
 */
public class User {
    private String name;
    private Integer age;
    private String sex;

    public User(){}
    public User(String name, Integer age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
