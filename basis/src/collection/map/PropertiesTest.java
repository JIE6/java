package collection.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 使用Properties 读写属性文件
 *
 * Properties 类是Hashtable 类的子类，正如它的名字所暗示的，该对象在处理属性文件时特别方便(Windows 操作平台上的ini 文件就是一种属性文件) Properties 类
 * 可以把Map对象和属性文件关联起来，从而可以把Map 对象中的key-value 对写入属性文件中，也可以把属性文件中的"属性名=属性值"加载到Map 对象中。由于属性文件里的属性名、
 * 属性值只能是字符串类型，所以Properties 里的key 、value 都是字符串类型。该类提供了如下三个方法来修改Properties 里的key 、value 值。
 * String getProperty(String key): 获取Properties 中指定属性名对应的属性值，类似于Map 的get(Object key)方法。
 * String getProperty(String key, String defaultValue): 该方法与前一个方法基本相似。该方法多一个功能，如果Properties 中不存在指定的key 时，则该方法指定默认值。
 * Object setProperty(String key, String value): 设置属性值，类似于Hashtable 的put()方法。
 * Properties 相当于一个key、value 都是String 类型的Map •
 * 除此之外，它还提供了两个读写属性文件的方法。
 * void load(InputStream inStream): 从属性文件(以输入流表示)中加载key-value 对，把加载到的key-value 对追加到Properties 里
 * ( Properties 是Hashtable 的子类，它不保证key-value 对之间的次序)。
 * void store(OutputStream out, String comments): 将Properties 中的key-value 对输出到指定的属性文件(以输出流表示)中。
 *
 * 上面两个方法中使用了InputStream 类和OutputStream 类，它们是Java IO 体系中的两个基类
 *
 *
 * @author JIE
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        // 向Properties 中添加属性
        props.setProperty("username", "yeeku");
        props.setProperty("password", "123456");
        System.out.println(props);
        // 将Properties 中的key-value 对保存到a.ini文件中
        props.store(new FileOutputStream("C:\\Users\\JIE\\Desktop\\a.ini"), "comment line");
        // 新建一个Properties 对象
        Properties props2 = new Properties();
        // 向Properties 中添加属性
        props2.setProperty("gender", "male");
        // 将a.ini 文件中的key-value 对追加到props2 中
        props2.load(new FileInputStream("C:\\Users\\JIE\\Desktop\\a.ini"));
        System.out.println(props2);
        props2.storeToXML(new FileOutputStream("C:\\Users\\JIE\\Desktop\\xml.ini"), "comment line");
    }
}
