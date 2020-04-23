<%--
JSP概念：Java Server Pages： java服务器端页面
    * 可以理解为：一个特殊的页面，其中既可以指定定义html标签，又可以定义java代码
    * 用于简化书写！！！

JSP与JS完全不是一个东西！！
    JavaScript：一门客户端脚本语言，增强用户和html页面的交互过程，来控制html元素，
         让页面有一些动态的效果，增强用户的体验。

原理：JSP本质上就是一个Servlet，看图片


JSP注释：见这个注释

JSP脚本：JSP定义Java代码的方式
	1. <%  代码 %>：定义的java代码，在service方法中。方法中可以定义什么，该脚本中就可以定义什么。
	2. <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置。
	3. <%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。


JSP内置对象：在jsp页面中不需要获取和创建，可以直接使用的对象，jsp一共有9个内置对象(记下哪9个)。

		变量名：					真实类型：					作用:
		* pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
		* request					HttpServletRequest			一次请求访问的多个资源(转发)
		* session					HttpSession					一次会话的多个请求间
		* application				ServletContext				所有用户间共享数据
		* response					HttpServletResponse			响应对象
		* page						Object						当前页面(Servlet)的对象  this
		* out						JspWriter					输出对象，数据输出到页面上
		* config					ServletConfig				Servlet的配置对象
		* exception					Throwable					异常对象

    1. out：字符输出流对象。可以将数据输出到页面上(一般用这个输出)。
        * response.getWriter()和out.write()的区别：
            * 在tomcat服务器真正给客户端做出响应之前，会先找response缓冲区数据，再找out缓冲区数据。
              所以response.getWriter()数据输出永远在out.write()之前,所以一般用out输出




JSP指令
	* 作用：用于配置JSP页面，导入资源文件
	* 格式：
		<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
	* 指令分类：
		1. page：配置JSP页面的
			* contentType：等同于response.setContentType()
				(1) 设置响应体的mime类型以及字符集
				(2) 设置当前jsp页面的编码（只能是高级的IDE才能生效，如果使用低级工具，则需要设置pageEncoding属性设置当前页面的字符集）
			* import：导包
			* errorPage：当前页面发生异常后，会自动跳转到指定的错误页面
			* isErrorPage：标识当前页面是否是错误页面。
				* true：是，可以使用内置对象exception
				* false：否。默认值。不可以使用内置对象exception
        2. include：用于包含页面。导入页面的资源文件
			* <%@include file="top.jsp"%>
		3. taglib：导入资源(一般用于导入标签库)
			* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				* prefix：前缀，自定义的


MVC：开发模式(看图)
    1. M：Model，模型。JavaBean
		* 完成具体的业务操作，如：查询数据库，封装对象
	2. V：View，视图。JSP
		* 展示数据--所以以后JSP(EL,JSTL)只用于展示数据
	3. C：Controller，控制器。Servlet
		* 获取用户的输入
		* 调用模型
		* 将数据交给视图进行展示
    优缺点：
		(1) 优点：
			1. 耦合性低，方便维护，可以利于分工协作
			2. 重用性高
		(2) 缺点：使得项目架构变得复杂，对开发人员要求高

    jsp演变历史(了解)
        1. 早期只有servlet，只能使用response输出标签数据，非常麻烦
        2. 后来又jsp，简化了Servlet的开发，如果过度使用jsp，在jsp中即写大量的java代码，有写html表，造成难于维护，难于分工协作
        3. 再后来，java的web开发，借鉴mvc开发模式，使得程序的设计更加合理性


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
