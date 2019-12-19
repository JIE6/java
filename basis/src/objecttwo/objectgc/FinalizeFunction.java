package objecttwo.objectgc;

/**
 * finalize 方法
 * 在垃圾回收机制回收某个对象所占用的内存之前，通常要求程序调用适当的方法来清理资源， 在没有明确指定清理资源的情况下，
 * Java 提供了默认机制来清理该对象的资源， 这个机制就是finalize()方法。
 *
 * 该方法是定义在Object 类里的实例方法，方法原型为:
 * protected void finalize() throws Throwable
 * 当finalize())方法返回后，对象消失，垃圾回收机制开始执行。方法原型中的throws Throwable 表示它可以抛出任何类型的异常。
 *
 * 任何Java 类都可以重写Object 类的finalize()方法，在该方法中清理该对象占用的资源。如果程序终止之前始终没有进行垃圾回收，则不会调用失去引用对象的finalize()方法来清理资源。
 * 垃圾回收机制何时调用对象的finalize()方法是完全透明的，只有当程序认为需要更多的额外内存时，垃圾回收机制才会进行垃圾回收。
 * 因此，完全有可能出现这样一种情形:某个失去引用的对象只占用了少量内存，而且系统没有产生严重的内存需求，因此垃圾回收机制并没有试图回收该对象所占用的资源，
 * 所以该对象的finalize()方法也不会得到调用。
 *
 * finalize()方法具有如下4 个特点。
 * 1.永远不要主动调用某个对象的finalize()方法，该方法应交给垃圾回收机制调用。
 * 2.finalize()方法何时被调用，是否被调用具有不确定性，不要把finalize()方法当成一定会被执行的方法
 * 3.当JVM 执行可恢复对象的finalize()方法时，可能使该对象或系统中其他对象重新变成可达状态。
 * 4.当口叫执行finalize()方法时出现异常时，垃圾回收机制不会报告异常，程序继续执行。
 *
 * 由于finalize()方法并不一定会被执行，因此如果想清理某个类里打开的资源，则不要放在finalize()方法中进行清理
 *
 * 下面程序演示了如何在finalize()方法里复活自身， 并可通过该程序看出垃圾回收的不确定性。
 * @author JIE
 */
public class FinalizeFunction {

    private static FinalizeFunction ft = null;

    public void info() {
        System.out.println("测试资源清理的finalize 方法");
    }

    public static void main(String[] args) {
        // 创建FinalizeFunction 对象立即进入可恢复状态
        new FinalizeFunction();
        // /通知系统进行资源回收  1
        System.gc();
        // 强制垃圾回收机制调用可恢复对象的finalize()方法 2
        // Runtime.getRuntime().runFinalization();
        System.runFinalization();
        ft.info();
    }

    @Override
    protected void finalize() throws Throwable {
        // 让ft 引用到试图回收的可恢复对象，即可恢复对象重新变成可达
        ft = this;
    }

    /**
     * 上面程序中定义了一个FinalizeFunction 类，重写了该类的finalize方法， 在该方法中把需要清理的可恢复对象重新赋给ft引用变量，从而让该可恢复对象重新变成可达状态。
     * 上面程序中的main方法创建了一个FinalizeTest 类的匿名对象， 因为创建后没有把这个对象赋给任何引用变量，所以该对象立即进入可恢复状态。进入可恢复状态后，
     * 系统调用 1 代码通知系统进行垃圾回收， 2 代码强制系统立即调用可恢复对象的finalize方法，再次调用ft对象的info方法。编译、运行上面程序， 看到ft的info方法被正常执行。
     *
     * 如果删除 1 代码，取消强制垃圾回收。再次编译、运行上面程序将会看到 Exception in thread "main" java.lang.NullPointerException
     *
     * 从运行结果可以看出，如果取消 1 代码，程序并没有通知系统开始执行垃圾回收(而且程序内存也没有紧张) ，因此系统通常不会立即进行垃圾回收
     * 也就不会调用FinalizeFunction对象的finalize方法, 这样FinalizeFunction 的 ft 类变量将依然保持为null ，这样就导致了空指针异常。
     *
     * 上面程序中 2 代码都用于强制垃圾回收机制调用可恢复对象的finalize方法，如果程序仅执行System.gc;代码，而不执行 2 代码
     * 由于NM 垃圾回收机制的不确定性，JVM 往往并不立即调用可恢复对象的finalize方法，这样FinalizeFunction 的ft类变量可能依然为null ，可能依然会导致空指针异常
     */
}
