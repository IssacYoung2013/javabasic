package com.interview.javabasic.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * author:  ywy
 * date:    2019-02-14
 * desc:
 */
public class TCPServer {

    public static void main(String[] args) throws IOException {

        // 创建Socket,并将socket绑定65000端口
        ServerSocket ss = new ServerSocket(65000);

        // 自旋，使得socket一直等待并处理客户端发送过来的请求
        while (true) {

            // 监听65000端口，直到客户端返回连接信息后才返回
            Socket socket = ss.accept();

            // 获取客户端的请求后，执行相关业务逻辑
            new LengthCalculator(socket).start();
        }
    }
}
