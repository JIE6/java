package objectone;

/**
 * 重点
 * 成员变量和局部变量
 * 根据定义变量位置的不同，可以将变量分成两大类: 成员变量和局部变量。成员变量和局部变量的运行机制存在较大差异
 * ---------------------------------------------------------------------------------------------
 * 成员变量和局部变量是什么？
 * 成员变量指的是在类里定义的变量
 * 局部变量指的是在方法里定义的变量
 * ---------------------------------------------------------------------------------------------
 * 成员变量被分为类变量和实例变量两种:
 * 定义成员变量时没有static 修饰的就是实例变量
 * 有static 修饰的就是类变量
 * ---------------------------------------------------------------------------------------------
 * 其中类变量从该类的准备阶段起开始存在， 直到系统完全销毁这个类，类变量的作用域与这个类的生存范围相同;
 * 而实例变量则从该类的实例被创建起开始存在，直到系统完全销毁这个实例，实例变量的作用域与对应实例的生存范围相同。
 * ---------------------------------------------------------------------------------------------

 * @author JIE
 */
public class MemberVarAndLocalVar {

    /**
     * 成员变量-实例变量
     */
    public String name;

    /**
     * 成员变量-类变量
     */
    public static int eyeNum;

    public static void main(String[] args) {
        /**
         * 成员变量的介绍与使用
         */
        //第一次主动使用MemberVarAndLocalVar 类， 该类自动初始化，则eyeNum 变量开始起作用，输出0
        System.out.println(MemberVarAndLocalVar.eyeNum);
        // 创建MemberVarAndLocalVar 对象
        MemberVarAndLocalVar mal = new MemberVarAndLocalVar();
        // 通过MemberVarAndLocalVar 对象的引用mal 来访问MemberVarAndLocalVar 对象name 实例变量,并通过实例访问eyeNum 类变量
        System.out.println(mal.name);
        // 不推荐（错误演示）因为通过mal 访问eyeNum 类变量，依然是访问MemberVarAndLocalVar 的eyeNum 类变量
        System.out.println(mal.eyeNum);
        // 直接为name 实例变量赋值
        mal.name = "小明";
        // 通过mal 访问eyeNum 类变量，依然是访问MemberVarAndLocalVar 的eyeNum 类变量
        mal.eyeNum = 2;
        // 再次通过mal 来访问name 实例变量和eyeNum 类变量
        System.out.println(mal.name);
        System.out.println(mal.eyeNum);

        MemberVarAndLocalVar mal2 = new MemberVarAndLocalVar();
        System.out.println("--------------mal2-----------------------");
        System.out.println(mal2.name);
        // mal2 访问的eyeNum 类变量依然引用MemberVarAndLocalVar 类的，因此依然输出2
        System.out.println(mal2.eyeNum);
        System.out.println(eyeNum);


        /**
         * 局部变量的介绍与使用
         * 局部变量根据定义形式的不同，又可以被分为如下三种。
         * 1.形参: 在定义方法签名时定义的变量， 形参的作用域在整个方法内有效。
         * 2.方法局部变量:在方法体内定义的局部变量，它的作用域是从定义该变量的地方生效，到该方法结束时失效。
         * 3.代码块局部变量: 在代码块中定义的局部变量，这个局部变量的作用域从定义该变量的地方生效，到该代码块结束时失效。
         * 与成员变量不同的是，局部变量除形参之外，都必须显式初始化。
         * 也就是说，必须先给方法局部变量和代码块局部变量指定初始值，否则不可以访问它们。
         */
        // 定义一个代码块局部变量a
        int a;
        // 下面代码将出现错误，因为a 变量还未初始化
        // System.out.println(a)
        // 为a 变量赋初始值，也就是进行初始化
        a = 5 ;
        System.out.println(a);

        // 定义一个eyeNum 实例变量
        int eyeNum = 3;
        // 直接访问eyeNum 变量，将输出eyeNum 局部变量的值: 3
        System.out.println(eyeNum);
        // 使用类名作为eyeNum 变量的限定 将输出 2
        System.out.println(MemberVarAndLocalVar.eyeNum);
        MemberVarAndLocalVar mal3 = new MemberVarAndLocalVar();
        mal3.name = "小刚";
        mal3.info();
        /**
         * 成员变量的初始化和内存中的运行机制
         * 当系统加载类或创建该类的实例时， 系统自动为成员变量分配内存空间，并在分配内存空间后， 自动为成员变量指定初始值
         */
    }

    public void info() {
        // 方法里的局部变量，局部变量覆盖成员交量
        String name = "小红";
        // 直接访问name 变量，将输出name 局部变量的值"小红"
        System.out.println(name);
        // 使用this来作为name 变量的限定,将输出name 实例变量的值:小刚
        System.out.println(this.name);
    }
}
