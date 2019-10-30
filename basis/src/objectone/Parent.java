package objectone;

/**
 * 继承-父
 * @author JIE
 */
public class Parent {
    protected String a;
    protected String b;

    public Parent () {
        System.out.println("Parent()");
    }

    public Parent (String a) {
        this();
        this.a = a;
        System.out.println("Parent(String a)");
    }

    public Parent (String a, String b) {
        this(a);
        this.b = b;
        System.out.println("Parent(String a, String b)");
    }

    public void info() {
        System.out.println("Parent.a="+a);
        System.out.println("Parent.b="+b);

    }
}
