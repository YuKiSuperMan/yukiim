package yuki.software.im.core.test.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @programN: yukiim
 * @description: 一个简单的处理
 * @author: YuKi
 * @create: 2018-11-12 21:50
 * @email: 1040929773@qq.com
 */
public class SimpleServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.writeAndFlush("Ok\r\n");
    }
}
