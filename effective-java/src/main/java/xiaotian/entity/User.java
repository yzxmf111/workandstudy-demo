package xiaotian.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author xiaotian
 * @description
 * @date 2022-07-15 15:41
 */
@Data
@ToString
public class User {

    String name;
    String phone;
    Address address;
}
