package November.JXJR;

public class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreateProduct();
    }
}