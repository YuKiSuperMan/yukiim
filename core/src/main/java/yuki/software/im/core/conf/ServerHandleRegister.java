package yuki.software.im.core.conf;

import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import yuki.software.im.core.protocol.yukiKeepAlive.handle.KeepAliveHandle;

import java.util.concurrent.TimeUnit;

/**
 * @programN: yuki_im
 * @description: 服务处理器注册
 * @author: YuKi
 * @create: 2019-01-01 11:51
 * @email: 1040929773@qq.com
 */
public class ServerHandleRegister {



    public static void register(SocketChannel socketChannel){
        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(65535, Delimiters.lineDelimiter()[0]));
        socketChannel.pipeline().addLast(new StringDecoder());
        socketChannel.pipeline().addLast(new IdleStateHandler(6,4,2, TimeUnit.SECONDS));
        socketChannel.pipeline().addLast(new KeepAliveHandle());
        socketChannel.pipeline().addLast(new StringEncoder());
    }

}
