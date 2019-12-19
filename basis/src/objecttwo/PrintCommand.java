package objecttwo;

/**
 * 命令模式
 * @author JIE
 */
public class PrintCommand implements Command{

    @Override
    public void process(int[] target) {
        for (int tem : target) {
            System.out.println("送代输出目标数组的元素:" + tem);
        }
    }
}
