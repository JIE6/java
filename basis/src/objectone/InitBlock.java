package objectone;

/**
 * 初始化块
 * 初始化块是Java 类里可出现的第4 种成员(前面依次有成员变量、方法和构造器)， 一个类里可以有多个初始化块，
 * 相同类型的初始化块之间有顺序: 前面定义的初始化块先执行，后面定义的初始化块后执行。初始化块的语法格式如下:
 * [修饰符] {
 *  // 初始化块的可执行性代码
 *  ......
 * }
 * 初始化块的修饰符只能是static， 使用static 修饰的初始化块被称为静态初始化块。初始化块里的代码可以包含任何可执行性语句，
 * 包括定义局部变量、调用其他对象的方法，以及使用分支、循环语句等。
 *
 * 从某种程度上来看，初始化块是构造器的补充，初始化块总是在构造器执行之前执行。系统同样可使用初始化块来进行对象的初始化操作。
 * 与构造器不同的是，初始化块是一段固定执行的代码，它不能接收任何参数。因此初始化块对同一个类的所有对象所进行的初始化处理完全相同。
 * 基于这个原因，不难发现初始化块的基本用法，如果有一段初始化处理代码对所有对象完全相同，且无须接收任何参数，就可以把这段初始化处理代码提取到初始化块中。
 *
 * 实际上初始化块是一个假象，使用Javac 命令编译Java 类后，该Java 类中的初始化块会消失,
 * 初始化块中代码会被"还原"到每个构造器中，且位于构造器所有代码的最前面。
 *
 * 与构造器类似，创建一个Java 对象时，不仅会执行该类的普通初始化块和构造器，而且系统会一直上溯到java.lang.Object 类，
 * 先执行java.lang.Object 类的初始化块，开始执行java.lang.Object 的构造器，依次向下执行其父类的初始化块，
 * 开始执行其父类的构造器……最后才执行该类的初始化块和构造器，返回该类的对象。
 *
 * 除此之外，如果希望类加载后对整个类进行某些初始化操作，例如当InitBlock 类加载后，则需要把InitBlock 类的b 类变量初始化为2 ，
 * 此时需要使用static 关键字来修饰初始化块，使用static 修饰的初始化块被称为静态初始化块。
 * @author JIE
 */
public class InitBlock {

    {
        // 下面定义一个初始化块
        int a = 6 ;
        if (a > 4){
            System.out.println("InitBlock 初始化块 局部变量a 的值大于4");
        }
        System.out.println("InitBlock 初始化块");
    }

    {
        // 定义第二个初始化块
        System.out.println("InitBlock 的第二个初始化块");
        b = 6;
    }
    int b = 9 ;
    /**
     * 定义无参数的构造器
     */
    public InitBlock() {
        System.out.println("InitBlock 的无参数构造器");
    }

    public static void main(String[] args) {
        /**
         * 从下面运行结果可以看出，当创建Java 对象时，系统总是先调用该类里定义的初始化块，
         * 如果一个类里定义了2 个普通初始化块，则前面定义的初始化块先执行，后面定义的初始化块后执行。
         * 初始化块虽然也是Java 类的一种成员，但它没有名字，也就没有标识，因此无法通过类、对象来调用初始化块。
         * 初始化块只在创建Java 对象时隐式执行，而且在执行构造器之前执行。
         *
         * 虽然Java 允许一个类里定义多 个普通初始化块，但这没有任何意义。因为初始化块是在创建Java 对象时隐式执行的，
         * 而且它们总是全部执行，因此完全可以把多个普通初始化块合并成一个初始化块，从而可以让程序更加简洁，可读性史强。
         */
        new InitBlock();

        /**
         * 从上面代码可以看出，初始化块和构造器的作用非常相似，它们都用于对Java 对象执行指定的初始化操作，但它们之间依然存在一些差异，下面具体分析初始化块和构造器之间的差异。
         * 普通初始化块、声明实例变量指定的默认值都可认为是对象的初始化代码，它们的执行顺序与源程序中的排列顺序相同。
         *
         * 上面程序中定义了两次对b 实例变量赋值，执行结果是b 实例变量的值为9，这表明int b = 9 这行代码比初始化块后执行。
         * 但如果将粗体字初始化块代码与int b = 9: 的顺序调换一下，将可以看到程序输出实例变量b 的值为6 ，这是由于初始化块中代码再次将b 实例变量的值设为6 。
         *
         * 当Java 创建一个对象时，系统先为该对象的所有实例变量分配内存(前提是该类已经被加载过了)，接着程序开始对这些实例变量执行初始化，其初始化顺序是
         * 先执行初始化块或声明实例变量时指定的初始值(这两个地方指定初始值的执行九许与它们在源、代码中的排列顺序相同)，再执行构造器里指定的初始值。
         */
        System.out.println(new InitBlock().b);

    }
}
