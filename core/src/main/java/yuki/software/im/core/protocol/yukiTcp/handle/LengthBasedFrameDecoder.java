package yuki.software.im.core.protocol.yukiTcp.handle;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @programN: yukiim
 * @description:粘包拆包解码器
 * @author: YuKi
 * @create: 2019-01-02 20:19
 * @email: 1040929773@qq.com
 */
public class LengthBasedFrameDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {



    }

}
