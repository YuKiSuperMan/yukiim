package yuki.software.im.core.main.init;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.yuki.software.im.core.server.conf.ServerHandleRegister;

/**
 * @programN: yuki_im
 * @description: 服务器初始化
 * @author: YuKi
 * @create: 2019-01-01 15:46
 * @email: 1040929773@qq.com
 */
@Component
public class ServerInital implements ApplicationListener<ContextRefreshedEvent> {

    private int port = 8765;

    public void run(){
        EventLoopGroup bossGroup=new NioEventLoopGroup(1);
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        try {
            ServerBootstrap b=new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        public void initChannel(SocketChannel socketChannel){
                            ServerHandleRegister.register(socketChannel);
                        }
                    });
            ChannelFuture f=b.bind(port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.run();
    }
}
