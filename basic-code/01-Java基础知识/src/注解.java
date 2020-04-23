/*
注解：一种代码级别的说明


作用分类：
	①编写文档：通过代码里标识的注解生成文档【生成文档doc文档】
	②代码分析：通过代码里标识的注解对代码进行分析【使用反射】
	③编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查【Override】

JDK中预定义的一些注解
	* @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
	* @Deprecated：该注解标注的内容，表示已过时
	* @SuppressWarnings：压制警告
		 一般传递参数all  @SuppressWarnings("all")


自定义注解
	* 格式：
		元注解
		public @interface 注解名称{
			属性列表;
		}

	* 本质：注解本质上就是一个接口，该接口默认继承Annotation接口
		* public interface MyAnno extends java.lang.annotation.Annotation {}

	* 属性：接口中的抽象方法
		* 要求：
			1. 属性的返回值类型只能有下列取值
				* 基本数据类型
				* String
				* 枚举
				* 注解
				* 以上类型的数组

			2. 定义了属性，在使用时需要给属性赋值：@注解名称(a=x,b=y,c={d,f,g})
				1. 如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值。
				2. 数组赋值时，值使用{}包裹。如果数组中只有一个值，则{}可以省略

	* 元注解：用于描述注解的注解
		* @Target(value={ElementType.XXX})：描述注解能够作用的位置
			* XXX取值：可取多个值：ElementType.XXX，ElementType.YYY
				* TYPE：可以作用于类上
				* METHOD：可以作用于方法上
				* FIELD：可以作用于成员变量上
		* @Retention：描述注解被保留的阶段
			* @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
		* @Documented：注解会被抽取到api文档中
		* @Inherited：注解会被子类继承


在程序使用(解析)注解：获取注解中定义的属性值
	1. 获取注解定义的位置的对象  （Class，Method，Field）
	2. 获取指定的注解
		getAnnotation(Class)
		//其实就是在内存中生成了一个该注解接口的子类实现对象
	            public class ProImpl implements Pro{
	                public String className(){
	                    return "cn.itcast.annotation.Demo1";
	                }
	                public String methodName(){
	                    return "show";
	                }
	            }
	3. 调用注解中的抽象方法获取配置的属性值
        Class<类名> 类名Class = 类名.class;       //Class，Method，Field
        注解名 an = 类名Class.getAnnotation(注解名.class);
                  = an.属性值;     //String className = an.className();


小结：
	1. 以后大多数时候，我们会使用注解，而不是自定义注解
	2. 注解给谁用？
		1. 编译器
		2. 给解析程序用
	3. 注解不是程序的一部分，可以理解为注解就是一个标签


*/


public class 注解 {
}
