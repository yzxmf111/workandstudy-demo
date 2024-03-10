package cn.xiaotian.Factory_parttern.abstract_factory;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/1/10 14:35
 **/
public class AbstractFactoryDemo {

	public static void main(String[] args) {
		CompleteShoeFactory completeShoeFactory = new CompleteLargeShoeFactory();
		Customer customer = new Customer(completeShoeFactory);
		customer.byShoes();
	}
}
