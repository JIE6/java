package objectone;

/**
 * 组合
 * 子类扩展父类时，子类可以从父类继承得到成员变量和方法，如果访问权限允许，子类可以直接访问父类的成员变量和方法，相当于子类可以直接复用父类的成员变量和方法，确实非常方便。
 * 继承带来了高度复用的同时，也带来了一个严重的问题:继承严重地破坏了父类的封装性。前面介绍封装时提到:每个类都应该封装它内部信息和实现细节，而只暴露必要的方法给其他类使用。
 * 但在继承关系中，子类可以直接访问父类的成员变量(内部信息)和方法，从而造成子类和父类的严重搞合。
 * 为了保证父类有良好的封装性，不会被子类随意改变，设计父类通常应该遵循如下规则。
 * 1.尽量隐藏父类的内部数据。尽量把父类的所有成员变量都设置成private 访问类型，不要让子类直接访问父类的成员变量。
 * 2.不要让子类可以随意访问、修改父类的方法。父类中那些仅为辅助其他的工具方法，应该使用private 访问控制符修饰，让子类无法访问该方法;
 * 如果父类中的方法需要被外部类调用，则必须以public 修饰，但又不希望子类重写该方法，可以使用final 修饰符(该修饰符后面会有更详细的介绍)来修饰该方法:
 * 如果希望父类的某个方法被子类重写，但不希望被其他类自由访问，则可以使用protected 来修饰该方法。
 * 3.尽量不要在父类构造器中调用将要被子类重写的方法。
 * @author JIE
 */
public class Combination {

    private Parent parent;

    public Combination(Parent parent) {
        this.parent = parent;
        System.out.println("InheritanceAndCombination(Parent parent)");
    }

    public void info() {
        parent.info();
    }

    public static void main(String[] args) {
        // 组合
        Parent parent = new Parent("aaa", "bbb");
        Combination combination = new Combination(parent);
        combination.info();
    }
}
