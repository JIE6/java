package objectone;

/**
 * 继承-子
 * @author JIE
 */
public class Child extends Parent {
    public String a = "ca";
    public String b = "cb";

    public Child () {
        // super();
        System.out.println("Child()");
    }

    public Child (String a) {
        super(a);
        System.out.println("Child(String a)");
    }

    public Child (String a, String b) {
        super(a, b);
        super.a = "xa";
        System.out.println("Child(String a, String b)");
    }

    public void polymorphismTest() {
        System.out.println("polymorphismTest");
    }

    @Override
    public void info() {
        System.out.println("Child.a="+a);
        System.out.println("Child.b="+b);
    }

    public static void main(String[] args) {
        Child child = new Child("a", "b");
//        Child child = new Child();
        child.info();
    }

}
