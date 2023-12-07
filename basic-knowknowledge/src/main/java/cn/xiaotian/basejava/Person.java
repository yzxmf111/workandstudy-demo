package cn.xiaotian.basejava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/7/27 14:12
 **/
@Data
public class Person {

    private Integer age;
    private String name;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return Objects.equals(age, person.age) && Objects.equals(name, person.name);
//    }

}
