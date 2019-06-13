package com.starry.redis.cli;

import com.starry.redis.cli.interfaces.BaseCommand;
import com.starry.redis.cli.interfaces.RedisCommandImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: RedisCli
 * Description: TODO
 *
 * @author: starryfei
 * @date: 2019-06-11 14:14
 **/
public class RedisCli extends Client implements BaseCommand {

    RedisCommandImpl redisCommand ;

    public RedisCli() {
        super();
        redisCommand = new RedisCommandImpl(this);
    }


    public RedisCli(String ip, int port) {
        super(ip,port);
        redisCommand = new RedisCommandImpl(this);
    }


    public String set(String key, String value) {
        return redisCommand.set(key,value);
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        return redisCommand.set(key, value, nxxx, expx, time);
    }

    public String set(String key, String value, String nxxx) {
        return redisCommand.set(key,value,nxxx);
    }

    public String get(String key) {
        return redisCommand.get(key);
    }

    public Boolean exists(String key) {
        return redisCommand.exists(key);
    }

    /**
     * Redis PERSIST 命令用于移除给定 key 的过期时间，使得 key 永不过期
     * @param key
     * @return
     */
    public Long persist(String key) {
        return redisCommand.persist(key);
    }

    public String type(String key) {
        return redisCommand.type(key);
    }

    /**
     * 秒为单位设置 key 的生存时间
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(String key, int seconds) {
        return redisCommand.expire(key,seconds);
    }

    /**
     * 毫秒为单位设置 key 的生存时间
     * @param key
     * @param milliseconds
     * @return
     */
    public Long pexpire(String key, long milliseconds) {
        return redisCommand.pexpire(key,milliseconds);
    }

    /**
     * 秒为单位设置 key 的过期 unix 时间戳
     * @param key
     * @param unixTime
     * @return
     */
    public Long expireAt(String key, long unixTime) {
        return redisCommand.expireAt(key,unixTime);
    }

    /**
     * 毫秒为单位设置 key 的过期 unix 时间戳
     * @param key
     * @param millisecondsTimestamp
     * @return
     */
    public Long pexpireAt(String key, long millisecondsTimestamp) {
        return redisCommand.pexpireAt(key,millisecondsTimestamp);
    }

    /**
     * 返回剩余时间，单位s
     * @param key
     * @return
     */
    public Long ttl(String key) {
        return redisCommand.ttl(key);
    }
    /**
     * 返回剩余时间，单位ms
     * @param key
     * @return
     */
    public Long pttl(String key) {
        return redisCommand.pttl(key);
    }

    public Boolean setbit(String key, long offset, boolean value) {
        return null;
    }

    public Boolean setbit(String key, long offset, String value) {
        return null;
    }

    public Boolean getbit(String key, long offset) {
        return null;
    }

