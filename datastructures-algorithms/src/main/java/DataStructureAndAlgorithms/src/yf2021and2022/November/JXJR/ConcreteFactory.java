package November.JXJR;

public class ConcreteFactory extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreateProduct();
    }
}