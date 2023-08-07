package cn.xiaotian.spring.aop.jdk_cglib;

/**
 * @author xiaotian
 * @description jdk的动态代理
 * @date 2023-03-14 16:53
 */
public class JdkProxy {

    /**
     * Spring 的 AOP 是通过动态代理来实现的，动态代理主要有两种实现方式 JDK 动态代理和 Cglib 动态代理，这两种动态代理的使用和原理有些不同。
     *
     * JDK 动态代理:
     *   Interface：对于 JDK 动态代理，目标类需要实现一个 Interface。
     *   InvocationHandler：InvocationHandler 是一个接口，可以通过实现这个接口，定义横切/加强逻辑，再通过反射机制（invoke）调用目标类的代码，在此过程中，可能包装逻辑，对目标方法进行前置后置处理。
     *   Proxy：Proxy 利用 InvocationHandler 动态创建一个符合目标类实现的接口的实例，生成目标类的代理对象。
     *
     * CgLib 动态代理
     *   使用 JDK 创建代理有一大限制，它只能为接口创建代理实例，而 CgLib 动态代理就没有这个限制。
     *   CgLib 动态代理是使用字节码处理框架 ASM，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。
     *   CgLib 创建的动态代理对象性能比 JDK 创建的动态代理对象的性能高不少，但是 CGLib 在创建代理对象时所花费的时间却比 JDK 多得多，
     *   所以对于单例的对象，因为无需频繁创建对象，用 CGLib 合适，反之，使用 JDK 方式要更为合适一些。同时，由于 CGLib 由于是采用动态创建子类的方法，对于 final 方法，无法进行代理。
     */


}
