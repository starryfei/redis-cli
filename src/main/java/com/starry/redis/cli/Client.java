package com.starry.redis.cli;

import com.starry.redis.cli.common.Common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ClassName: Client
 * Description: TODO
 *
 * @author: starryfei
 * @date: 2019-06-11 17:56
 **/
public class Client {

    private String ip;
    private int port;
    private Socket socket;
    private OutputStream outputStream;

    public Socket getSocket() {
        return socket;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    private InputStream inputStream;


    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
        connent();
    }

    public Client(){
        this.ip = Common.LOCAL_IP;
        this.port = Common.LOCAL_PORT;
        connent();
    }

    public String getIp() {
        return ip;
    }


    public int getPort() {
        return port;
    }

    public void connent(){
        try {
            socket = new Socket(ip,port);
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
