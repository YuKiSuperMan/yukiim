package yuki.software.im.core.protocol.yukiTcp.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @programN: yukiim
 * @description:粘包拆包编码器
 * @author: YuKi
 * @create: 2019-01-02 20:10
 * @email: 1040929773@qq.com
 */
public class LengthBasedFrameEncoder extends MessageToByteEncoder {



    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {



    }

}
