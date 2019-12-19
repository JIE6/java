package objecttwo;

/**
 * 命令模式
 * 通过一个Command 接口，就实现了让ProcessArray 类和具体"处理行为"的分离，程序使用Command接口代表了对数组的处理行为
 * Command 接口也没有提供真正的处理， 只有等到需要调用ProcessArray对象的processO方法时，
 * 才真正传入一个Command 对象，才确定对数组的处理行为。
 * @author JIE
 */
public class CommandTest {

    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {3 , -4 , 6, 4};


        // 第一次处理数组， 具体处理行为取决于PrintCommand
        pa.process(target , new PrintCommand());
        System.out.println("----------------------");
        // 第二次处理数组，具体处理行为取决于AddCommand
        pa.process(target , new AddCommand());

        /**
         * 对于PrintCommand 和AddCommand 两个实现类而言，实际有意义的部分就是process(int[] target)方法，
         * 该方法的方法体就是传入ProcessArray 类里的process()方法的" 处理行为"， 通过这种方式就可实现process()方法和"处理行为"的分离。
         */
    }
}
