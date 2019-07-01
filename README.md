# [redis-cli](https://www.starryfei.top/2019/06/18/%E5%9F%BA%E4%BA%8ERESP%E5%AE%9E%E7%8E%B0Java-redis%E5%AE%A2%E6%88%B7%E7%AB%AF/ "redis-cli")
根据RESP （Redis Protocol specification）协议实现的redis java 客户端

#### 使用方法
```java
RedisCli cli = new RedisCli();
// RedisCli cli = new RedisCli("127.0.0.1",6379);
String result = cli.set("ab","cc");
System.out.println(result);
String get = cli.get("ab");
System.out.println(get);
```
