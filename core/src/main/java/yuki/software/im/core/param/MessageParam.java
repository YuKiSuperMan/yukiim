package yuki.software.im.core.param;

/**
 * @programN: yukiim
 * @description: 消息实体
 * @author: YuKi
 * @create: 2019-01-02 14:57
 * @email: 1040929773@qq.com
 */
public class MessageParam {

    /**
     * 协议类型 0->yuki_tcp 1->websocket 2->mqtt
     */
    private int protocolCode;
    /**
     * 消息类型 0->txt 1->二进制
     */
    private int messageCode;
    /**
     * 内容
     */
    private byte[] contentBytes;

    public int getProtocolCode() {
        return protocolCode;
    }

    public void setProtocolCode(int protocolCode) {
        this.protocolCode = protocolCode;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    public byte[] getContentBytes() {
        return contentBytes;
    }

    public void setContentBytes(byte[] contentBytes) {
        this.contentBytes = contentBytes;
    }
}
