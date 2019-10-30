package objectone;

/**
 * 重点
 * 方法重载
 * Java 允许同一个类里定义多个同名方法，只要形参列表不同就行。
 * 如果同一个类中包含了两个或两个以上方法的方法名相同，但形参列表不同，则被称为方法重载。
 * ------------------------------------------------------------------------------------
 * 在Java 程序中确定一个方法需要三个要素。
 * 1.调用者，也就是方法的所属者，既可以是类，也可以是对象。
 * 2.方法名，方法的标识。
 * 3.形参列表，当调用方法时，系统将会根据传入的实参列表匹配。
 * ------------------------------------------------------------------------------------
 * 方法重载的要求就是两同一不同:同一个类中方法名相同，参数列表不同。
 * 至于方法的其他部分，如方法返回值类型、修饰符等，与方法重载没有任何关系。
 * @author JIE
 */
public class FunctionOverload {

    public void overload() {
        System.out.println("无参数");
    }

    public void overload(String str) {
        System.out.println("重载的overload方法：str="+str);
    }

    public void overload(int i) {
        System.out.println("重载的overload方法：i="+i);
    }

    public void overload(String str, int i) {
        System.out.println("重载的overload方法：str="+str+", i="+i);
    }

    public void overload(int i, String str) {
        System.out.println("重载的overload方法：i="+i+", str="+str);
    }

    public static void main(String[] args) {
        FunctionOverload functionOverload = new FunctionOverload();
        // 调用overload()时没有传入参数，因此系统调用上面没有参数的overload() 方法
        functionOverload.overload();
        // 调用Overload()时传入了一个字符串参数，因此系统调用上面带一个字符串参数的overload(String str)方法
        functionOverload.overload("String");
        // 调用Overload()时传入了一个int参数，因此系统调用上面带一个int参数的overload(int i)方法
        functionOverload.overload(0);
        /**如果被重载的方法里包含了个数可变的形参,则需按照顺序传入对应类型的参数*/
        // 调用Overload()时先传入了一个字符串参数再传入一个int参数，因此系统调用上面的overload(String str, int i)方法
        functionOverload.overload("String", 0);
        // 调用Overload()时先传入了一个int参数再传入一个字符串参数，因此系统调用上面的overload(int i, String str)方法
        functionOverload.overload(0, "String");
    }
}
