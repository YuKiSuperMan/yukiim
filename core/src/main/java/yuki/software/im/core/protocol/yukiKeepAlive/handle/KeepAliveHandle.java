package yuki.software.im.core.protocol.yukiKeepAlive.handle;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import yuki.software.im.core.protocol.constant.MessageConst;
import yuki.software.im.core.protocol.selector.param.Request;
import yuki.software.im.core.protocol.selector.param.Response;

/**
 * @programN: yuki_im
 * @description: 心跳保活
 * @author: YuKi
 * @create: 2019-01-01 11:57
 * @email: 1040929773@qq.com
 */
public class KeepAliveHandle extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //说明是定时器任务(该任务以后会做优化 暂时引用源码)
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            if(event.state().equals(IdleState.ALL_IDLE)){
                //说明是读写任务触发了
                System.out.println("读写空闲");
                ctx.channel().writeAndFlush(MessageConst.PING);
            }
            if(event.state().equals(IdleState.READER_IDLE)){
                System.out.println("读空闲");
            }
            if(event.state().equals(IdleState.WRITER_IDLE)){
                System.out.println("写空闲");
                ctx.channel().close();
            }
        }
    }
}
