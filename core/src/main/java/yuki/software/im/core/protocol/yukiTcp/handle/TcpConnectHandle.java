package yuki.software.im.core.protocol.yukiTcp.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @programN: yukiim
 * @description:
 * @author: YuKi
 * @create: 2019-01-02 15:03
 * @email: 1040929773@qq.com
 */
public class TcpConnectHandle extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];



        super.channelRead(ctx, msg);
    }

    public static void main(String[] args) {
        byte a = -12;
    }
}
