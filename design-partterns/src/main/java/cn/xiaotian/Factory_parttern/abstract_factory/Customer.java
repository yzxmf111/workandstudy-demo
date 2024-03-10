package cn.xiaotian.Factory_parttern.abstract_factory;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/1/10 14:32
 **/
public class Customer {

	private CompleteShoeFactory completeShoeFactory;

	public Customer(CompleteShoeFactory factory) {
		this.completeShoeFactory = factory;
	}

	public void byShoes() {
		Shoe shoe = completeShoeFactory.createShoe();
		shoe.printShone();
		Insole insole = completeShoeFactory.createInsole();
		insole.printInsole();
	}
}
