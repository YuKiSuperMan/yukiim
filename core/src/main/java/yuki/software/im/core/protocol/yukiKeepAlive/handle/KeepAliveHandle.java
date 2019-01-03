package yuki.software.im.core.protocol.yukiKeepAlive.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;
import yuki.software.im.core.main.init.ServerInital;
import yuki.software.im.core.protocol.constant.MessageConst;

/**
 * @programN: yuki_im
 * @description: 心跳保活
 * @author: YuKi
 * @create: 2019-01-01 11:57
 * @email: 1040929773@qq.com
 */
public class KeepAliveHandle extends ChannelInboundHandlerAdapter {

    private static final Logger logger =  Logger.getLogger(ServerInital.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //说明是定时器任务(该任务以后会做优化 暂时引用源码)
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            if(event.state().equals(IdleState.ALL_IDLE)){
                logger.info("客户端产生读写空闲事件");
                ctx.channel().writeAndFlush(MessageConst.PING);
            }
            if(event.state().equals(IdleState.READER_IDLE)){
                logger.info("客户端产生读空闲事件");
            }
            if(event.state().equals(IdleState.WRITER_IDLE)){
                logger.info("客户端产生写空闲事件");
                ctx.channel().close();
            }
        }
    }
}
