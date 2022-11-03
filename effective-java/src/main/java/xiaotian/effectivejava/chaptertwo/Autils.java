package xiaotian.effectivejava.chaptertwo;

/**
 * @author xiaotian
 * @description
 * @date 2022-08-19 14:03
 */
public class Autils {

    /**
     * 当前类不可被子类化了，因为子类构造器必须显式或隐式地调用super构造器.
     * 在这种情况下, 子类就没有可访问的超类构造器可调用了.
     */
    private Autils(){

    }
}
