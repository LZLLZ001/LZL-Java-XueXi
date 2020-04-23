<%--
概念：JavaServer Pages Tag Library  JSP标准标签库
	* 是由Apache组织提供的开源的免费的jsp标签	<标签>


作用：用于简化和替换jsp页面上的java代码


使用步骤：
	1. 导入jstl相关jar包
	2. 引入标签库：taglib指令：<%@ taglib %>
	        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  //prefix前置代号
	3. 使用标签:  前置代号:对应标签
            <c:if test="true">
                <h1>真...</h1>
            </c:if>

常用的JSTL标签
	1. if:相当于java代码的if语句
		 (1) 属性：
            * test 必须属性，接受boolean表达式
                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
                * 一般情况下，test属性值会结合el表达式一起使用
   		 (2) 注意：
       		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签

	2. choose:相当于java代码的switch语句
		 (1) 使用choose标签声明         			相当于switch声明
         (2) 使用when标签做判断         			相当于case
         (3) 使用otherwise标签做其他情况的声明    	相当于default
                <c:choose>
                    <c:when test="${number == 7}"> 对 </c:when>
                    <c:otherwise> 数字输入有误 </c:otherwise>
                </c:choose>

	3. foreach:相当于java代码的for语句
	    (1) 完成重复的操作
                属性：
                    begin：开始值
                    end：结束值
                    var：临时变量
                    step：步长
                    varStatus:循环状态对象
                        index:容器中元素的索引，从0开始
                        count:循环次数，从1开始
        (2) 遍历容器
                属性：
                    items:容器对象
                    var:容器中元素的临时变量
                    varStatus:循环状态对象
                        index:容器中元素的索引，从0开始
                        count:循环次数，从1开始


 技术选型：Servlet+JSP+MySQL+JDBCTempleat+Duird+BeanUtilS+tomcat



--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
