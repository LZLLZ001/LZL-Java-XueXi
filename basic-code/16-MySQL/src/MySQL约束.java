/*
约束的作用：对表中的数据进行限制，保证数据的正确性、有效性和完整性。

实际使用时大部分操作都可以通过可视化进行快速操作，不过因为比较简单，背背就行

分类：
	1. 主键约束：primary key
	2. 非空约束：not null
	3. 唯一约束：unique
	4. 外键约束：foreign key


1.非空约束：not null       值不能为null
           default ...    默认值为...
	1. 创建表时添加约束
		create table stu(
			id int not null, -- id为非空
			name varchar(20) default '小明' -- 默认为小明
		);
	2. 创建表完后，添加非空约束
		alter table stu modify id int not null; -- alter改变，modify修改
	3. 删除name的非空约束
		alter table stu modify id int;


2.唯一约束：unique，值不能重复
	1. 创建表时，添加唯一约束
		create table stu(
			id int unique -- 添加了唯一约束
		);
		注意：mysql中，唯一约束限定的列的值可以有多个null

		alter table stu modify id int unique;
		alter table stu drop index id;


3.主键约束：primary key  非空且唯一，一张表只能有一个字段为主键，用来唯一标识数据库中的每一条记录
	1. 在创建表时，添加主键约束
		create table stu(
			id int primary key,-- 给id添加主键约束
		);

        alter table stu modify id int primary key;
        alter table stu drop primary key;

	2. 数值类型自动增长：auto_increment
		create table stu(
			id int primary key auto_increment,-- 给id添加主键约束
		)[auto_increment=1000]; -- 默认开始值是1,修改默认开始值写上[]内内容

        alter table stu auto_increment = 2000; -- 创建好以后修改起始值
        alter table stu modify id int auto_increment; --添加自动增长
        alter table stu modify id int; -- 删除自动增长


4.外键约束：foreign key,让表于表产生关系，从而保证数据的正确性。
    外键：在从表中与主表主键对应的那一列（一对多）
    主表： 一方，用来约束别人的表
    从表： 多方，被别人约束的表
	1. 创建表时添加外键
        create table 表名(
            ....
            外键列
            constraint 外键名称 foreign key (外键列名称) references 主表名称(主表列名称)
        );      //constraint限制、约束；references参考、查询; 外键名称是一个任意取的名字

        alter table 表名 add constraint 外键名称 foreign key (外键字段名称) references 主表名称(主表列名称);
        alter table 表名 drop foreign key 外键名称;

    2. 级联操作：在修改和删除主表的主键时，同时更新或删除副表的外键值
        alter table 表名 add constraint 外键名称 foreign key (外键字段名称)
        references 主表名称(主表列名称) on update cascade;
            1. 添加级联：on update cascade
            2. 删除级联：on delete cascade



*/


public class MySQL约束 {
}
