package library;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Java 7 的ThreadLocalRandom 与Random
 * Random 类专门用于生成一个伪随机数，它有两个构造器: 一个构造器使用默认的种子(以当前时间作为种子) ，
 * 另一个构造器需要程序员显式传入一个long 型整数的种子。
 *
 * ThreadLocalRandom 类是Java 7 新增的一个类，它是Random 的增强版。在并发访问的环境下，
 * 使用ThreadLocalRandom 来代替Random 可以减少多线程资源竞争，最终保证系统具有更好的线程安全性。
 *
 * ThreadLocalRandom 类的用法与Random 类的用法基本相似，它提供了一个静态的current()方法来获取ThreadLocalRandom 对象，
 * 获取该对象之后即可调用各种nextXxxO方法来获取伪随机数了。
 *
 * ThreadLocalRandom 与Random 都比Math 的random()方法提供了更多的方式来生成各种伪随机数，可以生成浮点类型的伪随机数，也可以生成整数类型的伪随机数，
 * 还可以指定生成随机数的范围。
 * @author JIE
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("random.nextBoolean()" + ": " + random.nextBoolean());
        byte[] buffer = new byte[16];
        random.nextBytes(buffer);
        System.out.println(Arrays.toString(buffer));
        // 生成0.0 - 1.0 之间的伪随机double 数
        System.out.println("random.nextDouble()" + ": " + random.nextDouble());
        // 生成0.0 - 1.0 之间的伪随机float 数
        System.out.println("random.nextFloat()" + ": " + random.nextFloat());
        // 生成一个处于int 整数取值范围的伪随机整数
        System.out.println("random.nextInt()" + ": " + random.nextInt());
        // 生成0 -26 之间的伪随机整数
        System.out.println("random.nextInt(26)" + ": " + random.nextInt(26));

        /**
         * 从上面程序中可以看出， Random 可以提供很多选项来生成伪随机数。
         * Random 使用一个48 位的种子，如果这个类的两个实例是用同一个种子创建的，对它们以同样的顺序调用方法，则它们会产生相同的数字序列。
         *
         * 两个Random 对象种子相同时，它们会产生相同的数字序列。值得指出的， 当使用默认的种子构造Random 对象时，它们属于同一个种子。
         */
        Random r1 = new Random(50);
        System.out.println("第一个种子为50 的Random 对象");
        System.out.println(r1.nextInt());
        System.out.println(r1.nextDouble());
        System.out.println(r1.nextFloat());
        System.out.println(r1.nextBoolean());
        Random r2 = new Random(50);
        System.out.println("第二个种子为50 的Random 对象");
        System.out.println(r2.nextInt());
        System.out.println(r2.nextDouble());
        System.out.println(r2.nextFloat());
        System.out.println(r2.nextBoolean());
        Random r3 = new Random(100);
        System.out.println("第三个种子为50 的Random 对象");
        System.out.println(r3.nextInt());
        System.out.println(r3.nextDouble());
        System.out.println(r3.nextFloat());
        System.out.println(r3.nextBoolean());

        /**
         * 从上面运行结果来看，只要两个Random 对象的种子相同，而且方法的调用顺序也相同，它们就会
         * 产生相同的数字序列。也就是说， Random 产生的数字并不是真正随机的，而是一种伪随机。
         *
         * 为了避免两个Random 对象产生相同的数字序列，通常推荐使用当前时间作为Random 对象的种子，
         * 如下代码所示。
         */
        Random r4 = new Random(System.currentTimeMillis());

        /**
         * 在多线程环境下使用ThreadLocalRandom 的方式与使用Random 基本类似，如下程序片段示范了
         * ThreadLocalRandom 的用法。
         */
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        // 生成一个4 - 20 之间的伪随机整数
        System.out.println(rand.nextInt(4, 20));
        // 生成一个2.0 - 10.0 之间的伪随机浮点数
        System.out.println(rand.nextDouble(2, 10));
        System.out.println(rand.doubles(2, 10));
    }
}
