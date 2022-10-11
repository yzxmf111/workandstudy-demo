package November.JXJR;

public class Client {
    public static void main(String[] args) {
        int type = 1;
        Product product;
        if (type == 1) {   //耦合度太高了
            product = new ConcreateProduct1();
        } else if (type == 2) {
            product = new ConcreateProduct2();
        } else {
            product = new ConcreateProduct();
        }
        // do something with the product
    }
}
