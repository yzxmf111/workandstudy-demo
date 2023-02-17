package xiaotian.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Objects;

/**
 * @description
 * @author xiaotian
 * @date 2022-07-15 15:43
 */
@Data
@ToString
public class Address {

    String province;
    String city;
    String area;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(province, address.province) &&
                Objects.equals(city, address.city) &&
                Objects.equals(area, address.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(province, city, area);
    }
}
