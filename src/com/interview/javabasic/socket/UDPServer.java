package com.interview.javabasic.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * author:  ywy
 * date:    2019-02-14
 * desc:
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {

        // 服务端接受客户端发送的数据报
        DatagramSocket socket = new DatagramSocket(65001);
        byte[] buff = new byte[100]; // 存储从客户端接受到的内容
        DatagramPacket packet = new DatagramPacket(buff,buff.length);
        // 接受客户端发送的内容，并将被容封装进DatagramPacket对象中
        socket.receive(packet);;

        // 从 DatagramPacket对象中获取真正存储的数据
        byte[] data = packet.getData();
        // 将数据从二进制转换成字符串形式
        String content = new String(data,0,packet.getLength());
        System.out.println(content);
        // 将要发送给客户端的数据转换成二进制
        byte[] sendContent = String.valueOf(content.length()).getBytes();

        // 服务端给客户端发送数据报
        // 从DatagramPacket对象中获取数据的来源地址与端口号
        DatagramPacket packetToClient = new DatagramPacket(sendContent,sendContent.length,packet.getAddress(),packet.getPort());
        socket.send(packetToClient); // 发送数据给客户端

    }
}
