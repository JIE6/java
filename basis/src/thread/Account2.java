package thread;

/**
 * 同步方法
 *
 * 与同步代码块对应， Java 的多线程安全支持还提供了同步方法，同步方法就是使用synchronized 关键字来修饰某个方法，
 * 则该方法称为同步方法。对于synchronized 修饰的实例方法(非static 方法)而言，无须显式指定同步监视器，
 * 同步方法的同步监视器是this ，也就是调用该方法的对象。
 *
 * 通过使用同步方法可以非常方便地实现线程安全的类，线程安全的类具有如下特征。
 * 该类的对象可以被多个线程安全地访问。
 * 每个线程调用该对象的任意方法之后都将得到正确结果。
 * 每个线程调用该对象的任意方法之后，该对象状态依然保持合理状态。
 *
 * 前面介绍了可变类和不可变类，其中不可变类总是线程安全的，因为它的对象状态不可改变;但可变对象需要额外的方法来保证其线程安全。
 * 例如上面的Account 就是一个可变类，它的accountNo 和balance 两个成员变量都可以被改变， 当两个线程同时修改Account 对象的balance 成员变量的值时，
 * 程序就出现了异常。
 *
 * 下面将Account 类对balance 的访问设置成线程安全的，那么只要把修改balance 的方法变成同步方法即可。
 *
 * synchronized 关键字可以饰方法，可以饰代码块，但不能修饰构造器、成员变量等。
 *
 * 程序如下所示。
 * @author JIE
 */
public class Account2 {

    /**
     * 封装账户编号、账户余额的两个成员变量
     */
    private String accountNo;
    private double balance;

    public Account2() {}

    public Account2(String accountNo, double balance) {
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
     * 程序增加了一个代表取钱的draw()方法，井使用了synchronized 关键宇修饰该方法，把该方法变成同步方法， 该同步方法的同步监视器是this ，
     * 因此对于同一个Account 账户而言，任意时刻只能有一个线程获得对Account 对象的锁定，然后进入draw()方法执行取钱操作, 这样也可以保证多个线
     * 程并发取钱的线程安全。
     *
     * 因为Account 类中已经提供了draw()方法，而且取消了setBalance()方法， DrawThread 线程类需要改写，
     * 该线程类的run()方法只要调用Account 对象的draw()方法即可执行取钱操作。run()方法代码片段参考 DrawThread3
     * @param drawAmount
     */
    public synchronized void draw(double drawAmount) {
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
        if (obj != null && obj.getClass() == Account2.class) {
            Account2 target = (Account2)obj;
            return target.accountNo.equals(this.accountNo);
        }
        return false;
    }
}
