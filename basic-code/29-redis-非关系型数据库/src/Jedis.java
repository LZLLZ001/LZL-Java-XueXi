/*
Jedis: 一款java操作redis数据库的工具（类似于JDBC）.
    1. 下载jedis的jar包
    2. 获取连接
        Jedis jedis = new Jedis("localhost",6379);//如果使用空参构造，默认值 "localhost",6379端口
    3. 操作
        jedis.set("username","zhangsan");
    4. 关闭连接
        jedis.close();


Jedis操作各种redis中的数据结构
    1) 字符串类型 string
        set(key,value)
        get(key)

    2) 哈希类型 hash ： map格式
        hset(key,field,value)
        hget(key,field) :获取指定的field对应的值
        hgetAll(key): 获取这个key对应的整个map中的数据
	        Map<String, String> key = jedis.hgetAll("key");

    3) 列表类型 list ： linkedlist格式。支持重复元素
        lpush / rpush(key,value1,value1...)   从左/右将元素加入列表
        lpop / rpop(key)     删除列表最左/右边的元素，并将元素返回
        lrange(key,start,end) : 范围获取
    4) 集合类型 set  ： 不允许重复元素
        sadd(key,value1,value1...)
        smembers(key):获取所有元素
    5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序
        zadd(key,score,value)  //score用于由大到小排序
        zrange(key,start,end,)  //end赋值-1代表所有


jedis连接池： JedisPool
    * 使用：
        1. 创建JedisPool连接池对象
        2. 调用方法 getResource()方法获取Jedis连接
            //0.创建一个配置对象
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(50);
            config.setMaxIdle(10);

            //1.创建Jedis连接池对象
            JedisPool jedisPool = new JedisPool(config,"localhost",6379);
            //2.获取连接
            Jedis jedis = jedisPool.getResource();
            //3. 使用
            jedis.set("hehe","heihei");
            //4. 关闭 归还到连接池中
		    jedis.close();

    * 连接池工具类
			public class JedisPoolUtils {

			    private static JedisPool jedisPool;

			    static{
			        //读取配置文件
			        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
			        //创建Properties对象
			        Properties pro = new Properties();
			        //关联文件
			        try {
			            pro.load(is);
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        //获取数据，设置到JedisPoolConfig中
			        JedisPoolConfig config = new JedisPoolConfig();
			        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
			        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

			        //初始化JedisPool
			        jedisPool = new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("port")));
                }

			     * 获取连接方法
                public static Jedis getJedis(){
                        return jedisPool.getResource();
                }
          }

*/




public class Jedis {
}
