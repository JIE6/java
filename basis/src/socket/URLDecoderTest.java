package socket;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 使用URLDecoder 和URLEncoder
 *
 * URLDecoder 和URLEncoder 用于完成普通字符串和application/x-www-form-urlencoded MIME 字符串之间的相互转换。
 * 可能有读者觉得后一个字符串非常专业，以为又是什么特别高深的知识，其实不是。
 *
 * 在浏览器搜索时当关键字包含中文时，这些关键字就会变成所示的"乱码"实际上这不是乱码， 这就是所谓的application/x-www-form-ur1encoded MIME 字符串
 *
 * 当URL 地址里包含非西欧宇符的字符串时，系统会将这些非西欧字符串转换成特殊字符串。编程过程中可能涉及普通字符串和这种特殊字符串的相关转换，
 * 这就需要使用URLDecoder和URLEncoder 类。
 *
 * URLDecoder 类包含一个decode(String s,String enc)静态方法， 它可以将看上去是乱码的特殊宇符串转换成普通字符串。
 * URLEncoder 类包含一个encode(String s,String enc)静态方法，它可以将普通字符串转换成application/x-www-form-ur1encoded MIME 字符串。
 *
 * 下面程序示范了如何将"乱码"转换成普通字符串，并示范了如何将普通宇符串转换成application/x-www-form-urlencoded MIME 宇符串。
 * @author JIE
 */
public class URLDecoderTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 将普通字符串转换成application/x-www-form-urlencoded 字符串
        String encode = URLEncoder.encode("疯狂123aaa", "UTF-8");
        System.out.println(encode);
        // 将application/x-www-form-urlencoded 字符串, 转换成普通字符串
        String decode = URLDecoder.decode(encode, "UTF-8");
        System.out.println(decode);
    }
    /**
     * 仅包含西欧字符的普通字符串和application/x-www-form-urlencoded MIME 字符串无须转换
     * 而包含中文字符的普通字符串则需要转换，转换方法是每个中文字符占两个字节，每个字节可以转换成两个十六进制的数字
     * 所以每个中文字符将转换成"%XX%XX"的形式
     * 当然，采用不同的字符集时，每个中文字符对应的字节数并不完全相同，所以使用URLEncoder 和URLDecoder 进行转换时也需要指定字符集。
     */
}
