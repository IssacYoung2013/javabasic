package com.interview.javabasic.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * author:  ywy
 * date:    2019-02-14
 * desc:
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {

        // 创建socket，并指定连接是本机的端口号为65000的服务器socket
        Socket socket = new Socket("127.0.0.1",65000);

        // 获取输出流
        OutputStream os = socket.getOutputStream();

        // 获取输入流
        InputStream is = socket.getInputStream();

        // 将要传递的给server的字符串参数转换成byte数组，并将数组写入输出流中
        os.write(new String("hello,world").getBytes());
        int ch = 0;
        byte[] buff = new byte[1024];
        // buffer 主要用来读取输入的内容，存成byte数组，ch主要用来获取读取数组的长度
        ch = is.read(buff);
        // 将接受流的byte数组转换成字符串，这里是从服务端发回来的字符串参数的长度
        String content = new String(buff,0,ch);
        System.out.println(content);
        is.close();
        os.close();
        socket.close();

    }
}
