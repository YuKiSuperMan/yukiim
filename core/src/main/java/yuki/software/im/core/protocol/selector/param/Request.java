package yuki.software.im.core.protocol.selector.param;

import java.util.UUID;

/**
 * @programN: yuki_im_client
 * @description: 请求
 * @author: YuKi
 * @create: 2018-12-31 15:14
 * @email: 1040929773@qq.com
 */
public  class Request {

    private String key;
    private Object requestObj;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getRequestObj() {
        return requestObj;
    }

    public void setRequestObj(Object requestObj) {
        this.requestObj = requestObj;
    }
}
