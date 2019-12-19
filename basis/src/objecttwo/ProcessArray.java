package objecttwo;

/**
 * 命令模式
 * Command 接口里定义了一个process方法， 这个方法用于封装"处理行为"，但这个方法没有方法体
 * 下面是需要处理数组的处理类，在这个处理类中包含一个process方法,这个方法无法确定处理数组的处理行为
 * 所以定义该方法时使用了一个Command 参数，这个Command 参数负责对数组的处理行为
 * @author JIE
 */
public class ProcessArray {

    public void process(int[] target , Command cmd) {
        cmd.process(target);
    }
}
