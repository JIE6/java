package objecttwo;

/**
 * interface关键字
 * * @author JIE
 */
public class InterfaceCharacterImpl implements Output, InterfaceC {

    @Override
    public void out() {

    }

    @Override
    public void getData(String data) {

    }

    public static void main(String[] args) {
        System.out.println(Output.MAX_CACHE_LINE);
        // Output.MAX_CACHE_LINE = 12;
        Output.staticTest();
        /**
         * 从上面main()方法中可以看出， 可以访问Output 的MAX-CACHE-LINE 常量，这表明该成员变量是public 访问权限的，
         * 而且可通过接口来访问该成员变量，表明这个成员变量是一个类变量;
         * 当为这个成员变量赋值时引发"final 变量赋值"的编译异常，
         * 表明这个成员变量使用了final 修饰。
         */

        /**
         * 程序中的InterfaceC 接口继承了InterfaceA 和InterfaceB ，所以InterfaceC 中获得了它们的常量，
         */
        System.out.println(PROP_A);
        System.out.println(PROP_B);
        System.out.println(PROP_C);
    }

    @Override
    public void testC() {

    }

    @Override
    public void testA() {

    }

    @Override
    public void testB() {

    }
}