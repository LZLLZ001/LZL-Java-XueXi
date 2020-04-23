<%--
动画:三种方式显示和隐藏元素
    1. 默认显示和隐藏方式
        (1) show([speed,[easing],[fn]])
            1. 参数：
                1. speed：动画的速度。三个预定义的值("slow","normal", "fast")或表示动画时长的毫秒数值(如：1000)
                2. easing：用来指定切换效果，默认是"swing"，可用参数"linear"
                    * swing：动画执行时效果是 先慢，中间快，最后又慢
                    * linear：动画执行时速度是匀速的
                3. fn：在动画完成时执行的函数，每个元素执行一次。
        (2) hide([speed,[easing],[fn]])
        (3) toggle([speed],[easing],[fn]) //切换

    2. 滑动显示和隐藏方式
        (1) slideDown([speed],[easing],[fn])
        (2) slideUp([speed,[easing],[fn]])
        (3) slideToggle([speed],[easing],[fn])

    3. 淡入淡出显示和隐藏方式
        (1) fadeIn([speed],[easing],[fn])
        (2) fadeOut([speed],[easing],[fn])
        (3) fadeToggle([speed,[easing],[fn]])



遍历
	js的遍历方式：
		* for(初始化值;循环结束条件;步长)
	jq的遍历方式：
		1. jq对象.each(callback)
			(1) 语法：
				jquery对象.each(function(index,element){});
					* index:就是元素在集合中的索引
					* element：就是集合中的每一个元素对象

					* this：集合中的每一个元素对象
			(2) 回调函数返回值：
				* return false：结束循环(break)。
				* return true：结束本次循环，继续下次循环(continue)
		2. $.each(object, [callback])
		3. for..of: jquery 3.0 版本之后提供的方式
			for(元素对象 of 容器对象)


事件绑定
	1. jquery标准的绑定方式
		* jq对象.事件方法(回调函数)；
		* 注：如果调用事件方法，不传递回调函数，则会触发浏览器默认行为。
			* 表单对象.submit();//让表单提交
	2. on绑定事件/off解除绑定
		* jq对象.on("事件名称",回调函数)
		* jq对象.off("事件名称")
			* 如果off方法不传递任何参数，则将组件上的所有事件全部解绑
	3. 事件切换：toggle
		* jq对象.toggle(fn1,fn2...)
			* 当单击jq对象对应的组件后，会执行fn1.第二次点击会执行fn2.....




插件：增强JQuery的功能
    定义插件方法
    1. $.fn.extend(方法名1:function(){}, 方法名2:function(){}...)
        * 增强通过Jquery获取的对象的功能(增强对象方法)  $("#id").方法名1
    2. $.extend(方法名1:function(){}, 方法名2:function(){}...)
        * 增强JQeury对象自身的功能(增强全局方法)  $.方法1





--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
