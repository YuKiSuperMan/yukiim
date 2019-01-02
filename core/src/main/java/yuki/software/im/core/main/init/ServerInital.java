package yuki.software.im.core.main.init;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @programN: yuki_im
 * @description: 服务器初始化
 * @author: YuKi
 * @create: 2019-01-01 15:46
 * @email: 1040929773@qq.com
 */
@Component
public class ServerInital implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger =  Logger.getLogger(ServerInital.class);

    @Value("${server.port}")
    private int port;
    @Value("${server.host}")
    private String host;
    @Value("${server.isOpenFireWall}")
    private boolean isOpenFireWall;
    @Value("${server.bossGroupSize}")
    private int bossGroupSize;

    public void run(){
        EventLoopGroup bossGroup=new NioEventLoopGroup(bossGroupSize);
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        try {
            ServerBootstrap b=new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new YuKiServerInitializer(isOpenFireWall));
            logger.debug("绑定监听中...");
            ChannelFuture f=b.bind(host,port).sync();
            logger.debug("服务器启动成功...");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            logger.error(e,e);
        } finally{
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("load port = " + port + ",load host = " + host +",load isOpenFireWall = " + isOpenFireWall );
        this.run();
    }
}
