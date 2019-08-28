package chapter.bbasictype;

/**
 * 浮点类型默认是double类型，如果希望Java 把一个浮点类型值当成float类型处理，应该在这个浮点类型值后紧跟f或F
 * float:单精度浮点数
 * @author JIE
 */
public class Float {

    public static void main(String[] args) {
        float fLowercase = 5.2345556f;
        float fUppercase = 5.2345556F;
        // 下面将看到fLowercase与fUppercase的值己经发生了改变
        System.out.println(fLowercase);
        System.out.println(fUppercase);
    }
}
