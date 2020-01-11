package thread;

/**
 * 线程同步
 *
 * 多线程编程是有趣的事情， 它很容易突然出现" 错误情况"，这是由系统的线程调度具有一定的随机性造成的，
 * 不过即使程序偶然出现问题，那也是由于编程不当引起的。当使用多个线程来访问同一个数据时， 很容易"偶然" 出现线程安全问题。
 *
 * 线程安全问题
 *
 * 关于线程安全问题，有一个经典的问题
 * 银行取钱的问题。银行取钱的基本流程基本上可以分为如下几个步骤。
 * 1.用户输入账户、密码， 系统判断用户的账户、密码是否匹配。
 * 2.用户输入取款金额。
 * 3.系统判断账户余额是否大于取款金额。
 * 4.如果余额大于取款金额， 则取款成功; 如果余额小于取款金额，则取款失败。
 *
 * 乍一看上去，这个流程确实就是日常生活中的取款流程，这个流程没有任何问题。但一旦将这个流程放在多线程并发的场景下，就有可能出现问题。
 * 注意此处说的是有可能， 并不是说一定。也许你的程序运行了一百万次都没有出现问题，但没有出现问题并不等于没有问题!
 * 按上面的流程去编写取款程序，并使用两个线程来模拟取钱操作， 模拟两个人使用同一个账户并发取钱的问题。此处忽略检查账户和密码的操作， 仅仅模拟后面三步操作。
 * 下面先定义一个账户类，该账户类封装了账户编号和余额两个实例变量。
 * @author JIE
 */
public class Account {

    /**
     * 封装账户编号、账户余额的两个成员变量
     */
    private String accountNo;
    private double balance;

    public Account() {}

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
        if (obj != null && obj.getClass() == Account.class) {
            Account target = (Account)obj;
            return target.accountNo.equals(this.accountNo);
        }
        return false;
    }
}
