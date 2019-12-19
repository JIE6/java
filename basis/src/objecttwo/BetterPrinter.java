package objecttwo;

/**
 * 简单工厂模式
 *
 * 在OutputFactory类中包含了一个getOutputO方法， 该方法返回一个Output 实现类的实例，该方法负责创建Output 实例
 * 具体创建哪一个实现类的对象由该方法决定, 如果系统需要将Printer 改为BetterPrinter 实现类，只需让BetterPrinter 实现Output 接口，
 * 并改变OutputFactory 类中的getOutputO方法即可。
 *
 * @author JIE
 */
public class BetterPrinter implements Output{

    private String[] printData = new String[MAX_CACHE_LINE * 2] ;
    /**
     * 用以记录当前需打印的作业数
     */
    private int dataNum = 0 ;

    @Override
    public void out() {
        // 只要还有作业，就继续打印
        while (dataNum > 0) {
            System.out.println("高速打印机打印："+ printData[0]);
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
}
