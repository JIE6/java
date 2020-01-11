package thread;

/**
 * ThreadLocal 线程相关类
 * @author JIE
 */
public class MyTest extends Thread{

    private Account6 account;

    public MyTest(String name, Account6 account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            // 当i == 6 时输出将账户名替换成当前线程名
            if ((i == 6)) {
                account.setName(getName());
            }
            // 输出同一个账户的账户名和循环变量
            System.out.println(account.getName() + " " + i);
        }
    }
}
