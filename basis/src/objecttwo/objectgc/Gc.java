package objecttwo.objectgc;

/**
 * 强制垃圾回收
 *
 * 当一个对象失去引用后，系统何时调用它的finalize()方法对它进行资源清理，何时它会变成不可达状态，
 * 系统何时回收它所占有的内存，对于程序完全透明。程序只能控制一个对象何时不再被任何引用变量引用， 绝不能控制它何时被回收。
 *
 * 程序无法精确控制Java 垃圾回收的时机，但依然可以强制系统进行垃圾回收.这种强制只是通知系统进行垃圾回收，
 * 但系统是否进行垃圾回收依然不确定。大部分时候，程序强制系统垃圾回收后总会有一些效果。强制系统垃圾回收有如下两种方式。
 * 调用System 类的gc()静态方法: System.gc()
 * 调用Runtime 对象的gc()实例方法: Runtime.getRuntime().gc()
 *
 * 下面程序创建了4 个匿名对象， 每个对象创建之后立即进入可恢复状态，等待系统回收， 但直到程序退出，系统依然不会回收该资源。
 * @author JIE
 */
public class Gc {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new Gc();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("系统正在清理Gc对象的资源");
    }
    /**
     * 编译、运行上面程序， 看不到任何输出，可见直到系统退出，系统都不曾调用Gc 对象的finalize()方法。但如果将程序修改成GcTest
     */
}
