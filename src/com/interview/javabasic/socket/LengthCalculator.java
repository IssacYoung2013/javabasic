package com.interview.javabasic.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * author:  ywy
 * date:    2019-02-14
 * desc:
 */
public class LengthCalculator extends Thread {

    // 以socket为成员变量
    private Socket socket;

    public LengthCalculator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            // 获取socket输出流
            OutputStream os = socket.getOutputStream();
            // 获取socket输入流
            InputStream is = socket.getInputStream();
            int ch = 0;
            byte[] buff = new byte[1024];
            // buff 主要用来读取输入的内容，存成byte数组，ch主要用来获取数组的长度
            ch = is.read(buff);
            // 将接受流的byte数组转换成字符串，这里获取的内容是客户端发送过来的字符串
            String content = new String(buff,0,ch);
            System.out.println(content);
            // 往输出流里写入获得的字符串的长度，回发给客户端
            os.write(String.valueOf(content.length()).getBytes());
            // 不要忘记关闭输入输出流以及socket
            is.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
