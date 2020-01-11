# 面向对象-下

## 当前包下需重点掌握的知识点
| 类名/文件名 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| WrapperClass | 5 | 包装类及其用法 |
| PrintObject | 5 | 打印对象和toString方法 |
| EqualsFunction | 5 | ==和equals方法 |
| Singleton | 5 | 单例 |
| FinalCharacter | 5 | final修饰符 |
| AbstractCharacter,AbstractChild | 5 | abstract修饰符 |
| Output,InterfaceA,InterfaceB,InterfaceC,InterfaceCharacterImpl,Printer,Product | 5 | interface关键字 |
| Computer,OutputFactory,BetterPrinter | 5 | 简单工厂模式 |
| Command,ProcessArray,PrintCommand,AddCommand | 5 | 命令模式 |
| internal | 5 | 内部类 |
| lambda | 5 | Lambda 表达式 |
| enums | 5 | 枚举 |
| enums | 5 | 对象与垃圾回收 |

### 修饰符的适用范围
| 关键字 | 外部类/接口 | 成员属性 | 方法 | 构造器 | 初始化块 | 成员内部类 | 局部成员 |
|:----:|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
| public | √ | √ | √ | √ | × | √ | × |
| protected | × | √ | √ | √ | × | √ | × |
| 包访问控制符 | √ | √ | √ | √ | o | √ | o |
| private | × | √ | √ | √ | × | √ | × |
| abstract | √ | × | √ | × | × | √ | × |
| final | √ | √ | √ | × | × | √ | √ |
| static | × | √ | √ | × | √ | √ | × |
| strictfp | √ | × | √ | × | × | √ | × |
| synchronized | × | × | √ | × | × | × | × |
| native | × | × | √ | × | × | × | × |
| transient | × | √ | × | × | × | × | × |
| volatile | × | √ | × | × | × | × | × |
| default | × | × | √ | × | × | × | × |
<pre>
    strictfp 关键宇的含义是FP-strict ，也就是精确浮点的意思。在Java 虚拟机进行浮点运算时， 如果没
有指定strictfp年关键宇， Java 的编译器和运行时环境在浮点运算上不一定令人满意。一旦使用了strictfp来
修饰类、接口或者方法时，那么在所修饰的范围内Java 的编译器和运行时环境会完全依照浮点规范IEEE-754 来执
行。因此，如果想让浮点运算更加精确，就可以使用strictfp 关键字来修饰类、接口和方法。

    native 关键宇主要用于修饰一个方法，使用native 修饰的方法类似于一个抽象方法。与抽象方法不
同的是， native 方法通常采用C 语言来实现。如果某个方法需要利用平台相关特性，或者访问系统硬件等，则可以
使用native 修饰该方法，再把该方法交给C 去实现。一旦Java 程序中包含了native 方法，这个程序将失去跨平台的功能

    在上表列出的所有修饰符中， 4 个访问控制符是互斥的，最多只能出现其中之一。不仅如此， 还有abstract 和final 永远
不能同时使用; abstract 和static 不能同时修饰方法，可以同时修饰内部类; abstract和private 不能同时修饰方法，可以同时修饰内部类。
private 和final 同时修饰方法虽然语法是合法的，但没有太大的意义由于private 修饰的方法不可能被子类重写，因此使用final 修饰没什么意义
</pre>