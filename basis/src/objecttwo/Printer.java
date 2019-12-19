package objecttwo;

/**
 * interface关键字
 * @author JIE
 */
public class Printer implements Output, Product{

    private String[] printData = new String[MAX_CACHE_LINE] ;
    /**
     * 用以记录当前需打印的作业数
     */
    private int dataNum = 0 ;

    @Override
    public void out() {
        // 只要还有作业，就继续打印
        while (dataNum > 0) {
            System.out.println("打印机打印："+ printData[0]);
            // 把作业队列整体前移一位，并将剩下的作业数减1
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    @Override
    public void getData(String data) {
        if (dataNum >= MAX_CACHE_LINE) {
            System.out.println("输出队列己满，添加失败");
        }else {
            // 把打印数据添加到队列里，己保存数据的数量加l
            printData[dataNum++] = data;
        }
    }

    @Override
    public int getProduceTime() {
        return 45;
    }

    public static void main(String[] args) {
        // 创建一个Printer 对象，当成Output 使用
        Output output = new Printer();
        output.getData("轻量级Java EE 企业应用实战");
        output.getData("疯狂Java 讲义");
        output.out();
        output.getData("疯狂Android 讲义");
        output.getData("疯狂Ajax 讲义");
        output.getData("疯狂Android 讲义");
        output.getData("疯狂Ajax 讲义");
        output.out();

        output.print("孙悟空");
        Output.staticTest();

        // 创建一个Printer 对象，当成Product 使用
        Product p = new Printer();
        System.out.println(p.getProduceTime());
        // 所有接口类型的引用变量都可直接赋给Object 类型的变量
        Object obj = p ;
        System.out.println(obj);
    }
}
