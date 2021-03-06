/*
内容包括：
	关键字；标识符；常量：变量：数据类型；数据类型转换；四则运算；逻辑运算符；三元运算符；方法

JDK ：Java程序开发工具包，包含 JRE 和开发人员使用的工具。（JDK包含JRE,JRE包含JVM）
JRE ：Java程序的运行时环境，包含 JVM 和运行时所需要的 核心类库 。
JVM ：Java虚拟机，是运行所有Java程序的假想计算机，是Java程序的运行环境。
	跨平台：任何软件的运行，都必须要运行在操作系统之上，而我们用Java编写的软件可以运行在任何的操作系统上，
	这个特性称为Java语言的跨平台特性。该特性是由JVM实现的，我们编写的程序运行在JVM上，而JVM运行在操作系统上。

————————————————————————————————————————————————————————————————————————————————————————————————————————————————————

编译和运行是两回事：
	编译：是指将我们编写的Java源文件翻译成JVM认识的class文件，在这个过程中， javac 编译器会检查我们
			所写的程序是否有错误，有错误就会提示出来，如果没有错误就会编译成功。
	运行：是指将 class文件 交给JVM去运行，此时JVM就会去执行我们编写的程序了。

————————————————————————————————————————————————————————————————————————————————————————————————————————————————————


字节是我们常见的计算机中最小存储单元。计算机存储任何的数据都以字节的形式存储.
	8个bit（二进制位）表示为1个字节，写成1 byte或者1 B。
	8 bit = 1 B
	1024 B =1 KB
	1024 KB =1 MB

————————————————————————————————————————————————————————————————————————————————————————————————————————————————————

main方法：主方法。写法是固定格式不可以更改。main方法是程序的入口点或起始点。

————————————————————————————————————————————————————————————————————————————————————————————————————————————————————

关键字：Java已经定义好的单词，具有特殊含义，全部都是小写字母。

标识符：自己定义内容
	命名规则： 硬性要求
		标识符可以包含 英文字母26个(区分大小写) 、 0-9数字 、 $（美元符号） 和 _（下划线） 。
		标识符不能以数字开头。
		标识符不能是关键字。
	命名规范： 软性建议
		类名规范：首字母大写，后面每个单词首字母大写（大驼峰式）。HelloWorld
		方法名规范： 首字母小写，后面每个单词首字母大写（小驼峰式）。helloWorld
		变量名规范：全部小写。

————————————————————————————————————————————————————————————————————————————————————————————————————————————————————

常量：在程序运行期间，固定不变的量。
	常量的分类：
		1. 字符串常量：凡是用双引号引起来的部分，叫做字符串常量。例如："abc"、"Hello"、"123"
		2. 整数常量：直接写上的数字，没有小数点。例如：100、200、0、-250
		3. 浮点数常量：直接写上的数字，有小数点。例如：2.5、-3.14、0.0
		4. 字符常量：凡是用单引号引起来的单个字符，就做字符常量。例如：'A'、'b'、'9'、'中'
		5. 布尔常量：只有量中取值。true、false。
		6. 空常量：null。代表没有任何数据。

		System.out.println(""); //  字符串两个双引号中间的内容可以为空
		// System.out.println(''); // ×  两个单引号中间必须有且仅有一个字符，没有不行。
		// System.out.println('AB'); // ×  两个单引号中间必须有且仅有一个字符，有两个不行
		// System.out.println(null);// × 空常量不能直接用来打印输出。


Java的数据类型分为两大类：
	基本数据类型：
			整数：byte short int long
			浮点数：float double
			字符：char
			布尔 ：boolean
	引用数据类型：字符串、数组、类、接口、Lambda

	1) 注意字符串不是基本类型，而是引用类型
	2) 浮点数默认使用double,如果要用float需在后面加上后缀F；整数默认为int,long需要加上后缀L
	3) 对于基本类型来说，==是进行数值的比较。
       对于引用类型来说，==是进行【地址值】的比较。


变量：程序运行期间，内容可以发生改变的量，本质是一个内存空间的地址。
	数据类型 变量名称; // 创建了一个变量
	变量名称 = 数据值; // 赋值，将右边的数据值，赋值交给左边的变量
	数据类型 变量名称 = 数据值; // 在创建一个变量的同时，立刻放入指定的数据值
	数据类型 变量名称 = 变量名称;
	变量名称 = 变量名称;

	// byte num4 = 400； // × 注意：右侧数值的范围不能超过左侧数据类型的取值范围，右侧超出了byte数据范围，错误！
	// long num6 = 3000000000；// × 操作为先创建这个数字，然后赋值，整数默认为int，这个数字的值超过了Int类型的长度，报错
	long num6 = 3000000000L；//因为有后缀直接创建了Long类型的数字，然后赋值。

	注意事项：
		1. 变量名不可重复。
		2. 对于float和long类型来说，字母后缀F和L不要丢掉。
		3. 如果使用byte或者short类型的变量，那么右侧的数据值不能超过左侧类型的范围。
		4. 没有进行赋值的变量，不能直接使用（会报错）；一定要赋值之后，才能使用。
		5. 变量使用不能超过作用域的范围。【作用域】：从定义变量的一行开始（所以要先定义再使用），一直到直接所属的大括号结束为止。
		6. 可以通过一个语句来创建多个变量，但是一般情况不推荐这么写。

		int num1 = 10; // 创建了一个新的变量，名叫num1
		// int num1 = 20; // 又创建了另一个新的变量，名字也叫num1，错误！

		int num4; // 定义了一个变量，但是没有进行赋值
		// System.out.println(num4); // 直接使用打印输出就是错误的！

		// System.out.println(num5); // 在创建变量之前，不能使用这个变量
		int num5 = 500;
		System.out.println(num5);

		{
			int num6 = 60;
			System.out.println(num6); // 60
		}
		// int num6;
		// System.out.println(num6); // 已经超出了大括号的范围，超出了作用域，变量不能再使用了

		// 同时创建三个int变量，并且同时各自赋值
		int x = 100, y = 200, z = 300;
		System.out.println(x); // 100
		System.out.println(y); // 200
		System.out.println(z); // 300

数据类型转换：
	当数据类型不一样时，将会发生数据类型转换。

	自动类型转换（隐式）：
		1. 特点：代码不需要进行特殊处理，自动完成。
		2. 规则：数据范围从小到大。byte、short、char‐‐>int‐‐>long‐‐>float‐‐>double
		3. 一旦运算当中有不同类型的数据，那么结果将会是数据类型范围大的那种。
		4. 原理：自动补充。
			// 左边是long类型，右边是默认的int类型，左右不一样
			// 一个等号代表赋值，将右侧的int常量，交给左侧的long变量进行存储
			// int --> long，符合了数据范围从小到大的要求
			// 这一行代码发生了自动类型转换。
			long num1 = 100;
			System.out.println(num1); // 100

	强制类型转换（显式）：
		1. 特点：代码需要进行特殊的格式处理，不能自动完成。
		2. 格式：范围小的类型 范围小的变量名 = (范围小的类型) 原本范围大的数据;
			注意事项：
				1. 强制类型转换一般不推荐使用，因为有可能发生精度损失、数据溢出，所有多出内容都会被舍弃掉。
				2. byte/short/char这三种类型在运算（比如数学运算）的时候，都会被首先提升成为int类型，然后再计算。
				3. boolean类型不能发生数据类型转换

			// double --> int，强制类型转换
			int num3 = (int) 3.99;
			System.out.println(num3); // 这并不是四舍五入，所有的小数位都会被舍弃掉

			char zifu1 = 'A'; // 这是一个字符型变量，里面是大写字母A
			System.out.println(zifu1);// A
			System.out.println(zifu1 + 1); // 66，也就是大写字母A被当做65进行处理
			// 计算机的底层会用一个数字（二进制）来代表字符A，就是65
			// 一旦char类型进行了数学运算，那么字符就会按照一定的规则翻译成为一个数字

			byte num4 = 40; // 注意！右侧的数值大小不能超过左侧的类型范围
			byte num5 = 50;
			// byte result1 = num4 + num5;// × byte + byte --> int + int --> int，看第二个注意事项
			int result1 = num4 + num5;
			System.out.println(result1); // 90

			short num6 = 60;
			// byte + short --> int + int --> int
			// int强制转换为short：注意必须保证逻辑上真实大小本来就没有超过short范围，否则会发生数据溢出
			short result2 = (short) (num4 + num6);
			System.out.println(result2); // 100

四则运算当中的加号“+”：
		1. 对于数值来说是加法。
		2. ++i【++前】先加后用，i++【后++】先用后加
		2. 对于字符char类型来说，在计算之前，char会被提升成为int，然后再计算。
		3. 对于字符串String（首字母大写，并不是关键字）加号代表字符串连接操作。
			任何数据类型和字符串进行连接的时候，结果都会变成字符串（注意与字符的区别）。
				String str1 = "Hello";
				System.out.println(str1); // Hello
				System.out.println("Hello" + "World"); // HelloWorld
				System.out.println(str1 + 20); // Hello20，String + int --> String


逻辑运算符：
	1. 逻辑运算符只能用于boolean值。
	2. 与、或需要左右各自有一个boolean值，但是取反只要有唯一的一个boolean值即可。
	3. 与、或两种运算符，如果有多个条件，可以连续写。
		两个条件：条件A && 条件B
		多个条件：条件A && 条件B && 条件C
		进行多次判断，不能连着写：1 < x < 3会报错
		应该拆成两个部分，然后使用与运算符连接起来：1 < x && x < 3
	4. 短路效果，与“&&”，或“||”，具有短路效果：如果根据左边已经可以判断得到最终结果，那么右边的代码将不再执行，从而节省一定的性能。

		int a = 10;
		// false && ...
		System.out.println(3 > 4 && ++a < 100); // false，++a没有执行
		System.out.println(a); // 10

三元运算符：需要三个数据才可以进行操作的运算符。
	数据类型 变量名称 = 条件判断 ? 表达式A : 表达式B;
	流程：
		首先判断条件是否成立：
		如果成立为true，那么将表达式A的值赋值给左侧的变量；
		如果不成立为false，那么将表达式B的值赋值给左侧的变量；
		二者选其一。
	注意事项：
		1. 必须同时保证表达式A和表达式B都符合左侧数据类型的要求。
		2. 三元运算符的结果必须被使用。
				// int result = 3 > 4 ? 2.5 : 10; // 错误
				System.out.println(a > b ? a : b); // 正确
				// a > b ? a : b; // 错误




*/
public class Java基础 {

}
