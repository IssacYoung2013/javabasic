package com.interview.javabasic.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * author:  ywy
 * date:    2019-02-21
 * desc:
 */
public class NIOPlainEchoServer {
    public void serve(int port) throws IOException {
        System.out.println("Listening for connections on port " + port);
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket ss = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        // 将ServerSocket绑定到指定的端口里
        ss.bind(address);
        serverChannel.configureBlocking(false);
        Selector selector = Selector.open();
        // 将channel注册到Selector里，并说明让Selector关注的点，这里是关注建立连接这个事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            try {

                // 阻塞等待就绪的Channel，即没有与客户端建立连接前就一致轮询
                selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }
            // 获取Selector里所有就绪的SelectedKey实例，每将一个channel注册到一个selector就会产生一个Selector
            Set<SelectionKey> readKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                // 将就绪的SelectedKey从Selector移出，因为马上就要去处理它，防止重复执行
                iterator.remove();
                try {
                    // 若SelectKey处于Acceptable状态
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        // 接受客户端的连接
                        SocketChannel client = server.accept();
                        System.out.println("Accepted connection from : " + client);
                        client.configureBlocking(false);
                        // 向selector注册socketchannel,主要关注读写，并传入一个ByteBuffer实例读写缓存
                        client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                    }
                    // 若SelectedKey处于可读状态
                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        client.read(output);
                    }
                    // 若SelectedKey处于可写状态
                    if (key.isWritable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer output = (ByteBuffer) key.attachment();
                        output.flip();
                        // 将ByteBuffer里的数据写入channel里
                        client.write(output);
                        output.compact();
                    }
                } catch (IOException ex) {
                    key.cancel();
                    try {
                        key.channel().close();
                    } catch (IOException cex) {
                    }
                }
            }
        }
    }
}
