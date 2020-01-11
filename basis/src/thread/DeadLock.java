package thread;

/**
 * 死锁
 *
 * 当两个线程相互等待对方释放同步监视器时就会发生死锁， Java 虚拟机没有监测，也没有采取措施来处理死锁情况，所以多线程编程时应该采取措施避免死锁出现。
 * 一旦出现死锁， 整个程序既不会发生任何异常，也不会给出任何提示，只是所有线程处于阻塞状态， 无法继续。
 * 死锁是很容易发生的，尤其在系统中出现多个同步监视器的情况下，如下程序将会出现死锁。
 * @author JIE
 */
public class DeadLock implements Runnable{

    class A {
        public synchronized void foo(B b) {
            System.out.println(Thread.currentThread().getName() + "进入了A实例的foo方法");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "企图调用B实例的last方法");
            b.last();
        }

        public synchronized void last() {
            System.out.println("进入了A内部的last方法");
        }
    }

    class B {

        public synchronized void bar(A a) {
            System.out.println(Thread.currentThread().getName() + "进入了B实例的bar方法");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "企图调用A实例的last方法");
            a.last();
        }

            public synchronized void last() {
            System.out.println("进入了B内部的last方法");
        }
    }

    A a = new A();
    B b = new B();

    public void init() {
        Thread.currentThread().setName("主线程");
        // 调用a 对象的foo ()方法
        a.foo(b);
        System.out.println("进入了主线程之后") ;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("副线程");
        // 调用 b 对象的bar() 方法
        b.bar(a);
        System.out.println("进入了副线程之后") ;
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();
        // 以dl 为target 启动新线程
        new Thread(dl).start();
        // 调用init ()方法
        dl.init();
    }
    /**
     * 运行程序，将会看到
     *
     * 主线程进入了A实例的foo方法
     * 副线程进入了B实例的bar方法
     * 主线程企图调用B实例的last方法
     * 副线程企图调用A实例的last方法
     *
     * 可以看出，程序既无法向下执行，也不会抛出任何异常， 就一直"僵持"着。究其原因，是因为:
     * 上面程序中A 对象和B 对象的方法都是同步方法，也就是A 对象和B 对象都是同步锁。程序中两个线程执行，
     * 副线程的线程执行体是DeadLock 类的run()方法，主线程的线程执行体是DeadLock 的main()方法
     * (主线程调用了init()方法)。其中run()方法中让B 对象调用bar()方法，而init()方法让A 对象调用foo()方法
     * 结果显示init()方法先执行，调用了A 对象的foo()方法，进入foo()方法之前，该线程对A 对象加锁然后主线程暂停200ms ;
     * CPU 切换到执行另一个线程，让B 对象执行bar()方法，所以看到副线程开始执行B 实例的bar()方法，进入bar()方法之前，该线程对B 对象加锁
     * 当程序执行到sleep后，副线程也暂停200ms; 接下来主线程会先醒过来，继续向下执行，直到调用B 对象的last()方法， 执行该方法之前必须先对B 对象加锁，
     * 但此时副线程正保持着B 对象的锁，所以主线程阻塞;接下来副线程应该也醒过来了，继续向下执行，直到代码处希望调用A 对象的last()方法
     * 执行该方法之前必须先对A 对象加锁，但此时主线程没有释放对A 对象的锁, 至此，
     * 就出现了主线程保持着A 对象的锁， 等待对B 对象加锁，而副线程保持着B 对象的锁，等待对A 对象加锁，两个线程互相等待对方先释放，所以就出现了死锁。
     */
}
