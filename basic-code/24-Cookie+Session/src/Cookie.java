/*
会话技术
    1. 会话：一次会话中包含多次请求和响应。
        * 一次会话：浏览器第一次给服务器资源发送请求，会话建立，直到有一方断开为止
    2. 功能：在一次会话的范围内的多次请求间，共享数据
            因为HTTP协议是无状态的(每对请求相应之间项目独立，不能进行数据交流)
    3. java会话实现方式：
        (1) 客户端会话技术：Cookie
        (2) 服务器端会话技术：Session



Cookie概念：一种客户端会话技术，将数据保存到客户端


使用步骤：
    1. 创建Cookie对象，绑定数据
        * new Cookie(String name, String value)
    2. 发送Cookie对象
        * response.addCookie(Cookie cookie)
    3. 获取Cookie，拿到数据
        * Cookie[]  request.getCookies()
          co.getName();
          co.getValue();


cookie的细节
	1. 可以创建多个Cookie对象，使用response调用多次addCookie方法发送cookie即可。
	2. cookie默认情况下保存在浏览器中，当浏览器关闭后，Cookie数据被销毁
		持久化存储：
			* setMaxAge(int seconds)
				1. 正数：将Cookie数据写到硬盘的文件中，并指定cookie存活时间，时间到后，cookie文件自动失效
				2. 负数：默认值
				3. 零：删除cookie信息
	3. 一个tomcat服务器中，部署了多个web项目，那么在这些web项目中cookie默认情况下cookie不能共享
			* setPath(String path):设置cookie的获取范围。默认情况下，设置当前的虚拟目录
				* 如果要共享，则可以将path设置为"/"
		不同的tomcat服务器间cookie共享问题：
			* setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
				* setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共
    4. 实现原理：基于响应头set-cookie和请求头cookie实现(看图片)
    5. 在tomcat 8 之后，cookie支持中文数据。特殊字符还是不支持，建议使用URL编码存储，URL解码解析
            URLEncoder.encode(str_date,"utf-8");
            URLDecoder.decode(value,"utf-8");

Cookie的特点和作用
	1. cookie存储数据在客户端浏览器
	2. 浏览器对于单个cookie 的大小有限制(4kb) 以及 对同一个域名下的总cookie数量也有限制(20个)
	* 作用：
		1. cookie一般用于存出少量的不太敏感的数据
		2. 在不登录的情况下，完成服务器对客户端的身份识别


*/


public class Cookie {
}
