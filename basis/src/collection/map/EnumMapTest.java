package collection.map;

import objecttwo.enums.SeaSonEnum;

import java.util.EnumMap;

/**
 * EnumMap 实现类
 *
 * EnumMap 是一个与枚举类一起使用的Map实现， EnumMap 中的所有key 都必须是单个枚举类的枚举值。创建EnumMap 时必须显式或隐式指定它对应的枚举类。EnumMap 具有如下特征。
 *
 * EnumMap在内部以数组形式保存，所以这种实现形式非常紧凑、高效。
 * EnumMap 根据key 的自然顺序(即枚举值在枚举类中的定义顺序〉来维护key-value 对的顺序。
 * 当程序通过keySet() 、entrySet() 、values()等方法遍历EnumMap 时可以看到这种顺序。
 * EnumMap 不允许使用null 作为key ，但允许使用null 作为value 。如果试图使用null 作为key时将抛出NullPointerException 异常。
 * 如果只是查询是否包含值为null 的key ，或只是删除值为null 的key ，都不会抛出异常。
 *
 * 与创建普通的Map 有所区别的是，创建EnumMap 时必须指定一个枚举类，从而将该EnumMap 和指定枚举类关联起来。
 *
 * @author JIE
 */
public class EnumMapTest {

    public static void main(String[] args) {
        EnumMap enumMap = new EnumMap(SeaSonEnum.class);
        enumMap.put(SeaSonEnum.SUMMER, "夏日炎炎");
        enumMap.put(SeaSonEnum.SPRING, "春暖花开");
        System.out.println(enumMap);
        /**
         * 上面程序中创建了一个EnumMap 对象，创建该EnumMap 对象时指定它的key 只能是Season 枚举类的枚举值。
         * 如果向该EnumMap 中添加两个key-value 对后，这两个key-value 对将会以Season 枚举值的自然顺序排序。
         */
    }
}
