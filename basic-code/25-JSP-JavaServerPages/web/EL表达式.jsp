<%--
概念：Expression Language 表达式语言

作用：替换和简化jsp页面中java代码的编写(详细见百度百科)

语法：${表达式}

注意：jsp默认支持el表达式的。如果要忽略el表达式
    1. 设置jsp中page指令中：isELIgnored="true" 忽略当前jsp页面中所有的el表达式
    2. \${表达式} ：忽略当前这个el表达式




使用：
	(1) 运算：
        1. 算数运算符： + - * /(div) %(mod)
        2. 比较运算符： > < >= <= == !=
        3. 逻辑运算符： &&(and) ||(or) !(not)
        4. 空运算符： empty
            * 功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0
            * ${empty list}:判断字符串、集合、数组对象是否为null或者长度为0
            * ${not empty str}:表示判断字符串、集合、数组对象是否不为null 并且 长度>0

	(2) 获取值: el表达式只能从域对象中获取值
        1. ${域名称.键名}：从指定域中获取指定键的值
            * 域名称：
                <1> pageScope		--> pageContext
                <2> requestScope 	--> request
                <3> sessionScope 	--> session
                <4> applicationScope --> application（ServletContext）
            * 举例：存储request.setAttribute("name","张三");
            * 获取：${requestScope.name}

        2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。

        3. 获取对象、List集合、Map集合的值
                <1> 对象：${域名称.键名.属性名}
                        本质上会去调用对象的getter方法
                        逻辑视图：自己编写get方法进行数据的展示
                <2> List集合：${域名称.键名[索引]}

                <3> Map集合：
                    * ${域名称.键名.key名称}
                    * ${域名称.键名["key名称"]}

隐式对象：
    * el表达式中有11个隐式对象
    * pageContext：
        * 获取jsp其他八个内置对象
            * ${pageContext.request.contextPath}：动态获取虚拟目录

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
