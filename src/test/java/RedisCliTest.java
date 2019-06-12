import com.starry.redis.cli.RedisCli;
import com.starry.redis.cli.interfaces.RedisCommandImpl;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ClassName: RedisCliTest
 * Description: TODO
 *
 * @author: starryfei
 * @date: 2019-06-11 17:43
 **/

public class RedisCliTest {
    RedisCli cli;
    @Before
    public void init(){
        cli = new RedisCli();

    }

    @Test
    public void sendMsg() throws IOException {
        Socket socket = new Socket("127.0.0.1", 6379);
        socket.setSoTimeout(10);
        InputStream stream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        String data = "*3\r\n$3\r\nSET\r\n$5\r\nmykey\r\n$7\r\nmyvalue\r\n";
        outputStream.write(data.getBytes());
        String get = "*2\r\n$3\r\nget\r\n$5\r\nmykey\r\n";
        String list = "*4\r\n$5\r\nlpush\r\n$1\r\nc\r\n$2\r\ncc\r\n$2\r\nbb\r\n";
        String getlist ="";
        outputStream.write(get.getBytes());
        outputStream.write(list.getBytes());
        outputStream.flush();
        byte[] b = new byte[1024];
        stream.read(b);
        System.out.println(b);

        System.out.println(new String(b));

    }

    @Test
    public void setTest(){
        RedisCommandImpl redisCommand = new RedisCommandImpl();
        redisCommand.set("aa","cc");
    }
    @Test
    public void clent(){
        String result = cli.set("ab","cc");
        System.out.println(result);

        String get = cli.get("ab");
        System.out.println(get);
    }
    @Test
    public void jedisTest(){
        Jedis jedis = new Jedis();
        String res = jedis.set("ab","aa");
        System.out.println(res);
}
}
