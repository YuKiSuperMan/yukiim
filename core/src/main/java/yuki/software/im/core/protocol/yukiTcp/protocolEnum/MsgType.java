package yuki.software.im.core.protocol.yukiTcp.protocolEnum;

public enum MsgType {

    TEXT_MSG(0,"文本消息"),         //普通文本消息
    BINARY_MSG(1,"二进制消息"),     //二进制消息  获取到该消息 会将该消息转换成 语音或者图片
    CLOSE_MSG(8,"关闭连接"),       //该类消息为直接关闭连接消息
    PING_MSG(9,"ping消息"),       //ping消息为  客户端主动ping 服务端
    PONG_MSG(10,"pong消息"),      //pong消息为  服务器主动ping 客户端 客户端所做响应
    ;

    private int code;
    private String title;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    MsgType(int code, String title){
        this.code = code;
        this.title = title;
    }

}
