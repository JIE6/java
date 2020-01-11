package thread;

/**
 * 线程通信 - 传统的线程通信
 *
 * Account4 代码使用wait()和notifyAll()进行了控制，对存款者线程而言，当程序进入deposit()方法后，如果flag 为true ，
 * 则表明账户中己有存款，程序调用wait()方法阻塞;否则程序向下执行存款操作，当存款操作执行完成后，系统将flag 设为true ，
 * 然后调用notifyAll()来唤醒其他被阻塞的线程, 如果系统中有存款者线程，存款者线程也会被唤醒，
 * 但该存款者线程执行到if(flag)代码处时再次进入阻塞状态，只有执行draw()方法的取钱者线程才可以向下执行。
 * 同理，取钱者线程的运行流程也是如此。
 *
 * 程序中的存款者线程循环100 次重复存款，而取钱者线程则循环100 次重复取钱，存款者线程和取钱者线程分别调用Account 对象的deposit() 、draw()方法来实现。
 * @author JIE
 */
public class DrawThread4 extends Thread{

    /**
     * 模拟用户账户
     */
    private Account4 account;

    /**
     * 当前取钱线程所希望取的钱数
     */
    private double drawAmount;

    public DrawThread4(String name, Account4 account, double drawAmount) {
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
