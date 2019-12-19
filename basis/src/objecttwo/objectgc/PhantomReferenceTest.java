package objecttwo.objectgc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 对象的软、弱和虚引用
 * 使用虚引用来引用字符串对象，虚引用无法获取它引用的对象。下面程序还将虚引用和引用队列结合使用，
 * 可以看到被虚引用所引用的对象被垃圾回收后，虚引用将被添加到引用队列中
 * @author JIE
 */
public class PhantomReferenceTest {

    public static void main(String[] args) {
        // 创建一个字符串对象
        String str = new String(" 疯狂Java 讲义" );
        // 创建一个引用队列
        ReferenceQueue rq = new ReferenceQueue();
        // 创建一个虚引用，让此虚引用引用到"疯狂Java 讲义"字符串
        PhantomReference pr = new PhantomReference(str, rq);
        // 切断str 引用和" 疯狂Java 讲义"字符串之间的引用
        str = null;
        // 取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，所以此处输出null 1
        System.out.println(pr.get());
        // 强制垃圾回收
        System.gc();
        System.runFinalization();
        // 垃圾回收之后，虚引用将被放入引用队列中, 取出引用队列中最先进入队列的引用与pr 进行比较 2
        System.out.println(rq.poll() == pr);

        /**
         * 因为系统无法通过虚引用来获得被引用的对象，所以执行 1 的输出语句时，程序将输出null ( 即使此时并未强制进行垃圾回收) 。
         * 当程序强制垃圾回收后，只有虚引用引用的字符串对象将会被垃圾回收，当被引用的对象被回收后，对应的虚引用将被添加到关联的引用队列中，
         * 因而将在 2 代码处看到输出true 。
         *
         * 使用这些引用类可以避免在程序执行期间将对象留在内存中。如果以软引用、弱引用或虚引用的方式引用对象，垃圾回收器就能够随意地释放对象。
         * 如果希望尽可能减小程序在其生命周期中所占用的内存大小时，这些引用类就很有用处。
         *
         * 必须指出:要使用这些特殊的引用类，就不能保留对对象的强引用:如果保留了对对象的强引用，就会浪费这些引用类所提供的任何好处。
         *
         * 由于垃圾回收的不确定性，当程序希望从软、弱引用中取出被引用对象时，可能这个被引用对象己经被释放了。如果程序需要使用那个被引用的对象，
         * 则必须重新创建该对象。
         */
    }
}
