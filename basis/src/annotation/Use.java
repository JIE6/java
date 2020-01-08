package annotation;

/**
 * 使用注解
 * 在默认情况下，注解可用于修饰任何程序元素，包括类、接口、方法等，如下程序使用@Test 来修饰方法。
 *
 * 一旦在注解里定义了成员变量之后，使用该注解时就应该为它的成员变量指定值，如下代码所示。
 * @author JIE
 */

@Test(name = "Use-class", age = 6)
public class Use {

    @Test(name = "Use-info-function", age = 9)
    public void info(String name) {
        System.out.println("info---name="+name);
    }


    @Test(name = "Use-staticInfo-function", age = 8)
    public static void staticInfo(String name) {
        System.out.println("staticInfo---name="+name);
    }



    @Test(name = "Use-infos-function", age = 8)
    @Test(name = "Use-infos-function", age = 9)
    public void infos(String name) {
        System.out.println("info---name="+name);
    }


    @Tests(value = {
            @Test(name = "Use-staticInfos-function", age = 8),
            @Test(name = "Use-staticInfos-function", age = 9)
    })
    public static void staticInfos(String name) {
        System.out.println("staticInfo---name="+name);
    }
}
