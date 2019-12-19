package objecttwo;

/**
 * abstract修饰符
 * 利用抽象类和抽象方法的优势，可以更好地发挥多态的优势，使得程序更加灵活。
 *
 * 当使用abstract 修饰类时，表明这个类只能被继承;当使用abstract 修饰方法时， 表明这个方法必须由子类提供实现(即重写) 。
 *
 * 而final 修饰的类不能被继承，final 修饰的方法不能被重写。因此final和abstract 永远不能同时使用。
 *
 * 除此之外，当使用static 修饰一个方法时，表明这个方法属于该类本身，即通过类就可调用该方法，但如果该方法被定义成抽象方法，
 * 则将导致通过该类来调用该方法时出现错误(调用了一个没有方法体的方法肯定会引起错误)。因此static 和abstract 不能同时修饰某个方法，即没有所谓的类抽象方法。
 *
 * static 和abstract 并不是绝对王斥的， static 和abstract 虽然不能同时修饰某个方法，但它们可以同时修饰内部类。
 *
 * abstract 关键字修饰的方法必须被其子类重写才有意义，否则这个方法将永远不会有方法休，因此abstract 方法不能定义为private 访问权限，即private 和abstract 不能同时修饰方法。
 * @author JIE
 */
public class AbstractChild extends AbstractCharacter{


    public AbstractChild(String color) {
        super(color);
    }

    @Override
    public String eat() {
        return "儿子-站着吃";
    }

    public static void main(String[] args) {
        AbstractCharacter abstractCharacter = new AbstractChild("黑色");
        System.out.println(abstractCharacter.eat());
    }
}
