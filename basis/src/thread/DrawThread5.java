package thread;

/**
 * 线程通信 - 使用Condition 控制线程通信
 * @author JIE
 */
public class DrawThread5 extends Thread{

    /**
     * 模拟用户账户
     */
    private Account5 account;

    /**
     * 当前取钱线程所希望取的钱数
     */
    private double drawAmount;

    public DrawThread5(String name, Account5 account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        // 重复100 次执行取钱操作
        for (int i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }
    }
}
