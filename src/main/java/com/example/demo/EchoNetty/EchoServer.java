package com.example.demo.EchoNetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author lei.X
 * @date 2018/10/16
 */
public class EchoServer {

    private int port;

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws Exception{
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            ChannelFuture f = b.bind().sync();
            System.out.println(EchoServer.class.getSimpleName()+"start and listen on "+f.channel().localAddress());
            f.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }



    public static void main(String[] args) throws Exception{


        int port = 9998;
        new EchoServer(port).start();
    }





}
