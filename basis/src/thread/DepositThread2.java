package thread;

/**
 * 线程通信 - 使用Condition 控制线程通信
 *
 * @author JIE
 */
public class DepositThread2 extends Thread{

    /**
     * 模拟用户账户
     */
    private Account5 account;

    /**
     * 当前存款线程所希望存的钱数
     */
    private double depositAmount;

    public DepositThread2(String name, Account5 account, double depositAmount) {
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
