package library;

/**
 * Object 类
 *
 * Object 类是所有类、数组、枚举类的父类，也就是说， Java 允许把任何类型的对象赋给Object 类型的变量。
 * 当定义一个类时没有使用extends 关键字为它显式指定父类，则该类默认继承Object 父类。
 * 因为所有的Java 类都是Object 类的子类，所以任何Java 对象都可以调用Object 类的方法。Object类提供了如下几个常用方法。
 *
 * boolean equals(Object obj): 判断指定对象与该对象是否相等。此处相等的标准是，两个对象是同一个对象，因此该equals方法通常没有太大的实用价值。
 *
 * protected void finalize(): 当系统中没有引用变量引用到该对象时，垃圾回收器调用此方法来清理该对象的资源。
 *
 * Class<?> getClass(): 返回该对象的运行时类
 *
 * int hashCode(): 返回该对象的hashCode 值。在默认情况下， Object 类的hashCode()方法根据该对象的地址来计算(即与System.identityHashCode(Object x)方法的计算结果相同) 。
 * 但很多类都重写了Object 类的hashCode()方法，不再根据地址来计算其hashCode()方法值。
 *
 * String toString(): 返回该对象的字符串表示，当程序使用System.out.println()方法输出一个对象，或者把某个对象和字符串进行连接运算时，
 * 系统会自动调用该对象的toString()方法返回该对象的字符串表示。Object 类的toString()方法返回"运行时类名@十六进制hashCode 值"格式的字符串，
 * 但很多类都重写了Object 类的toString()方法，用于返回可以表述该对象信息的字符串。
 *
 * 除此之外， Object 类还提供了wait() 、notify() 、notifyAll()几个方法，通过这几个方法可以控制线程的暂停和运行
 *
 * Java 还提供了一个protected 修饰的clone()方法，该方法用于帮助其他对象来实现"自我克隆"，所谓"自我克隆"就是得到一个当前对象的副本，而且二者之间完全隔离。
 * 由于Object 类提供的clone()方法使用了protected 修饰，因此该方法只能被子类重写或调用。
 *
 * 自定义类实现"克隆"的步骤如下。
 * 自定义类实现Cloneable 接口。这是一个标记性的接口，实现该接口的对象可以实现"自我克隆"，接口里没有定义任何方法。
 * 自定义类实现自己的cloneO方法.
 * 实现cloneO方法时通过super.clone() ;调用Object 实现的clone()方法来得到该对象的副本，并返回该副本。如下程序示范了如何实现"自我克隆"。
 * @author JIE
 */
public class ObjectTest {

    class Address {
        String detail;

        public Address(String detail) {
            this.detail = detail;
        }
    }

    /**
     * 实现Cloneable 接口
     */
    class User implements Cloneable{
        int age;
        Address address;

        public User(int age) {
            this.age = age;
            address = new Address("杭州西湖");
        }

        /**
         * 通过调用super.clone ()来实现clone ()方法
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        public User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new ObjectTest().new User(18);
        // clone 得到user1 对象的副本
        User user2 = user1.clone();
        // 判断user1 、user2 是否相同 1
        System.out.println(user1 == user2);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        // 判断user1 、user2的address 是否相同 2
        System.out.println(user1.address == user2.address);
        System.out.println(user1.address.hashCode());
        System.out.println(user2.address.hashCode());
        /**
         * 上面程序让User 类实现了Cloneable 接口， 而且实现了cloneO方法，因此User 对象就可实现"自我克隆"
         * 克隆出来的对象只是原有对象的副本。程序在 1 代码处判断原有的User 对象与克隆出来的User 对象是否相同，程序返回false
         *
         * Object 类提供的Clone 机制只对对象里各实例变量进行"简单复制"，如果实例变量的类型是引用类型， Object 的Clone 机制
         * 也只是简单地复制这个引用变量， 这样原有对象的引用类型的实例变量与克隆对象的引用类型的实例变量依然指向内存中的同一个实例，
         * 所以上面程序在 2 代码处输出true 。
         *
         * Object 类提供的clone()方法不仅能简单地处理"复制"对象的问题，而且这种"自我克隆"机制十分高效。比如clone 一个包含100 个元素的int[]数组，
         * 用系统默认的clone 方法比静态copy 方法快近2 倍。
         *
         * 需要指出的是， Object 类的clone()方法虽然简单、易用， 但它只是一种"浅克隆", 它只克隆该对象的所有成员变量值，
         * 不会对引用类型的成员变量值所引用的对象进行克隆。如果开发者需要对对象进行"深克隆"，则需要开发者自己进行"递归"克隆，保证所有引用类型的成员变量值所引用的对象都被复制了
         */

    }
}
