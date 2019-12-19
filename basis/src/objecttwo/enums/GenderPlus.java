package objecttwo.enums;

/**
 * 枚举类的成员变量、方法和构造器
 * @author JIE
 */
public enum  GenderPlus {
    MALE, FEMALE;

    private String name;
    public void setName(String name) {
        switch (this) {
            case MALE:
                if ("男".equals(MALE)) {
                    this.name = name;
                }else {
                    System.out.println("参数错误");
                    return;
                }
                break;
            case FEMALE:
                if ("女".equals(FEMALE)) {
                    this.name = name;
                }else {
                    System.out.println("参数错误");
                    return;
                }
                break;
        }
    }

    public String getName() {
        return this.name;
    }

    /**
     * 上面程序把name 设置成private ，从而避免其他程序直接访问该name 成员变量，必须通过setName()方法来修改Gender 实例的name 变量，\
     * 而setName()方法就可以保证不会产生混乱。
     *
     * 实际上这种做法依然不够好，枚举类通常应该设计成不可变类，也就是说，它的成员变量值不应该允许改变，这样会更安全，
     * 而且代码更加简洁。因此建议将枚举类的成员变量都使用private final 修饰。
     *
     * 如果将所有的成员变量都使用了final 修饰符来修饰， 所以必须在构造器里为这些成员变量指定初始值
     * (或者在定义成员变量时指定默认值，或者在初始化块中指定初始值，但这两种情况并不常见)
     * 因此应该为枚举类显式定义带参数的构造器。
     *
     * 一旦为枚举类显式定义了带参数的构造器，列出枚举值时就必须对应地传入参数。参照GenderPro
     */
}
