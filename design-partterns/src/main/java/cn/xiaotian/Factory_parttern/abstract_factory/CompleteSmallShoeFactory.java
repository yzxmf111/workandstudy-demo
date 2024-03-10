package cn.xiaotian.Factory_parttern.abstract_factory;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/1/10 14:29
 **/
public class CompleteSmallShoeFactory implements CompleteShoeFactory{
	@Override
	public Shoe createShoe() {
		return new SmallShoes();
	}

	@Override
	public Insole createInsole() {
		return new SmallInsole();
	}
}
