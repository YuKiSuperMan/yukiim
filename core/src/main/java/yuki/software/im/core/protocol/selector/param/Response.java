package yuki.software.im.core.protocol.selector.param;

/**
 * @programN: yuki_im_client
 * @description:响应
 * @author: YuKi
 * @create: 2018-12-31 15:20
 * @email: 1040929773@qq.com
 */
public class Response {

    private String key;
    private Object responseObj;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getResponseObj() {
        return responseObj;
    }

    public void setResponseObj(Object responseObj) {
        this.responseObj = responseObj;
    }
}
