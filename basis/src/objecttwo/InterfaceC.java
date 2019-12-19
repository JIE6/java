package objecttwo;

/**
 * interface关键字
 * 接口的继承和类继承不一样，接口完全支持多继承，即一个接口可以有多个直接父接口。
 * 和类继承相似，子接口扩展某个父接口，将会获得父接口里定义的所有抽象方法、常量。
 *
 * 一个接口继承多个父接口时，多个父接口排在extends 关键宇之后，多个父接口之间以英文逗号( ，)隔开
 * @author JIE
 */

public interface InterfaceC extends InterfaceA, InterfaceB {

    int PROP_C = 6;
    
    void testC();
}