    /**
     * 从偏移量 offset 开始， 用 value 参数覆写(overwrite)键 key 储存的字符串值
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public Long setrange(String key, long offset, String value) {
        return redisCommand.setrange(key,offset,value);
    }

    /**
     * 返回键 key 储存的字符串值的指定部分， 字符串的截取范围由 start 和 end 两个偏移量决定 (包括 start 和 end 在内)
     * @param key
     * @param startOffset
     * @param endOffset
     * @return
     */
    public String getrange(String key, long startOffset, long endOffset) {
        return redisCommand.getrange(key,startOffset,endOffset);
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
     *
     * 当 key 存在但不是字符串类型时，返回一个错误。
     * @param key
     * @param value
     * @return
     */
    public String getSet(String key, String value) {
        return redisCommand.getSet(key,value);
    }

    /**
     * 只在键 key 不存在的情况下， 将键 key 的值设置为 value 。
     * 若键 key 已经存在， 则 SETNX 命令不做任何动作
     * @param key
     * @param value
     * @return
     */
    public Long setnx(String key, String value) {
        return redisCommand.setnx(key,value);
    }

    /**
     * 将键 key 的值设置为 value ， 并将键 key 的生存时间设置为 seconds 秒钟。
     * 如果键 key 已经存在， 那么 SETEX 命令将覆盖已有的值
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public String setex(String key, int seconds, String value) {
        return redisCommand.setex(key,seconds,value);
    }
    /**
     * 将键 key 的值设置为 value ， 并将键 key 的生存时间设置为 milliseconds 秒钟。
     * 如果键 key 已经存在， 那么 SETEX 命令将覆盖已有的值
     * @param key
     * @param milliseconds
     * @param value
     * @return
     */
    public String psetex(String key, long milliseconds, String value) {
        return redisCommand.psetex(key,milliseconds,value);
    }

    /**
     * 将键 key 储存的整数值减去减量 decrement 。
     * 如果键 key 不存在， 那么键 key 的值会先被初始化为 0 ， 然后再执行 DECRBY 命令。
     * 如果键 key 储存的值不能被解释为数字， 那么 DECRBY 命令将返回一个错误
     * @param key
     * @param integer
     * @return
     */
    public Long decrBy(String key, long integer) {
        return redisCommand.decrBy(key,integer);
    }

    /**
     * 为键 key 储存的数字值减去一。
     * 如果键 key 不存在， 那么键 key 的值会先被初始化为 0 ， 然后再执行 DECR 操作。
     * 如果键 key 储存的值不能被解释为数字， 那么 DECR 命令将返回一个错误
     * @param key
     * @return
     */
    public Long decr(String key) {
        return redisCommand.decr(key);
    }

    /**
     为键 key 储存的数字值加上增量 increment 。
     如果键 key 不存在， 那么键 key 的值会先被初始化为 0 ， 然后再执行 INCRBY 命令。
     如果键 key 储存的值不能被解释为数字， 那么 INCRBY 命令将返回一个错误。
     * @param key
     * @param integer
     * @return
     * @param key
     * @param integer
     * @return
     */
    public Long incrBy(String key, long integer) {
        return redisCommand.incrBy(key,integer);
    }

    /**
     * 为键 key 储存的值加上浮点数增量 increment 。
     *
     * 如果键 key 不存在， 那么 INCRBYFLOAT 会先将键 key 的值设为 0 ， 然后再执行加法操作。
     *
     * 如果命令执行成功， 那么键 key 的值会被更新为执行加法计算之后的新值， 并且新值会以字符串的形式返回给调用者。
     * @param key
     * @param value
     * @return
     */
    public Double incrByFloat(String key, double value) {
        return redisCommand.incrByFloat(key,value);
    }

    /**
     * 为键 key 储存的数字值加上一。
     *
     * 如果键 key 不存在， 那么它的值会先被初始化为 0 ， 然后再执行 INCR 命令。
     *
     * 如果键 key 储存的值不能被解释为数字， 那么 INCR 命令将返回一个错误。
     * @param key
     * @return
     */
    public Long incr(String key) {
        return redisCommand.incr(key);
    }

    /**
     * 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。
     *
     * 如果 key 不存在， APPEND 就简单地将给定 key 设为 value ，就像执行 SET key value 一样
     * @param key
     * @param value
     * @return
     */
    public Long append(String key, String value) {
        return redisCommand.append(key,value);
    }

    public String substr(String key, int start, int end) {
        return null;
    }

    public Long hset(String key, String field, String value) {
        return null;
    }

    public String hget(String key, String field) {
        return null;
    }

    public Long hsetnx(String key, String field, String value) {
        return null;
    }

    public String hmset(String key, Map<String, String> hash) {
        return null;
    }

    public List<String> hmget(String key, String... fields) {
        return null;
    }

    public Long hincrBy(String key, String field, long value) {
        return null;
    }

    public Double hincrByFloat(String key, String field, double value) {
        return null;
    }

    public Boolean hexists(String key, String field) {
        return null;
    }

    public Long hdel(String key, String... field) {
        return null;
    }

    public Long hlen(String key) {
        return null;
    }

    public Set<String> hkeys(String key) {
        return null;
    }

    public List<String> hvals(String key) {
        return null;
    }

    public Map<String, String> hgetAll(String key) {
        return null;
    }

    public Long rpush(String key, String... string) {
        return null;
    }

    public Long lpush(String key, String... string) {
        return null;
    }

    public Long llen(String key) {
        return null;
    }

    public List<String> lrange(String key, long start, long end) {
        return null;
    }

    public String ltrim(String key, long start, long end) {
        return null;
    }

    public String lindex(String key, long index) {
        return null;
    }

    public String lset(String key, long index, String value) {
        return null;
    }

    public Long lrem(String key, long count, String value) {
        return null;
    }

    public String lpop(String key) {
        return null;
    }

    public String rpop(String key) {
        return null;
    }

    public Long sadd(String key, String... member) {
        return null;
    }

    public Set<String> smembers(String key) {
        return null;
    }

    public Long srem(String key, String... member) {
        return null;
    }

    public String spop(String key) {
        return null;
    }

    public Set<String> spop(String key, long count) {
        return null;
    }

    public Long scard(String key) {
        return null;
    }

    public Boolean sismember(String key, String member) {
        return null;
    }

    public String srandmember(String key) {
        return null;
    }

    public List<String> srandmember(String key, int count) {
        return null;
    }

    public Long strlen(String key) {
        return null;
    }

    public Long zadd(String key, double score, String member) {
        return null;
    }

    public Long zadd(String key, Map<String, Double> scoreMembers) {
        return null;
    }

    public Set<String> zrange(String key, long start, long end) {
        return null;
    }

    public Long zrem(String key, String... member) {
        return null;
    }

    public Double zincrby(String key, double score, String member) {
        return null;
    }

    public Long zrank(String key, String member) {
        return null;
    }

    public Long zrevrank(String key, String member) {
        return null;
    }

    public Set<String> zrevrange(String key, long start, long end) {
        return null;
    }

    public Long zcard(String key) {
        return null;
    }

    public Double zscore(String key, String member) {
        return null;
    }

    public List<String> sort(String key) {
        return null;
    }

    public Long zcount(String key, double min, double max) {
        return null;
    }

    public Long zcount(String key, String min, String max) {
        return null;
    }

    public Set<String> zrangeByScore(String key, double min, double max) {
        return null;
    }

    public Set<String> zrangeByScore(String key, String min, String max) {
        return null;
    }

    public Set<String> zrevrangeByScore(String key, double max, double min) {
        return null;
    }

    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        return null;
    }

    public Set<String> zrevrangeByScore(String key, String max, String min) {
        return null;
    }

    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        return null;
    }

    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        return null;
    }

    public Long zremrangeByRank(String key, long start, long end) {
        return null;
    }

    public Long zremrangeByScore(String key, double start, double end) {
        return null;
    }

    public Long zremrangeByScore(String key, String start, String end) {
        return null;
    }

    public Long zlexcount(String key, String min, String max) {
        return null;
    }

    public Set<String> zrangeByLex(String key, String min, String max) {
        return null;
    }

    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        return null;
    }

    public Set<String> zrevrangeByLex(String key, String max, String min) {
        return null;
    }

    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        return null;
    }

    public Long zremrangeByLex(String key, String min, String max) {
        return null;
    }

    public Long lpushx(String key, String... string) {
        return null;
    }

    public Long rpushx(String key, String... string) {
        return null;
    }

    public List<String> blpop(int timeout, String key) {
        return null;
    }

    public List<String> brpop(int timeout, String key) {
        return null;
    }

    public Long del(String key) {
        return null;
    }
}
