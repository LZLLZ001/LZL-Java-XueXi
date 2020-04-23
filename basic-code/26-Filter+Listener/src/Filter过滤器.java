/*
web的三大组件：Servlet, Filter, Listener

web中的过滤器：当访问服务器的资源时，过滤器可以将请求拦截下来，完成一些特殊的功能。
	* 过滤器的作用：
		* 一般用于完成通用的操作。如：登录验证、统一编码处理、敏感字符过滤...


步骤：(实际使用时直接用快捷创建)
    1. 定义一个类，实现接口Filter
    2. 复写方法
    3. 配置拦截路径
        (1) web.xml(了解)
        (2) 注解



过滤器执行流程
    1. 执行过滤器
    2. 执行放行后的资源
    3. 回来执行过滤器放行代码下边的代码


过滤器生命周期方法
    1. init:在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
    2. doFilter:每一次请求被拦截资源时，会执行。执行多次，在这里面写拦截逻辑
    3. destroy:在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源





过滤器配置详解
    * 拦截路径配置：@WebFilter("/*")     <url-pattern>/*</url-pattern>
        1. 具体资源路径： /index.jsp   只有访问index.jsp资源时，过滤器才会被执行
        2. 拦截目录： /user/*	访问/user下的所有资源时，过滤器都会被执行(*就是通配符)
        3. 后缀名拦截： *.jsp		访问所有后缀名为jsp资源时，过滤器都会被执行
        4. 拦截所有资源：/*		访问所有资源时，过滤器都会被执行
    * 拦截方式配置：资源被访问的方式
        * 注解配置：@WebFilter(value="/*",dispatcherTypes ={ DispatcherType.FORWARD,DispatcherType.REQUEST})
                        注意：配置多个值时，value=不能省略！！
            * 设置dispatcherTypes属性
                1. REQUEST：默认值。浏览器直接请求资源
                2. FORWARD：转发访问资源
                3. INCLUDE：包含访问资源
                4. ERROR：错误跳转资源
                5. ASYNC：异步访问资源
        * web.xml配置
            * 设置<dispatcher></dispatcher>标签即可

过滤器链(配置多个过滤器)
    * 执行顺序：如果有两个过滤器：过滤器1和过滤器2
        1. 过滤器1
        2. 过滤器2
        3. 资源执行
        4. 过滤器2
        5. 过滤器1

    * 过滤器先后顺序问题：
        1. 注解配置：按照类名的字符串比较规则比较，值小的先执行
            * 如： AFilter 和 BFilter，AFilter就先执行了。
        2. web.xml配置： <filter-mapping>谁定义在上边，谁先执行


使用注意：
    要使用HttpServletRequest方法前要强转：HttpServletRequest request = (HttpServletRequest)rep
    放行代码：chain.doFilter(req, resp);
             若用到增强对象时要返回代理对象：chain.doFilter(代理对象, resp);


增强对象的功能：
    * 设计模式：一些通用的解决固定问题的方式
    1. 装饰模式
    2. 代理模式
        * 概念：
            1. 真实对象：被代理的对象
            2. 代理对象：
            3. 代理模式：代理对象代理真实对象，达到增强真实对象功能的目的
        * 实现方式：
            1. 静态代理：有一个类文件描述代理模式
            2. 动态代理：在内存中形成代理类(必须掌握理解，很多框架的底层原理都是动态代理)
                * 实现步骤：(看代码会清楚一些)
                    (1) 代理对象和真实对象实现相同的接口
                    (2) 代理对象 = Proxy.newProxyInstance();
                        三个参数：(都是固定格式)
                            类加载器：真实对象.getClass().getClassLoader()
                            接口数组：真实对象.getClass().getInterfaces()
                            处理器：new InvocationHandler(){}  //使用匿名内部类
                    (3) 重写代理逻辑方法方法invoke：代理对象调用的所有方法都会触发该方法执行
                            参数：
                                proxy:代理对象
                                method：代理对象调用的方法，被封装为的对象
                                args:代理对象调用的方法时，传递的实际参数
                        在里面使用真实对象调用该方法：method.invoke()
                    (4) 用if.else判断方法是否要增强
                    (5) 进行增强方法
                * 增强方式：
                    (1) 增强参数列表
                    (2) 增强返回值类型
                    (3) 增强方法体执行逻辑


 */



public class Filter过滤器 {
}
