/*
装饰者模式：
    动态的将新功能附加到对象上。(就像层层打包一个快递)
    在对象功能扩展方面，它比继承更有弹性，装饰者模式也体现了开闭原则(ocp)

    方法：装饰者类 继承 并且 组合 被装饰者抽象类。
         这样不管是什么形式的装饰者+被装饰者组合，都可通过递归方式可以方便的组合和维护。

    Component：被装饰者
    ConcreteComponent：实际被装饰者
    Decorator: 装饰者
    ConcreteDecorator：实际装饰者


Java的IO结构， FilterInputStream就是一个装饰者







*/



package 结构型模式;

public class 装饰者模式 {
}
