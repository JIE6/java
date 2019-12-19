package objecttwo;

/**
 * 命令模式
 * @author JIE
 */
public class AddCommand implements Command {

    @Override
    public void process(int[] target) {
        int sum = 0;
        for (int tmp : target ) {
            sum += tmp;
        }
        System.out.println("数组元素的总和是:" + sum);
    }
}
