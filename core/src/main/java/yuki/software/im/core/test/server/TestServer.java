package yuki.software.im.core.test.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import yuki.software.im.core.test.handle.SimpleServerHandler;

/**
 * @programN: yukiim
 * @description: 测试服务器
 * @author: YuKi
 * @create: 2018-11-12 21:30
 * @email: 1040929773@qq.com
 */
public class TestServer {

    /**
     * @Author YuKi
     * @Description //TODO 测试服务器启动方法
     * @Date 21:31 2018/11/12
     * @Param 
     * @return 
     * @throws 
     */
    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup parentGroup =  new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();
        //初始化线程池和服务器属性
        serverBootstrap.group(parentGroup,childGroup);
        serverBootstrap.option(ChannelOption.SO_BACKLOG,128)
                .childOption(ChannelOption.SO_KEEPALIVE,false)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(65535, Delimiters.lineDelimiter()[0]));
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new SimpleServerHandler());
                        socketChannel.pipeline().addLast(new StringEncoder());
                    }
                });
        ChannelFuture channelFuture = serverBootstrap.bind(6666).sync();
        channelFuture.channel().closeFuture().sync();
    }

}
