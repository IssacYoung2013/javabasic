package com.interview.javabasic.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 *
 * author:  ywy
 * date:    2019-02-21
 * desc:
 */
public class AIOPlainEchoServer {
    public void serve(int port) throws IOException {
        System.out.println("Listening for connections on port " + port);
        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(port);
        // 将ServerSocket绑定到指定的端口里
        serverChannel.bind(address);
        final CountDownLatch latch = new CountDownLatch(1);
        // 开始接受新的客户端请求，一旦一个客户端请求被接收
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                // 一旦处理完成，再次接受新的客户端的请求
                serverChannel.accept(null,this);
                ByteBuffer buffer = ByteBuffer.allocate(100);
                // 在channel里植入一个读操作EchoCompletionHandler，一旦buffer有数据写入，EchoCompletionHandler就会被唤醒
                result.read(buffer,buffer,new EchoCompletionHandler(result));
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                try {
                    // 若遇到异常，则关闭channel
                    serverChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    latch.countDown();
                }
            }
        });

        try {
            latch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private final class EchoCompletionHandler implements CompletionHandler<Integer,ByteBuffer> {

        private final AsynchronousSocketChannel channel;

        public EchoCompletionHandler(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            attachment.flip();
            // 在channel里植入一个读操作CompletionHandler,一旦channel有数据写入，CompletionHandler 便会被唤醒
            channel.write(attachment, attachment, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if(attachment.hasRemaining()) {
                        channel.write(attachment,attachment,this);
                    } else {
                        attachment.compact();
                        channel.read(attachment,attachment,EchoCompletionHandler.this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {

                    }
                }
            });
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {

        }
    }
}
