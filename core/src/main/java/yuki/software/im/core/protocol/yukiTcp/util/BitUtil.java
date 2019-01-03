package yuki.software.im.core.protocol.yukiTcp.util;

/**
 * @programN: yukiim
 * @description:
 * @author: YuKi
 * @create: 2019-01-02 15:38
 * @email: 1040929773@qq.com
 */
public class BitUtil {

    public static byte get(int start,int end,byte op){
        op = (byte)(op << start);
        op = (byte)(op >> end);
        return op;
    }

    public static void main(String[] args) {
        byte a = 127;
        String binaryString = Integer.toBinaryString(a);
        System.out.println(a);
        a = BitUtil.get(1,1,a);
        binaryString = Integer.toBinaryString(a);
        System.out.println(a);
    }
}
