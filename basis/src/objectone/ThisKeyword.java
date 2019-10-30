package objectone;

/**
 * 重点
 * 对象的this 引用
 *
 * Java 提供了一个this 关键字， this 关键字总是指向调用该方法的对象。
 * 根据this 出现位置的不同，this 作为对象的默认引用有两种情形。
 * 1.构造器中引用该构造器正在初始化的对象。
 * 2.在方法中引用调用该方法的对象。
 *
 * this 关键宇最大的作用就是让类中一个方法，访问该类里的另一个方法或实例变量。
 *
 * @author JIE
 */
public class ThisKeyword {

    public void jump() {
        System.out.println("正在执行jump方法");
    }

    /**
     * 定义一个run ()方法， run ()方法需要借助jump ()方法
     */
    public void run() {
        ThisKeyword jump = new ThisKeyword();
        jump.jump();
        System.out.println("正在执行run方法");
    }

    public static void main(String[] args) {
        ThisKeyword jumpAndRun = new ThisKeyword();
        jumpAndRun.run();
        /**
         * 解析：
         *
         * 在上面的程序中， 一共产生了两个ThisKeyword 对象，在ThisKeyword 类的run()方法中，程序创建了一个ThisKeyword 对象，
         * 并使用名为jump 的引用变量来指向该ThisKeyword 对象; 在main()方法中，程序再次创建了一个ThisKeyword对象，
         * 并使用名为jumpAndRun 的引用变量来指向该jumpAndRun 对象。
         *
         * 这里产生了两个问题。
         * 第一个问题: 在run()方法中调用jump()方法时是否一定需要一个ThisKeyword 对象?
         * 第二个问题:是否一定需要重新创建一个ThisKeyword 对象?
         * 第一个问题的答案是肯定的，因为没有使用static修饰的成员变量和方法都必须使用对象来调用。
         * 第二个问题的答案是否定的，因为当程序调用run()方法时， 一定会提供一个ThisKeyword 对象，
         * 这样就可以直接使用这个己经存在的ThisKeyword 对象，而无须重新创建新的ThisKeyword 对象了。
         *
         * 因此需要在run()方法中获得调用该方法的对象，通过this 关键字就可以满足这个要求。
         * this 可以代表任何对象， 当this 出现在某个方法体中时，它所代表的对象是不确定的，但它的类型是确定的:
         * 它所代表的只能是当前类的实例; 只有当这个方法被调用时，它所代表的对象才被确定下来:
         * 谁在调用这个方法， this 就代表谁。
         */

        // 所有使用ThisKeyword 创建的对象的foo 成员变量,都将被设为6 ，所以下面代码将输出6
        System.out.println(new ThisKeyword().foo);

        ThisKeyword tk = new ThisKeyword();
        System.out.println(tk.add().add().add().add().num);

    }


    /**
     * 将前面的ThisKeyword 类的run()方法改为如下形式会更加合适。
     */
    public void run2() {
        this.jump();
        System.out.println("正在执行run方法");
    }

    /**
     * 采用上面方法定义的更符合实际意义。
     * 从前一种定义来看，在ThisKeyword 对象的run()方法内重新创建了一个新的ThisKeyword 对象，并调用它的jump()方法，
     * 这意味着一个ThisKeyword 对象的run()方法需要依赖于另一个ThisKeyword 对象的jump()方法，远不符合逻辑。
     * 上面的代码更符合实际情形: 当一个ThisKeyword 对象调用run()方法时， run()方法需要依赖它自己的jump()方法。
     *
     * 在现实世界里，对象的一个方法依赖于另一个方法的情形如此常见:例如，吃饭方法依赖于拿筷子方法，
     * 写程序方法依赖于敲键盘方法，这种依赖都是同一个对象两个方法之间的依赖。因此， Java 允许
     * 对象的一个成员直接调用另一个成员， 可以省略this 前缀。也就是说，将上面的run()方法改为如下形
     * 式也完全正确。
     */
    public void run3() {
        jump();
        System.out.println("正在执行run方法");
    }


    /**
     * 定义一个名为foo 的成员变量
     */
    public int foo;
    /**
     * 除此之外， this 引用也可以用于构造器中作为默认引用，由于构造器是直接使用new 关键宇来调用，
     * 而不是使用对象来调用的，所以this 在构造器中代表该构造器正在初始化的对象。
     */
    public ThisKeyword() {
        // 在构造器里定义一个foo 变量
        int foo = 1;
        // 使用this 代表该构造器正在初始化的对象
        // 下面的代码将会把该构造器正在初始化的对象的foo 成员变量设为6
        this.foo = 6;
    }

    public int num;
    /**
     * 当this 作为对象的默认引用使用时，程序可以像访问普通引用变量一样来访问这个this 引用，
     * 甚至可以把this 当成普通方法的返回值
     * @return
     */
    public ThisKeyword add() {
        num++;
        return this;
    }
}
