package cn.xiaotian.Factory_parttern.abstract_factory;

/**
 * @Author tianyifan
 * @Description 用于创建一系列相互关联或相互依赖的产品族 如：大号鞋子+大号鞋垫 不能大号鞋子+小号鞋垫
 *              工厂模式包括简单工厂模式，工厂方法模式，还是抽象工厂模式，它们在形式和特点上是极为相似的，而且最终目的都是为了解耦。
 *              在使用时，我们不必去在意这个模式到底工厂方法模式还是抽象工厂模式，因为他们之间的演变常常是令人琢磨不透的。
 *              经常你会发现，明明使用的工厂方法模式，当新需求来临，稍加修改，加入了一个新方法后，
 *              由于类中的产品构成了不同等级结构中的产品族，它就变成抽象工厂模式了；而对于抽象工厂模式，
 *              当减少一个方法使的提供的产品不再构成产品族之后，它就演变成了工厂方法模式。
 *              todo:结合spring 实现抽象工厂模式+工厂方法模式
 * @Date 2024/1/10 14:27
 * @Version 1.0
 **/
public interface CompleteShoeFactory {
	Shoe createShoe();
	Insole createInsole();
}
