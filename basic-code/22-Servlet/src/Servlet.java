/*
Servlet：server applet
    * 概念：运行在服务器端的小程序，是javaweb的核心
	* Servlet就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
	* 将来我们自定义一个类，实现Servlet接口，复写方法。


* java动态项目的目录结构：
    -- 项目的根目录
        -- WEB-INF目录：
            -- web.xml：web项目的核心配置文件
            -- classes目录：放置字节码文件的目录
            -- lib目录：放置依赖的jar包


HttpServlet抽象类：将Servlet接口中的方法做了默认空实现，并且封装了http协议
		1. 定义类继承HttpServlet
		2. 重写doGet/doPost方法


Servlet3.0：支持注解配置Servlet
	(1)配置步骤：(实际上直接new一个Servlet，把name删掉加上/就行)
		1. 创建JavaEE项目，选择Servlet的版本3.0以上，可以不创建web.xml
		2. 定义类继承HttpServlet
		3. 重写doGet/doPost方法
		4. 在类上使用@WebServlet("/起名")注解，进行配置
		       一个Servlet可以定义多个访问路径 ： @WebServlet({"/d4","/dd4","/ddd4"})
		       可写目录结构多层路径： /xxx/xxx:
    (2) 访问方法为ip:端口号/虚拟目录/name。
            ip:端口号找到web服务器软件，虚拟目录找到项目，name找到对应的servlet实现类




Servlet中的生命周期方法：
	1. 被创建：执行init方法，只执行一次
        * 默认情况下，第一次被访问时，Servlet被创建
        * 可以配置执行Servlet的创建时机。
            * 在<servlet>标签下配置
                1. 第一次被访问时，创建
                    * <load-on-startup>的值为负数
                2. 在服务器启动时，创建
                    * <load-on-startup>的值为0或正整数
        * Servlet的init方法，只执行一次，说明一个Servlet在内存中只存在一个对象，Servlet是单例的
			* 多个用户同时访问时，可能存在线程安全问题。
			* 解决：尽量不要在Servlet中定义成员变量。即使定义了成员变量，也不要对修改值

	2. 提供服务：执行service方法，执行多次
		* 每次访问Servlet时，Service方法都会被调用一次。
	3. 被销毁：执行destroy方法，只执行一次
		* Servlet被销毁时执行。服务器关闭时，Servlet被销毁
		* 只有服务器正常关闭时，才会执行destroy方法。
		* destroy方法在Servlet被销毁之前执行，一般用于释放资源




断点调试：使用"小虫子"启动 dubug 启动


快速入门(了解)：
	1. 创建JavaEE项目(Java Enterprise)
	2. 定义一个类，实现Servlet接口
		* public class ServletDemo1 implements Servlet
	3. 实现接口中的抽象方法(使用自动生成就行)
	4. 配置Servlet
		 在web.xml中配置：
	    <!--配置Servlet -->
	    <servlet>
	        <servlet-name>demo1</servlet-name>  //任意起名
	        <servlet-class>cn.itcast.web.servlet.ServletDemo1</servlet-class>  //全类名
	    </servlet>

	    <servlet-mapping>
	        <servlet-name>demo1</servlet-name>
	        <url-pattern>/demo1</url-pattern>
	    </servlet-mapping>

        (1) 可配置多个servlet，name属性必须不同
        (2) 访问方法为ip:端口号/虚拟目录/name。
               ip:端口号找到web服务器软件，虚拟目录找到项目，name找到对应的servlet实现类





执行原理(了解)：
	1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
	2. 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
	3. 如果有，则在找到对应的<servlet-class>全类名
	4. tomcat会将字节码文件加载进内存，并且创建其对象
	5. 调用其方法




看一看就行：
    创建项目时选Java Enterprise(JavaEE)，
    选择JavaEE 7的版本(学习的是这个)，
    打钩Web Application（做的是web项目）

    在run---运行/配置中将 On'Update' action 选项 和 On frame deactivation选项都
        改为：Update resources 就可以变为资源热部署，带有classes选项的为连java代码也会热部署
    run---运行/配置---Deployment中的Application context窗口为虚拟目录，一般改为项目名


看一看理解就行：
    java就是普通的用java写的程序，直接就能运行的。
　　Java Enterprise 主要是针对Java EE 项目的开发设计的“帮助我们开发和部署可移植、健壮、可伸缩且安全的
        服务器端 Java应用程序”，所以web项目大多都在这个视图中进行开发。功能较前者多一些。
　　web project,web service project不能直接运行，必须在容器里面运行，这个容器就是web server，
        例如tomcat,jboss。web project就是web工程，简单的讲做网站的工程，
        web service project是以http为通信协议xml为媒介来传输数据以达到运行调用java程序的目的。
　　1、当你是web应用时，比如说要建个网站，需要发布到服务器时，应该要建Web Project 。
　　2、当你是做分布式系统时，也就是你做的只是一个服务，对外发布也只是一个服务的时候，
        需要建立Web Services Project(不理解可以先研究下webservices)。
　　3、当你仅仅是需要JDK来运行一些本地代码的时候，只需要建Java Project就可以了。
　　4、Web Project就是普通的jsp项目，基于J2EE标准，符合mvc规范，你可以理解为BS模式的程序。
　　5、Web Service Project 也是BS程序，只是要用到网络中其他的数据，为了数据之间能更好的通讯必须
        符合http和xml标准，因此就独立出来叫做Web Service Project。
　　6、 Java Project 就是一般的java项目，不属于BS项目。BS项目最大的特点是客户端的界面都是有浏览器作为载体，但是java project不是，它就是一般的JAVA项目。






*/


public class Servlet {
}
