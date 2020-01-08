package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用注解修饰了类、方法、成员变量等成员之后，这些注解不会自己生效，必须由开发者提供相应的工具来提取并处理注解信息。
 * Java 使用java.lang.annotation.Annotation 接口来代表程序元素前面的注解，该接口是所有注解的父接口。
 * Java 5 在java.lang.reflect 包下新增了AnnotatedElement 接口，该接口代表程序中可以接受注解的程序元素。
 * 该接口主要有如下几个实现类。
 * Class: 类定义。
 * Constructor : 构造器定义。
 * Field: 类的成员变量定义。
 * Method: 类的方法定义。
 * Package : 类的包定义。
 *
 * java.lang.reflect 包下主要包含一些实现反射功能的工具类，从Java 5 开始， java.lang.reflect 包所提供的反射API 增加了读取运行时注解的能力。只有当定义注解时使用了
 * @Retention(RetentionPolicy.RUNTIME)修饰， 该注解才会在运行时可见， JVM 才会在装载*.class 文件时读取保存在class 文件中的注解信息。
 *
 * AnnotatedElement 接口是所有程序元素( 如Class 、Method 、Constructor 等) 的父接口， 所以程序通过反射获取了某个类的AnnotatedElement 对象( 如C lass 、Method 、Constructor 等〉之后，
 * 程序就可以调用该对象的如下几个方法来访问注解信息。
 * <A extends Annotation> A getAnnotation(Class<A> annotationClass): 返回该程序元素上存在的、指定类型的注解， 如果该类型的注解不存在，则返回null 。
 * <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass): 这是Java 8 新增的方法， 该方法尝试获取直接修饰该程序元素、指定类型的注解。如果该类型的注解不存在，
 * 则返回null 。
 * Annotation[] getAnnotations(): 返回该程序元素上存在的所有注解。
 * Annotation[] getDeclaredAnnotations(): 返回直接修饰该程序元素的所有注解。
 * boolean isAnnotationPresent(Class<? extends Annotation> annotationClass): 判断该程序元素上是否存在指定类型的注解，如果存在则返回true ， 否则返回false 。
 * <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass): 该方法的功能与前面介绍的getAnnotationO方法基本相似。但由于Java 8 增加了重复注解功能，
 * 因此需要使用该方法获取修饰该程序元素、指定类型的多个注解。
 * <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> annotationClass): 该方法的功能与前面介绍的getDeclaredAnnotationsO方法基本相似。
 * 但由于Java 8 增加了重复注解功能，因此需要使用该方法获取直接修饰该程序元素、指定类型的多个注解。
 *
 *
 *
 * @author JIE
 */
public class Extract {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("获取注解信息");
        // 获取 annotation.Use 对象的info 方法所包含的所有注解
        Annotation[] annotations = Class.forName("annotation.Use").getMethod("info", String.class).getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Test) {
                System.out.println(((Test)annotation).sex());
                System.out.println(((Test)annotation).age());
                System.out.println(((Test)annotation).name());
            }
        }

        System.out.println();
        System.out.println("通过注解做条件利用反射调用方法");

        // 遍历 annotation.Use 对应的类里的所有方法
        for (Method method : Class.forName("annotation.Use").getMethods()) {
            // 如果该方法使用了@Test 修饰
            if (method.isAnnotationPresent(Test.class)) {
                // 调用 使用了@Test 修饰的 方法
                method.invoke(new annotation.Use(), "反射-注解-调用");
            }
        }

        System.out.println();
        System.out.println("获取重复注解信息");
        for (Annotation annotation : Class.forName("annotation.Use").getMethod("infos", String.class).getAnnotations()) {
            if (annotation instanceof Tests) {
                Test[] tests = ((Tests) annotation).value();
                for (Test test : tests) {
                    System.out.println(test.sex());
                    System.out.println(test.age());
                    System.out.println(test.name());
                }
            }
        }
    }
}
