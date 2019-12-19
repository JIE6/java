package objecttwo;

/**
 * 简单工厂模式
 *
 * 有一个场景: 假设程序中有个Computer 类需要组合一个输出设备，现在有两个选择:
 * 直接让Computer 类组合一个Printer
 * 或者让Computer 类组合一个Output
 * 那么到底采用哪种方式更好呢?
 *
 * 假设让Computer 类组合一个Printer 对象，如果有一天系统需要重构，需要使用BetterPrinter 来代替Printer ， 这就需要打开Computer 类源代码进行修改
 * 如果系统中只有一个Computer 类组合了Printer还好，但如果系统中有100 个类组合了Printer ，甚至1000 个、10000 个……
 * 将意味着需要打开100 个、1000个类进行修改，这是多么大的工作量啊!
 *
 * 为了避免这个问题，工厂模式建议让Computer 类组合一个Output 类型的对象将Computer 类与Printer 类完全分离。
 * Computer 对象实际组合的是Printer 对象还是BetterPrinter 对象, 对Computer 而言完全透明。
 * 当Printer 对象切换到BetterPrinter 对象时，系统完全不受影响
 *
 * 下面是这个Computer 类的定义代码
 * @author JIE
 */
public class Computer {

    private Output output;

    public Computer(Output output) {
        this.output = output;
    }

    /**
     * 定义一个模拟获取字符串输入的方法
     * @param message
     */
    public void keyIn(String message) {
        output.getData(message);
    }

    /**
     * 定义一个模拟打印的方法
     */
    public void print() {
        output.out();
    }
}
