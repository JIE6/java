package thread;

/**
 * 同步代码块 - 解决银行取钱的问题
 *
 * 之所以出现如 DrawThread 所示的结果, 是因为run()方法的方法体不具有同步安全性, 程序中有两个并发线程在修改Account 对象
 * 而且系统恰好在 修改账户余额 之前执行线程切换，切换给另一个修改Account对象的线程，所以就出现了问题。
 *
 * 为了解决这个问题， Java 的多线程支持引入了同步监视器来解决这个问题，使用同步监视器的通用方法就是同步代码块。同步代码块的语法格式如下:
 * synchronized(obj) {
 *     ...
 *     // 此处的代码就是同步代码块
 * }
 * 上面语法格式中synchronized 后括号里的obj 就是同步监视器，上面代码的含义是: 线程开始执行同步代码块之前，必须先获得对同步监视器的锁定。
 *
 * 任何时刻只能有一个线程可以获得对同步监视器的锁定，当同步代码块执行完成后，该线程会释放对该同步监视器的锁定。
 *
 * 虽然Java 程序允许使用任何对象作为同步监视器，但想一下同步监视器的目的: 阻止两个线程对同一个共享资源进行并发访问，
 * 因此通常推荐使用可能被并发访问的共享资源充当同步监视器。对于上面的取钱模拟程序，应该考虑使用账户(account ) 作为同步监视器，
 * 把程序修改成如下形式。
 *
 * @author JIE
 */
public class DrawThread2 extends Thread{

    /**
     * 模拟用户账户
     */
    private Account account;

    /**
     * 当前取钱线程所希望取的钱数
     */
    private double drawAmount;

    public DrawThread2(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    /**
     * 当多个线程修改同一个共享数据时，将涉及数据安全问题
     */
    @Override
    public void run() {

        // 使用account 作为同步监视器，任何线程进入下面同步代码块之前, 必须先获得对account 账户的锁定, 其他线程无法获得锁，也就无法修改它,
        // 这种做法符合: "加锁→修改→释放锁" 的逻辑
        synchronized (account) {
            // 账户余额大于取钱数目
            if (account.getBalance() >= drawAmount) {
                // 吐出钞票
                System.out.println(getName() + ", 取钱成功！吐出钞票：" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改账户余额
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("余额为：" + account.getBalance());
            }else {
                System.out.println(getName() + ", 取钱失败！余额不足：drawAmount=" + drawAmount + ", account.getBalance()=" + account.getBalance());
            }
        }
        // 同步代码块结束，该线程释放同步锁
    }

    public static void main(String[] args) {
        // 创建一个账户
        Account acct = new Account("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new DrawThread2("甲", acct, 800).start();
        new DrawThread2("乙", acct, 800).start();
    }
    /**
     * 上面程序使用synchronized 将run()方法里的方法体修改成同步代码块，该同步代码块的同步监视器是account 对象，
     * 这样的做法符合"加锁→修改→释放锁"的逻辑，任何线程在修改指定资源之前，首先对该资源加锁，在加锁期间其他线程无法修改该资源，
     * 当该线程修改完成后，该线程释放对该资源的锁定。通过这种方式就可以保证并发线程在任一时刻只有一个线程可以进入修改共享资源的代码区( 也被称为临界区) ,
     * 所以同一时刻最多只有一个线程处于临界区内，从而保证了线程的安全性。
     *
     * 将DrawThread 修改为上面所示的情形之后， 多次运行该程序，总可以看到如下所示的正确结果。
     *
     * 甲, 取钱成功！吐出钞票：800.0
     * 甲, 余额为：200.0
     * 乙, 取钱失败！余额不足：drawAmount=800.0, account.getBalance()=200.0
     */
}
