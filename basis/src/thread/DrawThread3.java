package thread;

/**
 * 同步方法 - 银行取钱
 * @author JIE
 */
public class DrawThread3 extends Thread{

    /**
     * 模拟用户账户
     */
    private Account2 account;

    /**
     * 当前取钱线程所希望取的钱数
     */
    private double drawAmount;

    public DrawThread3(String name, Account2 account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    /**
     * 当多个线程修改同一个共享数据时，将涉及数据安全问题
     */
    @Override
    public void run() {
        // 直接调用account 对象的draw()方法来执行取钱操作, 同步方法的同步监视器是this ， this 代表调用draw() 方法的对象
        // 也就是说，线程进入draw()方法之前，必须先对account 对象加锁
        account.draw(drawAmount);
    }

    public static void main(String[] args) {
        // 创建一个账户
        Account2 acct = new Account2("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new DrawThread3("甲", acct, 800).start();
        new DrawThread3("乙", acct, 800).start();
    }
    /**
     * DrawThread3 类无须自己实现取钱操作，而是直接调用account 的draw()方法来执行取钱操作.
     *
     * 由于己经使用synchronized 关键字修饰了draw()方法，同步方法的同步监视器是this ，而this 总代表调用该方法的对象
     *
     * 调用draw()方法的对象是account ， 因此多个线程并发修改同一份account 之前，必须先对account 对象加锁。
     * 这也符合了"加锁→修改→释放锁"的逻辑。
     *
     *
     * 在Account 里定义draw()方法， 而不是直接在run()方法中实现取钱逻辑，这种做法更符合面向对象规则。
     * 在面向对象里有一种流行的设计方式Domain Driven Design (领域驱动设计， DDD ) ，这种方式认为每个类都应该是完备的领域对象，
     * 例如Account 代表用户账户，应该提供用户账户的相关方法; 通过draw()方法来执行取钱操作(实际上还应该提供transfer()等方法来完成转账等操作)，
     * 而不是直接将setBalance()方法暴露出来任人操作，这样才可以更好地保证Account 对象的完整性和一致性。
     *
     * 可变类的线程安全是以降低程序的运行效率作为代价的，为了减少线程安全所带来的负面影响，程序可以采用如下策略。
     * 不要对线程安全类的所有方法都进行同步， 只对那些会改变竞争资源(竞争资源也就是共享资源)的方法进行同步。
     * 例如上面Account 类中的accountNo 实例变量就无须同步，所以程序只对draw()方法进行了同步控制。
     *
     * 如果可变类有两种运行环境: 单线程环境和多线程环境，则应该为该可变类提供两种版本，即线程不安全版本和线程安全版本。
     * 在单线程环境中使用线程不安全版本以保证性能， 在多线程环境中使用线程安全版本。
     *
     * JDK 所提供的StringBuilder 、StringBuffer 就是为了照顾单线程环境和多线程环境所提供的类，
     * 在单线程环境下应该使用StringBuilder 来保证较好的性能; 当需要保证多线程安全时，就应该使用StringBuffer 。
     */
}
