package throwable;

/**
 * 使用finally 回收资源
 *
 * 有些时候，程序在try 块里打开了一些物理资源(例如数据库连接、网络连接和磁盘文件等) ，这些物理资源都必须显式回收。
 *
 * Java 的垃圾回收机制不会回收任何物理资源， 垃圾回收时仅能回收堆内存中对象所占用的内存。
 *
 * 为了保证一定能回收try 块中打开的物理资源，异常处理机制提供了finally 块。不管try 块中的代码是否出现异常，也不管哪一个catch 块被执行，
 * 甚至在try 块或catch 块中执行了return 语句， finally块总会被执行。
 *
 * 异常处理语法结构中只有try 块是必需的，也就是说，如果没有try块，则不能有后面的catch 块和finally 块; catch 块和finally 块都是可选的，
 * 但catch 块和finally 块至少出现其中之一，也可以同时出现:可以有多个catch 块，捕获父类异常的catch 块必须位于捕获子类异常的后面;
 * 但不能只有try块，既没有catch 块，也没有finally 块;多个catch 块必须位于try 块之后， finally 块必须位于所有的catch块之后。
 *
 * @author JIE
 */
public class FinallyTest {

    public static void main(String[] args) {
        try {
            System.out.println("第一步");
            int i = 10 / 0;
        }catch (Exception e) {
            System.out.println("第二步");
            // return 语句强制方法返回
            return;
            // 使用exit 退出虚拟机
//            System.exit(1);
        }finally {
            System.out.println("第三步");
            /**
             * 上面程序的try 块后增加了finally 块，注意程序的catch 块中处有一条return语句，该语句强制方法返回。在通常情况下，一旦在方法里执行到return语句的地方，
             * 程序将立即结束该方法:现在不会了，虽然return语句也强制方法结束，但一定会先执行finally 块里的代码。
             *
             * 上面运行结果表明方法返回之前还是执行了finally 块的代码。将 return 语句注释掉 使用System.exit(1)语句来退出虚拟机。
             * 上面执行结果表明finally 块没有被执行。如果在异常处理代码中使用System.exit(1)语句来退出虚拟机，则finally 块将失去执行的机会。
             *
             * 除非在try 块、catch 块中调用了退出虚拟机的方法， 否则不管在try 块、catch 块中执行怎样的代码， 出现怎样的情况， 异常处理的finally 块总会被执行。
             *
             * 在通常情况下，不要在finally 块中使用如return 或throw 等导致方法终止的语句， (throw 语句将在后面介绍) ， 一旦在finally 块中使用了return 或throw 语句，
             * 将会导致try 块、catch 块中的return 、throw语句失效。
             * 看test()程序。
             */
            System.out.println(test());

            /**
             * 当Java 程序执行try 块、catch 块时遇到了return 或throw 语句，这两个语句都会导致该方法立即结束， 但是系统执行这两个语句并不会结束该方法，
             * 而是去寻找该异常处理流程中是否包含finally 块，如果没有finally 块，程序立即执行return 或throw 语旬， 方法终止;
             * 如果有finally 块， 系统立即开始执行finally 块。 只有当finally 块执行完成后， 系统才会再次跳回来执行try块、catch 块里的return 或throw语句;
             * 如果finally 块里也使用了return 或throw 等导致方法终止的语句， finally 块己经终止了方法，系统将不会跳回去执行try块、catch 块里的任何代码。
             *
             * 尽量避免在finally 块里使用return 或throw 等导致方法终止的语句， 否则可能出现一些很奇怪的情况。
             */
        }
    }

    public static boolean test() {
        try {
            // 因为finally 块中包含了return 语句, 所以下面的return 语句失去作用
            return true;
        }finally {
            return false;
        }
    }
}
