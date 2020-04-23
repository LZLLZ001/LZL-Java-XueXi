/*
Session概念：服务器端会话技术，在一次会话的多次请求间共享数据，
             将数据保存在服务器端的对象HttpSession中

快速入门：
	1. 获取HttpSession对象：
		HttpSession session = request.getSession();
	2. 使用HttpSession对象：
		void setAttribute(String name, Object value)
		Object getAttribute(String name)
		void removeAttribute(String name)

原理：Session的实现依赖于Cookie的。


细节：
	1. 当客户端关闭后，服务器不关闭，两次获取session默认情况下不是同一个。
		* 如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
			 Cookie co = new Cookie("JSESSIONID",session.getId());
	         co.setMaxAge(60*60);  //60×60s
	         response.addCookie(co);

	2. 客户端不关闭，服务器关闭后，两次获取的session不是同一个，但是要确保数据不丢失。
	        tomcat自动完成以下工作
                * session的钝化：在服务器正常关闭之前，将session对象系列化到硬盘上
                * session的活化：在服务器启动后，将session文件转化为内存中的session对象即可。

	3. session被销毁:
		(1) 服务器关闭
		(2) session对象调用invalidate() 。
		(3) session默认失效时间30分钟
                选择性配置修改（了解）
                <session-config>
                    <session-timeout>30</session-timeout>
                </session-config>

session的特点
    1. session用于存储一次会话的多次请求的数据，存在服务器端
    2. session可以存储任意类型，任意大小的数据


session与Cookie的区别：
    1. session存储数据在服务器端，Cookie在客户端
    2. session没有数据大小限制，Cookie有
    3. session数据安全，Cookie相对于不安全


*/


public class Session {
}
