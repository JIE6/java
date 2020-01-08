# 注解

<pre>
    从JDK5 开始， Java 增加了对元数据( MetaData) 的支持，也就是Annotation ( 即注解，也被翻译
为注释) ，注解其实是代码里的特殊标记，这些标记可以在编译、类加载、运行时被读取， 并执行相应的处理。
通过使用注解，程序开发人员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充的信息。代码分析工具、
开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
    注解提供了一种为程序元素设置元数据的方法，从某些方面来看， 注解就像修饰符一样，可用于修饰包、
类、构造器、方法、成员变量、参数、局部变量的声明，这些信息被存储在注解的"name=value"对中。
    注解是一个接口，程序可以通过反射来获取指定程序元素的java.lang.annotation。Annotation 对象，
然后通过java.lang.annotation.Annotation 对象来取得注解里的元数据。
    注解能被用来为程序元素(类、方法、成员变量等)设置元数据。值得指出的是，注解不影响程序代码的执行，
无论增加、删除注解，代码都始终如一地执行。如果希望让程序中的注解在运行时起一定的作用，只有通过某种配套的
工具对注解中的信息进行访问和处理，访问和处理注解的工具统称APT( Annotation Processing Tool ) 。
    注解必须使用工具来处理，工具负责提取注解里包含的元数据， 工具还会根据这些元数据增加额外的功能。在系统
学习新的注解语法之前，先看一下Java 提供的5 个基本注解的用法, 使用注解时要在其前面增加@符号， 并把该注解
当成一个修饰符使用， 用于修饰它支持的程序元素。
</pre>

## 当前包下需重点掌握的类
| 类名 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| Test | 5 | 自定义注解 |
| Use | 5 | 使用注解 |
| Extract | 5 | 提取注解信息通过Class.forName反射调用方法 |
| OutPut,Persistent,Id,Property,Person | 5 | 编译时处理注解 |


### 5个基本的注解
<pre>
    5 个基本的注解如下:
    @Override
    @Deprecated
    @SuppressWarnings
    @SafeVarargs
    @FunctionalInterface
    上面5 个基本注解中的@SafeVarargs 是Java 7 新增的、@FunctionalInterface 是Java 8 新增的。这5
个基本的注解都定义在java.lang 包下.可以通过查阅它们的API 文档来了解关于它们的更多细节。
    @Override：限定重写父类方法: @Override：@Override 就是用来指定方法覆载的，它可以强制一个子类必须覆盖父类的方法。
    @Deprecated：Java 9 增强的@Deprecated：@Deprecated 用于表示某个程序元素(类、方法等)己过时，当其他程序使用己过时的类、方法时，
编译器将会给出警告。Java 9 为@Deprecated 注解增加了如下两个属性。
    forRemoval: 该boolean 类型的属性指定该API 在将来是否会被删除。
    since: 该String 类型的属性指定该API 从哪个版本被标记为过时。
    @SuppressWarnings：抑制编译器警告。@SuppressWarnings 指示被该注解修饰的程序元素(以及该程序元素中的所有子元素)取消显示指定的编译器警告。
定的编译器警告。@SuppressWarnings 会一直作用于该程序元素的所有子元素，例如，使用@SuppressWarnings 修饰某个类取消显示某个编译器警告，
同时又修饰该类里的某个方法取消显示另一个编译器警告，那么该方法将会同时取消显示这两个编译器警告。
    在通常情况下，如果程序中使用没有泛型限制的集合将会引起编译器警告，为了避免这种编译器警告，可以使用@SuppressWamings 修饰。
    @SafeVarargs："堆污染"警告与Java 9 增强的@SafeVarargs
    @FunctionalInterface：Java 8 的函数式接口与@FunctionalInterface。前面己经提到， Java 8 规定: 如果接口中只有一个抽象方法
(可以包含多个默认方法或多个static方法)，该接口就是函数式接口。@FunctionalInterface就是用来指定某个接口必须是函数式接口。
</pre>

### JDK 的元注解
<pre>
    JDK 除在java.lang 下提供了5 个基本的注解之外，还在java.lang.annotation 包下提供了6 个Meta 注解(元注解)，其中有5 个元注解都用于修饰其他的注解定义。
其中@Repeatable 专门用于定义Java 8新增的重复注解，后面会重点介绍相关内容。此处先介绍常用的4 个元注解。

    使用@Retention
    @Retention 只能用于修饰注解定义，用于指定被修饰的注解可以保留多长时间， @Retention 包含一个RetentionPolicy 类型的value 成员变量，所以使用@Retention 
时必须为该value 成员变量指定值。value 成员变量的值只能是如下三个。    
    RetentionPolicy.CLASS: 编译器将把注解记录在class 文件中。当运行Java 程序时， JVM 不可获取注解信息。这是默认值。
    RetentionPolicy.RUNTIME: 编译器将把注解记录在class 文件中。当运行Java 程序时， JVM 也可获取注解信息， 程序可以通过反射获取该注解信息。
    RetentionPolicy.SOURCE: 注解只保留在源代码中，编译器直接丢弃这种注解。
    如果需要通过反射获取注解信息，就需要使用value 属性值为RetentionPolicy.RUNTIME 的@Retention 。使用@Retention 元注解可采用如下代码为value 指定值。
    //定义下面的@Testable 注解保留到运行时
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface Testable{ }
    也可采用如下代码来为value 指定值。
    / 定义下面的@Testable 注解将被编译器直接丢弃
    自Retention(RetentionPolicy.SOURCE)
    public @interface Testable{ }
    上面代码中使用@Retention 元注解时，并未通过value=RetentionPolicy.SOURCE 的方式来为该成员变量指定值，这是因为当注解的成员变量名为value 时， 
程序中可以直接在注解后的括号里指定该成员变量的值，无须使用name=value 的形式。

    使用@Target
    @Target 也只能修饰注解定义，它用于指定被修饰的注解能用于修饰哪些程序单元。@Target 元注解也包含一个名为value 的成员变量，该成员变量的值只能是如下几个。
    ElementType.ANNOTATION_TYPE: 指定该策略的注解只能修饰注解。
    ElementType.CONSTRUCTOR: 指定该策略的注解只能修饰构造器。
    ElementType.FIELD: 指定该策略的注解只能修饰成员变量。
    ElementType.LOCAL_VARIABLE: 指定该策略的注解只能修饰局部变量。
    ElementType.METHOD: 指定该策略的注解只能修饰方法定义。
    ElementType.PACKAGE: 指定该策略的注解只能修饰包定义。
    ElementType.PARAMETER: 指定该策略的注解可以修饰参数。(Java 8 新增)
    ElementType.TYPE: 指定该策略的注解可以修饰类、接口(包括注解类型)或枚举定义。
    ElementType.TYPE_USE: 这种注解被称为类型注解( Type Annotation ) ，类型注解可用于修饰在任何地方出现的类型。(Java 8 新增)
    
    使用@Documented
    @Documented 用于指定被该元注解修饰的注解类将被javadoc 工具提取成文档，如果定义注解类时使用了@Documented 修饰，则所有使用该注解修饰的程序元素的API 
文档中将会包含该注解说明。

    使用@Inherited
    @Inherited 元注解指定被它修饰的注解将具有继承性一一如果某个类使用了@Xxx 注解(定义该注解时使用了@Inherited 修饰)修饰，则其子类将自动被@Xxx 修饰。
</pre>
