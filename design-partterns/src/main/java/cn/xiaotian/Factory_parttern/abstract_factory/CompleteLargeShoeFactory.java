package cn.xiaotian.Factory_parttern.abstract_factory;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/1/10 14:29
 **/
public class CompleteLargeShoeFactory implements CompleteShoeFactory{
	@Override
	public Shoe createShoe() {
		return new LargeShoes();
	}

	@Override
	public Insole createInsole() {
		return new LargeInsole();
	}
}
