package objecttwo;

/**
 * 简单工厂模式
 * Computer 类己经完全与Printer 类分离，只是与Output 接口稠合。
 * Computer 不再负责创建Output 对象，系统提供一个Output 工厂来负责生成Output 对象
 * @author JIE
 */

public class OutputFactory {

    public Output getOutput() {
        //        return new Printer();
        /**
         * 因为BetterPrinter 类也实现了Output 接口，因此也可当成Output 对象使用，于是只要把返回对象改为BetterPrinter即可
         */
        return new BetterPrinter();
    }

    public static void main(String[] args) {
        OutputFactory outputFactory = new OutputFactory();
        Computer computer = new Computer(outputFactory.getOutput());
        computer.keyIn("k1");
        computer.keyIn("k2");
        computer.print();
    }
}
