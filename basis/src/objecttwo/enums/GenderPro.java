package objecttwo.enums;

/**
 * 枚举类的成员变量、方法和构造器
 * @author JIE
 */
public enum  GenderPro {

    /**
     * 此处的枚举值必须调用对应的构造器来创建
     */
    MALE("男"), FEMALE("女");

    private final String name;

    /**
     * 枚举类的构造器只能使用private 修饰
     */
    private GenderPro(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 从上面程序中可以看出， 当为GenderPro 枚举类创建了一个GenderPro(String name)构造器之后，
     * 列出枚举值就应该采用MALE("男"), FEMALE("女");来完成。也就是说， 在枚举类中列出枚举值时，实际上就是调用构造器创建枚举类对象，
     * 只是这里无须使用new 关键字，也无须显式调用构造器。前面列出枚举值时无须传入参数，甚至无须使用括号，仅仅是因为前面的枚举类包含无参数的构造器。
     *
     * 不难看出，上MALE("男"), FEMALE("女")实际上等同于如下两行代码:
     * public static final Gender MALE = new Gender( "男" ) ;
     * public static final Gender FEMALE = new Gender( "女" ) ;
     */
}
