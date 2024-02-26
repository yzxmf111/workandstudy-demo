package cn.xiaotian.enums;

/**
 * @Author yifan.tian
 * @Description https://www.zhihu.com/tardis/zm/art/55327937?source_id=1003
 *          Fruit反编译后：
 * public final class Fruit extends Enum{
 *
 *     public static Fruit[] values()
 *     {
 *         return (Fruit[])$VALUES.clone();
 *     }
 *
 *     public static Fruit valueOf(String s)
 *     {
 *         return (Fruit)Enum.valueOf(Fruit, s);
 *     }
 *
 *     private Fruit(String s, int i, int j)
 *     {
 *         super(s, i);
 *         code = j;
 *     }
 *
 *     public static final Fruit APPLE;
 *     public static final Fruit ORANGE;
 *     public static final Fruit BANANA;
 *     int code;
 *     private static final Fruit $VALUES[];
 *
 *     static
 *     {
 *         APPLE = new Fruit("APPLE", 0, 1);
 *         ORANGE = new Fruit("ORANGE", 1, 2);
 *         BANANA = new Fruit("BANANA", 2, 3);
 *         $VALUES = (new Fruit[] {
 *             APPLE, ORANGE, BANANA
 *         });
 *     }
 * }
 *          编译器为我们做了这些事情：
 *              可见，Jvm编译器背地里是使用上面的方式来处理枚举的。它做了几件事：
 *              定义一个继承自Enum类的Fruit类，Fruit类是用final修饰的
 *              为每个枚举实例对应创建一个类对象，这些类对象是用public static final修饰的。同时生成一个数组，用于保存全部的类对象
 *              生成一个静态代码块，用于初始化类对象和类对象数组
 *              生成一个构造函数，构造函数包含自定义参数和两个默认参数（下文会讲解这两个默认参数）
 *              生成一个静态的values()方法，用于返回所有的类对象
 *              生成一个静态的valueOf()方法，根据name参数返回对应的类实例（下文会讲解name参数）
 * @Date 2024/1/12 11:01
 **/
public enum Fruit {
	/**
	 * 数据枚举
	 */
	APPLE(1),ORANGE(2),BANANA(3);
	int code;

	Fruit(int code){
		this.code=code;
	}
}
