package yuki.software.im.core.main.init;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;

/**
 * @programN: yukiim
 * @description:
 * @author: YuKi
 * @create: 2019-01-01 17:46
 * @email: 1040929773@qq.com
 */
public class YuKiServerInitializer implements ChannelHandler {

    private static final Logger logger =  Logger.getLogger(ServerInital.class);

    private boolean isOpenFireWall;

    public YuKiServerInitializer(boolean isOpenFireWall){
        this.isOpenFireWall = isOpenFireWall;
    }

    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if(channelHandlerContext.channel().isRegistered()){
            //初始化时 对其进行ip进行记录

        }
    }

    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {

    }

    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {

    }
}
