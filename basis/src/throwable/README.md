# 异常

<pre>
    Java 提供了丰富的异常类，这些异常类之间有严格的继承关系。下图显示了Java 常见的异常类
之间的继承关系。
---------------------------------------------------------------------------------
                                Throwable
              ↗                                             ↖
            Error                                       Exception
           ......                                         ......
---------------------------------------------------------------------------------
    从上图可以看出，Java 把所有的非正常情况分成两种:异常(Exception ) 和错误(Error ),它们都继承
Throwable父类。
    Error 错误， 一般是指与虚拟机相关的问题，如系统崩溃、虚拟机错误、动态链接失败等，这种错误无法
恢复或不可能捕获，将导致应用程序中断。通常应用程序无法处理这些错误，因此应用程序不应该试图使用catch
块来捕获Error 对象。在定义该方法时，也无须在其throws 子句中声明该方法可能抛出Error 及其任何子类。
    异常捕获时， 一定要记住先捕获小异常， 再捕获大异常
</pre>

## 当前包下需重点掌握的知识点
| 位置 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| MultiExceptionTest | 5 | Java 7 新增的多异常捕获 |
| AccessExceptionMsg | 5 | 访问异常信息 |
| FinallyTest | 5 | 使用finally 回收资源 |
| AutoCloseTest | 5 | Java9 增强的自动关闭资源的try 语句 |
| ThrowsTest | 5 | 使用throws 声明抛出异常 |
| OverrideThrows | 5 | 方法重写时声明抛出异常的限制 |
| ThrowTest | 5 | 使用throw 抛出异常 |
| AuctionException | 5 | 自定义异常类 |
| AuctionTest | 5 | catch 和throw 同时使用 |
| NewThrowTest | 5 | Java 7 增强的throw 语句 |
| SalException | 5 | 异常链 |


## Checked 异常和Runtime 异常体系
<pre>
    Java 的异常被分为两大类: Checked 异常和 Runtime 异常(运行时异常)。 所有的 RuntimeException
类及其子类的实例被称为 Runtime 异常；不是 RuntimeException 类及其子类的异常实例则被称为Checked异常
    只有Java 语言提供了Checked 异常，其他语言都没有提供Checked 异常。Java 认为Checked 异常都是可以
被处理(修复)的异常，所以Java 程序必须显式处理Checked 异常。如果程序没有处理Checked异常，该程序在编译
时就会发生错误，无法通过编译。
    Checked 异常体现了Java 的设计哲学一一没有完善错误处理的代码根本就不会被执行!
    对于Checked 异常的处理方式有如下两种。
    1.当前方法明确知道如何处理该异常， 程序应该使用try...catch 块来捕获该异常，然后在对应的catch 块中修复该异常。
    2.当前方法不知道如何处理这种异常，应该在定义该方法时声明抛出该异常。
    Runtime 异常则更加灵活， RuntÏme 异常无须显式声明抛出，如果程序需要捕获Runtime 异常，也可以使用try...catch 块来实现.
</pre>