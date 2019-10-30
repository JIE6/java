package objectone;

/**
 * 隐藏和封装
 * @author JIE
 */
public class PersonEncapsulation {

    /**
     * 使用private 修饰成员变量，将这些成员变量隐藏起来
     */
    private String name;
    private int age;

    /**
     * 提供set方法来操作name 成员变量
     */
    public void setName(String name) {
        // 此处可执行合理性校验，要求用户名必须在2 才位之间等等......
        this.name = name;
    }

    /**
     * 提供get方法来获取name 成员变量
     * @return
     */
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (age >= 1000) {
            System.out.println("年龄不合法");
            return;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
