package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信 - 使用Condition 控制线程通信
 *
 * 如果程序不使用synchronized 关键字来保证同步，而是直接使用Lock 对象来保证同步，则系统中不存在隐式的同步监视器，
 * 也就不能使用wait() 、notify() 、notifyAll()方法进行线程通信了.
 *
 * 当使用Lock 对象来保证同步时， Java 提供了一个Condition 类来保持协调，使用Condition 可以让那些已经得到Lock 对象却无法继续执行的线程释放Lock 对象，
 * Condition 对象也可以唤醒其他处于等待的线程。
 *
 * Condition 将同步监视器方法( wait() 、notify() 和notifyAll() )分解成截然不同的对象，以便通过将这些对象与Lock 对象组合使用，
 * 为每个对象提供多个等待集( wait-set ) 。在这种情况下， Lock 替代了同步方法或同步代码块， Condition 替代了同步监视器的功能。
 *
 * Condition 实例被绑定在一个Lock 对象上。要获得特定Lock 实例的Condition 实例，调用Lock 对象的newCondition()方法即可。
 * Condition 类提供了如下三个方法。
 * await(): 类似于隐式同步监视器上的wait()方法，导致当前线程等待， 直到其他线程调用该Condition的signal()方法或signalAll()方法来唤醒该线程。
 * 该await()方法有更多变体， 如long awaitNanos(long nanosTimeout) 、void awaitUninterruptibly() 、awaitUntil(Date deadline)等，可以完成更丰富的等待操作。
 * signal(): 唤醒在此Lock 对象上等待的单个线程。如果所有线程都在该Lock 对象上等待，则会选择唤醒其中一个线程。选择是任意性的。
 * 只有当前线程放弃对该Lock 对象的锁定后(使用await()方法) ，才可以执行被唤醒的线程。
 * signalAll(): 唤醒在此Lock 对象上等待的所有线程。只有当前线程放弃对该Lock 对象的锁定后，才可以执行被唤醒的线程。
 *
 * 下面程序中Account 使用Lock 对象来控制同步，并使用Condition 对象来控制线程的协调运行。
 * @author JIE
 */
public class Account5 {

    /**
     * 显式定义Lock 对象
     */
    private final Lock lock = new ReentrantLock();
    /**
     * 获得指定Lock 对象对应的Condition
     */
    private final Condition cond = lock.newCondition();

    /**
     * 封装账户编号、账户余额的两个成员变量
     */
    private String accountNo;
    private double balance;

    /**
     * /标识账户中是否已有存款的旗标
     */
    private boolean flag = false;

    public Account5() {}

    public Account5(String accountNo, double balance) {
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


    public void draw(double drawAmount) {
        // 加锁
        lock.lock();
        try {
            // 如果flag 为假，表明账户中还没有人存钱进去，取钱方法阻塞
            if (!flag) {
                cond.await();
            }else {
                // 执行取钱操作
                System.out.println(Thread.currentThread().getName() + ", 取钱：" + drawAmount);
                // 修改余额
                balance -= drawAmount;
                System.out.println("余额为：" + balance);
                // 将标识账户是否己有存款的旗标设为false
                flag = false;
                // 唤醒其他线程
                cond.signalAll();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void deposit(double depositAmount) {
        lock.lock();
        try {
            // 如果flag 为真， 表明账户中己有人存钱进去，存钱方法阻塞
            if (flag) {
                cond.await();
            }else {
                // 执行存款操作
                System.out.println(Thread.currentThread().getName() + ", 存款：" + depositAmount);
                balance += depositAmount;
                // 将表示账户是否己有存款的旗标设为true
                flag = true;
                // 唤醒其他线程
                cond.signalAll();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
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
        if (obj != null && obj.getClass() == Account5.class) {
            Account5 target = (Account5)obj;
            return target.accountNo.equals(this.accountNo);
        }
        return false;
    }
}
