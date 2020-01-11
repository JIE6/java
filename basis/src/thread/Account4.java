package thread;

/**
 * 线程通信 - 传统的线程通信
 *
 * 当线程在系统内运行时，线程的调度具有一定的透明性，程序通常无法准确控制线程的轮换执行，但Java 也提供了一些机制来保证线程协调运行。
 *
 * 传统的线程通信
 *
 * 假设现在系统中有两个线程，这两个线程分别代表存款者和取钱者, 现在假设系统有一种特殊的要求，系统要求存款者和取钱者不断地重复存款、取钱的动作，
 * 而且要求每当存款者将钱存入指定账户后，取钱者就立即取出该笔钱。不允许存款者连续两次存钱，也不允许取钱者连续两次取钱。
 *
 * 为了实现这种功能，可以借助于Object 类提供的wait() 、notify()和notifyAll()三个方法，这三个方法并不属于Thread 类，而是属于Object 类。
 * 但这三个方法必须由同步监视器对象来调用， 这可分成以下两种情况。
 * 1.对于使用synchronized 修饰的同步方法，因为该类的默认实例(this) 就是同步监视器，所以可以在同步方法中直接调用这三个方法。
 * 2.对于使用synchronized 修饰的同步代码块，同步监视器是synchronized 后括号里的对象， 所以必须使用该对象调用这三个方法。
 *
 * 关于这三个方法的解释如下。
 * wait(): 导致当前线程等待， 直到其他线程调用该同步监视器的notify()方法或notifyAll()方法来唤醒该线程。该wait()方法有三种形式
 * 无时间参数的wait (一直等待，直到其他线程通知)、带毫秒参数的wait()和带毫秒、毫微秒参数的wait() 这两种方法都是等待指定时间后自动苏醒)。
 * 调用wait()方法的当前线程会释放对该同步监视器的锁定。
 * notify(): 唤醒在此同步监视器上等待的单个线程。如果所有线程都在此同步监视器上等待，则会选择唤醒其中一个线程。选择是任意性的。
 * 只有当前线程放弃对该同步监视器的锁定后(使用wait()方法) ，才可以执行被唤醒的线程。
 * notifyAll(): 唤醒在此同步监视器土等待的所有线程。只有当前线程放弃对该同步监视器的锁定后，才可以执行被唤醒的线程。
 *
 * 程序中可以通过一个旗标来标识账户中是否己有存款，当旗标为false 时， 表明账户中没有存款，存款者线程可以向下执行，当存款者把钱存入账户后，将旗标设为true ，
 * 并调用notify()或notifyAll()方法来唤醒其他线程; 当存款者线程进入线程体后，如果旗标为true 就调用wait()方法让该线程等待。
 * 当旗标为true 时， 表明账户中己经存入了存款，则取钱者线程可以向下执行， 当取钱者把钱从账户中取出后，将旗标设为false ，
 * 并调用notify()或notifyAll()方法来唤醒其他线程:当取钱者线程进入线程体后，如果旗标为false 就调用wait()方法让该线程等待。
 *
 * 本程序为Account 类提供draw()和deposit()两个方法，分别对应该账户的取钱、存款等操作，因为这两个方法可能需要并发修改Account 类的balance 成员变量的值，
 * 所以这两个方法都使用synchronized修饰成同步方法。除此之外，这两个方法还使用了wait() 、notifyAll()来控制线程的协作。
 *
 * @author JIE
 */
public class Account4 {

    /**
     * 封装账户编号、账户余额的两个成员变量
     */
    private String accountNo;
    private double balance;

    /**
     * /标识账户中是否已有存款的旗标
     */
    private boolean flag = false;

    public Account4() {}

    public Account4(String accountNo, double balance) {
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


    public synchronized void draw(double drawAmount) {
        try {
            // 如果flag 为假，表明账户中还没有人存钱进去，取钱方法阻塞
            if (!flag) {
                wait();
            }else {
                // 执行取钱操作
                System.out.println(Thread.currentThread().getName() + ", 取钱：" + drawAmount);
                // 修改余额
                balance -= drawAmount;
                System.out.println("余额为：" + balance);
                // 将标识账户是否己有存款的旗标设为false
                flag = false;
                // 唤醒其他线程
                notifyAll();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try {
            // 如果flag 为真， 表明账户中己有人存钱进去，存钱方法阻塞
            if (flag) {
                wait();
            }else {
                // 执行存款操作
                System.out.println(Thread.currentThread().getName() + ", 存款：" + depositAmount);
                balance += depositAmount;
                // 将表示账户是否己有存款的旗标设为true
                flag = true;
                // 唤醒其他线程
                notifyAll();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
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
        if (obj != null && obj.getClass() == Account4.class) {
            Account4 target = (Account4)obj;
            return target.accountNo.equals(this.accountNo);
        }
        return false;
    }
}
