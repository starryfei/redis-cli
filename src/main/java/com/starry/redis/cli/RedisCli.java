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

    public Long persist(String key) {
        return null;
    }

    public String type(String key) {
        return null;
    }

    public Long expire(String key, int seconds) {
        return redisCommand.expire(key,seconds);
    }

    public Long pexpire(String key, long milliseconds) {
        return redisCommand.pexpire(key,milliseconds);
    }

    public Long expireAt(String key, long unixTime) {
        return redisCommand.expireAt(key,unixTime);
    }

    public Long pexpireAt(String key, long millisecondsTimestamp) {
        return redisCommand.pexpireAt(key,millisecondsTimestamp);
    }

    public Long ttl(String key) {
        return redisCommand.ttl(key);
    }

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

    public Long setrange(String key, long offset, String value) {
        return null;
    }

    public String getrange(String key, long startOffset, long endOffset) {
        return null;
    }

    public String getSet(String key, String value) {
        return null;
    }

    public Long setnx(String key, String value) {
        return null;
    }

    public String setex(String key, int seconds, String value) {
        return null;
    }

    public String psetex(String key, long milliseconds, String value) {
        return null;
    }

    public Long decrBy(String key, long integer) {
        return null;
    }

    public Long decr(String key) {
        return null;
    }

    public Long incrBy(String key, long integer) {
        return null;
    }

    public Double incrByFloat(String key, double value) {
        return null;
    }

    public Long incr(String key) {
        return null;
    }

    public Long append(String key, String value) {
        return null;
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
