package thread;

/**
 * 线程同步
 *
 * 根据Account提供一个取钱的线程类，该线程类根据执行账户、取钱数量进行取钱操作，
 * 取钱的逻辑是当其余额不足时无法提取现金，当余额足够时系统吐出钞票， 余额减少。
 *
 * @author JIE
 */
public class DrawThread extends Thread{

    /**
     * 模拟用户账户
     */
    private Account account;

    /**
     * 当前取钱线程所希望取的钱数
     */
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    /**
     * 当多个线程修改同一个共享数据时，将涉及数据安全问题
     */
    @Override
    public void run() {
        // 账户余额大于取钱数目
        if (account.getBalance() >= drawAmount) {
            // 吐出钞票
            System.out.println(getName() + ", 取钱成功！吐出钞票：" + drawAmount);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            // 修改账户余额
            account.setBalance(account.getBalance() - drawAmount);
            System.out.println("余额为：" + account.getBalance());
        }else {
            System.out.println(getName() + ", 取钱失败！余额不足：drawAmount=" + drawAmount + ", account.getBalance()=" + account.getBalance());
        }
    }

    public static void main(String[] args) {
        // 创建一个账户
        Account acct = new Account("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new DrawThread("甲", acct, 800).start();
        new DrawThread("乙", acct, 800).start();
    }
    /**
     * 多次运行上面程序，很有可能都会看到下面出现的错误结果。
     *
     * 甲, 取钱成功！吐出钞票：800.0
     * 乙, 取钱成功！吐出钞票：800.0
     * 甲, 余额为：200.0
     * 乙, 余额为：-600.0
     *
     * 运行结果并不是银行所期望的结果(不过有可能看到运行正确的效果)，这正是多线程编程突然出现的"偶然"错误
     * 因为线程调度的不确定性。假设系统线程调度器在 取钱处
     * System.out.println(getName() + ", 余额为：" + account.getBalance());
     * 后暂停，让另一个线程执行，为了强制暂停，只要取消上面程序中代码的注释即可.
     * 取消注释后再次编译运行， 将总可以看到如下所示的错误结果。
     *
     * 甲, 取钱成功！吐出钞票：800.0
     * 乙, 取钱成功！吐出钞票：800.0
     * 乙, 余额为：200.0
     * 甲, 余额为：-600.0
     *
     * 问题出现了:账户余额只有1000 时取出了1600 ，而且账户余额出现了负值，这不是银行希望的结果。
     * 虽然上面程序是人为地使用Thread.sleep(1)来强制线程调度切换， 但这种切换也是完全可能发生的
     * 100000 次操作只要有 1 次出现了错误，那就是编程错误引起的。
     */
}
