package thread;

/**
 * 程通信 - 使用Condition 控制线程通信
 * @author JIE
 */
public class DrawTest2 {

    public static void main(String[] args) {
        Account5 acct = new Account5("1234567", 0);
        new DrawThread5("取钱者", acct, 800).start();
        new DepositThread2("存款者甲", acct, 800).start();
        new DepositThread2("存款者乙", acct, 800).start();
        new DepositThread2("存款者丙", acct, 800).start();
    }
}
