package com.starry.redis.cli.interfaces;

import com.starry.redis.cli.Client;
import com.starry.redis.cli.common.Common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: RedisCommandImpl
 * Description: TODO
 *
 * @author: starryfei
 * @date: 2019-06-11 18:55
 **/
public class RedisCommandImpl implements RedisCommand {
    private Client client;
    private byte[] read;
    private int count;

    public RedisCommandImpl(Client client){
        read = new byte[1024];
        this.client = client;
    }
    public RedisCommandImpl(){
    }

    /**
     * 协议
     * @param str
     * @return
     */
    private byte[] cover(String command, String... str){
        StringBuilder sb = new StringBuilder();
        sb.append(Common.REDIS_ARRAY);
        sb.append((str.length+1));
        sb.append(Common.REDIS_RN);
        sb.append(Common.RESIS_RESPONSE_BULK+command.length()+Common.REDIS_RN);
        sb.append(command+Common.REDIS_RN);
        for (String value: str
             ) {
            sb.append(Common.RESIS_RESPONSE_BULK+value.length()+Common.REDIS_RN);
            sb.append(value);
            sb.append(Common.REDIS_RN);
        }
        try {
            return sb.toString().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return sb.toString().getBytes();

        }

    }

    /**
     * 读取数据长度
     */
    private void readLength(){
        try {
            count = client.getInputStream().read(read);
            if(count == -1) {
                throw new Exception("read error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取响应的信息
     * @return
     */
    private String readResult(){
        readLength();

        StringBuilder bytes = new StringBuilder();
        for(int i =0; i<count; i++){
            byte b = read[i];
            bytes.append((char) b);
        }
//        String res = bytes.toString();

        return bytes.toString();
    }

    /**
     * 发送redis 协议
     * @param msg
     */
    private void sendMsg(byte[] msg){
        try {
            client.getOutputStream().write(msg);
            client.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String set(String key, String value) {
        byte[] bytes = cover("set",key,value);
        sendMsg(bytes);
        return readResult();
    }

    public String set(String key, String value, String nxxx, String expx, long time) {
        return null;
    }

    public String set(String key, String value, String nxxx) {

        return null;
    }

    public String get(String key) {
        byte[] bytes = cover("get",key);
        sendMsg(bytes);
        return readResult();
    }

    public Boolean exists(String key) {

        return null;
    }

    public Long persist(String key) {
        return null;
    }

    public String type(String key) {
        return null;
    }

    public Long expire(String key, int seconds) {
        return null;
    }

    public Long pexpire(String key, long milliseconds) {
        return null;
    }

    public Long expireAt(String key, long unixTime) {
        return null;
    }

    public Long pexpireAt(String key, long millisecondsTimestamp) {
        return null;
    }

    public Long ttl(String key) {
        return null;
    }

    public Long pttl(String key) {
        return null;
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
