package yuki.software.im.core.memory.impl;

import io.netty.channel.Channel;
import yuki.software.im.core.memory.handle;

import java.util.HashMap;
import java.util.Map;

/**
 * @programN: yukiim
 * @description:
 * @author: YuKi
 * @create: 2019-01-02 15:19
 * @email: 1040929773@qq.com
 */
public class SampleHandle {

    public static final Map<Long,Channel> channelMap = new HashMap<Long,Channel>();

    public static void putChannel(Channel channel, Long key) {
        channelMap.put(key,channel);
    }

    public static Channel getChannel(int key) {
        return channelMap.get(key);
    }
}
