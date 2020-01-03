package throwable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Java 7 增强的throw 语句
 * @author JIE
 */
public class NewThrowTest {

    public static void main(String[] args)
            // Java 7 会检查代码处可能抛出异常的实际类型, 因此此处只需声明抛出FileNotFoundException 异常即可
            throws FileNotFoundException {
        try {
            new FileOutputStream("w://a.txt");
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
