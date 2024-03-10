package cn.xiaotian.basejava.bigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ConfirmQuantity {

    private LocalDate date;

    private BigDecimal qty;
}
