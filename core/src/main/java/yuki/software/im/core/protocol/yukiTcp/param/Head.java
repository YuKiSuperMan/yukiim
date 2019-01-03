package yuki.software.im.core.protocol.yukiTcp.param;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @programN: yukiim
 * @description:
 * @author: YuKi
 * @create: 2019-01-02 16:15
 * @email: 1040929773@qq.com
 */
public class Head {

    ////////////////////////////////////  1111  1111



    /**
     * 第四位到第七位
     */
    private static short MSGTYPE_TEXT = 0b11110001;
    private static short MSGTYPE_BIT = 0b11110010;
    private static short MSGTYPE_DISCONNECT = 0b11110011;
    private static short MSGTYPE_PING = 0b11110100;
    private static short MSGTYPE_PONG = 0b11110101;

    /**
     *第二位
     */
    private static short IS_MSG_LENGHT = 0b11111111;
    private static short NO_MSG_LENGHT = 0b10111111;





    public static void main(String[] args) {
        short a = 0b11111111;
        byte b = (byte)a;
        System.out.println(b);

    }



}
