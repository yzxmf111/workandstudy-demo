package April;

public class Demo04 implements Demo03{

    @Override
    public void method() {
        System.out.println("fdasf");
    }

    public static void main(String[] args) {
        Demo04 ans = new Demo04();
       // ans.method3();
        Demo03.method3();
    }
}

