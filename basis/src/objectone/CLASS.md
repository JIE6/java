# 定义类
<pre>
  面向对象的程序设计过程中有两个重要概念:类( class) 和对象( object ，也被称为实例， instance) ,
其中类是某一批对象的抽象，可以把类理解成某种概念:对象才是一个具体存在的实体，从这个意义上
来看，日常所说的人，其实都是人的实例，而不是人类。

  Java 语言是面向对象的程序设计语言，类和对象是面向对象的核心。Java 语言提供了对创建类和
创建对象简单的语法支持。
</pre>

## 类的定义
<pre>
[修饰符] class 类名 {
    零个到多个构造器定义. . .
    零个到多个成员变量. . .
    零个到多个方法. . .
}

  在上面的语法格式中，修饰符可以是public 、final 、abstract ，或者完全省略这三个修饰符，类名只
要是一个合法的标识符即可，但这仅仅满足的是Java 的语法要求:如果从程序的可读性方面来看， Java
类名必须是由一个或多个有意义的单词连缀而成的，每个单词首字母大写，其他字母全部小写，单词与
单词之间不要使用任何分隔符。

  对一个类定义而言，可以包含三种最常见的成员:构造器、成员变量和方法， 三种成员都可以定义
零个或多个，如果三种成员都只定义零个，就是定义了一个空类，这没有太大的实际意义。

  类里各成员之间的定义顺序没有任何影响，各成员之间可以相互调用，但需要指出的是， static 修
饰的成员不能访问没有static 修饰的成员。

  成员变量用于定义该类或该类的实例所包含的状态数据，方法则用于定义该类或该类的实例的行为
特征或者功能实现。构造器用于构造该类的实例， Java 语言通过new 关键字来调用构造器，从而返回
该类的实例。

  构造器是一个类创建对象的根本途径，如果一个类没有构造器，这个类通常无法创建实例。因此，
Java 语言提供了一个功能: 如果程序员没有为一个类编写构造器，则系统会为该类提供一个默认的构造
器。一旦程序员为一个类提供了构造器，系统将不再为该类提供构造器。
</pre>

### 成员变量的定义
<pre>
[修饰符] 类型 成员变量名 [=默认值];
    
  对定义成员变量语法格式的详细说明如下:
  
  修饰符:修饰符可以省略，也可以是public 、protected 、private 、static 、final，其中public 、protected 、
private 三个最多只能出现其中之一， 可以与static 、final 组合起来修饰成员变量。

  类型: 类型可以是Java 语言允许的任何数据类型，包括基本类型和引用类型。
 
  成员变量名:成员变量名只要是一个合法的标识符即可，但这只是从语法角度来说的;如果从
程序可读性角度来看，成员变量名应该由一个或多个有意义的单词连缀而成。

  默认值:定义成员变量还可以指定一个可选的默认值。
</pre>

### 方法的定义
<pre>
[修饰符] 方法返回值类型 方法名 (形参列表) {
    零条到多条可执行性语句组成的方法体. . .
}

  对定义方法语法格式的详细说明如下:
  
  修饰符:修饰符可以省略，也可以是public 、protected、private 、static 、final 、abstract ，其中public 、
protected 、private 三个最多只能出现其中之一; final 和abstract 最多只能出现其中之一，它们可
以与static 组合起来修饰方法。

  方法返回值类型:返回值类型可以是Java 语言允许的任何数据类型，包括基本类型和引用类型:
如果声明了方法返回值类型，则方法体内必须有一个有效的return 语句，该语句返回一个变量
或一个表达式，这个变量或者表达式的类型必须与此处声明的类型匹配。除此之外， 如果一个
方法没有返回值，则必须使用void 来声明没有返回值。

  方法名:方法名的命名规则与成员变量的命名规则基本相同，但由于方法用于描述该类或该类
的实例的行为特征或功能实现，因此通常建议方法名以英文动词开头。

  形参列表:形参列表用于定义该方法可以接受的参数，形参列表由零组到多组"参数类型 形参名"
组合而成， 多组参数之间以英文逗号(,)隔开，形参类型和形参名之间以英文空格隔开。
一旦在定义方法时指定了形参列表，则调用该方法时必须传入对应的参数值。谁调用方法，谁负责为形参赋值。

  static 是一个特殊的关键字，它可用于修饰方法、成员变量等成员。static 修饰的成员表明它属于这
个类本身，而不属于该类的单个实例，因为通常把static 修饰的成员变量和方法也称为类变量、类方法。
不使用static 修饰的普通方法、成员变量则属于该类的单个实例，而不属于该类。因为通常把不使用static
修饰的成员变量和方法也称为实例变量、实例方法

  由于static 的英文直译就是静态的意思，因此有时也把static 修饰的成员变量和方法称为静态变量
和静态方法，把不使用static 修饰的成员变量和方法称为非静态变量和非静态方法。静态成员不能直接
访问非静态成员。
</pre>

### 构造器的定义
<pre>
[修饰符] 构造器名 (形参列表) {
    零条到多条可执行性语句组成的构造器执行体
}

  对定义构造器语法格式的详细说明如下:
  
  修饰符:修饰符可以省略，也可以是public 、protected 、private 其中之一。
  
  构造器名:构造器名必须和类名相同。
  
  形参列表:和定义方法形参列表的格式完全相同。
  
  构造器既不能定义返回值类型，也不能使用void 声明构造器没有返回值。如果为
构造器定义了返回值类型，或使用void 声明构造器没有返回值，编译时不会出错，但Java 会把这个所
谓的构造器当成方法来处理。它就不再是构造器。

  构造器没有返回值，但为什么不能用void声明？
这是java语法的规定，实际是类的构造器是有返回值得，当使用new关键字来调用构造器时，构造器返回该类的实例，
可以把这个类的实例当做是构造器的返回值，因此构造器的返回值类型总是当前类，无需定义返回值类型。但必须注意的是：
不要在构造器里显式的使用return来返回当前类的对象，因为构造器的返回值是隐式的。
</pre>