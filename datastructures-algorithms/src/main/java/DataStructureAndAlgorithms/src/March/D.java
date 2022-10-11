package March;

public class D{

    class B {

        public B(){

        }

        public B(int a){

        }

        public void method1(){
            System.out.println("我是方法一");
        }
    }

     class C extends B{

        public C(int a) {
            super(a);
        }

        @Override
        public void method1(){
            super.method1();
            System.out.println("我是方法二");
        }
    }

    public static void main(String[] args) {
        D d = new D();
      //  C c = new C(1);
      //  c.method1();
    }

}
