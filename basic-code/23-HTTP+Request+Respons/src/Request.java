/*
请求消息数据格式
	1. 请求行
		请求方式 /请求url 请求协议/版本
		GET /login.html	HTTP/1.1
		* 请求方式：
			* HTTP协议有7中请求方式，常用的有2种
				* GET：
					1. 请求参数在请求行中，在url后。
					2. 请求的url长度有限制的
					3. 不太安全
				* POST：
					1. 请求参数在请求体中
					2. 请求的url长度没有限制的
					3. 相对安全
	2. 请求头：客户端浏览器告诉服务器一些信息
		请求头名称: 请求头值
		* 常见的请求头：
			1. User-Agent：浏览器告诉服务器，我访问你使用的浏览器版本信息
				* 可以在服务器端获取该头的信息，解决浏览器的兼容性问题
			2. Referer：告诉服务器，当前请求从哪里来
				* 作用：1. 防盗链; 2. 统计工作
	3. 请求空行
		空行，就是用于分割POST请求的请求头，和请求体的。
	4. 请求体(正文)：
		* 封装POST请求消息的请求参数的




原理打开图片: request&response对象原理


request和response对象由服务器创建。
request对象获取请求消息，response对象设置响应消息



request功能：
	1. 获取请求消息数据
		(1) 获取请求行数据
			* GET /day14/demo1?name=zhangsan HTTP/1.1
			* 方法：
				1. 获取请求方式 ：GET
					* String getMethod()
				2. 获取虚拟目录：/day14(掌握)
					* String getContextPath()
				3. 获取Servlet路径: /demo1
					* String getServletPath()
				4. 获取get方式请求参数：name=zhangsan
					* String getQueryString()
				5. 获取请求URI：/day14/demo1(掌握，除了掌握外的了解就行)
					* String getRequestURI():		/day14/demo1
					* StringBuffer getRequestURL()  :http://localhost/day14/demo1
                        * URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
                        * URI：统一资源标识符 : /day14/demo1					共和国
				6. 获取协议及版本：HTTP/1.1
					* String getProtocol()
				7. 获取客户机的IP地址：
					* String getRemoteAddr()

		(2) 获取请求头数据
			String getHeader(String name):通过请求头的名称获取请求头的值
			    常用于获取User-Agent，Referer

		(3) 获取请求体数据:
			* 请求体：只有POST请求方式，才有请求体，在请求体中封装了POST请求的请求参数
			* 步骤：
				1. 获取流对象
					*  BufferedReader getReader()：获取字符输入流，只能操作字符数据
					*  ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据
				2. 从流对象中拿数据


    2. 其他功能(要背)：
		(1) 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
			1. String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
			2. Map<String,String[]> getParameterMap():获取所有参数的map集合(1,2常用，3,4了解)
			3. String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
			4. Enumeration<String> getParameterNames():获取所有请求的参数名
			* 中文乱码问题：
				* get方式：tomcat 8 已经将get方式乱码问题解决了
				* post方式：会乱码
					* 解决：不管是get还是post都在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");

        (2) 请求转发：一种在服务器内部的资源跳转方式
			1. 步骤：
				1. 通过request对象获取请求转发器对象：RequestDispatcher getRequestDispatcher(String path)
				2. 使用RequestDispatcher对象来进行转发：forward(ServletRequest request, ServletResponse response)
				    一般使用链式编程连起来用
			2. 特点：
				1. 浏览器地址栏路径不发生变化
				2. 只能转发到当前服务器内部资源中。
				3. 转发是一次请求

		(3) 共享数据：
			* 域对象：一个有作用范围的对象，可以在范围内共享数据
			* request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
			* request方法：
				1. void setAttribute(String name,Object obj):存储数据到域中
				2. Object getAttitude(String name):通过键在域中获取存储的值
				3. void removeAttribute(String name):通过键移除键值对

		(4) 获取ServletContext：
			ServletContext getServletContext()


form表单的action路径的写法：虚拟目录+Servlet的资源路径


BeanUtils工具类，简化数据封装：导jar包后使用其静态方法
    * 用于封装JavaBean的
    1. JavaBean：标准的Java类
        (1) 要求：
            1. 类必须被public修饰
            2. 必须提供空参的构造器
            3. 成员变量必须使用private修饰
            4. 提供公共setter和getter方法
        (2) 功能：封装数据

    2. 概念：
        成员变量：
        属性：setter和getter方法截取后的产物
            例如：getUsername() --> Username--> username
    3. 方法：
        1. setProperty() :设置属性值
        2. getProperty() :获取属性值
        3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中

*/


public class Request {
}
