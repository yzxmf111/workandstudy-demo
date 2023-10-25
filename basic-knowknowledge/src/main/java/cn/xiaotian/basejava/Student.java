package cn.xiaotian.basejava;


import lombok.AllArgsConstructor;

/**
 * @author xiaotian
 * @description
 * @date 2022-12-01 09:51
 */
@AllArgsConstructor
public class Student extends Person{

    public Student(int age, String name) {
        super(age, name);
    }
}
