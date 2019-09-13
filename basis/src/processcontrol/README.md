# 流程控制与数组
<pre>
不论哪一种编程语言，都会提供两种基本的流程控制结构:分支结构和循环结构。其中分支结构用
于实现根据条件来选择性地执行某段代码，循环结构则用于实现根据循环条件重复执行某段代码。Java
同样提供了这两种流程控制结构的语法， Java 提供了if 和switch 两种分支语旬，并提供了while 、do while
和for 三种循环语句。除此之外， JDK5 还提供了一种新的循环: foreach 循环，能以更简单的方式来遍
历集合、数组的元素。Java 还提供了break 和continue 来控制程序的循环结构。
数组也是大部分编程语言都支持的数据结构， Java 也不例外。Java 的数组类型是一种引用类型的
变量， Java 程序通过数组引用变量来操作数组，包括获得数组的长度，访问数组元素的值等。本章将会
详细介绍Java 数组的相关知识，包括如何定义、初始化数组等基础知识，并会深入介绍数组在内存中
的运行机制。

任何编程语言中最常见的程序结构就是顺序结构。顺序结构就是程序从上到下逐行地执行，中间没
有任何判断和跳转。
如果main 方法的多行代码之间没有任何流程控制，则程序总是从上向下依次执行，排在前面的代
码先执行，排在后面的代码后执行。这意味着:如果没有流程控制， Java 方法里的语句是一个顺序执行
流，从上向下依次执行每条语句。
</pre>

## 当前包下需重点掌握的类
| 类名 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| IfProcess | 5 | if结构 |
| SwitchProcess | 5 | switch结构 |
| WhileProcess | 5 | while结构 |
| DoWhileProcess | 5 | doWhile结构 |
| ForProcess | 5 | for结构及break，continue，return的用法 |
| ArrayTypeIntroduction | 5 | 数组类型-介绍 |
| ArrayType | 5 | 数组类型-使用，foreach循环-介绍与使用 |
| ArrayTypeGrasp | 5 | 数组类型-深入掌握，栈堆内存介绍， |
| ArrayTypeNoMultidimensional | 5 | 数组类型-java没有多维数组，没有多维数组，没有多维数组 |
| ArrayTypeArrays | 5 | 数组类型-Java工具类：Arrays |
| ArrayType8Arrays | 5 | 数组类型-Java8增强的工具类：Arrays |
| Board | 2 | 练习-通过数组画一个简单的棋盘并能实现下棋 |
| Practice | 2 | 练习-使用循环输出九九乘法表,使用循环输出等腰图形 |
