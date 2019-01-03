package yuki.software.im.core.memory;

import io.netty.channel.Channel;

public interface handle {

    /**
     * @Author YuKi
     * @Description:存入会话
     * @Date 15:14 2019/1/2
     * @Param
     * @return
     * @throws
     */

    void putChannel( Channel channel,Long key);

    Channel getChannel(int key);

}
