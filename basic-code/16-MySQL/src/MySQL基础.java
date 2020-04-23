/*
数据库： DataBase 简称 ： DB
	用于存储和管理数据的仓库。
    数据库的特点：
        1. 持久化存储数据的。其实数据库就是一个文件系统
        2. 方便存储和管理数据
        3. 使用了统一的方式操作数据库 -- SQL


SQL：Structured Query Language 结构化查询语言
    是一种所有关系型数据库的查询规范，不同的数据库都支持。
    通用的数据库操作语言，可以用在不同的数据库中。
    不同的数据库 SQL 语句有一些区别。

SQL 语句分类
	1) DDL(Data Definition Language)数据定义语言
		用来定义数据库对象：数据库，表，列等。关键字：create, drop,alter 等
	2) DML(Data Manipulation Language)数据操作语言
		用来对数据库中表的数据进行增删改。关键字：insert, delete, update 等
	3) DQL(Data Query Language)数据查询语言(重点)
		用来查询数据库中表的记录(数据)。关键字：select, where 等
	4) DCL(Data Control Language)数据控制语言(了解)
		用来定义数据库的访问权限和安全级别，及创建用户。关键字：GRANT， REVOKE 等

MySQL 的语法
    1) 每条语句以分号结尾
    2) 关键字不区分大小写
    3) 3 种注释：
        --空格 单行注释
        #   mysql特有的单行注释
        /星 星/ 多行注释




DDL 操作数据库：CRUD   (都可通过可视化工具便捷操作，但是语法简单，简单背就行)
	1. C(Create):创建
        创建数据库：
            create database 数据库名称;
        创建数据库，判断不存在，再创建：
            create database if not exists 数据库名称;
        创建数据库，并指定字符集
            create database 数据库名称 character set 字符集名;
	2. R(Retrieve)：查询
		查询所有数据库的名称:
			show databases;
		查询某个数据库的字符集:查询某个数据库的创建语句
			show create database 数据库名称;
	3. U(Update):修改
		修改数据库的字符集
			alter database 数据库名称 character set 字符集名称;
	4. D(Delete):删除
		删除数据库
			drop database 数据库名称;
		判断数据库存在，存在再删除
			drop database if exists 数据库名称;
	5. 使用数据库
		查询当前正在使用的数据库名称
			select database();
		使用数据库
			use 数据库名称;



DDL 操作表
	1. C(Create):创建
        create table 表名(
            列名1 数据类型1,
            列名2 数据类型2,
            ....
            列名n 数据类型n
        );
        * 注意：最后一列，不需要加逗号（,）;先列名再数据类型（age int,）
        * 常用数据库类型：
            (1)int：整数类型
            (2)double:小数类型
            (3)date:日期，只包含年月日，yyyy-MM-dd
            (4)datetime:日期，包含年月日时分秒	 yyyy-MM-dd HH:mm:ss
            (5)timestamp:时间错类型	包含年月日时分秒	 yyyy-MM-dd HH:mm:ss
                * 如果将来不给这个字段赋值，或赋值为null，则默认使用当前的系统时间，来自动赋值
            (6)varchar：字符串
                * name varchar(20):姓名最大20个字符zhangsan 8个字符  张三 2个字符
        复制表：
			create table 表名 like 被复制的表名;

    2. R(Retrieve)：查询
        查询某个数据库中所有的表名称
            show tables;
        查询表结构
            desc 表名;
	3. U(Update):修改
		(1)修改表名
			alter table 表名 rename to 新的表名;
		(2)修改表的字符集
			alter table 表名 character set 字符集名称;
		(3)添加一列
			alter table 表名 add 列名 数据类型;
		(4)修改列名称 类型
			alter table 表名 change 列名 新列名 新数据类型;
			alter table 表名 modify 列名 新数据类型;
		(5) 删除列
			alter table 表名 drop 列名;
	4. D(Delete):删除
		drop table 表名;
		drop table  if exists 表名 ;


DML：增删改表中数据
    1. 添加数据：
        insert into 表名(列名1,列名2,...列名n) values(值1,值2,...值n);
            注意：
                (1)列名和值要一一对应。
                (2)如果表名后，不定义列名，则默认给所有列添加值
                    insert into 表名 values(值1,值2,...值n);
                (3)除了数字类型，其他类型需要使用引号(单双都可以)引起来
    2. 删除数据：
        delete from 表名 [where 条件]
            注意：如果不加条件，则删除表中所有记录。
    3. 修改数据：
        update 表名 set 列名1 = 值1, 列名2 = 值2,... [where 条件];
            注意：如果不加任何条件，则会将表中所有记录全部修改。

记法：DDL中对库和表的操作为create，drop，alter，show
    DML与DQL对数据的操作为insert into，delete from，update，select from



DQL：查询表中的记录
    语法：
        select
            字段列表
        from
            表名列表
        where
            条件列表
        group by
            分组字段
        having
            分组之后的条件
        order by
            排序
        limit
            分页限定

    1.基础查询
        (1)多个字段的查询
            select 字段名1，字段名2... from 表名；
                *为查询所有字段
        (2)去除重复：
            distinct  //清晰的、确切的、不同种类的
                select distinct 字段名 from 表名;
        (3)计算列
            一般可以使用四则运算计算一些列的值。（一般只会进行数值型的计算）
            select 字段名1，(表达式)... from 表名； 可不用括号
                null参与的运算，计算结果都为null，需要使用：
                    ifnull(表达式1,表达式2)：
                        若表达式1字段为null则替换为表达式2值进行计算。
        (4)起别名：
            as：as可以省略(一般都省略，直接用空格)
                字段和表名等都可以起别名，字段名 别名,
        (5)聚合函数：将一列数据作为一个整体，进行纵向的计算。
            <1> count(...)：计算个数，一般选择非空的列：主键
                2. count(*)
            <2> max(...)：计算最大值
            <3> min(...)：计算最小值
            <4> sum(...)：计算和
            <5> avg(...)：计算平均值
                聚合函数的计算会自动排除null值。选择不包含非空的列进行计算或使用ifnull函数

    2.条件查询
        where子句后跟条件
        运算符
            (1) > 、< 、<= 、>= 、= 、<>
            (2)between...and...   包含头也包含尾
            (3)in(数据 1, 数据 2...)
                in里面的每个数据(或者为表达式)都会作为一次条件，只要满足任意一个条件的就会显示
            (4)like ...  模糊查询 like '张%'
                占位符：
                    _:单个任意字符
                    %:多个任意字符
            (5)is null 或 is not null
                null值不能使用=来判断，需要用is
            (6)and  或 &&
            (7)or  或 ||
            (8)not  或 !

    3.排序查询
        order by 排序字段1 排序方式1 ，排序字段2 排序方式2...
            排序方式：
                ASC：升序，默认的；DESC：降序。
            如果有多个排序条件，则当前边的条件值一样时，才会判断第二条件。

    4.分组查询:
        [where 条件] group by 分组字段 [having 条件];
            分组之后查询的字段：分组字段、聚合函数
            (将分组字段结果中相同内容作为一组，并且返回每组的第一条数据，所以单独分组没什么用处)
            where 和 having 的区别:
                (1) where 在分组group by之前进行限定，如果不满足条件，则不参与分组。
                    having在分组group by之后进行限定，如果不满足结果，则不会被查询出来.
                (2) where 后不可以跟聚合函数，having可以进行聚合函数的判断。

    5.分页查询
        limit 开始的索引,每页查询的条数;
            是一个MySQL"方言"

    6.多表查询
        笛卡尔积：两个集合A,B ，取这两个集合的所有组合情况。要完成多表查询，需要消除无用的数据

        (1)内连接查询：
		    1. 隐式内连接：使用where条件消除无用数据
		        	select                    select
                        列名列表                   t1.name, -- 员工表的姓名
                    from                          t1.gender,-- 员工表的性别
                        表名列表                   t2.name -- 部门表的名称
                    where....                 from
                                                  表1 t1,
                                                  表2 t2
                    			              where
				                                   t1.`dept_id` = t2.`id`;

		    2. 显式内连接：
                select 字段列表 from 表名1 [inner] join 表名2 on 条件

        (2)外链接查询：
            1. 左外连接：
                select 字段列表 from 表1 left [outer] join 表2 on 条件；
                    查询左表所有数据以及其交集部分。
                    用左边表的记录去匹配右边表的记录，如果符合条件的则显示；否则，显示 NULL
                    可以理解为：在内连接的基础上保证左表的数据全部显示
                        select 	t1.*,t2.`name` from 表1 t1 left join 表2 t2 on t1.`id` = t2.`id`;
            2. 右外连接：
                select 字段列表 from 表1 right [outer] join 表2 on 条件；
                    查询的是右表所有数据以及其交集部分。
                        select 	* from 表2 t2 right join 表1 t1 on t1.`id` = t2.`id`;

    7. 子查询：查询中嵌套查询子，子查询要使用括号
        (1)子查询的结果是单行单列的(一个数据)：
			    子查询可以作为条件，使用运算符去判断。 运算符： > >= < <= =
			        select * from 表1 where dept_id = (select id from dept where name='市场部');
		(2)子查询的结果是多行单列的(一列数据)：
			    子查询可以作为条件，使用运算符in来判断
			        select name from 表1 where id in (select t2.`id` from 表2 t2 where salary > 5000);
		(2)子查询的结果是多行多列的(一个表)：
			    子查询可以作为一张新表参与查询
			        select * from 表1 t1, (select * from 表2 where salary > 5000) e1 where t1.`id`= e1.`id`;






DCL：管理用户，授权(了解)，有专门的数据库管理员负责
	1. 管理用户
		1. 添加用户：
			* 语法：CREATE USER '用户名'@'主机名' IDENTIFIED BY '密码';
		2. 删除用户：
			* 语法：DROP USER '用户名'@'主机名';
		3. 修改用户密码：

			UPDATE USER SET PASSWORD = PASSWORD('新密码') WHERE USER = '用户名';
			UPDATE USER SET PASSWORD = PASSWORD('abc') WHERE USER = 'lisi';

			SET PASSWORD FOR '用户名'@'主机名' = PASSWORD('新密码');
			SET PASSWORD FOR 'root'@'localhost' = PASSWORD('123');

			* mysql中忘记了root用户的密码？
				1. cmd -- > net stop mysql 停止mysql服务
					* 需要管理员运行该cmd

				2. 使用无验证方式启动mysql服务： mysqld --skip-grant-tables
				3. 打开新的cmd窗口,直接输入mysql命令，敲回车。就可以登录成功
				4. use mysql;
				5. update user set password = password('你的新密码') where user = 'root';
				6. 关闭两个窗口
				7. 打开任务管理器，手动结束mysqld.exe 的进程
				8. 启动mysql服务
				9. 使用新密码登录。
		4. 查询用户：
			-- 1. 切换到mysql数据库
			USE myql;
			-- 2. 查询user表
			SELECT * FROM USER;

			* 通配符： % 表示可以在任意主机使用用户登录数据库

	2. 权限管理：
		1. 查询权限：
			-- 查询权限
			SHOW GRANTS FOR '用户名'@'主机名';
			SHOW GRANTS FOR 'lisi'@'%';

		2. 授予权限：
			-- 授予权限
			grant 权限列表 on 数据库名.表名 to '用户名'@'主机名';
			-- 给张三用户授予所有权限，在任意数据库任意表上

			GRANT ALL ON *.* TO 'zhangsan'@'localhost';
		3. 撤销权限：
			-- 撤销权限：
			revoke 权限列表 on 数据库名.表名 from '用户名'@'主机名';
			REVOKE UPDATE ON db3.`account` FROM 'lisi'@'%';

*/


public class MySQL基础 {
}
