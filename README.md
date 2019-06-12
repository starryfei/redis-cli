# redis-cli
根据RESP （Redis Protocol specification）协议实现的redis java 客户端

### #### 使用方法
```java
RedisCli cli = new RedisCli();
// RedisCli cli = new RedisCli("127.0.0.1",6379);
String result = cli.set("ab","cc");
System.out.println(result);
String get = cli.get("ab");
System.out.println(get);
```