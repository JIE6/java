package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步锁(Lock)
 *
 * 从Java 5 开始， Java 提供了一种功能更强大的线程同步机制， 通过显式定义同步锁对象来实现同步， 在这种机制下， 同步锁由Lock 对象充当。
 *
 * Lock 提供了比synchronized 方法和synchronized 代码块更广泛的锁定操作， Lock 允许实现更灵活的结构，可以具有差别很大的属性，
 * 并且支持多个相关的Condition 对象。
 *
 * Lock 是控制多个线程对共享资源进行访问的工具。通常， 锁提供了对共享资源的独占访问， 每次只能有一个线程对Lock 对象加锁，线程开始访问共享资源之前应先获得Lock 对象。
 *
 * 某些锁可能允许对共享资源并发访问，如ReadWriteLock (读写锁) ， Lock、ReadWriteLock 是Java 5提供的两个根接口，
 * 并为Lock 提供了ReentrantLock (可重入锁)实现类，为ReadWriteLock 提供了ReentrantReadWriteLock 实现类。
 *
 * Java 8 新增了新型的StampedLock 类， 在大多数场景中它可以替代传统的ReentrantReadWriteLock。
 * ReentrantReadWriteLock 为读写操作提供了三种锁模式: Writing 、ReadingOptimistic 、Reading 。
 *
 * 在实现线程安全的控制中， 比较常用的是ReentrantLock (可重入锁)。使用该Lock 对象可以显式地加锁、释放锁，
 * 通常使用ReentrantLock 的代码格式如下:
 * class X {
 *     // 定义锁对象
 *     private final ReentrantLock lock = new ReentrantLock();
 *     // ...
 *
 *     // 定义需要保证线程安全的方法
 *     public void m() {
 *     // 加锁
 *      lock.lock();
 *      try{
 *      // 需要保证线程安全的代码
 *      ......
 *      // 使用finally 块来保证释放锁
 *      }finally {
 *       lock.unlock() ;
 *      }
 *     }
 * }
 * 使用ReentrantLock 对象来进行同步，加锁和释放锁出现在不同的作用范围内时，通常建议使用finally 块来确保在必要时释放锁。
 * 通过使用ReentrantLock 对象，可以把Account 类改为如下形式，它依然是线程安全的。
 *
 * @author JIE
 */
public class Account3 {
    /**
     * 定义锁对象
     */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 封装账户编号、账户余额的两个成员变量
     */
    private String accountNo;
    private double balance;

    public Account3() {}

    public Account3(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * 因为账户余额不允许随便修改，所以只为balance 提供getter 方法
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 提供一个线程安全的draw() 方法来完成取钱操作
     *
     * 程序中定义了一个ReentrantLock 对象，程序中实现draw()方法时，进入方法开始执行后立即请求对ReentrantLock 对象进行加锁，
     * 当执行完draw()方法的取钱逻辑之后，程序使用finally 块来确保释放锁。
     *
     * 使用Lock 与使用同步方法有点相似，只是使用Lock 时显式使用Lock 对象作为同步锁，而使用同步方法时系统隐式使用当前对象作为同步监视器，
     * 同样都符合"加锁→修改→梓放锁" 的操作模式， 而且使用Lock 对象时每个Lock 对象对应一个Account 对象，一样可以保证对于同一个Account 对象，
     * 同一时刻只能有一个线程能进入临界区。
     *
     * 同步方法或同步代码块使用与竞争资源相关的、隐式的同步监视器，并且强制要求加锁和释放锁要出现在一个块结构中，而且当获取了多个锁时，
     * 它们必须以相反的顺序释放，且必须在与所有锁被获取时相同的范围内释放所有锁。
     *
     * 虽然同步方法和同步代码块的范围机制使得多线程安全编程非常方便，而且还可以避免很多涉及锁的常见编程错误，但有时也需要以更为灵活的方式使用锁。
     * Lock 提供了同步方法和同步代码块所没有的其他功能，包括用于非块结构的tryLock()方法，以及试图获取可中断锁的lockInterruptibly()方法， 还
     * 有获取超时失效锁的tryLock(long， TimeUnit)方法。
     *
     * ReentrantLock 锁具有可重入性，也就是说， 一个线程可以对己被加锁的ReentrantLock 锁再次加锁，ReentrantLock 对象会维持一个计数器来追踪lock()方法的嵌套调用，
     * 线程在每次调用lock()加锁后，必须显式调用unlock()来释放锁，所以一段被锁保护的代码可以调用另一个被相同锁保护的方法。
     *
     * @param drawAmount
     */
    public void draw(double drawAmount) {
        // 加锁
        lock.lock();
        try {
            // 账户余额大于取钱数目
            if (this.balance >= drawAmount) {
                // 吐出钞票
                System.out.println(Thread.currentThread().getName() + ", 取钱成功！吐出钞票：" + drawAmount);
                // 修改余额
                balance -= drawAmount;
                System.out.println("余额为：" + balance);
            }else {
                System.out.println(Thread.currentThread().getName() + ", 取钱失败！余额不足：drawAmount=" + drawAmount + ", balance=" + balance);
            }
        }finally {
            // 修改完成，释放锁
            lock.unlock();
        }
    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Account3.class) {
            Account3 target = (Account3)obj;
            return target.accountNo.equals(this.accountNo);
        }
        return false;
    }
}
