package thread;

/**
 * 线程通信 - 传统的线程通信
 *
 * @author JIE
 */
public class DepositThread extends Thread{

    /**
     * 模拟用户账户
     */
    private Account4 account;

    /**
     * 当前存款线程所希望存的钱数
     */
    private double depositAmount;

    public DepositThread(String name, Account4 account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        // 重复100 次执行存款操作
        for (int i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }
}
