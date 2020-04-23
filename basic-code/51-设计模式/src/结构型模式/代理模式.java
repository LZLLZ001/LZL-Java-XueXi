/*

代理模式(Proxy)：
    为一个对象提供一个替身，以控制对这个对象的访问。 即通过代理对象访问目标对象，
    可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能。

    被代理的对象可以是远程对象、 创建开销大的对象或需要安全控制的对象

    代理模式有三种：静态代理、 动态代理(JDK代理、接口代理)和
                Cglib代理 (可以在内存动态的创建对象，而不需要实现接口，他是属于动态代理的范畴) 。



静态代理：
    静态代理在使用时,需要定义接口或者父类,被代理对象(即目标对象)与代理对象一起实现相同的接口或者是继承相同父类。
    实现：
        1) 定义一个接口:ITeacherDao
        2) 目标对象TeacherDAO实现接口ITeacherDAO
        3) 使用静态代理方式,就需要在代理对象TeacherDAOProxy中也实现ITeacherDAO
        4) 调用的时候通过调用代理对象的方法来调用目标对象.
        5) 特别提醒：代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法。

    优缺点：
        1) 优点：在不修改目标对象的功能前提下, 能通过代理对象对目标功能扩展
        2) 缺点：因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类
        3) 一旦接口增加方法,目标对象与代理对象都要维护


JDK动态代理：
    1) 代理对象不需要实现接口，但是目标对象要实现接口。
    2) 代理对象的生成是利用JDK的API，利用反射机制动态的在内存中构建代理对象
    3) 动态代理也叫做： JDK代理、 接口代理

    JDK中生成代理对象的API
        1) 代理类所在包:java.lang.reflect.Proxy
        2) JDK实现代理只需要使用newProxyInstance方法:
             static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
                 1. ClassLoader loader ： 指定当前目标对象使用的类加载器, 获取加载器的方法固定
                 2. Class<?>[] interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
                 3. InvocationHandler h : 事情处理，执行目标对象的方法时，会触发事情处理器方法, 会把当前执行的目标对象方法作为参数传入

        public class ProxyFactory {
            private Object target;  //维护一个目标对象 , Object
            public ProxyFactory(Object target) {    //构造器 ， 对target 进行初始化
                this.target = target;
            }
            public Object getProxyInstance() {  //给目标对象 生成一个代理对象
                return Proxy.newProxyInstance(
                        target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(),
                        new InvocationHandler() {
                                @Override
                                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                        JDK增强代理开始代码
                                        Object returnVal = method.invoke(target, args); //反射机制调用目标对象的方法
                                        JDK增强代理结束代码
                                        return returnVal;
                                }
                        });
             }
        }


    Client中的使用：
		ITargetDao target = new TargetDao();    //创建目标对象
		ITargetDao proxyInstance = (ITargetDao)new ProxyFactory(target).getProxyInstance();//给目标对象，创建代理对象
        proxyInstance.targefun();   //通过代理对象，调用目标对象的方法



Cglib动态代理(子类代理)：
    静态代理和JDK代理模式都要求目标对象是实现一个接口。当目标对象只是一个单独的对象,并没有实现任何的接口时，
    可使用目标对象子类来实现代理-Cglib代理。它是在内存中构建一个子类对象从而实现对目标对象功能扩展.

    在AOP编程中如何选择代理模式：
        1. 目标对象需要实现接口， 用JDK代理
        2. 目标对象不需要实现接口， 用Cglib代理

    Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛的被许多AOP的框架使用,
    Cglib包的底层是通过使用字节码处理框架ASM来转换字节码并生成新的类.

    实现：
        1) 需要引入cglib的jar文件
        2) 在内存中动态构建子类，代理的类不能为final，
        3) 目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法

        public class ProxyFactory implements MethodInterceptor {
            private Object target; //维护一个目标对象
            public ProxyFactory(Object target) { //构造器，传入一个被代理的对象
                this.target = target;
            }
            public Object getProxyInstance() {  //返回一个target的代理对象
                Enhancer enhancer = new Enhancer();  //1. 创建一个工具类
                enhancer.setSuperclass(target.getClass());  //2. 设置父类
                enhancer.setCallback(this);  //3. 设置回调函数
                return enhancer.create();   //4. 创建子类对象，即代理对象
            }
            //重写  intercept 方法，会调用目标对象的方法
            @Override
            public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
                Cglib代理开始逻辑
                Object returnVal = method.invoke(target, args);
                Cglib代理结束逻辑
                return returnVal;
            }
        }

    Client中的使用：
        TargetDao target = new TargetDao();    //创建目标对象
		TargetDao proxyInstance = (TargetDao)new ProxyFactory(target).getProxyInstance();//获取到代理对象，并且将目标对象传递给代理对象
        proxyInstance.targefun();   //执行代理对象的方法，触发intecept 方法，从而实现 对目标对象的调用





*/







package 结构型模式;

public class 代理模式 {
}
