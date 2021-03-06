package com.starry.redis.cli.interfaces;

import com.starry.redis.cli.Client;
import com.starry.redis.cli.common.Common;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
        System.out.println(sb.toString());
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
            if(b !='\r' && b != '\n') {
                bytes.append((char) b);
            }
        }
        String res = bytes.toString();
        res.replaceAll(Common.REDIS_RN,"");
//        System.out.println(res);/
        return res;
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


    /**
     * set cc va EX 13 NX
     * @param key
     * @param value
     * @param nxxx
     * @param expx
     * @param time
     * @return
     */
    public String set(String key, String value, String nxxx, String expx, long time) {
        byte[] bytes = cover("set",key,value,expx,String.valueOf(time),nxxx);
        sendMsg(bytes);
        return readResult();
    }

    public String set(String... args) {
        byte[] bytes = cover("set",args);
        sendMsg(bytes);
        return readResult();
    }

    public String get(String key) {
        byte[] bytes = cover("get",key);
        sendMsg(bytes);
        return readResult();
    }

    public Boolean exists(String key) {
        byte[] bytes = cover("exists",key);
        sendMsg(bytes);
        String res = readResult();
        return res.startsWith(":0");
    }

    public Long persist(String key) {
        byte[] bytes = cover("persist",key);
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public String type(String key) {
        byte[] bytes = cover("type",key);
        sendMsg(bytes);
        String res = readResult();
        return  res;
    }

    public Long expire(String key, int seconds) {
        byte[] bytes = cover("expire",key, String.valueOf(seconds));
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Long pexpire(String key, long milliseconds) {
        byte[] bytes = cover("pexpire",key, String.valueOf(milliseconds));
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Long expireAt(String key, long unixTime) {
        byte[] bytes = cover("expireat",key, String.valueOf(unixTime));
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Long pexpireAt(String key, long millisecondsTimestamp) {
        byte[] bytes = cover("pexpireat",key, String.valueOf(millisecondsTimestamp));
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Long ttl(String key) {
        byte[] bytes = cover("ttl",key);
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Long pttl(String key) {
        byte[] bytes = cover("pttl",key);
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
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
        byte[] bytes = cover("setrange",key, String.valueOf(offset), value);
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public String getrange(String key, long startOffset, long endOffset) {
        byte[] bytes = cover("getrange",key,String.valueOf(startOffset),String.valueOf(endOffset));
        sendMsg(bytes);
        String res = readResult();
        return  res;
    }

    public String getSet(String key, String value) {
        byte[] bytes = cover("getset",key,value);
        sendMsg(bytes);
        String res = readResult();
        return  res;
    }

    public Long setnx(String key, String value) {
        byte[] bytes = cover("setnx",key,value);
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public String setex(String key, int seconds, String value) {
        byte[] bytes = cover("setex",key,String.valueOf(seconds), value);
        sendMsg(bytes);
        String res = readResult();
        return res;
    }

    public String psetex(String key, long milliseconds, String value) {
        byte[] bytes = cover("psetex",key,String.valueOf(milliseconds), value);
        sendMsg(bytes);
        String res = readResult();
        return res;
    }

    public Long decrBy(String key, long integer) {
        byte[] bytes = cover("descby",key,String.valueOf(integer));
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Long decr(String key) {
        byte[] bytes = cover("decr",key);
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Long incrBy(String key, long integer) {
        byte[] bytes = cover("incrby",key,String.valueOf(integer));
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Double incrByFloat(String key, double value) {
        byte[] bytes = cover("incrbyfloat",key,String.valueOf(value));
        sendMsg(bytes);
        String res = readResult();
        return Double.valueOf(res.replaceAll("\\:",""));
    }

    public Long incr(String key) {
        byte[] bytes = cover("incr",key);
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
    }

    public Long append(String key, String value) {
        byte[] bytes = cover("append",key, value);
        sendMsg(bytes);
        String res = readResult();
        return Long.valueOf(res.replaceAll("\\:",""));
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
