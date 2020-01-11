package thread;

/**
 * 程通信 - 传统的线程通信
 * @author JIE
 */
public class DrawTest {

    public static void main(String[] args) {
        // 创建一个账户
        Account4 acct = new Account4("1234567", 0);

        new DrawThread4("取钱者", acct, 800).start();
        new DepositThread("存款者甲", acct, 800).start();
        new DepositThread("存款者乙", acct, 800).start();
        new DepositThread("存款者丙", acct, 800).start();
    }

    /**
     * 运行该程序，可以看到存款者线程、取钱者线程交替执行的情形，每当存款者向账户中存入800 元之后，取钱者线程立即从账户中取出这笔钱。
     * 存款完成后账户余额总是800 元，取钱结束后账户余额总是 0 元。
     * 但有 3 个存款者线程随机地向账户中存款，只有 1 个取钱者线程执行取钱操作。只有当取钱者取钱后，存款者才可以存款;同理，只有等存款者存款后，取钱者线程才可以取钱。
     * 显示程序最后被阻塞无法继续向下执行， 这是因为 3 个存款者线程共有300 次尝试存款操作，但1 个取钱者线程只有100 次尝试取钱操作，所以程序最后被阻塞。
     *
     * 阻塞并不是死锁，对于这种情况，取钱者线程已经执行结束，而存款者线程只是在等待其他线程来取钱而己，并不是等待其他线程释放同步监视器。不要把死锁和程序阻塞等同起来!
     *
     */
}
