package objecttwo.objectgc;

/**
 * 强制垃圾回收
 * @author JIE
 */
public class GcTest {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new GcTest();
            // 下面两行代码的作用完全相同，强制系统进行垃圾回收
            if (i % 2 == 0) {
                System.out.println("System.gc();");
                System.gc();
            }else {
                System.out.println("Runtime.getRuntime().gc();");
                Runtime.getRuntime().gc();
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("系统正在清理GcTest对象的资源");
    }
}
